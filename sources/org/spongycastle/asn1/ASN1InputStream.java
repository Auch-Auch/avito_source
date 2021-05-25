package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.util.io.Streams;
import x6.e.a.c;
import x6.e.a.d;
import x6.e.a.e;
import x6.e.a.g;
import x6.e.a.i;
public class ASN1InputStream extends FilterInputStream implements BERTags {
    public final int a;
    public final boolean b;
    public final byte[][] c;

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, i.c(inputStream));
    }

    public static ASN1Primitive b(int i, d dVar, byte[][] bArr) throws IOException {
        int read;
        if (i == 10) {
            return ASN1Enumerated.d(c(dVar, bArr));
        }
        if (i == 12) {
            return new DERUTF8String(dVar.c());
        }
        if (i != 30) {
            switch (i) {
                case 1:
                    return ASN1Boolean.d(c(dVar, bArr));
                case 2:
                    return new ASN1Integer(dVar.c(), false);
                case 3:
                    int i2 = dVar.d;
                    if (i2 >= 1) {
                        int read2 = dVar.read();
                        int i3 = i2 - 1;
                        byte[] bArr2 = new byte[i3];
                        if (i3 != 0) {
                            if (Streams.readFully(dVar, bArr2) != i3) {
                                throw new EOFException("EOF encountered in middle of BIT STRING");
                            } else if (read2 > 0 && read2 < 8) {
                                int i4 = i3 - 1;
                                if (bArr2[i4] != ((byte) (bArr2[i4] & (255 << read2)))) {
                                    return new DLBitString(bArr2, read2);
                                }
                            }
                        }
                        return new DERBitString(bArr2, read2);
                    }
                    throw new IllegalArgumentException("truncated BIT STRING detected");
                case 4:
                    return new DEROctetString(dVar.c());
                case 5:
                    return DERNull.INSTANCE;
                case 6:
                    byte[] c2 = c(dVar, bArr);
                    ConcurrentMap<ASN1ObjectIdentifier.a, ASN1ObjectIdentifier> concurrentMap = ASN1ObjectIdentifier.c;
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.c.get(new ASN1ObjectIdentifier.a(c2));
                    return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(c2) : aSN1ObjectIdentifier;
                default:
                    switch (i) {
                        case 18:
                            return new DERNumericString(dVar.c());
                        case 19:
                            return new DERPrintableString(dVar.c());
                        case 20:
                            return new DERT61String(dVar.c());
                        case 21:
                            return new DERVideotexString(dVar.c());
                        case 22:
                            return new DERIA5String(dVar.c());
                        case 23:
                            return new ASN1UTCTime(dVar.c());
                        case 24:
                            return new ASN1GeneralizedTime(dVar.c());
                        case 25:
                            return new DERGraphicString(dVar.c());
                        case 26:
                            return new DERVisibleString(dVar.c());
                        case 27:
                            return new DERGeneralString(dVar.c());
                        case 28:
                            return new DERUniversalString(dVar.c());
                        default:
                            throw new IOException(a.Q2("unknown tag ", i, " encountered"));
                    }
            }
        } else {
            int i5 = dVar.d / 2;
            char[] cArr = new char[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int read3 = dVar.read();
                if (read3 < 0 || (read = dVar.read()) < 0) {
                    break;
                }
                cArr[i6] = (char) ((read3 << 8) | (read & 255));
            }
            return new DERBMPString(cArr);
        }
    }

    public static byte[] c(d dVar, byte[][] bArr) throws IOException {
        int i = dVar.d;
        if (i >= bArr.length) {
            return dVar.c();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        Streams.readFully(dVar, bArr2);
        return bArr2;
    }

    public static int d(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i3 = (i3 << 8) + read2;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i3 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i3 < i) {
                    return i3;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException(a.M2("DER length more than 4 bytes: ", i2));
            }
        }
    }

    public static int e(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    public ASN1EncodableVector a(d dVar) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(dVar);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.add(readObject);
        }
    }

    public ASN1Primitive buildObject(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        d dVar = new d(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(z, i2, dVar.c());
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser(dVar).b(z, i2);
        }
        if (!z) {
            return b(i2, dVar, this.c);
        }
        if (i2 == 4) {
            ASN1EncodableVector a3 = a(dVar);
            int size = a3.size();
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
            for (int i4 = 0; i4 != size; i4++) {
                aSN1OctetStringArr[i4] = (ASN1OctetString) a3.get(i4);
            }
            return new BEROctetString(aSN1OctetStringArr);
        } else if (i2 == 8) {
            return new DERExternal(a(dVar));
        } else {
            if (i2 != 16) {
                if (i2 == 17) {
                    ASN1EncodableVector a4 = a(dVar);
                    ASN1Sequence aSN1Sequence = c.a;
                    return a4.size() < 1 ? c.b : new DLSet(a4);
                }
                throw new IOException(a.Q2("unknown tag ", i2, " encountered"));
            } else if (this.b) {
                return new g(dVar.c());
            } else {
                ASN1EncodableVector a5 = a(dVar);
                ASN1Sequence aSN1Sequence2 = c.a;
                return a5.size() < 1 ? c.a : new DLSequence(a5);
            }
        }
    }

    public void readFully(byte[] bArr) throws IOException {
        if (Streams.readFully(this, bArr) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    public int readLength() throws IOException {
        return d(this, this.a);
    }

    public ASN1Primitive readObject() throws IOException {
        int read = read();
        if (read > 0) {
            int e = e(this, read);
            boolean z = (read & 32) != 0;
            int readLength = readLength();
            if (readLength >= 0) {
                try {
                    return buildObject(read, e, readLength);
                } catch (IllegalArgumentException e2) {
                    throw new ASN1Exception("corrupted stream detected", e2);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new e(this, this.a), this.a);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecificParser(e, aSN1StreamParser).getLoadedObject();
                }
                if ((read & 128) != 0) {
                    return new BERTaggedObjectParser(true, e, aSN1StreamParser).getLoadedObject();
                }
                if (e == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
                }
                if (e == 8) {
                    return new DERExternalParser(aSN1StreamParser).getLoadedObject();
                }
                if (e == 16) {
                    return new BERSequenceParser(aSN1StreamParser).getLoadedObject();
                }
                if (e == 17) {
                    return new BERSetParser(aSN1StreamParser).getLoadedObject();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public ASN1InputStream(InputStream inputStream, boolean z) {
        this(inputStream, i.c(inputStream), z);
    }

    public ASN1InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.a = i;
        this.b = z;
        this.c = new byte[11][];
    }
}
