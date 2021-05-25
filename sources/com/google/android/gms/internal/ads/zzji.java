package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
@TargetApi(24)
public final class zzji {
    private final MediaCodec.CryptoInfo zzant;
    private final MediaCodec.CryptoInfo.Pattern zzanv;

    private zzji(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzant = cryptoInfo;
        this.zzanv = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzanv.set(i, i2);
        this.zzant.setPattern(this.zzanv);
    }
}
