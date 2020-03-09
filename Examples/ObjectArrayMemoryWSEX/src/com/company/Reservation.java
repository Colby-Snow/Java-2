package com.company;

public class Reservation {
    private int resNumber;
    private String resCustName;
    private boolean resFreqFlyer;

    //parameterized constructor
    Reservation(int resNum, String resName, boolean freqFlyer){
        setResNumber(resNum);
        setResCustName(resName);
        setResFreqFlyer(freqFlyer);
    }

    public void setResFreqFlyer(boolean freqFlyer) {
        resFreqFlyer = freqFlyer;
    }

    public void setResCustName(String resName) {
        resCustName = resName;
    }

    public void setResNumber(int resNum) {
        resNumber = resNum;
    }

    public int getResNumber(){
        return resNumber;
    }
    public String getResCustName(){
        return resCustName;
    }
    public boolean getResFreqFlyer(){
        return resFreqFlyer;
    }
}
