package jun.error;

public class thrown {
    static void checkAge(int age) throws IllegalAccessException{
        if(age < 18){
            throw new IllegalAccessException("Must be 18 or older");
        }
        System.out.println("Access granted, age " + age);
    }
    
    public static void main(String[] args) {
        try {
            checkAge(25);
        } catch (IllegalAccessException e) {
            System.out.println("Caught: " + e.getMessage());

        }
    }
}
