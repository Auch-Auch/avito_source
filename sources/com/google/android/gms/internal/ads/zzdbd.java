package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
public final class zzdbd implements zzden<zzdba> {
    private final zzdvw zzgay;
    private final Context zzvr;

    public zzdbd(zzdvw zzdvw, Context context) {
        this.zzgay = zzdvw;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdba> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdbc
            private final zzdbd zzgtj;

            {
                this.zzgtj = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgtj.zzaqx();
            }
        });
    }

    public final /* synthetic */ zzdba zzaqx() throws Exception {
        double d;
        Intent registerReceiver = this.zzvr.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d = ((double) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) registerReceiver.getIntExtra("scale", -1));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzdba(d, z);
    }
}
