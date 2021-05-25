package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.util.Arrays;
public class TweakableBlockCipherParameters implements CipherParameters {
    public final byte[] a;
    public final KeyParameter b;

    public TweakableBlockCipherParameters(KeyParameter keyParameter, byte[] bArr) {
        this.b = keyParameter;
        this.a = Arrays.clone(bArr);
    }

    public KeyParameter getKey() {
        return this.b;
    }

    public byte[] getTweak() {
        return this.a;
    }
}
