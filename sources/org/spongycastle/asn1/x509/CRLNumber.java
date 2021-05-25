package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
public class CRLNumber extends ASN1Object {
    public BigInteger a;

    public CRLNumber(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public static CRLNumber getInstance(Object obj) {
        if (obj instanceof CRLNumber) {
            return (CRLNumber) obj;
        }
        if (obj != null) {
            return new CRLNumber(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    public BigInteger getCRLNumber() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.a);
    }

    public String toString() {
        StringBuilder L = a.L("CRLNumber: ");
        L.append(getCRLNumber());
        return L.toString();
    }
}
