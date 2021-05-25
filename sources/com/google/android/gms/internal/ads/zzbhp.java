package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzbhp {
    public static zzbfq zza(Context context, zzbhj zzbhj, String str, boolean z, boolean z2, @Nullable zzeg zzeg, zzabt zzabt, zzbbg zzbbg, zzabk zzabk, zzk zzk, zzb zzb, zzto zzto, zzsq zzsq, boolean z3) throws zzbgc {
        try {
            return (zzbfq) zzbal.zza(new zzdsz(context, zzbhj, str, z, z2, zzeg, zzabt, zzbbg, null, zzk, zzb, zzto, zzsq, z3) { // from class: com.google.android.gms.internal.ads.zzbho
                private final Context zzcxz;
                private final String zzdin;
                private final zzbhj zzems;
                private final boolean zzemt;
                private final boolean zzemu;
                private final zzeg zzemv;
                private final zzabt zzemw;
                private final zzbbg zzemx;
                private final zzabk zzemy;
                private final zzk zzemz;
                private final zzb zzena;
                private final zzto zzenb;
                private final zzsq zzenc;
                private final boolean zzend;

                {
                    this.zzcxz = r1;
                    this.zzems = r2;
                    this.zzdin = r3;
                    this.zzemt = r4;
                    this.zzemu = r5;
                    this.zzemv = r6;
                    this.zzemw = r7;
                    this.zzemx = r8;
                    this.zzemy = r9;
                    this.zzemz = r10;
                    this.zzena = r11;
                    this.zzenb = r12;
                    this.zzenc = r13;
                    this.zzend = r14;
                }

                @Override // com.google.android.gms.internal.ads.zzdsz
                public final Object get() {
                    Context context2 = this.zzcxz;
                    zzbhj zzbhj2 = this.zzems;
                    String str2 = this.zzdin;
                    boolean z4 = this.zzemt;
                    boolean z5 = this.zzemu;
                    zzeg zzeg2 = this.zzemv;
                    zzabt zzabt2 = this.zzemw;
                    zzbbg zzbbg2 = this.zzemx;
                    zzabk zzabk2 = this.zzemy;
                    zzk zzk2 = this.zzemz;
                    zzb zzb2 = this.zzena;
                    zzto zzto2 = this.zzenb;
                    zzsq zzsq2 = this.zzenc;
                    boolean z7 = this.zzend;
                    zzbhi zzbhi = new zzbhi();
                    zzbhr zzbhr = new zzbhr(new zzbhg(context2), zzbhi, zzbhj2, str2, z4, z5, zzeg2, zzabt2, zzbbg2, zzabk2, zzk2, zzb2, zzto2, zzsq2, z7);
                    zzbgf zzbgf = new zzbgf(zzbhr);
                    zzbhr.setWebChromeClient(new zzbfi(zzbgf));
                    zzbhi.zza(zzbgf, z5);
                    return zzbgf;
                }
            });
        } catch (Throwable th) {
            zzp.zzkt().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbgc("Webview initialization failed.", th);
        }
    }
}
