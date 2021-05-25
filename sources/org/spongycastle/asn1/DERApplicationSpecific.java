package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.encoders.Hex;
public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    public DERApplicationSpecific(int i, byte[] bArr) {
        super(false, i, bArr);
    }

    @Override // org.spongycastle.asn1.ASN1ApplicationSpecific, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (isConstructed()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(getApplicationTag()));
        stringBuffer.append("]");
        if (this.octets != null) {
            stringBuffer.append(" #");
            stringBuffer.append(Hex.toHexString(this.octets));
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public DERApplicationSpecific(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    public DERApplicationSpecific(int i, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i, aSN1Encodable);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DERApplicationSpecific(boolean r5, int r6, org.spongycastle.asn1.ASN1Encodable r7) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0010
            org.spongycastle.asn1.ASN1Primitive r1 = r7.toASN1Primitive()
            boolean r1 = r1.isConstructed()
            if (r1 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r1 = 0
            goto L_0x0011
        L_0x0010:
            r1 = 1
        L_0x0011:
            org.spongycastle.asn1.ASN1Primitive r7 = r7.toASN1Primitive()
            java.lang.String r2 = "DER"
            byte[] r7 = r7.getEncoded(r2)
            if (r5 == 0) goto L_0x001e
            goto L_0x002a
        L_0x001e:
            int r5 = org.spongycastle.asn1.ASN1ApplicationSpecific.getLengthOfHeader(r7)
            int r2 = r7.length
            int r2 = r2 - r5
            byte[] r3 = new byte[r2]
            java.lang.System.arraycopy(r7, r5, r3, r0, r2)
            r7 = r3
        L_0x002a:
            r4.<init>(r1, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERApplicationSpecific.<init>(boolean, int, org.spongycastle.asn1.ASN1Encodable):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DERApplicationSpecific(int r5, org.spongycastle.asn1.ASN1EncodableVector r6) {
        /*
            r4 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r6.size()
            if (r1 == r2) goto L_0x002b
            org.spongycastle.asn1.ASN1Encodable r2 = r6.get(r1)     // Catch:{ IOException -> 0x001e }
            org.spongycastle.asn1.ASN1Object r2 = (org.spongycastle.asn1.ASN1Object) r2     // Catch:{ IOException -> 0x001e }
            java.lang.String r3 = "DER"
            byte[] r2 = r2.getEncoded(r3)     // Catch:{ IOException -> 0x001e }
            r0.write(r2)     // Catch:{ IOException -> 0x001e }
            int r1 = r1 + 1
            goto L_0x0006
        L_0x001e:
            r5 = move-exception
            org.spongycastle.asn1.ASN1ParsingException r6 = new org.spongycastle.asn1.ASN1ParsingException
            java.lang.String r0 = "malformed object: "
            java.lang.String r0 = a2.b.a.a.a.Z2(r0, r5)
            r6.<init>(r0, r5)
            throw r6
        L_0x002b:
            byte[] r6 = r0.toByteArray()
            r0 = 1
            r4.<init>(r0, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERApplicationSpecific.<init>(int, org.spongycastle.asn1.ASN1EncodableVector):void");
    }
}
