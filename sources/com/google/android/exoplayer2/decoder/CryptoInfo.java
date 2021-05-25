package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class CryptoInfo {
    public final MediaCodec.CryptoInfo a;
    @Nullable
    public final b b;
    public int clearBlocks;
    public int encryptedBlocks;
    @Nullable
    public byte[] iv;
    @Nullable
    public byte[] key;
    public int mode;
    @Nullable
    public int[] numBytesOfClearData;
    @Nullable
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    @RequiresApi(24)
    public static final class b {
        public final MediaCodec.CryptoInfo a;
        public final MediaCodec.CryptoInfo.Pattern b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this.a = cryptoInfo;
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.a = cryptoInfo;
        this.b = Util.SDK_INT >= 24 ? new b(cryptoInfo, null) : null;
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.a;
    }

    @Deprecated
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return getFrameworkCryptoInfo();
    }

    public void increaseClearDataFirstSubSampleBy(int i) {
        if (i != 0) {
            if (this.numBytesOfClearData == null) {
                int[] iArr = new int[1];
                this.numBytesOfClearData = iArr;
                this.a.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.numBytesOfClearData;
            iArr2[0] = iArr2[0] + i;
        }
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.a;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (Util.SDK_INT >= 24) {
            b bVar = (b) Assertions.checkNotNull(this.b);
            bVar.b.set(i3, i4);
            bVar.a.setPattern(bVar.b);
        }
    }
}
