package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class ImmutableList<E> implements List<E>, RandomAccess {
    public final List<E> a;

    public ImmutableList(List<E> list) {
        this.a = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e) {
        return this.a.add(e);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i) {
        return this.a.get(i);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.a.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.a.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i, @NonNull E e) {
        return this.a.set(i, e);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.a.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i, int i2) {
        return this.a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.a.toArray();
    }

    @NonNull
    public static <E> ImmutableList<E> from(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    @Override // java.util.List
    public void add(int i, @NonNull E e) {
        this.a.add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.a.addAll(i, collection);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.a.listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        return this.a.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.a.toArray(tArr);
    }
}
