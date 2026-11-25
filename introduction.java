package OOPs;
class Animal{
    // class are blueprint of the object
    int eye;
    int ears;
    // above variable are called as propertiers of the class
    void walk(){
        System.out.println("Animals walk in many differnt type");
    }
    void type()
    {
        System.out.println("Animal are many types are there in world");
    }
}
public class introduction {
    public static void main(String[] args) {
        Animal cow = new Animal();
        // object is real world entity
        cow.type();
        cow.walk();
        cow.eye=2;
        System.out.println("Cows having "+cow.eye+" eyes");
    }
}
