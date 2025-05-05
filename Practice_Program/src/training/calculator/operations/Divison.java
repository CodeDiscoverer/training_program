package training.calculator.operations;

import training.calculator.Calculator;

public class Divison extends Calculator{
	
	private int result = 0;

	public Divison(int noOfElements, int[] elements) {
        super(noOfElements, elements);
    }

    @Override
    public int divison(){
    	if(elements[0] < elements[1]) {
    		System.err.println("Divisor is Lesser than the Divisible Value");
    	}
    	else {
    		try {
    			result = elements[0]/elements[1];
    		} catch (ArithmeticException e){
                throw new ArithmeticException("Divisible by Zero is not possible");
            }
    	}
		return result;
    }
    
}