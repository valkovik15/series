public class Model {
    private Series obj;
    public Model()
    {
        obj=new Liner();
    }
    public Series getData() {
        return obj;
    }
    public void changeType(int typ)
    {
        if(typ==0)
            obj=new Liner(getData().getA0(), getData().getQ(), getData().getN());
        else
            obj=new Exponential(getData().getA0(), getData().getQ(), getData().getN());
    }
}
