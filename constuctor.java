package OOPs;

class Student{
     String name;
     int grade;
     float marks;
     Student(){
        System.out.println("This is a default constuctor and constuctor is called when is obejct is created");
     }
    //  parameters constuctors
    Student(String name,int grade,float marks)
    {
        this.name = name;
        this.grade = grade;
        this.marks = marks;
    }
    void details()
    {
        System.out.println("Name : "+this.name);
        System.out.println("Grade : "+this.grade);
        System.out.println("Marks : "+this.marks);
    }
}
public class constuctor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Lakshmikant Hunachal";
        s1.grade = 12;
        s1.marks = 95;
        s1.details();
        Student s2 = new Student("Deepa", 12, 97.5f);
        s2.details();
        Student s3 = new Student();
        s3.details();
    }
}
