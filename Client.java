/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Menna Ashraf Hanafy AbdelHamied SEC4 منة الله اشرف حنفي عبدالحميد
package client;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Socket socket = null;
    try{
        int server_port = 43085;
        //creating a stream socket and establishing connection at server port
        socket = new Socket("localhost",server_port);
        //creating input and output stream to send and receive data to server
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String username = JOptionPane.showInputDialog("Enter Username: ");
        String password = JOptionPane.showInputDialog("Enter Password: ");
        //---------------------------------------------------------------------
        //sending username and password to the server to validate both of them
        //writing to the output stream using UTF format
        out.writeUTF(username);
        out.writeUTF(password);
        //-------------------------------
        String response = in.readUTF(); //receiving response from server and storing it in response variable
        JOptionPane.showMessageDialog(null,response);
        
    } catch(UnknownHostException e) {
        System.out.println("Sock : "+e.getMessage());
    }
    catch(IOException e) {
        System.out.println("IO : "+e.getMessage());
    }finally {
        if (socket!=null) 
            try{
                socket.close();
            }catch(IOException e){}
             }
    }
    
}
