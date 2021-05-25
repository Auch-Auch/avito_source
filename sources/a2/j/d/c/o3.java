package a2.j.d.c;

import a2.b.a.a.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
@GwtCompatible(emulated = true, serializable = true)
public final class o3<E> extends ImmutableSet<E> {
    public final transient E c;
    @LazyInit
    public transient int d;

    public o3(E e) {
        this.c = (E) Preconditions.checkNotNull(e);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i) {
        objArr[i] = this.c;
        return i + 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.c.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.c.hashCode();
        this.d = hashCode;
        return hashCode;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> i() {
        return ImmutableList.of((Object) this.c);
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean j() {
        return this.d != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder I = a.I('[');
        I.append(this.c.toString());
        I.append(']');
        return I.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return Iterators.singletonIterator(this.c);
    }

    public o3(E e, int i) {
        this.c = e;
        this.d = i;
    }
}
