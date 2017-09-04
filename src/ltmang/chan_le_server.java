/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class chan_le_server {
    
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(1234);
        Socket sv = ss.accept();
        
        DataInputStream nhan = new DataInputStream(sv.getInputStream());
        DataOutputStream goi = new DataOutputStream(sv.getOutputStream());
        String kq="";
        int x = nhan.readInt();
        if(x%2==0)
        {
            kq = "so chan";
            
        }
        else
            kq = "so le";
        
        goi.writeUTF(kq);
        
    }
    
}
