package training.calculator.operations;

import training.calculator.Calculator;

public class Difference extends Calculator{
	
	int result = 0;

	public Difference(int noOfElements, int[] elements) {
        super(noOfElements, elements);
    }

    @Override
    public int difference(){
        for(int value : elements){
            result -= value;
        }
        return result;
    }
    
}
