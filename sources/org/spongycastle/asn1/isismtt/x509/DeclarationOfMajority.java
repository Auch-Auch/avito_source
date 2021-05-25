package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Choice;
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
public class DeclarationOfMajority extends ASN1Object implements ASN1Choice {
    public static final int dateOfBirth = 2;
    public static final int fullAgeAtCountry = 1;
    public static final int notYoungerThan = 0;
    public ASN1TaggedObject a;

    public DeclarationOfMajority(int i) {
        this.a = new DERTaggedObject(false, 0, new ASN1Integer((long) i));
    }

    public static DeclarationOfMajority getInstance(Object obj) {
        if (obj == null || (obj instanceof DeclarationOfMajority)) {
            return (DeclarationOfMajority) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new DeclarationOfMajority((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public ASN1Sequence fullAgeAtCountry() {
        if (this.a.getTagNo() != 1) {
            return null;
        }
        return ASN1Sequence.getInstance(this.a, false);
    }

    public ASN1GeneralizedTime getDateOfBirth() {
        if (this.a.getTagNo() != 2) {
            return null;
        }
        return ASN1GeneralizedTime.getInstance(this.a, false);
    }

    public int getType() {
        return this.a.getTagNo();
    }

    public int notYoungerThan() {
        if (this.a.getTagNo() != 0) {
            return -1;
        }
        return ASN1Integer.getInstance(this.a, false).getValue().intValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public DeclarationOfMajority(boolean z, String str) {
        if (str.length() > 2) {
            throw new IllegalArgumentException("country can only be 2 characters");
        } else if (z) {
            this.a = new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(str, true)));
        } else {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(ASN1Boolean.FALSE);
            aSN1EncodableVector.add(new DERPrintableString(str, true));
            this.a = new DERTaggedObject(false, 1, new DERSequence(aSN1EncodableVector));
        }
    }

    public DeclarationOfMajority(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.a = new DERTaggedObject(false, 2, aSN1GeneralizedTime);
    }

    public DeclarationOfMajority(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() <= 2) {
            this.a = aSN1TaggedObject;
            return;
        }
        throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Bad tag number: ")));
    }
}
