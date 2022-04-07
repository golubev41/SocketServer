public class v2 {
    public static double func(double x, double y,double a, double w){
        return ((Math.abs(x-y))/Math.pow(a,(1+2*x)))-Math.exp(1+w);
    }
}
