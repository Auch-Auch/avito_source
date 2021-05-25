package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
@GwtCompatible(serializable = true)
public final class f5 extends Ordering<Object> implements Serializable {
    public static final f5 a = new f5();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.usingToString()";
    }
}
