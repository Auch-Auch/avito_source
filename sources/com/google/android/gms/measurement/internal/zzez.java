package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzez extends zzgw {
    private char zza = 0;
    private long zzb = -1;
    @GuardedBy("this")
    private String zzc;
    private final zzfb zzd = new zzfb(this, 6, false, false);
    private final zzfb zze = new zzfb(this, 6, true, false);
    private final zzfb zzf = new zzfb(this, 6, false, true);
    private final zzfb zzg = new zzfb(this, 5, false, false);
    private final zzfb zzh = new zzfb(this, 5, true, false);
    private final zzfb zzi = new zzfb(this, 5, false, true);
    private final zzfb zzj = new zzfb(this, 4, false, false);
    private final zzfb zzk = new zzfb(this, 3, false, false);
    private final zzfb zzl = new zzfb(this, 2, false, false);

    public zzez(zzgd zzgd) {
        super(zzgd);
    }

    public static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzfa(str);
    }

    @VisibleForTesting
    private final String zzad() {
        String str;
        String str2;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzy.zzs() != null) {
                    str2 = this.zzy.zzs();
                } else {
                    zzt().zzu();
                    str2 = "FA";
                }
                this.zzc = str2;
            }
            str = this.zzc;
        }
        return str;
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final boolean zze() {
        return false;
    }

    public final zzfb zzf() {
        return this.zzd;
    }

    public final zzfb zzg() {
        return this.zze;
    }

    public final zzfb zzh() {
        return this.zzf;
    }

    public final zzfb zzi() {
        return this.zzg;
    }

    public final zzfb zzj() {
        return this.zzh;
    }

    public final zzfb zzk() {
        return this.zzi;
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

    public final zzfb zzv() {
        return this.zzj;
    }

    public final zzfb zzw() {
        return this.zzk;
    }

    public final zzfb zzx() {
        return this.zzl;
    }

    public final String zzy() {
        Pair<String, Long> zza2 = zzs().zzb.zza();
        if (zza2 == null || zza2 == zzfl.zza) {
            return null;
        }
        String valueOf = String.valueOf(zza2.second);
        String str = (String) zza2.first;
        return a.s2(a.q0(str, valueOf.length() + 1), valueOf, ":", str);
    }

    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfw zzg2 = this.zzy.zzg();
            if (zzg2 == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzg2.zzz()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i < 0) {
                    i = 0;
                }
                zzg2.zza(new zzey(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @VisibleForTesting
    public final boolean zza(int i) {
        return Log.isLoggable(zzad(), i);
    }

    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zzad(), str);
    }

    public static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zza2 = zza(z, obj);
        String zza3 = zza(z, obj2);
        String zza4 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zza4)) {
            sb.append(str3);
            sb.append(zza4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + str.length() + 43);
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzb2 = zzb(zzgd.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb2)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzfa) {
                return zzfa.zza((zzfa) obj);
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
