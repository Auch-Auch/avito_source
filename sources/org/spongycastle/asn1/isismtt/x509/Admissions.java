package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.GeneralName;
public class Admissions extends ASN1Object {
    public GeneralName a;
    public NamingAuthority b;
    public ASN1Sequence c;

    public Admissions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.a = GeneralName.getInstance(aSN1TaggedObject, true);
                } else if (tagNo == 1) {
                    this.b = NamingAuthority.getInstance(aSN1TaggedObject, true);
                } else {
                    throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Bad tag number: ")));
                }
                aSN1Encodable = (ASN1Encodable) objects.nextElement();
            }
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject2 = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject2.getTagNo() == 1) {
                    this.b = NamingAuthority.getInstance(aSN1TaggedObject2, true);
                    aSN1Encodable = (ASN1Encodable) objects.nextElement();
                } else {
                    throw new IllegalArgumentException(a.D(aSN1TaggedObject2, a.L("Bad tag number: ")));
                }
            }
            this.c = ASN1Sequence.getInstance(aSN1Encodable);
            if (objects.hasMoreElements()) {
                StringBuilder L = a.L("Bad object encountered: ");
                L.append(objects.nextElement().getClass());
                throw new IllegalArgumentException(L.toString());
            }
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static Admissions getInstance(Object obj) {
        if (obj == null || (obj instanceof Admissions)) {
            return (Admissions) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Admissions((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public GeneralName getAdmissionAuthority() {
        return this.a;
    }

    public NamingAuthority getNamingAuthority() {
        return this.b;
    }

    public ProfessionInfo[] getProfessionInfos() {
        ProfessionInfo[] professionInfoArr = new ProfessionInfo[this.c.size()];
        Enumeration objects = this.c.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            professionInfoArr[i] = ProfessionInfo.getInstance(objects.nextElement());
            i++;
        }
        return professionInfoArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralName generalName = this.a;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, generalName));
        }
        NamingAuthority namingAuthority = this.b;
        if (namingAuthority != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, namingAuthority));
        }
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public Admissions(GeneralName generalName, NamingAuthority namingAuthority, ProfessionInfo[] professionInfoArr) {
        this.a = generalName;
        this.b = namingAuthority;
        this.c = new DERSequence(professionInfoArr);
    }
}
