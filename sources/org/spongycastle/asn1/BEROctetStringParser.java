package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;
import x6.e.a.b;
public class BEROctetStringParser implements ASN1OctetStringParser {
    public ASN1StreamParser a;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new BEROctetString(Streams.readAll(getOctetStream()));
    }

    @Override // org.spongycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new b(this.a);
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
