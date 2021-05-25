package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzddz implements zzdek<Bundle> {
    private final String zzbra;
    private final int zzdqn;
    private final boolean zzdrk;
    private final boolean zzedt;
    private final boolean zzguv;
    private final int zzguw;
    private final int zzgux;

    public zzddz(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzguv = z;
        this.zzedt = z2;
        this.zzbra = str;
        this.zzdrk = z3;
        this.zzdqn = i;
        this.zzguw = i2;
        this.zzgux = i3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.zzbra);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzwe.zzpu().zzd(zzaat.zzcri));
        bundle2.putInt("target_api", this.zzdqn);
        bundle2.putInt("dv", this.zzguw);
        bundle2.putInt("lv", this.zzgux);
        Bundle zza = zzdlu.zza(bundle2, "sdk_env");
        zza.putBoolean("mf", zzaco.zzdax.get().booleanValue());
        zza.putBoolean("instant_app", this.zzguv);
        zza.putBoolean("lite", this.zzedt);
        zza.putBoolean("is_privileged_process", this.zzdrk);
        bundle2.putBundle("sdk_env", zza);
        Bundle zza2 = zzdlu.zza(zza, "build_meta");
        zza2.putString("cl", "317778048");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
