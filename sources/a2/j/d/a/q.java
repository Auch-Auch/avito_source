package a2.j.d.a;

import com.google.common.base.Throwables;
import java.util.AbstractList;
public final class q extends AbstractList<StackTraceElement> {
    public final /* synthetic */ Throwable a;

    public q(Throwable th) {
        this.a = th;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return (StackTraceElement) Throwables.a(Throwables.b, Throwables.a, new Object[]{this.a, Integer.valueOf(i)});
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return ((Integer) Throwables.a(Throwables.c, Throwables.a, new Object[]{this.a})).intValue();
    }
}
