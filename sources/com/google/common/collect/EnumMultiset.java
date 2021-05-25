package com.google.common.collect;

import a2.j.d.c.i;
import a2.j.d.c.r0;
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
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends i<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient Class<E> c;
    public transient E[] d;
    public transient int[] e;
    public transient int f;
    public transient long g;

    public class a extends EnumMultiset<E>.c {
        public a() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        public Object a(int i) {
            return EnumMultiset.this.d[i];
        }
    }

    public class b extends EnumMultiset<E>.c {
        public b() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        public Object a(int i) {
            return new r0(this, i);
        }
    }

    public abstract class c<T> implements Iterator<T> {
        public int a = 0;
        public int b = -1;

        public c() {
        }

        public abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                int i = this.a;
                EnumMultiset enumMultiset = EnumMultiset.this;
                if (i >= enumMultiset.d.length) {
                    return false;
                }
                if (enumMultiset.e[i] > 0) {
                    return true;
                }
                this.a = i + 1;
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a3 = a(this.a);
                int i = this.a;
                this.b = i;
                this.a = i + 1;
                return a3;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b >= 0, "no calls to next() since the last call to remove()");
            EnumMultiset enumMultiset = EnumMultiset.this;
            int[] iArr = enumMultiset.e;
            int i = this.b;
            if (iArr[i] > 0) {
                enumMultiset.f--;
                enumMultiset.g -= (long) iArr[i];
                iArr[i] = 0;
            }
            this.b = -1;
        }
    }

    public EnumMultiset(Class<E> cls) {
        this.c = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.d = enumConstants;
        this.e = new int[enumConstants.length];
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.c = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.d = enumConstants;
        this.e = new int[enumConstants.length];
        AppCompatDelegateImpl.i.B1(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c);
        AppCompatDelegateImpl.i.v2(this, objectOutputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int add(Object obj, int i) {
        return add((EnumMultiset<E>) ((Enum) obj), i);
    }

    @Override // a2.j.d.c.i
    public int b() {
        return this.f;
    }

    @Override // a2.j.d.c.i
    public Iterator<E> c() {
        return new a();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.e, 0);
        this.g = 0;
        this.f = 0;
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        if (obj == null || !f(obj)) {
            return 0;
        }
        return this.e[((Enum) obj).ordinal()];
    }

    @Override // a2.j.d.c.i
    public Iterator<Multiset.Entry<E>> d() {
        return new b();
    }

    public void e(@NullableDecl Object obj) {
        Preconditions.checkNotNull(obj);
        if (!f(obj)) {
            StringBuilder L = a2.b.a.a.a.L("Expected an ");
            L.append(this.c);
            L.append(" but got ");
            L.append(obj);
            throw new ClassCastException(L.toString());
        }
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo6elementSet() {
        return super.mo6elementSet();
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final boolean f(@NullableDecl Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        int ordinal = r5.ordinal();
        E[] eArr = this.d;
        if (ordinal >= eArr.length || eArr[ordinal] != r5) {
            return false;
        }
        return true;
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return new Multisets.k(this, entrySet().iterator());
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        if (obj == null || !f(obj)) {
            return 0;
        }
        Enum r1 = (Enum) obj;
        AppCompatDelegateImpl.i.z(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.e;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.f--;
            this.g -= (long) i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.g -= (long) i;
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.g);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @CanIgnoreReturnValue
    public int add(E e2, int i) {
        e(e2);
        AppCompatDelegateImpl.i.z(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        int ordinal = e2.ordinal();
        int i2 = this.e[ordinal];
        long j = (long) i;
        long j2 = ((long) i2) + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.e[ordinal] = (int) j2;
        if (i2 == 0) {
            this.f++;
        }
        this.g += j;
        return i2;
    }

    @CanIgnoreReturnValue
    public int setCount(E e2, int i) {
        e(e2);
        AppCompatDelegateImpl.i.z(i, "count");
        int ordinal = e2.ordinal();
        int[] iArr = this.e;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.g += (long) (i - i2);
        if (i2 == 0 && i > 0) {
            this.f++;
        } else if (i2 > 0 && i == 0) {
            this.f--;
        }
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }
}
