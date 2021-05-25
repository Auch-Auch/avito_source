package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class ParametersWithID implements CipherParameters {
    public CipherParameters a;
    public byte[] b;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.a = cipherParameters;
        this.b = bArr;
    }

    public byte[] getID() {
        return this.b;
    }

    public CipherParameters getParameters() {
        return this.a;
    }
}
