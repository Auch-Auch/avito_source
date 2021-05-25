package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.EnvelopedData;
public class POPOPrivKey extends ASN1Object implements ASN1Choice {
    public static final int agreeMAC = 3;
    public static final int dhMAC = 2;
    public static final int encryptedKey = 4;
    public static final int subsequentMessage = 1;
    public static final int thisMessage = 0;
    public int a;
    public ASN1Encodable b;

    public POPOPrivKey(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.a = tagNo;
        if (tagNo == 0) {
            this.b = DERBitString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 1) {
            this.b = SubsequentMessage.valueOf(ASN1Integer.getInstance(aSN1TaggedObject, false).getValue().intValue());
        } else if (tagNo == 2) {
            this.b = DERBitString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 3) {
            this.b = PKMACValue.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 4) {
            this.b = EnvelopedData.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag in POPOPrivKey");
        }
    }

    public static POPOPrivKey getInstance(Object obj) {
        if (obj instanceof POPOPrivKey) {
            return (POPOPrivKey) obj;
        }
        if (obj != null) {
            return new POPOPrivKey(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getType() {
        return this.a;
    }

    public ASN1Encodable getValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.a, this.b);
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, z));
    }

    public POPOPrivKey(SubsequentMessage subsequentMessage2) {
        this.a = 1;
        this.b = subsequentMessage2;
    }
}
