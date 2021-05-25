package org.spongycastle.asn1.est;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.Attribute;
public class AttrOrOID extends ASN1Object implements ASN1Choice {
    public final ASN1ObjectIdentifier a;
    public final Attribute b;

    public AttrOrOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.a = aSN1ObjectIdentifier;
        this.b = null;
    }

    public static AttrOrOID getInstance(Object obj) {
        if (obj instanceof AttrOrOID) {
            return (AttrOrOID) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return new AttrOrOID(ASN1ObjectIdentifier.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new AttrOrOID(Attribute.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
        }
    }

    public Attribute getAttribute() {
        return this.b;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.a;
    }

    public boolean isOid() {
        return this.a != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.a;
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        return this.b.toASN1Primitive();
    }

    public AttrOrOID(Attribute attribute) {
        this.a = null;
        this.b = attribute;
    }
}
