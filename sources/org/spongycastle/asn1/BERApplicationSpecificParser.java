package org.spongycastle.asn1;

import java.io.IOException;
public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    public final int a;
    public final ASN1StreamParser b;

    public BERApplicationSpecificParser(int i, ASN1StreamParser aSN1StreamParser) {
        this.a = i;
        this.b = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new BERApplicationSpecific(this.a, this.b.c());
    }

    @Override // org.spongycastle.asn1.ASN1ApplicationSpecificParser
    public ASN1Encodable readObject() throws IOException {
        return this.b.readObject();
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
