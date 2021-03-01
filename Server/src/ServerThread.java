import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread{
    private Socket socket = null;

    public ServerThread(Socket socket){
        super("ServerThread");
        this.socket = socket;
    }

    public void run(){
        try{
            String inLine, outLine;
            PrintWriter out = new PrintWriter((socket.getOutputStream()), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            RequestProtocol rp = new RequestProtocol();

            while((inLine = in.readLine()) != null){
                outLine = RequestProtocol.processRequest(inLine);
                out.println(outLine);
                if(outLine.equals("exit"))
                    break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
