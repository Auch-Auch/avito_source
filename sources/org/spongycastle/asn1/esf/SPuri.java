package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERIA5String;
public class SPuri {
    public DERIA5String a;

    public SPuri(DERIA5String dERIA5String) {
        this.a = dERIA5String;
    }

    public static SPuri getInstance(Object obj) {
        if (obj instanceof SPuri) {
            return (SPuri) obj;
        }
        if (obj instanceof DERIA5String) {
            return new SPuri(DERIA5String.getInstance(obj));
        }
        return null;
    }

    public DERIA5String getUri() {
        return this.a;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.a.toASN1Primitive();
    }
}
