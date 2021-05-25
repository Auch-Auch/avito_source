package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class OtherHash extends ASN1Object implements ASN1Choice {
    public ASN1OctetString a;
    public OtherHashAlgAndValue b;

    public OtherHash(ASN1OctetString aSN1OctetString) {
        this.a = aSN1OctetString;
    }

    public static OtherHash getInstance(Object obj) {
        if (obj instanceof OtherHash) {
            return (OtherHash) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new OtherHash((ASN1OctetString) obj);
        }
        return new OtherHash(OtherHashAlgAndValue.getInstance(obj));
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.b;
        if (otherHashAlgAndValue == null) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
        }
        return otherHashAlgAndValue.getHashAlgorithm();
    }

    public byte[] getHashValue() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.b;
        if (otherHashAlgAndValue == null) {
            return this.a.getOctets();
        }
        return otherHashAlgAndValue.getHashValue().getOctets();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.b;
        if (otherHashAlgAndValue == null) {
            return this.a;
        }
        return otherHashAlgAndValue.toASN1Primitive();
    }

    public OtherHash(OtherHashAlgAndValue otherHashAlgAndValue) {
        this.b = otherHashAlgAndValue;
    }

    public OtherHash(byte[] bArr) {
        this.a = new DEROctetString(bArr);
    }
}
