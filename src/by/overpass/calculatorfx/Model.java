package by.overpass.calculatorfx;

import by.overpass.calculatorfx.operations.OperationAdd;
import by.overpass.calculatorfx.operations.OperationDivide;
import by.overpass.calculatorfx.operations.OperationMultiply;
import by.overpass.calculatorfx.operations.OperationPower;
import by.overpass.calculatorfx.operations.OperationRoot;
import by.overpass.calculatorfx.operations.OperationSubtract;

public class Model {
	public Double calculate(Double number1, Double number2, String operator) {
		switch (operator) {
			case "+":
				return new Context(new OperationAdd())
						.performCalculation(number1, number2);
			case "-":
				return new Context(new OperationSubtract())
						.performCalculation(number1, number2);
			case "*":
				return new Context(new OperationMultiply())
						.performCalculation(number1, number2);
			case "/":
				return new Context(new OperationDivide())
						.performCalculation(number1, number2);
			case "√":
				return new Context(new OperationRoot())
						.performCalculation(number1, number2);
			case "^":
				return new Context(new OperationPower())
						.performCalculation(number1, number2);
		}

		System.out.println("Unknown operator - " + operator);
		return Double.NEGATIVE_INFINITY;
	}
}
