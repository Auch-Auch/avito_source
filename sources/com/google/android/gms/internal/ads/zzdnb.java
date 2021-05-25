package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
public final class zzdnb {
    private final zzdne zzhdx = new zzdne();
    private int zzhdy;
    private int zzhdz;
    private int zzhea;
    private int zzheb;
    private int zzhec;

    public final void zzatm() {
        this.zzhea++;
    }

    public final void zzatn() {
        this.zzheb++;
    }

    public final void zzato() {
        this.zzhdy++;
        this.zzhdx.zzher = true;
    }

    public final void zzatp() {
        this.zzhdz++;
        this.zzhdx.zzhes = true;
    }

    public final void zzatq() {
        this.zzhec++;
    }

    public final zzdne zzatr() {
        zzdne zzdne = (zzdne) this.zzhdx.clone();
        zzdne zzdne2 = this.zzhdx;
        zzdne2.zzher = false;
        zzdne2.zzhes = false;
        return zzdne;
    }

    public final String zzats() {
        StringBuilder L = a.L("\n\tPool does not exist: ");
        L.append(this.zzhea);
        L.append("\n\tNew pools created: ");
        L.append(this.zzhdy);
        L.append("\n\tPools removed: ");
        L.append(this.zzhdz);
        L.append("\n\tEntries added: ");
        L.append(this.zzhec);
        L.append("\n\tNo entries retrieved: ");
        return a.j(L, this.zzheb, "\n");
    }
}
