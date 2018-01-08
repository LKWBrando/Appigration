package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonPressed(View view){
        Intent goToMenu = new Intent(this, MenuActivity.class);
        Intent goToLogin = new Intent(this, LoginActivity.class);
        Intent goToRegister = new Intent(this, RegisterActivity.class);
        switch(view.getId()){
            case R.id.browseButton:
                startActivity(goToMenu);
                break;
            case R.id.loginButton:
                startActivity(goToLogin);
                break;
            case R.id.registerButton:
                startActivity(goToRegister);
                break;
        }
    }
}
