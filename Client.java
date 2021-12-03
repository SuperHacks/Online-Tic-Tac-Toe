import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;

public final class Client {
    public Socket Socket = null;
    public static PrintWriter out = null;
    public static BufferedReader in = null;
    public Login Login;
    public int[] avalible = new int[9];
    
    public static void main(String[] args) throws IOException{
       
        Client Init = new Client();
        Init.start_client();
       
    }
    
    // Creates/Starts the login GUI and listens for connection request
    public void start_client(){
  
        Login = new Login();
        Login.Start();

        //Connection Request
        Login.connectB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Connect_to_server(Login.ipAdderF.getText(), Login.portNumF.getText(), Login);
            }
        });

    }

    // Attemps to connect to server
    public void Connect_to_server(String IP, String SPort, Login Login){
        
        int Port;
        // Validates IP
        if(IP.length() == 0){
            Login.userNameL.setText("INVALID IP");
            return;
        }
        // Validates Port
        try{
            Port = Integer.parseInt(SPort);
        }catch (NumberFormatException e){
            Login.userNameL.setText("PLEASE ENTER AN INTEGER");
            return;
        }
        // Attempts Connection
        try{
            this.Socket = new Socket(IP, Port);
            out = new PrintWriter(Socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
        }catch(UnknownHostException e){
            Login.userNameL.setText("UNKNOWN HOST");
            return;
        }catch(IOException e){
            Login.userNameL.setText("Couldn't get I/O for connection");
            return;
        }
        
        /**
         *  Only reached when connection is established:
         *      - Creates a board 
         *      - Creates a thread to listen for responses from server
         */
        Board game = new Board();
        Connection connection = new Connection(out, in, game,this);
        Thread thread = new Thread(connection);
        
        //Formating for sending/reciving is covered in Connection & SConnection.
        out.println("U " + Login.userNameF.getText());
        thread.start();
        Login.setVisible(false);
        game.setVisible(true);
        Start(game);
    }
    /** 
    *    Starts the game:
    *       Listens/Updates moves clicked on the game board, then sends server move.
    *    @param game The GUI object from board
    *    @return None
    */
    public void Start(Board game){     

        game.BUTTS[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                //after clcik sets the TEXT :: "X"
                game.BUTTS[0].setText("X");
                game.BUTTS[0].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[0].setEnabled(false);
                out.println("M 1");
                avalible[0] = 1;
                Lock(game);
            }
        });
        game.BUTTS[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[1].setText("X");
                game.BUTTS[1].setFont(new Font("X", Font.PLAIN, 100));
                //after click disables the button
                game.BUTTS[1].setEnabled(false);

                out.println("M 2");
                Lock(game);
                avalible[1] = 1;
            }
        });
        game.BUTTS[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[2].setText("X");
                game.BUTTS[2].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[2].setEnabled(false);

                out.println("M 3");
                Lock(game);
                avalible[2] = 1;
            }
        });
        game.BUTTS[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[3].setText("X");
                game.BUTTS[3].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[3].setEnabled(false);

                out.println("M 4");
                Lock(game);
                avalible[3] = 1;
            }
        });
        game.BUTTS[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[4].setText("X");
                game.BUTTS[4].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[4].setEnabled(false);

                out.println("M 5");
                Lock(game);
                avalible[4] = 1;
            }
        });
        game.BUTTS[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[5].setText("X");
                game.BUTTS[5].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[5].setEnabled(false);

                out.println("M 6");
                Lock(game);
                avalible[5] = 1;
            }
        });
        game.BUTTS[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[6].setText("X");
                game.BUTTS[6].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[6].setEnabled(false);

                out.println("M 7");
                Lock(game);
                avalible[6] = 1;
            }
        });
        game.BUTTS[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[7].setText("X");
                game.BUTTS[7].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[7].setEnabled(false);

                out.println("M 8");
                Lock(game);
                avalible[7] = 1;
            }
        });
        game.BUTTS[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //after clcik sets the TEXT :: "X"
                game.BUTTS[8].setText("X");
                game.BUTTS[8].setFont(new Font("X", Font.PLAIN, 100));

                //after click disables the button
                game.BUTTS[8].setEnabled(false);

                out.println("M 9");
                Lock(game);
                avalible[8] = 1;
            }
        });

    }
    
    /**
     *    Locks all buttons on the board; so the player must wait for a response.
     *    @param game The GUI object from board
     *    @return None
     */
    public void Lock(Board game){
        game.BUTTS[0].setEnabled(false);
        game.BUTTS[1].setEnabled(false);
        game.BUTTS[2].setEnabled(false);
        game.BUTTS[3].setEnabled(false);
        game.BUTTS[4].setEnabled(false);
        game.BUTTS[5].setEnabled(false);
        game.BUTTS[6].setEnabled(false);
        game.BUTTS[7].setEnabled(false);
        game.BUTTS[8].setEnabled(false);
    }

    /**
     *     Unlocks board based on moves avalible.
     * 
     *     @param game The GUI object from board
     *     @return None
     */
    public void Unlock(Board game){
		for (int i = 0; i<this.avalible.length; i++){
			if (this.avalible[i] != 1 || this.avalible[i] != 2){
				game.BUTTS[i].setEnabled(true);
			}
		}
	}
}