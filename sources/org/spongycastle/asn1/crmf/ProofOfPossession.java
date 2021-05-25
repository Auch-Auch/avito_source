package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERTaggedObject;
public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    public int a;
    public ASN1Encodable b;

    public ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.a = tagNo;
        if (tagNo == 0) {
            this.b = DERNull.INSTANCE;
        } else if (tagNo == 1) {
            this.b = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 2 || tagNo == 3) {
            this.b = POPOPrivKey.getInstance(aSN1TaggedObject, true);
        } else {
            StringBuilder L = a.L("unknown tag: ");
            L.append(this.a);
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static ProofOfPossession getInstance(Object obj) {
        if (obj == null || (obj instanceof ProofOfPossession)) {
            return (ProofOfPossession) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new ProofOfPossession((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid object: ")));
    }

    public ASN1Encodable getObject() {
        return this.b;
    }

    public int getType() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.a, this.b);
    }

    public ProofOfPossession() {
        this.a = 0;
        this.b = DERNull.INSTANCE;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.a = 1;
        this.b = pOPOSigningKey;
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.a = i;
        this.b = pOPOPrivKey;
    }
}
