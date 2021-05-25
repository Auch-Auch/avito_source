package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;
public class DHKDFParameters implements DerivationParameters {
    public ASN1ObjectIdentifier a;
    public int b;
    public byte[] c;
    public byte[] d;

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr) {
        this(aSN1ObjectIdentifier, i, bArr, null);
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.a;
    }

    public byte[] getExtraInfo() {
        return this.d;
    }

    public int getKeySize() {
        return this.b;
    }

    public byte[] getZ() {
        return this.c;
    }

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.a = aSN1ObjectIdentifier;
        this.b = i;
        this.c = bArr;
        this.d = bArr2;
    }
}
