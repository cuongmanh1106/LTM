/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_tongchan_tongle;

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
        
        DatagramPacket p=null;
        int chan=0;
        int le = 0;
        String dl="";
        int n=-1;
        while(n!=0)
        {
            p = nhanDL(sv);
            dl = new String(p.getData()).trim();
            System.out.println(dl+chan+le);
            n = Integer.parseInt(dl);
            
            if(n%2==0)
            {
                chan += n;
            }
            else
                le += n;
            
            
        }
        System.out.print("thoat ra vong lap");
        String tam = String.valueOf(chan);
        sendPacket(tam, sv, p.getAddress(), p.getPort());
        
        tam = String.valueOf(le);
        sendPacket(tam, sv, p.getAddress(), p.getPort());
        
        sv.close();
        
    }
    
}
