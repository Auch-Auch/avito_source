package org.spongycastle.asn1.pkcs;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    public ASN1Integer a;
    public ASN1Set b;
    public ContentInfo c;
    public ASN1Set d;
    public ASN1Set e;
    public ASN1Set f;

    public SignedData(ASN1Integer aSN1Integer, ASN1Set aSN1Set, ContentInfo contentInfo, ASN1Set aSN1Set2, ASN1Set aSN1Set3, ASN1Set aSN1Set4) {
        this.a = aSN1Integer;
        this.b = aSN1Set;
        this.c = contentInfo;
        this.d = aSN1Set2;
        this.e = aSN1Set3;
        this.f = aSN1Set4;
    }

    public static SignedData getInstance(Object obj) {
        if (obj instanceof SignedData) {
            return (SignedData) obj;
        }
        if (obj != null) {
            return new SignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Set getCRLs() {
        return this.e;
    }

    public ASN1Set getCertificates() {
        return this.d;
    }

    public ContentInfo getContentInfo() {
        return this.c;
    }

    public ASN1Set getDigestAlgorithms() {
        return this.b;
    }

    public ASN1Set getSignerInfos() {
        return this.f;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1Set aSN1Set = this.d;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        ASN1Set aSN1Set2 = this.e;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
        }
        aSN1EncodableVector.add(this.f);
        return new BERSequence(aSN1EncodableVector);
    }

    public SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = (ASN1Integer) objects.nextElement();
        this.b = (ASN1Set) objects.nextElement();
        this.c = ContentInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) objects.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.d = ASN1Set.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 1) {
                    this.e = ASN1Set.getInstance(aSN1TaggedObject, false);
                } else {
                    throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag value ")));
                }
            } else {
                this.f = (ASN1Set) aSN1Primitive;
            }
        }
    }
}
