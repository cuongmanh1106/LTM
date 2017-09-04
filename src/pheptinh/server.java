/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pheptinh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class server {
    
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(1234);
        Socket sv = ss.accept();
        
        DataInputStream nhan = new DataInputStream(sv.getInputStream());
        DataOutputStream goi = new DataOutputStream(sv.getOutputStream());
        
        
        
        int n;
        int a=0,b=0;
        while(true) 
        {
            String menu = "1.Nhap 2 so\n2.Tong 2 so\n3.Tich 2 so\n4.thoat\n";
            goi.writeUTF(menu);
            switch(nhan.readInt())
            {
                case 1: 
                    a = nhan.readInt();
                    b = nhan.readInt();
                    break;
                    
                case 2:
                    goi.writeUTF("Tong la"+(a + b));
                    break;
                case 3:
                    goi.writeUTF("Tich la"+(a * b));
                    break;
                case 4:
                    sv.close();
                    return;
            }
        }
    
    }
}
