package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
public class BERGenerator extends ASN1Generator {
    public boolean a;
    public boolean b;
    public int c;

    public BERGenerator(OutputStream outputStream) {
        super(outputStream);
        this.a = false;
    }

    public final void a(int i) throws IOException {
        this._out.write(i);
        this._out.write(128);
    }

    @Override // org.spongycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this._out;
    }

    public void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if (this.a && this.b) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    public void writeBERHeader(int i) throws IOException {
        if (this.a) {
            int i2 = this.c | 128;
            if (this.b) {
                a(i2 | 32);
                this._out.write(i);
                this._out.write(128);
            } else if ((i & 32) != 0) {
                a(i2 | 32);
            } else {
                a(i2);
            }
        } else {
            this._out.write(i);
            this._out.write(128);
        }
    }

    public BERGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.a = false;
        this.a = true;
        this.b = z;
        this.c = i;
    }
}
