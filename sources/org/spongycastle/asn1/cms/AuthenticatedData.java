package org.spongycastle.asn1.cms;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
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
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class AuthenticatedData extends ASN1Object {
    public ASN1Integer a;
    public OriginatorInfo b;
    public ASN1Set c;
    public AlgorithmIdentifier d;
    public AlgorithmIdentifier e;
    public ContentInfo f;
    public ASN1Set g;
    public ASN1OctetString h;
    public ASN1Set i;

    public AuthenticatedData(OriginatorInfo originatorInfo, ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ContentInfo contentInfo, ASN1Set aSN1Set2, ASN1OctetString aSN1OctetString, ASN1Set aSN1Set3) {
        if (!(algorithmIdentifier2 == null && aSN1Set2 == null) && (algorithmIdentifier2 == null || aSN1Set2 == null)) {
            throw new IllegalArgumentException("digestAlgorithm and authAttrs must be set together");
        }
        this.a = new ASN1Integer((long) calculateVersion(originatorInfo));
        this.b = originatorInfo;
        this.d = algorithmIdentifier;
        this.e = algorithmIdentifier2;
        this.c = aSN1Set;
        this.f = contentInfo;
        this.g = aSN1Set2;
        this.h = aSN1OctetString;
        this.i = aSN1Set3;
    }

    public static int calculateVersion(OriginatorInfo originatorInfo) {
        int i2 = 0;
        if (originatorInfo == null) {
            return 0;
        }
        Enumeration objects = originatorInfo.getCertificates().getObjects();
        while (true) {
            if (!objects.hasMoreElements()) {
                break;
            }
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) nextElement;
                if (aSN1TaggedObject.getTagNo() == 2) {
                    i2 = 1;
                } else if (aSN1TaggedObject.getTagNo() == 3) {
                    i2 = 3;
                    break;
                }
            }
        }
        if (originatorInfo.getCRLs() != null) {
            Enumeration objects2 = originatorInfo.getCRLs().getObjects();
            while (objects2.hasMoreElements()) {
                Object nextElement2 = objects2.nextElement();
                if ((nextElement2 instanceof ASN1TaggedObject) && ((ASN1TaggedObject) nextElement2).getTagNo() == 1) {
                    return 3;
                }
            }
        }
        return i2;
    }

    public static AuthenticatedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Set getAuthAttrs() {
        return this.g;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.e;
    }

    public ContentInfo getEncapsulatedContentInfo() {
        return this.f;
    }

    public ASN1OctetString getMac() {
        return this.h;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.d;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.b;
    }

    public ASN1Set getRecipientInfos() {
        return this.c;
    }

    public ASN1Set getUnauthAttrs() {
        return this.i;
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
        AlgorithmIdentifier algorithmIdentifier = this.e;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, algorithmIdentifier));
        }
        aSN1EncodableVector.add(this.f);
        ASN1Set aSN1Set = this.g;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, aSN1Set));
        }
        aSN1EncodableVector.add(this.h);
        ASN1Set aSN1Set2 = this.i;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, aSN1Set2));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public static AuthenticatedData getInstance(Object obj) {
        if (obj instanceof AuthenticatedData) {
            return (AuthenticatedData) obj;
        }
        if (obj != null) {
            return new AuthenticatedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AuthenticatedData(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
        int i2 = 2;
        if (objectAt instanceof ASN1TaggedObject) {
            this.b = OriginatorInfo.getInstance((ASN1TaggedObject) objectAt, false);
            objectAt = aSN1Sequence.getObjectAt(2);
            i2 = 3;
        }
        this.c = ASN1Set.getInstance(objectAt);
        int i3 = i2 + 1;
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i3);
        if (objectAt2 instanceof ASN1TaggedObject) {
            this.e = AlgorithmIdentifier.getInstance((ASN1TaggedObject) objectAt2, false);
            int i5 = i4 + 1;
            ASN1Encodable objectAt3 = aSN1Sequence.getObjectAt(i4);
            i4 = i5;
            objectAt2 = objectAt3;
        }
        this.f = ContentInfo.getInstance(objectAt2);
        int i6 = i4 + 1;
        ASN1Encodable objectAt4 = aSN1Sequence.getObjectAt(i4);
        if (objectAt4 instanceof ASN1TaggedObject) {
            this.g = ASN1Set.getInstance((ASN1TaggedObject) objectAt4, false);
            objectAt4 = aSN1Sequence.getObjectAt(i6);
            i6++;
        }
        this.h = ASN1OctetString.getInstance(objectAt4);
        if (aSN1Sequence.size() > i6) {
            this.i = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i6), false);
        }
    }
}
