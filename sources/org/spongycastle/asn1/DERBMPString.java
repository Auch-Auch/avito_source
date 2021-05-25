package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.util.Arrays;
import x6.e.a.i;
public class DERBMPString extends ASN1Primitive implements ASN1String {
    public final char[] a;

    public DERBMPString(byte[] bArr) {
        int length = bArr.length / 2;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            cArr[i] = (char) ((bArr[i2 + 1] & 255) | (bArr[i2] << 8));
        }
        this.a = cArr;
    }

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERBMPString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(a.G2(e, a.L("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() {
        return (this.a.length * 2) + i.a(this.a.length * 2) + 1;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        return Arrays.areEqual(this.a, ((DERBMPString) aSN1Primitive).a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(30);
        aSN1OutputStream.g(this.a.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.a;
            if (i != cArr.length) {
                char c = cArr[i];
                aSN1OutputStream.c((byte) (c >> '\b'));
                aSN1OutputStream.c((byte) c);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return new String(this.a);
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

    public DERBMPString(char[] cArr) {
        this.a = cArr;
    }

    public DERBMPString(String str) {
        this.a = str.toCharArray();
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERBMPString)) {
            return getInstance(object);
        }
        return new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
    }
}
