package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;
public final class QRCodeDecoderMetaData {
    public final boolean a;

    public QRCodeDecoderMetaData(boolean z) {
        this.a = z;
    }

    public void applyMirroredCorrection(ResultPoint[] resultPointArr) {
        if (this.a && resultPointArr != null && resultPointArr.length >= 3) {
            ResultPoint resultPoint = resultPointArr[0];
            resultPointArr[0] = resultPointArr[2];
            resultPointArr[2] = resultPoint;
        }
    }

    public boolean isMirrored() {
        return this.a;
    }
}
