import java.io.*;
import java.net.*;
import java.awt.event.*;

// FIRST PLAYER CONNECTION
public class SConnection implements Runnable{
    PrintWriter out;
    BufferedReader in;
    GameProtocol GG;
	PrintWriter out2;
    public SConnection(PrintWriter out, BufferedReader in, GameProtocol G,  PrintWriter out2){
        this.out = out;
        this.in = in;
        this.GG = G;
		this.out2 = out2;

    }
    public static void main(String[] args) {
        
    }
    @Override
    public void run() {
        String Recieved;
        try{
        while((Recieved = in.readLine()) != null){
				System.out.println("\n P2 Recieved from P1: " + Recieved);
				processInput(Recieved,out,out2);
		}}catch (IOException e) {
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
				Check(out,out2);
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
			GG.GAME[0][0] = 1;
		}
		if (M == 2){
			GG.GAME[0][1] = 1;
		}
		if (M == 3){
			GG.GAME[0][2] = 1;
		}
		if (M == 4){
			GG.GAME[1][0] = 1;
		}
		if (M == 5){
			GG.GAME[1][1] = 1;
		}
		if (M == 6){
			GG.GAME[1][2] = 1;
		}
		if (M == 7){
			GG.GAME[2][0] = 1;
		}
		if (M == 8){
			GG.GAME[2][1] = 1;
		}
		if (M == 9){
			GG.GAME[2][2] = 1;
		}
        }
    private void response(PrintWriter out, String input){
        out.println(input);
    
    }
	public void Check(PrintWriter out, PrintWriter out2){

		if ((GG.GAME[0][0] == GG.GAME[0][1]) && (GG.GAME[0][1] == GG.GAME[0][2])&& (GG.GAME[0][0] == 1 || GG.GAME [0][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[1][0] == GG.GAME[0][1]) && (GG.GAME[1][1] == GG.GAME[1][2])&& (GG.GAME[1][0] == 1 || GG.GAME [1][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[2][0] == GG.GAME[2][1]) && (GG.GAME[2][1] == GG.GAME[2][2])&& (GG.GAME[2][0] == 1 || GG.GAME [2][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[0][0] == GG.GAME[1][0]) && (GG.GAME[1][0] == GG.GAME[2][0])&& (GG.GAME[0][0] == 1 || GG.GAME [0][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[0][1] == GG.GAME[1][1]) && (GG.GAME[1][1] == GG.GAME[2][1])&& (GG.GAME[0][1] == 1 || GG.GAME [0][1] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[0][2] == GG.GAME[1][2]) && (GG.GAME[1][2] == GG.GAME[1][2])&& (GG.GAME[0][2] == 1 || GG.GAME [0][2] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[0][0] == GG.GAME[1][1]) && (GG.GAME[1][1] == GG.GAME[2][2])&& (GG.GAME[0][0] == 1 || GG.GAME [0][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		if ((GG.GAME[2][0] == GG.GAME[1][1]) && (GG.GAME[1][1] == GG.GAME[0][2])&& (GG.GAME[2][0] == 1 || GG.GAME [2][0] == 2)){
			out.println("LOSE");
			out2.println("WIN");
		}
		
	}
}


