import javax.swing.*;
import java.awt.*;
import java.util.EventListener;




public class Board extends JFrame implements EventListener{
	
	JButton[] BUTTS = new JButton[9];
	JFrame frame = new JFrame();
	/*	Board and buttons represent this and so on.
	 * 	|---|---|---|         
	 * 	|x1	|x2	|x3 |
	 * 	|---|---|---|
	 * 	|x4	|x5	|x6 |
	 * 
	 */
	
//	public void addComponentPane(Container pane) {
//		
//	}
	
	//invoke after everything for thread saftey (what it says in Javadoc)
	public Board() {
		BUTTS[0] = new JButton();
		BUTTS[1] = new JButton();
		BUTTS[2] = new JButton();
		BUTTS[3] = new JButton();
		BUTTS[4] = new JButton();
		BUTTS[5] = new JButton();
		BUTTS[6] = new JButton();
		BUTTS[7] = new JButton();
		BUTTS[8] = new JButton();
		frame.setTitle("Tick Tack Toe with friends");
		frame.setSize(500,500);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the size of the frame 400/400
		
		frame.setLayout(new GridLayout(3,3));
		//x1.setFont(new Font("X", Font.PLAIN, 100));
		frame.add(BUTTS[0]);
		frame.add(BUTTS[1]);
		frame.add(BUTTS[2]);
		frame.add(BUTTS[3]);
		frame.add(BUTTS[4]);
		frame.add(BUTTS[5]);
		frame.add(BUTTS[6]);
		frame.add(BUTTS[7]);
		frame.add(BUTTS[8]);
		
		frame.setVisible(true);
		
		
	}
	
	
	
	

}
