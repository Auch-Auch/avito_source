package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
public class BERConstructedOctetString extends BEROctetString {
    public Vector c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BERConstructedOctetString(java.util.Vector r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r4.size()
            if (r1 == r2) goto L_0x0057
            java.lang.Object r2 = r4.elementAt(r1)     // Catch:{ ClassCastException -> 0x0034, IOException -> 0x001c }
            org.spongycastle.asn1.DEROctetString r2 = (org.spongycastle.asn1.DEROctetString) r2     // Catch:{ ClassCastException -> 0x0034, IOException -> 0x001c }
            byte[] r2 = r2.getOctets()     // Catch:{ ClassCastException -> 0x0034, IOException -> 0x001c }
            r0.write(r2)     // Catch:{ ClassCastException -> 0x0034, IOException -> 0x001c }
            int r1 = r1 + 1
            goto L_0x0006
        L_0x001c:
            r4 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "exception converting octets "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r4 = r4.toString()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0034:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Object r4 = r4.elementAt(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r4 = " found in input should only contain DEROctetString"
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r0.<init>(r4)
            throw r0
        L_0x0057:
            byte[] r0 = r0.toByteArray()
            r3.<init>(r0)
            r3.c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.BERConstructedOctetString.<init>(java.util.Vector):void");
    }

    public static BEROctetString fromSequence(ASN1Sequence aSN1Sequence) {
        Vector vector = new Vector();
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            vector.addElement(objects.nextElement());
        }
        return new BERConstructedOctetString(vector);
    }

    @Override // org.spongycastle.asn1.BEROctetString
    public Enumeration getObjects() {
        Vector vector = this.c;
        if (vector != null) {
            return vector.elements();
        }
        Vector vector2 = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return vector2.elements();
            }
            int i2 = i + 1000;
            int length = (i2 > bArr.length ? bArr.length : i2) - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i, bArr2, 0, length);
            vector2.addElement(new DEROctetString(bArr2));
            i = i2;
        }
    }

    @Override // org.spongycastle.asn1.BEROctetString, org.spongycastle.asn1.ASN1OctetString
    public byte[] getOctets() {
        return this.a;
    }

    public BERConstructedOctetString(byte[] bArr) {
        super(bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BERConstructedOctetString(ASN1Primitive aSN1Primitive) {
        super(aSN1Primitive.getEncoded());
        try {
        } catch (IOException unused) {
            throw new IllegalArgumentException("Unable to encode object");
        }
    }

    public BERConstructedOctetString(ASN1Encodable aSN1Encodable) {
        this(aSN1Encodable.toASN1Primitive());
    }
}
