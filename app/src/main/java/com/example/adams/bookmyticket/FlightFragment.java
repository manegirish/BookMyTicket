package com.example.adams.bookmyticket;

/**
 * Created by Adams on 06-11-2017.
 */

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class FlightFragment extends Fragment implements View.OnClickListener {

    private EditText sourceBox, destinationBox;
    private RadioGroup classRadioGroup;
    private TextView dateText;

    private String date = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flight_fragment_layout, container, false);

        classRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        classRadioGroup.clearCheck();

        sourceBox = (EditText) rootView.findViewById(R.id.etsourceflight);
        destinationBox = (EditText) rootView.findViewById(R.id.etdestinationflight);

        dateText = (TextView) rootView.findViewById(R.id.etdate);
        dateText.setOnClickListener(this);

        Button buttonnextflight = (Button) rootView.findViewById(R.id.buttonnextflight);
        buttonnextflight.setOnClickListener(this);

        return rootView;

    }

    private boolean isValid(String source, String destination, int radioButtonId) {
        if (source.length() == 0) {
            sourceBox.setError("Please Enter the Source");
            return false;
        }
        if (destination.length() == 0) {
            destinationBox.setError("Please Enter the Destination");
            return false;
        }
        if (radioButtonId <= 0) {
            Toast.makeText(getActivity(), "Please Select Class", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (date == null || date.length() <= 0 || date.equalsIgnoreCase("null")) {
            Toast.makeText(getActivity(), "Please Select Valid Date", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etdate:
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                int selectedMonth = monthOfYear + 1;
                                date = checkDigit(dayOfMonth) + "/" + checkDigit(selectedMonth) + "/" + year;
                                dateText.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.buttonnextflight:
                String source = sourceBox.getText().toString().trim();
                String destination = destinationBox.getText().toString().trim();

                boolean isFirstClass = false;
                boolean isEconomyClass = false;
                boolean isBusinessClass = false;
                boolean isPremiumEconomy = false;

                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbflight) {
                    isFirstClass = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbflight2) {
                    isEconomyClass = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbflight3) {
                    isFirstClass = true;
                }
                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbflight4) {
                    isPremiumEconomy = true;
                }

                if (isValid(source, destination, classRadioGroup.getCheckedRadioButtonId())) {
                    Intent in = new Intent(getActivity(), PaymentActivity.class);
                    startActivity(in);
                }
                break;
        }
    }
}

