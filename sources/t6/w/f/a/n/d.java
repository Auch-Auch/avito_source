package t6.w.f.a.n;

import java.io.Serializable;
public final class d<K, V> implements Serializable {
    public final K a;
    public final V b;

    public d(K k, V v) {
        this.a = k;
        this.b = v;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        K k = this.a;
        if (k == null) {
            if (dVar.a != null) {
                return false;
            }
        } else if (!k.equals(dVar.a)) {
            return false;
        }
        V v = this.b;
        V v2 = dVar.b;
        if (v == null) {
            if (v2 != null) {
                return false;
            }
        } else if (!v.equals(v2)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        K k = this.a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.lang.Object
    public String toString() {
        return ((Object) this.a) + "=" + ((Object) this.b);
    }
}
