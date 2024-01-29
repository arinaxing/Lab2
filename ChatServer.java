import java.io.IOException;
import java.net.URI;
//import arraylist and use it to store strings with incoming messages and user, and colon

class Handler implements URLHandler {
    ArrayList<String> history = new ArrayList<>();
    String message = null;
    String user = null;

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            String key = parameters[0];
            String content = parameters[1];
                if ("s".equals(key)){
                    message = content;
                } else if ("user".equals(key)){
                    user = content;
                }
        }
        return user + ": " + message;
    }
                    
            



        
        if (url.getPath().equals("/")) {
            return String.format("Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
