/* Using TCP/IP sockets, write a client – server program to make the 

client send the file name and to make the server send back the contents 

of the requested file if present*/


/*SERVER program*/

import java.net.*;
import java.io.*;

public class tcps {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server ready for connection");
        Socket sock = sersock.accept();
        System.out.println("Connection Is successful and waiting for the client request");

        InputStream istream = sock.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine();
        BufferedReader ContentRead = new BufferedReader(new FileReader(fname));

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        String str;
        while ((str = ContentRead.readLine()) != null) {
            pwrite.println(str);
        }

        sock.close();
        sersock.close();
        pwrite.close();
        fileRead.close();
        ContentRead.close();
    }
}


/*first the server port should be established before it accepts any request from the client*/  