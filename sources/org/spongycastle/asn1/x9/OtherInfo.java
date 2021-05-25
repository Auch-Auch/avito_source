package org.spongycastle.asn1.x9;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class OtherInfo extends ASN1Object {
    public KeySpecificInfo a;
    public ASN1OctetString b;
    public ASN1OctetString c;

    public OtherInfo(KeySpecificInfo keySpecificInfo, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        this.a = keySpecificInfo;
        this.b = aSN1OctetString;
        this.c = aSN1OctetString2;
    }

    public static OtherInfo getInstance(Object obj) {
        if (obj instanceof OtherInfo) {
            return (OtherInfo) obj;
        }
        if (obj != null) {
            return new OtherInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public KeySpecificInfo getKeyInfo() {
        return this.a;
    }

    public ASN1OctetString getPartyAInfo() {
        return this.b;
    }

    public ASN1OctetString getSuppPubInfo() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1OctetString aSN1OctetString = this.b;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, aSN1OctetString));
        }
        aSN1EncodableVector.add(new DERTaggedObject(2, this.c));
        return new DERSequence(aSN1EncodableVector);
    }

    public OtherInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = KeySpecificInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.b = (ASN1OctetString) aSN1TaggedObject.getObject();
            } else if (aSN1TaggedObject.getTagNo() == 2) {
                this.c = (ASN1OctetString) aSN1TaggedObject.getObject();
            }
        }
    }
}
