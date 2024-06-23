package Calculator;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * The Calculator class implements a simple calculator GUI application with
 * basic and scientific functionalities such as addition, subtraction,
 * multiplication, division, square root, trigonometric functions, logarithm,
 * and exponentiation.
 */

public class Calculator {

	private JFrame frame;
	private JTextField textField;

	private JFrame frame; 			// Main frame for the calculator
	private JTextField textField; 	// Text field to display input and results
	private double first; 			// First operand for the operations
	private double second; 			// Second operand for the operations
	private double result; 			// Result of the operations
	private String operation; 		// Current operation to be performed
	private String answer; 			// String format of the result for displaying

	private final ButtonGroup buttonGroup = new ButtonGroup();	// Button group for storing multiple buttons

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator window = new ScientificCalculator(); 	// Create a new instance of ScientificCalculator class
					window.frame.setVisible(true); 								// Make the frame visible
				} catch (Exception e) {											// Catch an exception if it occurs
					e.printStackTrace(); 										// Print the exception
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();	// Initialize the contents of the frame
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Set up the main frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 800); 					// Position and size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Set the default operation on closing
		frame.getContentPane().setLayout(null); 				// No layout manager for custom positioning

		// Create and set up the text field
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18)); 	// Font style and size
		textField.setBounds(10, 10, 410, 50); 					// Position and size of the text field
		frame.getContentPane().add(textField); 					// Add text field to the frame
		textField.setColumns(10); 								// Set number of columns

		// Set up the Square Root button
		JButton btnBack = new JButton("\u221A");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform the operation based on input from the text field
				double a=Math.sqrt(Double.parseDouble(textField.getText()));
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				textField.setText(textField.getText()+a);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));	// Font style and size
		btnBack.setBounds(25, 221, 84, 80);						// Position and size of the button
		frame.getContentPane().add(btnBack);					// Add button to the frame

		// Set up the Logarithm button
		JButton btn_9 = new JButton("Log");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform the operation based on input from the text field
				double a=Math.log(Double.parseDouble(textField.getText()));
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				textField.setText(textField.getText()+a);
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 18));	// Font style and size
		btn_9.setBounds(100, 299, 84, 80);					// Position and size of the button
		frame.getContentPane().add(btn_9);					// Add button to the frame

		// Set up the Percentage button
		JButton btn_percentage = new JButton("%");
		btn_percentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform the operation based on input from the text field
				   first=Double.parseDouble(textField.getText());
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				operation="%";
			   }
		});
		btn_percentage.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btn_percentage.setBounds(100, 378, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btn_percentage);                  // Add button to the frame

		// Set up the Square button
		JButton btn_0 = new JButton("x^2");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the text from the field and perform the square operation
				double a=(Double.parseDouble(textField.getText()));
				a=a*a;
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				textField.setText(textField.getText()+a);

			}}
		);
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 18));		// Font style and size
		btn_0.setBounds(23, 533, 84, 80);						// Position and size of the button
		frame.getContentPane().add(btn_0);						// Add button to the frame

		// Set up the Exponential button
		JButton btnClear = new JButton("e^x");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform the operation based on input from the text field
				double a=Math.exp(Double.parseDouble(textField.getText()));
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				textField.setText(textField.getText()+a);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));	// Font style and size
		btnClear.setBounds(100, 221, 84, 80);					// Position and size of the button
		frame.getContentPane().add(btnClear);					// Add button to the frame


		// Set up the Backspace button
		JButton btn__back = new JButton("\uF0E7"); // Unicode character for backspace icon
		btn__back.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				String backSpace = null;

				// Check if the text field has content
				if (textField.getText().length() > 0) {
					// Create a StringBuilder from the text field content
					StringBuilder str = new StringBuilder(textField.getText());
					// Delete the last character from the StringBuilder
					str.deleteCharAt(textField.getText().length() - 1);
					// Convert StringBuilder back to String
					backSpace = str.toString();
					// Update the text field with the modified text
					textField.setText(backSpace);
				}
			}
		});
		btn__back.setFont(new Font("Wingdings", Font.PLAIN, 18)); // Set font style and size
		btn__back.setBounds(259, 378, 84, 80);                    // Set button position and size
		frame.getContentPane().add(btn__back);                    // Add button to the frame

		// Set up the Clear button
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			// Clears the text field when clicked
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnClear.setBounds(181, 378, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnClear);                 // Add button to the frame

		// Set up the Sin button
		JButton btnSin = new JButton("Sin");
		btnSin.addActionListener(new ActionListener() {
		// Computes sine of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.sin(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnSin.setBounds(181, 221, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnSin);                 // Add button to the frame

		// Set up the Cosh button
		JButton btnCosh = new JButton("Cosh");
		btnCosh.addActionListener(new ActionListener() {
			// Computes hyperbolic cosine of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.cosh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnCosh.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnCosh.setBounds(259, 299, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnCosh);                 // Add button to the frame

		// Set up the Inverse button
		JButton btnInverse = new JButton("1/X");
		btnInverse.addActionListener(new ActionListener() {
		// Computes the inverse of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = 1 / (Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnInverse.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnInverse.setBounds(25, 299, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnInverse);                 // Add button to the frame

		// Set up the Cos button
		JButton btnCos = new JButton("Cos");
		btnCos.addActionListener(new ActionListener() {
			// Computes cosine of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.cos(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnCos.setBounds(259, 221, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnCos);                 // Add button to the frame

		// Set up the Sinh button
		JButton btnSinh = new JButton("Sinh");
		btnSinh.addActionListener(new ActionListener() {
			// Computes hyperbolic sine of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.sinh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnSinh.setBounds(181, 299, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnSinh);                 // Add button to the frame

		// Set up the Power button
		JButton btnPower = new JButton("x^y");
		btnPower.addActionListener(new ActionListener() {
		// Prepares for power operation with current text field value as base
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getSelectedText());
				textField.setText("");
				operation = "x^y";
			}
		});
		btnPower.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnPower.setBounds(25, 378, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnPower);                 // Add button to the frame

		// Set up the Factorial button
		JButton btnFactorial = new JButton("n!");
		btnFactorial.addActionListener(new ActionListener() {
			// Computes factorial of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(textField.getText());
				double fact = 1;
				while (a != 0) {
					fact = fact * a;
					a--;
				}
				textField.setText("");
				textField.setText(textField.getText() + fact);
			}
		});
		btnFactorial.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnFactorial.setBounds(23, 611, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnFactorial);                 // Add button to the frame

		// Set up the Plus/Minus button
		JButton btnPlusMinus = new JButton("+/-");
		btnPlusMinus.addActionListener(new ActionListener() {
		// Toggles the sign of the current text field value
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(String.valueOf(textField.getText()));
				a = a * (-1);
				textField.setText(String.valueOf(a));
			}
		});
		btnPlusMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnPlusMinus.setBounds(25, 690, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnPlusMinus);                 // Add button to the frame

		// Set up the Dot button
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnDot.setBounds(259, 690, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnDot);                 // Add button to the frame

		// Set up the Tan button
		JButton btnTan = new JButton("Tan");
b		tnTan.addActionListener(new ActionListener() {
		// Computes tangent of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.tan(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnTan.setBounds(342, 221, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnTan);                 // Add button to the frame

		// Set up the Tanh button
		JButton btnTanh = new JButton("Tanh");
		btnTanh.addActionListener(new ActionListener() {
		// Computes hyperbolic tangent of the current text field value and displays the result
			public void actionPerformed(ActionEvent e) {
				double a = Math.tanh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText() + a);
			}
		});
		btnTanh.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnTanh.setBounds(342, 299, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnTanh);                 // Add button to the frame

		// Set up the Subtract button
		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
		// Stores the first operand and prepares for subtraction operation on text field value
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText("");
				operation = "-";
			}
		});
		btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnSubtract.setBounds(342, 378, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnSubtract);                 // Add button to the frame

		// Set up the Addition button
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
		// Stores the first operand and prepares for addition operation on text field value
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText("");
				operation = "+";
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnAdd.setBounds(342, 455, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnAdd);                 // Add button to the frame

		// Set up the Multiplication button
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
		// Stores the first operand and prepares for multiplication operation on text field value
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText("");
				operation = "*";
			}
		});
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnMultiply.setBounds(342, 533, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnMultiply);                 // Add button to the frame

		// Set up the Division button
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
		// Stores the first operand and prepares for division operation on text field value
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(textField.getText());
				textField.setText("");
				operation = "/";
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnDivide.setBounds(342, 611, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnDivide);                 // Add button to the frame

		// Set up the Cube button
		JButton btnCube = new JButton("x^3");
		btnCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the text from the field and perform the cube operation
				double a = (Double.parseDouble(textField.getText()));
				a = a * a * a;
				// Clear the text field
				textField.setText("");
				// Set the result in the text field
				textField.setText(textField.getText() + a);
			}
		});
		btnCube.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Font style and size
		btnCube.setBounds(23, 455, 84, 80);                  // Position and size of the button
		frame.getContentPane().add(btnCube);                 // Add button to the frame

		// Set up the Equal button
		JButton btnequal = new JButton("=");
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second=Double.parseDouble(textField.getText());
				// For every operation, take first and second operand, apply the operation and store the result in a variable
				// Then display the result on screen through a text field
				// Repeat the same for +, -, *, /, %, and ^ (power)
				if(operation=="+")
				{
					result=first+second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="%")
				{
					// Perform the modulus operation first % second
					result=first%second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="/")
				{
					// Perform the division operation, first / second
					result=first/second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="*")
				{
					// Perform the multiplication operation, first * second
					result=first*second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-")
				{
					// Perform subtraction operation, first - second
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="x^y")
				{
					// Perform power operation, x to the power of y
					double resultt=1;
					for(int i=0; i<second;i++)
					{
						result=first*result;

					}
					answer=String.format("%.2f",resultt);
					textField.setText(answer);
				}

			}
		});
		btnequal.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set button font style and size
		btnequal.setBounds(342, 690, 84, 80);                 // Set button position and size
		frame.getContentPane().add(btnequal);                 // Add button to the frame

		// Set up buttons for numbers from 0 to 9
		// For every button we set the font style and size,
		// also button position and we place it in the frame

		// The number from that button is stored in variable and it is displayed in a text field
		// so it can be used later for further operations

		JButton btn_0_3 = new JButton("0");
		btn_0_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_0_3.setBounds(181, 469, 84, 80);
		frame.getContentPane().add(btn_0_3);

		JButton btn_0_4 = new JButton("0");
		btn_0_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_4.setBounds(100, 690, 165, 80);
		frame.getContentPane().add(btn_0_4);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn_1.getText();
				textField.setText(number);
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_1.setBounds(100, 611, 84, 80);
		frame.getContentPane().add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn_2.getText();
				textField.setText(number);

			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_2.setBounds(181, 611, 84, 80);
		frame.getContentPane().add(btn_2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn3.getText();
				textField.setText(number);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(259, 611, 84, 80);
		frame.getContentPane().add(btn3);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn4.getText();
				textField.setText(number);

			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(100, 533, 84, 80);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn5.getText();
				textField.setText(number);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(181, 533, 84, 80);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn6.getText();
				textField.setText(number);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(259, 533, 84, 80);
		frame.getContentPane().add(btn6);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn7.getText();
				textField.setText(number);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(100, 455, 84, 80);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn8.getText();
				textField.setText(number);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(181, 455, 84, 80);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn9.getText();
				textField.setText(number);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(259, 455, 84, 80);
		frame.getContentPane().add(btn9);
	}
}
