package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
public class RDN extends ASN1Object {
    public ASN1Set a;

    public RDN(ASN1Set aSN1Set) {
        this.a = aSN1Set;
    }

    public static RDN getInstance(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        if (obj != null) {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.a.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.a.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int size = this.a.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.a.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        return this.a.size() > 1;
    }

    public int size() {
        return this.a.size();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(aSN1ObjectIdentifier);
        aSN1EncodableVector.add(aSN1Encodable);
        this.a = new DERSet(new DERSequence(aSN1EncodableVector));
    }

    public RDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.a = new DERSet(attributeTypeAndValue);
    }

    public RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.a = new DERSet(attributeTypeAndValueArr);
    }
}
