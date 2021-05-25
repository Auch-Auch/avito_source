package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class ProtectedPart extends ASN1Object {
    public PKIHeader a;
    public PKIBody b;

    public ProtectedPart(ASN1Sequence aSN1Sequence) {
        this.a = PKIHeader.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = PKIBody.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static ProtectedPart getInstance(Object obj) {
        if (obj instanceof ProtectedPart) {
            return (ProtectedPart) obj;
        }
        if (obj != null) {
            return new ProtectedPart(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIBody getBody() {
        return this.b;
    }

    public PKIHeader getHeader() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public ProtectedPart(PKIHeader pKIHeader, PKIBody pKIBody) {
        this.a = pKIHeader;
        this.b = pKIBody;
    }
}
