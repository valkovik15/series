public class Liner extends Series {
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