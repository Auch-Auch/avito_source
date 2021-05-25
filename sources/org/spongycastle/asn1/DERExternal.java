package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class DERExternal extends ASN1Primitive {
    public ASN1ObjectIdentifier a;
    public ASN1Integer b;
    public ASN1Primitive c;
    public int d;
    public ASN1Primitive e;

    public DERExternal(ASN1EncodableVector aSN1EncodableVector) {
        int i = 0;
        ASN1Primitive d2 = d(aSN1EncodableVector, 0);
        if (d2 instanceof ASN1ObjectIdentifier) {
            this.a = (ASN1ObjectIdentifier) d2;
            d2 = d(aSN1EncodableVector, 1);
            i = 1;
        }
        if (d2 instanceof ASN1Integer) {
            this.b = (ASN1Integer) d2;
            i++;
            d2 = d(aSN1EncodableVector, i);
        }
        if (!(d2 instanceof ASN1TaggedObject)) {
            this.c = d2;
            i++;
            d2 = d(aSN1EncodableVector, i);
        }
        if (aSN1EncodableVector.size() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (d2 instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) d2;
            e(aSN1TaggedObject.getTagNo());
            this.e = aSN1TaggedObject.getObject();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        return getEncoded().length;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        ASN1Primitive aSN1Primitive2;
        ASN1Integer aSN1Integer;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (!(aSN1Primitive instanceof DERExternal)) {
            return false;
        }
        if (this == aSN1Primitive) {
            return true;
        }
        DERExternal dERExternal = (DERExternal) aSN1Primitive;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.a;
        if (aSN1ObjectIdentifier2 != null && ((aSN1ObjectIdentifier = dERExternal.a) == null || !aSN1ObjectIdentifier.equals(aSN1ObjectIdentifier2))) {
            return false;
        }
        ASN1Integer aSN1Integer2 = this.b;
        if (aSN1Integer2 != null && ((aSN1Integer = dERExternal.b) == null || !aSN1Integer.equals(aSN1Integer2))) {
            return false;
        }
        ASN1Primitive aSN1Primitive3 = this.c;
        if (aSN1Primitive3 == null || ((aSN1Primitive2 = dERExternal.c) != null && aSN1Primitive2.equals(aSN1Primitive3))) {
            return this.e.equals(dERExternal.e);
        }
        return false;
    }

    public final ASN1Primitive d(ASN1EncodableVector aSN1EncodableVector, int i) {
        if (aSN1EncodableVector.size() > i) {
            return aSN1EncodableVector.get(i).toASN1Primitive();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    public final void e(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(a.M2("invalid encoding value: ", i));
        }
        this.d = i;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.a;
        if (aSN1ObjectIdentifier != null) {
            byteArrayOutputStream.write(aSN1ObjectIdentifier.getEncoded(ASN1Encoding.DER));
        }
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null) {
            byteArrayOutputStream.write(aSN1Integer.getEncoded(ASN1Encoding.DER));
        }
        ASN1Primitive aSN1Primitive = this.c;
        if (aSN1Primitive != null) {
            byteArrayOutputStream.write(aSN1Primitive.getEncoded(ASN1Encoding.DER));
        }
        byteArrayOutputStream.write(new DERTaggedObject(true, this.d, this.e).getEncoded(ASN1Encoding.DER));
        aSN1OutputStream.d(32, 8, byteArrayOutputStream.toByteArray());
    }

    public ASN1Primitive getDataValueDescriptor() {
        return this.c;
    }

    public ASN1ObjectIdentifier getDirectReference() {
        return this.a;
    }

    public int getEncoding() {
        return this.d;
    }

    public ASN1Primitive getExternalContent() {
        return this.e;
    }

    public ASN1Integer getIndirectReference() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.a;
        int hashCode = aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier.hashCode() : 0;
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null) {
            hashCode ^= aSN1Integer.hashCode();
        }
        ASN1Primitive aSN1Primitive = this.c;
        if (aSN1Primitive != null) {
            hashCode ^= aSN1Primitive.hashCode();
        }
        return hashCode ^ this.e.hashCode();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public DERExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, DERTaggedObject dERTaggedObject) {
        this(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, dERTaggedObject.getTagNo(), dERTaggedObject.toASN1Primitive());
    }

    public DERExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int i, ASN1Primitive aSN1Primitive2) {
        this.a = aSN1ObjectIdentifier;
        this.b = aSN1Integer;
        this.c = aSN1Primitive;
        e(i);
        this.e = aSN1Primitive2.toASN1Primitive();
    }
}
