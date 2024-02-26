import java.util.HashMap;
import java.util.Set;

/** Data Matrix Calculator
 * 
 * @author CIS 2024-01
 */
    
public class DataMatrixCalculator{
    
    private HashMap<String, DataMatrix> variables;
    
    /**
     * Create a DataMatrixCalculator
     */
    public DataMatrixCalculator(){
        variables = new HashMap<>();
    }

    /**
     * put in the Hashmap a new key and element
     */
    public void assign(String name, String values[][] ){
        variables.put(name, new DataMatrix(values) );
    }    
    
    /**
     * Retunr all keys of the HashMap into Array
     */
    public String[] variables() {
       Set<String> variableNames = variables.keySet();
       return variableNames.toArray(new String[variableNames.size()]);
    }

    /**
     * Assigns the value of an operation to a variable (unary operations)
     * @param a is the key of the new element in variables
     * @param b is the key of the DataMatrix in variables
     * @param unary if equals to 's' do shape or if equals to 't' do transpose
     */
    public void assign(String a, char unary, String b){
        DataMatrix matrix = variables.get(b);
        DataMatrix result;
        if(unary == 's'){
            result = matrix.shape();
        }else if(unary == 't'){
            result = matrix.transpose();
        }else{
            String[][] falseMatrix = {{"false"}};
            result = new DataMatrix(falseMatrix);
        }
        
        variables.put(a,result);
    } 
    
    /**
     * Assigns the value of an operation to a variable (simple binary operations)
     * @param a is the key of the new element in variables
     * @param b and c is the key of the DataMatrix's in variables
     * @param sBinary if equals to '+' do add or if equals to '-' do sub
     */
    public void assign(String a, String b, char sBinary, String c){
        DataMatrix matrix1 = variables.get(b);
        DataMatrix matrix2 = variables.get(c);
        DataMatrix result;
        if(sBinary == '+'){
            result = matrix1.add(matrix2);
        }else if(sBinary == '-'){
            result = matrix1.sub(matrix2);
        }else{
            String[][] falseMatrix = {{"false"}};
            result = new DataMatrix(falseMatrix);
        }

        variables.put(a,result);
    }   
    
    /**
     * Returns the string represention of a matrix. 
     */
    public String toString(String variable) {
        if (variables.containsKey(variable)) {
        DataMatrix matrix = variables.get(variable);
        return matrix.toString();
        }else
        throw new IllegalArgumentException("No existe esa variable");
    }
    

    //If the last operation was successful
    public boolean ok(){
        return false;
    }
}
    



