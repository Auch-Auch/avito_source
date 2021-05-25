package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
public final class zzlj implements zzjv, zzke {
    private static final zzka zzapf = new zzlm();
    private static final int zzayq = zzpq.zzbl("qt  ");
    private long zzaid;
    private final zzpk zzapm = new zzpk(zzpf.zzbjn);
    private final zzpk zzapn = new zzpk(4);
    private int zzarb;
    private int zzarc;
    private zzjx zzarf;
    private final zzpk zzaxp = new zzpk(16);
    private final Stack<zzku> zzaxr = new Stack<>();
    private int zzaxt;
    private int zzaxu;
    private long zzaxv;
    private int zzaxw;
    private zzpk zzaxx;
    private zzll[] zzayr;
    private boolean zzays;

    private final void zzeb(long j) throws zzhv {
        zzmc zzmc;
        zzjz zzjz;
        zzln zza;
        while (!this.zzaxr.isEmpty() && this.zzaxr.peek().zzawf == j) {
            zzku pop = this.zzaxr.pop();
            if (pop.type == zzkr.zzatp) {
                long j2 = C.TIME_UNSET;
                ArrayList arrayList = new ArrayList();
                long j3 = Long.MAX_VALUE;
                zzmc zzmc2 = null;
                zzjz zzjz2 = new zzjz();
                zzkt zzau = pop.zzau(zzkr.zzavo);
                if (!(zzau == null || (zzmc2 = zzkw.zza(zzau, this.zzays)) == null)) {
                    zzjz2.zzb(zzmc2);
                }
                int i = 0;
                while (i < pop.zzawh.size()) {
                    zzku zzku = pop.zzawh.get(i);
                    if (zzku.type == zzkr.zzatr && (zza = zzkw.zza(zzku, pop.zzau(zzkr.zzatq), (long) C.TIME_UNSET, (zzjn) null, this.zzays)) != null) {
                        zzls zza2 = zzkw.zza(zza, zzku.zzav(zzkr.zzats).zzav(zzkr.zzatt).zzav(zzkr.zzatu), zzjz2);
                        if (zza2.zzawy != 0) {
                            zzll zzll = new zzll(zza, zza2, this.zzarf.zzc(i, zza.type));
                            zzho zzv = zza.zzaht.zzv(zza2.zzaxe + 30);
                            if (zza.type == 1) {
                                if (zzjz2.zzgq()) {
                                    zzv = zzv.zzb(zzjz2.zzahl, zzjz2.zzahm);
                                }
                                if (zzmc2 != null) {
                                    zzv = zzv.zza(zzmc2);
                                }
                            }
                            zzll.zzazy.zze(zzv);
                            zzmc = zzmc2;
                            zzjz = zzjz2;
                            j2 = Math.max(j2, zza.zzaid);
                            arrayList.add(zzll);
                            long j4 = zza2.zzaok[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzjz2 = zzjz;
                            zzmc2 = zzmc;
                        }
                    }
                    zzmc = zzmc2;
                    zzjz = zzjz2;
                    i++;
                    zzjz2 = zzjz;
                    zzmc2 = zzmc;
                }
                this.zzaid = j2;
                this.zzayr = (zzll[]) arrayList.toArray(new zzll[arrayList.size()]);
                this.zzarf.zzgp();
                this.zzarf.zza(this);
                this.zzaxr.clear();
                this.zzaxt = 2;
            } else if (!this.zzaxr.isEmpty()) {
                this.zzaxr.peek().zza(pop);
            }
        }
        if (this.zzaxt != 2) {
            zzgz();
        }
    }

    private final void zzgz() {
        this.zzaxt = 0;
        this.zzaxw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long getDurationUs() {
        return this.zzaid;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjy) throws IOException, InterruptedException {
        return zzlo.zze(zzjy);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        this.zzaxr.clear();
        this.zzaxw = 0;
        this.zzarc = 0;
        this.zzarb = 0;
        if (j == 0) {
            zzgz();
            return;
        }
        zzll[] zzllArr = this.zzayr;
        if (zzllArr != null) {
            for (zzll zzll : zzllArr) {
                zzls zzls = zzll.zzazx;
                int zzec = zzls.zzec(j2);
                if (zzec == -1) {
                    zzec = zzls.zzed(j2);
                }
                zzll.zzaxa = zzec;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzll zzll : this.zzayr) {
            zzls zzls = zzll.zzazx;
            int zzec = zzls.zzec(j);
            if (zzec == -1) {
                zzec = zzls.zzed(j);
            }
            long j3 = zzls.zzaok[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjx) {
        this.zzarf = zzjx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x0188 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0293 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjy r24, com.google.android.gms.internal.ads.zzkb r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 660
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlj.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }
}
