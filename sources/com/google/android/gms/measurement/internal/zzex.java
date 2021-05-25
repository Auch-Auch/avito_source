package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
public final class zzex extends zzgw {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    public zzex(zzgd zzgd) {
        super(zzgd);
    }

    private final boolean zzg() {
        zzu();
        return this.zzy.zzl() && this.zzy.zzr().zza(3);
    }

    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzhb.zzb, zzhb.zza, zza);
    }

    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzha.zzb, zzha.zza, zzb);
    }

    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return a.d("experiment_id", "(", str, ")");
        }
        return zza(str, zzhd.zzb, zzhd.zza, zzc);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final boolean zze() {
        return false;
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

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkw.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Nullable
    public final String zza(zzao zzao) {
        String str = null;
        if (zzao == null) {
            return null;
        }
        if (!zzg()) {
            return zzao.toString();
        }
        StringBuilder L = a.L("origin=");
        L.append(zzao.zzc);
        L.append(",name=");
        L.append(zza(zzao.zza));
        L.append(",params=");
        zzan zzan = zzao.zzb;
        if (zzan != null) {
            if (!zzg()) {
                str = zzan.toString();
            } else {
                str = zza(zzan.zzb());
            }
        }
        L.append(str);
        return L.toString();
    }

    @Nullable
    public final String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder L = a.L("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (L.length() != 8) {
                L.append(", ");
            }
            L.append(zzb(str2));
            L.append("=");
            if (!zzmo.zzb() || !zzt().zza(zzaq.zzcd)) {
                L.append(bundle.get(str2));
            } else {
                Object obj = bundle.get(str2);
                if (obj instanceof Bundle) {
                    str = zza(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    str = zza((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    str = zza(((ArrayList) obj).toArray());
                } else {
                    str = String.valueOf(obj);
                }
                L.append(str);
            }
        }
        L.append("}]");
        return L.toString();
    }

    @Nullable
    private final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder L = a.L("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                str = zza((Bundle) obj);
            } else {
                str = String.valueOf(obj);
            }
            if (str != null) {
                if (L.length() != 1) {
                    L.append(", ");
                }
                L.append(str);
            }
        }
        L.append("]");
        return L.toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
