package by.overpass.calculatorfx.operations;

import by.overpass.calculatorfx.CalculationStrategy;

public class OperationDivide implements CalculationStrategy {

	@Override
	public Double doCalculation(Double number1, Double number2) {
		if (number2 == 0.0)
			return Double.POSITIVE_INFINITY;
		return number1 / number2;
	}
}
