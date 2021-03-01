import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(listening){
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("Could not listen on port " + portNumber);
        System.exit(-1);
    }
    }
