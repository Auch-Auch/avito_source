package org.spongycastle.asn1.esf;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x500.DirectoryString;
public class SignerLocation extends ASN1Object {
    public DirectoryString a;
    public DirectoryString b;
    public ASN1Sequence c;

    public SignerLocation(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.a = DirectoryString.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.b = DirectoryString.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 2) {
                if (aSN1TaggedObject.isExplicit()) {
                    this.c = ASN1Sequence.getInstance(aSN1TaggedObject, true);
                } else {
                    this.c = ASN1Sequence.getInstance(aSN1TaggedObject, false);
                }
                ASN1Sequence aSN1Sequence2 = this.c;
                if (aSN1Sequence2 != null && aSN1Sequence2.size() > 6) {
                    throw new IllegalArgumentException("postal address must contain less than 6 strings");
                }
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public static SignerLocation getInstance(Object obj) {
        if (obj == null || (obj instanceof SignerLocation)) {
            return (SignerLocation) obj;
        }
        return new SignerLocation(ASN1Sequence.getInstance(obj));
    }

    public DirectoryString getCountry() {
        return this.a;
    }

    public DERUTF8String getCountryName() {
        if (this.a == null) {
            return null;
        }
        return new DERUTF8String(getCountry().getString());
    }

    public DirectoryString getLocality() {
        return this.b;
    }

    public DERUTF8String getLocalityName() {
        if (this.b == null) {
            return null;
        }
        return new DERUTF8String(getLocality().getString());
    }

    public DirectoryString[] getPostal() {
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        DirectoryString[] directoryStringArr = new DirectoryString[size];
        for (int i = 0; i != size; i++) {
            directoryStringArr[i] = DirectoryString.getInstance(this.c.getObjectAt(i));
        }
        return directoryStringArr;
    }

    public ASN1Sequence getPostalAddress() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DirectoryString directoryString = this.a;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, directoryString));
        }
        DirectoryString directoryString2 = this.b;
        if (directoryString2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, directoryString2));
        }
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, aSN1Sequence));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null || aSN1Sequence.size() <= 6) {
            this.a = directoryString;
            this.b = directoryString2;
            this.c = aSN1Sequence;
            return;
        }
        throw new IllegalArgumentException("postal address must contain less than 6 strings");
    }

    public SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, DirectoryString[] directoryStringArr) {
        this(directoryString, directoryString2, new DERSequence(directoryStringArr));
    }

    public SignerLocation(DERUTF8String dERUTF8String, DERUTF8String dERUTF8String2, ASN1Sequence aSN1Sequence) {
        this(DirectoryString.getInstance(dERUTF8String), DirectoryString.getInstance(dERUTF8String2), aSN1Sequence);
    }
}
