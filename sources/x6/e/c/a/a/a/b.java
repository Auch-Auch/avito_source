package x6.e.c.a.a.a;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.encoders.Base64;
public class b {
    public final String a;
    public final String b;
    public final String c = "-----BEGIN PKCS7-----";
    public final String d;
    public final String e;
    public final String f;

    public b(String str) {
        this.a = a.e3("-----BEGIN ", str, "-----");
        this.b = a.e3("-----BEGIN X509 ", str, "-----");
        this.d = a.e3("-----END ", str, "-----");
        this.e = a.e3("-----END X509 ", str, "-----");
        this.f = "-----END PKCS7-----";
    }

    public final String a(InputStream inputStream) throws IOException {
        int read;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            read = inputStream.read();
            if (read != 13 && read != 10 && read >= 0) {
                stringBuffer.append((char) read);
            } else if (read < 0 || stringBuffer.length() != 0) {
                break;
            }
        }
        if (read < 0) {
            return null;
        }
        if (read == 13) {
            inputStream.mark(1);
            int read2 = inputStream.read();
            if (read2 == 10) {
                inputStream.mark(1);
            }
            if (read2 > 0) {
                inputStream.reset();
            }
        }
        return stringBuffer.toString();
    }

    public ASN1Sequence b(InputStream inputStream) throws IOException {
        String a3;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            a3 = a(inputStream);
            if (a3 == null || a3.startsWith(this.a) || a3.startsWith(this.b)) {
                break;
            }
        } while (!a3.startsWith(this.c));
        while (true) {
            String a4 = a(inputStream);
            if (a4 == null || a4.startsWith(this.d) || a4.startsWith(this.e) || a4.startsWith(this.f)) {
                break;
            }
            stringBuffer.append(a4);
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        try {
            return ASN1Sequence.getInstance(Base64.decode(stringBuffer.toString()));
        } catch (Exception unused) {
            throw new IOException("malformed PEM data encountered");
        }
    }
}
