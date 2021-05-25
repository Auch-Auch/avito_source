package org.spongycastle.asn1.x500;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERUniversalString;
public class DirectoryString extends ASN1Object implements ASN1Choice, ASN1String {
    public ASN1String a;

    public DirectoryString(DERT61String dERT61String) {
        this.a = dERT61String;
    }

    public static DirectoryString getInstance(Object obj) {
        if (obj == null || (obj instanceof DirectoryString)) {
            return (DirectoryString) obj;
        }
        if (obj instanceof DERT61String) {
            return new DirectoryString((DERT61String) obj);
        }
        if (obj instanceof DERPrintableString) {
            return new DirectoryString((DERPrintableString) obj);
        }
        if (obj instanceof DERUniversalString) {
            return new DirectoryString((DERUniversalString) obj);
        }
        if (obj instanceof DERUTF8String) {
            return new DirectoryString((DERUTF8String) obj);
        }
        if (obj instanceof DERBMPString) {
            return new DirectoryString((DERBMPString) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return this.a.getString();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ((ASN1Encodable) this.a).toASN1Primitive();
    }

    public String toString() {
        return this.a.getString();
    }

    public DirectoryString(DERPrintableString dERPrintableString) {
        this.a = dERPrintableString;
    }

    public DirectoryString(DERUniversalString dERUniversalString) {
        this.a = dERUniversalString;
    }

    public DirectoryString(DERUTF8String dERUTF8String) {
        this.a = dERUTF8String;
    }

    public DirectoryString(DERBMPString dERBMPString) {
        this.a = dERBMPString;
    }

    public DirectoryString(String str) {
        this.a = new DERUTF8String(str);
    }

    public static DirectoryString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }
}
