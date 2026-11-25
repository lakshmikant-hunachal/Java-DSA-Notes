package OOPs;

import java.util.Scanner;

class Complex{
    int real;
    int img;
    Complex(int real,int img)
    {
        this.real = real;
        this.img = img;
    }

    Complex add(Complex c)
    {
        return new Complex(this.real+c.real, this.img+c.img);
    }

    Complex diff(Complex c)
    {
        return new Complex(this.real-c.real, this.img-c.img);
    }
    Complex product(Complex c)
    {
        return new Complex(this.real*c.real-this.img*c.img,this.real*c.img+c.real*this.img);
    }

    void print(){
        if(img>=0)
            System.out.println(real+"+"+img+"i");
        else
            System.out.println(real+"-"+img+"i");
    }
}
public class complexNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first complex number real and imagenary values");
        int r1 = sc.nextInt();
        int i1 = sc.nextInt();
        Complex c1 = new Complex(r1, i1);

        System.out.println("Enter second complex number real and imagenary values");
        int r2 = sc.nextInt();
        int i2 = sc.nextInt();
        Complex c2 = new Complex(r2, i2);

        Complex sum = c1.add(c2);
        Complex d = c1.diff(c2);
        Complex pro = c1.product(c2);

        c1.print();
        c2.print();
        
        sum.print();
        d.print();
        pro.print();
        
    }
}
