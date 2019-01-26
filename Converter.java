package assignmentOne;

public class Converter {
	
	Long dec;
	String hexa;
	String octal;
	String binary;
	String txt;
	String sci;
	
	String output;
	
	char type;
	
	Converter(char t){
		type = t;
	}
	
	public void getDecimal(String str) {
		switch(type) {
			case 'd':
				break;
			case 'h':
					dec = Long.parseLong(str,16);
				break;
				
			case 'o':
					dec = Long.parseLong(str,8);
				break;
				
			case 'b':
					dec = Long.parseLong(str,2);
				break;
				
			case 't':
					StringBuilder temp = new StringBuilder();
					for(int i = 0; i < str.length(); i++) {
						int c = (int)str.charAt(i);
						temp.append(c);
					}
					dec = Long.parseLong(temp.toString());
				break;
			case 'c':
					dec = Long.parseLong(str,16);
				break;
				
			case 'f':
					dec = floatParse(str);
				break;
		}
		return;
	}
	
	private Long floatParse(String str) {
		double a;
		int b;
		String spl[] = str.split("(e+)|(E+)", 2);
		a = Double.parseDouble(spl[0]);
		b = Integer.parseInt(spl[1]);
		return (long) (a*Math.pow(10, b));
	}
	
	public String getHex() {
		return "Ox" + Long.toHexString(dec);
	}
	
	public String getOct() {
		return "O" + Long.toOctalString(dec);
	}
	
	public String getBin() {
		return "Ob" + Long.toBinaryString(dec);
	}
	
	//we should always expect to divide by 10 until there's only one digit before the decimal point
	public String getFloat() {
		int power;
		Double value;
		
		power = (dec.toString().length()) - 1;
		value = dec/Math.pow(10, power);
		StringBuilder str = new StringBuilder();
		
		str.append(value);
		str.append("e+");
		str.append(power);
		
		return str.toString();
	}
		
		
		
}
