import java.io.BufferedReader;
import java.net.Socket;

public class Join{
	int hasJoined;
	public void updateListentoPeers(String inputs,BufferedReader buf_reader,String username,ActiveNode active_Node,Node_Info node) throws  Exception{
		//System.out.println("Peers to receive messages from (s to skip)");
		String[] inputvalues = inputs.split(" ");
		if(!inputs.equals("s")) 
			for(int i = 0 ; i < inputvalues.length; i++) {
				String[] address = inputvalues[i].split(":");
				System.out.println("address" + address[1]);
		        Socket Predecessor_node = null;
		        Socket Sucessor_node = null;
		        try {
		        	if(node.hasPredecessor == 0) {
		        	Node_Info Predecessor = new Node_Info();
		        	Predecessor.portno = Integer.valueOf(address[1]);
		        	Predecessor.LogicalName = address[0];
		        	Predecessor_node = new Socket(address[0],Integer.valueOf(address[1]));
		        	hasJoined = 1;
		        		new ChatNode(Predecessor_node).start();
		        	}
		        	else if(node.hasSucessor == 0)  {
		        		Node_Info Sucessor = new Node_Info();
		        		Sucessor.portno = Integer.valueOf(address[1]);
		        		Sucessor.LogicalName = address[0];
		        		Sucessor_node = new Socket(address[0],Integer.valueOf(address[1]));
		        		hasJoined = 1;
			        		new ChatNode(Sucessor_node).start();
		        	
		        	}
		        	else {
		        		System.out.print("Node has both Successor and Predecessor can't add more node!!!!");
		        	}
		        }
		        catch(Exception e) {
		        	if(Predecessor_node != null) Predecessor_node.close();
		        	else System.out.println("Invalid input skip tonext line");
		        	if(Sucessor_node != null) Sucessor_node.close();
		        	else System.out.println("Invalid input skip tonext line");
		        }
			}
		//MessageContent note=new MessageContent();
			//note.Communicate(buf_reader,username,active_Node,node);
			//return 1;    
	}
	
}
