
package proceso;

import javax.swing.JFrame;


public class Principal extends JFrame{
    public Principal(){
        
       setTitle("Juego");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(900,550);
       setLocationRelativeTo(null);
       setResizable(false);
       add(new Tablero());
       setVisible(true);
    }
    
     public static void main(String args[]){
       new Principal();
    }
}
