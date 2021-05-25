package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
@GwtCompatible(emulated = true, serializable = true)
public class a3<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> e = new a3(new Object[0], 0);
    @VisibleForTesting
    public final transient Object[] c;
    public final transient int d;

    public a3(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.c, 0, objArr, i, this.d);
        return i + this.d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int d() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // java.util.List
    public E get(int i) {
        Preconditions.checkElementIndex(i, this.d);
        return (E) this.c[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.d;
    }
}
