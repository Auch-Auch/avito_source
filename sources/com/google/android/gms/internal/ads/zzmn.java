package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import java.io.IOException;
public final class zzmn implements zzjx, zzmx, zznj, zzow<zzmu> {
    private final Handler handler;
    private final Uri uri;
    private final Handler zzaeo;
    private boolean zzafq;
    private boolean zzage;
    private long zzaid;
    private final zzom zzaoo;
    private final int zzbdf;
    private final zzmy zzbdg;
    private final zznc zzbdh;
    private final zzok zzbdi;
    private final String zzbdj;
    private final long zzbdk;
    private final zzot zzbdl = new zzot("Loader:ExtractorMediaPeriod");
    private final zzmt zzbdm;
    private final zzpb zzbdn;
    private final Runnable zzbdo;
    private final Runnable zzbdp;
    private final SparseArray<zznh> zzbdq;
    private zzna zzbdr;
    private zzke zzbds;
    private boolean zzbdt;
    private boolean zzbdu;
    private boolean zzbdv;
    private int zzbdw;
    private zznp zzbdx;
    private boolean[] zzbdy;
    private boolean[] zzbdz;
    private boolean zzbea;
    private long zzbeb;
    private long zzbec;
    private int zzbed;
    private boolean zzbee;
    private long zzcp;

    public zzmn(Uri uri2, zzom zzom, zzjv[] zzjvArr, int i, Handler handler2, zzmy zzmy, zznc zznc, zzok zzok, String str, int i2) {
        this.uri = uri2;
        this.zzaoo = zzom;
        this.zzbdf = i;
        this.zzaeo = handler2;
        this.zzbdg = zzmy;
        this.zzbdh = zznc;
        this.zzbdi = zzok;
        this.zzbdj = str;
        this.zzbdk = (long) i2;
        this.zzbdm = new zzmt(zzjvArr, this);
        this.zzbdn = new zzpb();
        this.zzbdo = new zzmq(this);
        this.zzbdp = new zzmp(this);
        this.handler = new Handler();
        this.zzbec = C.TIME_UNSET;
        this.zzbdq = new SparseArray<>();
        this.zzcp = -1;
    }

    private final void startLoading() {
        zzke zzke;
        zzmu zzmu = new zzmu(this, this.uri, this.zzaoo, this.zzbdm, this.zzbdn);
        if (this.zzafq) {
            zzoz.checkState(zzhu());
            long j = this.zzaid;
            if (j == C.TIME_UNSET || this.zzbec < j) {
                zzmu.zze(this.zzbds.zzdz(this.zzbec), this.zzbec);
                this.zzbec = C.TIME_UNSET;
            } else {
                this.zzbee = true;
                this.zzbec = C.TIME_UNSET;
                return;
            }
        }
        this.zzbed = zzhs();
        int i = this.zzbdf;
        if (i == -1) {
            i = (this.zzafq && this.zzcp == -1 && ((zzke = this.zzbds) == null || zzke.getDurationUs() == C.TIME_UNSET)) ? 6 : 3;
        }
        this.zzbdl.zza(zzmu, this, i);
    }

    /* access modifiers changed from: public */
    private final void zzhr() {
        if (!this.zzage && !this.zzafq && this.zzbds != null && this.zzbdt) {
            int size = this.zzbdq.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbdq.valueAt(i).zzid() == null) {
                    return;
                }
            }
            this.zzbdn.zzis();
            zznq[] zznqArr = new zznq[size];
            this.zzbdz = new boolean[size];
            this.zzbdy = new boolean[size];
            this.zzaid = this.zzbds.getDurationUs();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 < size) {
                    zzho zzid = this.zzbdq.valueAt(i2).zzid();
                    zznqArr[i2] = new zznq(zzid);
                    String str = zzid.zzagy;
                    if (!zzpg.zzbg(str) && !zzpg.zzbf(str)) {
                        z = false;
                    }
                    this.zzbdz[i2] = z;
                    this.zzbea = z | this.zzbea;
                    i2++;
                } else {
                    this.zzbdx = new zznp(zznqArr);
                    this.zzafq = true;
                    this.zzbdh.zzb(new zznn(this.zzaid, this.zzbds.isSeekable()), null);
                    this.zzbdr.zza((zzmx) this);
                    return;
                }
            }
        }
    }

    private final int zzhs() {
        int size = this.zzbdq.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbdq.valueAt(i2).zzib();
        }
        return i;
    }

    private final long zzht() {
        int size = this.zzbdq.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbdq.valueAt(i).zzht());
        }
        return j;
    }

    private final boolean zzhu() {
        return this.zzbec != C.TIME_UNSET;
    }

    public final void release() {
        this.zzbdl.zza(new zzms(this, this.zzbdm));
        this.handler.removeCallbacksAndMessages(null);
        this.zzage = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zza(zzna zzna, long j) {
        this.zzbdr = zzna;
        this.zzbdn.open();
        startLoading();
    }

    public final boolean zzbb(int i) {
        if (!this.zzbee) {
            return !zzhu() && this.zzbdq.valueAt(i).zzic();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final zzkg zzc(int i, int i2) {
        zznh zznh = this.zzbdq.get(i);
        if (zznh != null) {
            return zznh;
        }
        zznh zznh2 = new zznh(this.zzbdi);
        zznh2.zza(this);
        this.zzbdq.put(i, zznh2);
        return zznh2;
    }

    public final void zzd(int i, long j) {
        zznh valueAt = this.zzbdq.valueAt(i);
        if (!this.zzbee || j <= valueAt.zzht()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzif();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzee(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        if (this.zzbee) {
            return false;
        }
        if (this.zzafq && this.zzbdw == 0) {
            return false;
        }
        boolean open = this.zzbdn.open();
        if (this.zzbdl.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzeg(long j) {
        if (!this.zzbds.isSeekable()) {
            j = 0;
        }
        this.zzbeb = j;
        int size = this.zzbdq.size();
        boolean z = !zzhu();
        int i = 0;
        while (z && i < size) {
            if (this.zzbdy[i]) {
                z = this.zzbdq.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbec = j;
            this.zzbee = false;
            if (this.zzbdl.isLoading()) {
                this.zzbdl.zziq();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbdq.valueAt(i2).zzk(this.zzbdy[i2]);
                }
            }
        }
        this.zzbdv = false;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final void zzf(zzho zzho) {
        this.handler.post(this.zzbdo);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zzgp() {
        this.zzbdt = true;
        this.handler.post(this.zzbdo);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzhl() throws IOException {
        this.zzbdl.zzbj(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final zznp zzhm() {
        return this.zzbdx;
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final long zzhn() {
        if (this.zzbdw == 0) {
            return Long.MIN_VALUE;
        }
        return zzhp();
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzho() {
        if (!this.zzbdv) {
            return C.TIME_UNSET;
        }
        this.zzbdv = false;
        return this.zzbeb;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhp() {
        long j;
        if (this.zzbee) {
            return Long.MIN_VALUE;
        }
        if (zzhu()) {
            return this.zzbec;
        }
        if (this.zzbea) {
            j = Long.MAX_VALUE;
            int size = this.zzbdq.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbdz[i]) {
                    j = Math.min(j, this.zzbdq.valueAt(i).zzht());
                }
            }
        } else {
            j = zzht();
        }
        return j == Long.MIN_VALUE ? this.zzbeb : j;
    }

    public final void zzhq() throws IOException {
        this.zzbdl.zzbj(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zza(zzob[] zzobArr, boolean[] zArr, zznm[] zznmArr, boolean[] zArr2, long j) {
        zzoz.checkState(this.zzafq);
        for (int i = 0; i < zzobArr.length; i++) {
            if (zznmArr[i] != null && (zzobArr[i] == null || !zArr[i])) {
                int i2 = ((zzmw) zznmArr[i]).track;
                zzoz.checkState(this.zzbdy[i2]);
                this.zzbdw--;
                this.zzbdy[i2] = false;
                this.zzbdq.valueAt(i2).disable();
                zznmArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzobArr.length; i3++) {
            if (zznmArr[i3] == null && zzobArr[i3] != null) {
                zzob zzob = zzobArr[i3];
                zzoz.checkState(zzob.length() == 1);
                zzoz.checkState(zzob.zzbf(0) == 0);
                int zza = this.zzbdx.zza(zzob.zzij());
                zzoz.checkState(!this.zzbdy[zza]);
                this.zzbdw++;
                this.zzbdy[zza] = true;
                zznmArr[i3] = new zzmw(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.zzbdu) {
            int size = this.zzbdq.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.zzbdy[i4]) {
                    this.zzbdq.valueAt(i4).disable();
                }
            }
        }
        if (this.zzbdw == 0) {
            this.zzbdv = false;
            if (this.zzbdl.isLoading()) {
                this.zzbdl.zziq();
            }
        } else if (!this.zzbdu ? j != 0 : z) {
            j = zzeg(j);
            for (int i5 = 0; i5 < zznmArr.length; i5++) {
                if (zznmArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.zzbdu = true;
        return j;
    }

    public final int zza(int i, zzhq zzhq, zzjk zzjk, boolean z) {
        if (this.zzbdv || zzhu()) {
            return -3;
        }
        return this.zzbdq.valueAt(i).zza(zzhq, zzjk, z, this.zzbee, this.zzbeb);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zza(zzke zzke) {
        this.zzbds = zzke;
        this.handler.post(this.zzbdo);
    }

    private final void zza(zzmu zzmu) {
        if (this.zzcp == -1) {
            this.zzcp = zzmu.zzcp;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ int zza(zzmu zzmu, long j, long j2, IOException iOException) {
        zzke zzke;
        zzmu zzmu2 = zzmu;
        zza(zzmu2);
        Handler handler2 = this.zzaeo;
        if (!(handler2 == null || this.zzbdg == null)) {
            handler2.post(new zzmr(this, iOException));
        }
        if (iOException instanceof zzns) {
            return 3;
        }
        boolean z = zzhs() > this.zzbed;
        if (this.zzcp == -1 && ((zzke = this.zzbds) == null || zzke.getDurationUs() == C.TIME_UNSET)) {
            this.zzbeb = 0;
            this.zzbdv = this.zzafq;
            int size = this.zzbdq.size();
            for (int i = 0; i < size; i++) {
                this.zzbdq.valueAt(i).zzk(!this.zzafq || this.zzbdy[i]);
            }
            zzmu2.zze(0, 0);
        }
        this.zzbed = zzhs();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ void zza(zzmu zzmu, long j, long j2, boolean z) {
        zza(zzmu);
        if (!z && this.zzbdw > 0) {
            int size = this.zzbdq.size();
            for (int i = 0; i < size; i++) {
                this.zzbdq.valueAt(i).zzk(this.zzbdy[i]);
            }
            this.zzbdr.zza((zzna) this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ void zza(zzmu zzmu, long j, long j2) {
        zza(zzmu);
        this.zzbee = true;
        if (this.zzaid == C.TIME_UNSET) {
            long zzht = zzht();
            this.zzaid = zzht == Long.MIN_VALUE ? 0 : zzht + 10000;
            this.zzbdh.zzb(new zznn(this.zzaid, this.zzbds.isSeekable()), null);
        }
        this.zzbdr.zza((zzna) this);
    }
}
