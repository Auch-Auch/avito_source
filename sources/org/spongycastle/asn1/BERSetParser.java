package org.spongycastle.asn1;

import java.io.IOException;
public class BERSetParser implements ASN1SetParser {
    public ASN1StreamParser a;

    public BERSetParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new BERSet(this.a.c());
    }

    @Override // org.spongycastle.asn1.ASN1SetParser
    public ASN1Encodable readObject() throws IOException {
        return this.a.readObject();
    }

    @Override // org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
