package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztw;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;
public final class zzdmz implements zzdna {
    @GuardedBy("this")
    private final ConcurrentHashMap<zzdnk, zzdmx> zzhdu;
    private zzdnd zzhdv;
    private zzdnb zzhdw = new zzdnb();

    public zzdmz(zzdnd zzdnd) {
        this.zzhdu = new ConcurrentHashMap<>(zzdnd.zzhek);
        this.zzhdv = zzdnd;
    }

    private final void dumpToLog() {
        if (zzdnd.zzatt()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhdv.zzhei);
            sb.append(" PoolCollection");
            sb.append(this.zzhdw.zzats());
            int i = 0;
            for (Map.Entry<zzdnk, zzdmx> entry : this.zzhdu.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzhdv.zzhek; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().zzath());
                sb.append("\n");
            }
            while (i < this.zzhdv.zzhej) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzbbd.zzef(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdna
    @Nullable
    public final synchronized zzdnh<?> zza(zzdnk zzdnk) {
        zzdnh<?> zzdnh;
        zzdmx zzdmx = this.zzhdu.get(zzdnk);
        zzdnh = null;
        if (zzdmx != null) {
            zzdnh = zzdmx.zzate();
            if (zzdnh == null) {
                this.zzhdw.zzatn();
            }
            zza(zzdnh, zzdmx.zzati());
        } else {
            this.zzhdw.zzatm();
            zza((zzdnh<?>) null, (zzdnx) null);
        }
        return zzdnh;
    }

    @Override // com.google.android.gms.internal.ads.zzdna
    public final zzdnd zzatl() {
        return this.zzhdv;
    }

    @Override // com.google.android.gms.internal.ads.zzdna
    public final synchronized boolean zzb(zzdnk zzdnk) {
        zzdmx zzdmx = this.zzhdu.get(zzdnk);
        if (zzdmx == null) {
            return true;
        }
        if (zzdmx.size() < this.zzhdv.zzhek) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdna
    public final synchronized boolean zza(zzdnk zzdnk, zzdnh<?> zzdnh) {
        boolean zzb;
        zzdmx zzdmx = this.zzhdu.get(zzdnk);
        zzdnh.zzhfj = zzp.zzkw().currentTimeMillis();
        if (zzdmx == null) {
            zzdnd zzdnd = this.zzhdv;
            zzdmx = new zzdmx(zzdnd.zzhek, zzdnd.zzhel * 1000);
            int size = this.zzhdu.size();
            zzdnd zzdnd2 = this.zzhdv;
            if (size == zzdnd2.zzhej) {
                int i = zzdnc.zzhed[zzdnd2.zzheo - 1];
                long j = Long.MAX_VALUE;
                zzdnk zzdnk2 = null;
                if (i == 1) {
                    for (Map.Entry<zzdnk, zzdmx> entry : this.zzhdu.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < j) {
                            j = entry.getValue().getCreationTimeMillis();
                            zzdnk2 = entry.getKey();
                        }
                    }
                    if (zzdnk2 != null) {
                        this.zzhdu.remove(zzdnk2);
                    }
                } else if (i == 2) {
                    for (Map.Entry<zzdnk, zzdmx> entry2 : this.zzhdu.entrySet()) {
                        if (entry2.getValue().zzatf() < j) {
                            j = entry2.getValue().zzatf();
                            zzdnk2 = entry2.getKey();
                        }
                    }
                    if (zzdnk2 != null) {
                        this.zzhdu.remove(zzdnk2);
                    }
                } else if (i == 3) {
                    int i2 = Integer.MAX_VALUE;
                    for (Map.Entry<zzdnk, zzdmx> entry3 : this.zzhdu.entrySet()) {
                        if (entry3.getValue().zzatg() < i2) {
                            i2 = entry3.getValue().zzatg();
                            zzdnk2 = entry3.getKey();
                        }
                    }
                    if (zzdnk2 != null) {
                        this.zzhdu.remove(zzdnk2);
                    }
                }
                this.zzhdw.zzatp();
            }
            this.zzhdu.put(zzdnk, zzdmx);
            this.zzhdw.zzato();
        }
        zzb = zzdmx.zzb(zzdnh);
        this.zzhdw.zzatq();
        zzdne zzatr = this.zzhdw.zzatr();
        zzdnx zzati = zzdmx.zzati();
        zzdnh.zzhfh.zzaiw().zzd((zztw.zzb) ((zzegp) zztw.zzb.zzng().zza(zztw.zzb.zza.zzne().zzb(zztw.zzb.zzc.IN_MEMORY).zza(zztw.zzb.zze.zznk().zzu(zzatr.zzher).zzv(zzatr.zzhes).zzcd(zzati.zzhga))).zzbfx()));
        dumpToLog();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdna
    @Deprecated
    public final zzdnk zza(zzvc zzvc, String str, zzvm zzvm) {
        return new zzdnj(zzvc, str, new zzasx(this.zzhdv.zzvr).zzvk().zzdtx, this.zzhdv.zzhem, zzvm);
    }

    private final void zza(zzdnh<?> zzdnh, zzdnx zzdnx) {
        if (zzdnh != null) {
            zzdnh.zzhfh.zzaiw().zzc((zztw.zzb) ((zzegp) zztw.zzb.zzng().zza(zztw.zzb.zza.zzne().zzb(zztw.zzb.zzc.IN_MEMORY).zza(zztw.zzb.zzd.zzni().zzt(zzdnx.zzhfz).zzcc(zzdnx.zzhga))).zzbfx()));
        }
        dumpToLog();
    }
}
