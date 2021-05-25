package x6.e.a;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1OctetStringParser;
import org.spongycastle.asn1.ASN1StreamParser;
public class b extends InputStream {
    public final ASN1StreamParser a;
    public boolean b = true;
    public InputStream c;

    public b(ASN1StreamParser aSN1StreamParser) {
        this.a = aSN1StreamParser;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser;
        int i3 = 0;
        if (this.c == null) {
            if (!this.b || (aSN1OctetStringParser = (ASN1OctetStringParser) this.a.readObject()) == null) {
                return -1;
            }
            this.b = false;
            this.c = aSN1OctetStringParser.getOctetStream();
        }
        while (true) {
            int read = this.c.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                ASN1OctetStringParser aSN1OctetStringParser2 = (ASN1OctetStringParser) this.a.readObject();
                if (aSN1OctetStringParser2 == null) {
                    this.c = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.c = aSN1OctetStringParser2.getOctetStream();
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser;
        if (this.c == null) {
            if (!this.b || (aSN1OctetStringParser = (ASN1OctetStringParser) this.a.readObject()) == null) {
                return -1;
            }
            this.b = false;
            this.c = aSN1OctetStringParser.getOctetStream();
        }
        while (true) {
            int read = this.c.read();
            if (read >= 0) {
                return read;
            }
            ASN1OctetStringParser aSN1OctetStringParser2 = (ASN1OctetStringParser) this.a.readObject();
            if (aSN1OctetStringParser2 == null) {
                this.c = null;
                return -1;
            }
            this.c = aSN1OctetStringParser2.getOctetStream();
        }
    }
}
