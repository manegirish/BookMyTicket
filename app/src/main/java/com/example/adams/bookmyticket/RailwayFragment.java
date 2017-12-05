package com.example.adams.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.adams.bookmyticket.R.id.etdestinationrailway;
import static com.example.adams.bookmyticket.R.id.etsourcerailway;

/**
 * Created by Adams on 06-11-2017.
 */

public class RailwayFragment extends Fragment implements View.OnClickListener {

    private EditText sourceBox, destinationBox;
    private RadioGroup classRadioGroup,typeRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.railway_fragment_layout, container, false);

        classRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        classRadioGroup.clearCheck();
        typeRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup1);
        typeRadioGroup.clearCheck();

        sourceBox = (EditText) rootView.findViewById(etsourcerailway);
        destinationBox = (EditText) rootView.findViewById(R.id.etdestinationrailway);

        Button buttonnextrailway = (Button) rootView.findViewById(R.id.buttonnextrailway);
        buttonnextrailway.setOnClickListener(this);

        return rootView;

    }

    private boolean isValid(String source, String destination) {
        if (source.length() == 0) {
            sourceBox.setError("Please Enter the Source");
            return false;
        }
        if (destination.length() == 0) {
            destinationBox.setError("Please Enter the Destination");
            return false;
        }
        if (classRadioGroup.getCheckedRadioButtonId() <= 0) {
            Toast.makeText(getActivity(), "Please Select Class", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (typeRadioGroup.getCheckedRadioButtonId() <= 0) {
            Toast.makeText(getActivity(), "Please Select Ticket Type", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonnextrailway:
                String source = sourceBox.getText().toString().trim();
                String destination = destinationBox.getText().toString().trim();

                boolean isFirstClass = false;
                boolean isSingleType = false;

                if (classRadioGroup.getCheckedRadioButtonId() == R.id.rbrailway) {
                    isFirstClass = true;
                }
                if (typeRadioGroup.getCheckedRadioButtonId() == R.id.rbrailway3) {
                    isSingleType = true;
                }
                if (isValid(source,destination)){
                    //Write your intent or whatever code you want to make for  going to another activity
                    Intent in = new Intent(getActivity(), PaymentActivity.class);
                    startActivity(in);
                }
                break;
        }
    }
}
