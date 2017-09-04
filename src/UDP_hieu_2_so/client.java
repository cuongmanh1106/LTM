/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_hieu_2_so;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class client {
    public static void sendPacket(String tam, DatagramSocket cl, String dc, int port) throws UnknownHostException, IOException
    {
        byte m[]= tam.getBytes();
        InetAddress dcServer = InetAddress.getByName(dc);
        int portServer = port;
        DatagramPacket p = new DatagramPacket(m, m.length,dcServer,portServer);
        cl.send(p);
    }
    
    public static String nhanDL(DatagramSocket sv) throws IOException
    {
        byte m[] = new byte[256];
        DatagramPacket p = new DatagramPacket(m, m.length);
        sv.receive(p);
        String dl = new String (p.getData()).trim();
        return dl;
    }
    public static void main(String[] args) throws SocketException, IOException
    {
        DatagramSocket cl = new DatagramSocket();
        Scanner kb = new Scanner(System.in);
        System.out.println("Nhap 2 so");
        int a = kb.nextInt();
        String tam1 = String.valueOf(a);
        sendPacket(tam1, cl, "localhost", 1234);
        
        int b = kb.nextInt();
        tam1 = String.valueOf(b);
        sendPacket(tam1, cl, "localhost", 1234);
        
        String tam = nhanDL(cl);
        System.out.print(tam);
    }
    
}
