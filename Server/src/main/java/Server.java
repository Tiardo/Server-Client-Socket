import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket( 8000 );
        System.out.println("Start Server");

        Socket socket = server.accept();
        System.out.println("Client connection");


        BufferedWriter writer =
                new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        writer.write("Добро пожаловать");
        writer.newLine();
        writer.flush();

        writer.close();
        socket.close();
        server.close();


    }
}
