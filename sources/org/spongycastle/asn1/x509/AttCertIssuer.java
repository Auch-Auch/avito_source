package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
public class AttCertIssuer extends ASN1Object implements ASN1Choice {
    public ASN1Encodable a;
    public ASN1Primitive b;

    public AttCertIssuer(GeneralNames generalNames) {
        this.a = generalNames;
        this.b = generalNames.toASN1Primitive();
    }

    public static AttCertIssuer getInstance(Object obj) {
        if (obj == null || (obj instanceof AttCertIssuer)) {
            return (AttCertIssuer) obj;
        }
        if (obj instanceof V2Form) {
            return new AttCertIssuer(V2Form.getInstance(obj));
        }
        if (obj instanceof GeneralNames) {
            return new AttCertIssuer((GeneralNames) obj);
        }
        if (obj instanceof ASN1TaggedObject) {
            return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject) obj, false));
        }
        if (obj instanceof ASN1Sequence) {
            return new AttCertIssuer(GeneralNames.getInstance(obj));
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in factory: ")));
    }

    public ASN1Encodable getIssuer() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.b;
    }

    public AttCertIssuer(V2Form v2Form) {
        this.a = v2Form;
        this.b = new DERTaggedObject(false, 0, v2Form);
    }

    public static AttCertIssuer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }
}
