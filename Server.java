import java.net.* ;

public class Server {

    //List of Clients
    //private static ArrayList<ClientRecievable> clients = new ArrayList<>();
    
    public static void main(String argv[]) throws Exception {
	
    int port = Integer.parseInt(argv[0]);
	// Establish the listen socket.
	ServerSocket socket = new ServerSocket(port);

	// Process HTTP service requests in an infinite loop.
	while (true) {

	    // Listen for a TCP connection request.
        // Player 1 Connection
	    Socket Client = socket.accept();
        Socket Client2 = socket.accept();
	    // Construct an object to process GAME Request.
	    GameProtocol request = new GameProtocol(Client, Client2);
	    
	    // Creates a thread for the game
	    Thread thread = new Thread(request);
	    
	    // Starts thread.
	    thread.start();
	}
    }
}
