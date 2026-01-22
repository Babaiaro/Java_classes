public class reverse {
    public static void main(String[] args){
        String original = "this is reverse";
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed);
    }
    
}
