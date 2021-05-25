package a2.j.d.c;

import a2.b.a.a.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
@GwtCompatible(serializable = true)
public final class g0<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<? super T>[] a;

    public g0(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.a = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        int i = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.a;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i].compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            return Arrays.equals(this.a, ((g0) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.lang.Object
    public String toString() {
        return a.t(a.L("Ordering.compound("), Arrays.toString(this.a), ")");
    }

    public g0(Iterable<? extends Comparator<? super T>> iterable) {
        this.a = (Comparator[]) Iterables.d(iterable, new Comparator[0]);
    }
}
