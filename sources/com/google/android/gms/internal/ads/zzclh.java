package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public final class zzclh {
    private final Map<String, String> zzcyu = new ConcurrentHashMap();
    private final /* synthetic */ zzcli zzgfe;

    @VisibleForTesting
    public zzclh(zzcli zzcli) {
        this.zzgfe = zzcli;
    }

    /* access modifiers changed from: public */
    private final zzclh zzaoo() {
        this.zzcyu.putAll(this.zzgfe.zzgff);
        return this;
    }

    public final zzclh zza(zzdkz zzdkz) {
        this.zzcyu.put("gqi", zzdkz.zzdsg);
        return this;
    }

    public final void zzaop() {
        this.zzgfe.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzclk
            private final zzclh zzgfg;

            {
                this.zzgfg = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfg.zzaoq();
            }
        });
    }

    public final /* synthetic */ void zzaoq() {
        this.zzgfe.zzgfb.zzn(this.zzcyu);
    }

    public final zzclh zzd(zzdkx zzdkx) {
        this.zzcyu.put("aai", zzdkx.zzdjo);
        return this;
    }

    public final zzclh zzq(String str, String str2) {
        this.zzcyu.put(str, str2);
        return this;
    }
}
