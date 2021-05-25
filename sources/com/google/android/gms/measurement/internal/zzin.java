package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.avito.android.BuildConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zznt;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;
public final class zzin extends zzg {
    @VisibleForTesting
    public zzik zza;
    private volatile zzik zzb;
    private zzik zzc;
    private final Map<Activity, zzik> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzik zzg;
    private zzik zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private zzik zzk;
    private String zzl;

    public zzin(zzgd zzgd) {
        super(zzgd);
    }

    @MainThread
    private final zzik zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzik zzik = this.zzd.get(activity);
        if (zzik == null) {
            zzik zzik2 = new zzik(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
            this.zzd.put(activity, zzik2);
            zzik = zzik2;
        }
        return (zzt().zza(zzaq.zzcc) && this.zzg != null) ? this.zzg : zzik;
    }

    @WorkerThread
    public final zzik zza(boolean z) {
        zzw();
        zzd();
        if (!zzt().zza(zzaq.zzcc) || !z) {
            return this.zza;
        }
        zzik zzik = this.zza;
        return zzik != null ? zzik : this.zzh;
    }

    public final zzik zzab() {
        zzb();
        return this.zzb;
    }

    @MainThread
    public final void zzb(Activity activity) {
        if (zzt().zza(zzaq.zzcc)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = zzm().elapsedRealtime();
        if (!zzt().zza(zzaq.zzcb) || zzt().zzj().booleanValue()) {
            zzik zzd2 = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzq().zza(new zziq(this, zzd2, elapsedRealtime));
            return;
        }
        this.zzb = null;
        zzq().zza(new zzir(this, elapsedRealtime));
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzt().zzj().booleanValue()) {
            this.zzd.remove(activity);
        }
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
        return false;
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        String str2;
        if (!zzt().zza(zzaq.zzcc)) {
            zzr().zzk().zza("Manual screen reporting is disabled.");
            return;
        }
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzr().zzk().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            str = null;
            if (bundle != null) {
                String string = bundle.getString(VKApiUserFull.SCREEN_NAME);
                if (string == null || (string.length() > 0 && string.length() <= 100)) {
                    String string2 = bundle.getString("screen_class");
                    if (string2 == null || (string2.length() > 0 && string2.length() <= 100)) {
                        str2 = string;
                        str = string2;
                    } else {
                        zzr().zzk().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    }
                } else {
                    zzr().zzk().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
            } else {
                str2 = null;
            }
            if (str == null) {
                Activity activity = this.zze;
                str = activity != null ? zza(activity.getClass().getCanonicalName()) : "Activity";
            }
            if (this.zzf && this.zzb != null) {
                this.zzf = false;
                boolean zzc2 = zzkw.zzc(this.zzb.zzb, str);
                boolean zzc3 = zzkw.zzc(this.zzb.zza, str2);
                if (zzc2 && zzc3) {
                    zzr().zzk().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
        }
        zzr().zzx().zza("Logging screen view with name, class", str2 == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : str2, str == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : str);
        zzik zzik = this.zzb == null ? this.zzc : this.zzb;
        zzik zzik2 = new zzik(str2, str, zzp().zzg(), true, j);
        this.zzb = zzik2;
        this.zzc = zzik;
        this.zzg = zzik2;
        zzq().zza(new zzim(this, bundle, zzik2, zzik, zzm().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzik zzik;
        if (zzt().zzj().booleanValue() && bundle != null && (zzik = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzik.zzc);
            bundle2.putString("name", zzik.zza);
            bundle2.putString("referrer_name", zzik.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(Bundle bundle, @NonNull zzik zzik, zzik zzik2, long j) {
        if (bundle != null) {
            bundle.remove(VKApiUserFull.SCREEN_NAME);
            bundle.remove("screen_class");
        }
        zza(zzik, zzik2, j, true, zzp().zza((String) null, "screen_view", bundle, (List<String>) null, true, true));
    }

    @MainThread
    public final void zza(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        if (!zzt().zzj().booleanValue()) {
            zzr().zzk().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc2 = zzkw.zzc(this.zzb.zzb, str2);
            boolean zzc3 = zzkw.zzc(this.zzb.zza, str);
            if (zzc2 && zzc3) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : str, str2);
                zzik zzik = new zzik(str, str2, zzp().zzg());
                this.zzd.put(activity, zzik);
                zza(activity, zzik, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @MainThread
    private final void zza(Activity activity, zzik zzik, boolean z) {
        zzik zzik2;
        zzik zzik3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzik.zzb == null) {
            zzik2 = new zzik(zzik.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzik.zzc, zzik.zze, zzik.zzf);
        } else {
            zzik2 = zzik;
        }
        this.zzc = this.zzb;
        this.zzb = zzik2;
        zzq().zza(new zzip(this, zzik2, zzik3, zzm().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzik zzik, zzik zzik2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        long j3;
        zzik zzik3;
        zzd();
        boolean z3 = false;
        if (zzt().zza(zzaq.zzat)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzik3 = this.zza) != null) {
                zza(zzik3, true, j);
            }
            z2 = false;
        }
        if (zzik2 == null || zzik2.zzc != zzik.zzc || !zzkw.zzc(zzik2.zzb, zzik.zzb) || !zzkw.zzc(zzik2.zza, zzik.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzt().zza(zzaq.zzcc)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            zza(zzik, bundle2, true);
            if (zzik2 != null) {
                String str = zzik2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzik2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzik2.zzc);
            }
            if (zzt().zza(zzaq.zzat) && z2) {
                if (!zznt.zzb() || !zzt().zza(zzaq.zzav) || !zznh.zzb() || !zzt().zza(zzaq.zzbz)) {
                    j3 = zzk().zzb.zzb();
                } else {
                    j3 = zzk().zza(j);
                }
                if (j3 > 0) {
                    zzp().zza(bundle2, j3);
                }
            }
            boolean zza2 = zzt().zza(zzaq.zzcc);
            String str3 = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            if (zza2) {
                if (!zzt().zzj().booleanValue()) {
                    bundle2.putLong("_mt", 1);
                }
                if (zzik.zze) {
                    str3 = "app";
                }
            }
            if (zzt().zza(zzaq.zzcc)) {
                long currentTimeMillis = zzm().currentTimeMillis();
                if (zzik.zze) {
                    long j4 = zzik.zzf;
                    if (j4 != 0) {
                        j2 = j4;
                        zzf().zza(str3, "_vs", j2, bundle2);
                    }
                }
                j2 = currentTimeMillis;
                zzf().zza(str3, "_vs", j2, bundle2);
            } else {
                zzf().zzb(str3, "_vs", bundle2);
            }
        }
        this.zza = zzik;
        if (zzt().zza(zzaq.zzcc) && zzik.zze) {
            this.zzh = zzik;
        }
        zzh().zza(zzik);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzik zzik, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzik != null && zzik.zzd, z, j) && zzik != null) {
            zzik.zzd = false;
        }
    }

    public static void zza(zzik zzik, Bundle bundle, boolean z) {
        if (bundle != null && zzik != null && (!bundle.containsKey("_sc") || z)) {
            String str = zzik.zza;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = zzik.zzb;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzik.zzc);
        } else if (bundle != null && zzik == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzik zzik) {
        zzd();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzik != null) {
                this.zzl = str;
                this.zzk = zzik;
            }
        }
    }

    @VisibleForTesting
    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzt().zzj().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzik(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zza(Activity activity) {
        if (zzt().zza(zzaq.zzcc)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzt().zza(zzaq.zzcb) && zzt().zzj().booleanValue()) {
                        this.zzg = null;
                        zzq().zza(new zzit(this));
                    }
                }
            }
        }
        if (!zzt().zza(zzaq.zzcb) || zzt().zzj().booleanValue()) {
            zza(activity, zzd(activity), false);
            zza zze2 = zze();
            zze2.zzq().zza(new zze(zze2, zze2.zzm().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        zzq().zza(new zzio(this));
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
