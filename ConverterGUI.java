package assignmentOne;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConverterGUI {
	Converter cDec;
	Converter cHex;
	Converter cOct;
	Converter cBin;
	Converter cTxt;
	Converter cFlt;
	
	JFrame frm;
	JPanel pnl;
	JButton btn;
	JTextField fld;
	JLabel lbl;
	
	ConverterGUI(){
		cDec = new Converter('d');
		cHex = new Converter('h');
		cOct = new Converter('o');
		cBin = new Converter('b');
		cTxt = new Converter('t');
		cFlt = new Converter('f');
	}
	
}
