import java.io.* ;
import java.net.* ;


final class GameProtocol implements Runnable {
    Socket P1;
	Socket P2;
	int[][] GAME = {{0,0,0},
               		{0,0,0},
					{0,0,0}};
	/**
	 * 
	 * Currently is the connection held by second player; 
	 * 		Revisit:
	 * 			Make both connections work on SConnection
	 * 			
	 * 
	 * @param socket Player 1 Connection
	 * @param socket2 Player 2 Connection
	 * @throws Exception
	 */
    public GameProtocol(Socket socket, Socket socket2) throws Exception {
		this.P1 = socket;
        this.P2 = socket2;
    }
    
	/**
	 * in/out - Corresponds to Connection 1
	 * in2/out2 - Corresponds to Connectino 2
	 * 
	 * *CHANGE THIS TO BOTH ON SConnection*
	 * Creates a thread to listen:
	 * 			 for responses from Connection 1 (in) to Connection 2 out (out)
	 * Then Connection 2 (in) to Connection 1 (out) in this protocol.
	 * 
	 */
	@Override
    public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(P1.getInputStream()));
			PrintWriter out = new PrintWriter(this.P1.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(P2.getInputStream()));
			PrintWriter out2 = new PrintWriter(this.P2.getOutputStream(), true);
			input_reader(in, out2, in2, out);
		} catch (Exception e) {
			System.out.println(e);
		}
    }

	/**
	 * @param in - Connection 1 (in)
	 * @param out - Connection 2 (out)
	 * @param in2 - Connection 2 (in)
	 * @param out2 - Connection 1 (out)
	 */
	private void input_reader(BufferedReader in, PrintWriter out,BufferedReader in2, PrintWriter out2){
		String input2;
		SConnection Connection = new SConnection(out, in, this, out2);
		Thread C1 = new Thread(Connection);
		C1.start();
		

		try {
			out.write("P 2");
			out2.write("P 1");
			while((input2 = in2.readLine()) != null) {
				System.out.println("\n P1 Recieved from P2: " + input2);
				processInput(input2,out2, out);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void processInput(String input, PrintWriter out, PrintWriter out2) {
		try{
			if ((input.charAt(0) == ('U'))){
				response(out, input);
			}else if(input.compareTo("LOCK") == 0){
				response(out, input);
			}else if (input.charAt(0) == 'M'){
				move(input.substring(2));
				Check(out, out2);
				response(out, input);
			}else if(input.charAt(0) == 'P'){
				response(out, input);
			}
		}catch(Exception e){
			System.out.println(input);
			System.out.print(e);
		}} 
	
	private void move(String Move){
		int M;
		M = Integer.parseInt(Move);
		if (M == 1){
			GAME[0][0] = 2;
		}
		if (M == 2){
			GAME[0][1] = 2;
		}
		if (M == 3){
			GAME[0][2] = 2;
		}
		if (M == 4){
			GAME[1][0] = 2;
		}
		if (M == 5){
			GAME[1][1] = 2;
		}
		if (M == 6){
			GAME[1][2] = 2;
		}
		if (M == 7){
			GAME[2][0] = 2;
		}
		if (M == 8){
			GAME[2][1] = 2;
		}
		if (M == 9){
			GAME[2][2] = 2;
		}
	}

	private void response(PrintWriter out, String input){
		out.println(input);
	}
	public void Check(PrintWriter out2, PrintWriter out){

		if ((GAME[0][0] == GAME[0][1]) && (GAME[0][1] == GAME[0][2])  && (GAME[0][0] == 1 || GAME [0][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[1][0] == GAME[1][1]) && (GAME[1][1] == GAME[1][2])&& (GAME[1][0] == 1 || GAME [1][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[2][0] == GAME[2][1]) && (GAME[2][1] == GAME[2][2])&& (GAME[2][0] == 1 || GAME [2][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[0][0] == GAME[1][0]) && (GAME[1][0] == GAME[2][0])&& (GAME[0][0] == 1 || GAME [0][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[0][1] == GAME[1][1]) && (GAME[1][1] == GAME[2][1])&& (GAME[0][1] == 1 || GAME [0][1] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[0][2] == GAME[1][2]) && (GAME[1][2] == GAME[1][2])&& (GAME[0][2] == 1 || GAME [0][2] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[0][0] == GAME[1][1]) && (GAME[1][1] == GAME[2][2])&& (GAME[0][0] == 1 || GAME [0][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
		if ((GAME[2][0] == GAME[1][1]) && (GAME[1][1] == GAME[0][2])&& (GAME[2][0] == 1 || GAME [2][0] == 2)){
			out.println("WIN");
			out2.println("LOSE");
		}
	}

}
