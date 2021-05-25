package com.google.common.collect;

import a2.j.d.c.a2;
import a2.j.d.c.z1;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    @Override // java.util.List
    public void add(int i, E e) {
        mo147delegate().add(i, e);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public boolean addAll(int i, Collection<? extends E> collection) {
        return mo147delegate().addAll(i, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract List<E> mo147delegate();

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // java.util.List
    public E get(int i) {
        return mo147delegate().get(i);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return mo147delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return mo147delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return mo147delegate().listIterator();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E remove(int i) {
        return mo147delegate().remove(i);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E set(int i, E e) {
        return mo147delegate().set(i, e);
    }

    public boolean standardAdd(E e) {
        add(size(), e);
        return true;
    }

    public boolean standardAddAll(int i, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = listIterator(i);
        boolean z = false;
        for (E e : iterable) {
            listIterator.add(e);
            z = true;
        }
        return z;
    }

    @Beta
    public boolean standardEquals(@NullableDecl Object obj) {
        return Lists.b(this, obj);
    }

    @Beta
    public int standardHashCode() {
        int i;
        int i2 = 1;
        for (E e : this) {
            int i3 = i2 * 31;
            if (e == null) {
                i = 0;
            } else {
                i = e.hashCode();
            }
            i2 = ~(~(i3 + i));
        }
        return i2;
    }

    public int standardIndexOf(@NullableDecl Object obj) {
        return Lists.c(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@NullableDecl Object obj) {
        return Lists.d(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i, int i2) {
        List list;
        if (this instanceof RandomAccess) {
            list = new z1(this);
        } else {
            list = new a2(this);
        }
        return list.subList(i, i2);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return mo147delegate().subList(i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return mo147delegate().listIterator(i);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i) {
        return new Lists.a(this).listIterator(i);
    }
}
