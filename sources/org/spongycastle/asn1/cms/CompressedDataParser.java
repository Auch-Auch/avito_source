package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class CompressedDataParser {
    public ASN1Integer a;
    public AlgorithmIdentifier b;
    public ContentInfoParser c;

    public CompressedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = (ASN1Integer) aSN1SequenceParser.readObject();
        this.b = AlgorithmIdentifier.getInstance(aSN1SequenceParser.readObject().toASN1Primitive());
        this.c = new ContentInfoParser((ASN1SequenceParser) aSN1SequenceParser.readObject());
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this.b;
    }

    public ContentInfoParser getEncapContentInfo() {
        return this.c;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }
}
