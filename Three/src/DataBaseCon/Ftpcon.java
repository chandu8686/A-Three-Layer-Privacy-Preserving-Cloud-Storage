/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseCon;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author java4
 */
public class Ftpcon {
    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    boolean status;

public boolean upload(File file){
   try{
//           client.enterLocalPassiveMode();
            client.connect("ftp.drivehq.com");
       
            client.login("cloud15", "cloud15");
            client.enterLocalPassiveMode();
             //String filename = "/home/ibn/Desktop/report.txt";
             fis = new FileInputStream(file);
             
             status= client.storeFile("/csp/"+file.getName(), fis);
       
             client.logout();
             fis.close();
    
}
catch(Exception e){
    System.out.println(e);
}
        if(status){
             System.out.println("success");
             return false;
        }
        else{
            System.out.println("failed");
            return true;
          
        }
    
} 
//    public static void main(String[] args) {
//        Ftpcon f=new Ftpcon();
//        f.upload();
//    }
   
}
