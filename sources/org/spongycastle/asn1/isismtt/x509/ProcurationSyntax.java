package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.DirectoryString;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.IssuerSerial;
public class ProcurationSyntax extends ASN1Object {
    public String a;
    public DirectoryString b;
    public GeneralName c;
    public IssuerSerial d;

    public ProcurationSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 1) {
                this.a = DERPrintableString.getInstance(instance, true).getString();
            } else if (tagNo == 2) {
                this.b = DirectoryString.getInstance(instance, true);
            } else if (tagNo == 3) {
                ASN1Primitive object = instance.getObject();
                if (object instanceof ASN1TaggedObject) {
                    this.c = GeneralName.getInstance(object);
                } else {
                    this.d = IssuerSerial.getInstance(object);
                }
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("Bad tag number: ")));
            }
        }
    }

    public static ProcurationSyntax getInstance(Object obj) {
        if (obj == null || (obj instanceof ProcurationSyntax)) {
            return (ProcurationSyntax) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProcurationSyntax((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public IssuerSerial getCertRef() {
        return this.d;
    }

    public String getCountry() {
        return this.a;
    }

    public GeneralName getThirdPerson() {
        return this.c;
    }

    public DirectoryString getTypeOfSubstitution() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        String str = this.a;
        if (str != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, new DERPrintableString(str, true)));
        }
        DirectoryString directoryString = this.b;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, directoryString));
        }
        GeneralName generalName = this.c;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, generalName));
        } else {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, this.d));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ProcurationSyntax(String str, DirectoryString directoryString, IssuerSerial issuerSerial) {
        this.a = str;
        this.b = directoryString;
        this.c = null;
        this.d = issuerSerial;
    }

    public ProcurationSyntax(String str, DirectoryString directoryString, GeneralName generalName) {
        this.a = str;
        this.b = directoryString;
        this.c = generalName;
        this.d = null;
    }
}
