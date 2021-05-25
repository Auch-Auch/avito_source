package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
public class Target extends ASN1Object implements ASN1Choice {
    public static final int targetGroup = 1;
    public static final int targetName = 0;
    public GeneralName a;
    public GeneralName b;

    public Target(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.a = GeneralName.getInstance(aSN1TaggedObject, true);
        } else if (tagNo == 1) {
            this.b = GeneralName.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag: ")));
        }
    }

    public static Target getInstance(Object obj) {
        if (obj == null || (obj instanceof Target)) {
            return (Target) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Target((ASN1TaggedObject) obj);
        }
        StringBuilder L = a.L("unknown object in factory: ");
        L.append(obj.getClass());
        throw new IllegalArgumentException(L.toString());
    }

    public GeneralName getTargetGroup() {
        return this.b;
    }

    public GeneralName getTargetName() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        GeneralName generalName = this.a;
        if (generalName != null) {
            return new DERTaggedObject(true, 0, generalName);
        }
        return new DERTaggedObject(true, 1, this.b);
    }

    public Target(int i, GeneralName generalName) {
        this(new DERTaggedObject(i, generalName));
    }
}
