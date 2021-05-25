package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
public final class zzbyr extends zzbxe<zzqu> implements zzqu {
    private final zzdkx zzfpf;
    @GuardedBy("this")
    private Map<View, zzqq> zzful = new WeakHashMap(1);
    private final Context zzvr;

    public zzbyr(Context context, Set<zzbys<zzqu>> set, zzdkx zzdkx) {
        super(set);
        this.zzvr = context;
        this.zzfpf = zzdkx;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void zza(zzqr zzqr) {
        zza(new zzbxg(zzqr) { // from class: com.google.android.gms.internal.ads.zzbyu
            private final zzqr zzfun;

            {
                this.zzfun = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzqu) obj).zza(this.zzfun);
            }
        });
    }

    public final synchronized void zzv(View view) {
        zzqq zzqq = this.zzful.get(view);
        if (zzqq == null) {
            zzqq = new zzqq(this.zzvr, view);
            zzqq.zza(this);
            this.zzful.put(view, zzqq);
        }
        zzdkx zzdkx = this.zzfpf;
        if (zzdkx != null && zzdkx.zzdsv) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpm)).booleanValue()) {
                zzqq.zzen(((Long) zzwe.zzpu().zzd(zzaat.zzcpl)).longValue());
                return;
            }
        }
        zzqq.zzlu();
    }

    public final synchronized void zzw(View view) {
        if (this.zzful.containsKey(view)) {
            this.zzful.get(view).zzb(this);
            this.zzful.remove(view);
        }
    }
}
