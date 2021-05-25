package com.google.common.collect;

import a2.j.d.c.b0;
import a2.j.d.c.d;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX WARN: Failed to parse class signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;><TKTV> */
@GwtCompatible(emulated = true, serializable = true)
public final class ArrayListMultimap extends d {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    public transient int h;

    public ArrayListMultimap(int i, int i2) {
        super(new b0(i));
        AppCompatDelegateImpl.i.z(i2, "expectedValuesPerKey");
        this.h = i2;
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap(12, 3);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.h = 3;
        int readInt = objectInputStream.readInt();
        s(new b0());
        AppCompatDelegateImpl.i.A1(this, objectInputStream, readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AppCompatDelegateImpl.i.u2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.d, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
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

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // a2.j.d.c.d, a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.d, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ List mo118get(@NullableDecl Object obj) {
        return super.mo118get((ArrayListMultimap) obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // a2.j.d.c.e
    public Collection n() {
        return new ArrayList(this.h);
    }

    @Override // a2.j.d.c.d, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
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

    @Override // a2.j.d.c.d, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ List mo119removeAll(@NullableDecl Object obj) {
        return super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.d, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ List mo120replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return super.mo120replaceValues((ArrayListMultimap) obj, iterable);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> it = this.f.values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> ArrayListMultimap<K, V> create(int i, int i2) {
        return new ArrayListMultimap(i, i2);
    }

    public static <K, V> ArrayListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        ArrayListMultimap<K, V> arrayListMultimap = new ArrayListMultimap(multimap.keySet().size(), multimap instanceof ArrayListMultimap ? ((ArrayListMultimap) multimap).h : 3);
        arrayListMultimap.putAll(multimap);
        return arrayListMultimap;
    }

    public ArrayListMultimap() {
        this(12, 3);
    }
}
