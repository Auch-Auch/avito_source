package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
public class ASN1OutputStream {
    public OutputStream a;

    public class a extends ASN1OutputStream {
        public boolean b = true;

        public a(ASN1OutputStream aSN1OutputStream, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // org.spongycastle.asn1.ASN1OutputStream
        public void c(int i) throws IOException {
            if (this.b) {
                this.b = false;
            } else {
                this.a.write(i);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.a = outputStream;
    }

    public ASN1OutputStream a() {
        return new DEROutputStream(this.a);
    }

    public ASN1OutputStream b() {
        return new DLOutputStream(this.a);
    }

    public void c(int i) throws IOException {
        this.a.write(i);
    }

    public void close() throws IOException {
        this.a.close();
    }

    public void d(int i, int i2, byte[] bArr) throws IOException {
        h(i, i2);
        g(bArr.length);
        this.a.write(bArr);
    }

    public void e(int i, byte[] bArr) throws IOException {
        c(i);
        g(bArr.length);
        this.a.write(bArr);
    }

    public void f(ASN1Primitive aSN1Primitive) throws IOException {
        aSN1Primitive.encode(new a(this, this.a));
    }

    public void flush() throws IOException {
        this.a.flush();
    }

    public void g(int i) throws IOException {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            c((byte) (i3 | 128));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                c((byte) (i >> i4));
            }
            return;
        }
        c((byte) i);
    }

    public void h(int i, int i2) throws IOException {
        if (i2 < 31) {
            c(i | i2);
            return;
        }
        c(i | 31);
        if (i2 < 128) {
            c(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 4;
        bArr[4] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            i3--;
            bArr[i3] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        this.a.write(bArr, i3, 5 - i3);
    }

    public void writeNull() throws IOException {
        this.a.write(5);
        this.a.write(0);
    }

    public void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
