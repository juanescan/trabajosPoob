import java.util.ArrayList;

/**
 * Write a description of class flota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flota
{
    // instance variables - replace the example below with your own
    private String nombre;
    public final int codigo;
    private ArrayList<tablero> tableros;
    private ArrayList<avion> aviones;
    private ArrayList<portaAviones> portaAviones;
    private ArrayList<marino> marinos;
    private ArrayList<Barco> barcos;
    
    
    
    public flota(int codigoInicial){
        this.codigo = codigoInicial;
    }
}
