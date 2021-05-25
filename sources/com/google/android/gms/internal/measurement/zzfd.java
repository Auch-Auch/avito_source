package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
public abstract class zzfd<E> extends zzfc<E> implements zzfx<E>, NavigableSet<E> {
    public final transient Comparator<? super E> zza;
    private transient zzfd<E> zzb;

    public zzfd(Comparator<? super E> comparator) {
        this.zza = comparator;
    }

    public static <E> zzfs<E> zza(Comparator<? super E> comparator) {
        return zzfi.zza.equals(comparator) ? (zzfs<E>) zzfs.zzb : new zzfs<>(zzeq.zza(), comparator);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return (E) zzff.zza((zzfd) tailSet(e, true), null);
    }

    @Override // com.google.android.gms.internal.measurement.zzfx, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.zza;
    }

    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet descendingSet() {
        zzfd<E> zzfd = this.zzb;
        if (zzfd != null) {
            return zzfd;
        }
        zzfd<E> zzi = zzi();
        this.zzb = zzi;
        zzi.zzb = this;
        return zzi;
    }

    @Override // java.util.SortedSet
    public E first() {
        return (E) ((zzfz) iterator()).next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return (E) zzfe.zza((zzfz) ((zzfd) headSet(e, true)).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet headSet(Object obj) {
        return (zzfd) headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return (E) zzff.zza((zzfd) tailSet(e, false), null);
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.SortedSet
    public E last() {
        return (E) ((zzfz) descendingIterator()).next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return (E) zzfe.zza((zzfz) ((zzfd) headSet(e, false)).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return (zzfd) subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet tailSet(Object obj) {
        return (zzfd) tailSet(obj, true);
    }

    public abstract zzfd<E> zza(E e, boolean z);

    public abstract zzfd<E> zza(E e, boolean z, E e2, boolean z2);

    public abstract zzfd<E> zzb(E e, boolean z);

    public abstract zzfd<E> zzi();

    /* renamed from: zzj */
    public abstract zzfz<E> descendingIterator();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.measurement.zzfd<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return zza((zzfd<E>) zzdq.zza(obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        zzdq.zza(obj);
        zzdq.zza(obj2);
        if (this.zza.compare(obj, obj2) <= 0) {
            return zza(obj, z, obj2, z2);
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.measurement.zzfd<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return zzb((zzfd<E>) zzdq.zza(obj), z);
    }

    public final int zza(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }
}
