package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class AuthenticatedDataParser {
    public ASN1SequenceParser a;
    public ASN1Integer b;
    public ASN1Encodable c;
    public boolean d;

    public AuthenticatedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = aSN1SequenceParser;
        this.b = ASN1Integer.getInstance(aSN1SequenceParser.readObject());
    }

    public ASN1SetParser getAuthAttrs() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (!(aSN1Encodable instanceof ASN1TaggedObjectParser)) {
            return null;
        }
        this.c = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) aSN1Encodable).getObjectParser(17, false);
    }

    public AlgorithmIdentifier getDigestAlgorithm() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (!(aSN1Encodable instanceof ASN1TaggedObjectParser)) {
            return null;
        }
        AlgorithmIdentifier instance = AlgorithmIdentifier.getInstance((ASN1TaggedObject) aSN1Encodable.toASN1Primitive(), false);
        this.c = null;
        return instance;
    }

    public ContentInfoParser getEnapsulatedContentInfo() throws IOException {
        return getEncapsulatedContentInfo();
    }

    public ContentInfoParser getEncapsulatedContentInfo() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable == null) {
            return null;
        }
        this.c = null;
        return new ContentInfoParser((ASN1SequenceParser) aSN1Encodable);
    }

    public ASN1OctetString getMac() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        this.c = null;
        return ASN1OctetString.getInstance(aSN1Encodable.toASN1Primitive());
    }

    public AlgorithmIdentifier getMacAlgorithm() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable == null) {
            return null;
        }
        this.c = null;
        return AlgorithmIdentifier.getInstance(((ASN1SequenceParser) aSN1Encodable).toASN1Primitive());
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this.d = true;
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (!(aSN1Encodable instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) aSN1Encodable).getTagNo() != 0) {
            return null;
        }
        this.c = null;
        return OriginatorInfo.getInstance(((ASN1SequenceParser) ((ASN1TaggedObjectParser) this.c).getObjectParser(16, false)).toASN1Primitive());
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if (!this.d) {
            getOriginatorInfo();
        }
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1SetParser aSN1SetParser = (ASN1SetParser) this.c;
        this.c = null;
        return aSN1SetParser;
    }

    public ASN1SetParser getUnauthAttrs() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable == null) {
            return null;
        }
        this.c = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) aSN1Encodable).getObjectParser(17, false);
    }

    public ASN1Integer getVersion() {
        return this.b;
    }
}
