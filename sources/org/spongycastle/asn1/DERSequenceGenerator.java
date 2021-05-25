package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class DERSequenceGenerator extends DERGenerator {
    public final ByteArrayOutputStream d = new ByteArrayOutputStream();

    public DERSequenceGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public void addObject(ASN1Encodable aSN1Encodable) throws IOException {
        aSN1Encodable.toASN1Primitive().encode(new DEROutputStream(this.d));
    }

    public void close() throws IOException {
        byte[] byteArray = this.d.toByteArray();
        if (this.a) {
            int i = this.c;
            int i2 = i | 128;
            if (this.b) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a(byteArrayOutputStream, 48, byteArray);
                a(this._out, i | 32 | 128, byteArrayOutputStream.toByteArray());
                return;
            }
            a(this._out, i2 | 32, byteArray);
            return;
        }
        a(this._out, 48, byteArray);
    }

    @Override // org.spongycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this.d;
    }

    public DERSequenceGenerator(OutputStream outputStream, int i, boolean z) throws IOException {
        super(outputStream, i, z);
    }
}
