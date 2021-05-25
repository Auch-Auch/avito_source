package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
public final class zziv extends zzgi<String> implements zziu, RandomAccess {
    private static final zziv zzzr;
    private static final zziu zzzs;
    private final List<Object> zzzt;

    static {
        zziv zziv = new zziv();
        zzzr = zziv;
        zziv.zzej();
        zzzs = zziv;
    }

    public zziv() {
        this(10);
    }

    private static String zzm(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgs) {
            return ((zzgs) obj).zzfl();
        }
        return zzie.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzek();
        this.zzzt.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final void clear() {
        zzek();
        this.zzzt.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzzt.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgs) {
            zzgs zzgs = (zzgs) obj;
            String zzfl = zzgs.zzfl();
            if (zzgs.zzfm()) {
                this.zzzt.set(i, zzfl);
            }
            return zzfl;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzie.zzh(bArr);
        if (zzie.zzg(bArr)) {
            this.zzzt.set(i, zzh);
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzek();
        return zzm(this.zzzt.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zzzt.size();
    }

    @Override // com.google.android.gms.internal.vision.zzik
    public final /* synthetic */ zzik zzan(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzzt);
            return new zziv(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final Object zzbt(int i) {
        return this.zzzt.get(i);
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final void zzc(zzgs zzgs) {
        zzek();
        this.zzzt.add(zzgs);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, com.google.android.gms.internal.vision.zzik
    public final /* bridge */ /* synthetic */ boolean zzei() {
        return super.zzei();
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final List<?> zzhs() {
        return Collections.unmodifiableList(this.zzzt);
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final zziu zzht() {
        return zzei() ? new zzky(this) : this;
    }

    public zziv(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzek();
        if (collection instanceof zziu) {
            collection = ((zziu) collection).zzhs();
        }
        boolean addAll = this.zzzt.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzek();
        Object remove = this.zzzt.remove(i);
        ((AbstractList) this).modCount++;
        return zzm(remove);
    }

    private zziv(ArrayList<Object> arrayList) {
        this.zzzt = arrayList;
    }

    @Override // com.google.android.gms.internal.vision.zzgi, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
