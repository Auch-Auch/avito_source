package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@RequiresApi(19)
@TargetApi(19)
public abstract class zzlu extends zzhb {
    private static final byte[] zzbbh = zzpq.zzbm("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzho zzaht;
    private ByteBuffer[] zzakz;
    private final zzlw zzbbi;
    private final zzjs<zzju> zzbbj;
    private final boolean zzbbk;
    private final zzjk zzbbl;
    private final zzjk zzbbm;
    private final zzhq zzbbn;
    private final List<Long> zzbbo;
    private final MediaCodec.BufferInfo zzbbp;
    private zzjq<zzju> zzbbq;
    private zzjq<zzju> zzbbr;
    private MediaCodec zzbbs;
    private zzlr zzbbt;
    private boolean zzbbu;
    private boolean zzbbv;
    private boolean zzbbw;
    private boolean zzbbx;
    private boolean zzbby;
    private boolean zzbbz;
    private boolean zzbca;
    private boolean zzbcb;
    private boolean zzbcc;
    private ByteBuffer[] zzbcd;
    private long zzbce;
    private int zzbcf;
    private int zzbcg;
    private boolean zzbch;
    private boolean zzbci;
    private int zzbcj;
    private int zzbck;
    private boolean zzbcl;
    private boolean zzbcm;
    private boolean zzbcn;
    private boolean zzbco;
    private boolean zzbcp;
    private boolean zzbcq;
    public zzjl zzbcr;

    public zzlu(int i, zzlw zzlw, zzjs<zzju> zzjs, boolean z) {
        super(i);
        zzoz.checkState(zzpq.SDK_INT >= 16);
        this.zzbbi = (zzlw) zzoz.checkNotNull(zzlw);
        this.zzbbj = zzjs;
        this.zzbbk = z;
        this.zzbbl = new zzjk(0);
        this.zzbbm = new zzjk(0);
        this.zzbbn = new zzhq();
        this.zzbbo = new ArrayList();
        this.zzbbp = new MediaCodec.BufferInfo();
        this.zzbcj = 0;
        this.zzbck = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0145 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhf() throws com.google.android.gms.internal.ads.zzhd {
        /*
        // Method dump skipped, instructions count: 463
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzhf():boolean");
    }

    private final void zzhg() throws zzhd {
        if (this.zzbck == 2) {
            zzhe();
            zzhb();
            return;
        }
        this.zzbco = true;
        zzgc();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public boolean isReady() {
        if (this.zzaht == null || this.zzbcp) {
            return false;
        }
        if (zzeh() || this.zzbcg >= 0) {
            return true;
        }
        return this.zzbce != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.zzbce;
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public void onStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public void onStopped() {
    }

    @Override // com.google.android.gms.internal.ads.zzhw
    public final int zza(zzho zzho) throws zzhd {
        try {
            return zza(this.zzbbi, zzho);
        } catch (zzlz e) {
            throw zzhd.zza(e, getIndex());
        }
    }

    public abstract int zza(zzlw zzlw, zzho zzho) throws zzlz;

    public void zza(zzjk zzjk) {
    }

    public abstract void zza(zzlr zzlr, MediaCodec mediaCodec, zzho zzho, MediaCrypto mediaCrypto) throws zzlz;

    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhd;

    public boolean zza(MediaCodec mediaCodec, boolean z, zzho zzho, zzho zzho2) {
        return false;
    }

    public boolean zza(zzlr zzlr) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzb(long j, long j2) throws zzhd {
        if (this.zzbco) {
            zzgc();
            return;
        }
        if (this.zzaht == null) {
            this.zzbbm.clear();
            int zza = zza(this.zzbbn, this.zzbbm, true);
            if (zza == -5) {
                zzd(this.zzbbn.zzaht);
            } else if (zza == -4) {
                zzoz.checkState(this.zzbbm.zzgj());
                this.zzbcn = true;
                zzhg();
                return;
            } else {
                return;
            }
        }
        zzhb();
        if (this.zzbbs != null) {
            zzpn.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhf());
            zzpn.endSection();
        } else {
            zzdp(j);
            this.zzbbm.clear();
            int zza2 = zza(this.zzbbn, this.zzbbm, false);
            if (zza2 == -5) {
                zzd(this.zzbbn.zzaht);
            } else if (zza2 == -4) {
                zzoz.checkState(this.zzbbm.zzgj());
                this.zzbcn = true;
                zzhg();
            }
        }
        this.zzbcr.zzgl();
    }

    public void zzc(String str, long j, long j2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r5.height == r0.height) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzd(com.google.android.gms.internal.ads.zzho r5) throws com.google.android.gms.internal.ads.zzhd {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzho r0 = r4.zzaht
            r4.zzaht = r5
            com.google.android.gms.internal.ads.zzjn r5 = r5.zzahb
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            com.google.android.gms.internal.ads.zzjn r2 = r0.zzahb
        L_0x000d:
            boolean r5 = com.google.android.gms.internal.ads.zzpq.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzho r5 = r4.zzaht
            com.google.android.gms.internal.ads.zzjn r5 = r5.zzahb
            if (r5 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzjs<com.google.android.gms.internal.ads.zzju> r5 = r4.zzbbj
            if (r5 == 0) goto L_0x0037
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzho r3 = r4.zzaht
            com.google.android.gms.internal.ads.zzjn r3 = r3.zzahb
            com.google.android.gms.internal.ads.zzjq r5 = r5.zza(r1, r3)
            r4.zzbbr = r5
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbq
            if (r5 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzjs<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbj
            r1.zza(r5)
            goto L_0x0049
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzhd r5 = com.google.android.gms.internal.ads.zzhd.zza(r5, r0)
            throw r5
        L_0x0047:
            r4.zzbbr = r1
        L_0x0049:
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r5 = r4.zzbbr
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbq
            if (r5 != r1) goto L_0x007a
            android.media.MediaCodec r5 = r4.zzbbs
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzlr r1 = r4.zzbbt
            boolean r1 = r1.zzbba
            com.google.android.gms.internal.ads.zzho r3 = r4.zzaht
            boolean r5 = r4.zza(r5, r1, r0, r3)
            if (r5 == 0) goto L_0x007a
            r4.zzbci = r2
            r4.zzbcj = r2
            boolean r5 = r4.zzbbw
            if (r5 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzho r5 = r4.zzaht
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L_0x0076
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            r4.zzbcb = r2
            return
        L_0x007a:
            boolean r5 = r4.zzbcl
            if (r5 == 0) goto L_0x0081
            r4.zzbck = r2
            return
        L_0x0081:
            r4.zzhe()
            r4.zzhb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzd(com.google.android.gms.internal.ads.zzho):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public void zze(boolean z) throws zzhd {
        this.zzbcr = new zzjl();
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhw
    public final int zzee() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public void zzef() {
        zzjq<zzju> zzjq = null;
        this.zzaht = null;
        try {
            zzhe();
            try {
                zzjq<zzju> zzjq2 = this.zzbbq;
                if (zzjq2 != null) {
                    this.zzbbj.zza(zzjq2);
                }
                try {
                    zzjq<zzju> zzjq3 = this.zzbbr;
                    if (!(zzjq3 == null || zzjq3 == this.zzbbq)) {
                        this.zzbbj.zza(zzjq3);
                    }
                } finally {
                    this.zzbbq = zzjq;
                    this.zzbbr = zzjq;
                }
            } catch (Throwable th) {
                zzjq<zzju> zzjq4 = this.zzbbr;
                if (!(zzjq4 == null || zzjq4 == this.zzbbq)) {
                    this.zzbbj.zza(zzjq4);
                }
                throw th;
            } finally {
                this.zzbbq = zzjq;
                this.zzbbr = zzjq;
            }
        } catch (Throwable th2) {
            try {
                zzjq<zzju> zzjq5 = this.zzbbr;
                if (!(zzjq5 == null || zzjq5 == this.zzbbq)) {
                    this.zzbbj.zza(zzjq5);
                }
                throw th2;
            } finally {
                this.zzbbq = zzjq;
                this.zzbbr = zzjq;
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public boolean zzfc() {
        return this.zzbco;
    }

    public void zzgc() throws zzhd {
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0189 A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzhb() throws com.google.android.gms.internal.ads.zzhd {
        /*
        // Method dump skipped, instructions count: 517
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzhb():void");
    }

    public final MediaCodec zzhc() {
        return this.zzbbs;
    }

    public final zzlr zzhd() {
        return this.zzbbt;
    }

    public void zzhe() {
        this.zzbce = C.TIME_UNSET;
        this.zzbcf = -1;
        this.zzbcg = -1;
        this.zzbcp = false;
        this.zzbch = false;
        this.zzbbo.clear();
        zzjq<zzju> zzjq = null;
        this.zzbcd = null;
        this.zzakz = null;
        this.zzbbt = null;
        this.zzbci = false;
        this.zzbcl = false;
        this.zzbbu = false;
        this.zzbbv = false;
        this.zzbbw = false;
        this.zzbbx = false;
        this.zzbby = false;
        this.zzbca = false;
        this.zzbcb = false;
        this.zzbcc = false;
        this.zzbcm = false;
        this.zzbcj = 0;
        this.zzbck = 0;
        this.zzbbl.zzdd = null;
        MediaCodec mediaCodec = this.zzbbs;
        if (mediaCodec != null) {
            this.zzbcr.zzaoa++;
            try {
                mediaCodec.stop();
                try {
                    this.zzbbs.release();
                    this.zzbbs = null;
                    zzjq<zzju> zzjq2 = this.zzbbq;
                    if (zzjq2 != null && this.zzbbr != zzjq2) {
                        try {
                            this.zzbbj.zza(zzjq2);
                        } finally {
                            this.zzbbq = zzjq;
                        }
                    }
                } catch (Throwable th) {
                    this.zzbbs = null;
                    zzjq<zzju> zzjq3 = this.zzbbq;
                    if (!(zzjq3 == null || this.zzbbr == zzjq3)) {
                        this.zzbbj.zza(zzjq3);
                    }
                    throw th;
                } finally {
                    this.zzbbq = zzjq;
                }
            } catch (Throwable th2) {
                this.zzbbs = null;
                zzjq<zzju> zzjq4 = this.zzbbq;
                if (!(zzjq4 == null || this.zzbbr == zzjq4)) {
                    try {
                        this.zzbbj.zza(zzjq4);
                    } finally {
                        this.zzbbq = zzjq;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public zzlr zza(zzlw zzlw, zzho zzho, boolean z) throws zzlz {
        return zzlw.zzc(zzho.zzagy, z);
    }

    private final void zza(zzlt zzlt) throws zzhd {
        throw zzhd.zza(zzlt, getIndex());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public void zza(long j, boolean z) throws zzhd {
        this.zzbcn = false;
        this.zzbco = false;
        if (this.zzbbs != null) {
            this.zzbce = C.TIME_UNSET;
            this.zzbcf = -1;
            this.zzbcg = -1;
            this.zzbcq = true;
            this.zzbcp = false;
            this.zzbch = false;
            this.zzbbo.clear();
            this.zzbcb = false;
            this.zzbcc = false;
            if (this.zzbbv || (this.zzbby && this.zzbcm)) {
                zzhe();
                zzhb();
            } else if (this.zzbck != 0) {
                zzhe();
                zzhb();
            } else {
                this.zzbbs.flush();
                this.zzbcl = false;
            }
            if (this.zzbci && this.zzaht != null) {
                this.zzbcj = 1;
            }
        }
    }

    private final boolean zzd(long j, long j2) throws zzhd {
        boolean z;
        boolean z2;
        if (this.zzbcg < 0) {
            if (!this.zzbbz || !this.zzbcm) {
                this.zzbcg = this.zzbbs.dequeueOutputBuffer(this.zzbbp, 0);
            } else {
                try {
                    this.zzbcg = this.zzbbs.dequeueOutputBuffer(this.zzbbp, 0);
                } catch (IllegalStateException unused) {
                    zzhg();
                    if (this.zzbco) {
                        zzhe();
                    }
                    return false;
                }
            }
            int i = this.zzbcg;
            if (i >= 0) {
                if (this.zzbcc) {
                    this.zzbcc = false;
                    this.zzbbs.releaseOutputBuffer(i, false);
                    this.zzbcg = -1;
                    return true;
                }
                MediaCodec.BufferInfo bufferInfo = this.zzbbp;
                if ((bufferInfo.flags & 4) != 0) {
                    zzhg();
                    this.zzbcg = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.zzakz[i];
                if (byteBuffer != null) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.zzbbp;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j3 = this.zzbbp.presentationTimeUs;
                int size = this.zzbbo.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z2 = false;
                        break;
                    } else if (this.zzbbo.get(i2).longValue() == j3) {
                        this.zzbbo.remove(i2);
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.zzbch = z2;
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzbbs.getOutputFormat();
                if (this.zzbbw && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                    this.zzbcc = true;
                } else {
                    if (this.zzbca) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbbs, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzakz = this.zzbbs.getOutputBuffers();
                return true;
            } else {
                if (this.zzbbx && (this.zzbcn || this.zzbck == 2)) {
                    zzhg();
                }
                return false;
            }
        }
        if (!this.zzbbz || !this.zzbcm) {
            MediaCodec mediaCodec = this.zzbbs;
            ByteBuffer[] byteBufferArr = this.zzakz;
            int i3 = this.zzbcg;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.zzbbp;
            z = zza(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzbch);
        } else {
            try {
                MediaCodec mediaCodec2 = this.zzbbs;
                ByteBuffer[] byteBufferArr2 = this.zzakz;
                int i4 = this.zzbcg;
                ByteBuffer byteBuffer3 = byteBufferArr2[i4];
                MediaCodec.BufferInfo bufferInfo4 = this.zzbbp;
                z = zza(j, j2, mediaCodec2, byteBuffer3, i4, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.zzbch);
            } catch (IllegalStateException unused2) {
                zzhg();
                if (this.zzbco) {
                    zzhe();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzbbp.presentationTimeUs;
        this.zzbcg = -1;
        return true;
    }
}
