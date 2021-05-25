package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
public final class zzjw implements zzjy {
    private static final byte[] zzaon = new byte[4096];
    private long position;
    private final zzom zzaoo;
    private final long zzaop;
    private byte[] zzaoq = new byte[65536];
    private int zzaor;
    private int zzaos;

    public zzjw(zzom zzom, long j, long j2) {
        this.zzaoo = zzom;
        this.position = j;
        this.zzaop = j2;
    }

    private final int zzak(int i) {
        int min = Math.min(this.zzaos, i);
        zzal(min);
        return min;
    }

    private final void zzal(int i) {
        int i2 = this.zzaos - i;
        this.zzaos = i2;
        this.zzaor = 0;
        byte[] bArr = this.zzaoq;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.zzaoq = bArr2;
    }

    private final void zzam(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzaos;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzaoq, 0, bArr, i, min);
        zzal(min);
        return min;
    }

    private final boolean zzd(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzaor + i;
        byte[] bArr = this.zzaoq;
        if (i2 > bArr.length) {
            this.zzaoq = Arrays.copyOf(this.zzaoq, zzpq.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzaos - this.zzaor, i);
        while (min < i) {
            min = zza(this.zzaoq, this.zzaor, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.zzaor + i;
        this.zzaor = i3;
        this.zzaos = Math.max(this.zzaos, i3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final long getLength() {
        return this.zzaop;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzam(zzb);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzam(zzb);
        return zzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final int zzah(int i) throws IOException, InterruptedException {
        int zzak = zzak(i);
        if (zzak == 0) {
            byte[] bArr = zzaon;
            zzak = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzam(zzak);
        return zzak;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzai(int i) throws IOException, InterruptedException {
        int zzak = zzak(i);
        while (zzak < i && zzak != -1) {
            byte[] bArr = zzaon;
            zzak = zza(bArr, -zzak, Math.min(i, bArr.length + zzak), zzak, false);
        }
        zzam(zzak);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzaj(int i) throws IOException, InterruptedException {
        zzd(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzgo() {
        this.zzaor = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzaoq, this.zzaor - i2, bArr, i, i2);
        }
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzaoo.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}
