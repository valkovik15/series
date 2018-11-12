import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    private double a0;
    private double q;
    private int n;

    public abstract double countJ(int j);

    //public Series()
    //{
     //   a0=0;
      //  q=0;
       // n=0;
    //}

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

    public void writeToFile( String adress) throws IOException {
        {

            try (FileWriter writer = new FileWriter(adress, false)) {
                // запись всей строки
                String text = toString();
                writer.write(text);
                writer.flush();
            }
        }
    }
}
