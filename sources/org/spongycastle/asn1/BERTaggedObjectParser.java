package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import x6.e.a.d;
import x6.e.a.e;
public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    public boolean a;
    public int b;
    public ASN1StreamParser c;

    public BERTaggedObjectParser(boolean z, int i, ASN1StreamParser aSN1StreamParser) {
        this.a = z;
        this.b = i;
        this.c = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return this.c.b(this.a, this.b);
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable getObjectParser(int i, boolean z) throws IOException {
        if (!z) {
            ASN1StreamParser aSN1StreamParser = this.c;
            boolean z2 = this.a;
            InputStream inputStream = aSN1StreamParser.a;
            if (!(inputStream instanceof e)) {
                if (z2) {
                    if (i == 4) {
                        return new BEROctetStringParser(aSN1StreamParser);
                    }
                    if (i == 16) {
                        return new DERSequenceParser(aSN1StreamParser);
                    }
                    if (i == 17) {
                        return new DERSetParser(aSN1StreamParser);
                    }
                } else if (i == 4) {
                    return new DEROctetStringParser((d) inputStream);
                } else {
                    if (i == 16) {
                        throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
                    } else if (i == 17) {
                        throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
                    }
                }
                throw new ASN1Exception("implicit tagging not implemented");
            } else if (z2) {
                return aSN1StreamParser.a(i);
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (this.a) {
            return this.c.readObject();
        } else {
            throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
        }
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.b;
    }

    public boolean isConstructed() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
}
