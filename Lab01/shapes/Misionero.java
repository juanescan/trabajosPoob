
/**
 * Write a description of class Cannibal here.
 * 
 * @author (Santiago Cordoba y Juan Cancelado) 
 * @version (a version number or a date)
 */
public class Misionero
{
    // instance variables - replace the example below with your own
    private Circle cara;
    private Rectangle pecho;
    private boolean isVisible;

    /**
     * Constructor for objects of class Misionero
     */
    public Misionero()
    {
        cara = new Circle(40,150,100,"black");
        pecho = new Rectangle(60,40,150,140,"blue");
    }

    /**
     * Make this Misionero visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        cara.makeVisible();
        pecho.makeVisible();
    }
    
    /**
     * Make this Misionero invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        cara.makeInvisible();
        pecho.makeInvisible();
    }
    
    
    /**
     * Change the size to the new size
     * @param newSize must be >=0
     */
    public void changeSize(int newSize){
        int newHeight = (int)(1.3 * newSize);
        cara.changeSize(newSize);
        pecho.changeSize(newHeight,newSize);
        organizeChangeSizeAndMoveTo();
    }
    
    /**
     * Change the color 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        cara.changeColor(newColor);
        pecho.changeColor(newColor);
    }
    
    /**
     * Move the Misionero to the specific place.
     */
    public void moveTo(int f,int c){
        cara.Coordenadas(f,c);
        pecho.Coordenadas(f,c);
        organizeChangeSizeAndMoveTo();
    }
    
    /**
     * Rotate the Cannibal 90 degrees.
     */
    public void rotate(){
        pecho.rotate();
        organizeRotate();
    }
    
    /**
     * Organize the figure when use changeSize or moveTo.
     */
    private void organizeChangeSizeAndMoveTo() { 
        if(pecho.getRGrade() == 1){
            pecho.Coordenadas(cara.getXPosition()+cara.getDiameter(),cara.getYPosition());
        }
        else if(pecho.getRGrade() == 2){
            pecho.Coordenadas(cara.getXPosition(),cara.getYPosition()-cara.getDiameter());
        }
        else if(pecho.getRGrade() == 3){
            pecho.Coordenadas(cara.getXPosition()-cara.getDiameter(),cara.getYPosition());
        }
        else if(pecho.getRGrade() == 0){
            pecho.Coordenadas(cara.getXPosition(),cara.getYPosition()+cara.getDiameter());
        }
    }
    
    /**
     * Organize the figure when use rotate.
     */
    private void organizeRotate(){
        if(pecho.getRGrade() == 1){
            pecho.Coordenadas(cara.getXPosition()+cara.getDiameter(),cara.getYPosition());
        }
        else if(pecho.getRGrade() == 2){
            pecho.Coordenadas(cara.getXPosition(),cara.getYPosition()-cara.getDiameter());
        }
        else if(pecho.getRGrade() == 3){
            pecho.Coordenadas(cara.getXPosition()-cara.getDiameter(),cara.getYPosition());
        }
        else if(pecho.getRGrade() == 0){
            pecho.Coordenadas(cara.getXPosition(),cara.getYPosition()+cara.getDiameter());
        }
    }
}
