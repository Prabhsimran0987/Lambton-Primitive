package primitive_bank;

import javax.swing.*;

public class Lambton_Bank {
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Bank Managment System");
		frame.setIconImage(  new ImageIcon(System.getProperty("user.dir") + "\\src\\primitive_bank\\ddot.png").getImage() );
		
		GUI interf = new GUI();
		Login_Account user = new Login_Account();
	    interf.openSignInForm(frame, user);
		frame.setSize(800,500);  
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
