package a2.j.b.e.a.b;

import java.util.HashMap;
import java.util.Map;
public final class t0 {
    public final Map<String, Double> a = new HashMap();

    public final synchronized void a(String str) {
        this.a.put(str, Double.valueOf(0.0d));
    }

    public final synchronized double b(String str) {
        Double d = this.a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
