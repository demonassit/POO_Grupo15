/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proceso;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tablero extends JPanel implements Runnable{
    private final Image background;
    private  Image tortuga;
    private  Image liebre;
    private Thread hilo;
    
    private  int x,y;
    
    public Tablero(){
        
        //debemos definir los elementos que se encuentran al inicio de nuestro tablero
        //por defecto tenemos en nuestro tablero un fondo de pantalla "background"
        //debemos de cargar los parametros y la configuracion del fondo de pantalla
        setBackground(Color.WHITE);
        setDoubleBuffered(true);//el tamaño del buffer para transferir los datos
        //definir donde esta la imagen
        background = new ImageIcon(this.getClass().getResource("/img/paisaje1.png")).getImage();
        //definir las coordenadas
        x=800;
        y=300;//tamaño del fondo de pantalla
        tortuga();
        liebre();
        hilo = new Thread(this);
        hilo.start();
   }
    
    void tortuga(){
        //es para cargar la imagen de la tortuga
        tortuga = new ImageIcon(this.getClass().getResource("/img/tortuga.png")).getImage();
        
        
    }
    void liebre(){
         //es para cargar la imagen de la liebre
        liebre = new ImageIcon(this.getClass().getResource("/img/liebre.png")).getImage();
       
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //definir el objeto 2d
        Graphics2D g2 = (Graphics2D)g;
        //vamos a dibujar los elementos de cada imagen que quiero que tenga movimiento
        g2.drawImage(background, 0,0, null);
        g2.drawImage(tortuga,x,y, null);
        g2.drawImage(liebre,x,y-200,null);
         //ya tengo la posicion de tortuga y la liebre dentro del fondo de pantalla
        //ahora falta que el hilo haga que corran, para eso sirve el ciclo
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void ciclo(){
        x += 100;
        if ( x > 800 ){
            x = -200;
        }
    }
    
    @Override
    public void run() {
         //con el metodo que va animar las cosas
        //debe de existir un ciclo que se repita y se repita lo que quiera animar
        while(true){
            //un metodo para ciclar el proceso
            ciclo();
            //pintar lo que quiero que se mueva en ese ciclo
            repaint();
            
      
            try{
                Thread.sleep(1000);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
}
