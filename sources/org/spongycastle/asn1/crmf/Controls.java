package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class Controls extends ASN1Object {
    public ASN1Sequence a;

    public Controls(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static Controls getInstance(Object obj) {
        if (obj instanceof Controls) {
            return (Controls) obj;
        }
        if (obj != null) {
            return new Controls(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public AttributeTypeAndValue[] toAttributeTypeAndValueArray() {
        int size = this.a.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.a.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public Controls(AttributeTypeAndValue attributeTypeAndValue) {
        this.a = new DERSequence(attributeTypeAndValue);
    }

    public Controls(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (AttributeTypeAndValue attributeTypeAndValue : attributeTypeAndValueArr) {
            aSN1EncodableVector.add(attributeTypeAndValue);
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }
}
