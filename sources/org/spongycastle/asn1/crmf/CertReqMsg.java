package org.spongycastle.asn1.crmf;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class CertReqMsg extends ASN1Object {
    public CertRequest a;
    public ProofOfPossession b;
    public ASN1Sequence c;

    public CertReqMsg(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = CertRequest.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if ((nextElement instanceof ASN1TaggedObject) || (nextElement instanceof ProofOfPossession)) {
                this.b = ProofOfPossession.getInstance(nextElement);
            } else {
                this.c = ASN1Sequence.getInstance(nextElement);
            }
        }
    }

    public static CertReqMsg getInstance(Object obj) {
        if (obj instanceof CertReqMsg) {
            return (CertReqMsg) obj;
        }
        if (obj != null) {
            return new CertReqMsg(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertRequest getCertReq() {
        return this.a;
    }

    public ProofOfPossession getPop() {
        return this.b;
    }

    public ProofOfPossession getPopo() {
        return this.b;
    }

    public AttributeTypeAndValue[] getRegInfo() {
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.c.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ProofOfPossession proofOfPossession = this.b;
        if (proofOfPossession != null) {
            aSN1EncodableVector.add(proofOfPossession);
        }
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static CertReqMsg getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public CertReqMsg(CertRequest certRequest, ProofOfPossession proofOfPossession, AttributeTypeAndValue[] attributeTypeAndValueArr) {
        if (certRequest != null) {
            this.a = certRequest;
            this.b = proofOfPossession;
            if (attributeTypeAndValueArr != null) {
                this.c = new DERSequence(attributeTypeAndValueArr);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("'certReq' cannot be null");
    }
}
