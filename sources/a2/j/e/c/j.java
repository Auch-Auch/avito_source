package a2.j.e.c;
public class j {
    public final Class<?> a;
    public final boolean b;

    public j(Class cls, boolean z, h hVar) {
        this.a = cls;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!jVar.a.equals(this.a) || jVar.b != this.b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
    }
}
