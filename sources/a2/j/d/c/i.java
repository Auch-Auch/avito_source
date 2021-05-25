package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class i<E> extends AbstractCollection<E> implements Multiset<E> {
    @MonotonicNonNullDecl
    public transient Set<E> a;
    @MonotonicNonNullDecl
    public transient Set<Multiset.Entry<E>> b;

    public class a extends Multisets.g<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.g
        public Multiset<E> d() {
            return i.this;
        }

        @Override // com.google.common.collect.Multisets.g, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<E> iterator() {
            return i.this.c();
        }
    }

    public class b extends Multisets.h<E> {
        public b() {
        }

        @Override // com.google.common.collect.Multisets.h
        public Multiset<E> d() {
            return i.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Multiset.Entry<E>> iterator() {
            return i.this.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.b();
        }
    }

    public Set<E> a() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl E e) {
        add(e, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.a(this, collection);
    }

    public abstract int b();

    public abstract Iterator<E> c();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    public Set<Multiset.Entry<E>> createEntrySet() {
        return new b();
    }

    public abstract Iterator<Multiset.Entry<E>> d();

    @Override // com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public Set<E> mo6elementSet() {
        Set<E> set = this.a;
        if (set != null) {
            return set;
        }
        Set<E> a3 = a();
        this.a = a3;
        return a3;
    }

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.b;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.b = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public final boolean equals(@NullableDecl Object obj) {
        return Multisets.b(this, obj);
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).mo6elementSet();
        }
        return mo6elementSet().removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.f(this, collection);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e, int i) {
        return Multisets.g(this, e, i);
    }

    @Override // java.util.AbstractCollection, java.lang.Object, com.google.common.collect.Multiset
    public final String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e, int i, int i2) {
        return Multisets.h(this, e, i, i2);
    }
}
