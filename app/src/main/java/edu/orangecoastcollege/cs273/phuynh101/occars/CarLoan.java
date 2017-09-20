package edu.orangecoastcollege.cs273.phuynh101.occars;

/**
 * Created by phuynh101 on 9/14/2017.
 */

public class CarLoan {

    private static final double SALES_TAX = 0.08;
    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    /**
     * default constructor
     */
    public CarLoan() {
    }

    /**
     * get the price of the car
     * @return the price of the car
     */
    public double getPrice() {
        return mPrice;
    }

    /**
     * set the price of the car
     * @param price the price of the car
     */
    public void setPrice(double price) {
        mPrice = price;
    }

    /**
     * get the down payment
     * @return the down payment
     */
    public double getDownPayment() {
        return mDownPayment;
    }

    /**
     * set the down payment
     * @param downPayment the down payment
     */
    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    /**
     * get the term
     * @return the term
     */
    public int getTerm() {
        return mTerm;
    }

    /**
     * set the term
     * @param term the term
     */
    public void setTerm(int term) {
        mTerm = term;
    }

    /**
     * calculate the tax amount
     * @return the tax amount
     */
    public double taxAmount()
    {
        return mPrice*SALES_TAX;
    }

    /**
     * calculate the total amount
     * @return the total amount
     */
    public double totalAmount()
    {
        return mPrice + taxAmount();
    }

    /**
     * calculate the borrowed amount
     * @return the borrowed amount
     */
    public double borrowedAmount()
    {
        return mPrice - mDownPayment;
    }

    /**
     * calculate the interest amount
     * @return the interest amount
     */
    public double interestAmount()
    {
        double interestRate;

        switch (mTerm)
        {
            case 3:
                interestRate = 0.0462;
                break;
            case 4:
                interestRate = 0.0419;
                break;
            case 5:
                interestRate = 0.0416;
                break;
            default:
                interestRate = 0.10;
                break;
        }

        return borrowedAmount()*interestRate;
    }

    /**
     * calculate the monthly payment
     * @return the monthly payment
     */
    public double monthlyPayment()
    {
        return (borrowedAmount() + interestAmount()) / (mTerm*12);
    }
}
