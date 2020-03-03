import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ActiveNode extends Thread {
    Node_Info n_inf = new Node_Info();
    int portnos;
    private ServerSocket serversocket;
    public ArrayList<ActiveNodeWorker> serverThreadThreads = new ArrayList<ActiveNodeWorker>();
    public ActiveNode() {}
    public ActiveNode(int portno) throws IOException{
    	portnos = portno;
    	serversocket = new ServerSocket(portno);
    }
    public int get_ActiveNode() {
    	return portnos;
    }
    public void run() {
    	try {
    		while(true) {
    			ActiveNodeWorker act_nodeworker = new ActiveNodeWorker(serversocket.accept(),this);
    			serverThreadThreads.add(act_nodeworker);
    			act_nodeworker.start();
    			
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
  }
    public void sendMessage(String message) {
       try {
    	   serverThreadThreads.forEach(t->t.getPrintWriter().println(message)); 	   
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    	
    }
    public ArrayList<ActiveNodeWorker> getServerThreadThreads(){
    	 return serverThreadThreads;  	
    }
    
    
	boolean Join(String LogicalName,int portno) {		
		return true;
	}
	
	
	
}
