package com.google.common.collect;

import a2.j.d.c.m;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public class TreeMultimap<K, V> extends m<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient Comparator<? super K> h;
    public transient Comparator<? super V> i;

    public TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.h = comparator;
        this.i = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap<>(Ordering.natural(), Ordering.natural());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.h = (Comparator) Preconditions.checkNotNull((Comparator) objectInputStream.readObject());
        this.i = (Comparator) Preconditions.checkNotNull((Comparator) objectInputStream.readObject());
        s(new TreeMap(this.h));
        AppCompatDelegateImpl.i.A1(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(keyComparator());
        objectOutputStream.writeObject(valueComparator());
        AppCompatDelegateImpl.i.u2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        return p();
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@NullableDecl Object obj) {
        return super.containsKey(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.h;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // a2.j.d.c.e
    public Collection n() {
        return new TreeSet(this.i);
    }

    @Override // a2.j.d.c.e
    public Collection<V> o(@NullableDecl K k) {
        if (k == null) {
            keyComparator().compare(k, k);
        }
        return n();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ SortedSet mo119removeAll(@NullableDecl Object obj) {
        return super.mo119removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ SortedSet mo120replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return super.mo120replaceValues((TreeMultimap<K, V>) obj, iterable);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public Comparator<? super V> valueComparator() {
        return this.i;
    }

    @Override // a2.j.d.c.p, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // a2.j.d.c.p
    public SortedSet<V> x() {
        return new TreeSet(this.i);
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) Preconditions.checkNotNull(comparator), (Comparator) Preconditions.checkNotNull(comparator2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        TreeMultimap<K, V> treeMultimap = new TreeMultimap<>(Ordering.natural(), Ordering.natural());
        treeMultimap.putAll(multimap);
        return treeMultimap;
    }

    @Override // a2.j.d.c.m, a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // a2.j.d.c.m, a2.j.d.c.h, com.google.common.collect.Multimap
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @GwtIncompatible
    /* renamed from: get */
    public NavigableSet<V> mo118get(@NullableDecl K k) {
        return (NavigableSet) super.mo118get((TreeMultimap<K, V>) k);
    }
}
