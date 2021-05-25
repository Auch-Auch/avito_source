package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
public class AuthEnvelopedDataParser {
    public ASN1SequenceParser a;
    public ASN1Integer b;
    public ASN1Encodable c;
    public boolean d;
    public EncryptedContentInfoParser e;

    public AuthEnvelopedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = aSN1SequenceParser;
        ASN1Integer instance = ASN1Integer.getInstance(aSN1SequenceParser.readObject());
        this.b = instance;
        if (instance.getValue().intValue() != 0) {
            throw new ASN1ParsingException("AuthEnvelopedData version number must be 0");
        }
    }

    public ASN1SetParser getAuthAttrs() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable instanceof ASN1TaggedObjectParser) {
            this.c = null;
            return (ASN1SetParser) ((ASN1TaggedObjectParser) aSN1Encodable).getObjectParser(17, false);
        } else if (this.e.getContentType().equals(CMSObjectIdentifiers.data)) {
            return null;
        } else {
            throw new ASN1ParsingException("authAttrs must be present with non-data content");
        }
    }

    public EncryptedContentInfoParser getAuthEncryptedContentInfo() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        if (aSN1Encodable == null) {
            return null;
        }
        this.c = null;
        EncryptedContentInfoParser encryptedContentInfoParser = new EncryptedContentInfoParser((ASN1SequenceParser) aSN1Encodable);
        this.e = encryptedContentInfoParser;
        return encryptedContentInfoParser;
    }

    public ASN1OctetString getMac() throws IOException {
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        ASN1Encodable aSN1Encodable = this.c;
        this.c = null;
        return ASN1OctetString.getInstance(aSN1Encodable.toASN1Primitive());
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
