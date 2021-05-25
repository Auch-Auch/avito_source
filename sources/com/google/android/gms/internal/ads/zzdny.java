package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.ads.internal.zzp;
public final class zzdny {
    private int zzhga = 0;
    private final long zzhgb;
    private final zzdnx zzhgc = new zzdnx();
    private long zzhgd;
    private int zzhge = 0;
    private int zzhgf = 0;

    public zzdny() {
        long currentTimeMillis = zzp.zzkw().currentTimeMillis();
        this.zzhgb = currentTimeMillis;
        this.zzhgd = currentTimeMillis;
    }

    public final long getCreationTimeMillis() {
        return this.zzhgb;
    }

    public final long zzatf() {
        return this.zzhgd;
    }

    public final int zzatg() {
        return this.zzhge;
    }

    public final String zzats() {
        StringBuilder L = a.L("Created: ");
        L.append(this.zzhgb);
        L.append(" Last accessed: ");
        L.append(this.zzhgd);
        L.append(" Accesses: ");
        L.append(this.zzhge);
        L.append("\nEntries retrieved: Valid: ");
        L.append(this.zzhgf);
        L.append(" Stale: ");
        L.append(this.zzhga);
        return L.toString();
    }

    public final void zzauc() {
        this.zzhgd = zzp.zzkw().currentTimeMillis();
        this.zzhge++;
    }

    public final void zzaud() {
        this.zzhgf++;
        this.zzhgc.zzhfz = true;
    }

    public final void zzaue() {
        this.zzhga++;
        this.zzhgc.zzhga++;
    }

    public final zzdnx zzauf() {
        zzdnx zzdnx = (zzdnx) this.zzhgc.clone();
        zzdnx zzdnx2 = this.zzhgc;
        zzdnx2.zzhfz = false;
        zzdnx2.zzhga = 0;
        return zzdnx;
    }
}
