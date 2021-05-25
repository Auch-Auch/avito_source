package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
public final class zzal {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final zzan zze;
    private final String zzf;

    private zzal(zzgd zzgd, String str, String str2, String str3, long j, long j2, zzan zzan) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzan);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgd.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzez.zza(str2), zzez.zza(str3));
        }
        this.zze = zzan;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder K = a.K(valueOf.length() + a.q0(str2, a.q0(str, 33)), "Event{appId='", str, "', name='", str2);
        K.append("', params=");
        K.append(valueOf);
        K.append('}');
        return K.toString();
    }

    public final zzal zza(zzgd zzgd, long j) {
        return new zzal(zzgd, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public zzal(zzgd zzgd, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzan zzan;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgd.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzez.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzan = new zzan(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgd.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzgd.zzi().zza(next, bundle2.get(next));
                    if (zza2 == null) {
                        zzgd.zzr().zzi().zza("Param value can't be null", zzgd.zzj().zzb(next));
                        it.remove();
                    } else {
                        zzgd.zzi().zza(bundle2, next, zza2);
                    }
                }
            }
            zzan = new zzan(bundle2);
        }
        this.zze = zzan;
    }
}
