package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;
public final class zzcsd implements zzcre<zzbzr> {
    private final zzdkv zzfld;
    private final Executor zzfmk;
    private final zzcar zzglr;
    private final Context zzvr;

    public zzcsd(Context context, Executor executor, zzcar zzcar, zzdkv zzdkv) {
        this.zzvr = context;
        this.zzglr = zzcar;
        this.zzfmk = executor;
        this.zzfld = zzdkv;
    }

    private static String zze(zzdkx zzdkx) {
        try {
            return zzdkx.zzhar.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        return (this.zzvr instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabu.zzk(this.zzvr) && !TextUtils.isEmpty(zze(zzdkx));
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzbzr> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        String zze = zze(zzdkx);
        return zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this, zze != null ? Uri.parse(zze) : null, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcsg
            private final Uri zzeag;
            private final zzcsd zzgls;
            private final zzdlj zzglt;
            private final zzdkx zzglu;

            {
                this.zzgls = r1;
                this.zzeag = r2;
                this.zzglt = r3;
                this.zzglu = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgls.zza(this.zzeag, this.zzglt, this.zzglu, obj);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ zzdvt zza(Uri uri, zzdlj zzdlj, zzdkx zzdkx, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzd zzd = new zzd(build.intent);
            zzbbq zzbbq = new zzbbq();
            zzbzt zza = this.zzglr.zza(new zzbpt(zzdlj, zzdkx, null), new zzbzw(new zzcaz(zzbbq) { // from class: com.google.android.gms.internal.ads.zzcsf
                private final zzbbq zzbvp;

                {
                    this.zzbvp = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzcaz
                public final void zza(boolean z, Context context) {
                    zzbbq zzbbq2 = this.zzbvp;
                    try {
                        zzp.zzko();
                        zzn.zza(context, (AdOverlayInfoParcel) zzbbq2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbbq.set(new AdOverlayInfoParcel(zzd, null, zza.zzagc(), null, new zzbbg(0, 0, false)));
            this.zzfld.zzwf();
            return zzdvl.zzaf(zza.zzagb());
        } catch (Throwable th) {
            zzbbd.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
