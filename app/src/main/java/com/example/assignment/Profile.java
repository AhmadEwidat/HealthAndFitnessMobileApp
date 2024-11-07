package com.example.assignment;

//class to make user information
public class Profile {

    private int age;
    private double heightInmeter;
    private double weightInKg;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeightInmeter() {
        return heightInmeter;
    }

    public void setHeightInmeter(double heightInmeter) {
        this.heightInmeter = heightInmeter;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Profile(int age, double heightInmeter, double weightInKg) {

        this.age = age;
        this.heightInmeter = heightInmeter;
        this.weightInKg = weightInKg;
    }
}
