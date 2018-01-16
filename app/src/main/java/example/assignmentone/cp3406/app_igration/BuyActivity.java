package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {

    int max = 999999;
    SeekBar seekBar;
    int value;
    TextView priceValue;
    private EditText locationText;
    Button okay;

    public void onBrowsePressed(View view) {
        Intent goToBrowse = new Intent(this, BrowseActivity.class);
        startActivity(goToBrowse);

    }

    public static ArrayList<String> locationList = new ArrayList<String>();
    //String locationList[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        okay = (Button) findViewById(R.id.okay);

        locationText = (EditText) findViewById(R.id.locationText);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(max);

        value = seekBar.getProgress();

        priceValue = (TextView) findViewById(R.id.price);

        final String price = Integer.toString(value);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = locationText.getText().toString().trim();
                if (location.length() !=0){
                    locationList.add(location);
                    locationText.setText("");
                }
            }
        });











       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               priceValue.setText(price);
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });



    }
}
