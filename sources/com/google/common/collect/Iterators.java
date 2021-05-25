package com.google.common.collect;

import a2.j.d.c.b5;
import a2.j.d.c.t1;
import a2.j.d.c.u1;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Iterators {

    public static class a extends UnmodifiableIterator<T> {
        public final /* synthetic */ Enumeration a;

        public a(Enumeration enumeration) {
            this.a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.a.nextElement();
        }
    }

    public static class b implements Enumeration<T> {
        public final /* synthetic */ Iterator a;

        public b(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasNext();
        }

        @Override // java.util.Enumeration
        public T nextElement() {
            return (T) this.a.next();
        }
    }

    public static class c extends UnmodifiableIterator<T> {
        public final /* synthetic */ Iterator a;

        public c(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.a.next();
        }
    }

    public static class d implements Iterator<T> {
        public Iterator<T> a = l.INSTANCE;
        public final /* synthetic */ Iterable b;

        public d(Iterable iterable) {
            this.b = iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.b.iterator().hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.a.hasNext()) {
                Iterator<T> it = this.b.iterator();
                this.a = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    public static class e extends AbstractIterator<T> {
        public final /* synthetic */ Iterator c;
        public final /* synthetic */ Predicate d;

        public e(Iterator it, Predicate predicate) {
            this.c = it;
            this.d = predicate;
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            while (this.c.hasNext()) {
                T t = (T) this.c.next();
                if (this.d.apply(t)) {
                    return t;
                }
            }
            return (T) endOfData();
        }
    }

    public static class f extends b5<F, T> {
        public final /* synthetic */ Function b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        @Override // a2.j.d.c.b5
        public T a(F f) {
            return (T) this.b.apply(f);
        }
    }

    public static class g implements Iterator<T> {
        public int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Iterator c;

        public g(int i, Iterator it) {
            this.b = i;
            this.c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b && this.c.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                this.a++;
                return (T) this.c.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
        }
    }

    public static class h extends UnmodifiableIterator<T> {
        public final /* synthetic */ Iterator a;

        public h(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) this.a.next();
            this.a.remove();
            return t;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    public static class i extends UnmodifiableIterator<T> {
        public boolean a;
        public final /* synthetic */ Object b;

        public i(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.a) {
                this.a = true;
                return (T) this.b;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class j<T> extends a2.j.d.c.c<T> {
        public static final UnmodifiableListIterator<Object> e = new j(new Object[0], 0, 0, 0);
        public final T[] c;
        public final int d;

        public j(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.c = tArr;
            this.d = i;
        }

        @Override // a2.j.d.c.c
        public T a(int i) {
            return this.c[this.d + i];
        }
    }

    public static class k<T> implements Iterator<T> {
        @NullableDecl
        public Iterator<? extends T> a;
        public Iterator<? extends T> b = j.e;
        public Iterator<? extends Iterator<? extends T>> c;
        @NullableDecl
        public Deque<Iterator<? extends Iterator<? extends T>>> d;

        public k(Iterator<? extends Iterator<? extends T>> it) {
            this.c = (Iterator) Preconditions.checkNotNull(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator<? extends Iterator<? extends T>> it;
            while (!((Iterator) Preconditions.checkNotNull(this.b)).hasNext()) {
                while (true) {
                    Iterator<? extends Iterator<? extends T>> it2 = this.c;
                    if (it2 != null && it2.hasNext()) {
                        it = this.c;
                        break;
                    }
                    Deque<Iterator<? extends Iterator<? extends T>>> deque = this.d;
                    if (deque == null || deque.isEmpty()) {
                        break;
                    }
                    this.c = this.d.removeFirst();
                }
                it = null;
                this.c = it;
                if (it == null) {
                    return false;
                }
                Iterator<? extends T> it3 = (Iterator) it.next();
                this.b = it3;
                if (it3 instanceof k) {
                    k kVar = (k) it3;
                    this.b = kVar.b;
                    if (this.d == null) {
                        this.d = new ArrayDeque();
                    }
                    this.d.addFirst(this.c);
                    if (kVar.d != null) {
                        while (!kVar.d.isEmpty()) {
                            this.d.addFirst(kVar.d.removeLast());
                        }
                    }
                    this.c = kVar.c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.b;
                this.a = it;
                return (T) it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
            this.a.remove();
            this.a = null;
        }
    }

    public enum l implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(false, "no calls to next() since the last call to remove()");
        }
    }

    public static class m<T> extends UnmodifiableIterator<T> {
        public final Queue<PeekingIterator<T>> a;

        public class a implements Comparator<PeekingIterator<T>> {
            public final /* synthetic */ Comparator a;

            public a(m mVar, Comparator comparator) {
                this.a = comparator;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Comparator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return this.a.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
            }
        }

        public m(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.a = new PriorityQueue(2, new a(this, comparator));
            Iterator<? extends Iterator<? extends T>> it = iterable.iterator();
            while (it.hasNext()) {
                Iterator it2 = (Iterator) it.next();
                if (it2.hasNext()) {
                    this.a.add(Iterators.peekingIterator(it2));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> remove = this.a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.a.add(remove);
            }
            return next;
        }
    }

    public static class n<E> implements PeekingIterator<E> {
        public final Iterator<? extends E> a;
        public boolean b;
        @NullableDecl
        public E c;

        public n(Iterator<? extends E> it) {
            this.a = (Iterator) Preconditions.checkNotNull(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b || this.a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.b) {
                return (E) this.a.next();
            }
            E e = this.c;
            this.b = false;
            this.c = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.b) {
                this.c = (E) this.a.next();
                this.b = true;
            }
            return this.c;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.b, "Can't remove after you've peeked at next");
            this.a.remove();
        }
    }

    public static void a(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.Q2("position (", i2, ") must not be negative"));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it, int i2) {
        Preconditions.checkNotNull(it);
        int i3 = 0;
        Preconditions.checkArgument(i2 >= 0, "numberToAdvance must be nonnegative");
        while (i3 < i2 && it.hasNext()) {
            it.next();
            i3++;
        }
        return i3;
    }

    public static <T> boolean all(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it, Predicate<? super T> predicate) {
        return indexOf(it, predicate) != -1;
    }

    public static <T> Enumeration<T> asEnumeration(Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new b(it);
    }

    public static void b(Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @NullableDecl
    public static <T> T c(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        return concat(new t1(new Iterator[]{it, it2}));
    }

    public static <T> Iterator<T> consumingIterator(Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new h(it);
    }

    public static boolean contains(Iterator<?> it, @NullableDecl Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new d(iterable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.equal(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new e(it, predicate);
    }

    public static <T> T find(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        int length = tArr.length;
        Preconditions.checkArgument(length >= 0);
        Preconditions.checkPositionIndexes(0, 0 + length, tArr.length);
        Preconditions.checkPositionIndex(0, length);
        if (length == 0) {
            return j.e;
        }
        return new j(tArr, 0, length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new a(enumeration);
    }

    public static int frequency(Iterator<?> it, @NullableDecl Object obj) {
        int i2 = 0;
        while (contains(it, obj)) {
            i2++;
        }
        return i2;
    }

    public static <T> T get(Iterator<T> it, int i2) {
        a(i2);
        int advance = advance(it, i2);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException(a2.b.a.a.a.S2("position (", i2, ") must be less than the number of elements that remained (", advance, ")"));
    }

    public static <T> T getLast(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @NullableDecl
    public static <T> T getNext(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? (T) it.next() : t;
    }

    public static <T> T getOnlyElement(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append((Object) next);
        for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
            sb.append(", ");
            sb.append((Object) it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(Typography.greater);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int indexOf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> Iterator<T> limit(Iterator<T> it, int i2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i2 >= 0, "limit is negative");
        return new g(i2, it);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new m(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it, int i2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i2 > 0);
        return new u1(it, i2, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it, int i2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i2 > 0);
        return new u1(it, i2, false);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it) {
        if (it instanceof n) {
            return (n) it;
        }
        return new n(it);
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@NullableDecl T t) {
        return new i(t);
    }

    public static int size(Iterator<?> it) {
        long j2 = 0;
        while (it.hasNext()) {
            it.next();
            j2++;
        }
        return Ints.saturatedCast(j2);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static String toString(Iterator<?> it) {
        StringBuilder I = a2.b.a.a.a.I('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                I.append(", ");
            }
            z = false;
            I.append(it.next());
        }
        I.append(']');
        return I.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new f(it, function);
    }

    public static <T> Optional<T> tryFind(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new c(it);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    @NullableDecl
    public static <T> T getLast(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? (T) getLast(it) : t;
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it, Class<T> cls) {
        return filter(it, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(new t1(new Iterator[]{it, it2, it3}));
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    @NullableDecl
    public static <T> T get(Iterator<? extends T> it, int i2, @NullableDecl T t) {
        a(i2);
        advance(it, i2);
        return (T) getNext(it, t);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T find(java.util.Iterator<? extends T> r2, com.google.common.base.Predicate<? super T> r3, @org.checkerframework.checker.nullness.compatqual.NullableDecl T r4) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r2)
            com.google.common.base.Preconditions.checkNotNull(r3)
        L_0x0006:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r2.next()
            boolean r1 = r3.apply(r0)
            if (r1 == 0) goto L_0x0006
            return r0
        L_0x0017:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.find(java.util.Iterator, com.google.common.base.Predicate, java.lang.Object):java.lang.Object");
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(new t1(new Iterator[]{it, it2, it3, it4}));
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? (T) getOnlyElement(it) : t;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        Iterator[] itArr2 = (Iterator[]) Arrays.copyOf(itArr, itArr.length);
        for (Iterator it : (Iterator[]) Preconditions.checkNotNull(itArr2)) {
            Preconditions.checkNotNull(it);
        }
        return concat(new t1(itArr2));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it) {
        return new k(it);
    }
}
