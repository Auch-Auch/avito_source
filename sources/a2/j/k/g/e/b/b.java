package a2.j.k.g.e.b;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
public final class b {
    public final List<a> a;
    public final int b;
    public final boolean c;

    public b(List<a> list, int i, boolean z) {
        this.a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.a.equals(bVar.a) || this.c != bVar.c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return a.w(new StringBuilder("{ "), this.a, " }");
    }
}
