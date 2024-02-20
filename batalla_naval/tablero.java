import java.util.ArrayList;

/**
 * Write a description of class tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tablero
{
    // instance variables - replace the example below with your own
    private ArrayList<flota> flotas;
    private int longitud;
    private int latitud;
    
    public tablero(int longitud1,int latitud1, ArrayList<flota> flotas1){
        longitud = longitud1;
        latitud = latitud1;
        flotas = flotas1;
        if (longitud < -100 && longitud > 100){
            System.out.println("fuera de los limites");
        }
        
        if (latitud < -100 && latitud > 100){
            System.out.println("fuera de los limites");
        }
        
    }
    
}
