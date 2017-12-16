package by.overpass.calculatorfx;

public class Context {
	private CalculationStrategy strategy;

	public Context(CalculationStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Double performCalculation(Double number1, Double number2) {
		return strategy.doCalculation(number1, number2);
	}
}
