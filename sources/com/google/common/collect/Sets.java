package com.google.common.collect;

import a2.j.d.c.g1;
import a2.j.d.c.m3;
import a2.j.d.c.n3;
import a2.j.d.c.q4;
import a2.j.d.c.x;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Sets {

    public static abstract class SetView<E> extends AbstractSet<E> {
        public SetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S copyInto(S s) {
            s.addAll(this);
            return s;
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public abstract UnmodifiableIterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public SetView(a aVar) {
        }
    }

    public static class a extends SetView<E> {
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        /* renamed from: com.google.common.collect.Sets$a$a  reason: collision with other inner class name */
        public class C0286a extends AbstractIterator<E> {
            public final Iterator<? extends E> c;
            public final Iterator<? extends E> d;

            public C0286a() {
                this.c = a.this.a.iterator();
                this.d = a.this.b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                if (this.c.hasNext()) {
                    return (E) this.c.next();
                }
                while (this.d.hasNext()) {
                    E e2 = (E) this.d.next();
                    if (!a.this.a.contains(e2)) {
                        return e2;
                    }
                }
                return (E) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) || this.b.contains(obj);
        }

        @Override // com.google.common.collect.Sets.SetView
        public <S extends Set<E>> S copyInto(S s) {
            s.addAll(this.a);
            s.addAll(this.b);
            return s;
        }

        @Override // com.google.common.collect.Sets.SetView
        public ImmutableSet<E> immutableCopy() {
            return new ImmutableSet.Builder().addAll((Iterable) this.a).addAll((Iterable) this.b).build();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.isEmpty() && this.b.isEmpty();
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator */
        public UnmodifiableIterator<E> mo123iterator() {
            return new C0286a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.a.size();
            for (Object obj : this.b) {
                if (!this.a.contains(obj)) {
                    size++;
                }
            }
            return size;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator  reason: collision with other method in class */
        public Iterator mo123iterator() {
            return new C0286a();
        }
    }

    public static class b extends SetView<E> {
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {
            public final Iterator<E> c;

            public a() {
                this.c = b.this.a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.c.hasNext()) {
                    E next = this.c.next();
                    if (b.this.b.contains(next)) {
                        return next;
                    }
                }
                return (E) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) && this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.a.containsAll(collection) && this.b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.a);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator */
        public UnmodifiableIterator<E> mo123iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (Object obj : this.a) {
                if (this.b.contains(obj)) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator  reason: collision with other method in class */
        public Iterator mo123iterator() {
            return new a();
        }
    }

    public static class c extends SetView<E> {
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {
            public final Iterator<E> c;

            public a() {
                this.c = c.this.a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.c.hasNext()) {
                    E next = this.c.next();
                    if (!c.this.b.contains(next)) {
                        return next;
                    }
                }
                return (E) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) && !this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.b.containsAll(this.a);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator */
        public UnmodifiableIterator<E> mo123iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (Object obj : this.a) {
                if (!this.b.contains(obj)) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator  reason: collision with other method in class */
        public Iterator mo123iterator() {
            return new a();
        }
    }

    public static class d extends SetView<E> {
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {
            public final /* synthetic */ Iterator c;
            public final /* synthetic */ Iterator d;

            public a(Iterator it, Iterator it2) {
                this.c = it;
                this.d = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.c.hasNext()) {
                    E e2 = (E) this.c.next();
                    if (!d.this.b.contains(e2)) {
                        return e2;
                    }
                }
                while (this.d.hasNext()) {
                    E e3 = (E) this.d.next();
                    if (!d.this.a.contains(e3)) {
                        return e3;
                    }
                }
                return (E) endOfData();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.b.contains(obj) ^ this.a.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.equals(this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (Object obj : this.a) {
                if (!this.b.contains(obj)) {
                    i++;
                }
            }
            for (Object obj2 : this.b) {
                if (!this.a.contains(obj2)) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        /* renamed from: iterator */
        public UnmodifiableIterator<E> mo123iterator() {
            return new a(this.a.iterator(), this.b.iterator());
        }
    }

    public static class e extends AbstractSet<Set<E>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ ImmutableMap b;

        public class a extends AbstractIterator<Set<E>> {
            public final BitSet c;

            public a() {
                this.c = new BitSet(e.this.b.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                if (this.c.isEmpty()) {
                    this.c.set(0, e.this.a);
                } else {
                    int nextSetBit = this.c.nextSetBit(0);
                    int nextClearBit = this.c.nextClearBit(nextSetBit);
                    if (nextClearBit == e.this.b.size()) {
                        return (Set) endOfData();
                    }
                    int i = (nextClearBit - nextSetBit) - 1;
                    this.c.set(0, i);
                    this.c.clear(i, nextClearBit);
                    this.c.set(nextClearBit);
                }
                return new m3(this, (BitSet) this.c.clone());
            }
        }

        public e(int i, ImmutableMap immutableMap) {
            this.a = i;
            this.b = immutableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            if (set.size() != this.a || !this.b.keySet().containsAll(set)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Set<E>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.binomial(this.b.size(), this.a);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Sets.combinations(");
            L.append(this.b.keySet());
            L.append(", ");
            return a2.b.a.a.a.j(L, this.a, ")");
        }
    }

    public static final class f<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        public final transient ImmutableList<ImmutableSet<E>> a;
        public final transient x<E> b;

        public f(ImmutableList<ImmutableSet<E>> immutableList, x<E> xVar) {
            this.a = immutableList;
            this.b = xVar;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.b;
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return super.equals(obj);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            int i = 1;
            int size = size() - 1;
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                size = ~(~(size * 31));
            }
            UnmodifiableIterator<ImmutableSet<E>> it = this.a.mo99iterator();
            while (it.hasNext()) {
                ImmutableSet<E> next = it.next();
                i = ~(~((next.hashCode() * (size() / next.size())) + (i * 31)));
            }
            return ~(~(i + size));
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection<List<E>> mo147delegate() {
            return this.b;
        }
    }

    @GwtIncompatible
    public static class g<E> extends ForwardingNavigableSet<E> {
        public final NavigableSet<E> a;

        public g(NavigableSet<E> navigableSet) {
            this.a = navigableSet;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E ceiling(E e) {
            return this.a.floor(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.a.comparator();
            if (comparator == null) {
                return Ordering.natural().reverse();
            }
            return Ordering.from(comparator).reverse();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.a.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E first() {
            return this.a.last();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E floor(E e) {
            return this.a.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            return this.a.tailSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E higher(E e) {
            return this.a.lower(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.a.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E last() {
            return this.a.first();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E lower(E e) {
            return this.a.higher(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollFirst() {
            return this.a.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollLast() {
            return this.a.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return this.a.subSet(e2, z2, e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return this.a.headSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject, java.lang.Object
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(E e) {
            return standardHeadSet(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(E e, E e2) {
            return standardSubSet(e, e2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(E e) {
            return standardTailSet(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public NavigableSet<E> mo147delegate() {
            return this.a;
        }
    }

    @GwtIncompatible
    public static class h<E> extends j<E> implements NavigableSet<E> {
        public h(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return (E) Iterables.find(((NavigableSet) this.a).tailSet(e, true), this.b, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.filter(((NavigableSet) this.a).descendingIterator(), this.b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.filter((NavigableSet) ((NavigableSet) this.a).descendingSet(), (Predicate) this.b);
        }

        @Override // java.util.NavigableSet
        @NullableDecl
        public E floor(E e) {
            return (E) Iterators.find(((NavigableSet) this.a).headSet(e, true).descendingIterator(), this.b, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.filter((NavigableSet) ((NavigableSet) this.a).headSet(e, z), (Predicate) this.b);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return (E) Iterables.find(((NavigableSet) this.a).tailSet(e, false), this.b, null);
        }

        @Override // com.google.common.collect.Sets.j, java.util.SortedSet
        public E last() {
            return (E) Iterators.find(((NavigableSet) this.a).descendingIterator(), this.b);
        }

        @Override // java.util.NavigableSet
        @NullableDecl
        public E lower(E e) {
            return (E) Iterators.find(((NavigableSet) this.a).headSet(e, false).descendingIterator(), this.b, null);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) Iterables.a((NavigableSet) this.a, this.b);
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) Iterables.a(((NavigableSet) this.a).descendingSet(), this.b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.filter((NavigableSet) ((NavigableSet) this.a).subSet(e, z, e2, z2), (Predicate) this.b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.filter((NavigableSet) ((NavigableSet) this.a).tailSet(e, z), (Predicate) this.b);
        }
    }

    public static class i<E> extends Collections2.a<E> implements Set<E> {
        public i(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    public static class j<E> extends i<E> implements SortedSet<E> {
        public j(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) Iterators.find(this.a.iterator(), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e) {
            return new j(((SortedSet) this.a).headSet(e), this.b);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [E, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.util.SortedSet
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public E last() {
            /*
                r3 = this;
                java.util.Collection<E> r0 = r3.a
                java.util.SortedSet r0 = (java.util.SortedSet) r0
            L_0x0004:
                java.lang.Object r1 = r0.last()
                com.google.common.base.Predicate<? super E> r2 = r3.b
                boolean r2 = r2.apply(r1)
                if (r2 == 0) goto L_0x0011
                return r1
            L_0x0011:
                java.util.SortedSet r0 = r0.headSet(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.j.last():java.lang.Object");
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e, E e2) {
            return new j(((SortedSet) this.a).subSet(e, e2), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e) {
            return new j(((SortedSet) this.a).tailSet(e), this.b);
        }
    }

    public static abstract class k<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.c(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    public static final class l<E> extends AbstractSet<Set<E>> {
        public final ImmutableMap<E, Integer> a;

        public class a extends a2.j.d.c.c<Set<E>> {
            public a(int i) {
                super(i);
            }

            @Override // a2.j.d.c.c
            public Object a(int i) {
                return new m(l.this.a, i);
            }
        }

        public l(Set<E> set) {
            Preconditions.checkArgument(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.a = Maps.h(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.a.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof l) {
                return this.a.equals(((l) obj).a);
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public int hashCode() {
            return this.a.keySet().hashCode() << (this.a.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Set<E>> iterator() {
            return new a(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.a.size();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("powerSet(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static final class m<E> extends AbstractSet<E> {
        public final ImmutableMap<E, Integer> a;
        public final int b;

        public class a extends UnmodifiableIterator<E> {
            public final ImmutableList<E> a;
            public int b;

            public a() {
                this.a = m.this.a.keySet().asList();
                this.b = m.this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.b);
                if (numberOfTrailingZeros != 32) {
                    this.b &= ~(1 << numberOfTrailingZeros);
                    return this.a.get(numberOfTrailingZeros);
                }
                throw new NoSuchElementException();
            }
        }

        public m(ImmutableMap<E, Integer> immutableMap, int i) {
            this.a = immutableMap;
            this.b = i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            Integer num = this.a.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.b) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.b);
        }
    }

    public static final class n<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        public final NavigableSet<E> a;
        public final SortedSet<E> b;
        @MonotonicNonNullDecl
        public transient n<E> c;

        public n(NavigableSet<E> navigableSet) {
            this.a = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.b = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.a.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.b;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.a.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            n<E> nVar = this.c;
            if (nVar != null) {
                return nVar;
            }
            n<E> nVar2 = new n<>(this.a.descendingSet());
            this.c = nVar2;
            nVar2.c = this;
            return nVar2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return this.a.floor(e);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.a.headSet(e, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return this.a.higher(e);
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return this.a.lower(e);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.unmodifiableNavigableSet(this.a.subSet(e, z, e2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.a.tailSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return this.b;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set mo147delegate() {
            return this.b;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public SortedSet<E> mo147delegate() {
            return this.b;
        }
    }

    public static boolean a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static boolean c(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).mo6elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return d(set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... setArr) {
        return cartesianProduct(Arrays.asList(setArr));
    }

    @Beta
    public static <E> Set<Set<E>> combinations(Set<E> set, int i2) {
        ImmutableMap h2 = Maps.h(set);
        AppCompatDelegateImpl.i.z(i2, "size");
        Preconditions.checkArgument(i2 <= h2.size(), "size (%s) must be <= set.size() (%s)", i2, h2.size());
        if (i2 == 0) {
            return ImmutableSet.of(ImmutableSet.of());
        }
        if (i2 == h2.size()) {
            return ImmutableSet.of(h2.keySet());
        }
        return new e(i2, h2);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        EnumSet<E> allOf = EnumSet.allOf(collection.iterator().next().getDeclaringClass());
        allOf.removeAll(collection);
        return allOf;
    }

    public static boolean d(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static <E> SetView<E> difference(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new c(set, set2);
    }

    public static <E> Set<E> filter(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return filter((SortedSet) set, (Predicate) predicate);
        }
        if (!(set instanceof i)) {
            return new i((Set) Preconditions.checkNotNull(set), (Predicate) Preconditions.checkNotNull(predicate));
        }
        i iVar = (i) set;
        return new i((Set) iVar.a, Predicates.and(iVar.b, predicate));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E e2, E... eArr) {
        return g1.l(EnumSet.of((Enum) e2, (Enum[]) eArr));
    }

    public static <E> SetView<E> intersection(Set<E> set, Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new b(set, set2);
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        Iterables.addAll(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int i2) {
        return new HashSet<>(Maps.e(i2));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i2) {
        return new LinkedHashSet<>(Maps.e(i2));
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new l(set);
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> navigableSet, Range<K> range) {
        boolean z = true;
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            boolean z2 = lowerBoundType == boundType;
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != boundType) {
                z = false;
            }
            return navigableSet.subSet(lowerEndpoint, z2, upperEndpoint, z);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableSet.tailSet(lowerEndpoint2, z);
        } else if (!range.hasUpperBound()) {
            return (NavigableSet) Preconditions.checkNotNull(navigableSet);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableSet.headSet(upperEndpoint2, z);
        }
    }

    public static <E> SetView<E> symmetricDifference(Set<? extends E> set, Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new d(set, set2);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return new q4(navigableSet, null);
    }

    public static <E> SetView<E> union(Set<? extends E> set, Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new a(set, set2);
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof n)) ? navigableSet : new n(navigableSet);
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        Iterator<? extends Set<? extends B>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableSet copyOf = ImmutableSet.copyOf((Collection) ((Set) it.next()));
            if (copyOf.isEmpty()) {
                return ImmutableSet.of();
            }
            builder.add((ImmutableList.Builder) copyOf);
        }
        ImmutableList build = builder.build();
        return new f(build, new x(new n3(build)));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> iterable) {
        if (iterable instanceof g1) {
            return (g1) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.of();
            }
            return g1.l(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.of();
        }
        EnumSet of = EnumSet.of((Enum) it.next());
        Iterators.addAll(of, it);
        return g1.l(of);
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> iterable) {
        Set<E> newConcurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(newConcurrentHashSet, iterable);
        return newConcurrentHashSet;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = Lists.newArrayList(iterable);
        }
        return new CopyOnWriteArraySet<>(collection);
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithExpectedSize = newHashSetWithExpectedSize(eArr.length);
        Collections.addAll(newHashSetWithExpectedSize, eArr);
        return newHashSetWithExpectedSize;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> newLinkedHashSet = newLinkedHashSet();
        Iterables.addAll(newLinkedHashSet, iterable);
        return newLinkedHashSet;
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> iterable) {
        TreeSet<E> newTreeSet = newTreeSet();
        Iterables.addAll(newTreeSet, iterable);
        return newTreeSet;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>((Collection) iterable);
        }
        return newHashSet(iterable.iterator());
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> cls) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    public static <E> SortedSet<E> filter(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof i)) {
            return new j((SortedSet) Preconditions.checkNotNull(sortedSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        i iVar = (i) sortedSet;
        return new j((SortedSet) iVar.a, Predicates.and(iVar.b, predicate));
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> newHashSet = newHashSet();
        Iterators.addAll(newHashSet, it);
        return newHashSet;
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (!(navigableSet instanceof i)) {
            return new h((NavigableSet) Preconditions.checkNotNull(navigableSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        i iVar = (i) navigableSet;
        return new h((NavigableSet) iVar.a, Predicates.and(iVar.b, predicate));
    }
}
