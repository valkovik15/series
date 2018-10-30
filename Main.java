import javax.swing.*;
import java.awt.*;
import java.io.*;

abstract class Series {
    protected double a0;
    protected double q;

    public abstract double countJ(int j);

    public double countSum(int limit) {
        double sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += countJ(i);
        }
        return sum;
    }

    public String toString(int j) {
        StringBuffer s = new StringBuffer();
        s.append(a0 + " ");
        for (int i = 1; i < j - 1; i++) {
            s.append(countJ(i));
            s.append(" ");
        }
        s.append(countJ(j));
        return s.toString();
    }

    public void writeToFile(int j, String adress) {
        {

            try (FileWriter writer = new FileWriter(adress, false)) {
                // запись всей строки
                String text = toString(j);
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
            return a0;
        return a0 + q * j;
    }

    public Liner(double a, double zn) {
        a0 = a;
        q = zn;
    }
}

class Exponential extends Series {
    public double countJ(int j) {
        if (j == 0)
            return a0;
        return a0 * Math.pow(q, j);

    }

    public Exponential(double a, double zn) {
        a0 = a;
        q = zn;

    }
}

public class Main {
     static void init() {
        Liner Arithm = new Liner(a, q);
        Exponential Geom = new Exponential(a, q);
        series[0] = Arithm;
        series[1] = Geom;
    }

    static int type = 0;
    static double q = 2;
    static int a = 1;
    static int n = 0;
    static Series[] series = new Series[2];

    public static void main(String[] args) {
        init();
        MyForm f = new MyForm();
        f.pack();
        f.setSize(new Dimension(500, 500));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
