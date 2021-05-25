package org.spongycastle.asn1.x509.sigi;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.DirectoryString;
public class PersonalData extends ASN1Object {
    public NameOrPseudonym a;
    public BigInteger b;
    public ASN1GeneralizedTime c;
    public DirectoryString d;
    public String e;
    public DirectoryString f;

    public PersonalData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.a = NameOrPseudonym.getInstance(objects.nextElement());
            while (objects.hasMoreElements()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.b = ASN1Integer.getInstance(instance, false).getValue();
                } else if (tagNo == 1) {
                    this.c = ASN1GeneralizedTime.getInstance(instance, false);
                } else if (tagNo == 2) {
                    this.d = DirectoryString.getInstance(instance, true);
                } else if (tagNo == 3) {
                    this.e = DERPrintableString.getInstance(instance, false).getString();
                } else if (tagNo == 4) {
                    this.f = DirectoryString.getInstance(instance, true);
                } else {
                    throw new IllegalArgumentException(a.D(instance, a.L("Bad tag number: ")));
                }
            }
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static PersonalData getInstance(Object obj) {
        if (obj == null || (obj instanceof PersonalData)) {
            return (PersonalData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PersonalData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public ASN1GeneralizedTime getDateOfBirth() {
        return this.c;
    }

    public String getGender() {
        return this.e;
    }

    public BigInteger getNameDistinguisher() {
        return this.b;
    }

    public NameOrPseudonym getNameOrPseudonym() {
        return this.a;
    }

    public DirectoryString getPlaceOfBirth() {
        return this.d;
    }

    public DirectoryString getPostalAddress() {
        return this.f;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        BigInteger bigInteger = this.b;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new ASN1Integer(bigInteger)));
        }
        ASN1GeneralizedTime aSN1GeneralizedTime = this.c;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1GeneralizedTime));
        }
        DirectoryString directoryString = this.d;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, directoryString));
        }
        String str = this.e;
        if (str != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, new DERPrintableString(str, true)));
        }
        DirectoryString directoryString2 = this.f;
        if (directoryString2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 4, directoryString2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PersonalData(NameOrPseudonym nameOrPseudonym, BigInteger bigInteger, ASN1GeneralizedTime aSN1GeneralizedTime, DirectoryString directoryString, String str, DirectoryString directoryString2) {
        this.a = nameOrPseudonym;
        this.c = aSN1GeneralizedTime;
        this.e = str;
        this.b = bigInteger;
        this.f = directoryString2;
        this.d = directoryString;
    }
}
