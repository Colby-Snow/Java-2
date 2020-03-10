package com.company;

public class BMI {
    private double weight, height;
    private int option;
    private double bmi;
    private String bmiRating;

    public BMI(){
        weight = 70;
        height = 170;
        option = 1;
    }

    public BMI(double w, double h, int o){
        weight = w;
        height = h;
        option = o;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getOption() {
        return option;
    }

    public void setHeight(double height) {
        if(height > 0){ this.height = height; }
        else{
            this.height = 170;
        }
    }

    public void setOption(int option) {
        this.option = option;
    }

    public void setWeight(double weight) {
        if(weight > 0){ this.weight = weight; }
        else{
            this.weight = 70;
        }
    }

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

    private double CalcBmiImperial(){
        double heightSquared = Math.pow(height, 2);

        bmi = 703  * (weight/heightSquared);
        return bmi;
    }

    private double CalcBmiMetric(){
        double heightSquared = Math.pow(height, 2);

        bmi = weight/heightSquared;
        return bmi;
    }

    public String toString(){
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
