import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ActiveNodeWorker extends Thread {
       public ActiveNode act_node;
       public Socket socket;
       public PrintWriter printwriter;
       public ActiveNodeWorker() {}
	   public ActiveNodeWorker(Socket socket,ActiveNode act_node) {
		   this.act_node = act_node;
		   this.socket = socket;
	   }
	   public PrintWriter getPrintWriter() {return printwriter;}
	   public void run() {
		   try {
			   BufferedReader buf_read = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			   this.printwriter = new PrintWriter(socket.getOutputStream(),true);
			   while(true) {
				   act_node.sendMessage(buf_read.readLine());
			   }
		   }
		   catch(Exception e) {
			   act_node.getServerThreadThreads().remove(this);
		   }
	   }
}
