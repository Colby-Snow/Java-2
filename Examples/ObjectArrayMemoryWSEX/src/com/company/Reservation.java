/**
 * This class is used to instantiate Reservation objects.
 */

package com.company;

public class Reservation {

    //instance variables
    private int resNumber;
    private String resCustName;
    private boolean resFreqFlyer;

    //default constructor

    /**
     * Instantiates a Reservation object with default values
     */
    Reservation(){
        resNumber = 1000;
        resCustName = "Johnson";
        resFreqFlyer = true;
    }

    //parameterized constructor

    /**
     * Instantiates a Reservation object with parameter values:
     * @param resNum Reservation number
     * @param resName Customer name
     * @param freqFlyer Frequent flyer status.
     */
    Reservation(int resNum, String resName, boolean freqFlyer){
        setResNumber(resNum);
        setResCustName(resName);
        setResFreqFlyer(freqFlyer);
    }

    //setters

    /**
     * Sets the frequent flyer status.
     * @param freqFlyer Frequent flyer status to be set
     */
    public void setResFreqFlyer(boolean freqFlyer) {
        resFreqFlyer = freqFlyer;
    }

    /**
     * Sets the customer name. Must not be blank
     * @param resName Customer Name to be set
     */
    public void setResCustName(String resName) {
        if(!resName.trim().isEmpty()){
            resCustName = resName;
        }
        else{
            resCustName = "Johnson";
        }
    }

    /**
     * Sets the reservation number. Number must be between 1000 and 9999.
     * @param resNum Reservation number to be set.
     */
    public void setResNumber(int resNum) {
        if(resNum >= 1000 && resNum <= 9999){
            resNumber = resNum;
        }
        else{
            resNumber = 1000;
        }
    }

    //getters

    /**
     * Get the reservation number.
     * @return Reservation number
     */
    public int getResNumber(){
        return resNumber;
    }

    /**
     * Get the customer name
     * @return Customer name
     */
    public String getResCustName(){
        return resCustName;
    }

    /**
     * Gets the frequent flyer status
     * @return True - Customer is a frequent flyer
     */
    public boolean getResFreqFlyer(){
        return resFreqFlyer;
    }


    @Override
    public String toString(){
        String resMsg = "";


        resMsg = String.format("Reservation number: %4d" +
                "\nCustomer name: %-22s" +
                "\nFrequent flyer: %4b", resNumber, resCustName, resFreqFlyer);
        return resMsg;
    }
}
