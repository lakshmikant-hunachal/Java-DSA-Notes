package OOPs;
class Men{
    int height;
    String name;
    private int age;
    Men(int height,String name)
    {
        this.height=height;
        this.name=name;
    }
    void setter(int age)
    {
        this.age=age;
    }
    int getter()
    {
        return this.age;
    }
    void habbit(){
       System.out.println("Human contain  many type of the habbit ");
    }

}
public class AccesModifiers {
    public static void main(String[] args) {
        Men m1 = new Men(172, "Lakshmikant Hunachal");
        // private variables can not acces directly outside the class but access using helper methods
        // those are getter and setter methods
        m1.habbit();
        m1.setter(20);
        System.out.println("Age :"+m1.getter());
        System.out.println("Name :"+m1.name+ " Height : "+m1.height);
    }
}
// Four types of the Access modifiers
// PUblic,private,protected,default
