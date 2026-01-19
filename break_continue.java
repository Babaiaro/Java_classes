public class break_continue {
    public static void main (String[] args){
        for (int i=1; i<6; i++){
            if(i==2){
                continue;
            }
            if(i==4){
                break;
            }
            System.out.println(i);
        }

    }
    
}
