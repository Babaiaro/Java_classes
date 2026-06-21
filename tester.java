package jun.error;

public class tester {
    public static void main(String[] args) {
        try {
            test();
        } catch ( ApplicationException e) {
            e.printStackTrace();
        }
        
    }
    public static void test() throws ApplicationException{
        try {
            int a = 0;
            int b = 1; 
            System.out.println(b/a);
        } catch (Exception e) {
            throw new ApplicationException("Chained Exception", e);
        }
    }     
}
 class ApplicationException extends Exception{
        public ApplicationException(String message, Exception cause){
            super(message, cause);
        }
}
