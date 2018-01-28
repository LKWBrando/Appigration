package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView currentUser;
    Button loginButton;
    Button registerButton;
    Button logoutButton;
    SharedPreferences preferences;
    String currentUserString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        currentUser = findViewById(R.id.currentUser);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        logoutButton = findViewById(R.id.logoutButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUserString = preferences.getString("loggedUser", null);
        if(currentUserString == null){
            logoutButton.setVisibility(View.INVISIBLE);
            currentUser.setVisibility(View.INVISIBLE);
            registerButton.setVisibility(View.VISIBLE);
            loginButton.setVisibility(View.VISIBLE);
        }else{
            currentUser.setText("Welcome, " + currentUserString + " !");
            logoutButton.setVisibility(View.VISIBLE);
            currentUser.setVisibility(View.VISIBLE);
            registerButton.setVisibility(View.INVISIBLE);
            loginButton.setVisibility(View.INVISIBLE);
        }
    }

    public void onButtonPressed(View view){
        switch(view.getId()){
            case R.id.loginButton:
                Intent goToLogin = new Intent(this, LoginActivity.class);
                startActivity(goToLogin);
                break;
            case R.id.registerButton:
                Intent goToRegister = new Intent(this, RegisterActivity.class);
                startActivity(goToRegister);
                break;
            case R.id.buyMenu:
                Intent goToBuy = new Intent(this, BuyActivity.class);
                startActivity(goToBuy);
                break;
            case R.id.rentMenu:
                Intent goToRent = new Intent(this, RentActivity.class);
                startActivity(goToRent);
                break;
            case R.id.searchMenu:
                Intent goToSearch = new Intent(this, SearchActivity.class);
                startActivity(goToSearch);
                break;
            case R.id.logoutButton:
                preferences.edit().putString("loggedUser", null).apply();
                Intent refreshMenu = new Intent(this, MenuActivity.class);
                startActivity(refreshMenu);
        }
    }
}
