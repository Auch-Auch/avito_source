package com.google.common.collect;

import a2.j.d.c.d3;
import a2.j.d.c.o3;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    @NullableDecl
    @RetainedWith
    @LazyInit
    public transient ImmutableList<E> b;

    public static class Builder<E> extends ImmutableCollection.a<E> {
        @VisibleForTesting
        @NullableDecl
        public Object[] d;
        public int e;

        public Builder() {
            super(4);
        }

        public Builder(int i) {
            super(i);
            this.d = new Object[ImmutableSet.f(i)];
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> immutableSet;
            int i = this.b;
            if (i == 0) {
                return ImmutableSet.of();
            }
            boolean z = false;
            if (i == 1) {
                return ImmutableSet.of(this.a[0]);
            }
            if (this.d == null || ImmutableSet.f(i) != this.d.length) {
                immutableSet = ImmutableSet.h(this.b, this.a);
                this.b = immutableSet.size();
            } else {
                int i2 = this.b;
                Object[] objArr = this.a;
                int length = objArr.length;
                if (i2 < (length >> 1) + (length >> 2)) {
                    z = true;
                }
                if (z) {
                    objArr = Arrays.copyOf(objArr, i2);
                }
                int i3 = this.e;
                Object[] objArr2 = this.d;
                immutableSet = new d3<>(objArr, i3, objArr2, objArr2.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return immutableSet;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableSet$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.d != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e2) {
            Preconditions.checkNotNull(e2);
            if (this.d != null) {
                int f = ImmutableSet.f(this.b);
                Object[] objArr = this.d;
                if (f <= objArr.length) {
                    int length = objArr.length - 1;
                    int hashCode = e2.hashCode();
                    int V1 = AppCompatDelegateImpl.i.V1(hashCode);
                    while (true) {
                        int i = V1 & length;
                        Object[] objArr2 = this.d;
                        Object obj = objArr2[i];
                        if (obj == null) {
                            objArr2[i] = e2;
                            this.e += hashCode;
                            super.add((Builder<E>) e2);
                            break;
                        } else if (obj.equals(e2)) {
                            break;
                        } else {
                            V1 = i + 1;
                        }
                    }
                    return this;
                }
            }
            this.d = null;
            super.add((Builder<E>) e2);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableSet$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.d != null) {
                for (E e2 : eArr) {
                    add((Builder<E>) e2);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }
    }

    public static class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.a);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i) {
        AppCompatDelegateImpl.i.z(i, "expectedSize");
        return new Builder<>(i);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.e()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return h(array.length, array);
    }

    @VisibleForTesting
    public static int f(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        Preconditions.checkArgument(z, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> h(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        boolean z = false;
        if (i == 1) {
            return of(objArr[0]);
        }
        int f = f(i);
        Object[] objArr2 = new Object[f];
        int i2 = f - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            ObjectArrays.a(obj, i5);
            int hashCode = obj.hashCode();
            int V1 = AppCompatDelegateImpl.i.V1(hashCode);
            while (true) {
                int i6 = V1 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += hashCode;
                    i4++;
                    break;
                } else if (obj2.equals(obj)) {
                    break;
                } else {
                    V1++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new o3(objArr[0], i3);
        }
        if (f(i4) < f / 2) {
            return h(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            z = true;
        }
        if (z) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new d3(objArr, i3, objArr2, i2, i4);
    }

    public static <E> ImmutableSet<E> of() {
        return d3.h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> i = i();
        this.b = i;
        return i;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !j() || !((ImmutableSet) obj).j() || hashCode() == obj.hashCode()) {
            return Sets.a(this, obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    public ImmutableList<E> i() {
        return ImmutableList.f(toArray());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public abstract UnmodifiableIterator<E> mo99iterator();

    public boolean j() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new a(toArray());
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new o3(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return h(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return h(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return h(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return h(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return h(length, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.common.collect.ImmutableSet$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return of(next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return h(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
