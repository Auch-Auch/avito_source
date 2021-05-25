package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class AsymmetricKeyParameter implements CipherParameters {
    public boolean a;

    public AsymmetricKeyParameter(boolean z) {
        this.a = z;
    }

    public boolean isPrivate() {
        return this.a;
    }
}
