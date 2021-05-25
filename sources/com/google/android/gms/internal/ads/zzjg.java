package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
public final class zzjg {
    public byte[] iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzanr;
    private int zzans;
    private final MediaCodec.CryptoInfo zzant;
    private final zzji zzanu;

    public zzjg() {
        int i = zzpq.SDK_INT;
        zzji zzji = null;
        MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzant = cryptoInfo;
        this.zzanu = i >= 24 ? new zzji(cryptoInfo) : zzji;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.zzanr = 0;
        this.zzans = 0;
        int i3 = zzpq.SDK_INT;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzant;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i2;
            if (i3 >= 24) {
                this.zzanu.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgh() {
        return this.zzant;
    }
}
