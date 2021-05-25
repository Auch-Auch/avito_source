package bolts;
public class Capture<T> {
    public T a;

    public Capture() {
    }

    public T get() {
        return this.a;
    }

    public void set(T t) {
        this.a = t;
    }

    public Capture(T t) {
        this.a = t;
    }
}
