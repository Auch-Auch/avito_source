package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DLSet;
public class Attributes extends ASN1Object {
    public ASN1Set a;

    public Attributes(ASN1Set aSN1Set) {
        this.a = aSN1Set;
    }

    public static Attributes getInstance(Object obj) {
        if (obj instanceof Attributes) {
            return (Attributes) obj;
        }
        if (obj != null) {
            return new Attributes(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public Attribute[] getAttributes() {
        int size = this.a.size();
        Attribute[] attributeArr = new Attribute[size];
        for (int i = 0; i != size; i++) {
            attributeArr[i] = Attribute.getInstance(this.a.getObjectAt(i));
        }
        return attributeArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public Attributes(ASN1EncodableVector aSN1EncodableVector) {
        this.a = new DLSet(aSN1EncodableVector);
    }
}
