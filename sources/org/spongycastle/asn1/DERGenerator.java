package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
public abstract class DERGenerator extends ASN1Generator {
    public boolean a;
    public boolean b;
    public int c;

    public DERGenerator(OutputStream outputStream) {
        super(outputStream);
        this.a = false;
    }

    public void a(OutputStream outputStream, int i, byte[] bArr) throws IOException {
        outputStream.write(i);
        int length = bArr.length;
        if (length > 127) {
            int i2 = length;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            outputStream.write((byte) (i3 | 128));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                outputStream.write((byte) (length >> i4));
            }
        } else {
            outputStream.write((byte) length);
        }
        outputStream.write(bArr);
    }

    public DERGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.a = false;
        this.a = true;
        this.b = z;
        this.c = i;
    }
}
