package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Objects;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import x6.e.a.i;
public class DERIA5String extends ASN1Primitive implements ASN1String {
    public final byte[] a;

    public DERIA5String(byte[] bArr) {
        this.a = bArr;
    }

    public static DERIA5String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERIA5String)) {
            return (DERIA5String) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERIA5String) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(a.G2(e, a.L("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
        }
    }

    public static boolean isIA5String(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() {
        return i.a(this.a.length) + 1 + this.a.length;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERIA5String)) {
            return false;
        }
        return Arrays.areEqual(this.a, ((DERIA5String) aSN1Primitive).a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.e(22, this.a);
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

    public String toString() {
        return getString();
    }

    public DERIA5String(String str) {
        this(str, false);
    }

    public DERIA5String(String str, boolean z) {
        Objects.requireNonNull(str, "string cannot be null");
        if (!z || isIA5String(str)) {
            this.a = Strings.toByteArray(str);
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public static DERIA5String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERIA5String)) {
            return getInstance(object);
        }
        return new DERIA5String(((ASN1OctetString) object).getOctets());
    }
}
