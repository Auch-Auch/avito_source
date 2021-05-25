package org.spongycastle.asn1.isismtt.ocsp;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class CertHash extends ASN1Object {
    public AlgorithmIdentifier a;
    public byte[] b;

    public CertHash(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static CertHash getInstance(Object obj) {
        if (obj == null || (obj instanceof CertHash)) {
            return (CertHash) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertHash((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public byte[] getCertificateHash() {
        return this.b;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DEROctetString(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public CertHash(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = algorithmIdentifier;
        byte[] bArr2 = new byte[bArr.length];
        this.b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }
}
