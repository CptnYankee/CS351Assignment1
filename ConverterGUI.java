package assignmentOne;

public class ConverterGUI {
	Converter cDec;
	Converter cHex;
	Converter cOct;
	Converter cBin;
	Converter cTxt;
	Converter cFlt;
	
	ConverterGUI(){
		cDec = new Converter('d');
		cHex = new Converter('h');
		cOct = new Converter('o');
		cBin = new Converter('b');
		cTxt = new Converter('t');
		cFlt = new Converter('f');
	}

}
