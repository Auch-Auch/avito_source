package org.spongycastle.asn1;

import java.io.IOException;
public class DERExternalParser implements ASN1Encodable, InMemoryRepresentable {
    public ASN1StreamParser a;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        try {
            return new DERExternal(this.a.c());
        } catch (IllegalArgumentException e) {
            throw new ASN1Exception(e.getMessage(), e);
        }
    }

    public ASN1Encodable readObject() throws IOException {
        return this.a.readObject();
    }

    @Override // org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new ASN1ParsingException("unable to get DER object", e2);
        }
    }
}
