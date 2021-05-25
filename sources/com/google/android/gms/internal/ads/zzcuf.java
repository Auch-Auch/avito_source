package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;
public final class zzcuf {
    private final zzcli zzfns;
    private final zzcjd zzgdx;
    private final zzdlt zzgex;

    public zzcuf(zzdlt zzdlt, zzcjd zzcjd, zzcli zzcli) {
        this.zzgex = zzdlt;
        this.zzgdx = zzcjd;
        this.zzfns = zzcli;
    }

    public final void zza(zzdkz zzdkz, zzdkx zzdkx, int i, @Nullable zzcri zzcri, long j) {
        zzcje zzcje;
        zzclh zzq = this.zzfns.zzaor().zza(zzdkz).zzd(zzdkx).zzq("action", "adapter_status").zzq("adapter_l", String.valueOf(j));
        zzq.zzq("sc", Integer.toString(i));
        if (zzcri != null) {
            zzq.zzq("arec", Integer.toString(zzcri.zzapu().errorCode));
            String zzgu = this.zzgex.zzgu(zzcri.getMessage());
            if (zzgu != null) {
                zzq.zzq("areec", zzgu);
            }
        }
        zzcjd zzcjd = this.zzgdx;
        Iterator<String> it = zzdkx.zzhap.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcje = null;
                break;
            }
            zzcje = zzcjd.zzgg(it.next());
            if (zzcje != null) {
                break;
            }
        }
        if (zzcje != null) {
            zzq.zzq("ancn", zzcje.zzdfe);
            zzapo zzapo = zzcje.zzgdu;
            if (zzapo != null) {
                zzq.zzq("adapter_v", zzapo.toString());
            }
            zzapo zzapo2 = zzcje.zzgdv;
            if (zzapo2 != null) {
                zzq.zzq("adapter_sv", zzapo2.toString());
            }
        }
        zzq.zzaop();
    }
}
