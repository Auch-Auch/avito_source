package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.encoders.Base64;
public class PEMUtil {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public PEMUtil(String str) {
        this.a = a.e3("-----BEGIN ", str, "-----");
        this.b = a.e3("-----BEGIN X509 ", str, "-----");
        this.c = a.e3("-----END ", str, "-----");
        this.d = a.e3("-----END X509 ", str, "-----");
    }

    public final String a(InputStream inputStream) throws IOException {
        int read;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            read = inputStream.read();
            if (read == 13 || read == 10 || read < 0) {
                if (read < 0 || stringBuffer.length() != 0) {
                    break;
                }
            } else if (read != 13) {
                stringBuffer.append((char) read);
            }
        }
        if (read < 0) {
            return null;
        }
        return stringBuffer.toString();
    }

    public ASN1Sequence b(InputStream inputStream) throws IOException {
        String a3;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            a3 = a(inputStream);
            if (a3 == null || a3.startsWith(this.a)) {
                break;
            }
        } while (!a3.startsWith(this.b));
        while (true) {
            String a4 = a(inputStream);
            if (a4 == null || a4.startsWith(this.c) || a4.startsWith(this.d)) {
                break;
            }
            stringBuffer.append(a4);
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        ASN1Primitive readObject = new ASN1InputStream(Base64.decode(stringBuffer.toString())).readObject();
        if (readObject instanceof ASN1Sequence) {
            return (ASN1Sequence) readObject;
        }
        throw new IOException("malformed PEM data encountered");
    }
}
