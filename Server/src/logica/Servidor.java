/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Oswaldo
 */
public class Servidor {
    
    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    private int puerto;
    
    
    private boolean activado;

    public Servidor() {
        activado = false;
        puerto = 5000;
    }        

    public void activar(boolean b) {
        activado = b;
    }

    public void escucharClientes() throws IOException {
        
        byte movimientos[] = new byte[100];
        
        if(activado){
            
            // Establecer puerto por donde se va a escuchar
            servidor = new ServerSocket(puerto);
            // Esperar conexion
            System.out.println("Esperando conexiones...");
            cliente = servidor.accept();  // Bloqueante
            System.out.println("Se ha conectado " + cliente.getInetAddress().getHostAddress());
            // Alguien se conecto, y está en la variable(objeto) cliente
            //capturar flujos
            datosEntrada = new DataInputStream(cliente.getInputStream());
            datosSalida = new DataOutputStream(cliente.getOutputStream());
            
            
            // Envio/Recepcion datos
            datosEntrada.read(movimientos);
            System.out.println("Recibo: " + new String(movimientos));            
            
            //cerrar todo
            datosEntrada.close();
            datosSalida.close();
            cliente.close();
        }
        
        
    }
    
}
