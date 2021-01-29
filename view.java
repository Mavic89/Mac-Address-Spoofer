import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;


public class GUI {
	public static void main(String args[]) {
		String os = System.getProperty("os.name");
		Spoofer spooferObject = new Spoofer(os);
		
		//JFRAME
		JFrame frame = new JFrame("Mac Address Spoofer");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,300);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//JPANEL
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.BLACK);
        
        //HEADER
		JLabel title = new JLabel("<html><b><u>Mac Address Spoofer</u></b></html>",SwingConstants.CENTER);
	    title.setFont(new Font("Verdana", Font.PLAIN, 30));
	    title.setPreferredSize(new Dimension(250, 100));
		title.setForeground(Color.GREEN);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//MAC ADDRESS SECTION
		JLabel MAC = new JLabel();
	    MAC.setFont(new Font("Verdana", Font.PLAIN, 13));
	    MAC.setPreferredSize(new Dimension(100, 100));
		MAC.setForeground(Color.WHITE);
		String MacAdr = spooferObject.getMAC();
		MAC.setText("Mac Address:"+MacAdr);
		MAC.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	/*	//DISK SERIAL SECTION
		JLabel DiskSerial = new JLabel();
		DiskSerial.setFont(new Font("Verdana", Font.PLAIN, 13));
		DiskSerial.setPreferredSize(new Dimension(100, 100));
		DiskSerial.setForeground(Color.WHITE);
		String serialNumber = Spoofer.getDiskSerial();
		DiskSerial.setText("Disk Serial:"+serialNumber);
		DiskSerial.setAlignmentX(Component.CENTER_ALIGNMENT);*/
		
		//SPOOF BUTTON
		JButton Spoof = new JButton("SPOOF");
		Spoof.setPreferredSize(new Dimension(50, 50));
		Spoof.setBackground(Color.GREEN);
		Spoof.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//ADDING ALL CONTENT
		frame.add(panel);
		panel.add(title);
		panel.add(Box.createRigidArea(new Dimension(5, 15)));
		panel.add(MAC);
		panel.add(Box.createRigidArea(new Dimension(5, 15)));
		//panel.add(DiskSerial);
		panel.add(Box.createRigidArea(new Dimension(5, 15)));
		panel.add(Spoof);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));
		
		
	}
}
