package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    public ASN1Encodable a;

    public PKIArchiveOptions(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.a = EncryptedKey.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            this.a = ASN1OctetString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 2) {
            this.a = ASN1Boolean.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag number: ")));
        }
    }

    public static PKIArchiveOptions getInstance(Object obj) {
        if (obj == null || (obj instanceof PKIArchiveOptions)) {
            return (PKIArchiveOptions) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new PKIArchiveOptions((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException(a.b3("unknown object: ", obj));
    }

    public int getType() {
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable instanceof EncryptedKey) {
            return 0;
        }
        return aSN1Encodable instanceof ASN1OctetString ? 1 : 2;
    }

    public ASN1Encodable getValue() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable instanceof EncryptedKey) {
            return new DERTaggedObject(true, 0, aSN1Encodable);
        }
        if (aSN1Encodable instanceof ASN1OctetString) {
            return new DERTaggedObject(false, 1, aSN1Encodable);
        }
        return new DERTaggedObject(false, 2, aSN1Encodable);
    }

    public PKIArchiveOptions(EncryptedKey encryptedKey) {
        this.a = encryptedKey;
    }

    public PKIArchiveOptions(ASN1OctetString aSN1OctetString) {
        this.a = aSN1OctetString;
    }

    public PKIArchiveOptions(boolean z) {
        this.a = ASN1Boolean.getInstance(z);
    }
}
