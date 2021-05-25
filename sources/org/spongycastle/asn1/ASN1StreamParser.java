package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import x6.e.a.c;
import x6.e.a.d;
import x6.e.a.e;
import x6.e.a.i;
public class ASN1StreamParser {
    public final InputStream a;
    public final int b;
    public final byte[][] c;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, i.c(inputStream));
    }

    public ASN1Encodable a(int i) throws IOException {
        if (i == 4) {
            return new BEROctetStringParser(this);
        }
        if (i == 8) {
            return new DERExternalParser(this);
        }
        if (i == 16) {
            return new BERSequenceParser(this);
        }
        if (i == 17) {
            return new BERSetParser(this);
        }
        StringBuilder L = a.L("unknown BER object encountered: 0x");
        L.append(Integer.toHexString(i));
        throw new ASN1Exception(L.toString());
    }

    public ASN1Primitive b(boolean z, int i) throws IOException {
        if (!z) {
            return new DERTaggedObject(false, i, new DEROctetString(((d) this.a).c()));
        }
        ASN1EncodableVector c2 = c();
        if (this.a instanceof e) {
            if (c2.size() == 1) {
                return new BERTaggedObject(true, i, c2.get(0));
            }
            BERSequence bERSequence = x6.e.a.a.a;
            return new BERTaggedObject(false, i, c2.size() < 1 ? x6.e.a.a.a : new BERSequence(c2));
        } else if (c2.size() == 1) {
            return new DERTaggedObject(true, i, c2.get(0));
        } else {
            ASN1Sequence aSN1Sequence = c.a;
            return new DERTaggedObject(false, i, c2.size() < 1 ? c.a : new DLSequence(c2));
        }
    }

    public ASN1EncodableVector c() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable readObject = readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            if (readObject instanceof InMemoryRepresentable) {
                aSN1EncodableVector.add(((InMemoryRepresentable) readObject).getLoadedObject());
            } else {
                aSN1EncodableVector.add(readObject.toASN1Primitive());
            }
        }
    }

    public ASN1Encodable readObject() throws IOException {
        int read = this.a.read();
        if (read == -1) {
            return null;
        }
        InputStream inputStream = this.a;
        boolean z = false;
        if (inputStream instanceof e) {
            e eVar = (e) inputStream;
            eVar.f = false;
            eVar.c();
        }
        int e = ASN1InputStream.e(this.a, read);
        if ((read & 32) != 0) {
            z = true;
        }
        int d = ASN1InputStream.d(this.a, this.b);
        if (d >= 0) {
            d dVar = new d(this.a, d);
            if ((read & 64) != 0) {
                return new DERApplicationSpecific(z, e, dVar.c());
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(z, e, new ASN1StreamParser(dVar));
            }
            if (z) {
                if (e == 4) {
                    return new BEROctetStringParser(new ASN1StreamParser(dVar));
                }
                if (e == 8) {
                    return new DERExternalParser(new ASN1StreamParser(dVar));
                }
                if (e == 16) {
                    return new DERSequenceParser(new ASN1StreamParser(dVar));
                }
                if (e == 17) {
                    return new DERSetParser(new ASN1StreamParser(dVar));
                }
                throw new IOException(a.Q2("unknown tag ", e, " encountered"));
            } else if (e == 4) {
                return new DEROctetStringParser(dVar);
            } else {
                try {
                    return ASN1InputStream.b(e, dVar, this.c);
                } catch (IllegalArgumentException e2) {
                    throw new ASN1Exception("corrupted stream detected", e2);
                }
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new e(this.a, this.b), this.b);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(e, aSN1StreamParser);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, e, aSN1StreamParser);
            }
            return aSN1StreamParser.a(e);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this.a = inputStream;
        this.b = i;
        this.c = new byte[11][];
    }

    public ASN1StreamParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }
}
