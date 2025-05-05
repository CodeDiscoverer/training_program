package training.calculator.operations;

import training.calculator.Calculator;

public class Sum extends Calculator {

    private int result = 0;

    public Sum(int noOfElements, int[] elements) {
        super(noOfElements, elements);
    }

    @Override
    public int sum(){
        for(int value : elements){
            result += value;
        }
        return result;
    }
}
