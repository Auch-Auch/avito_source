package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class McElieceCCA2KeyParameters extends AsymmetricKeyParameter {
    public String b;

    public McElieceCCA2KeyParameters(boolean z, String str) {
        super(z);
        this.b = str;
    }

    public String getDigest() {
        return this.b;
    }
}
