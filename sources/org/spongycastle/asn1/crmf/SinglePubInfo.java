package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;
public class SinglePubInfo extends ASN1Object {
    public ASN1Integer a;
    public GeneralName b;

    public SinglePubInfo(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.b = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static SinglePubInfo getInstance(Object obj) {
        if (obj instanceof SinglePubInfo) {
            return (SinglePubInfo) obj;
        }
        if (obj != null) {
            return new SinglePubInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getPubLocation() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        GeneralName generalName = this.b;
        if (generalName != null) {
            aSN1EncodableVector.add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
