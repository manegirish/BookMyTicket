package com.example.adams.bookmyticket;

/**
 * Created by Adams on 06-11-2017.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import static android.R.attr.password;
import static com.example.adams.bookmyticket.R.id.buttonnextflight;
import static com.example.adams.bookmyticket.R.id.editTextEmail1;
import static com.example.adams.bookmyticket.R.id.editTextPassword1;
import static com.example.adams.bookmyticket.R.id.etdate;
import static com.example.adams.bookmyticket.R.id.etdestinationflight;
import static com.example.adams.bookmyticket.R.id.etdestinationrailway;
import static com.example.adams.bookmyticket.R.id.etsourceflight;
import static com.example.adams.bookmyticket.R.id.etsourcerailway;

public class Flight extends  Fragment implements View.OnClickListener {
    private EditText sourceBox, destinationBox, dateBox;
    private RadioGroup classRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flight, container, false);

        classRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        classRadioGroup.clearCheck();

        sourceBox = (EditText) rootView.findViewById(etsourceflight);
        destinationBox = (EditText) rootView.findViewById(R.id.etdestinationflight);
        dateBox = (EditText) rootView.findViewById(R.id.etdate);

        Button buttonnextflight = (Button) rootView.findViewById(R.id.buttonnextflight);
        buttonnextflight.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonnextflight:
                String source = sourceBox.getText().toString().trim();
                String destination = destinationBox.getText().toString().trim();
                String date = dateBox.getText().toString().trim();

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

                if (sourceBox.getText().length() == 0)
                {
                    sourceBox.setError("Please Enter the Source");
                }
                if (destinationBox.getText().length() == 0)
                {
                    destinationBox.setError("Please Enter the Destination");
                }
                if (dateBox.getText().length() == 0)
                {
                    dateBox.setError("Please Enter the Source");
                }


                if (etsourceflight == 1 && etdestinationflight == 1 && etdate == 1) {
                    Intent in = new Intent(getActivity(), PaymentActivity.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(getActivity(),"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

