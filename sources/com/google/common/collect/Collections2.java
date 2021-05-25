package com.google.common.collect;

import a2.j.d.c.v2;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Collections2 {

    public static class a<E> extends AbstractCollection<E> {
        public final Collection<E> a;
        public final Predicate<? super E> b;

        public a(Collection<E> collection, Predicate<? super E> predicate) {
            this.a = collection;
            this.b = predicate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e) {
            Preconditions.checkArgument(this.b.apply(e));
            return this.a.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(this.b.apply(it.next()));
            }
            return this.a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (Collections2.e(this.a, obj)) {
                return this.b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (E e : this.a) {
                if (this.b.apply(e)) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static final class b<E> extends AbstractCollection<List<E>> {
        public final ImmutableList<E> a;
        public final Comparator<? super E> b;
        public final int c;

        public b(Iterable<E> iterable, Comparator<? super E> comparator) {
            int saturatedMultiply;
            ImmutableList<E> sortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.a = sortedCopyOf;
            this.b = comparator;
            int i = 1;
            int i2 = 1;
            int i3 = 1;
            while (true) {
                if (i >= sortedCopyOf.size()) {
                    saturatedMultiply = IntMath.saturatedMultiply(i3, IntMath.binomial(i, i2));
                    break;
                }
                if (comparator.compare(sortedCopyOf.get(i - 1), sortedCopyOf.get(i)) < 0) {
                    i3 = IntMath.saturatedMultiply(i3, IntMath.binomial(i, i2));
                    i2 = 0;
                    saturatedMultiply = Integer.MAX_VALUE;
                    if (i3 == Integer.MAX_VALUE) {
                        break;
                    }
                }
                i++;
                i2++;
            }
            this.c = saturatedMultiply;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.a(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new c(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.c;
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("orderedPermutationCollection(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static final class c<E> extends AbstractIterator<List<E>> {
        @NullableDecl
        public List<E> c;
        public final Comparator<? super E> d;

        public c(List<E> list, Comparator<? super E> comparator) {
            this.c = Lists.newArrayList(list);
            this.d = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            List<E> list = this.c;
            if (list == null) {
                return (List) endOfData();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) list);
            int size = this.c.size() - 2;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                } else if (this.d.compare(this.c.get(size), this.c.get(size + 1)) < 0) {
                    break;
                } else {
                    size--;
                }
            }
            if (size == -1) {
                this.c = null;
                return copyOf;
            }
            E e = this.c.get(size);
            for (int size2 = this.c.size() - 1; size2 > size; size2--) {
                if (this.d.compare(e, this.c.get(size2)) < 0) {
                    Collections.swap(this.c, size, size2);
                    Collections.reverse(this.c.subList(size + 1, this.c.size()));
                    return copyOf;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static final class d<E> extends AbstractCollection<List<E>> {
        public final ImmutableList<E> a;

        public d(ImmutableList<E> immutableList) {
            this.a = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.a(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new e(this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.a.size());
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("permutations(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static class e<E> extends AbstractIterator<List<E>> {
        public final List<E> c;
        public final int[] d;
        public final int[] e;
        public int f = Integer.MAX_VALUE;

        public e(List<E> list) {
            this.c = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.d = iArr;
            int[] iArr2 = new int[size];
            this.e = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            if (this.f <= 0) {
                return (List) endOfData();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.c);
            int size = this.c.size() - 1;
            this.f = size;
            if (size == -1) {
                return copyOf;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.d;
                int i2 = this.f;
                int i3 = iArr[i2];
                int[] iArr2 = this.e;
                int i4 = i3 + iArr2[i2];
                if (i4 < 0) {
                    iArr2[i2] = -iArr2[i2];
                    this.f = i2 - 1;
                } else if (i4 != i2 + 1) {
                    Collections.swap(this.c, (i2 - iArr[i2]) + i, (i2 - i4) + i);
                    this.d[this.f] = i4;
                    return copyOf;
                } else if (i2 == 0) {
                    return copyOf;
                } else {
                    i++;
                    iArr2[i2] = -iArr2[i2];
                    this.f = i2 - 1;
                }
            }
        }
    }

    public static class f<F, T> extends AbstractCollection<T> {
        public final Collection<F> a;
        public final Function<? super F, ? extends T> b;

        public f(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.a = (Collection) Preconditions.checkNotNull(collection);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public static boolean a(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        v2 c2 = c(list);
        v2 c3 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (c2.g(i) != c3.d(c2.f(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> v2<E> c(Collection<E> collection) {
        v2<E> v2Var = new v2<>();
        for (E e2 : collection) {
            v2Var.o(e2, v2Var.d(e2) + 1);
        }
        return v2Var;
    }

    public static StringBuilder d(int i) {
        AppCompatDelegateImpl.i.z(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
    }

    public static boolean e(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (!(collection instanceof a)) {
            return new a((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
        }
        a aVar = (a) collection;
        return new a(aVar.a, Predicates.and(aVar.b, predicate));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new d(ImmutableList.copyOf((Collection) collection));
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new f(collection, function);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new b(iterable, comparator);
    }
}
