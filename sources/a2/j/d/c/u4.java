package a2.j.d.c;

import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class u4<E> extends h4<E> implements Set<E> {
    private static final long serialVersionUID = 0;

    public u4(Set<E> set, @NullableDecl Object obj) {
        super(set, obj, null);
    }

    /* renamed from: e */
    public Set<E> d() {
        return (Set) ((Collection) this.a);
    }

    @Override // java.lang.Object, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.b) {
            equals = d().equals(obj);
        }
        return equals;
    }

    @Override // java.lang.Object, java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = d().hashCode();
        }
        return hashCode;
    }
}
