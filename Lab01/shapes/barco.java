
/**
 * Write a description of class barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class barco
{
    // instance variables - replace the example below with your own
    private Rectangle bote;
    /**
     * Constructor for objects of class barco
     */
    public barco()
    {
        // initialise instance variables
        bote = new Rectangle(40,280,250,200,"green");
    }
    
    /**
     * Make this barco visible. If it was already visible, do nothing. 
     */
    public void makeVisible(){
        bote.makeVisible();
    }
      
    /**
     * Make this barco invisible. If it was already invisible, do nothing. 
     */
    public void makeInvisible(){
        bote.makeInvisible();
    }
    
    /**
     * Change the size to the new size
     * @param newSize must be >=0
     */
    public void changeSize(int newSize){
        int newHeight = (int) (0.125 * newSize);
        int newWidht = (int) (newSize * 0.0833333);
        bote.changeSize(newHeight,newSize);
    }
    
    /**
     * Change the color 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        bote.changeColor(newColor);
    }
    
     /**
     * Move the Canibbal to the specific place.
     */
    public void moveTo(int f,int c){
        bote.Coordenadas(f,c);
    }
    
    /**
     * Rotate the Cannibal 90 degrees.
     */
    public void rotate(){
        bote.rotate();
    }
    
}
