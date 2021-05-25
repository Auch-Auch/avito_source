package org.spongycastle.asn1.misc;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1BitString;
import org.spongycastle.asn1.DERBitString;
public class NetscapeCertType extends DERBitString {
    public static final int objectSigning = 16;
    public static final int objectSigningCA = 1;
    public static final int reserved = 8;
    public static final int smime = 32;
    public static final int smimeCA = 2;
    public static final int sslCA = 4;
    public static final int sslClient = 128;
    public static final int sslServer = 64;

    public NetscapeCertType(int i) {
        super(ASN1BitString.getBytes(i), ASN1BitString.getPadBits(i));
    }

    @Override // org.spongycastle.asn1.ASN1BitString
    public String toString() {
        StringBuilder L = a.L("NetscapeCertType: 0x");
        L.append(Integer.toHexString(this.data[0] & 255));
        return L.toString();
    }

    public NetscapeCertType(DERBitString dERBitString) {
        super(dERBitString.getBytes(), dERBitString.getPadBits());
    }
}
