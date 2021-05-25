package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class ParametersWithSBox implements CipherParameters {
    public CipherParameters a;
    public byte[] b;

    public ParametersWithSBox(CipherParameters cipherParameters, byte[] bArr) {
        this.a = cipherParameters;
        this.b = bArr;
    }

    public CipherParameters getParameters() {
        return this.a;
    }

    public byte[] getSBox() {
        return this.b;
    }
}
