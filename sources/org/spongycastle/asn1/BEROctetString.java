package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
public class BEROctetString extends ASN1OctetString {
    public ASN1OctetString[] b;

    public class a implements Enumeration {
        public int a = 0;

        public a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a < BEROctetString.this.b.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            ASN1OctetString[] aSN1OctetStringArr = BEROctetString.this.b;
            int i = this.a;
            this.a = i + 1;
            return aSN1OctetStringArr[i];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BEROctetString(org.spongycastle.asn1.ASN1OctetString[] r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r4.length
            if (r1 == r2) goto L_0x0050
            r2 = r4[r1]     // Catch:{ ClassCastException -> 0x002f, IOException -> 0x0017 }
            org.spongycastle.asn1.DEROctetString r2 = (org.spongycastle.asn1.DEROctetString) r2     // Catch:{ ClassCastException -> 0x002f, IOException -> 0x0017 }
            byte[] r2 = r2.getOctets()     // Catch:{ ClassCastException -> 0x002f, IOException -> 0x0017 }
            r0.write(r2)     // Catch:{ ClassCastException -> 0x002f, IOException -> 0x0017 }
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0017:
            r4 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "exception converting octets "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r4 = r4.toString()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x002f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = r4[r1]
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r4 = " found in input should only contain DEROctetString"
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r0.<init>(r4)
            throw r0
        L_0x0050:
            byte[] r0 = r0.toByteArray()
            r3.<init>(r0)
            r3.b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.BEROctetString.<init>(org.spongycastle.asn1.ASN1OctetString[]):void");
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        Enumeration objects = getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            i += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().a();
        }
        return i + 2 + 2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(36);
        aSN1OutputStream.c(128);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
        }
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }

    public Enumeration getObjects() {
        if (this.b != null) {
            return new a();
        }
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return vector.elements();
            }
            int i2 = i + 1000;
            int length = (i2 > bArr.length ? bArr.length : i2) - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i, bArr2, 0, length);
            vector.addElement(new DEROctetString(bArr2));
            i = i2;
        }
    }

    @Override // org.spongycastle.asn1.ASN1OctetString
    public byte[] getOctets() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }
}
