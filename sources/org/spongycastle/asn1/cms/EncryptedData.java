package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
public class EncryptedData extends ASN1Object {
    public ASN1Integer a;
    public EncryptedContentInfo b;
    public ASN1Set c;

    public EncryptedData(EncryptedContentInfo encryptedContentInfo) {
        this(encryptedContentInfo, null);
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj != null) {
            return new EncryptedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.b;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.c;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        ASN1Set aSN1Set = this.c;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new BERTaggedObject(false, 1, aSN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo, ASN1Set aSN1Set) {
        this.a = new ASN1Integer(aSN1Set == null ? 0 : 2);
        this.b = encryptedContentInfo;
        this.c = aSN1Set;
    }

    public EncryptedData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() == 3) {
            this.c = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), false);
        }
    }
}
