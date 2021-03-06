import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Peer {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		char input;
		String message = "";
		 ActiveNode active_Node;
		// Creates a join class object and calls update method in join class
		Join joinrequest=new Join();
		MessageContent note =new MessageContent();
		// Node_Info class gives the information of the node in loading its predecessor and successor availability
		Node_Info node = new Node_Info();
		Leave leaves=new Leave();
		System.out.println("Choose one of the following operations to perform :\n"
				+ " J - JOIN \n M - SENDMESSAGE \n L - LEAVE\n");
		input = sc.next().charAt(0);
		if(input == 'J') { 
			System.out.println( "for join");
       BufferedReader buf_reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter logical name");
         node.LogicalName = buf_reader.readLine();
			System.out.println("Enter portno to be connected");
		node.portno = Integer.parseInt(buf_reader.readLine());
	 //This creates an Active node object which is to be considered as the base node object
         active_Node = new ActiveNode(node.portno);
         active_Node.start();
         node.hasPredecessor = 0;
         node.hasSucessor = 0;
         System.out.println("Enter the name and port number to connect");
         String inputs = buf_reader.readLine();
	 // Update method updates the list by adding the new nodes which are connected to the active node
         joinrequest.updateListentoPeers(inputs,buf_reader, node.LogicalName, active_Node, node);
         //This class is from where the program starts executing. User reads input from the console and chooses from J, M ,L
         if(joinrequest.hasJoined == 1) {
        		System.out.println("Joined sucessfully : choose one\n"
        				+ " M - SENDMESSAGE \n L - LEAVE\n");
		
        	input = sc.next().charAt(0);
	     // If user chooses M then it calls Communicate method in message content class
             if(input=='M') {
	     //Communicate method in message content class sends the message to the  nodes which are logically connected to each other (Active node passes message to predecessor and Successor and Vice-versa).
            	note.Communicate(message,buf_reader,node.LogicalName,active_Node,node);  
             }
	     // If user chooses L, it means leave class is invoked calling the leave method
             if(input=='L') {
	     //Leave method is used to remove the connected node and keep the nodes updated about the removal
            	 leaves.leave(node.portno,active_Node);
             }
         }   
         else if(input=='M') {
        	 System.out.println("Please Join first to communicate");
         }
         else if(input=='L') {
        	 System.out.println("Cant leave without joining");
         }
         else {
        	 System.out.println("Invalid Input");
        	 System.exit(0);
         }
	}
		
		sc.close();

	
	
	}
	
	public String mymsg(BufferedReader buf_reader) throws IOException {
   	 String msg;
		 msg = buf_reader.readLine();
	return msg;
}

}


