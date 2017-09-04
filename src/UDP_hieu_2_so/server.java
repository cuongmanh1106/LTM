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

/**
 *
 * @author Admin
 */
public class server {
    
     public static void sendPacket(String tam, DatagramSocket cl, InetAddress dc, int port) throws UnknownHostException, IOException
    {
        byte m[]= tam.getBytes();
        int portServer = port;
        DatagramPacket p = new DatagramPacket(m, m.length,dc,portServer);
        cl.send(p);
    }
    
    public static DatagramPacket nhanDL(DatagramSocket sv) throws IOException
    {
        byte m[] = new byte[256];
        DatagramPacket p = new DatagramPacket(m, m.length);
        sv.receive(p); //khac ben client phai tra ve 3 dl la: dl nhap dcServer dcPort
        return p;
    }
    
    
    public static void main (String[] args) throws SocketException, IOException
    {
        DatagramSocket sv = new DatagramSocket(1234);
        DatagramPacket p1 = nhanDL(sv);
        DatagramPacket p2 = nhanDL(sv);
        
        String dl1 = new String(p1.getData()).trim();
        int a = Integer.parseInt(dl1);
        
        String dl2 = new String(p2.getData()).trim();
        int b = Integer.parseInt(dl2);
        
        int kq = a - b;
        
        String tam = String.valueOf(kq);
        
        sendPacket(tam, sv, p1.getAddress(), p1.getPort());
        
        sv.close();
    }
    
}
