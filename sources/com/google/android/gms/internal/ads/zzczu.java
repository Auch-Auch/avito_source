package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
public final class zzczu implements zzden<zzczv> {
    private final zzaxk zzbps;
    private final zzdln zzfqn;
    private final zzden<zzdeq> zzgsl;
    private final Context zzvr;

    public zzczu(zzdbj<zzdeq> zzdbj, zzdln zzdln, Context context, zzaxk zzaxk) {
        this.zzgsl = zzdbj;
        this.zzfqn = zzdln;
        this.zzvr = context;
        this.zzbps = zzaxk;
    }

    public final /* synthetic */ zzczv zza(zzdeq zzdeq) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        DisplayMetrics displayMetrics;
        zzvj zzvj = this.zzfqn.zzbpb;
        zzvj[] zzvjArr = zzvj.zzcho;
        if (zzvjArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvj zzvj2 : zzvjArr) {
                boolean z4 = zzvj2.zzchp;
                if (!z4 && !z2) {
                    str = zzvj2.zzacx;
                    z2 = true;
                }
                if (z4 && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvj.zzacx;
            z = zzvj.zzchp;
        }
        Resources resources = this.zzvr.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbps.zzwj().zzxk();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzvj[] zzvjArr2 = zzvj.zzcho;
        if (zzvjArr2 != null) {
            boolean z5 = false;
            for (zzvj zzvj3 : zzvjArr2) {
                if (zzvj3.zzchp) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i5 = zzvj3.width;
                    if (i5 == -1 && f != 0.0f) {
                        i5 = (int) (((float) zzvj3.widthPixels) / f);
                    }
                    sb.append(i5);
                    sb.append("x");
                    int i6 = zzvj3.height;
                    if (i6 == -2) {
                        if (f != 0.0f) {
                            i6 = (int) (((float) zzvj3.heightPixels) / f);
                        }
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzczv(zzvj, str, z, sb.toString(), f, i2, i, str2, this.zzfqn.zzgso);
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzczv> zzaqs() {
        return zzdvl.zzb(this.zzgsl.zzaqs(), new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzczx
            private final zzczu zzgsq;

            {
                this.zzgsq = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return this.zzgsq.zza((zzdeq) obj);
            }
        }, zzbbi.zzedz);
    }
}
