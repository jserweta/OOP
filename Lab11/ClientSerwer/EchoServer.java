import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String inputLine;
        User user = new User();

        while ((inputLine = in.readLine()) != null) {
            String str = new String(inputLine);
            String[] command = str.split(" ");
            switch (command[0]){
                case "LOGIN":

                    if(!user.getON()) {
                        String[] date = command[1].split(";");
                        if (Login.LOG(date[0], date[1])) {
                            user.setON(true);
                            user.setID(Login.logIN(date[0], date[1]));
                            out.println("ID = " + user.getID());
                        } else {
                            out.println("Nie poprawne dane, " + "odległość = " + Login.logIN(date[0], date[1]));
                        }
                        break;
                    }else out.println("Jesteś zalogowany");


                case "LOGOUT":
                    if(user.getON()){
                        if(LogOut.logOUT(user,command[1])){
                            user.setON(false);
                            out.println("Wylogowano");
                        }
                        else out.println("Nie poprawny ID");
                    }else out.println("Nie jesteś zalogowany");
                    break;
                case "LS":
                    if(user.getON()){
                        if(command[1].equals(user.getID())){
                            out.println(Ls.listing());
                        }else out.println("Nie poprawny ID");
                    }else out.println("Nie jesteś zalogowany");
                    break;
                case "GET":
                    if(user.getON()){
                        if(command[1].equals(user.getID())){
                            out.println(Get.GetFile(command[2]));
                        }else out.println("Nie poprawny ID");
                    }else out.println("Nie jesteś zalogowany");
                    break;
            }

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}