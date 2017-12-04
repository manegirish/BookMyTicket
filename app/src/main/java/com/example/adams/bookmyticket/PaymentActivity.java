package com.example.adams.bookmyticket;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle("Payment Details");

        final TextView tvcardno;
        TextView tvmonth;
        TextView tvyear;
        TextView tvcvv;
        CheckBox cbsave;
        Button bproceed;
        final EditText etcardno;
        final EditText etmonth;
        final EditText etyear;
        final EditText etcvv;
        ProgressDialog progressDialog;


        //initializing views
        etcardno = (EditText) findViewById(R.id.etcardno);
        etmonth = (EditText) findViewById(R.id.etmonth);
        etyear = (EditText) findViewById(R.id.etyear);
        etcvv = (EditText) findViewById(R.id.etcvv);
        tvcardno = (TextView) findViewById(R.id.tvcardno);
        tvmonth = (TextView) findViewById(R.id.tvmonth);
        tvyear = (TextView) findViewById(R.id.tvyear);
        tvcvv = (TextView) findViewById(R.id.tvcvv);
        bproceed = (Button) findViewById(R.id.bproceed);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        //bproceed.setOnClickListener((View.OnClickListener) Payment.this);

        bproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etcardno.getText().length() == 0 || etcvv.getText().length()  == 0 || etyear.getText().length() == 0 || etmonth.getText().length() == 0)

                {
                    Toast mytoast = Toast.makeText(getApplicationContext(), "Field left empty!!", Toast.LENGTH_SHORT);
                    mytoast.show();
                }

                else

                {

                    Toast pass = Toast.makeText(getApplicationContext(), "Payment Successful!!", Toast.LENGTH_SHORT);
                    pass.show();

                }
            }

        });

        String cardno = etcardno.getText().toString().trim();
        String month = etmonth.getText().toString().trim();
        String year  = etyear.getText().toString().trim();
        String cvv  = etcvv.getText().toString().trim();

        //checking if fields are empty
        if(TextUtils.isEmpty(cardno)){
            Toast.makeText(this,"Please enter Card No.",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(month)){
            Toast.makeText(this,"Please enter Month",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(year)){
            Toast.makeText(this,"Please enter Year",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(cvv)){
            Toast.makeText(this,"Please enter CVV",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Processing Your Payment Please Wait...");
        progressDialog.show();


        if (etcardno.getText().length() == 1 && etmonth.getText().length()== 1 && etyear.getText().length()==1 && etcvv.getText().length()==1 )
        {

            Toast mytoast= Toast.makeText(getApplicationContext(), "Your Ticket has been sent on your Email ID!!", Toast.LENGTH_SHORT);
            mytoast.show();

        }
    }
}
