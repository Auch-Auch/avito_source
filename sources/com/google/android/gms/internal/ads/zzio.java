package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
public final class zzio {
    private static boolean zzajj = false;
    private static boolean zzajk = false;
    private int streamType;
    private zzhu zzafd;
    private int zzahj;
    private final zzif zzajl = null;
    private final zziz zzajm;
    private final zzje zzajn;
    private final zzie[] zzajo;
    private final zziu zzajp;
    private final ConditionVariable zzajq;
    private final long[] zzajr;
    private final zziq zzajs;
    private final LinkedList<zzix> zzajt;
    private AudioTrack zzaju;
    private int zzajv;
    private int zzajw;
    private int zzajx;
    private boolean zzajy;
    private int zzajz;
    private long zzaka;
    private zzhu zzakb;
    private long zzakc;
    private long zzakd;
    private ByteBuffer zzake;
    private int zzakf;
    private int zzakg;
    private int zzakh;
    private long zzaki;
    private long zzakj;
    private boolean zzakk;
    private long zzakl;
    private Method zzakm;
    private int zzakn;
    private long zzako;
    private long zzakp;
    private int zzakq;
    private long zzakr;
    private long zzaks;
    private int zzakt;
    private int zzaku;
    private long zzakv;
    private long zzakw;
    private long zzakx;
    private zzie[] zzaky;
    private ByteBuffer[] zzakz;
    private ByteBuffer zzala;
    private ByteBuffer zzalb;
    private byte[] zzalc;
    private int zzald;
    private int zzale;
    private boolean zzalf;
    private boolean zzalg;
    private int zzalh;
    private boolean zzali;
    private boolean zzalj;
    private long zzalk;
    private float zzdj;

    public zzio(zzif zzif, zzie[] zzieArr, zziu zziu) {
        this.zzajp = zziu;
        this.zzajq = new ConditionVariable(true);
        if (zzpq.SDK_INT >= 18) {
            try {
                this.zzakm = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpq.SDK_INT >= 19) {
            this.zzajs = new zzit();
        } else {
            this.zzajs = new zziq(null);
        }
        zziz zziz = new zziz();
        this.zzajm = zziz;
        zzje zzje = new zzje();
        this.zzajn = zzje;
        zzie[] zzieArr2 = new zzie[(zzieArr.length + 3)];
        this.zzajo = zzieArr2;
        zzieArr2[0] = new zzjc();
        zzieArr2[1] = zziz;
        System.arraycopy(zzieArr, 0, zzieArr2, 2, zzieArr.length);
        zzieArr2[zzieArr.length + 2] = zzje;
        this.zzajr = new long[10];
        this.zzdj = 1.0f;
        this.zzaku = 0;
        this.streamType = 3;
        this.zzalh = 0;
        this.zzafd = zzhu.zzahv;
        this.zzale = -1;
        this.zzaky = new zzie[0];
        this.zzakz = new ByteBuffer[0];
        this.zzajt = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzaju != null;
    }

    private static int zzaz(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    c = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c = 1;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = 2;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 7;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zziw {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zzc(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzdv(long j) throws zziw {
        ByteBuffer byteBuffer;
        int length = this.zzaky.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzakz[i - 1];
            } else {
                byteBuffer = this.zzala;
                if (byteBuffer == null) {
                    byteBuffer = zzie.zzaiu;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzie zzie = this.zzaky[i];
                zzie.zzn(byteBuffer);
                ByteBuffer zzfk = zzie.zzfk();
                this.zzakz[i] = zzfk;
                if (zzfk.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzahj);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzahj)) / 1000000;
    }

    private final void zzfl() {
        ArrayList arrayList = new ArrayList();
        zzie[] zzieArr = this.zzajo;
        for (zzie zzie : zzieArr) {
            if (zzie.isActive()) {
                arrayList.add(zzie);
            } else {
                zzie.flush();
            }
        }
        int size = arrayList.size();
        this.zzaky = (zzie[]) arrayList.toArray(new zzie[size]);
        this.zzakz = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzie zzie2 = this.zzaky[i];
            zzie2.flush();
            this.zzakz[i] = zzie2.zzfk();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfo() throws com.google.android.gms.internal.ads.zziw {
        /*
            r9 = this;
            int r0 = r9.zzale
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzajy
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzie[] r0 = r9.zzaky
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzale = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzale
            com.google.android.gms.internal.ads.zzie[] r5 = r9.zzaky
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfj()
        L_0x0028:
            r9.zzdv(r7)
            boolean r0 = r4.zzfc()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzale
            int r0 = r0 + r2
            r9.zzale = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzalb
            if (r0 == 0) goto L_0x0044
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzalb
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzale = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zzfo():boolean");
    }

    private final void zzfs() {
        if (!isInitialized()) {
            return;
        }
        if (zzpq.SDK_INT >= 21) {
            this.zzaju.setVolume(this.zzdj);
            return;
        }
        AudioTrack audioTrack = this.zzaju;
        float f = this.zzdj;
        audioTrack.setStereoVolume(f, f);
    }

    private final long zzft() {
        return this.zzajy ? this.zzaks : this.zzakr / ((long) this.zzakq);
    }

    private final void zzfu() {
        this.zzaki = 0;
        this.zzakh = 0;
        this.zzakg = 0;
        this.zzakj = 0;
        this.zzakk = false;
        this.zzakl = 0;
    }

    private final boolean zzfv() {
        if (zzpq.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzajx;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.zzalg = false;
        if (isInitialized()) {
            zzfu();
            this.zzajs.pause();
        }
    }

    public final void play() {
        this.zzalg = true;
        if (isInitialized()) {
            this.zzakw = System.nanoTime() / 1000;
            this.zzaju.play();
        }
    }

    public final void release() {
        reset();
        for (zzie zzie : this.zzajo) {
            zzie.reset();
        }
        this.zzalh = 0;
        this.zzalg = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzako = 0;
            this.zzakp = 0;
            this.zzakr = 0;
            this.zzaks = 0;
            this.zzakt = 0;
            zzhu zzhu = this.zzakb;
            if (zzhu != null) {
                this.zzafd = zzhu;
                this.zzakb = null;
            } else if (!this.zzajt.isEmpty()) {
                this.zzafd = this.zzajt.getLast().zzafd;
            }
            this.zzajt.clear();
            this.zzakc = 0;
            this.zzakd = 0;
            this.zzala = null;
            this.zzalb = null;
            int i = 0;
            while (true) {
                zzie[] zzieArr = this.zzaky;
                if (i >= zzieArr.length) {
                    break;
                }
                zzie zzie = zzieArr[i];
                zzie.flush();
                this.zzakz[i] = zzie.zzfk();
                i++;
            }
            this.zzalf = false;
            this.zzale = -1;
            this.zzake = null;
            this.zzakf = 0;
            this.zzaku = 0;
            this.zzakx = 0;
            zzfu();
            if (this.zzaju.getPlayState() == 3) {
                this.zzaju.pause();
            }
            AudioTrack audioTrack = this.zzaju;
            this.zzaju = null;
            this.zzajs.zza(null, false);
            this.zzajq.close();
            new zzir(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzali) {
                reset();
                this.zzalh = 0;
            }
        }
    }

    public final void setVolume(float f) {
        if (this.zzdj != f) {
            this.zzdj = f;
            zzfs();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzis {
        /*
        // Method dump skipped, instructions count: 340
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzay(String str) {
        zzif zzif = this.zzajl;
        return zzif != null && zzif.zzw(zzaz(str));
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) throws zziv, zziw {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = this.zzala;
        zzoz.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        AudioTrack audioTrack = null;
        if (!isInitialized()) {
            this.zzajq.block();
            if (this.zzali) {
                this.zzaju = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzajv).setEncoding(this.zzajx).setSampleRate(this.zzahj).build(), this.zzajz, 1, this.zzalh);
            } else if (this.zzalh == 0) {
                this.zzaju = new AudioTrack(this.streamType, this.zzahj, this.zzajv, this.zzajx, this.zzajz, 1);
            } else {
                this.zzaju = new AudioTrack(this.streamType, this.zzahj, this.zzajv, this.zzajx, this.zzajz, 1, this.zzalh);
            }
            int state = this.zzaju.getState();
            if (state == 1) {
                int audioSessionId = this.zzaju.getAudioSessionId();
                if (this.zzalh != audioSessionId) {
                    this.zzalh = audioSessionId;
                    this.zzajp.zzx(audioSessionId);
                }
                this.zzajs.zza(this.zzaju, zzfv());
                zzfs();
                this.zzalj = false;
                if (this.zzalg) {
                    play();
                }
            } else {
                try {
                    this.zzaju.release();
                } catch (Exception unused) {
                } finally {
                    this.zzaju = audioTrack;
                }
                throw new zziv(state, this.zzahj, this.zzajv, this.zzajz);
            }
        }
        if (zzfv()) {
            if (this.zzaju.getPlayState() == 2) {
                this.zzalj = false;
                return false;
            } else if (this.zzaju.getPlayState() == 1 && this.zzajs.zzfw() != 0) {
                return false;
            }
        }
        boolean z = this.zzalj;
        boolean zzfp = zzfp();
        this.zzalj = zzfp;
        if (z && !zzfp && this.zzaju.getPlayState() != 1) {
            this.zzajp.zzc(this.zzajz, zzha.zzdm(this.zzaka), SystemClock.elapsedRealtime() - this.zzalk);
        }
        if (this.zzala == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzajy && this.zzakt == 0) {
                int i3 = this.zzajx;
                if (i3 == 7 || i3 == 8) {
                    i2 = zziy.zzo(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzic.zzfg();
                } else if (i3 == 6) {
                    i2 = zzic.zzm(byteBuffer);
                } else {
                    throw new IllegalStateException(a.m2(38, "Unexpected audio encoding: ", i3));
                }
                this.zzakt = i2;
            }
            if (this.zzakb != null) {
                if (!zzfo()) {
                    return false;
                }
                this.zzajt.add(new zzix(this.zzakb, Math.max(0L, j), zzdw(zzft()), null));
                this.zzakb = null;
                zzfl();
            }
            if (this.zzaku == 0) {
                this.zzakv = Math.max(0L, j);
                this.zzaku = 1;
            } else {
                long zzdw = this.zzakv + zzdw(this.zzajy ? this.zzakp : this.zzako / ((long) this.zzakn));
                if (this.zzaku != 1 || Math.abs(zzdw - j) <= 200000) {
                    i = 2;
                } else {
                    i = 2;
                    this.zzaku = 2;
                }
                if (this.zzaku == i) {
                    this.zzakv = (j - zzdw) + this.zzakv;
                    this.zzaku = 1;
                    this.zzajp.zzel();
                }
            }
            if (this.zzajy) {
                this.zzakp += (long) this.zzakt;
            } else {
                this.zzako += (long) byteBuffer.remaining();
            }
            this.zzala = byteBuffer;
        }
        if (this.zzajy) {
            zzc(this.zzala, j);
        } else {
            zzdv(j);
        }
        if (this.zzala.hasRemaining()) {
            return false;
        }
        this.zzala = null;
        return true;
    }

    public final boolean zzfc() {
        if (isInitialized()) {
            return this.zzalf && !zzfp();
        }
        return true;
    }

    public final void zzfm() {
        if (this.zzaku == 1) {
            this.zzaku = 2;
        }
    }

    public final void zzfn() throws zziw {
        if (!this.zzalf && isInitialized() && zzfo()) {
            this.zzajs.zzdy(zzft());
            this.zzakf = 0;
            this.zzalf = true;
        }
    }

    public final boolean zzfp() {
        if (isInitialized()) {
            if (zzft() <= this.zzajs.zzfw()) {
                if (zzfv() && this.zzaju.getPlayState() == 2 && this.zzaju.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhu zzfq() {
        return this.zzafd;
    }

    public final void zzfr() {
        if (this.zzali) {
            this.zzali = false;
            this.zzalh = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long j;
        long j2;
        if (!(isInitialized() && this.zzaku != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzaju.getPlayState() == 3) {
            long zzfx = this.zzajs.zzfx();
            if (zzfx != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzakj >= 30000) {
                    long[] jArr = this.zzajr;
                    int i = this.zzakg;
                    jArr[i] = zzfx - nanoTime;
                    this.zzakg = (i + 1) % 10;
                    int i2 = this.zzakh;
                    if (i2 < 10) {
                        this.zzakh = i2 + 1;
                    }
                    this.zzakj = nanoTime;
                    this.zzaki = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzakh;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzaki = (this.zzajr[i3] / ((long) i4)) + this.zzaki;
                        i3++;
                    }
                }
                if (!zzfv() && nanoTime - this.zzakl >= 500000) {
                    boolean zzfy = this.zzajs.zzfy();
                    this.zzakk = zzfy;
                    if (zzfy) {
                        long zzfz = this.zzajs.zzfz() / 1000;
                        long zzga = this.zzajs.zzga();
                        if (zzfz < this.zzakw) {
                            this.zzakk = false;
                        } else if (Math.abs(zzfz - nanoTime) > 5000000) {
                            this.zzakk = false;
                        } else if (Math.abs(zzdw(zzga) - zzfx) > 5000000) {
                            this.zzakk = false;
                        }
                    }
                    Method method = this.zzakm;
                    if (method != null && !this.zzajy) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzaju, null)).intValue()) * 1000) - this.zzaka;
                            this.zzakx = intValue;
                            long max = Math.max(intValue, 0L);
                            this.zzakx = max;
                            if (max > 5000000) {
                                this.zzakx = 0;
                            }
                        } catch (Exception unused) {
                            this.zzakm = null;
                        }
                    }
                    this.zzakl = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzakk) {
            j = zzdw(this.zzajs.zzga() + zzdx(nanoTime2 - (this.zzajs.zzfz() / 1000)));
        } else {
            if (this.zzakh == 0) {
                j = this.zzajs.zzfx();
            } else {
                j = nanoTime2 + this.zzaki;
            }
            if (!z) {
                j -= this.zzakx;
            }
        }
        long j3 = this.zzakv;
        while (!this.zzajt.isEmpty() && j >= this.zzajt.getFirst().zzagr) {
            zzix remove = this.zzajt.remove();
            this.zzafd = remove.zzafd;
            this.zzakd = remove.zzagr;
            this.zzakc = remove.zzama - this.zzakv;
        }
        if (this.zzafd.zzahw == 1.0f) {
            j2 = (j + this.zzakc) - this.zzakd;
        } else if (!this.zzajt.isEmpty() || this.zzajn.zzge() < 1024) {
            j2 = ((long) (((double) this.zzafd.zzahw) * ((double) (j - this.zzakd)))) + this.zzakc;
        } else {
            j2 = zzpq.zza(j - this.zzakd, this.zzajn.zzgd(), this.zzajn.zzge()) + this.zzakc;
        }
        return j3 + j2;
    }

    public final void zzz(int i) {
        zzoz.checkState(zzpq.SDK_INT >= 21);
        if (!this.zzali || this.zzalh != i) {
            this.zzali = true;
            this.zzalh = i;
            reset();
        }
    }

    public final zzhu zzb(zzhu zzhu) {
        if (this.zzajy) {
            zzhu zzhu2 = zzhu.zzahv;
            this.zzafd = zzhu2;
            return zzhu2;
        }
        zzhu zzhu3 = new zzhu(this.zzajn.zza(zzhu.zzahw), this.zzajn.zzb(zzhu.zzahx));
        zzhu zzhu4 = this.zzakb;
        if (zzhu4 == null) {
            if (!this.zzajt.isEmpty()) {
                zzhu4 = this.zzajt.getLast().zzafd;
            } else {
                zzhu4 = this.zzafd;
            }
        }
        if (!zzhu3.equals(zzhu4)) {
            if (isInitialized()) {
                this.zzakb = zzhu3;
            } else {
                this.zzafd = zzhu3;
            }
        }
        return this.zzafd;
    }
}
