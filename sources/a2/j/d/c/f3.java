package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class f3<E> extends ImmutableSortedSet<E> {
    public static final f3<Comparable> f = new f3<>(ImmutableList.of(), Ordering.natural());
    @VisibleForTesting
    public final transient ImmutableList<E> e;

    public f3(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.e = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i) {
        return this.e.a(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.e.b();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.e.c();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e2) {
        int t = t(e2, true);
        if (t == size()) {
            return null;
        }
        return this.e.get(t);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (Collections.binarySearch(this.e, obj, this.c) >= 0) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).mo6elementSet();
        }
        if (!AppCompatDelegateImpl.i.M0(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator<E> it = mo99iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int compare = this.c.compare(next2, next);
                if (compare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (compare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (compare > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int d() {
        return this.e.d();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return this.e.e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }] */
    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r7 = (java.util.Set) r7
            int r1 = r6.size()
            int r3 = r7.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Comparator<? super E> r1 = r6.c
            boolean r1 = androidx.appcompat.app.AppCompatDelegateImpl.i.M0(r1, r7)
            if (r1 == 0) goto L_0x0049
            java.util.Iterator r7 = r7.iterator()
            com.google.common.collect.UnmodifiableIterator r1 = r6.mo99iterator()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r3 == 0) goto L_0x0047
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            java.lang.Object r4 = r7.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r4 == 0) goto L_0x0046
            java.util.Comparator<? super E> r5 = r6.c     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            int r3 = r5.compare(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r3 == 0) goto L_0x002e
        L_0x0046:
            return r2
        L_0x0047:
            return r0
        L_0x0048:
            return r2
        L_0x0049:
            boolean r7 = r6.containsAll(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.f3.equals(java.lang.Object):boolean");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.e.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e2) {
        int s = s(e2, true) - 1;
        if (s == -1) {
            return null;
        }
        return this.e.get(s);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e2) {
        int t = t(e2, false);
        if (t == size()) {
            return null;
        }
        return this.e.get(t);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.e.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e2) {
        int s = s(e2, false) - 1;
        if (s == -1) {
            return null;
        }
        return this.e.get(s);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> m() {
        Comparator reverseOrder = Collections.reverseOrder(this.c);
        if (isEmpty()) {
            return ImmutableSortedSet.n(reverseOrder);
        }
        return new f3(this.e.reverse(), reverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> o(E e2, boolean z) {
        return r(0, s(e2, z));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> p(E e2, boolean z, E e3, boolean z2) {
        f3<E> r = r(t(e2, z), size());
        return r.r(0, r.s(e3, z2));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> q(E e2, boolean z) {
        return r(t(e2, z), size());
    }

    public f3<E> r(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new f3<>(this.e.subList(i, i2), this.c);
        }
        return ImmutableSortedSet.n(this.c);
    }

    public int s(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.e, Preconditions.checkNotNull(e2), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return ~binarySearch;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e.size();
    }

    public int t(E e2, boolean z) {
        int binarySearch = Collections.binarySearch(this.e, Preconditions.checkNotNull(e2), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return ~binarySearch;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    /* renamed from: descendingIterator */
    public UnmodifiableIterator<E> mo98descendingIterator() {
        return this.e.reverse().mo99iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return this.e.mo99iterator();
    }
}
