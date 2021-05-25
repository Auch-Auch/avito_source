package org.spongycastle.asn1;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import java.io.IOException;
import org.spongycastle.util.Arrays;
import x6.e.a.i;
public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    public final boolean isConstructed;
    public final byte[] octets;
    public final int tag;

    public ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = Arrays.clone(bArr);
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a.A2(e, a.L("Failed to construct object from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance: ")));
        }
    }

    public static int getLengthOfHeader(byte[] bArr) {
        int i = bArr[1] & 255;
        if (i == 128 || i <= 127) {
            return 2;
        }
        int i2 = i & 127;
        if (i2 <= 4) {
            return i2 + 2;
        }
        throw new IllegalStateException(a.M2("DER length more than 4 bytes: ", i2));
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        return i.a(this.octets.length) + i.b(this.tag) + this.octets.length;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        if (this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && Arrays.areEqual(this.octets, aSN1ApplicationSpecific.octets)) {
            return true;
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.octets);
    }

    public ASN1Primitive getObject() throws IOException {
        return ASN1Primitive.fromByteArray(getContents());
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        boolean z = this.isConstructed;
        return ((z ? 1 : 0) ^ this.tag) ^ Arrays.hashCode(this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return this.isConstructed;
    }

    public ASN1Primitive getObject(int i) throws IOException {
        int i2;
        if (i < 31) {
            byte[] encoded = getEncoded();
            if ((encoded[0] & Ascii.US) == 31) {
                i2 = 2;
                int i3 = encoded[1] & 255;
                if ((i3 & 127) != 0) {
                    while (i3 >= 0 && (i3 & 128) != 0) {
                        i3 = encoded[i2] & 255;
                        i2++;
                    }
                } else {
                    throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
                }
            } else {
                i2 = 1;
            }
            int length = (encoded.length - i2) + 1;
            byte[] bArr = new byte[length];
            System.arraycopy(encoded, i2, bArr, 1, length - 1);
            bArr[0] = (byte) i;
            if ((encoded[0] & 32) != 0) {
                bArr[0] = (byte) (bArr[0] | 32);
            }
            return ASN1Primitive.fromByteArray(bArr);
        }
        throw new IOException("unsupported tag number");
    }
}
