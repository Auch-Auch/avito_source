package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class AEADParameters implements CipherParameters {
    public byte[] a;
    public byte[] b;
    public KeyParameter c;
    public int d;

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, null);
    }

    public byte[] getAssociatedText() {
        return this.a;
    }

    public KeyParameter getKey() {
        return this.c;
    }

    public int getMacSize() {
        return this.d;
    }

    public byte[] getNonce() {
        return this.b;
    }

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr, byte[] bArr2) {
        this.c = keyParameter;
        this.b = bArr;
        this.d = i;
        this.a = bArr2;
    }
}
