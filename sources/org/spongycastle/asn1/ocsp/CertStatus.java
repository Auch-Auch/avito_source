package org.spongycastle.asn1.ocsp;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERTaggedObject;
public class CertStatus extends ASN1Object implements ASN1Choice {
    public int a;
    public ASN1Encodable b;

    public CertStatus() {
        this.a = 0;
        this.b = DERNull.INSTANCE;
    }

    public static CertStatus getInstance(Object obj) {
        if (obj == null || (obj instanceof CertStatus)) {
            return (CertStatus) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertStatus((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in factory: ")));
    }

    public ASN1Encodable getStatus() {
        return this.b;
    }

    public int getTagNo() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.a, this.b);
    }

    public CertStatus(RevokedInfo revokedInfo) {
        this.a = 1;
        this.b = revokedInfo;
    }

    public static CertStatus getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public CertStatus(int i, ASN1Encodable aSN1Encodable) {
        this.a = i;
        this.b = aSN1Encodable;
    }

    public CertStatus(ASN1TaggedObject aSN1TaggedObject) {
        this.a = aSN1TaggedObject.getTagNo();
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.b = DERNull.INSTANCE;
        } else if (tagNo == 1) {
            this.b = RevokedInfo.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 2) {
            this.b = DERNull.INSTANCE;
        } else {
            throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Unknown tag encountered: ")));
        }
    }
}
