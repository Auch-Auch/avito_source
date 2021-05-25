package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class CertID extends ASN1Object {
    public AlgorithmIdentifier a;
    public ASN1OctetString b;
    public ASN1OctetString c;
    public ASN1Integer d;

    public CertID(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1Integer aSN1Integer) {
        this.a = algorithmIdentifier;
        this.b = aSN1OctetString;
        this.c = aSN1OctetString2;
        this.d = aSN1Integer;
    }

    public static CertID getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.a;
    }

    public ASN1OctetString getIssuerKeyHash() {
        return this.c;
    }

    public ASN1OctetString getIssuerNameHash() {
        return this.b;
    }

    public ASN1Integer getSerialNumber() {
        return this.d;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public static CertID getInstance(Object obj) {
        if (obj instanceof CertID) {
            return (CertID) obj;
        }
        if (obj != null) {
            return new CertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertID(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
        this.c = (ASN1OctetString) aSN1Sequence.getObjectAt(2);
        this.d = (ASN1Integer) aSN1Sequence.getObjectAt(3);
    }
}
