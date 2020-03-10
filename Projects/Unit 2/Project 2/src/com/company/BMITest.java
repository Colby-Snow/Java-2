package com.company;

public class BMITest {

    public static void main(String[] args) {
	    BMI test = new BMI();

	    printStats(test);
        test.setHeight(30);
        test.setWeight(240);
        test.setOption(2);
        printStats(test);
        test.setHeight(0);
        test.setWeight(0);
        printStats(test);
        System.out.println(test.CalcBmi());
        System.out.println(test.toString());
    }
    public static void printStats(BMI test){
        System.out.println(test.getHeight());
        System.out.println(test.getOption());
        System.out.println(test.getWeight());
    }
}
