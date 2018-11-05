import javax.swing.*;
import java.awt.*;
import java.io.*;

abstract class Series {
    private double a0;
    private double q;
    private int n;

    public abstract double countJ(int j);

    public Series()
    {
        a0=0;
        q=0;
        n=0;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public int getN() {
        return n;
    }

    public void setA0(double a0) {
        this.a0 = a0;
    }

    public double getA0() {
        return a0;
    }

    public double getQ() {
        return q;
    }

    public double countSum(int limit) {
        double sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += countJ(i);
        }
        return sum;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(a0 + " ");
        for (int i = 1; i < 5; i++) {
            s.append(countJ(i));
            s.append(" ");
        }
        return s.toString();
    }

    public void writeToFile(int j, String adress) {
        {

            try (FileWriter writer = new FileWriter(adress, false)) {
                // запись всей строки
                String text = toString();
                writer.write(text);
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex);
            }
        }
    }
}

class Liner extends Series {
    public double countJ(int j) {
        if (j == 0)
            return getA0();
        return getA0() + getQ() * j;
    }

    public Liner(double a, double b, int c)
    {
        setQ(b);
        setA0(a);
        setN(c);
    }

    public Liner() {
        setQ(0);
        setA0(0);
        setN(0);
    }

}

class Exponential extends Series {
    public double countJ(int j) {
        if (j == 0)
            return getA0();
        return getA0() * Math.pow(getQ(), j);

    }
    public Exponential(double a, double b, int c)
    {
        setQ(b);
        setA0(a);
        setN(c);
    }

    public Exponential() {
        setQ(0);
        setA0(0);
        setN(0);
    }
}
class Model {
    private Series obj;
    public Model()
    {
        obj=new Liner();
    }
    public Series getObj() {
        return obj;
    }
    public void changeType(int typ)
    {
        if(typ==0)
            obj=new Liner(getObj().getA0(), getObj().getQ(), getObj().getN());
        else
            obj=new Exponential(getObj().getA0(), getObj().getQ(), getObj().getN());
    }
}

    public class Demo {
        static void init() {
            Ser = new Model();
        }

        static Model Ser;

        public static void main(String[] args) {
            init();
            MyForm f = new MyForm();
            f.pack();
            f.setSize(new Dimension(500, 500));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        }
    }
