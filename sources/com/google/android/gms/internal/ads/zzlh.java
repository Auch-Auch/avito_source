package com.google.android.gms.internal.ads;
public final class zzlh {
    public final zzkg zzasm;
    public final zzlp zzayh = new zzlp();
    public zzln zzayi;
    public zzlb zzayj;
    public int zzayk;
    public int zzayl;
    public int zzaym;
    public zzkf zzayn;
    public zzlq zzayo;

    public zzlh(zzkg zzkg) {
        this.zzasm = zzkg;
    }

    public final void reset() {
        zzlp zzlp = this.zzayh;
        zzlp.zzbaj = 0;
        zzlp.zzbaw = 0;
        zzlp.zzbaq = false;
        zzlp.zzbav = false;
        zzlp.zzbas = null;
        this.zzayk = 0;
        this.zzaym = 0;
        this.zzayl = 0;
        this.zzayn = null;
        this.zzayo = null;
    }

    public final void zza(zzln zzln, zzlb zzlb) {
        this.zzayi = (zzln) zzoz.checkNotNull(zzln);
        this.zzayj = (zzlb) zzoz.checkNotNull(zzlb);
        this.zzasm.zze(zzln.zzaht);
        reset();
    }
}
