package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import java.io.IOException;
public final class zzhl implements Handler.Callback, zzna, zznc, zzof {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzhx[] zzael;
    private final zzog zzaem;
    private final Handler zzaeo;
    private final zzid zzaer;
    private final zzia zzaes;
    private boolean zzaeu;
    private boolean zzaey;
    private zzhy zzaez;
    private zzhu zzafd;
    private zzhn zzafe;
    private final zzhw[] zzafu;
    private final zzhs zzafv;
    private zzmz zzafw;
    private final zzpl zzafy;
    private final HandlerThread zzafz;
    private final zzhc zzaga;
    private zzhx zzagb;
    private zzpd zzagc;
    private zzhx[] zzagd;
    private boolean zzage;
    private boolean zzagf;
    private int zzagg;
    private int zzagh;
    private long zzagi;
    private int zzagj;
    private zzhm zzagk;
    private long zzagl;
    private zzhk zzagm;
    private zzhk zzagn;
    private zzhk zzago;

    public zzhl(zzhx[] zzhxArr, zzog zzog, zzhs zzhs, boolean z, int i, Handler handler2, zzhn zzhn, zzhc zzhc) {
        this.zzael = zzhxArr;
        this.zzaem = zzog;
        this.zzafv = zzhs;
        this.zzaeu = z;
        this.zzaeo = handler2;
        this.state = 1;
        this.zzafe = zzhn;
        this.zzaga = zzhc;
        this.zzafu = new zzhw[zzhxArr.length];
        for (int i2 = 0; i2 < zzhxArr.length; i2++) {
            zzhxArr[i2].setIndex(i2);
            this.zzafu[i2] = zzhxArr[i2].zzdx();
        }
        this.zzafy = new zzpl();
        this.zzagd = new zzhx[0];
        this.zzaer = new zzid();
        this.zzaes = new zzia();
        zzog.zza(this);
        this.zzafd = zzhu.zzahv;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzafz = handlerThread;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzaeo.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzdq(long j) throws zzhd {
        long j2;
        zzhk zzhk = this.zzago;
        if (zzhk == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + zzhk.zzen();
        }
        this.zzagl = j2;
        this.zzafy.zzel(j2);
        for (zzhx zzhx : this.zzagd) {
            zzhx.zzdo(this.zzagl);
        }
    }

    private final boolean zzdr(long j) {
        if (j == C.TIME_UNSET || this.zzafe.zzagr < j) {
            return true;
        }
        zzhk zzhk = this.zzago.zzafs;
        return zzhk != null && zzhk.zzafq;
    }

    private final void zzer() throws zzhd {
        this.zzagf = false;
        this.zzafy.start();
        for (zzhx zzhx : this.zzagd) {
            zzhx.start();
        }
    }

    private final void zzes() throws zzhd {
        this.zzafy.stop();
        for (zzhx zzhx : this.zzagd) {
            zza(zzhx);
        }
    }

    private final void zzet() throws zzhd {
        long j;
        zzhk zzhk = this.zzago;
        if (zzhk != null) {
            long zzho = zzhk.zzafi.zzho();
            if (zzho != C.TIME_UNSET) {
                zzdq(zzho);
            } else {
                zzhx zzhx = this.zzagb;
                if (zzhx == null || zzhx.zzfc()) {
                    this.zzagl = this.zzafy.zzfx();
                } else {
                    long zzfx = this.zzagc.zzfx();
                    this.zzagl = zzfx;
                    this.zzafy.zzel(zzfx);
                }
                zzho = this.zzagl - this.zzago.zzen();
            }
            this.zzafe.zzagr = zzho;
            this.zzagi = SystemClock.elapsedRealtime() * 1000;
            if (this.zzagd.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzago.zzafi.zzhp();
            }
            zzhn zzhn = this.zzafe;
            if (j == Long.MIN_VALUE) {
                j = this.zzaez.zza(this.zzago.zzafn, this.zzaes, false).zzaid;
            }
            zzhn.zzags = j;
        }
    }

    private final void zzeu() {
        zzi(true);
        this.zzafv.onStopped();
        setState(1);
    }

    private final void zzev() throws IOException {
        zzhk zzhk = this.zzagm;
        if (!(zzhk == null || zzhk.zzafq)) {
            zzhk zzhk2 = this.zzagn;
            if (zzhk2 == null || zzhk2.zzafs == zzhk) {
                for (zzhx zzhx : this.zzagd) {
                    if (!zzhx.zzea()) {
                        return;
                    }
                }
                this.zzagm.zzafi.zzhl();
            }
        }
    }

    private final void zzew() {
        long j;
        zzhk zzhk = this.zzagm;
        if (!zzhk.zzafq) {
            j = 0;
        } else {
            j = zzhk.zzafi.zzhn();
        }
        if (j == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzen = this.zzagl - this.zzagm.zzen();
        boolean zzdt = this.zzafv.zzdt(j - zzen);
        zzh(zzdt);
        if (zzdt) {
            this.zzagm.zzafi.zzef(zzen);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzaey != z) {
            this.zzaey = z;
            this.zzaeo.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        this.handler.removeMessages(2);
        this.zzagf = false;
        this.zzafy.stop();
        this.zzagc = null;
        this.zzagb = null;
        this.zzagl = 60000000;
        zzhx[] zzhxArr = this.zzagd;
        for (zzhx zzhx : zzhxArr) {
            try {
                zza(zzhx);
                zzhx.disable();
            } catch (zzhd | RuntimeException unused) {
            }
        }
        this.zzagd = new zzhx[0];
        zzhk zzhk = this.zzago;
        if (zzhk == null) {
            zzhk = this.zzagm;
        }
        zza(zzhk);
        this.zzagm = null;
        this.zzagn = null;
        this.zzago = null;
        zzh(false);
        if (z) {
            zzmz zzmz = this.zzafw;
            if (zzmz != null) {
                zzmz.zzhy();
                this.zzafw = null;
            }
            this.zzaez = null;
        }
    }

    private final boolean zzu(int i) {
        this.zzaez.zza(i, this.zzaes, false);
        if (this.zzaez.zza(0, this.zzaer, false).zzaip || this.zzaez.zza(i, this.zzaes, this.zzaer, this.repeatMode) != -1) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:480:0x0839, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x083a, code lost:
        r34.zzaeo.obtainMessage(8, com.google.android.gms.internal.ads.zzhd.zza(r0)).sendToTarget();
        zzeu();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x084d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x084e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x084f, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x0863, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:488:0x0864, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0572 A[LOOP:7: B:312:0x0572->B:316:0x0582, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0766  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0839 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    @Override // android.os.Handler.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
        // Method dump skipped, instructions count: 2194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhl.handleMessage(android.os.Message):boolean");
    }

    public final synchronized void release() {
        if (!this.zzage) {
            this.handler.sendEmptyMessage(6);
            while (!this.zzage) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            this.zzafz.quit();
        }
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzmz zzmz, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzmz).sendToTarget();
    }

    public final synchronized void zzb(zzhh... zzhhArr) {
        if (!this.zzage) {
            int i = this.zzagg;
            this.zzagg = i + 1;
            this.handler.obtainMessage(11, zzhhArr).sendToTarget();
            while (this.zzagh <= i) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzof
    public final void zzeq() {
        this.handler.sendEmptyMessage(10);
    }

    public final void zzf(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzhy zzhy, int i, long j) {
        this.handler.obtainMessage(3, new zzhm(zzhy, i, j)).sendToTarget();
    }

    public final void zza(zzhh... zzhhArr) {
        if (!this.zzage) {
            this.zzagg++;
            this.handler.obtainMessage(11, zzhhArr).sendToTarget();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zza(zzmx zzmx) {
        this.handler.obtainMessage(8, zzmx).sendToTarget();
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzb(zzhy zzhy, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzhy, obj)).sendToTarget();
    }

    private final void zzb(Object obj, int i) {
        this.zzaeo.obtainMessage(6, new zzhp(this.zzaez, obj, this.zzafe, i)).sendToTarget();
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzaez, i, C.TIME_UNSET);
    }

    private final long zza(int i, long j) throws zzhd {
        zzhk zzhk;
        zzes();
        this.zzagf = false;
        setState(2);
        zzhk zzhk2 = this.zzago;
        if (zzhk2 == null) {
            zzhk zzhk3 = this.zzagm;
            if (zzhk3 != null) {
                zzhk3.release();
            }
            zzhk = null;
        } else {
            zzhk = null;
            while (zzhk2 != null) {
                if (zzhk2.zzafn != i || !zzhk2.zzafq) {
                    zzhk2.release();
                } else {
                    zzhk = zzhk2;
                }
                zzhk2 = zzhk2.zzafs;
            }
        }
        zzhk zzhk4 = this.zzago;
        if (!(zzhk4 == zzhk && zzhk4 == this.zzagn)) {
            for (zzhx zzhx : this.zzagd) {
                zzhx.disable();
            }
            this.zzagd = new zzhx[0];
            this.zzagc = null;
            this.zzagb = null;
            this.zzago = null;
        }
        if (zzhk != null) {
            zzhk.zzafs = null;
            this.zzagm = zzhk;
            this.zzagn = zzhk;
            zzb(zzhk);
            zzhk zzhk5 = this.zzago;
            if (zzhk5.zzafr) {
                j = zzhk5.zzafi.zzeg(j);
            }
            zzdq(j);
            zzew();
        } else {
            this.zzagm = null;
            this.zzagn = null;
            this.zzago = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final Pair<Integer, Long> zzb(zzhy zzhy, int i, long j) {
        return zza(zzhy, i, j, 0);
    }

    private final void zzb(zzhk zzhk) throws zzhd {
        if (this.zzago != zzhk) {
            boolean[] zArr = new boolean[this.zzael.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhx[] zzhxArr = this.zzael;
                if (i < zzhxArr.length) {
                    zzhx zzhx = zzhxArr[i];
                    zArr[i] = zzhx.getState() != 0;
                    zzob zzbg = zzhk.zzaft.zzbht.zzbg(i);
                    if (zzbg != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbg == null || (zzhx.zzec() && zzhx.zzdz() == this.zzago.zzafk[i]))) {
                        if (zzhx == this.zzagb) {
                            this.zzafy.zza(this.zzagc);
                            this.zzagc = null;
                            this.zzagb = null;
                        }
                        zza(zzhx);
                        zzhx.disable();
                    }
                    i++;
                } else {
                    this.zzago = zzhk;
                    this.zzaeo.obtainMessage(3, zzhk.zzaft).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private static void zza(zzhx zzhx) throws zzhd {
        if (zzhx.getState() == 2) {
            zzhx.stop();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafe = new zzhn(0, 0);
        zzb(obj, i);
        this.zzafe = new zzhn(0, C.TIME_UNSET);
        setState(4);
        zzi(false);
    }

    private final int zza(int i, zzhy zzhy, zzhy zzhy2) {
        int zzfe = zzhy.zzfe();
        int i2 = -1;
        for (int i3 = 0; i3 < zzfe && i2 == -1; i3++) {
            i = zzhy.zza(i, this.zzaes, this.zzaer, this.repeatMode);
            i2 = zzhy2.zzc(zzhy.zza(i, this.zzaes, true).zzafj);
        }
        return i2;
    }

    private final Pair<Integer, Long> zza(zzhm zzhm) {
        zzhy zzhy = zzhm.zzaez;
        if (zzhy.isEmpty()) {
            zzhy = this.zzaez;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzhy, zzhm.zzagp, zzhm.zzagq);
            zzhy zzhy2 = this.zzaez;
            if (zzhy2 == zzhy) {
                return zzb;
            }
            int zzc = zzhy2.zzc(zzhy.zza(((Integer) zzb.first).intValue(), this.zzaes, true).zzafj);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzhy, this.zzaez);
            if (zza == -1) {
                return null;
            }
            this.zzaez.zza(zza, this.zzaes, false);
            return zzb(0, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzht(this.zzaez, zzhm.zzagp, zzhm.zzagq);
        }
    }

    private final Pair<Integer, Long> zza(zzhy zzhy, int i, long j, long j2) {
        zzoz.zzc(i, 0, zzhy.zzfd());
        zzhy.zza(i, this.zzaer, false, j2);
        if (j == C.TIME_UNSET) {
            j = this.zzaer.zzais;
            if (j == C.TIME_UNSET) {
                return null;
            }
        }
        long j3 = this.zzaer.zzait + j;
        long j4 = zzhy.zza(0, this.zzaes, false).zzaid;
        if (j4 != C.TIME_UNSET) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private static void zza(zzhk zzhk) {
        while (zzhk != null) {
            zzhk.release();
            zzhk = zzhk.zzafs;
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzhd {
        this.zzagd = new zzhx[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhx[] zzhxArr = this.zzael;
            if (i2 < zzhxArr.length) {
                zzhx zzhx = zzhxArr[i2];
                zzob zzbg = this.zzago.zzaft.zzbht.zzbg(i2);
                if (zzbg != null) {
                    int i4 = i3 + 1;
                    this.zzagd[i3] = zzhx;
                    if (zzhx.getState() == 0) {
                        zzhz zzhz = this.zzago.zzaft.zzbhv[i2];
                        boolean z = this.zzaeu && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        int length = zzbg.length();
                        zzho[] zzhoArr = new zzho[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            zzhoArr[i5] = zzbg.zzbe(i5);
                        }
                        zzhk zzhk = this.zzago;
                        zzhx.zza(zzhz, zzhoArr, zzhk.zzafk[i2], this.zzagl, z2, zzhk.zzen());
                        zzpd zzdy = zzhx.zzdy();
                        if (zzdy != null) {
                            if (this.zzagc == null) {
                                this.zzagc = zzdy;
                                this.zzagb = zzhx;
                                zzdy.zzb(this.zzafd);
                            } else {
                                throw zzhd.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhx.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zznl] */
    @Override // com.google.android.gms.internal.ads.zzno
    public final /* synthetic */ void zza(zzmx zzmx) {
        this.handler.obtainMessage(9, zzmx).sendToTarget();
    }
}
