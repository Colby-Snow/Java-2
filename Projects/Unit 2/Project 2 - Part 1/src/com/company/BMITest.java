package com.company;

public class BMITest {

    public static void main(String[] args) {
	    BMI test = new BMI();
        //tests getters and displays defaults.
	    printStats(test);

	    //test setters.
        test.setHeight(30);
        test.setWeight(240);
        test.setOption(2);
        printStats(test);

        //tests setters defaults
        test.setHeight(0);
        test.setWeight(0);
        printStats(test);

        //tests calculated BMIs
        System.out.println(test.CalcBmi());

        //tests BMI Information
        System.out.println(test.toString());

        //tests parameterized constructors
        BMI test2 = new BMI(120, 70, 1);
        printStats(test2);
        System.out.println(test2.toString());
        System.out.println(test2.CalcBmi());
    }
    public static void printStats(BMI test){
        System.out.println(test.getHeight());
        System.out.println(test.getOption());
        System.out.println(test.getWeight());
    }
}
