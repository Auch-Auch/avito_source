package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class AuthEnvelopedData extends ASN1Object {
    public ASN1Integer a;
    public OriginatorInfo b;
    public ASN1Set c;
    public EncryptedContentInfo d;
    public ASN1Set e;
    public ASN1OctetString f;
    public ASN1Set g;

    public AuthEnvelopedData(OriginatorInfo originatorInfo, ASN1Set aSN1Set, EncryptedContentInfo encryptedContentInfo, ASN1Set aSN1Set2, ASN1OctetString aSN1OctetString, ASN1Set aSN1Set3) {
        this.a = new ASN1Integer(0);
        this.b = originatorInfo;
        this.c = aSN1Set;
        if (aSN1Set.size() != 0) {
            this.d = encryptedContentInfo;
            this.e = aSN1Set2;
            if (encryptedContentInfo.getContentType().equals(CMSObjectIdentifiers.data) || !(aSN1Set2 == null || aSN1Set2.size() == 0)) {
                this.f = aSN1OctetString;
                this.g = aSN1Set3;
                return;
            }
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
    }

    public static AuthEnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Set getAuthAttrs() {
        return this.e;
    }

    public EncryptedContentInfo getAuthEncryptedContentInfo() {
        return this.d;
    }

    public ASN1OctetString getMac() {
        return this.f;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.b;
    }

    public ASN1Set getRecipientInfos() {
        return this.c;
    }

    public ASN1Set getUnauthAttrs() {
        return this.g;
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
        aSN1EncodableVector.add(this.f);
        ASN1Set aSN1Set2 = this.g;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, aSN1Set2));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public static AuthEnvelopedData getInstance(Object obj) {
        if (obj == null || (obj instanceof AuthEnvelopedData)) {
            return (AuthEnvelopedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new AuthEnvelopedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid AuthEnvelopedData: ")));
    }

    public AuthEnvelopedData(ASN1Sequence aSN1Sequence) {
        ASN1Set aSN1Set;
        ASN1Integer aSN1Integer = (ASN1Integer) aSN1Sequence.getObjectAt(0).toASN1Primitive();
        this.a = aSN1Integer;
        if (aSN1Integer.getValue().intValue() == 0) {
            int i = 2;
            ASN1Primitive aSN1Primitive = aSN1Sequence.getObjectAt(1).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                this.b = OriginatorInfo.getInstance((ASN1TaggedObject) aSN1Primitive, false);
                aSN1Primitive = aSN1Sequence.getObjectAt(2).toASN1Primitive();
                i = 3;
            }
            ASN1Set instance = ASN1Set.getInstance(aSN1Primitive);
            this.c = instance;
            if (instance.size() != 0) {
                int i2 = i + 1;
                this.d = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i).toASN1Primitive());
                int i3 = i2 + 1;
                ASN1Primitive aSN1Primitive2 = aSN1Sequence.getObjectAt(i2).toASN1Primitive();
                if (aSN1Primitive2 instanceof ASN1TaggedObject) {
                    this.e = ASN1Set.getInstance((ASN1TaggedObject) aSN1Primitive2, false);
                    aSN1Primitive2 = aSN1Sequence.getObjectAt(i3).toASN1Primitive();
                    i3++;
                } else if (!this.d.getContentType().equals(CMSObjectIdentifiers.data) && ((aSN1Set = this.e) == null || aSN1Set.size() == 0)) {
                    throw new IllegalArgumentException("authAttrs must be present with non-data content");
                }
                this.f = ASN1OctetString.getInstance(aSN1Primitive2);
                if (aSN1Sequence.size() > i3) {
                    this.g = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i3).toASN1Primitive(), false);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
    }
}
