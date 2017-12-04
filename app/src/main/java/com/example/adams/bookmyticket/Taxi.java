package com.example.adams.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.adams.bookmyticket.R.id.etdestinationtaxi;
import static com.example.adams.bookmyticket.R.id.etsourcetaxi;

/**
 * Created by Adams on 06-11-2017.
 */

public class Taxi extends Fragment implements View.OnClickListener {

    private EditText sourceBox, destinationBox;
    private RadioGroup classRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.taxi, container, false);

        classRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        classRadioGroup.clearCheck();

        sourceBox = (EditText) rootView.findViewById(etsourcetaxi);
        destinationBox = (EditText) rootView.findViewById(R.id.etdestinationtaxi);

        Button buttonnexttaxi = (Button) rootView.findViewById(R.id.buttonnexttaxi);
        buttonnexttaxi.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
                if (sourceBox.getText().length() == 0)
                {
                    sourceBox.setError("Please Enter the Source");
                }
                if (destinationBox.getText().length() == 0)
                {
                    destinationBox.setError("Please Enter the Destination");
                }
                break;
        }
    }

}
