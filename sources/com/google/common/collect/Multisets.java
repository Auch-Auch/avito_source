package com.google.common.collect;

import a2.j.d.c.e5;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Multisets {

    public static class a extends m<E> {
        public final /* synthetic */ Multiset c;
        public final /* synthetic */ Multiset d;

        /* renamed from: com.google.common.collect.Multisets$a$a  reason: collision with other inner class name */
        public class C0284a extends AbstractIterator<Multiset.Entry<E>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ Iterator d;

            public C0284a(Iterator it, Iterator it2) {
                this.c = it;
                this.d = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (this.c.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.c.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, Math.max(entry.getCount(), a.this.d.count(element)));
                }
                while (this.d.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.d.next();
                    Object element2 = entry2.getElement();
                    if (!a.this.c.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Multiset multiset, Multiset multiset2) {
            super(null);
            this.c = multiset;
            this.d = multiset2;
        }

        @Override // a2.j.d.c.i
        public Set<E> a() {
            return Sets.union(this.c.mo6elementSet(), this.d.mo6elementSet());
        }

        @Override // a2.j.d.c.i
        public Iterator<E> c() {
            throw new AssertionError("should never be called");
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@NullableDecl Object obj) {
            return this.c.contains(obj) || this.d.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            return Math.max(this.c.count(obj), this.d.count(obj));
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<E>> d() {
            return new C0284a(this.c.entrySet().iterator(), this.d.entrySet().iterator());
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.c.isEmpty() && this.d.isEmpty();
        }
    }

    public static class b extends m<E> {
        public final /* synthetic */ Multiset c;
        public final /* synthetic */ Multiset d;

        public class a extends AbstractIterator<Multiset.Entry<E>> {
            public final /* synthetic */ Iterator c;

            public a(Iterator it) {
                this.c = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.c.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.c.next();
                    Object element = entry.getElement();
                    int min = Math.min(entry.getCount(), b.this.d.count(element));
                    if (min > 0) {
                        return Multisets.immutableEntry(element, min);
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Multiset multiset, Multiset multiset2) {
            super(null);
            this.c = multiset;
            this.d = multiset2;
        }

        @Override // a2.j.d.c.i
        public Set<E> a() {
            return Sets.intersection(this.c.mo6elementSet(), this.d.mo6elementSet());
        }

        @Override // a2.j.d.c.i
        public Iterator<E> c() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int count = this.c.count(obj);
            if (count == 0) {
                return 0;
            }
            return Math.min(count, this.d.count(obj));
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<E>> d() {
            return new a(this.c.entrySet().iterator());
        }
    }

    public static class c extends m<E> {
        public final /* synthetic */ Multiset c;
        public final /* synthetic */ Multiset d;

        public class a extends AbstractIterator<Multiset.Entry<E>> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ Iterator d;

            public a(Iterator it, Iterator it2) {
                this.c = it;
                this.d = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (this.c.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.c.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, c.this.d.count(element) + entry.getCount());
                }
                while (this.d.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.d.next();
                    Object element2 = entry2.getElement();
                    if (!c.this.c.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Multiset multiset, Multiset multiset2) {
            super(null);
            this.c = multiset;
            this.d = multiset2;
        }

        @Override // a2.j.d.c.i
        public Set<E> a() {
            return Sets.union(this.c.mo6elementSet(), this.d.mo6elementSet());
        }

        @Override // a2.j.d.c.i
        public Iterator<E> c() {
            throw new AssertionError("should never be called");
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@NullableDecl Object obj) {
            return this.c.contains(obj) || this.d.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            return this.d.count(obj) + this.c.count(obj);
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<E>> d() {
            return new a(this.c.entrySet().iterator(), this.d.entrySet().iterator());
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.c.isEmpty() && this.d.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.m, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return IntMath.saturatedAdd(this.c.size(), this.d.size());
        }
    }

    public static class d extends m<E> {
        public final /* synthetic */ Multiset c;
        public final /* synthetic */ Multiset d;

        public class a extends AbstractIterator<E> {
            public final /* synthetic */ Iterator c;

            public a(Iterator it) {
                this.c = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.c.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.c.next();
                    E e = (E) entry.getElement();
                    if (entry.getCount() > d.this.d.count(e)) {
                        return e;
                    }
                }
                return (E) endOfData();
            }
        }

        public class b extends AbstractIterator<Multiset.Entry<E>> {
            public final /* synthetic */ Iterator c;

            public b(Iterator it) {
                this.c = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.c.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.c.next();
                    Object element = entry.getElement();
                    int count = entry.getCount() - d.this.d.count(element);
                    if (count > 0) {
                        return Multisets.immutableEntry(element, count);
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Multiset multiset, Multiset multiset2) {
            super(null);
            this.c = multiset;
            this.d = multiset2;
        }

        @Override // com.google.common.collect.Multisets.m, a2.j.d.c.i
        public int b() {
            return Iterators.size(d());
        }

        @Override // a2.j.d.c.i
        public Iterator<E> c() {
            return new a(this.c.entrySet().iterator());
        }

        @Override // com.google.common.collect.Multisets.m, a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object obj) {
            int count = this.c.count(obj);
            if (count == 0) {
                return 0;
            }
            return Math.max(0, count - this.d.count(obj));
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<E>> d() {
            return new b(this.c.entrySet().iterator());
        }
    }

    public static abstract class e<E> implements Multiset.Entry<E> {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (getCount() != entry.getCount() || !Objects.equal(getElement(), entry.getElement())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            int i;
            E element = getElement();
            if (element == null) {
                i = 0;
            } else {
                i = element.hashCode();
            }
            return i ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    public static final class f implements Comparator<Multiset.Entry<?>> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static abstract class g<E> extends Sets.k<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return d().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return d().containsAll(collection);
        }

        public abstract Multiset<E> d();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return d().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().entrySet().size();
        }
    }

    public static abstract class h<E> extends Sets.k<Multiset.Entry<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && d().count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public abstract Multiset<E> d();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                E e = (E) entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return d().setCount(e, count, 0);
                }
            }
            return false;
        }
    }

    public static final class i<E> extends m<E> {
        public final Multiset<E> c;
        public final Predicate<? super E> d;

        public class a implements Predicate<Multiset.Entry<E>> {
            public a() {
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return i.this.d.apply((Object) ((Multiset.Entry) obj).getElement());
            }
        }

        public i(Multiset<E> multiset, Predicate<? super E> predicate) {
            super(null);
            this.c = (Multiset) Preconditions.checkNotNull(multiset);
            this.d = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // a2.j.d.c.i
        public Set<E> a() {
            return Sets.filter(this.c.mo6elementSet(), this.d);
        }

        @Override // a2.j.d.c.i, com.google.common.collect.Multiset
        public int add(@NullableDecl E e, int i) {
            Preconditions.checkArgument(this.d.apply(e), "Element %s does not match predicate %s", e, this.d);
            return this.c.add(e, i);
        }

        @Override // a2.j.d.c.i
        public Iterator<E> c() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object obj) {
            int count = this.c.count(obj);
            if (count <= 0 || !this.d.apply(obj)) {
                return 0;
            }
            return count;
        }

        @Override // a2.j.d.c.i
        public Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.c.entrySet(), new a());
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<E>> d() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator iterator() {
            return Iterators.filter(this.c.iterator(), this.d);
        }

        @Override // a2.j.d.c.i, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object obj, int i) {
            AppCompatDelegateImpl.i.z(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.c.remove(obj, i);
            }
            return 0;
        }
    }

    public static class j<E> extends e<E> implements Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final E a;
        public final int b;

        public j(@NullableDecl E e, int i) {
            this.a = e;
            this.b = i;
            AppCompatDelegateImpl.i.z(i, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.b;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @NullableDecl
        public final E getElement() {
            return this.a;
        }
    }

    public static final class k<E> implements Iterator<E> {
        public final Multiset<E> a;
        public final Iterator<Multiset.Entry<E>> b;
        @MonotonicNonNullDecl
        public Multiset.Entry<E> c;
        public int d;
        public int e;
        public boolean f;

        public k(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.a = multiset;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.d == 0) {
                    Multiset.Entry<E> next = this.b.next();
                    this.c = next;
                    int count = next.getCount();
                    this.d = count;
                    this.e = count;
                }
                this.d--;
                this.f = true;
                return this.c.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.f, "no calls to next() since the last call to remove()");
            if (this.e == 1) {
                this.b.remove();
            } else {
                this.a.remove(this.c.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    public static class l<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Multiset<? extends E> a;
        @MonotonicNonNullDecl
        public transient Set<E> b;
        @MonotonicNonNullDecl
        public transient Set<Multiset.Entry<E>> c;

        public l(Multiset<? extends E> multiset) {
            this.a = multiset;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> d() {
            return Collections.unmodifiableSet(this.a.mo6elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        /* renamed from: elementSet */
        public Set<E> mo6elementSet() {
            Set<E> set = this.b;
            if (set != null) {
                return set;
            }
            Set<E> d = d();
            this.b = d;
            return d;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.c;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.a.entrySet());
            this.c = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.collect.Multiset<? extends E>, com.google.common.collect.Multiset<E> */
        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Multiset<E> mo147delegate() {
            return (Multiset<? extends E>) this.a;
        }
    }

    public static abstract class m<E> extends a2.j.d.c.i<E> {
        public m(a aVar) {
        }

        @Override // a2.j.d.c.i
        public int b() {
            return mo6elementSet().size();
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            mo6elementSet().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<E> iterator() {
            return new k(this, entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.e(this);
        }
    }

    public static <E> boolean a(Multiset<E> multiset, Collection<? extends E> collection) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            Multiset multiset2 = (Multiset) collection;
            if (multiset2 instanceof a2.j.d.c.f) {
                a2.j.d.c.f fVar = (a2.j.d.c.f) multiset2;
                if (fVar.isEmpty()) {
                    return false;
                }
                Preconditions.checkNotNull(multiset);
                for (int c2 = fVar.c.c(); c2 >= 0; c2 = fVar.c.m(c2)) {
                    multiset.add(fVar.c.f(c2), fVar.c.g(c2));
                }
            } else if (multiset2.isEmpty()) {
                return false;
            } else {
                for (Multiset.Entry<E> entry : multiset2.entrySet()) {
                    multiset.add(entry.getElement(), entry.getCount());
                }
            }
            return true;
        } else if (collection.isEmpty()) {
            return false;
        } else {
            return Iterators.addAll(multiset, collection.iterator());
        }
    }

    public static boolean b(Multiset<?> multiset, @NullableDecl Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int c(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).mo6elementSet().size();
        }
        return 11;
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (Multiset.Entry<?> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.google.common.collect.ImmutableMultiset$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, f.a);
        List asList = Arrays.asList(entryArr);
        int i2 = ImmutableMultiset.d;
        ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(asList.size());
        for (E e2 : asList) {
            builder.addCopies(e2.getElement(), e2.getCount());
        }
        return builder.build();
    }

    public static <E> Iterator<E> d(Multiset<E> multiset) {
        return new k(multiset, multiset.entrySet().iterator());
    }

    @Beta
    public static <E> Multiset<E> difference(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new d(multiset, multiset2);
    }

    public static int e(Multiset<?> multiset) {
        long j2 = 0;
        for (Multiset.Entry<?> entry : multiset.entrySet()) {
            j2 += (long) entry.getCount();
        }
        return Ints.saturatedCast(j2);
    }

    public static boolean f(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).mo6elementSet();
        }
        return multiset.mo6elementSet().retainAll(collection);
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (!(multiset instanceof i)) {
            return new i(multiset, predicate);
        }
        i iVar = (i) multiset;
        return new i(iVar.c, Predicates.and(iVar.d, predicate));
    }

    public static <E> int g(Multiset<E> multiset, E e2, int i2) {
        AppCompatDelegateImpl.i.z(i2, "count");
        int count = multiset.count(e2);
        int i3 = i2 - count;
        if (i3 > 0) {
            multiset.add(e2, i3);
        } else if (i3 < 0) {
            multiset.remove(e2, -i3);
        }
        return count;
    }

    public static <E> boolean h(Multiset<E> multiset, E e2, int i2, int i3) {
        AppCompatDelegateImpl.i.z(i2, "oldCount");
        AppCompatDelegateImpl.i.z(i3, "newCount");
        if (multiset.count(e2) != i2) {
            return false;
        }
        multiset.setCount(e2, i3);
        return true;
    }

    public static <E> Multiset.Entry<E> immutableEntry(@NullableDecl E e2, int i2) {
        return new j(e2, i2);
    }

    public static <E> Multiset<E> intersection(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new b(multiset, multiset2);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrences(multiset, (Multiset<?>) ((Multiset) iterable));
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        boolean z = false;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            z |= multiset.remove(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count == 0) {
                it.remove();
            } else if (count < next.getCount()) {
                multiset.setCount(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }

    @Beta
    public static <E> Multiset<E> sum(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new c(multiset, multiset2);
    }

    @Beta
    public static <E> Multiset<E> union(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new a(multiset, multiset2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Multiset<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        return ((multiset instanceof l) || (multiset instanceof ImmutableMultiset)) ? multiset : new l((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new e5((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) Preconditions.checkNotNull(immutableMultiset);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count >= next.getCount()) {
                it.remove();
            } else if (count > 0) {
                multiset.remove(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }
}
