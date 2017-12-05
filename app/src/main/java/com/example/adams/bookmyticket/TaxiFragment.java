package com.example.adams.bookmyticket;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.adams.bookmyticket.R.id.etsourcetaxi;

/**
 * Created by Adams on 06-11-2017.
 */

public class TaxiFragment extends Fragment implements View.OnClickListener {

    private EditText sourceBox, destinationBox;
    private RadioGroup classRadioGroup;
    private TextView timeText;

    private int hour,minute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.taxi_fragment_layout, container, false);

        classRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        classRadioGroup.clearCheck();

        sourceBox = (EditText) rootView.findViewById(etsourcetaxi);
        destinationBox = (EditText) rootView.findViewById(R.id.etdestinationtaxi);

        timeText = (TextView) rootView.findViewById(R.id.ettimetaxi);
        timeText.setOnClickListener(this);

        Button buttonnexttaxi = (Button) rootView.findViewById(R.id.buttonnexttaxi);
        buttonnexttaxi.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

    }

    @SuppressLint("SimpleDateFormat")
    private String getTime(int hr,int min) {
        Time tme = new Time(hr,min,0);//seconds by default set to zero
        Format formatter = new SimpleDateFormat("h:mm a");
        return formatter.format(tme);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ettimetaxi:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timeText.setText(getTime(selectedHour,selectedMinute));
                    }
                }, hour, minute, false);
                timePickerDialog.setTitle("Pickup Time");
                timePickerDialog.show();
                break;
            case R.id.buttonnexttaxi:

                String source = sourceBox.getText().toString().trim();
                String destination = destinationBox.getText().toString().trim();

                boolean isMicro = false;
                boolean isMini = false;
                boolean isPrime = false;
                boolean isLuxury = false;

                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbtaxi) {
                    isMicro = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbtaxi2) {
                    isMini = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbtaxi3) {
                    isPrime = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbtaxi4) {
                    isLuxury = true;
                }
                if (sourceBox.getText().length() == 0) {
                    sourceBox.setError("Please Enter the Source");
                }
                if (destinationBox.getText().length() == 0) {
                    destinationBox.setError("Please Enter the Destination");
                }
                break;
        }
    }

}
