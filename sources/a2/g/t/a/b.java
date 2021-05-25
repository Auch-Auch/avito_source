package a2.g.t.a;
public class b {
    public final int a;
    public double b = -1.0d;
    public int c;

    public b(double d) {
        int i;
        if (d == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.a = i;
    }

    public void a(double d) {
        int i = this.c;
        if (i > this.a) {
            this.b = Math.exp((Math.log(d) * 0.05d) + (Math.log(this.b) * 0.95d));
        } else if (i > 0) {
            double d2 = (double) i;
            double d3 = (0.95d * d2) / (d2 + 1.0d);
            this.b = Math.exp((Math.log(d) * (1.0d - d3)) + (Math.log(this.b) * d3));
        } else {
            this.b = d;
        }
        this.c++;
    }
}
