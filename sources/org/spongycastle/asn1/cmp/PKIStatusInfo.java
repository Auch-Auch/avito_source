package org.spongycastle.asn1.cmp;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
public class PKIStatusInfo extends ASN1Object {
    public ASN1Integer a;
    public PKIFreeText b;
    public DERBitString c;

    public PKIStatusInfo(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = null;
        this.c = null;
        if (aSN1Sequence.size() > 2) {
            this.b = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
        } else if (aSN1Sequence.size() > 1) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
            if (objectAt instanceof DERBitString) {
                this.c = DERBitString.getInstance(objectAt);
            } else {
                this.b = PKIFreeText.getInstance(objectAt);
            }
        }
    }

    public static PKIStatusInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERBitString getFailInfo() {
        return this.c;
    }

    public BigInteger getStatus() {
        return this.a.getValue();
    }

    public PKIFreeText getStatusString() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        PKIFreeText pKIFreeText = this.b;
        if (pKIFreeText != null) {
            aSN1EncodableVector.add(pKIFreeText);
        }
        DERBitString dERBitString = this.c;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static PKIStatusInfo getInstance(Object obj) {
        if (obj instanceof PKIStatusInfo) {
            return (PKIStatusInfo) obj;
        }
        if (obj != null) {
            return new PKIStatusInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIStatusInfo(PKIStatus pKIStatus) {
        this.a = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText) {
        this.a = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
        this.b = pKIFreeText;
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText, PKIFailureInfo pKIFailureInfo) {
        this.a = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
        this.b = pKIFreeText;
        this.c = pKIFailureInfo;
    }
}
