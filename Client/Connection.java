import java.io.*;
import java.awt.*;

final class Connection implements Runnable{
    PrintWriter out;
    BufferedReader in;
    Board board;
	Client client;

	/**
	 * @param out PrintWriter to server
	 * @param in BufferedReader from server
	 * @param board The GUI object from board
	 * @param client The Client object
	 */
    public Connection(PrintWriter out, BufferedReader in, Board board, Client client){
        this.out = out;
        this.in = in;
        this.board = board;
		this.client = client;
    }

    public static void main(String[] args) {   
    }

	/**
	 *   When Connection thread starts it immediately passes the UserName to the server, then continusously listens for response from server.
	 */
    @Override
    public void run() {
		out.println("U " + client.Login.userNameF.getText());

		String Recieved;
        try{
        while((Recieved = in.readLine()) != null){
            processInput(Recieved,out);
		}}catch (IOException e) {
			System.out.println("Exception [" + e + "] Received");
		}
	}

	/**
	 * Formating (currently):
	 * 	  If the string starts with the following it means:
	 * 			"U " - remaining string is the username. *Make client save oppent*
	 * 			"M " - remaining string is the move. [1-9]. *Make moves more flexible*
	 * 			"P " - remaining string identifies which player you are.
	 * 			"WIN" - Game Over locks the board then prints out if you are winner or loser
	 * 			"LOSE" - Game Over locks the board then prints out if you are winner or loser
	 * @param input Input recieved/used to process
	 * @param out PrintWriter to server
	 */
	private void processInput(String input, PrintWriter out) {

		//Recieving P and U at same time
		//Find 0-9 printed
		try{
			if ( (input.equals("WIN")) || (input.equals("LOSE")) ){
				System.out.println("\n GAME OVER: " + input);
				out.println("LOCK");
				this.client.Lock(board);
				this.client.Socket.close();
			}else if (input.charAt(0) == 'U'){
				System.out.print("\n YOU ARE VS: " + input.substring(2));
			}else if(input.charAt(0) == 'P'){
				// If you are player 2; lock untill its player 1 moves.
				if(input.charAt(2) == '2'){
					client.Lock(board);
				}
				
			}else if(input == "LOCK"){
				this.client.Lock(board);
				this.client.Socket.close();
			}else if(input.charAt(0) == 'M'){
				move(input.substring(2));
				client.Unlock(board);
			}
		}catch(Exception e){
			System.out.println("Exception: " + input);
			System.out.print("Exception [" + e + "] received");
		}} 
	

	/**
	 * Updates avalible list in client & game board; after move is recieved.
	 * @param Move String from [1-9] containing move
	 */
	private void move(String Move){
		int M;
		M = Integer.parseInt(Move);
		if (M == 1){
			this.board.BUTTS[0].setText("O");
			this.board.BUTTS[0].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[0].setEnabled(false);
			client.avalible[0] = 2;
		}
		if (M == 2){
			this.board.BUTTS[1].setText("O");
			this.board.BUTTS[1].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[1].setEnabled(false);
			client.avalible[1] = 2;
		}
		if (M == 3){
			this.board.BUTTS[2].setText("O");
			this.board.BUTTS[2].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[2].setEnabled(false);
			client.avalible[2] = 2;
		}
		if (M == 4){
			this.board.BUTTS[3].setText("O");
			this.board.BUTTS[3].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[3].setEnabled(false);
			client.avalible[3] = 2;
		}
		if (M == 5){
			this.board.BUTTS[4].setText("O");
			this.board.BUTTS[4].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[4].setEnabled(false);
			client.avalible[4] = 2;
		}
		if (M == 6){
			this.board.BUTTS[5].setText("O");
			this.board.BUTTS[5].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[5].setEnabled(false);
			client.avalible[5] = 2;
		}
		if (M == 7){
			this.board.BUTTS[6].setText("O");
			this.board.BUTTS[6].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[6].setEnabled(false);
			client.avalible[6] = 2;
		}
		if (M == 8){
			this.board.BUTTS[7].setText("O");
			this.board.BUTTS[7].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[7].setEnabled(false);
			client.avalible[7] = 2;
		}
		if (M == 9){
			this.board.BUTTS[8].setText("O");
			this.board.BUTTS[8].setFont(new Font("O", Font.PLAIN, 100));
			this.board.BUTTS[8].setEnabled(false);
			client.avalible[8] = 2;
		}
        }
	
}
