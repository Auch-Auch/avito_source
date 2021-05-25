package org.spongycastle.pqc.crypto.gmss;
public class GMSSPublicKeyParameters extends GMSSKeyParameters {
    public byte[] c;

    public GMSSPublicKeyParameters(byte[] bArr, GMSSParameters gMSSParameters) {
        super(false, gMSSParameters);
        this.c = bArr;
    }

    public byte[] getPublicKey() {
        return this.c;
    }
}
