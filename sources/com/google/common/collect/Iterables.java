package com.google.common.collect;

import a2.j.d.c.h0;
import a2.j.d.c.s1;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Iterables {

    public static class a extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;

        public a(Iterable iterable) {
            this.b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.cycle(this.b);
        }

        @Override // com.google.common.collect.FluentIterable, java.lang.Object
        public String toString() {
            return this.b.toString() + " (cycled)";
        }
    }

    public static class b extends FluentIterable<List<T>> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ int c;

        public b(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.partition(this.b.iterator(), this.c);
        }
    }

    public static class c extends FluentIterable<List<T>> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ int c;

        public c(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.paddedPartition(this.b.iterator(), this.c);
        }
    }

    public static class d extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ Predicate c;

        public d(Iterable iterable, Predicate predicate) {
            this.b = iterable;
            this.c = predicate;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.filter(this.b.iterator(), this.c);
        }
    }

    public static class e extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ Function c;

        public e(Iterable iterable, Function function) {
            this.b = iterable;
            this.c = function;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.b.iterator(), this.c);
        }
    }

    public static class f extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ int c;

        public class a implements Iterator<T> {
            public boolean a = true;
            public final /* synthetic */ Iterator b;

            public a(f fVar, Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t = (T) this.b.next();
                this.a = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(!this.a, "no calls to next() since the last call to remove()");
                this.b.remove();
            }
        }

        public f(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.c), list.size()).iterator();
            }
            Iterator it = iterable.iterator();
            Iterators.advance(it, this.c);
            return new a(this, it);
        }
    }

    public static class g extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ int c;

        public g(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.limit(this.b.iterator(), this.c);
        }
    }

    public static class h extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;

        public h(Iterable iterable) {
            this.b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.b;
            if (iterable instanceof Queue) {
                return new h0((Queue) iterable);
            }
            return Iterators.consumingIterator(iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable, java.lang.Object
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    public static class i extends FluentIterable<T> {
        public final /* synthetic */ Iterable b;
        public final /* synthetic */ Comparator c;

        public i(Iterable iterable, Comparator comparator) {
            this.b = iterable;
            this.c = comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.mergeSorted(Iterables.transform(this.b, new s1()), this.c);
        }
    }

    public static final class j<T> extends FluentIterable<T> {
        public final Iterable<? extends T> b;

        public j(Iterable iterable, a aVar) {
            this.b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.b.iterator());
        }

        @Override // com.google.common.collect.FluentIterable, java.lang.Object
        public String toString() {
            return this.b.toString();
        }
    }

    @NullableDecl
    public static <T> T a(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return Iterators.addAll(collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> void b(List<T> list, Predicate<? super T> predicate, int i2, int i3) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i3) {
                break;
            } else if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i3--;
            if (i3 >= i2) {
                list.remove(i3);
            } else {
                return;
            }
        }
    }

    public static Object[] c(Iterable<?> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = Lists.newArrayList(iterable.iterator());
        }
        return collection.toArray();
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.concat(iterable, iterable2);
    }

    public static <T> Iterable<T> consumingIterable(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new h(iterable);
    }

    public static boolean contains(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Collection) {
            return Collections2.e((Collection) iterable, obj);
        }
        return Iterators.contains(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new a(iterable);
    }

    public static <T> T[] d(Iterable<? extends T> iterable, T[] tArr) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = Lists.newArrayList(iterable.iterator());
        }
        return (T[]) collection.toArray(tArr);
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if (!(iterable instanceof Collection) || !(iterable2 instanceof Collection) || ((Collection) iterable).size() == ((Collection) iterable2).size()) {
            return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        }
        return false;
    }

    public static <T> Iterable<T> filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new d(iterable, predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (T) Iterators.find(iterable.iterator(), predicate);
    }

    public static int frequency(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> T get(Iterable<T> iterable, int i2) {
        Preconditions.checkNotNull(iterable);
        return iterable instanceof List ? (T) ((List) iterable).get(i2) : (T) Iterators.get(iterable.iterator(), i2);
    }

    @NullableDecl
    public static <T> T getFirst(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.getLast(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return (T) list.get(list.size() - 1);
        }
        throw new NoSuchElementException();
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return (T) Iterators.getOnlyElement(iterable.iterator());
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> limit(Iterable<T> iterable, int i2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i2 >= 0, "limit is negative");
        return new g(iterable, i2);
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new j(new i(iterable, comparator), null);
    }

    public static <T> Iterable<List<T>> paddedPartition(Iterable<T> iterable, int i2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i2 > 0);
        return new c(iterable, i2);
    }

    public static <T> Iterable<List<T>> partition(Iterable<T> iterable, int i2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i2 > 0);
        return new b(iterable, i2);
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.removeAll(iterable.iterator(), collection);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: com.google.common.base.Predicate */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            return Iterators.removeIf(iterable.iterator(), predicate);
        }
        List list = (List) iterable;
        Predicate predicate2 = (Predicate) Preconditions.checkNotNull(predicate);
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!predicate2.apply(obj)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, obj);
                    } catch (UnsupportedOperationException unused) {
                        b(list, predicate2, i3, i2);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        b(list, predicate2, i3, i2);
                        return true;
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        if (i2 != i3) {
            z = true;
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).retainAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.retainAll(iterable.iterator(), collection);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static <T> Iterable<T> skip(Iterable<T> iterable, int i2) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i2 >= 0, "number to skip cannot be negative");
        return new f(iterable, i2);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) d(iterable, ObjectArrays.newArray(cls, 0));
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <F, T> Iterable<T> transform(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new e(iterable, function);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Iterable<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof j) || (iterable instanceof ImmutableCollection)) ? iterable : new j(iterable, null);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.concat(iterable, iterable2, iterable3);
    }

    @NullableDecl
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @NullableDecl T t) {
        return (T) Iterators.find(iterable.iterator(), predicate, t);
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... iterableArr) {
        return FluentIterable.concat(iterableArr);
    }

    @GwtIncompatible
    public static <T> Iterable<T> filter(Iterable<?> iterable, Class<T> cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return filter(iterable, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.checkNotNull(immutableCollection);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.concat(iterable);
    }

    @NullableDecl
    public static <T> T get(Iterable<? extends T> iterable, int i2, @NullableDecl T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.a(i2);
        if (iterable instanceof List) {
            List list = (List) iterable;
            return i2 < list.size() ? (T) list.get(i2) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.advance(it, i2);
        return (T) Iterators.getNext(it, t);
    }

    @NullableDecl
    public static <T> T getLast(Iterable<? extends T> iterable, @NullableDecl T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                List list = (List) iterable;
                return (T) list.get(list.size() - 1);
            }
        }
        return (T) Iterators.getLast(iterable.iterator(), t);
    }
}
