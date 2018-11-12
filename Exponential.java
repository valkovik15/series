public class Exponential extends Series {
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