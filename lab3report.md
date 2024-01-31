##Part 1
```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
//use an array list and store the user and message separated by colon

    class Handler implements URLHandler {
    ArrayList<String> history = new ArrayList<>();
    String message = null;
    String user = null;

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("&");
                String content = parameters[0];
                String userequals = parameters[1];

            String[] contentParam = content.split("=");
                String message = contentParam[1];

            String[] userParam = userequals.split("=");
                String user = userParam[1];
            
        String output = user + ": " + message +"\n";
        history.add(output);
        String printed = "";
        
       for(String a : history){
            printed+=a;
            
        }
        return printed;
        }
        return "404 Not Found";
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
```
Which methods in your code are called?
What are the relevant arguments to those methods, and the values of any relevant fields of the class?
How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
![Image](1stMessage.png)
The handleRequest and main method are called. The relevant arguments to the handleRequest class is the url that is taken in.
This url is used to extract parameters. Using the ```getQuery()``` command, we split the query at ```&``` and havee our two parameters
with one beeing the user side and one being the message side. Within these two parameters, we split them further at the ```=``` which appears
on both sides of ```&```. Now, we can extract the user and message content by referring to the correct parameters.
The relevant fields are history which is an arrayList used to store the user and message entered separated by a colon. ```\n``` is used so that the next 
log stored will be printed in a new line. An empty string called Printed was made so the content stored in history could be iterated and printed out. Since this was the first message
and user, that was the only line printed out.  No values got changed because history only had one string stored and it printed that string out. 


![Image](2ndMessage.png)
Like the previous image, the handleRequest and main method are called. The parameters remain the same. The message and user are extracted from this new message. One
thing different is that because history is an arrayList so it now contains both the previous user and message and the current user and message. So when the code proceeds to the 
for loop to print out  the array list, both lines are printed. Therefore, history is the only value changed.

##Part 2
![Image](MyComputer.png)
The absolute path to my private key is therefore /Users/arinaxing/.ssh/id_rsa

![Image](publickey.png)
/home/linux/ieng6/oce/63/763/rxing/.ssh

![Image](noPass.png)

##Part 3
In these last two weeks I basically everything that was taught. I never knew we can log onto other computers from our own computer. But what I found coolest was creating our own "website"
which is basically a writeup on github. I always wondered how websites were written, now I know from github we can create writeups using the .md file and other people can acces it with a link. 
There are also markdowns to remember (or use the cheat sheet) to write in a specific way. For example, #is a big heading, we use tickmarks to write code blocks and we can save as a PDF using the print
method-which I didn't know before. And also, we can basically use a website to create our own mini chat server which utilizes ourr skills to recognize queries and spliting parameters.







