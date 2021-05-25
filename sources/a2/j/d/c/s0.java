package a2.j.d.c;

import a2.b.a.a.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class s0<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final ImmutableMap<T, Integer> a;

    public s0(List<T> list) {
        this.a = Maps.h(list);
    }

    public final int b(T t) {
        Integer num = this.a.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.c(t);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return b(t) - b(t2);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof s0) {
            return this.a.equals(((s0) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("Ordering.explicit(");
        L.append(this.a.keySet());
        L.append(")");
        return L.toString();
    }
}
