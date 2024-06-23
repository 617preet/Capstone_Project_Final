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

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	
	//To store the result 
	double first;
	double second;
	double result;
	String operation;
	String answer;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 825);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(23, 37, 403, 137);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("\u221A");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sqrt(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(25, 221, 84, 80);
		frame.getContentPane().add(btnBack);
		
		JButton btn_9 = new JButton("Log");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.log(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_9.setBounds(100, 299, 84, 80);
		frame.getContentPane().add(btn_9);
		
		JButton btn_percentage = new JButton("%");
		btn_percentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="%";
			}
		});
		btn_percentage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_percentage.setBounds(100, 378, 84, 80);
		frame.getContentPane().add(btn_percentage);
		
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
		
		JButton btn_0 = new JButton("x^2");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=(Double.parseDouble(textField.getText()));
				a=a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
				
			}}
		);
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0.setBounds(23, 533, 84, 80);
		frame.getContentPane().add(btn_0);
		
		JButton btnClear = new JButton("e^x");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.exp(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(100, 221, 84, 80);
		frame.getContentPane().add(btnClear);
		
		JButton btn__back = new JButton("\uF0E7");
		btn__back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace=null;
				
				if(textField.getText().length()>0)
				{
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace=str.toString();
					textField.setText(backSpace);
				}
					
				}
			}
					
				);
		String backSpace=null;
		
		if(textField.getText().length()>0)
		{
			StringBuilder str=new StringBuilder(textField.getText());
			str.deleteCharAt(textField.getText().length()-1);
			backSpace=str.toString();
			textField.setText(backSpace);
		}
						
				
			
		
		btn__back.setFont(new Font("Wingdings", Font.PLAIN, 18));
		btn__back.setBounds(259, 378, 84, 80);
		frame.getContentPane().add(btn__back);
		
		JButton btn_Clear = new JButton("C");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Clear.setBounds(181, 378, 84, 80);
		frame.getContentPane().add(btn_Clear);
		
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
		
		JButton btnNewButton_1_10 = new JButton("Sin");
		btnNewButton_1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sin(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_1_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_10.setBounds(181, 221, 84, 80);
		frame.getContentPane().add(btnNewButton_1_10);
		
		JButton btnNewButton_1_11 = new JButton("Cosh");
		btnNewButton_1_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.cosh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_1_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_11.setBounds(259, 299, 84, 80);
		frame.getContentPane().add(btnNewButton_1_11);
		
		JButton btn_7 = new JButton("1/X");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double a=1/(Double.parseDouble(textField.getText()));
			textField.setText("");
			textField.setText(textField.getText()+a);
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_7.setBounds(25, 299, 84, 80);
		frame.getContentPane().add(btn_7);
		
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
		
		JButton btnNewButton_1_15 = new JButton("Cos");
		btnNewButton_1_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.cos(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnNewButton_1_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_15.setBounds(259, 221, 84, 80);
		frame.getContentPane().add(btnNewButton_1_15);
		
		JButton btn_8 = new JButton("Sinh");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sinh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_8.setBounds(181, 299, 84, 80);
		frame.getContentPane().add(btn_8);
		
		JButton btn_4 = new JButton("x^y");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getSelectedText());
				textField.setText("");
				operation="x^y";
				
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_4.setBounds(25, 378, 84, 80);
		frame.getContentPane().add(btn_4);
		
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
		
		JButton btn_0_1 = new JButton("n!");
		btn_0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double a=Double.parseDouble(textField.getText());
			double fact=1;
			while(a!=0)
			{
				fact=fact*a;
				a--;
			}
			textField.setText("");
			textField.setText(textField.getText()+fact);
			}
		});
		btn_0_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_1.setBounds(23, 611, 84, 80);
		frame.getContentPane().add(btn_0_1);
		
		JButton btnPlusMinus = new JButton("+/-");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double a=Double.parseDouble(String.valueOf(textField.getText()));	
			a=a*(-1);
			textField.setText(String.valueOf(a));
			}
		});
		btnPlusMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlusMinus.setBounds(25, 690, 84, 80);
		frame.getContentPane().add(btnPlusMinus);
		
		JButton btn_0_3 = new JButton("0");
		btn_0_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_0_3.setBounds(181, 469, 84, 80);
		frame.getContentPane().add(btn_0_3);
		
		JButton btn_0_4 = new JButton("0");
		btn_0_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_4.setBounds(100, 690, 165, 80);
		frame.getContentPane().add(btn_0_4);
		
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
		
		JButton btndot = new JButton(".");
		btndot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndot.setBounds(259, 690, 84, 80);
		frame.getContentPane().add(btndot);
		
		JButton btn_0_9 = new JButton("Tan");
		btn_0_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.tan(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn_0_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_9.setBounds(342, 221, 84, 80);
		frame.getContentPane().add(btn_0_9);
		
		JButton btn_0_10 = new JButton("Tanh");
		btn_0_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.tanh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn_0_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_10.setBounds(342, 299, 84, 80);
		frame.getContentPane().add(btn_0_10);
		
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="-";
			}
		});
		btnminus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnminus.setBounds(342, 378, 84, 80);
		frame.getContentPane().add(btnminus);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="+";
			}
		});
		btnplus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnplus.setBounds(342, 455, 84, 80);
		frame.getContentPane().add(btnplus);
		
		JButton btnmul = new JButton("*");
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="*";
			}
		});
		btnmul.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnmul.setBounds(342, 533, 84, 80);
		frame.getContentPane().add(btnmul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="/";
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiv.setBounds(342, 611, 84, 80);
		frame.getContentPane().add(btnDiv);
		
		JButton btnequal = new JButton("=");
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second=Double.parseDouble(textField.getText());
				if(operation=="+")
				{
					result=first+second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-")
				{
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="%")
				{
					result=first%second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="/")
				{
					result=first/second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="*")
				{
					result=first*second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-")
				{
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				
				else if(operation=="x^y")
				{
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
		btnequal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnequal.setBounds(342, 690, 84, 80);
		frame.getContentPane().add(btnequal);
		
		JButton btn_0_6 = new JButton("x^3");
		btn_0_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=(Double.parseDouble(textField.getText()));
				a=a*a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn_0_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_0_6.setBounds(23, 455, 84, 80);
		frame.getContentPane().add(btn_0_6);
	}
}
