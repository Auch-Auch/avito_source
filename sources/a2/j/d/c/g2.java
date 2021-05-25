package a2.j.d.c;

import java.util.Iterator;
import java.util.Map;
public final class g2 extends b5<Map.Entry<K, V>, K> {
    public g2(Iterator it) {
        super(it);
    }

    @Override // a2.j.d.c.b5
    public Object a(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
