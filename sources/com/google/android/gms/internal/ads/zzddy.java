package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;
public final class zzddy implements zzden<zzddz> {
    private final zzbbg zzbpa;
    private final zzdvw zzgay;
    private final Context zzvr;

    public zzddy(zzdvw zzdvw, Context context, zzbbg zzbbg) {
        this.zzgay = zzdvw;
        this.zzvr = context;
        this.zzbpa = zzbbg;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzddz> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdeb
            private final zzddy zzguy;

            {
                this.zzguy = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguy.zzarg();
            }
        });
    }

    public final /* synthetic */ zzddz zzarg() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzvr).isCallerInstantApp();
        zzp.zzkp();
        boolean zzaz = zzayh.zzaz(this.zzvr);
        String str = this.zzbpa.zzbra;
        zzp.zzkr();
        boolean zzxu = zzaym.zzxu();
        zzp.zzkp();
        return new zzddz(isCallerInstantApp, zzaz, str, zzxu, zzayh.zzaw(this.zzvr), DynamiteModule.getRemoteVersion(this.zzvr, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzvr, ModuleDescriptor.MODULE_ID));
    }
}
