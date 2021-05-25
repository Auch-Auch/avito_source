package org.spongycastle.asn1.x9;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
public class X962Parameters extends ASN1Object implements ASN1Choice {
    public ASN1Primitive a = null;

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.a = x9ECParameters.toASN1Primitive();
    }

    public static X962Parameters getInstance(Object obj) {
        if (obj == null || (obj instanceof X962Parameters)) {
            return (X962Parameters) obj;
        }
        if (obj instanceof ASN1Primitive) {
            return new X962Parameters((ASN1Primitive) obj);
        }
        if (obj instanceof byte[]) {
            try {
                return new X962Parameters(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (Exception e) {
                throw new IllegalArgumentException(a.F2(e, a.L("unable to parse encoded data: ")));
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
    }

    public ASN1Primitive getParameters() {
        return this.a;
    }

    public boolean isImplicitlyCA() {
        return this.a instanceof ASN1Null;
    }

    public boolean isNamedCurve() {
        return this.a instanceof ASN1ObjectIdentifier;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public X962Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.a = aSN1ObjectIdentifier;
    }

    public X962Parameters(ASN1Null aSN1Null) {
        this.a = aSN1Null;
    }

    public static X962Parameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public X962Parameters(ASN1Primitive aSN1Primitive) {
        this.a = aSN1Primitive;
    }
}
