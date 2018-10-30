import javax.swing.*;
import java.awt.*;
import java.io.*;
abstract class Series
{
    protected double a0;
    protected double q;
    public abstract double countJ(int j);
    public double countSum(int limit)
    {
        double sum=a0;
        for(int i=1; i<limit; i++)
        {
            sum+=countJ(i);
        }
        return sum;
    }
    public String toString(int j) {
        StringBuffer s= new StringBuffer();
        s.append(a0+" ");
        for(int i=1; i<j-1; i++)
        {
            s.append(countJ(j));
            s.append(" ");
        }
        s.append(countJ(j));
        return s.toString();
    }
    public void writeToFile(int j)
    {
        {

            try(FileWriter writer = new FileWriter("Series.txt", false))
            {
                // запись всей строки
                String text = toString(j);
                writer.write(text);
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex);
            }
        }
    }
}
class Liner extends Series
{
    public double countJ(int j)
    {
        return a0+q*j;
    }
}
class Exponential extends Series
{
    public double countJ(int j)
    {
        return a0*Math.pow(q,j);
    }
}
public class Main {

    public static void main(String[] args) {
        MyForm f=new MyForm();
        f.pack();
        f.setSize(new Dimension(500, 500));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
