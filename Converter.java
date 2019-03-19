package assignmentOne;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class Converter extends JPanel{
	
	int dec;
	String hexa;
	String octal;
	String binary;
	String txt;
	String sci;
	
	String tString;
	
	JLabel label;
	JTextField txtFld;
	
	char type;
	
	Converter(char t){
		type = t;
		JLabel label = new JLabel("",0);
		JTextField txtFld = new JTextField(10);
		txtFld.setText("");
		add(txtFld);
		add(label);
	}
	
	void setLabel(String str){
		label.setText(str);
		
	}
	public void getDecimal(String str) {
		switch(type) {
			case 'd':
				break;
			case 'h':
					dec = Integer.parseInt(str,16);
				break;
				
			case 'o':
					dec = Integer.parseInt(str,8);
				break;
				
			case 'b':
					dec = binaryParse(str);
				break;
				
			case 't':
					StringBuilder temp = new StringBuilder();
					for(int i = 0; i < str.length(); i++) {
						int c = (int)str.charAt(i);
						temp.append(c);
					}
					dec = Integer.parseInt(temp.toString());
				break;
			case 'c':
					dec = Integer.parseInt(str,16);
				break;
				
			case 'f':
					dec = floatParse(str);
				break;
		}
		return;
	}
	
	public void convert() {
		switch(type) {
			case 'd':
				txtFld.setText(Integer.toString(dec));
				break;
			case 'h':
				txtFld.setText(getHex());
				break;
				
			case 'o':
				txtFld.setText(getOct());
				break;

			case 'b':
				txtFld.setText(getBin());
				break;
				
			case 't':
				txtFld.setText(getFloat());	
				break;
			case 'c':
				tString = getHex();
				txtFld.setText("0xAA" + tString.substring(2));
				break;
				
			case 'f':
				txtFld.setText(getFloat());
				break;
		}
		return;
	}
	
	private int binaryParse(String str) {
		int temp = Integer.parseInt(str);
		
		int decimal = 0;
		//pos keeps track of the power we are working with
		int pos = 0;
		
		while(temp > 0) {
			//0 or 1 * 1,2,4,8 etc.
			decimal += temp%10 * Math.pow(2,pos);
			temp /= 10;
			pos++;
		}
		return decimal;
	}
	
	private int floatParse(String str) {
		double a;
		int b;
		String spl[] = str.split("(e+)|(E+)", 2);
		a = Double.parseDouble(spl[0]);
		b = Integer.parseInt(spl[1]);
		return (int)(a*Math.pow(10, b));
	}
	
	public String getHex() {
		String hex = "";
		int temp = dec;
		int digit = dec;
		
		//this will add the hex values, but they will be in reverse order.
		while(temp > 0) {
			digit = (int) (temp % 16);
			
			switch(digit) {
				case 10:
					hex += "A";
					break;
				case 11:
					hex += "B";
					break;
				case 12:
					hex += "C";
					break;
				case 13:
					hex += "D";
					break;
				case 14:
					hex += "E";
					break;
				case 15:
					hex += "F";
					break;
				default:
					hex += Integer.toString(digit);
			}
			temp = temp/16;
		}
		return "0x" + flipString(hex);
	}
	
	public String getOct() {
		String oct = "";
		int temp = dec;
		
		while(temp > 0) {
			oct += Integer.toString(temp%8);
			temp /= 8;
		}
		
		return "0" + flipString(oct);
	}
	
	public String getBin() {
		String bin = "";
		int temp = dec;
		
		while (temp > 0){
			bin += Integer.toString(temp%2);
			temp /= 2;
		}
		return "0b" + flipString(bin);
	}
	
	//we should always expect to divide by 10 until there's only one digit before the decimal point
	public String getFloat() {
		int power;
		Double value;
		
		power = (Integer.toString(dec).length()) - 1;
		value = dec/Math.pow(10, power);
		StringBuilder str = new StringBuilder();
		
		str.append(value);
		str.append("e+");
		str.append(power);
		
		return str.toString();
	}
	
	public String flipString(String in) {
		String out = "";
		for(int i = in.length()-1; i >= 0; i--) {
			out += in.charAt(i);
		}
		
		return out;
	}
		
		
}
