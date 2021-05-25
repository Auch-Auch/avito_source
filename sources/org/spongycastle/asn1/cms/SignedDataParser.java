package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
public class SignedDataParser {
    public ASN1SequenceParser a;
    public ASN1Integer b;
    public Object c;
    public boolean d;
    public boolean e;

    public SignedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.a = aSN1SequenceParser;
        this.b = (ASN1Integer) aSN1SequenceParser.readObject();
    }

    public static SignedDataParser getInstance(Object obj) throws IOException {
        if (obj instanceof ASN1Sequence) {
            return new SignedDataParser(((ASN1Sequence) obj).parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new SignedDataParser((ASN1SequenceParser) obj);
        }
        throw new IOException(a.H2(obj, a.L("unknown object encountered: ")));
    }

    public ASN1SetParser getCertificates() throws IOException {
        this.d = true;
        ASN1Encodable readObject = this.a.readObject();
        this.c = readObject;
        if (!(readObject instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) readObject).getTagNo() != 0) {
            return null;
        }
        ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this.c).getObjectParser(17, false);
        this.c = null;
        return aSN1SetParser;
    }

    public ASN1SetParser getCrls() throws IOException {
        if (this.d) {
            this.e = true;
            if (this.c == null) {
                this.c = this.a.readObject();
            }
            Object obj = this.c;
            if (!(obj instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) obj).getTagNo() != 1) {
                return null;
            }
            ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this.c).getObjectParser(17, false);
            this.c = null;
            return aSN1SetParser;
        }
        throw new IOException("getCerts() has not been called.");
    }

    public ASN1SetParser getDigestAlgorithms() throws IOException {
        ASN1Encodable readObject = this.a.readObject();
        if (readObject instanceof ASN1Set) {
            return ((ASN1Set) readObject).parser();
        }
        return (ASN1SetParser) readObject;
    }

    public ContentInfoParser getEncapContentInfo() throws IOException {
        return new ContentInfoParser((ASN1SequenceParser) this.a.readObject());
    }

    public ASN1SetParser getSignerInfos() throws IOException {
        if (!this.d || !this.e) {
            throw new IOException("getCerts() and/or getCrls() has not been called.");
        }
        if (this.c == null) {
            this.c = this.a.readObject();
        }
        return (ASN1SetParser) this.c;
    }

    public ASN1Integer getVersion() {
        return this.b;
    }
}
