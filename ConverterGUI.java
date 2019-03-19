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

public class ConverterGUI {
	//I think I only need to use 1 converter, but to simplfy testing we'll have all for now
	private Converter cDec;
	private Converter cHex;
	private Converter cOct;
	private Converter cBin;
	private Converter cTxt;
	private Converter cFlt;
	
	private JFrame frm;
	
	//Buttons
	private JButton btnClr;
    private JButton btnCol;
    private JButton btnConv;
    
    //primary panel
    private JPanel pnlPrim;
    //pane displaying the color
    private JPanel colorPane;
    
    //TextFields
    private JTextField fldDec;
    private JTextField fldHex;
    private JTextField fldOct;
    private JTextField fldBin;
    private JTextField fldCha;
    private JTextField fldFlt;
    //Labels
    private JLabel lblBin;
    private JLabel lblCol;
    private JLabel lblDec;
    private JLabel lblFlt;
    private JLabel lblHex;
    private JLabel lblOct;
    private JLabel lblTxt;
    //color thing
    private JColorChooser colorChooser;
	
	ConverterGUI(){
		cDec = new Converter('d');
		cHex = new Converter('h');
		cOct = new Converter('o');
		cBin = new Converter('b');
		cTxt = new Converter('t');
		cFlt = new Converter('f');
		buildUI();
	}
	
	private void buildUI() {
		frm = new JFrame("Number Converter");
		colorChooser = new JColorChooser();
        pnlPrim = new JPanel();
        btnConv = new JButton("Convert");
        btnClr = new JButton("Clear");
        btnCol = new JButton("Pick Color");
        colorPane = new JPanel();
        
        btnConv.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt) {
        		btnConvActionPerformed(evt);
        	}

			private void btnConvActionPerformed(ActionEvent evt) {
				
			}
        });
        
        btnClr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClrActionPerformed(evt);
            }

			private void btnClrActionPerformed(ActionEvent evt) {
				fldDec.setText("");
				fldHex.setText("");
				fldOct.setText("");
				fldBin.setText("");
				fldCha.setText("");
			}
        });
        
        btnCol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnColActionPerformed(evt);
            }

			private void btnColActionPerformed(ActionEvent evt) {
				
			}
        });

        fldFlt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fldFltActionPerformed(evt);
            }

			private void fldFltActionPerformed(ActionEvent evt) {
				
				
			}
        });

        GroupLayout colorPaneLayout = new GroupLayout(colorPane);
        colorPane.setLayout(colorPaneLayout);
        colorPaneLayout.setHorizontalGroup(
            colorPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        colorPaneLayout.setVerticalGroup(
            colorPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cDec.setLabel("Decimal");

        cOct.setLabel("Octal");

        cBin.setLabel("Binary");

       // cCol.setLabel("Color");

        cTxt.setLabel("Characters");

        cHex.setLabel("HexaDecimal");

        cFlt.setLabel("Float");

        GroupLayout pnlPrimLayout = new GroupLayout(pnlPrim);
        pnlPrim.setLayout(pnlPrimLayout);
        pnlPrimLayout.setHorizontalGroup(
            pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrimLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblDec, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOct, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBin, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCol, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTxt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHex, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addComponent(btnConv)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClr))
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCol, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                    .addComponent(fldBin, GroupLayout.Alignment.TRAILING)
                    .addComponent(fldOct, GroupLayout.Alignment.TRAILING)
                    .addComponent(fldHex, GroupLayout.Alignment.TRAILING)
                    .addComponent(fldDec, GroupLayout.Alignment.TRAILING)
                    .addComponent(fldCha, GroupLayout.Alignment.TRAILING)
                    .addComponent(fldFlt))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlPrimLayout.setVerticalGroup(
            pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            //this is a very useful thing to know
            .addGroup(GroupLayout.Alignment.TRAILING, pnlPrimLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDec, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fldDec))
                .addGap(18, 18, 18)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(fldHex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHex, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(fldOct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOct, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(fldBin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCol, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCol, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fldCha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblFlt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))
                    .addGroup(pnlPrimLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fldFlt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrimLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClr)
                            .addComponent(btnConv))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(frm.getContentPane());
        frm.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        frm.pack();
    }
	void openWindow() {
		frm.setVisible(true);
	}
}

