package com.google.common.collect;

import a2.j.d.c.q2;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    @Beta
    public class StandardElementSet extends Multisets.g<E> {
        public StandardElementSet() {
        }

        @Override // com.google.common.collect.Multisets.g
        public Multiset<E> d() {
            return ForwardingMultiset.this;
        }

        @Override // com.google.common.collect.Multisets.g, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<E> iterator() {
            return new q2(ForwardingMultiset.this.entrySet().iterator());
        }
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        return mo147delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return mo147delegate().count(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Multiset<E> mo147delegate();

    @Override // com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public Set<E> mo6elementSet() {
        return mo147delegate().mo6elementSet();
    }

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return mo147delegate().entrySet();
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        return mo147delegate().remove(obj, i);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return mo147delegate().setCount(e, i);
    }

    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.a(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public void standardClear() {
        Iterators.b(entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardContains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    @Beta
    public int standardCount(@NullableDecl Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@NullableDecl Object obj) {
        return Multisets.b(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return new Multisets.k(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).mo6elementSet();
        }
        return mo6elementSet().removeAll(collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.f(this, collection);
    }

    public int standardSetCount(E e, int i) {
        return Multisets.g(this, e, i);
    }

    public int standardSize() {
        return Multisets.e(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public String standardToString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return mo147delegate().setCount(e, i, i2);
    }

    public boolean standardSetCount(E e, int i, int i2) {
        return Multisets.h(this, e, i, i2);
    }
}
