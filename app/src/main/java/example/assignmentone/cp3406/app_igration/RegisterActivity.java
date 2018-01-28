package example.assignmentone.cp3406.app_igration;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLInput;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputUserName;
    private EditText inputUserPassword;
    private EditText inputConfirmPassword;
    private EditText inputUserPhoneNumber;
    private EditText inputUserEmailAddress;

    private String getInputName;
    private String getInputPass;
    private String getConfirmedPass;
    private String getInputPhoneNum;
    private String getInputEmail;

    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputUserName = findViewById(R.id.inputUserName);
        inputUserPassword = findViewById(R.id.inputUserPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        inputUserPhoneNumber = findViewById(R.id.inputUserPhoneNumber);
        inputUserEmailAddress = findViewById(R.id.inputUserEmailAddress);

        userDatabase = new UserDatabase(this);
    }

    public void addUser(String getInputName, String getInputPass,String getInputPhoneNum, String getInputEmail){
        SQLiteDatabase db = userDatabase.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put("username", getInputName);
        cValues.put("userpass", getInputPass);
        cValues.put("usernum", getInputPhoneNum);
        cValues.put("useremail", getInputEmail);
        db.insert("usernamelist", null, cValues);
    }

    public void registerButtonPressed(View view){
        getInputName = inputUserName.getText().toString();
        getInputPass = inputUserPassword.getText().toString();
        getConfirmedPass = inputConfirmPassword.getText().toString();
        getInputPhoneNum =  inputUserPhoneNumber.getText().toString();
        getInputEmail = inputUserEmailAddress.getText().toString();

        if(getInputPass.equals(getConfirmedPass)){
            addUser(getInputName, getInputPass, getInputPhoneNum, getInputEmail);
            Toast successMessage = Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT);
            successMessage.show();
            Intent goToMenu = new Intent(this, MenuActivity.class);
            startActivity(goToMenu);
        }
        else{
            Toast errorMessage = Toast.makeText(this, "Confirm your password again!", Toast.LENGTH_SHORT);
            errorMessage.show();
            inputUserPassword.setText("");
            inputConfirmPassword.setText("");
        }
    }
}