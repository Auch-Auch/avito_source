package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
@TargetApi(16)
public final class zzjb extends zzlu implements zzpd {
    private int zzahi;
    private int zzahk;
    private final zzij zzamk;
    private final zzio zzaml;
    private boolean zzamm;
    private boolean zzamn;
    private MediaFormat zzamo;
    private long zzamp;
    private boolean zzamq;

    public zzjb(zzlw zzlw) {
        this(zzlw, null, true);
    }

    public static void zza(int i, long j, long j2) {
    }

    private final boolean zzba(String str) {
        return this.zzaml.zzay(str);
    }

    public static void zzgb() {
    }

    public static void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean isReady() {
        return this.zzaml.zzfp() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhd {
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.zzamo;
        boolean z = mediaFormat2 != null;
        String string = z ? mediaFormat2.getString("mime") : MimeTypes.AUDIO_RAW;
        if (z) {
            mediaFormat = this.zzamo;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzamn || integer != 6 || (i = this.zzahi) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahi; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.zzaml.zza(string, integer, integer2, this.zzahk, 0, iArr);
        } catch (zzis e) {
            throw zzhd.zza(e, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void onStarted() {
        super.onStarted();
        this.zzaml.play();
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void onStopped() {
        this.zzaml.pause();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final int zza(zzlw zzlw, zzho zzho) throws zzlz {
        int i;
        int i2;
        String str = zzho.zzagy;
        boolean z = false;
        if (!zzpg.zzbf(str)) {
            return 0;
        }
        int i3 = zzpq.SDK_INT;
        int i4 = i3 >= 21 ? 16 : 0;
        int i5 = 3;
        if (zzba(str) && zzlw.zzhh() != null) {
            return i4 | 4 | 3;
        }
        zzlr zzc = zzlw.zzc(str, false);
        if (zzc == null) {
            return 1;
        }
        if (i3 < 21 || (((i = zzho.zzahj) == -1 || zzc.zzay(i)) && ((i2 = zzho.zzahi) == -1 || zzc.zzaz(i2)))) {
            z = true;
        }
        if (!z) {
            i5 = 2;
        }
        return i4 | 4 | i5;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzb(zzhu zzhu) {
        return this.zzaml.zzb(zzhu);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzc(String str, long j, long j2) {
        this.zzamk.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzd(zzho zzho) throws zzhd {
        super.zzd(zzho);
        this.zzamk.zzc(zzho);
        this.zzahk = MimeTypes.AUDIO_RAW.equals(zzho.zzagy) ? zzho.zzahk : 2;
        this.zzahi = zzho.zzahi;
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhx
    public final zzpd zzdy() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zze(boolean z) throws zzhd {
        super.zze(z);
        this.zzamk.zzc(this.zzbcr);
        int i = zzeg().zzaib;
        if (i != 0) {
            this.zzaml.zzz(i);
        } else {
            this.zzaml.zzfr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zzef() {
        try {
            this.zzaml.release();
            try {
                super.zzef();
            } finally {
                this.zzbcr.zzgl();
                this.zzamk.zzd(this.zzbcr);
            }
        } catch (Throwable th) {
            super.zzef();
            throw th;
        } finally {
            this.zzbcr.zzgl();
            this.zzamk.zzd(this.zzbcr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean zzfc() {
        return super.zzfc() && this.zzaml.zzfc();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzfq() {
        return this.zzaml.zzfq();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final long zzfx() {
        long zzj = this.zzaml.zzj(zzfc());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzamq) {
                zzj = Math.max(this.zzamp, zzj);
            }
            this.zzamp = zzj;
            this.zzamq = false;
        }
        return this.zzamp;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzgc() throws zzhd {
        try {
            this.zzaml.zzfn();
        } catch (zziw e) {
            throw zzhd.zza(e, getIndex());
        }
    }

    private zzjb(zzlw zzlw, zzjs<zzju> zzjs, boolean z) {
        this(zzlw, null, true, null, null);
    }

    private zzjb(zzlw zzlw, zzjs<zzju> zzjs, boolean z, Handler handler, zzig zzig) {
        this(zzlw, null, true, null, null, null, new zzie[0]);
    }

    private zzjb(zzlw zzlw, zzjs<zzju> zzjs, boolean z, Handler handler, zzig zzig, zzif zzif, zzie... zzieArr) {
        super(1, zzlw, zzjs, z);
        this.zzaml = new zzio(null, zzieArr, new zzjd(this));
        this.zzamk = new zzij(null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final zzlr zza(zzlw zzlw, zzho zzho, boolean z) throws zzlz {
        zzlr zzhh;
        if (!zzba(zzho.zzagy) || (zzhh = zzlw.zzhh()) == null) {
            this.zzamm = false;
            return super.zza(zzlw, zzho, z);
        }
        this.zzamm = true;
        return zzhh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    @Override // com.google.android.gms.internal.ads.zzlu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzlr r4, android.media.MediaCodec r5, com.google.android.gms.internal.ads.zzho r6, android.media.MediaCrypto r7) {
        /*
            r3 = this;
            java.lang.String r4 = r4.name
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            r0 = 0
            r1 = 24
            if (r7 >= r1) goto L_0x0037
            java.lang.String r7 = "OMX.SEC.aac.dec"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpq.MANUFACTURER
            java.lang.String r7 = "samsung"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpq.DEVICE
            java.lang.String r7 = "zeroflte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = "herolte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = "heroqlte"
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L_0x0037
        L_0x0035:
            r4 = 1
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            r3.zzamn = r4
            boolean r4 = r3.zzamm
            r7 = 0
            if (r4 == 0) goto L_0x0059
            android.media.MediaFormat r4 = r6.zzey()
            r3.zzamo = r4
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/raw"
            r4.setString(r1, r2)
            android.media.MediaFormat r4 = r3.zzamo
            r5.configure(r4, r7, r7, r0)
            android.media.MediaFormat r4 = r3.zzamo
            java.lang.String r5 = r6.zzagy
            r4.setString(r1, r5)
            return
        L_0x0059:
            android.media.MediaFormat r4 = r6.zzey()
            r5.configure(r4, r7, r7, r0)
            r3.zzamo = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjb.zza(com.google.android.gms.internal.ads.zzlr, android.media.MediaCodec, com.google.android.gms.internal.ads.zzho, android.media.MediaCrypto):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    public final void zza(long j, boolean z) throws zzhd {
        super.zza(j, z);
        this.zzaml.reset();
        this.zzamp = j;
        this.zzamq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhd {
        if (this.zzamm && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbcr.zzaod++;
            this.zzaml.zzfm();
            return true;
        } else {
            try {
                if (!this.zzaml.zzb(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbcr.zzaoc++;
                return true;
            } catch (zziv | zziw e) {
                throw zzhd.zza(e, getIndex());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhe
    public final void zza(int i, Object obj) throws zzhd {
        if (i == 2) {
            this.zzaml.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzaml.setStreamType(((Integer) obj).intValue());
        }
    }
}
