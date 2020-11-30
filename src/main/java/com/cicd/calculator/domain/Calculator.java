package com.cicd.calculator.domain;

import javax.validation.constraints.NotNull;

public class Calculator{
    @NotNull
    private int firstValue;
    @NotNull
    private int secondValue;

    public void setFirstValue(int input){
        firstValue = input;
    }    
    public int getFirstValue(){
        return firstValue;
    }

    public void setSecondValue(int input){
        secondValue = input;
    }
    public int getSecondValue(){
        return secondValue;
    }

    public int Add(int first, int second) {
        return first + second;
    }

    public int Subtract(int first, int second) {
        return first - second;
    }

    public int Multiply(int first, int second) {
        return first * second;
    }

    public double Divide(int dividend, int divisor) {
        if(divisor == 0)
            return 0;
        return dividend/divisor;
    }
}