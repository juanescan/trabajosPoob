
/**
 * Represents a simple data: boolean ('TRUE', 'FALSE'), numerical (integer or real), character (any character, if it is a digit it is considered numeric)
 *
 * @author ECI-2024-01
 */
public class Data{
    

    private String s;
    private char x;
    
    /**
     * Constructs a new Data given its value, If it is not possible, it is assumed FALSE
     */
    public Data(String s){
        this.s = s;
    }

  
     /**
     * Add the specified data with this data
     */   
    // boolean + boolean. + is OR
    // numerical + numerical. + is +
    // character + character. + is the largest character
    // boolean + numerical. Transform the number to boolean. If 0, false. True otherwise.
    // boolean + character. Transform the boolean to character. TRUE is T and FALSE is F.
    // + is commutative
    public Data add(Data b){
        char t = b.type();
        char t2 = type();
        if(t == 'b' && t2 == 'b'){
            if(s.equalsIgnoreCase("true") || b.string().equalsIgnoreCase("true")){
            return new Data("TRUE");
            }else{
            return new Data("FALSE");
        }
        }else if(t == 'n' && t2 == 'n'){
            double result = Double.parseDouble(s) + Double.parseDouble(b.string());
            return new Data(String.valueOf(result));
        }else if(t == 'c' && t2 == 'c'){
            char result = (char) Math.max(s.charAt(0),b.string().charAt(0));
            return new Data(String.valueOf(result));
        }else if(((t == 'b' && t2 == 'n') || (t == 'n' && t2 == 'b'))){
            return sumBN(b);
        }else if(((t == 'b' && t2 == 'c') || (t == 'c' && t2 == 'b'))){
            return sumBC(b);
        }
        else{
            return null;
        }
    }
    
    
  
     /**
     * Substract the specified data with this data
     */   
    // boolean - boolean. - is AND
    // numerical - numerical. + is -
    // character - character. - is the smaller character
    // boolean - numerical. Transform the number to boolean. If 0, true. False otherwise.
    // boolean - character. Transform the boolean to character. TRUE is T and FALSE is F.
    // + is commutative
    public Data sub(Data b){
        char t = b.type();
        char t2 = type();
        if(t == 'b' && t2 == 'b'){
            if(s.equalsIgnoreCase("true") && b.string().equalsIgnoreCase("true")){
            return new Data("TRUE");
            }else{
            return new Data("FALSE");
            }
        }else if(t == 'n' && t2 == 'n'){
            double result = Double.parseDouble(s) - Double.parseDouble(b.string());
            return new Data(String.valueOf(result));
        }else if(t == 'c' && t2 == 'c'){
            char result = (char) Math.min(s.charAt(0),b.string().charAt(0));
            return new Data(String.valueOf(result));
        }else if(((t == 'b' && t2 == 'n') || (t == 'n' && t2 == 'b'))){
            return resBN(b);
        }else if(((t == 'b' && t2 == 'c') || (t == 'c' && t2 == 'b'))){
            return resBC(b);
        }else{
            return null;
        }
    }
    
    /**
     * Returns the data type
     * @returns 'b', 'n', or 'c'
     */
    public char type(){
        s = string();
        x = '?';
        if(isBoolean()){
            x = 'b';
        }
        else if(isNumeric()){
            x = 'n';
        }
        else if(isChar()){
            x = 'c';
        }
        
        return x;
    }
    
    @Override
    /**
     * Return the string representation of the data, not the original string
     */
    public String toString () {
          x = type();
          if(x == 'b'){
                s = string();
                s = s.toUpperCase();
          }
          else if(x == 'c'){
              s = string();
          }
          else if(x == 'n'){
              s = string();
          }
          else if(x == '?'){
              s = "FALSE";
          }
          return s;
    }   
    
     /**
     * Return the string used to create the Data without leading or trailing blanks
     */   
    public String string() {
          return s.trim();
    }  
    
    /**
     * Check if the two data is equal
     */
    public boolean equals(Data a){
        string();
        char t = a.type();
        char t2 = type();
        boolean resultado = false;
        if(t == 'c' && t2 == 'c' && s.equals(a.string())) {
            resultado = true;
        }
        else if(t == 'b' && t2 == 'b' && s.equalsIgnoreCase(a.string())){
            resultado = true;
        }
        else if(t == 'n' && t2 == 'n' && Double.parseDouble(s) == Double.parseDouble(a.string())){
            resultado = true;
        }
        
        return resultado;
    }
    
    /**
     * Check is the data is boolean type
     */
    private boolean isBoolean(){
        if (s.equalsIgnoreCase("true") ||s.equalsIgnoreCase("false")){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Check is the data is numeric type
     */
    private boolean isNumeric(){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Check is the data is character type
     */
    private boolean isChar(){
        if (s.length() == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Sum of boolean and numeric data
     */
    private Data sumBN(Data b){
        char t = b.type();
        char t2 = type();
        if(t == 'b' && t2 == 'n'){
            if(s.equalsIgnoreCase("0") && b.string().equalsIgnoreCase("false") ){
                return new Data("FALSE");
            }
        }else if(t == 'n' && t2 == 'b'){
            if(s.equalsIgnoreCase("false") && b.string().equals("0")){
            return new Data("FALSE");
            }
        }
        return new Data("TRUE");
    }
    
    /**
     * Sum of boolean and char data
     */
    private Data sumBC(Data b){
        String charge;
        if(b.string().equalsIgnoreCase("true") || (string().equalsIgnoreCase("true"))){
                charge ="T";
            }
            else{
                charge ="F";
            }
            char result = (char) Math.max(s.charAt(0),b.string().charAt(0));
            return new Data(String.valueOf(result));
    }
    
    /**
     * Rest of boolean and numeric data
     */
    private Data resBN(Data b){
        char t = b.type();
        char t2 = type();
        if(t == 'b' && t2 == 'n'){
            if(s.equalsIgnoreCase("0") && b.string().equalsIgnoreCase("true") ){
                return new Data("TRUE");
            }
        }else if(t == 'n' && t2 == 'b'){
            if(s.equalsIgnoreCase("true") && b.string().equals("0")){
            return new Data("TRUE");
            }
        }
        return new Data("FALSE");
    }
    
    /**
     * Rest of boolean and numeric data
     */
    private Data resBC(Data b){
        String charge;
        if(b.string().equalsIgnoreCase("true") || (string().equalsIgnoreCase("true"))){
                charge ="T";
            }
            else{
                charge ="F";
            }
            char result = (char) Math.min(s.charAt(0),b.string().charAt(0));
            return new Data(String.valueOf(result));
    }
}

