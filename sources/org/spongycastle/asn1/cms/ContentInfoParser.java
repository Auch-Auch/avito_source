package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
public class ContentInfoParser {
    public ASN1ObjectIdentifier a;
    public ASN1TaggedObjectParser b;

    public ContentInfoParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = (ASN1ObjectIdentifier) aSN1SequenceParser.readObject();
        this.b = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public ASN1Encodable getContent(int i) throws IOException {
        ASN1TaggedObjectParser aSN1TaggedObjectParser = this.b;
        if (aSN1TaggedObjectParser != null) {
            return aSN1TaggedObjectParser.getObjectParser(i, true);
        }
        return null;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.a;
    }
}
