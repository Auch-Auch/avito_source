package org.spongycastle.asn1.cmp;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class PKIMessage extends ASN1Object {
    public PKIHeader a;
    public PKIBody b;
    public DERBitString c;
    public ASN1Sequence d;

    public PKIMessage(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = PKIHeader.getInstance(objects.nextElement());
        this.b = PKIBody.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.c = DERBitString.getInstance(aSN1TaggedObject, true);
            } else {
                this.d = ASN1Sequence.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    public static PKIMessage getInstance(Object obj) {
        if (obj instanceof PKIMessage) {
            return (PKIMessage) obj;
        }
        if (obj != null) {
            return new PKIMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIBody getBody() {
        return this.b;
    }

    public CMPCertificate[] getExtraCerts() {
        ASN1Sequence aSN1Sequence = this.d;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[size];
        for (int i = 0; i < size; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.d.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public PKIHeader getHeader() {
        return this.a;
    }

    public DERBitString getProtection() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        DERBitString dERBitString = this.c;
        if (dERBitString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, dERBitString));
        }
        ASN1Sequence aSN1Sequence = this.d;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, aSN1Sequence));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PKIMessage(PKIHeader pKIHeader, PKIBody pKIBody, DERBitString dERBitString, CMPCertificate[] cMPCertificateArr) {
        this.a = pKIHeader;
        this.b = pKIBody;
        this.c = dERBitString;
        if (cMPCertificateArr != null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (CMPCertificate cMPCertificate : cMPCertificateArr) {
                aSN1EncodableVector.add(cMPCertificate);
            }
            this.d = new DERSequence(aSN1EncodableVector);
        }
    }

    public PKIMessage(PKIHeader pKIHeader, PKIBody pKIBody, DERBitString dERBitString) {
        this(pKIHeader, pKIBody, dERBitString, null);
    }

    public PKIMessage(PKIHeader pKIHeader, PKIBody pKIBody) {
        this(pKIHeader, pKIBody, null, null);
    }
}
