package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    public int a;
    public boolean b = true;
    public ASN1Encodable c = null;

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof ASN1Choice) {
            this.b = true;
        } else {
            this.b = z;
        }
        this.a = i;
        if (this.b) {
            this.c = aSN1Encodable;
            return;
        }
        boolean z2 = aSN1Encodable.toASN1Primitive() instanceof ASN1Set;
        this.c = aSN1Encodable;
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return (ASN1TaggedObject) aSN1TaggedObject.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.a != aSN1TaggedObject.a || this.b != aSN1TaggedObject.b) {
            return false;
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable == null) {
            if (aSN1TaggedObject.c != null) {
                return false;
            }
            return true;
        } else if (!aSN1Encodable.toASN1Primitive().equals(aSN1TaggedObject.c.toASN1Primitive())) {
            return false;
        } else {
            return true;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive b() {
        return new DERTaggedObject(this.b, this.a, this.c);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive c() {
        return new DLTaggedObject(this.b, this.a, this.c);
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public ASN1Primitive getObject() {
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable != null) {
            return aSN1Encodable.toASN1Primitive();
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable getObjectParser(int i, boolean z) throws IOException {
        if (i == 4) {
            return ASN1OctetString.getInstance(this, z).parser();
        }
        if (i == 16) {
            return ASN1Sequence.getInstance(this, z).parser();
        }
        if (i == 17) {
            return ASN1Set.getInstance(this, z).parser();
        }
        if (z) {
            return getObject();
        }
        throw new ASN1Exception(a.M2("implicit tagging not implemented for tag: ", i));
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        int i = this.a;
        ASN1Encodable aSN1Encodable = this.c;
        return aSN1Encodable != null ? i ^ aSN1Encodable.hashCode() : i;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isExplicit() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("[");
        L.append(this.a);
        L.append("]");
        L.append(this.c);
        return L.toString();
    }

    public static ASN1TaggedObject getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a.A2(e, a.L("failed to construct tagged object from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance: ")));
        }
    }
}
