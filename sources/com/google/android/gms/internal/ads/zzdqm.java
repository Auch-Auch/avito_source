package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdqt;
import com.google.android.gms.internal.ads.zzdra;
@ShowFirstParty
public final class zzdqm {
    private final Looper zzhji;
    private final Context zzvr;

    public zzdqm(@NonNull Context context, @NonNull Looper looper) {
        this.zzvr = context;
        this.zzhji = looper;
    }

    public final void zzhc(@NonNull String str) {
        new zzdql(this.zzvr, this.zzhji, (zzdra) ((zzegp) zzdra.zzavo().zzhf(this.zzvr.getPackageName()).zzb(zzdra.zza.BLOCKED_IMPRESSION).zza(zzdqt.zzavm().zzhe(str).zzb(zzdqt.zza.BLOCKED_REASON_BACKGROUND)).zzbfx())).zzavh();
    }
}
