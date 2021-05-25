package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzqa;
import java.util.List;
public final class zzes extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    public zzes(zzgd zzgd, long j) {
        super(zzgd);
        this.zzg = j;
    }

    @VisibleForTesting
    @WorkerThread
    private final String zzai() {
        if (!zzqa.zzb() || !zzt().zza(zzaq.zzbq)) {
            try {
                Class<?> loadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
    }

    @WorkerThread
    public final zzn zza(String str) {
        String str2;
        long j;
        boolean z;
        Boolean bool;
        zzd();
        zzb();
        String zzab = zzab();
        String zzac = zzac();
        zzw();
        String str3 = this.zzb;
        long zzaf = (long) zzaf();
        zzw();
        String str4 = this.zzd;
        long zzf2 = zzt().zzf();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzy.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j2 = this.zzf;
        boolean zzab2 = this.zzy.zzab();
        boolean z2 = !zzs().zzq;
        zzd();
        zzb();
        if (!this.zzy.zzab()) {
            str2 = null;
        } else {
            str2 = zzai();
        }
        zzgd zzgd = this.zzy;
        Long valueOf = Long.valueOf(zzgd.zzc().zzh.zza());
        if (valueOf.longValue() == 0) {
            j = zzgd.zza;
            z = zzab2;
        } else {
            z = zzab2;
            j = Math.min(zzgd.zza, valueOf.longValue());
        }
        int zzag = zzag();
        boolean booleanValue = zzt().zzi().booleanValue();
        zzy zzt = zzt();
        zzt.zzb();
        Boolean zze2 = zzt.zze("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zze2 == null || zze2.booleanValue()).booleanValue();
        zzfl zzs = zzs();
        zzs.zzd();
        boolean z3 = zzs.zzg().getBoolean("deferred_analytics_collection", false);
        String zzad = zzad();
        Boolean zze3 = zzt().zze("google_analytics_default_allow_ad_personalization_signals");
        if (zze3 == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(!zze3.booleanValue());
        }
        return new zzn(zzab, zzac, str3, zzaf, str4, zzf2, j2, str, z, z2, str2, 0, j, zzag, booleanValue, booleanValue2, z3, zzad, bool, this.zzg, zzt().zza(zzaq.zzbb) ? this.zzh : null, (!zzoe.zzb() || !zzt().zza(zzaq.zzbn)) ? null : zzae());
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b0 A[Catch:{ IllegalStateException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d1 A[Catch:{ IllegalStateException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d3 A[Catch:{ IllegalStateException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x026b  */
    @Override // com.google.android.gms.measurement.internal.zzg
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaa() {
        /*
        // Method dump skipped, instructions count: 724
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzes.zzaa():void");
    }

    public final String zzab() {
        zzw();
        return this.zza;
    }

    public final String zzac() {
        zzw();
        return this.zzj;
    }

    public final String zzad() {
        zzw();
        return this.zzk;
    }

    public final String zzae() {
        zzw();
        return this.zzl;
    }

    public final int zzaf() {
        zzw();
        return this.zzc;
    }

    public final int zzag() {
        zzw();
        return this.zzi;
    }

    @Nullable
    public final List<String> zzah() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
