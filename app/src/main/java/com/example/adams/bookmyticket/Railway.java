package com.example.adams.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Adams on 06-11-2017.
 */

public class Railway extends Fragment {

    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.railway, container, false);

        radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    /*Toast.makeText(Flight.this, rb.getText(), Toast.LENGTH_SHORT).show();*/
                }

            }
        });

        Button buttonnextrailway = (Button) rootView.findViewById(R.id.buttonnextrailway);
        buttonnextrailway.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),PaymentActivity.class);
                startActivity(in);

            }
        });
        return rootView;

    }

   /* @Override
    public void onClick(View view) {
        Intent  in = new Intent(getActivity(),PaymentActivity.class);
        startActivity(in);

    }*/

}
