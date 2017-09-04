/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_chan_le;

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
        DatagramPacket p = nhanDL(sv);
        String dl = new String(p.getData()).trim();
        int x = Integer.parseInt(dl);
        String kq="";
        System.out.print("so nhan duoc la:"+x);
        if(x%2==0)
        {
            kq = "so chan";
        }
        else
            kq = "so le";
        
        sendPacket(kq, sv,p.getAddress(), p.getPort());
    }
    
}
