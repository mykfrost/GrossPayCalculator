package com.chinatown254.android.grosspaycalculator;

public class PayRate {

    private double payRate;
    private double hours;
    private double grossPay;

    public PayRate(double payRate, double hours) {
        this.payRate = payRate;
        this.hours = hours;
        this.grossPay = payRate * hours;
    }

    public double getPayRate() {
        return payRate;
    }
    public double getHours() {
        return hours;
    }
    public double getGrossPay() {
        return grossPay;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public void setHours(double hours) {
        this.hours = hours;

    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public Double calculateGrossPay() {
            return payRate * hours;

    }
}
