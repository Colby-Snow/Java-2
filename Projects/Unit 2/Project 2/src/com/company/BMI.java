package com.company;

/**
 * This class calculates BMI using the metric and imperial system.
 */
public class BMI {
    //instance variables
    private double weight, height;
    private int option;
    private double bmi;
    private String bmiRating;

    //default constructor

    /**
     * Initializes BMI class with inputted variables
     */
    public BMI(){
        weight = 70;
        height = 170;
        option = 1;
    }

    //parameterized constructor

    /**
     * Initializes BMI class with inputted variables
     * @param w Weight
     * @param h Height
     * @param o Option
     */
    public BMI(double w, double h, int o){
        setWeight(w);
        setHeight(h);
        setOption(o);
    }

    //getters

    /**
     * Gets the height
     * @return Height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the weight
     * @return Weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the Option
     * @return Option
     */
    public int getOption() {
        return option;
    }

    //setters

    /**
     * Sets the height. Must be greater than 0
     * @param height Height to be set
     */
    public void setHeight(double height) {
        if(height > 0){ this.height = height; }
        else{
            this.height = 170;
        }
    }

    /**
     * Sets the Option. Option must be either 1 or 2. 1 is Imperial system. 2 is Metric system
     * @param option Option to be set
     */
    public void setOption(int option) {
        this.option = option;
    }


    /**
     * Sets the weight. Must be greater than 0
     * @param weight Weight to be set
     */
    public void setWeight(double weight) {
        if(weight > 0){ this.weight = weight; }
        else{
            this.weight = 70;
        }
    }

    /**
     * Returns calculated BMI based on option
     * @return Calculated BMI
     */
    public double CalcBmi(){
        double calculatedBmi = 0;
        if(option == 1){
            calculatedBmi = CalcBmiImperial();
        }
        else if (option == 2){
            calculatedBmi = CalcBmiMetric();
        }

        return calculatedBmi;
    }

    //Calculates Imperial BMI
    private double CalcBmiImperial(){
        double heightSquared = Math.pow(height, 2);

        bmi = 703  * (weight/heightSquared);
        return bmi;
    }

    //Calculates Metric BMI
    private double CalcBmiMetric(){
        double heightSquared = Math.pow(height, 2);

        bmi = weight/heightSquared;
        return bmi;
    }

    /**
     * Returns BMI information.
     * @return BMI information.
     */
    public String toString(){
        CalcBmi();

        if(bmi < 18.5){
            bmiRating = "Underweight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9){
            bmiRating = "Normal weight";
        }
        else if (bmi > 24.9 && bmi <= 29.9){
            bmiRating = "Overweight";
        }
        else if (bmi > 29.9){
            bmiRating = "Obesity";
        }
        String msg;
        msg = String.format("BMI is %2.2f and is considered %-12s", bmi, bmiRating);

        return msg;
    }
}
