package by.overpass.calculatorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

	@FXML
	private Text output;
	@FXML
	private Text currentOperation;

	private Double number1 = 0d;
	private Double number2 = 0d;
	private String operator = "";
	private boolean start = true;
	private boolean firstTimeInARow = true;
	private Model model = new Model();

	@FXML
	private void processNumpad(ActionEvent event) {
		if (start) {
			output.setText("");
			start = false;
		}

		String value = ((Button) event.getSource()).getText();
		if (".".equals(value) && output.getText().contains(".")) return;
		output.setText(output.getText() + value);
	}

	@FXML
	private void processOperator(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		currentOperation.setText("");
		
		if ("=".equals(value)) {
			processEqualsOperator();
		} else if ("CL".equals(value)) {
			processCLOperator();
		} else if ("C".equals(value) && !output.getText().isEmpty()) {
			processCOperator();
		} else if ("±".equals(value)) {
			processPlusMinusOperator();
		} else {
			processArithmeticOperator(value);
		}
	}
	
	private void setOperator(String operator) {
		this.operator = operator;
		this.currentOperation.setText(operator);
	}
	
	private void processEqualsOperator() {
		if (firstTimeInARow) {
			number2 = Double.parseDouble(output.getText());
			firstTimeInARow = false;
		}
		
		Double result = model.calculate(number1, number2, operator);
		output.setText(String.valueOf(result));
		number1 = result;
		start = true;
	}
	
	private void processCLOperator() {
		output.setText("");
		setOperator("");
		number1 = 0d;
		firstTimeInARow = true;
	}
	
	private void processCOperator() {
		String out = output.getText();
		out = out.substring(0, out.length() - 1);
		output.setText(out);
		firstTimeInARow = true;
	}
	
	private void processArithmeticOperator(String value) {
		setOperator(value);
		if (!output.getText().trim().equals("")) 
			number1 = Double.parseDouble(output.getText());
		output.setText("");
		firstTimeInARow = true;
	}
	
	private void processPlusMinusOperator() {
		if (!output.getText().trim().equals("")) {
			if (output.getText().contains("-"))
				output.setText(output.getText().replaceAll("-", ""));
			else 
				output.setText("-".concat(output.getText()));
		}
	}
}
