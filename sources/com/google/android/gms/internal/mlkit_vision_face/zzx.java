package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class zzx extends zzv implements List<V> {
    public final /* synthetic */ zzm zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(@NullableDecl zzm zzm, K k, @NullableDecl List<V> list, zzv zzv) {
        super(zzm, k, list, zzv);
        this.zzd = zzm;
    }

    @Override // java.util.List
    public void add(int i, V v) {
        zza();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, v);
        zzm.zzc(this.zzd);
        if (isEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (addAll) {
            zzm.zza(this.zzd, this.zzb.size() - size);
            if (size == 0) {
                zzc();
            }
        }
        return addAll;
    }

    @Override // java.util.List
    public V get(int i) {
        zza();
        return (V) ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<V> listIterator() {
        zza();
        return new zzw(this);
    }

    @Override // java.util.List
    public V remove(int i) {
        zza();
        V v = (V) ((List) this.zzb).remove(i);
        zzm.zzb(this.zzd);
        zzb();
        return v;
    }

    @Override // java.util.List
    public V set(int i, V v) {
        zza();
        return (V) ((List) this.zzb).set(i, v);
    }

    @Override // java.util.List
    public List<V> subList(int i, int i2) {
        zza();
        zzm zzm = this.zzd;
        K k = this.zza;
        List subList = ((List) this.zzb).subList(i, i2);
        zzv zzv = this.zzc;
        if (zzv == null) {
            zzv = this;
        }
        return zzm.zza(k, subList, zzv);
    }

    @Override // java.util.List
    public ListIterator<V> listIterator(int i) {
        zza();
        return new zzw(this, i);
    }
}
