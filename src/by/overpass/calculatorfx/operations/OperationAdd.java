package by.overpass.calculatorfx.operations;

import by.overpass.calculatorfx.CalculationStrategy;

public class OperationAdd implements CalculationStrategy {

	@Override
	public Double doCalculation(Double number1, Double number2) {
		return number1 + number2;
	}

}
