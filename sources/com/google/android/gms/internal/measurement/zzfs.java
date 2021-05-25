package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzfs<E> extends zzfd<E> {
    public static final zzfs<Comparable> zzb = new zzfs<>(zzeq.zza(), zzfi.zza);
    private final transient zzeq<E> zzc;

    public zzfs(zzeq<E> zzeq, Comparator<? super E> comparator) {
        super(comparator);
        this.zzc = zzeq;
    }

    private final int zzc(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.zzc, zzdq.zza(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return ~binarySearch;
    }

    private final int zzd(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.zzc, zzdq.zza(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return ~binarySearch;
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.NavigableSet
    public final E ceiling(E e) {
        int zzd = zzd(e, true);
        if (zzd == size()) {
            return null;
        }
        return this.zzc.get(zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzc, obj, ((zzfd) this).zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof zzfj) {
            collection = ((zzfj) collection).zza();
        }
        if (!zzfw.zza(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzfz zzfz = (zzfz) iterator();
        Iterator<?> it = collection.iterator();
        if (!zzfz.hasNext()) {
            return false;
        }
        Object next = it.next();
        Object next2 = zzfz.next();
        while (true) {
            try {
                int zza = zza(next2, next);
                if (zza < 0) {
                    if (!zzfz.hasNext()) {
                        return false;
                    }
                    next2 = zzfz.next();
                } else if (zza == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (zza > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }] */
    @Override // com.google.android.gms.internal.measurement.zzey, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Comparator<? super E> r1 = r5.zza
            boolean r1 = com.google.android.gms.internal.measurement.zzfw.zza(r1, r6)
            if (r1 == 0) goto L_0x0049
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r1 = r5.iterator()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            com.google.android.gms.internal.measurement.zzfz r1 = (com.google.android.gms.internal.measurement.zzfz) r1     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
        L_0x0030:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r3 == 0) goto L_0x0047
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            java.lang.Object r4 = r6.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r4 == 0) goto L_0x0046
            int r3 = r5.zza(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x0048 }
            if (r3 == 0) goto L_0x0030
        L_0x0046:
            return r2
        L_0x0047:
            return r0
        L_0x0048:
            return r2
        L_0x0049:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfs.equals(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.SortedSet
    public final E first() {
        if (!isEmpty()) {
            return this.zzc.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.NavigableSet
    public final E floor(E e) {
        int zzc2 = zzc(e, true) - 1;
        if (zzc2 == -1) {
            return null;
        }
        return this.zzc.get(zzc2);
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.NavigableSet
    public final E higher(E e) {
        int zzd = zzd(e, false);
        if (zzd == size()) {
            return null;
        }
        return this.zzc.get(zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.SortedSet
    public final E last() {
        if (!isEmpty()) {
            return this.zzc.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.measurement.zzfd, java.util.NavigableSet
    public final E lower(E e) {
        int zzc2 = zzc(e, false) - 1;
        if (zzc2 == -1) {
            return null;
        }
        return this.zzc.get(zzc2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzfd
    public final zzfd<E> zza(E e, boolean z) {
        return zza(0, zzc(e, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<E> iterator() {
        return (zzfz) this.zzc.iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return this.zzc.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzfd
    public final zzfd<E> zzi() {
        Comparator reverseOrder = Collections.reverseOrder(((zzfd) this).zza);
        if (isEmpty()) {
            return zzfd.zza(reverseOrder);
        }
        return new zzfs(this.zzc.zzd(), reverseOrder);
    }

    @Override // com.google.android.gms.internal.measurement.zzfd
    /* renamed from: zzj */
    public final zzfz<E> descendingIterator() {
        return (zzfz) this.zzc.zzd().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzfd
    public final zzfd<E> zza(E e, boolean z, E e2, boolean z2) {
        return zzb(e, z).zza(e2, z2);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        return this.zzc.zzb(objArr, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzer
    public final zzeq<E> zzc() {
        return this.zzc;
    }

    private final zzfs<E> zza(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new zzfs<>((zzeq) this.zzc.subList(i, i2), ((zzfd) this).zza);
        }
        return zzfd.zza(((zzfd) this).zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzfd
    public final zzfd<E> zzb(E e, boolean z) {
        return zza(zzd(e, z), size());
    }
}
