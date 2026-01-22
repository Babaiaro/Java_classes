public class reverse_loop {
    public static void main(String[] args){
        String original = " here another reverse";
        String reversed = " ";
        for(int i = original.length()-1; i >= 0; i--){
            reversed += original.charAt(i);
        }
        System.out.println(reversed);
    }
    
}
