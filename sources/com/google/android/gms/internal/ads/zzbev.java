package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public abstract class zzbev implements Releasable {
    public Context mContext;
    public String zzecp;
    public WeakReference<zzbde> zzekx;

    public zzbev(zzbde zzbde) {
        this.mContext = zzbde.getContext();
        this.zzecp = zzp.zzkp().zzs(this.mContext, zzbde.zzzt().zzbra);
        this.zzekx = new WeakReference<>(zzbde);
    }

    /* access modifiers changed from: private */
    public static String zzfp(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 0;
                    break;
                }
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 3;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 4;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 6;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = 7;
                    break;
                }
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = '\b';
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = '\t';
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = '\n';
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 5:
            case '\b':
            case '\t':
            default:
                return "internal";
            case 1:
            case 3:
                return "network";
            case 6:
            case 7:
                return "policy";
            case '\n':
            case 11:
                return "io";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzbat.zzaah.post(new zzbex(this, str, str2, j, j2, z, i, i2));
    }

    @VisibleForTesting
    public final void zzc(String str, String str2, long j) {
        zzbat.zzaah.post(new zzbey(this, str, str2, j));
    }

    public void zzdl(int i) {
    }

    public void zzdm(int i) {
    }

    public void zzdn(int i) {
    }

    public void zzdo(int i) {
    }

    public boolean zze(String str, String[] strArr) {
        return zzfn(str);
    }

    public abstract boolean zzfn(String str);

    public String zzfo(String str) {
        zzwe.zzpq();
        return zzbat.zzex(str);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzbat.zzaah.post(new zzbew(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zza(String str, String str2, int i) {
        zzbat.zzaah.post(new zzbez(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzbat.zzaah.post(new zzbfb(this, str, str2, str3, str4));
    }

    /* access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbde zzbde = this.zzekx.get();
        if (zzbde != null) {
            zzbde.zza(str, map);
        }
    }
}
