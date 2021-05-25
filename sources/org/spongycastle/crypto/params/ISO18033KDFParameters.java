package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
public class ISO18033KDFParameters implements DerivationParameters {
    public byte[] a;

    public ISO18033KDFParameters(byte[] bArr) {
        this.a = bArr;
    }

    public byte[] getSeed() {
        return this.a;
    }
}
