package y6.a.a;
public class a {
    public volatile boolean a;

    public synchronized void a() {
        this.a = false;
    }

    public synchronized void b() {
        boolean z = this.a;
        this.a = true;
        if (!z) {
            notify();
        }
    }
}
