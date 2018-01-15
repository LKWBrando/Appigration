package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RentActivity extends AppCompatActivity {

    public void onBrowsePressed(View view){
        Intent goToBrowse = new Intent(this, BrowseActivity.class);
        startActivity(goToBrowse);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
    }
}
