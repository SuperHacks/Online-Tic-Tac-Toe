import java.util.EventListener;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame implements EventListener{
	
	JFrame frame = new JFrame(); 
	boolean connected = false; 
	JLabel userNameL = new JLabel("Type In User Name: ");
	JLabel ipAdderL = new JLabel("Ip Adress: ");
	JLabel portNumL = new JLabel("Port #: ");
	
	JTextField userNameF = new JTextField();
	JTextField ipAdderF = new JTextField();
	JTextField portNumF = new JTextField();
	
	JButton connectB = new JButton("Connect");
	
	
	public void addComponentToPane(Container pane) {
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		
		GridLayout grid = new GridLayout(4,2);
		
		//sets the panels layout to grid (4,2)
		panel.setLayout(grid);
		
		
		//userNameL.setPreferredSize(new Dimension(3,50));
		panel.add(userNameL);
		panel.add(userNameF);
		
		
		panel.add(ipAdderL);
		panel.add(ipAdderF);
		panel.add(portNumL);
		panel.add(portNumF);
		
		pane.add(panel, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(panel2, BorderLayout.SOUTH);
		
		connectB.setPreferredSize(new Dimension (200, 50));
		panel2.add(connectB);
        
		
	}
	
	
	
	
	
	public void Start() {
		frame.setTitle("Start Screen");
		frame.setSize(600,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
//		frame.setLayout(new GridLayout(4,2));
		
		//frame.setContentPane(frame.getContentPane());
		addComponentToPane(frame.getContentPane());
		frame.setVisible(true);
		
	}
	
	
	
	
	

}