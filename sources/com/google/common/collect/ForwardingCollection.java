package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(E e) {
        return mo147delegate().add(e);
    }

    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return mo147delegate().addAll(collection);
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        mo147delegate().clear();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return mo147delegate().contains(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return mo147delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Collection<E> mo147delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return mo147delegate().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return mo147delegate().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return mo147delegate().remove(obj);
    }

    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return mo147delegate().removeAll(collection);
    }

    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return mo147delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return mo147delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    public void standardClear() {
        Iterators.b(iterator());
    }

    public boolean standardContains(@NullableDecl Object obj) {
        return Iterators.contains(iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return Collections2.b(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(@NullableDecl Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Objects.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.removeAll(iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.retainAll(iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        StringBuilder d = Collections2.d(size());
        d.append('[');
        boolean z = true;
        for (E e : this) {
            if (!z) {
                d.append(", ");
            }
            z = false;
            if (e == this) {
                d.append("(this Collection)");
            } else {
                d.append((Object) e);
            }
        }
        d.append(']');
        return d.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        return mo147delegate().toArray();
    }

    @Override // java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) mo147delegate().toArray(tArr);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) ObjectArrays.d(this, tArr);
    }
}
