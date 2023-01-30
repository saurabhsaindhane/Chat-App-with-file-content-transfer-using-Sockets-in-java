import java.io.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.net.*;
import java.security.*;


public class GossipServer


{


    public static void main(String[] args) throws Exception


    {
        Timestamp it= Timestamp.from(Instant.now());

        ServerSocket sersock = new ServerSocket(3000);


        System.out.println("Server  ready ");


        Socket sock = sersock.accept( );





        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));





        OutputStream ostream = sock.getOutputStream();


        PrintWriter pwrite = new PrintWriter(ostream, true);







        InputStream istream = sock.getInputStream();


        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));





        String receiveMessage, sendMessage;
        System.out.println("name the directory name:");
        sendMessage = keyRead.readLine();


        pwrite.println(sendMessage);

        int i = 1;


            receiveMessage = receiveRead.readLine();



                System.out.println("client directory content "+it+":");

                System.out.println(receiveMessage);

        receiveMessage = receiveRead.readLine();
        System.out.println("client file content "+it+":");

        System.out.println(receiveMessage);

        receiveMessage = "";
        sendMessage = "";

        while(true)


        {


            if((receiveMessage = receiveRead.readLine()) != null)


            {
                System.out.println("client "+it+":");

                System.out.println(receiveMessage);


            }

            System.out.println("server "+it+":");
            sendMessage = keyRead.readLine();


            pwrite.println(sendMessage);


            pwrite.flush();


        }


    }


}

