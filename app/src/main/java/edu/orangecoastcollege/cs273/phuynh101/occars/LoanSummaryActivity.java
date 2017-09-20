package edu.orangecoastcollege.cs273.phuynh101.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Loan summary activity
 */
public class LoanSummaryActivity extends AppCompatActivity {

    private TextView mReport1TextView;
    private TextView mReport2TextView;
    private TextView mReport3TextView;

    /**
     * establishes connections from view to controller
     * @param savedInstanceState settings from the previous
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        mReport1TextView = (TextView) findViewById(R.id.report1TextView) ;
        mReport2TextView = (TextView) findViewById(R.id.report2TextView) ;
        mReport3TextView = (TextView) findViewById(R.id.report3TextView) ;

        //Receive the Intent
        //Populate the textview with data
        Intent intentFromPurchase = getIntent();
        String report1 = intentFromPurchase.getExtras().getString("loanReport1");
        String report2 = intentFromPurchase.getExtras().getString("loanReport2");
        String report3 = intentFromPurchase.getExtras().getString("loanReport3");

        //fill your textview with data from the report
        mReport1TextView.setText(report1);
        mReport2TextView.setText(report2);
        mReport3TextView.setText(report3);
    }

    /**
     * go back to main activity
     * @param v the view that triggers the event
     */
    protected void gotoPurchaseActivity(View v)
    {
        finish();
    }
}
