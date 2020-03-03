import java.io.BufferedReader;
import java.io.StringWriter;
import javax.json.Json;
// Used for passing messages amongst Chat Nodes
public class MessageContent {
//Communicate method sends the message to the  nodes which are logically connected to each other 
//(Active node passes message to predecessor and Successor and Vice-versa).
public void Communicate(String messages,BufferedReader buf_readere,String username,ActiveNode active_Node,Node_Info node) throws Exception{
	Leave leaves = new Leave();
	Peer p = new Peer();
	System.out.println("Enter message to communicate");
	System.out.println("> u can communicate[ c change]");
	try {
			boolean flag = true;
			//System.out.println("Please enter the message");
			    while(flag) {
			    	String message = p.mymsg(buf_readere);
					if(message.equals("L")) {
						flag = false;
						leaves.leave(node.portno,active_Node);	
						break;
					}
			else {
			
					StringWriter stringwriter = new StringWriter();
					Json.createWriter(stringwriter).writeObject(Json.createObjectBuilder()
							.add("username",username)
							.add("message", message)
							.build());
					active_Node.sendMessage(stringwriter.toString());
					//flag = false;
		}
			}
			
			
	}
		catch(Exception e) {
			System.out.println("Invalid input");
		}
	
		}
}
