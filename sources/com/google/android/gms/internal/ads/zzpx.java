package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
@TargetApi(16)
public final class zzpx extends zzlu {
    private static final int[] zzbkx = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzaib;
    private boolean zzali;
    private final zzqb zzbky;
    private final zzqg zzbkz;
    private final long zzbla;
    private final int zzblb;
    private final boolean zzblc;
    private final long[] zzbld;
    private zzho[] zzble;
    private zzpz zzblf;
    private Surface zzblg;
    private Surface zzblh;
    private int zzbli;
    private boolean zzblj;
    private long zzblk;
    private long zzbll;
    private int zzblm;
    private int zzbln;
    private int zzblo;
    private float zzblp;
    private int zzblq;
    private int zzblr;
    private int zzbls;
    private float zzblt;
    private int zzblu;
    private int zzblv;
    private int zzblw;
    private float zzblx;
    public zzqc zzbly;
    private long zzblz;
    private int zzbma;
    private final Context zzvr;

    public zzpx(Context context, zzlw zzlw, long j, Handler handler, zzqd zzqd, int i) {
        this(context, zzlw, 0, null, false, handler, zzqd, -1);
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjk();
        zzpn.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpn.endSection();
        this.zzbcr.zzaoc++;
        this.zzbln = 0;
        zzji();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzho zzho) {
        int i = zzho.zzagz;
        if (i != -1) {
            return i;
        }
        return zza(zzho.zzagy, zzho.width, zzho.height);
    }

    private static int zzj(zzho zzho) {
        int i = zzho.zzahd;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzjg() {
        this.zzblk = this.zzbla > 0 ? SystemClock.elapsedRealtime() + this.zzbla : C.TIME_UNSET;
    }

    private final void zzjh() {
        MediaCodec zzhc;
        this.zzblj = false;
        if (zzpq.SDK_INT >= 23 && this.zzali && (zzhc = zzhc()) != null) {
            this.zzbly = new zzqc(this, zzhc);
        }
    }

    private final void zzjj() {
        this.zzblu = -1;
        this.zzblv = -1;
        this.zzblx = -1.0f;
        this.zzblw = -1;
    }

    private final void zzjk() {
        int i = this.zzblu;
        int i2 = this.zzblq;
        if (i != i2 || this.zzblv != this.zzblr || this.zzblw != this.zzbls || this.zzblx != this.zzblt) {
            this.zzbkz.zzb(i2, this.zzblr, this.zzbls, this.zzblt);
            this.zzblu = this.zzblq;
            this.zzblv = this.zzblr;
            this.zzblw = this.zzbls;
            this.zzblx = this.zzblt;
        }
    }

    private final void zzjl() {
        if (this.zzblu != -1 || this.zzblv != -1) {
            this.zzbkz.zzb(this.zzblq, this.zzblr, this.zzbls, this.zzblt);
        }
    }

    private final void zzjm() {
        if (this.zzblm > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbkz.zzf(this.zzblm, elapsedRealtime - this.zzbll);
            this.zzblm = 0;
            this.zzbll = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzpq.SDK_INT < 23 || this.zzali) {
            return false;
        }
        return !z || zzpt.zzc(this.zzvr);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblj || (((surface = this.zzblh) != null && this.zzblg == surface) || zzhc() == null))) {
            this.zzblk = C.TIME_UNSET;
            return true;
        } else if (this.zzblk == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzblk) {
                return true;
            }
            this.zzblk = C.TIME_UNSET;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        }
        this.zzblq = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
        this.zzblr = i2;
        float f = this.zzblp;
        this.zzblt = f;
        if (zzpq.SDK_INT >= 21) {
            int i3 = this.zzblo;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzblq;
                this.zzblq = i2;
                this.zzblr = i4;
                this.zzblt = 1.0f / f;
            }
        } else {
            this.zzbls = this.zzblo;
        }
        mediaCodec.setVideoScalingMode(this.zzbli);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void onStarted() {
        super.onStarted();
        this.zzblm = 0;
        this.zzbll = SystemClock.elapsedRealtime();
        this.zzblk = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void onStopped() {
        zzjm();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final int zza(zzlw zzlw, zzho zzho) throws zzlz {
        boolean z;
        int i;
        int i2;
        String str = zzho.zzagy;
        int i3 = 0;
        if (!zzpg.zzbg(str)) {
            return 0;
        }
        zzjn zzjn = zzho.zzahb;
        if (zzjn != null) {
            z = false;
            for (int i4 = 0; i4 < zzjn.zzaoh; i4++) {
                z |= zzjn.zzag(i4).zzaoi;
            }
        } else {
            z = false;
        }
        zzlr zzc = zzlw.zzc(str, z);
        boolean z2 = true;
        if (zzc == null) {
            return 1;
        }
        boolean zzbc = zzc.zzbc(zzho.zzagv);
        if (zzbc && (i = zzho.width) > 0 && (i2 = zzho.height) > 0) {
            if (zzpq.SDK_INT >= 21) {
                zzbc = zzc.zza(i, i2, (double) zzho.zzahc);
            } else {
                if (i * i2 > zzly.zzhi()) {
                    z2 = false;
                }
                if (!z2) {
                    String.valueOf(zzpq.zzbki).length();
                }
                zzbc = z2;
            }
        }
        int i5 = zzc.zzbba ? 8 : 4;
        if (zzc.zzali) {
            i3 = 16;
        }
        return (zzbc ? 3 : 2) | i5 | i3;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzc(String str, long j, long j2) {
        this.zzbkz.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzd(zzho zzho) throws zzhd {
        super.zzd(zzho);
        this.zzbkz.zzc(zzho);
        float f = zzho.zzahe;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzblp = f;
        this.zzblo = zzj(zzho);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zze(boolean z) throws zzhd {
        super.zze(z);
        int i = zzeg().zzaib;
        this.zzaib = i;
        this.zzali = i != 0;
        this.zzbkz.zzc(this.zzbcr);
        this.zzbky.enable();
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zzef() {
        this.zzblq = -1;
        this.zzblr = -1;
        this.zzblt = -1.0f;
        this.zzblp = -1.0f;
        this.zzblz = C.TIME_UNSET;
        this.zzbma = 0;
        zzjj();
        zzjh();
        this.zzbky.disable();
        this.zzbly = null;
        this.zzali = false;
        try {
            super.zzef();
        } finally {
            this.zzbcr.zzgl();
            this.zzbkz.zzd(this.zzbcr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzhe() {
        try {
            super.zzhe();
            Surface surface = this.zzblh;
            if (surface != null) {
                if (this.zzblg == surface) {
                    this.zzblg = null;
                }
                surface.release();
                this.zzblh = null;
            }
        } catch (Throwable th) {
            if (this.zzblh != null) {
                Surface surface2 = this.zzblg;
                Surface surface3 = this.zzblh;
                if (surface2 == surface3) {
                    this.zzblg = null;
                }
                surface3.release();
                this.zzblh = null;
            }
            throw th;
        }
    }

    public final void zzji() {
        if (!this.zzblj) {
            this.zzblj = true;
            this.zzbkz.zzb(this.zzblg);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzpx(Context context, zzlw zzlw, long j, zzjs<zzju> zzjs, boolean z, Handler handler, zzqd zzqd, int i) {
        super(2, zzlw, null, false);
        boolean z2 = false;
        this.zzbla = 0;
        this.zzblb = -1;
        this.zzvr = context.getApplicationContext();
        this.zzbky = new zzqb(context);
        this.zzbkz = new zzqg(handler, zzqd);
        if (zzpq.SDK_INT <= 22 && "foster".equals(zzpq.DEVICE) && "NVIDIA".equals(zzpq.MANUFACTURER)) {
            z2 = true;
        }
        this.zzblc = z2;
        this.zzbld = new long[10];
        this.zzblz = C.TIME_UNSET;
        this.zzblk = C.TIME_UNSET;
        this.zzblq = -1;
        this.zzblr = -1;
        this.zzblt = -1.0f;
        this.zzblp = -1.0f;
        this.zzbli = 1;
        zzjj();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(zzho[] zzhoArr, long j) throws zzhd {
        this.zzble = zzhoArr;
        if (this.zzblz == C.TIME_UNSET) {
            this.zzblz = j;
        } else {
            int i = this.zzbma;
            long[] jArr = this.zzbld;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
            } else {
                this.zzbma = i + 1;
            }
            jArr[this.zzbma - 1] = j;
        }
        super.zza(zzhoArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zza(long j, boolean z) throws zzhd {
        super.zza(j, z);
        zzjh();
        this.zzbln = 0;
        int i = this.zzbma;
        if (i != 0) {
            this.zzblz = this.zzbld[i - 1];
            this.zzbma = 0;
        }
        if (z) {
            zzjg();
        } else {
            this.zzblk = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhe
    public final void zza(int i, Object obj) throws zzhd {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzblh;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzlr zzhd = zzhd();
                    if (zzhd != null && zzn(zzhd.zzbbb)) {
                        surface = zzpt.zzc(this.zzvr, zzhd.zzbbb);
                        this.zzblh = surface;
                    }
                }
            }
            if (this.zzblg != surface) {
                this.zzblg = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhc = zzhc();
                    if (zzpq.SDK_INT < 23 || zzhc == null || surface == null) {
                        zzhe();
                        zzhb();
                    } else {
                        zzhc.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzblh) {
                    zzjj();
                    zzjh();
                    return;
                }
                zzjl();
                zzjh();
                if (state == 2) {
                    zzjg();
                }
            } else if (surface != null && surface != this.zzblh) {
                zzjl();
                if (this.zzblj) {
                    this.zzbkz.zzb(this.zzblg);
                }
            }
        } else if (i == 4) {
            this.zzbli = ((Integer) obj).intValue();
            MediaCodec zzhc2 = zzhc();
            if (zzhc2 != null) {
                zzhc2.setVideoScalingMode(this.zzbli);
            }
        } else {
            super.zza(i, obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zza(zzlr zzlr) {
        return this.zzblg != null || zzn(zzlr.zzbbb);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r4 = null;
     */
    @Override // com.google.android.gms.internal.ads.zzlu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzlr r21, android.media.MediaCodec r22, com.google.android.gms.internal.ads.zzho r23, android.media.MediaCrypto r24) throws com.google.android.gms.internal.ads.zzlz {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpx.zza(com.google.android.gms.internal.ads.zzlr, android.media.MediaCodec, com.google.android.gms.internal.ads.zzho, android.media.MediaCrypto):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zza(zzjk zzjk) {
        if (zzpq.SDK_INT < 23 && this.zzali) {
            zzji();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzho zzho, zzho zzho2) {
        if (!zza(z, zzho, zzho2)) {
            return false;
        }
        int i = zzho2.width;
        zzpz zzpz = this.zzblf;
        return i <= zzpz.width && zzho2.height <= zzpz.height && zzho2.zzagz <= zzpz.zzbmb;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbma;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzbld;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzblz = jArr[0];
            int i4 = i3 - 1;
            this.zzbma = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j4 = j3 - this.zzblz;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzblg == this.zzblh) {
            if (!zzem(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        } else if (!this.zzblj) {
            if (zzpq.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzbky.zzf(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (zzf - nanoTime) / 1000;
            if (zzem(j6)) {
                zzpn.beginSection("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                zzpn.endSection();
                zzjl zzjl = this.zzbcr;
                zzjl.zzaoe++;
                this.zzblm++;
                int i5 = this.zzbln + 1;
                this.zzbln = i5;
                zzjl.zzaof = Math.max(i5, zzjl.zzaof);
                if (this.zzblm == this.zzblb) {
                    zzjm();
                }
                return true;
            }
            if (zzpq.SDK_INT >= 21) {
                if (j6 < 50000) {
                    zza(mediaCodec, i, j4, zzf);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec, i, j4);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpn.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpn.endSection();
        this.zzbcr.zzaod++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjk();
        zzpn.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpn.endSection();
        this.zzbcr.zzaoc++;
        this.zzbln = 0;
        zzji();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
                i3 = i * i2;
                i4 = 2;
                break;
            case 1:
            case 5:
                i3 = i * i2;
                break;
            case 3:
                if (!"BRAVIA 4K 2015".equals(zzpq.MODEL)) {
                    i3 = ((zzpq.zzf(i2, 16) * zzpq.zzf(i, 16)) << 4) << 4;
                    i4 = 2;
                    break;
                } else {
                    return -1;
                }
            default:
                return -1;
        }
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean zza(boolean z, zzho zzho, zzho zzho2) {
        if (!zzho.zzagy.equals(zzho2.zzagy) || zzj(zzho) != zzj(zzho2)) {
            return false;
        }
        if (!z) {
            return zzho.width == zzho2.width && zzho.height == zzho2.height;
        }
        return true;
    }
}
