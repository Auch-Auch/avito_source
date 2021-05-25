package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CMCUnsignedData extends ASN1Object {
    public final BodyPartPath a;
    public final ASN1ObjectIdentifier b;
    public final ASN1Encodable c;

    public CMCUnsignedData(BodyPartPath bodyPartPath, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.a = bodyPartPath;
        this.b = aSN1ObjectIdentifier;
        this.c = aSN1Encodable;
    }

    public static CMCUnsignedData getInstance(Object obj) {
        if (obj instanceof CMCUnsignedData) {
            return (CMCUnsignedData) obj;
        }
        if (obj != null) {
            return new CMCUnsignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartPath getBodyPartPath() {
        return this.a;
    }

    public ASN1Encodable getContent() {
        return this.c;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCUnsignedData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = BodyPartPath.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = aSN1Sequence.getObjectAt(2);
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
