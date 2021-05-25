package org.spongycastle.asn1.cms;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class EnvelopedData extends ASN1Object {
    public ASN1Integer a;
    public OriginatorInfo b;
    public ASN1Set c;
    public EncryptedContentInfo d;
    public ASN1Set e;

    public EnvelopedData(OriginatorInfo originatorInfo, ASN1Set aSN1Set, EncryptedContentInfo encryptedContentInfo, ASN1Set aSN1Set2) {
        this.a = new ASN1Integer((long) calculateVersion(originatorInfo, aSN1Set, aSN1Set2));
        this.b = originatorInfo;
        this.c = aSN1Set;
        this.d = encryptedContentInfo;
        this.e = aSN1Set2;
    }

    public static int calculateVersion(OriginatorInfo originatorInfo, ASN1Set aSN1Set, ASN1Set aSN1Set2) {
        if (originatorInfo != null || aSN1Set2 != null) {
            return 2;
        }
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            if (RecipientInfo.getInstance(objects.nextElement()).getVersion().getValue().intValue() != 0) {
                return 2;
            }
        }
        return 0;
    }

    public static EnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.d;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.b;
    }

    public ASN1Set getRecipientInfos() {
        return this.c;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.e;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        OriginatorInfo originatorInfo = this.b;
        if (originatorInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, originatorInfo));
        }
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        ASN1Set aSN1Set = this.e;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public static EnvelopedData getInstance(Object obj) {
        if (obj instanceof EnvelopedData) {
            return (EnvelopedData) obj;
        }
        if (obj != null) {
            return new EnvelopedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EnvelopedData(OriginatorInfo originatorInfo, ASN1Set aSN1Set, EncryptedContentInfo encryptedContentInfo, Attributes attributes) {
        this.a = new ASN1Integer((long) calculateVersion(originatorInfo, aSN1Set, ASN1Set.getInstance(attributes)));
        this.b = originatorInfo;
        this.c = aSN1Set;
        this.d = encryptedContentInfo;
        this.e = ASN1Set.getInstance(attributes);
    }

    public EnvelopedData(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
        int i = 2;
        if (objectAt instanceof ASN1TaggedObject) {
            this.b = OriginatorInfo.getInstance((ASN1TaggedObject) objectAt, false);
            objectAt = aSN1Sequence.getObjectAt(2);
            i = 3;
        }
        this.c = ASN1Set.getInstance(objectAt);
        int i2 = i + 1;
        this.d = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
        if (aSN1Sequence.size() > i2) {
            this.e = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), false);
        }
    }
}
