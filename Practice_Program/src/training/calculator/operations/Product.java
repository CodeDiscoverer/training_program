package training.calculator.operations;

import training.calculator.Calculator;

public class Product extends Calculator {

    private int result = 1;

    public Product(int noOfElements, int[] elements) {
        super(noOfElements, elements);
    }

    @Override
    public int product(){
        for(int value : elements){
            result *= value;
        }
        return result;
    }
}
