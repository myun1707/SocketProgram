import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RequestProtocol {

    public static String processRequest(String request) throws IOException {
        String[] words = request.split("\\s+");
        String result = "";

        String content = Files.readString(Path.of(words[1]));

        if (words[0].equals("GET") && words[2].equals("HTTP/1.0")) {
            result = result + "HTTP/1.0 200 ok \n Content: " + words[1] + "\n\n";
            result = result + content;
        }
        else if(words[0].equals("exit")){
            return "exit";
        }
        else{
            result = "HTTP/1.0 404 Not Found";
            }

            return result;
        }
    }
