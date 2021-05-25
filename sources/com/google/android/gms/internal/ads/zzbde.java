package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
public interface zzbde extends zzajk, zzbgy, zzbhd {
    @Override // com.google.android.gms.internal.ads.zzbgt
    Context getContext();

    String getRequestId();

    void setBackgroundColor(int i);

    void zza(zzbgk zzbgk);

    void zza(String str, zzbev zzbev);

    void zza(boolean z, long j);

    void zzav(boolean z);

    zzbev zzfj(String str);

    void zzuw();

    @Nullable
    zzbcx zzzn();

    @Nullable
    zzbgk zzzo();

    @Nullable
    zzabi zzzp();

    @Override // com.google.android.gms.internal.ads.zzbgt
    Activity zzzq();

    zzb zzzr();

    zzabh zzzs();

    @Override // com.google.android.gms.internal.ads.zzbha
    zzbbg zzzt();

    int zzzu();

    int zzzv();

    void zzzw();
}
