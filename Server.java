/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Menna Ashraf Hanafy AbdelHamied SEC4 منة الله اشرف حنفي عبدالحميد
package server;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Server {
    public static void main(String[] args) {
        int server_port = 43085;
        //create listening socket to receive clients requests
        try(ServerSocket listenSocket = new ServerSocket(server_port)){
         System.out.println("Server started listening on port : "+server_port);
         //creating infinite loop to continously accept/listen for incoming messages/data
             while(true) {
                 try(Socket clientSocket = listenSocket.accept();) {
                 
                 //creating input and output streams to send and receive data
                 DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                 
                //reading incoming data from input stream to validate both username and password
                String username = in.readUTF();
                String password = in.readUTF();
                
                if("menna ashraf".equals(username) && "sec4_33243085".equals(password)) {
                    //sending response in output stream to client 
                    out.writeUTF("You have successfully logged in");
                }
                else {
                    out.writeUTF("Invalid username or password");
                }
                 
                }catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + server_port);
            System.exit(-1);
        }
    }
}
    
    

