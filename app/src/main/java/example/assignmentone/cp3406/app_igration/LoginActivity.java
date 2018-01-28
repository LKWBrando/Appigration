package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText userpassInput;
    SharedPreferences preferences;
    UserDatabase userNameList;
    String usernameString;
    String userpassString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        userNameList = new UserDatabase(this);
        usernameInput = findViewById(R.id.usernameInput);
        userpassInput = findViewById(R.id.userpassInput);
    }

    public void onButtonPressed(View view){
        Intent goToRegister = new Intent(this, RegisterActivity.class);
        usernameString = usernameInput.getText().toString();
        userpassString = userpassInput.getText().toString();

        switch(view.getId()){
            case R.id.registerButton:
                startActivity(goToRegister);
                break;
            case R.id.loginButton:
                Boolean loginPassed = false;
                Cursor cursor = userNameList.getReadableDatabase().rawQuery("SELECT * FROM usernamelist", null);
                while(cursor.moveToNext()){
                    if(usernameString.equals(cursor.getString(1)) && userpassString.equals(cursor.getString(2))){
                        cursor.close();
                        preferences.edit().putString("loggedUser", null).apply();
                        loginPassed = true;
                    }
                }
                cursor.close();

                if (!loginPassed){
                    Toast errorMsg = Toast.makeText(this, "UserName or Password is incorrect!", Toast.LENGTH_SHORT);
                    errorMsg.show();
                }else{
                    Intent goToLogin = new Intent(this, MenuActivity.class);
                    startActivity(goToLogin);
                }
        }
    }
}
