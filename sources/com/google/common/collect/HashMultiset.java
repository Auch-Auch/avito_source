package com.google.common.collect;

import a2.j.d.c.f;
import a2.j.d.c.v2;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public class HashMultiset<E> extends f<E> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    public HashMultiset(int i) {
        super(i);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // a2.j.d.c.f
    public void e(int i) {
        this.c = new v2<>(i);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo6elementSet() {
        return super.mo6elementSet();
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E> HashMultiset<E> create(int i) {
        return new HashMultiset<>(i);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(Multisets.c(iterable));
        Iterables.addAll(create, iterable);
        return create;
    }
}
