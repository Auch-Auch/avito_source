package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
public class SignedData extends ASN1Object {
    public static final ASN1Integer i = new ASN1Integer(1);
    public static final ASN1Integer j = new ASN1Integer(3);
    public static final ASN1Integer k = new ASN1Integer(4);
    public static final ASN1Integer l = new ASN1Integer(5);
    public ASN1Integer a;
    public ASN1Set b;
    public ContentInfo c;
    public ASN1Set d;
    public ASN1Set e;
    public ASN1Set f;
    public boolean g;
    public boolean h;

    public SignedData(ASN1Set aSN1Set, ContentInfo contentInfo, ASN1Set aSN1Set2, ASN1Set aSN1Set3, ASN1Set aSN1Set4) {
        boolean z;
        boolean z2;
        boolean z3;
        ASN1Integer aSN1Integer;
        boolean z4;
        ASN1ObjectIdentifier contentType = contentInfo.getContentType();
        boolean z5 = true;
        if (aSN1Set2 != null) {
            Enumeration objects = aSN1Set2.getObjects();
            z3 = false;
            z2 = false;
            z = false;
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement instanceof ASN1TaggedObject) {
                    ASN1TaggedObject instance = ASN1TaggedObject.getInstance(nextElement);
                    if (instance.getTagNo() == 1) {
                        z = true;
                    } else if (instance.getTagNo() == 2) {
                        z2 = true;
                    } else if (instance.getTagNo() == 3) {
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
            z2 = false;
            z = false;
        }
        if (z3) {
            aSN1Integer = new ASN1Integer(5);
        } else {
            if (aSN1Set3 != null) {
                Enumeration objects2 = aSN1Set3.getObjects();
                z4 = false;
                while (objects2.hasMoreElements()) {
                    if (objects2.nextElement() instanceof ASN1TaggedObject) {
                        z4 = true;
                    }
                }
            } else {
                z4 = false;
            }
            if (z4) {
                aSN1Integer = l;
            } else if (z2) {
                aSN1Integer = k;
            } else if (z) {
                aSN1Integer = j;
            } else {
                Enumeration objects3 = aSN1Set4.getObjects();
                while (true) {
                    if (objects3.hasMoreElements()) {
                        if (SignerInfo.getInstance(objects3.nextElement()).getVersion().getValue().intValue() == 3) {
                            break;
                        }
                    } else {
                        z5 = false;
                        break;
                    }
                }
                if (z5) {
                    aSN1Integer = j;
                } else if (!CMSObjectIdentifiers.data.equals(contentType)) {
                    aSN1Integer = j;
                } else {
                    aSN1Integer = i;
                }
            }
        }
        this.a = aSN1Integer;
        this.b = aSN1Set;
        this.c = contentInfo;
        this.d = aSN1Set2;
        this.e = aSN1Set3;
        this.f = aSN1Set4;
        this.h = aSN1Set3 instanceof BERSet;
        this.g = aSN1Set2 instanceof BERSet;
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

    public ASN1Set getDigestAlgorithms() {
        return this.b;
    }

    public ContentInfo getEncapContentInfo() {
        return this.c;
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
            if (this.g) {
                aSN1EncodableVector.add(new BERTaggedObject(false, 0, aSN1Set));
            } else {
                aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
            }
        }
        ASN1Set aSN1Set2 = this.e;
        if (aSN1Set2 != null) {
            if (this.h) {
                aSN1EncodableVector.add(new BERTaggedObject(false, 1, aSN1Set2));
            } else {
                aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
            }
        }
        aSN1EncodableVector.add(this.f);
        return new BERSequence(aSN1EncodableVector);
    }

    public SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1Integer.getInstance(objects.nextElement());
        this.b = (ASN1Set) objects.nextElement();
        this.c = ContentInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) objects.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.g = aSN1TaggedObject instanceof BERTaggedObject;
                    this.d = ASN1Set.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 1) {
                    this.h = aSN1TaggedObject instanceof BERTaggedObject;
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
