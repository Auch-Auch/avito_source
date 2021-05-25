package org.spongycastle.asn1.cmp;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
public class PKIConfirmContent extends ASN1Object {
    public ASN1Null a;

    public PKIConfirmContent(ASN1Null aSN1Null) {
        this.a = aSN1Null;
    }

    public static PKIConfirmContent getInstance(Object obj) {
        if (obj == null || (obj instanceof PKIConfirmContent)) {
            return (PKIConfirmContent) obj;
        }
        if (obj instanceof ASN1Null) {
            return new PKIConfirmContent((ASN1Null) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid object: ")));
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public PKIConfirmContent() {
        this.a = DERNull.INSTANCE;
    }
}
