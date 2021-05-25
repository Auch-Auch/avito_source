package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import x6.e.a.i;
public class DERGraphicString extends ASN1Primitive implements ASN1String {
    public final byte[] a;

    public DERGraphicString(byte[] bArr) {
        this.a = Arrays.clone(bArr);
    }

    public static DERGraphicString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGraphicString)) {
            return (DERGraphicString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERGraphicString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(a.G2(e, a.L("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() {
        return i.a(this.a.length) + 1 + this.a.length;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERGraphicString)) {
            return false;
        }
        return Arrays.areEqual(this.a, ((DERGraphicString) aSN1Primitive).a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.e(25, this.a);
    }

    public byte[] getOctets() {
        return Arrays.clone(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return Strings.fromByteArray(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public static DERGraphicString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERGraphicString)) {
            return getInstance(object);
        }
        return new DERGraphicString(((ASN1OctetString) object).getOctets());
    }
}
