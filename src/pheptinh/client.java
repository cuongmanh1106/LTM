/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pheptinh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class client {
    
    public static void main(String[] args) throws IOException
    {
        Socket cl = new Socket("localhost",1234);
        
        DataInputStream nhan = new DataInputStream(cl.getInputStream());
        DataOutputStream goi = new DataOutputStream(cl.getOutputStream());
        
        Scanner kb = new Scanner (System.in);
        
        
        
        int n = 0;
        int a , b;
        String kq;
        while(true)
        {
            String menu = nhan.readUTF();
            System.out.println(menu);
            System.out.println("Lua chon cua ban");
            n = kb.nextInt();
            goi.writeInt(n);
            
            switch(n)
            {
                case 1: 
                    System.out.println("nhap 2 so:");
                    goi.writeInt(kb.nextInt());
                    goi.writeInt(kb.nextInt());
                    break;
                case 2:
                    System.out.println(nhan.readUTF());
                    break;
                case 3:
                    System.out.println(nhan.readUTF());
                    break;
                case 4:
                    cl.close();
                    return;
                
            }
        }
        
    }
    
}
