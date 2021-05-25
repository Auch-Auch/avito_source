package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public class j4<K, V> extends r4 implements Map.Entry<K, V> {
    private static final long serialVersionUID = 0;

    public j4(Map.Entry<K, V> entry, @NullableDecl Object obj) {
        super(entry, obj);
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.b) {
            equals = ((Map.Entry) this.a).equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        K k;
        synchronized (this.b) {
            k = (K) ((Map.Entry) this.a).getKey();
        }
        return k;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        V v;
        synchronized (this.b) {
            v = (V) ((Map.Entry) this.a).getValue();
        }
        return v;
    }

    @Override // java.lang.Object, java.util.Map.Entry
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = ((Map.Entry) this.a).hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        V v2;
        synchronized (this.b) {
            v2 = (V) ((Map.Entry) this.a).setValue(v);
        }
        return v2;
    }
}
