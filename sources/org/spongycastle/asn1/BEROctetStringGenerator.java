package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
public class BEROctetStringGenerator extends BERGenerator {
    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[1000]);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new a(bArr);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i, boolean z) throws IOException {
        super(outputStream, i, z);
        writeBERHeader(36);
    }

    public class a extends OutputStream {
        public byte[] a;
        public int b = 0;
        public DEROutputStream c;

        public a(byte[] bArr) {
            this.a = bArr;
            this.c = new DEROutputStream(BEROctetStringGenerator.this._out);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i = this.b;
            if (i != 0) {
                byte[] bArr = new byte[i];
                System.arraycopy(this.a, 0, bArr, 0, i);
                this.c.e(4, bArr);
            }
            BEROctetStringGenerator.this.writeBEREnd();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = this.a;
            int i2 = this.b;
            int i3 = i2 + 1;
            this.b = i3;
            bArr[i2] = (byte) i;
            if (i3 == bArr.length) {
                this.c.e(4, bArr);
                this.b = 0;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            while (i2 > 0) {
                int min = Math.min(i2, this.a.length - this.b);
                System.arraycopy(bArr, i, this.a, this.b, min);
                int i3 = this.b + min;
                this.b = i3;
                byte[] bArr2 = this.a;
                if (i3 >= bArr2.length) {
                    this.c.e(4, bArr2);
                    this.b = 0;
                    i += min;
                    i2 -= min;
                } else {
                    return;
                }
            }
        }
    }
}
