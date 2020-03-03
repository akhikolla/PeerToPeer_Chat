
public class Leave {
	//when user chooses L to leave
	public void leave( int portno, ActiveNode active_Node) throws Exception {
		try{
			boolean flag = true;
		//Removing the node that enters L
		while(flag) {
			for(ActiveNodeWorker ac: active_Node.serverThreadThreads) {
	        if(ac.act_node.portnos == portno) {    
	            System.out.println("Node with port number" +  ac.act_node.portnos  + "is removed");
	            flag = false;
	            break;
	        }
	        
	     
	}
		
		}
		System.exit(0);
		}catch(Exception e) {
			e.printStackTrace();
}
}
}
