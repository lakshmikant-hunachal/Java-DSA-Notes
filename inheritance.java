package OOPs;
// single level inheritance 
class Father{
    String name;
    void money()
    {
        System.out.println("Money for my children");
    }

}
class son extends Father{
   String name;
   void money(){
    System.out.println("i have money from my father ans my money");
   }
}
public class inheritance {
    public static void main(String[] args) {
        son s1 = new son();
        s1.money();
    }
}
// Multilevel inheritance
// hierarchial inheritance
// multiple inheritance is not possible in java 
// but it is possible using interfaces

