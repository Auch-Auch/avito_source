package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
@GwtIncompatible
public final class e3<E> extends ImmutableSortedMultiset<E> {
    public static final long[] j = {0};
    public static final ImmutableSortedMultiset<Comparable> k = new e3(Ordering.natural());
    @VisibleForTesting
    public final transient f3<E> f;
    public final transient long[] g;
    public final transient int h;
    public final transient int i;

    public e3(Comparator<? super E> comparator) {
        this.f = ImmutableSortedSet.n(comparator);
        this.g = j;
        this.h = 0;
        this.i = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r7 >= 0) goto L_0x0014;
     */
    @Override // com.google.common.collect.Multiset
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r7) {
        /*
            r6 = this;
            a2.j.d.c.f3<E> r0 = r6.f
            java.util.Objects.requireNonNull(r0)
            if (r7 != 0) goto L_0x0008
            goto L_0x0013
        L_0x0008:
            com.google.common.collect.ImmutableList<E> r1 = r0.e     // Catch:{ ClassCastException -> 0x0013 }
            java.util.Comparator<? super E> r0 = r0.c     // Catch:{ ClassCastException -> 0x0013 }
            int r7 = java.util.Collections.binarySearch(r1, r7, r0)     // Catch:{ ClassCastException -> 0x0013 }
            if (r7 < 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r7 = -1
        L_0x0014:
            if (r7 < 0) goto L_0x0024
            long[] r0 = r6.g
            int r1 = r6.h
            int r1 = r1 + r7
            int r7 = r1 + 1
            r2 = r0[r7]
            r4 = r0[r1]
            long r2 = r2 - r4
            int r7 = (int) r2
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.e3.count(java.lang.Object):int");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return this.h > 0 || this.i < this.g.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public ImmutableSet mo6elementSet() {
        return this.f;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return h(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> h(int i2) {
        E e = this.f.e.get(i2);
        long[] jArr = this.g;
        int i3 = this.h + i2;
        return Multisets.immutableEntry(e, (int) (jArr[i3 + 1] - jArr[i3]));
    }

    public ImmutableSortedMultiset<E> l(int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i3, this.i);
        if (i2 == i3) {
            return ImmutableSortedMultiset.j(comparator());
        }
        if (i2 == 0 && i3 == this.i) {
            return this;
        }
        return new e3(this.f.r(i2, i3), this.g, this.h + i2, i3 - i2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return h(this.i - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.g;
        int i2 = this.h;
        return Ints.saturatedCast(jArr[this.i + i2] - jArr[i2]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet  reason: collision with other method in class */
    public ImmutableSortedSet<E> mo6elementSet() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public ImmutableSortedMultiset<E> mo12headMultiset(E e, BoundType boundType) {
        return l(0, this.f.s(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public ImmutableSortedMultiset<E> mo13tailMultiset(E e, BoundType boundType) {
        return l(this.f.t(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public NavigableSet mo6elementSet() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet  reason: collision with other method in class */
    public Set mo6elementSet() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public SortedSet mo6elementSet() {
        return this.f;
    }

    public e3(f3<E> f3Var, long[] jArr, int i2, int i3) {
        this.f = f3Var;
        this.g = jArr;
        this.h = i2;
        this.i = i3;
    }
}
