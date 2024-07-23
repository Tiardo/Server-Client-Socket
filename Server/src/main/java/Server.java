import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

       try (ServerSocket server = new ServerSocket( 8000 )) {

           System.out.println("Start Server");

           while (true)
               try (
                    Socket socket = server.accept();
                    BufferedWriter writer =
                            new BufferedWriter(
                                new OutputStreamWriter(
                                    socket.getOutputStream()));
                    BufferedReader reader =
                            new BufferedReader(
                                new InputStreamReader(
                                    socket.getInputStream()));
               ) {


                   String request = reader.readLine();
                   if (request == null) {
                       System.out.println("НИЧЕГО");
                   } else {

                       String response = "Добро пожаловать " + request.length();
                       System.out.println(request);
                       writer.write(response);
                       writer.newLine();
                       writer.flush();
                   }
               }


       } catch (IOException e){
           throw new RuntimeException(e);
       }

    }
}
