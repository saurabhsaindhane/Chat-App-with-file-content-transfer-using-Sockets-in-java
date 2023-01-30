


import java.io.*;

import java.io.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.net.*;
import java.security.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;


public class GossipClient


{


    public static void main(String[] args) throws Exception


    {
        Timestamp it= Timestamp.from(Instant.now());

        Socket sock = new Socket("127.0.0.1", 3000);


        String receiveMessage = "", sendMessage = "";


        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        InputStream istream = sock.getInputStream();

String content = "";
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        receiveMessage = receiveRead.readLine();
        File directoryPath = new File("/home/pc/"+receiveMessage);
        //List of all files and directories
        String contents[] = directoryPath.list();


        for(int i=0; i<contents.length; i++) {
            sendMessage = contents[i];
        }

        pwrite.println(sendMessage);
        File[] fl = directoryPath.listFiles();
        for(File ob: fl){
            Scanner sc = new Scanner(ob);


            sc.useDelimiter("\\Z");

            content = sc.next();
        }
        pwrite.println(content);
        System.out.println("Client side");

        receiveMessage = "";
        sendMessage = "";
        while(true)


        {
            if((receiveMessage = receiveRead.readLine()) != null)

            {

                System.out.println("server "+it+":");
                System.out.println(receiveMessage);


            }
            System.out.println("client "+it+":");
            sendMessage = keyRead.readLine();


            pwrite.println(sendMessage);


            pwrite.flush();
        }


    }


}