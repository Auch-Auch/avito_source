package com.google.common.collect;

import a2.j.d.c.e3;
import a2.j.d.c.f3;
import a2.j.d.c.k0;
import a2.j.d.c.p1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends p1<E> implements SortedMultiset<E> {
    @LazyInit
    public transient ImmutableSortedMultiset<E> e;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        public final Comparator<? super E> d;
        @VisibleForTesting
        public E[] e = ((E[]) new Object[4]);
        public int[] f = new int[4];
        public int g;
        public boolean h;

        public Builder(Comparator<? super E> comparator) {
            super(true);
            this.d = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public final void b(boolean z) {
            int i = this.g;
            if (i != 0) {
                E[] eArr = (E[]) Arrays.copyOf(this.e, i);
                Arrays.sort(eArr, this.d);
                int i2 = 1;
                for (int i3 = 1; i3 < eArr.length; i3++) {
                    if (this.d.compare(eArr[i2 - 1], eArr[i3]) < 0) {
                        eArr[i2] = eArr[i3];
                        i2++;
                    }
                }
                Arrays.fill(eArr, i2, this.g, (Object) null);
                if (z) {
                    int i4 = i2 * 4;
                    int i5 = this.g;
                    if (i4 > i5 * 3) {
                        eArr = (E[]) Arrays.copyOf(eArr, IntMath.saturatedAdd(i5, (i5 / 2) + 1));
                    }
                }
                int[] iArr = new int[eArr.length];
                for (int i6 = 0; i6 < this.g; i6++) {
                    int binarySearch = Arrays.binarySearch(eArr, 0, i2, this.e[i6], this.d);
                    int[] iArr2 = this.f;
                    if (iArr2[i6] >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + iArr2[i6];
                    } else {
                        iArr[binarySearch] = ~iArr2[i6];
                    }
                }
                this.e = eArr;
                this.f = iArr;
                this.g = i2;
            }
        }

        public final void c() {
            int i = this.g;
            E[] eArr = this.e;
            if (i == eArr.length) {
                b(true);
            } else if (this.h) {
                this.e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.h = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e2, int i) {
            Preconditions.checkNotNull(e2);
            AppCompatDelegateImpl.i.z(i, "occurrences");
            if (i == 0) {
                return this;
            }
            c();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e2;
            this.f[i2] = i;
            this.g = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> setCount(E e2, int i) {
            Preconditions.checkNotNull(e2);
            AppCompatDelegateImpl.i.z(i, "count");
            c();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e2;
            this.f[i2] = ~i;
            this.g = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedMultiset<E> build() {
            int i;
            b(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = this.g;
                if (i2 >= i) {
                    break;
                }
                int[] iArr = this.f;
                if (iArr[i2] > 0) {
                    E[] eArr = this.e;
                    eArr[i3] = eArr[i2];
                    iArr[i3] = iArr[i2];
                    i3++;
                }
                i2++;
            }
            Arrays.fill(this.e, i3, i, (Object) null);
            Arrays.fill(this.f, i3, this.g, 0);
            this.g = i3;
            if (i3 == 0) {
                return ImmutableSortedMultiset.j(this.d);
            }
            f3 f3Var = (f3) ImmutableSortedSet.l(this.d, i3, this.e);
            long[] jArr = new long[(this.g + 1)];
            int i4 = 0;
            while (i4 < this.g) {
                int i5 = i4 + 1;
                jArr[i5] = jArr[i4] + ((long) this.f[i4]);
                i4 = i5;
            }
            this.h = true;
            return new e3(f3Var, jArr, 0, this.g);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e2) {
            return addCopies((Builder<E>) e2, 1);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableSortedMultiset$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : ((Multiset) iterable).entrySet()) {
                    addCopies((Builder<E>) entry.getElement(), entry.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E e2 : eArr) {
                add((Builder<E>) e2);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableSortedMultiset$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }
    }

    public static final class a<E> implements Serializable {
        public final Comparator<? super E> a;
        public final E[] b;
        public final int[] c;

        public a(SortedMultiset<E> sortedMultiset) {
            this.a = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.b = (E[]) new Object[size];
            this.c = new int[size];
            int i = 0;
            for (Multiset.Entry<E> entry : sortedMultiset.entrySet()) {
                this.b[i] = entry.getElement();
                this.c[i] = entry.getCount();
                i++;
            }
        }

        public Object readResolve() {
            int length = this.b.length;
            Builder builder = new Builder(this.a);
            for (int i = 0; i < length; i++) {
                builder.addCopies((Builder) this.b[i], this.c[i]);
            }
            return builder.build();
        }
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return i(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> i(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return j(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i = 0;
        for (Multiset.Entry<E> entry : collection) {
            builder.add((ImmutableList.Builder) entry.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + ((long) entry.getCount());
            i = i2;
        }
        return new e3(new f3(builder.build(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> j(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) e3.k : new e3(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) e3.k;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, a2.j.d.c.q3
    public final Comparator<? super E> comparator() {
        return mo6elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public abstract ImmutableSortedSet<E> mo6elementSet();

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public abstract ImmutableSortedMultiset<E> mo12headMultiset(E e2, BoundType boundType);

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public abstract ImmutableSortedMultiset<E> mo13tailMultiset(E e2, BoundType boundType);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new a(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2) {
        return new e3((f3) ImmutableSortedSet.of((Comparable) e2), new long[]{0, 1}, 0, 1);
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public ImmutableSortedMultiset<E> mo11descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.e;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? j(Ordering.from(comparator()).reverse()) : new k0<>(this);
            this.e = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e2, e3) <= 0, "Expected lowerBound <= upperBound but %s > %s", e2, e3);
        return mo13tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).mo12headMultiset((ImmutableSortedMultiset<E>) e3, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(e2, e3));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(e2, e3, e4));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(e2, e3, e4, e5));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.e() ? i(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) iterable).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        return copyOf(Ordering.natural(), Arrays.asList(e2, e3, e4, e5, e6));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(eArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, e2, e3, e4, e5, e6, e7);
        Collections.addAll(newArrayListWithCapacity, eArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }
}
