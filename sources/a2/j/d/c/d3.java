package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class d3<E> extends ImmutableSet<E> {
    public static final d3<Object> h = new d3<>(new Object[0], 0, null, 0, 0);
    @VisibleForTesting
    public final transient Object[] c;
    @VisibleForTesting
    public final transient Object[] d;
    public final transient int e;
    public final transient int f;
    public final transient int g;

    public d3(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.c = objArr;
        this.d = objArr2;
        this.e = i2;
        this.f = i;
        this.g = i3;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.c, 0, objArr, i, this.g);
        return i + this.g;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.g;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.d;
        if (obj == null || objArr == null) {
            return false;
        }
        int W1 = AppCompatDelegateImpl.i.W1(obj);
        while (true) {
            int i = W1 & this.e;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            W1 = i + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int d() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> i() {
        return ImmutableList.h(this.c, this.g);
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.g;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return asList().mo99iterator();
    }
}
