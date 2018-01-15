package example.assignmentone.cp3406.app_igration;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class BuyActivity extends AppCompatActivity {

    int max = 999999;
    SeekBar seekBar;
    int value;
    TextView priceValue;

    public void onBrowsePressed(View view){
        Intent goToBrowse = new Intent(this, BrowseActivity.class);
        startActivity(goToBrowse);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);



        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(max);

        value = seekBar.getProgress();

        priceValue = (TextView) findViewById(R.id.price);

        final String price = Integer.toString(value);






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
