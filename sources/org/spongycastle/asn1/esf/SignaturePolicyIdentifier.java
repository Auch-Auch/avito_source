package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
public class SignaturePolicyIdentifier extends ASN1Object {
    public SignaturePolicyId a;
    public boolean b = true;

    public SignaturePolicyIdentifier() {
    }

    public static SignaturePolicyIdentifier getInstance(Object obj) {
        if (obj instanceof SignaturePolicyIdentifier) {
            return (SignaturePolicyIdentifier) obj;
        }
        if ((obj instanceof ASN1Null) || ASN1Object.hasEncodedTagValue(obj, 5)) {
            return new SignaturePolicyIdentifier();
        }
        if (obj != null) {
            return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(obj));
        }
        return null;
    }

    public SignaturePolicyId getSignaturePolicyId() {
        return this.a;
    }

    public boolean isSignaturePolicyImplied() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.b) {
            return DERNull.INSTANCE;
        }
        return this.a.toASN1Primitive();
    }

    public SignaturePolicyIdentifier(SignaturePolicyId signaturePolicyId) {
        this.a = signaturePolicyId;
    }
}
