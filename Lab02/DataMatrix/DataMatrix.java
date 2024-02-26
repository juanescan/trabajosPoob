import java.util.Arrays;
/**
 * @author ECI, 2024
 *
 */
public class DataMatrix{

    private Data [][] data;
    
    /**
     * Creates a matrix with the defined size and value
     */
    public DataMatrix(String[][] data) {
        this.data = new Data[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                this.data[i][j] = new Data(data[i][j]);
            }
        }
    }

    /**
     * Calculate the size of a DataMatrix and return the size in a DataMatrix
     */
    public DataMatrix shape(){
        int rows = data.length;
        int columns = data[0].length;
        String[][] size = { {String.valueOf(rows), String.valueOf(columns)} };
        return new DataMatrix(size);
    }
    
    /**
     * Return the string representation of the data, not the original string of the position in the DataMatrix specific
     */
    public String toString(int row, int column){
        return data[row][column].toString();
    }
    
    /**
     * Transpose the DataMatrix
     */
    public DataMatrix transpose(){
        int rows = data.length;
        int columns = data[0].length;
        String[][] matrixTranspose = new String[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrixTranspose[j][i] = data[i][j].toString();
            }
        }
        
        return new DataMatrix(matrixTranspose);
    }
    
    /**
     * Add the DataMatrix with another DataMatrix position by position
     */
    public DataMatrix add(DataMatrix t){
        int rows = data.length;
        int columns = data[0].length;
        if(rows != t.data.length || columns != t.data[0].length){
            System.out.println("Las matrices son de dimensiones diferentes, no se pueden operar");
            return null;
        }
        String[][] result= new String[data.length][data[0].length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                String resultSum = data[i][j].add(t.data[i][j]).string();
                result[i][j] = resultSum; 
            }
        }
        return new DataMatrix(result);
    }
    
    /**
     * Sub the DataMatrix with another DataMatrix position by position
     */
    public DataMatrix sub(DataMatrix t){
       int rows = data.length;
        int columns = data[0].length;
        if(rows != t.data.length || columns != t.data[0].length){
            System.out.println("Las matrices son de dimensiones diferentes, no se pueden operar");
            return null;
        }
        String[][] result= new String[data.length][data[0].length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                String resultSub = data[i][j].sub(t.data[i][j]).string();
                result[i][j] = resultSub; 
            }
        }
        return new DataMatrix(result); 
    }
    
    @Override
    /**
     * Do the toString() to every element of the DataMatrix and return a string with all elements
     */
    public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("[");
    for (int i = 0; i < data.length; i++) {
        result.append(Arrays.toString(data[i])); 
        if (i < data.length - 1) {
            result.append(", "); 
        }
    }
    result.append("]");
    return result.toString();
    }

 
 
}
