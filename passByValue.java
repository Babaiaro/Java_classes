public class passByValue {

    public static void main(String[] args){
        int a = 5;
        int b = a;
        doSomething(b);
        System.out.printf("$d $d", a, b);
    }

    private static void doSomething(int temp){
        temp = 10;
        
    }
}
