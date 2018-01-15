package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButtonPressed(View view){
        Intent goToLogin = new Intent(this, LoginActivity.class);
        Intent goToRegister = new Intent(this, RegisterActivity.class);
        Intent goToBuy = new Intent(this, BuyActivity.class);
        Intent goToRent = new Intent(this, RentActivity.class);
        Intent goToBrowse = new Intent(this, BrowseActivity.class);
        Intent goToSearch = new Intent(this, SearchActivity.class);
        switch(view.getId()){
            case R.id.loginButton:
                startActivity(goToLogin);
                break;
            case R.id.registerButton:
                startActivity(goToRegister);
                break;
            case R.id.buyMenu:
                startActivity(goToBuy);
                break;
            case R.id.rentMenu:
                startActivity(goToRent);
                break;
            case R.id.searchMenu:
                startActivity(goToSearch);
                break;
        }
    }
}
