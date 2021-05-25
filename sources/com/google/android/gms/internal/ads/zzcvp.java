package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbuc;
import java.util.Iterator;
public final class zzcvp<AdT, AdapterT, ListenerT extends zzbuc> implements zzcre<AdT> {
    private final zzcrf<AdapterT, ListenerT> zzfkl;
    private final zzdpf zzfqo;
    private final zzcrh<AdT, AdapterT, ListenerT> zzgoh;
    private final zzdvw zzgoi;

    public zzcvp(zzdpf zzdpf, zzdvw zzdvw, zzcrf<AdapterT, ListenerT> zzcrf, zzcrh<AdT, AdapterT, ListenerT> zzcrh) {
        this.zzfqo = zzdpf;
        this.zzgoi = zzdvw;
        this.zzgoh = zzcrh;
        this.zzfkl = zzcrf;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        return !zzdkx.zzhap.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<AdT> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        zzcrg<AdapterT, ListenerT> zzcrg;
        Iterator<String> it = zzdkx.zzhap.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcrg = null;
                break;
            }
            try {
                zzcrg = this.zzfkl.zzf(it.next(), zzdkx.zzhar);
                break;
            } catch (zzdlr unused) {
            }
        }
        if (zzcrg == null) {
            return zzdvl.immediateFailedFuture(new zzctt("unable to instantiate mediation adapter class"));
        }
        zzbbq zzbbq = new zzbbq();
        zzcrg.zzglc.zza(new zzcvu(this, zzcrg, zzbbq));
        if (zzdkx.zzduo) {
            Bundle bundle = zzdlj.zzhbp.zzfqn.zzhbu.zzchc;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfqo.zzu(zzdpg.ADAPTER_LOAD_AD_SYN).zza(new zzdop(this, zzdlj, zzdkx, zzcrg) { // from class: com.google.android.gms.internal.ads.zzcvs
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcrg zzgod;
            private final zzcvp zzgoj;

            {
                this.zzgoj = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
                this.zzgod = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzdop
            public final void run() {
                this.zzgoj.zzd(this.zzgbj, this.zzfoo, this.zzgod);
            }
        }, this.zzgoi).zzw(zzdpg.ADAPTER_LOAD_AD_ACK).zze(zzbbq).zzw(zzdpg.ADAPTER_WRAP_ADAPTER).zzb(new zzdoq(this, zzdlj, zzdkx, zzcrg) { // from class: com.google.android.gms.internal.ads.zzcvr
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcrg zzgod;
            private final zzcvp zzgoj;

            {
                this.zzgoj = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
                this.zzgod = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzdoq
            public final Object apply(Object obj) {
                return this.zzgoj.zza(this.zzgbj, this.zzfoo, this.zzgod, (Void) obj);
            }
        }).zzauz();
    }

    public final /* synthetic */ void zzd(zzdlj zzdlj, zzdkx zzdkx, zzcrg zzcrg) throws Exception {
        this.zzgoh.zza(zzdlj, zzdkx, zzcrg);
    }

    @VisibleForTesting
    public static String zza(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    public final /* synthetic */ Object zza(zzdlj zzdlj, zzdkx zzdkx, zzcrg zzcrg, Void r4) throws Exception {
        return this.zzgoh.zzb(zzdlj, zzdkx, zzcrg);
    }
}
