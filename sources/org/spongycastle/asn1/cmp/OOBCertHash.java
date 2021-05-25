package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.CertId;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class OOBCertHash extends ASN1Object {
    public AlgorithmIdentifier a;
    public CertId b;
    public DERBitString c;

    public OOBCertHash(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size() - 1;
        this.c = DERBitString.getInstance(aSN1Sequence.getObjectAt(size));
        for (int i = size - 1; i >= 0; i--) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.a = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else {
                this.b = CertId.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    public static OOBCertHash getInstance(Object obj) {
        if (obj instanceof OOBCertHash) {
            return (OOBCertHash) obj;
        }
        if (obj != null) {
            return new OOBCertHash(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertId getCertId() {
        return this.b;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.a;
    }

    public DERBitString getHashVal() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = this.a;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, algorithmIdentifier));
        }
        CertId certId = this.b;
        if (certId != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, certId));
        }
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public OOBCertHash(AlgorithmIdentifier algorithmIdentifier, CertId certId, byte[] bArr) {
        this(algorithmIdentifier, certId, new DERBitString(bArr));
    }

    public OOBCertHash(AlgorithmIdentifier algorithmIdentifier, CertId certId, DERBitString dERBitString) {
        this.a = algorithmIdentifier;
        this.b = certId;
        this.c = dERBitString;
    }
}
