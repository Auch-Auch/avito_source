package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.DLTaggedObject;
public class SafeBag extends ASN1Object {
    public ASN1ObjectIdentifier a;
    public ASN1Encodable b;
    public ASN1Set c;

    public SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.a = aSN1ObjectIdentifier;
        this.b = aSN1Encodable;
        this.c = null;
    }

    public static SafeBag getInstance(Object obj) {
        if (obj instanceof SafeBag) {
            return (SafeBag) obj;
        }
        if (obj != null) {
            return new SafeBag(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Set getBagAttributes() {
        return this.c;
    }

    public ASN1ObjectIdentifier getBagId() {
        return this.a;
    }

    public ASN1Encodable getBagValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DLTaggedObject(true, 0, this.b));
        ASN1Set aSN1Set = this.c;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(aSN1Set);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set) {
        this.a = aSN1ObjectIdentifier;
        this.b = aSN1Encodable;
        this.c = aSN1Set;
    }

    public SafeBag(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.b = ((ASN1TaggedObject) aSN1Sequence.getObjectAt(1)).getObject();
        if (aSN1Sequence.size() == 3) {
            this.c = (ASN1Set) aSN1Sequence.getObjectAt(2);
        }
    }
}
