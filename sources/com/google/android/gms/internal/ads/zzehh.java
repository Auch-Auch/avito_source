package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
public final class zzehh extends zzeez<String> implements zzehk, RandomAccess {
    private static final zzehh zzihf;
    private static final zzehk zzihg;
    private final List<Object> zzihh;

    static {
        zzehh zzehh = new zzehh();
        zzihf = zzehh;
        zzehh.zzbdg();
        zzihg = zzehh;
    }

    public zzehh() {
        this(10);
    }

    private static String zzal(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeff) {
            return ((zzeff) obj).zzbdj();
        }
        return zzegr.zzz((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbdh();
        this.zzihh.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final void clear() {
        zzbdh();
        this.zzihh.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzihh.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeff) {
            zzeff zzeff = (zzeff) obj;
            String zzbdj = zzeff.zzbdj();
            if (zzeff.zzbdk()) {
                this.zzihh.set(i, zzbdj);
            }
            return zzbdj;
        }
        byte[] bArr = (byte[]) obj;
        String zzz = zzegr.zzz(bArr);
        if (zzegr.zzy(bArr)) {
            this.zzihh.set(i, zzz);
        }
        return zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbdh();
        return zzal(this.zzihh.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zzihh.size();
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final void zzaj(zzeff zzeff) {
        zzbdh();
        this.zzihh.add(zzeff);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, com.google.android.gms.internal.ads.zzeha
    public final /* bridge */ /* synthetic */ boolean zzbdf() {
        return super.zzbdf();
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final List<?> zzbgn() {
        return Collections.unmodifiableList(this.zzihh);
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final zzehk zzbgo() {
        return zzbdf() ? new zzejs(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final /* synthetic */ zzeha zzft(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzihh);
            return new zzehh(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final Object zzhe(int i) {
        return this.zzihh.get(i);
    }

    public zzehh(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbdh();
        if (collection instanceof zzehk) {
            collection = ((zzehk) collection).zzbgn();
        }
        boolean addAll = this.zzihh.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbdh();
        Object remove = this.zzihh.remove(i);
        ((AbstractList) this).modCount++;
        return zzal(remove);
    }

    private zzehh(ArrayList<Object> arrayList) {
        this.zzihh = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzeez, java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
