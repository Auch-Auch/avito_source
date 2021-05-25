package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public class ExchangePair {
    public final AsymmetricKeyParameter a;
    public final byte[] b;

    public ExchangePair(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        this.a = asymmetricKeyParameter;
        this.b = Arrays.clone(bArr);
    }

    public AsymmetricKeyParameter getPublicKey() {
        return this.a;
    }

    public byte[] getSharedValue() {
        return Arrays.clone(this.b);
    }
}
