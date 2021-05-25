package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
public final class zzaxv implements zzrh {
    private final Object lock = new Object();
    private final zzaya zzdza;
    private final zzaxt zzdzg;
    @VisibleForTesting
    private final zzaxr zzdzh;
    @VisibleForTesting
    private final HashSet<zzaxj> zzdzi = new HashSet<>();
    @VisibleForTesting
    private final HashSet<zzaxs> zzdzj = new HashSet<>();

    public zzaxv(String str, zzaya zzaya) {
        this.zzdzh = new zzaxr(str, zzaya);
        this.zzdza = zzaya;
        this.zzdzg = new zzaxt();
    }

    public final Bundle zza(Context context, zzaxq zzaxq) {
        HashSet<zzaxj> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzdzi);
            this.zzdzi.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzdzh.zzp(context, this.zzdzg.zzwu()));
        Bundle bundle2 = new Bundle();
        Iterator<zzaxs> it = this.zzdzj.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzaxj> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaxq.zza(hashSet);
            return bundle;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final void zzb(zzaxj zzaxj) {
        synchronized (this.lock) {
            this.zzdzi.add(zzaxj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        long currentTimeMillis = zzp.zzkw().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzdza.zzxf() > ((Long) zzwe.zzpu().zzd(zzaat.zzcof)).longValue()) {
                this.zzdzh.zzdyx = -1;
                return;
            }
            this.zzdzh.zzdyx = this.zzdza.zzxg();
            return;
        }
        this.zzdza.zzez(currentTimeMillis);
        this.zzdza.zzdg(this.zzdzh.zzdyx);
    }

    public final void zzvz() {
        synchronized (this.lock) {
            this.zzdzh.zzvz();
        }
    }

    public final void zzwa() {
        synchronized (this.lock) {
            this.zzdzh.zzwa();
        }
    }

    public final void zzb(HashSet<zzaxj> hashSet) {
        synchronized (this.lock) {
            this.zzdzi.addAll(hashSet);
        }
    }

    public final void zza(zzvc zzvc, long j) {
        synchronized (this.lock) {
            this.zzdzh.zza(zzvc, j);
        }
    }

    public final zzaxj zza(Clock clock, String str) {
        return new zzaxj(clock, this, this.zzdzg.zzwt(), str);
    }
}
