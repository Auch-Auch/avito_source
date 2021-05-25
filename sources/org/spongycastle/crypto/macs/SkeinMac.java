package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SkeinParameters;
public class SkeinMac implements Mac {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    public SkeinEngine a;

    public SkeinMac(int i, int i2) {
        this.a = new SkeinEngine(i, i2);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        return this.a.doFinal(bArr, i);
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        StringBuilder L = a.L("Skein-MAC-");
        L.append(this.a.getBlockSize() * 8);
        L.append("-");
        L.append(this.a.getOutputSize() * 8);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.a.getOutputSize();
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        SkeinParameters skeinParameters;
        if (cipherParameters instanceof SkeinParameters) {
            skeinParameters = (SkeinParameters) cipherParameters;
        } else if (cipherParameters instanceof KeyParameter) {
            skeinParameters = new SkeinParameters.Builder().setKey(((KeyParameter) cipherParameters).getKey()).build();
        } else {
            throw new IllegalArgumentException(a.E(cipherParameters, a.L("Invalid parameter passed to Skein MAC init - ")));
        }
        if (skeinParameters.getKey() != null) {
            this.a.init(skeinParameters);
            return;
        }
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b) {
        this.a.update(b);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    public SkeinMac(SkeinMac skeinMac) {
        this.a = new SkeinEngine(skeinMac.a);
    }
}
