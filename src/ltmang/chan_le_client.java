/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class chan_le_client {
    
    public static void main(String[] args) throws IOException
    {
        Socket cl = new Socket("localhost",1234);
        
        DataInputStream nhan = new DataInputStream(cl.getInputStream());
        DataOutputStream goi = new DataOutputStream(cl.getOutputStream());
        
        Scanner kb = new Scanner (System.in);
        
        int x = kb.nextInt();
        goi.writeInt(x);
        
        String kq = nhan.readUTF();
        
        System.out.print(kq);
    }
    
}
