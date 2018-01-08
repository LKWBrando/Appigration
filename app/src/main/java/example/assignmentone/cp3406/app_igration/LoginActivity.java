package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonPressed(View view){
        Intent goToRegister = new Intent(this, RegisterActivity.class);
        switch(view.getId()){
            case R.id.registerButton:
                startActivity(goToRegister);
                break;
        }
    }
}
