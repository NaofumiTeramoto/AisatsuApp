package jp.techacademy.naofumi.teramoto.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int ITimes;
    int iTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText("ohayo");

    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        if (v.getId() == R.id.button1) {
            if(ITimes<2 || ITimes> 18) {
                textView.setText("こんばんは");
            } else if(ITimes<10){
                textView.setText("おはよう");
            } else{
                textView.setText("こんにちは");
            }

        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        ITimes=hourOfDay;  //hourOfDay をonTimeSetの外で参照するには？
                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);

        timePickerDialog.show();
    }

}