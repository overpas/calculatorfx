package by.overpass.calculatorfx.operations;

import by.overpass.calculatorfx.CalculationStrategy;

public class OperationRoot implements CalculationStrategy {

	@Override
	public Double doCalculation(Double number1, Double number2) {
		return Math.pow(number1, 1/number2);
	}

}
