package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class EncryptedContentInfoParser {
    public ASN1ObjectIdentifier a;
    public AlgorithmIdentifier b;
    public ASN1TaggedObjectParser c;

    public EncryptedContentInfoParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = (ASN1ObjectIdentifier) aSN1SequenceParser.readObject();
        this.b = AlgorithmIdentifier.getInstance(aSN1SequenceParser.readObject().toASN1Primitive());
        this.c = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.b;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.a;
    }

    public ASN1Encodable getEncryptedContent(int i) throws IOException {
        return this.c.getObjectParser(i, false);
    }
}
