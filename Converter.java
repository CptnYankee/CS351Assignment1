package assignment1;

public class Converter {
	
	Double dec;
	String hexa;
	String octal;
	String binary;
	String txt;
	String sci;
	
	String output;
	
	public void getDecimal(String str, char type) {
		switch(type) {
			case 'h':
				break;
				
			case 'o':
				break;
				
			case 'b':
				break;
				
			case 't':
					StringBuilder temp = new StringBuilder();
					for(int i = 0; i < str.length(); i++) {
						int c = (int)str.charAt(i);
						temp.append(c);
					}
					dec = Double.parseDouble(temp.toString());
				break;
				
			case 'f':
					dec = floatParse(str);
				break;
				
		}
		return;
	}
	
	private Double floatParse(String str) {
		double a;
		int b;
		String spl[] = str.split("(e+)|(E+)", 2);
		a = Double.parseDouble(spl[0]);
		b = Integer.parseInt(spl[1]);
		return (a*Math.pow(10, b));
	}
	
	public String getHex() {
		return "Ox" + Double.toHexString(dec);
	}
	
	public String getOct() {
		return "O";// + Double.toOctalString(dec);
	}
	
	public String getBin() {
		return "Ob";// + Double.toBinaryString(dec);
	}
	
	//we should always expect to divide by 10 until there's only one digit before the decimal point
	public String getFloat() {
		int power;
		double value;
		
		power = (dec.toString().length()) - 1;
		value = dec/Math.pow(10, power);
		StringBuilder str = new StringBuilder();
		
		str.append(value);
		str.append("e+");
		str.append(power);
		
		return str.toString();
	}
		
		
		
}
