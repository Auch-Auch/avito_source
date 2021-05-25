package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
public class DEROutputStream extends ASN1OutputStream {
    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.spongycastle.asn1.ASN1OutputStream
    public ASN1OutputStream a() {
        return this;
    }

    @Override // org.spongycastle.asn1.ASN1OutputStream
    public ASN1OutputStream b() {
        return this;
    }

    @Override // org.spongycastle.asn1.ASN1OutputStream
    public void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().b().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
