package a2.j.d.c;

import a2.j.d.c.v2;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class f<E> extends i<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient v2<E> c;
    public transient long d;

    public class a extends f<E>.c {
        public a() {
            super();
        }

        @Override // a2.j.d.c.f.c
        public E a(int i) {
            v2<E> v2Var = f.this.c;
            Preconditions.checkElementIndex(i, v2Var.c);
            return (E) v2Var.a[i];
        }
    }

    public class b extends f<E>.c {
        public b() {
            super();
        }

        @Override // a2.j.d.c.f.c
        public Object a(int i) {
            v2<E> v2Var = f.this.c;
            Preconditions.checkElementIndex(i, v2Var.c);
            return new v2.a(i);
        }
    }

    public abstract class c<T> implements Iterator<T> {
        public int a;
        public int b = -1;
        public int c;

        public c() {
            this.a = f.this.c.c();
            this.c = f.this.c.d;
        }

        public abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (f.this.c.d == this.c) {
                return this.a >= 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a3 = a(this.a);
                int i = this.a;
                this.b = i;
                this.a = f.this.c.m(i);
                return a3;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (f.this.c.d == this.c) {
                Preconditions.checkState(this.b != -1, "no calls to next() since the last call to remove()");
                f fVar = f.this;
                fVar.d -= (long) fVar.c.q(this.b);
                this.a = f.this.c.n(this.a, this.b);
                this.b = -1;
                this.c = f.this.c.d;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public f(int i) {
        e(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: a2.j.d.c.f<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        e(3);
        for (int i = 0; i < readInt; i++) {
            add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AppCompatDelegateImpl.i.v2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        boolean z = true;
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int i2 = this.c.i(e);
        if (i2 == -1) {
            this.c.o(e, i);
            this.d += (long) i;
            return 0;
        }
        int g = this.c.g(i2);
        long j = (long) i;
        long j2 = ((long) g) + j;
        if (j2 > 2147483647L) {
            z = false;
        }
        Preconditions.checkArgument(z, "too many occurrences: %s", j2);
        this.c.t(i2, (int) j2);
        this.d += j;
        return g;
    }

    @Override // a2.j.d.c.i
    public final int b() {
        return this.c.c;
    }

    @Override // a2.j.d.c.i
    public final Iterator<E> c() {
        return new a();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.c.a();
        this.d = 0;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.c.d(obj);
    }

    @Override // a2.j.d.c.i
    public final Iterator<Multiset.Entry<E>> d() {
        return new b();
    }

    public abstract void e(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return new Multisets.k(this, entrySet().iterator());
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int i2 = this.c.i(obj);
        if (i2 == -1) {
            return 0;
        }
        int g = this.c.g(i2);
        if (g > i) {
            this.c.t(i2, g - i);
        } else {
            this.c.q(i2);
            i = g;
        }
        this.d -= (long) i;
        return g;
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i) {
        int i2;
        AppCompatDelegateImpl.i.z(i, "count");
        v2<E> v2Var = this.c;
        if (i == 0) {
            Objects.requireNonNull(v2Var);
            i2 = v2Var.p(e, AppCompatDelegateImpl.i.W1(e));
        } else {
            i2 = v2Var.o(e, i);
        }
        this.d += (long) (i - i2);
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.d);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E e, int i, int i2) {
        AppCompatDelegateImpl.i.z(i, "oldCount");
        AppCompatDelegateImpl.i.z(i2, "newCount");
        int i3 = this.c.i(e);
        if (i3 == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.c.o(e, i2);
                this.d += (long) i2;
            }
            return true;
        } else if (this.c.g(i3) != i) {
            return false;
        } else {
            if (i2 == 0) {
                this.c.q(i3);
                this.d -= (long) i;
            } else {
                this.c.t(i3, i2);
                this.d += (long) (i2 - i);
            }
            return true;
        }
    }
}
