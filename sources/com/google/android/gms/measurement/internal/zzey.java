package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;
public final class zzey implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzez zzf;

    public zzey(zzez zzez, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzez;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfl zzc2 = this.zzf.zzy.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzg()) {
                    zzez zzez = this.zzf;
                    zzez.zzu();
                    zzez.zza = 'C';
                } else {
                    zzez zzez2 = this.zzf;
                    zzez2.zzu();
                    zzez2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzez zzez3 = this.zzf;
                zzez3.zzb = zzez3.zzt().zzf();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char c = this.zzf.zza;
            long j = this.zzf.zzb;
            String zza2 = zzez.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(c);
            sb.append(j);
            sb.append(":");
            sb.append(zza2);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
