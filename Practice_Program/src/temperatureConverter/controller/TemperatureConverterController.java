package temperatureConverter.controller;

public class TemperatureConverterController implements TemperatureConverter{

	@Override
	public void convertFahrenheit(double fahrenheit) {
		
		try {
			if(fahrenheit > 0) {
				System.out.printf("%.2f Fahrenheit in Celsius is %.2f\n", fahrenheit,((fahrenheit - 32) / 1.8));
			}else {
				throw new Exception("Fahrenheit can't be lessthan or equal zero");
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void convertCelsius(double celsius) {
		try {
			if(celsius > 0) {
				System.out.printf("%.2f Celsius in Fahrenheit is %.2f\n", celsius, ((celsius * 1.8) + 32));
			}else {
				throw new Exception("Celsius can't be lessthan or equal zero");
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
