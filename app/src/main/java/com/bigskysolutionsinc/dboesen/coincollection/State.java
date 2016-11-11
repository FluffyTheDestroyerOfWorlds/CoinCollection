package com.bigskysolutionsinc.dboesen.coincollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class State extends AppCompatActivity {
String txtState = "";
String txtDrawState = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            txtState = (String) bundle.get("txtState");
            System.out.println(txtState);
            TextView txtStateInput = (TextView) findViewById(R.id.txtStateName);
            txtStateInput.setText(txtState);
        }

        // Exception to the rule DC
        if (txtState.contentEquals("District of Columbia")) {
            txtState = "Washington DC";
        }
        txtState = txtState.toString().replace(" ", "_");
        txtDrawState = "@drawable/" + txtState + "_coin";
        txtDrawState = txtDrawState.toLowerCase();
        System.out.println(txtDrawState);
        ImageView imgChange = (ImageView) findViewById(R.id.imgStateCoin);

        int resourceID = getResources().getIdentifier(txtDrawState, "id", this.getPackageName());
        System.out.println(resourceID);

        imgChange.setImageResource(resourceID);
    }


}
