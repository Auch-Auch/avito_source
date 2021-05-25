package com.google.common.collect;

import a2.j.d.c.b0;
import a2.j.d.c.c0;
import a2.j.d.c.l;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX WARN: Failed to parse class signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;><TKTV> */
@GwtCompatible(emulated = true, serializable = true)
public final class HashMultimap extends l {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    public transient int h;

    public HashMultimap() {
        this(12, 2);
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap(12, 2);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.h = 2;
        int readInt = objectInputStream.readInt();
        s(new b0(12));
        AppCompatDelegateImpl.i.A1(this, objectInputStream, readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AppCompatDelegateImpl.i.u2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
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

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Set mo118get(@NullableDecl Object obj) {
        return super.mo118get((HashMultimap) obj);
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
        return new c0(this.h);
    }

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

    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ Set mo119removeAll(@NullableDecl Object obj) {
        return super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Set mo120replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return super.mo120replaceValues((HashMultimap) obj, iterable);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public HashMultimap(int i, int i2) {
        super(new b0(i));
        this.h = 2;
        Preconditions.checkArgument(i2 >= 0);
        this.h = i2;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> HashMultimap<K, V> create(int i, int i2) {
        return new HashMultimap(i, i2);
    }

    public static <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new HashMultimap(multimap);
    }

    public HashMultimap(Multimap<? extends K, ? extends V> multimap) {
        super(new b0(multimap.keySet().size()));
        this.h = 2;
        putAll(multimap);
    }
}
