package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
public final class zzasz implements Callable<zzasu> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzasw zzdut;

    public zzasz(zzasw zzasw, Context context) {
        this.zzdut = zzasw;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzasu call() throws Exception {
        zzasu zzasu;
        zzasy zzasy = (zzasy) this.zzdut.zzduq.get(this.val$context);
        if (zzasy != null) {
            if (!(zzacg.zzczs.get().longValue() + zzasy.zzdur < zzp.zzkw().currentTimeMillis())) {
                zzasu = new zzasx(this.val$context, zzasy.zzdus).zzvk();
                this.zzdut.zzduq.put(this.val$context, new zzasy(this.zzdut, zzasu));
                return zzasu;
            }
        }
        zzasu = new zzasx(this.val$context).zzvk();
        this.zzdut.zzduq.put(this.val$context, new zzasy(this.zzdut, zzasu));
        return zzasu;
    }
}
