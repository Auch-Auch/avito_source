package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import x6.e.a.d;
public class DEROctetStringParser implements ASN1OctetStringParser {
    public d a;

    public DEROctetStringParser(d dVar) {
        this.a = dVar;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DEROctetString(this.a.c());
    }

    @Override // org.spongycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(a.A2(e, a.L("IOException converting stream to byte array: ")), e);
        }
    }
}
