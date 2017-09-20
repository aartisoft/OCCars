package edu.orangecoastcollege.cs273.phuynh101.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Purchase Activity (main activity)
 */
public class PurchaseActivity extends AppCompatActivity {

    //Connection to View
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearsRadioButton;
    private RadioButton mFourYearsRadioButton;
    private RadioButton mFiveYearsRadioButton;

    //Connection to Model
    private CarLoan mCarLoan = new CarLoan();

    /**
     * establishes connections from view to controller
     * @param savedInstanceState settings from the previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        mFourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        mFiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if(mThreeYearsRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if(mFourYearsRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);

    }

    /**
     * collect all the loan information
     * @param v the view that triggers the event
     */
    protected void reportSummary(View v)
    {
        collectCarLoanData();

        String report1 = getString(R.string.report_line1) + mCarLoan.monthlyPayment();
        String report2 = getString(R.string.report_line2) + mCarLoan.getPrice() +getString(R.string.report_line3) +
                mCarLoan.getDownPayment() + getString(R.string.report_line4);
        if(mFiveYearsRadioButton.isChecked())
            report2 += "3 years";
        else if(mFourYearsRadioButton.isChecked())
            report2 += "4 years";
        else
            report2 += "5 years";
        report2 += getString(R.string.report_line5) + mCarLoan.taxAmount()
                + getString(R.string.report_line6)  +mCarLoan.totalAmount() +getString(R.string.report_line7)
                + mCarLoan.borrowedAmount() +getString(R.string.report_line8) + mCarLoan.interestAmount();

        String report3 = getString(R.string.report_line9) + getString(R.string.report_line10) + getString(R.string.report_line11)
                +getString(R.string.report_line12);

        //Intents starts new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data to the Intent for Loan summary to receive
        launchLoanSummary.putExtra("loanReport1", report1);
        launchLoanSummary.putExtra("loanReport2", report2);
        launchLoanSummary.putExtra("loanReport3", report3);

        //start the second activity
        startActivity(launchLoanSummary);
    }
}
