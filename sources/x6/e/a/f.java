package x6.e.a;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ParsingException;
public class f implements Enumeration {
    public ASN1InputStream a;
    public Object b = a();

    public f(byte[] bArr) {
        this.a = new ASN1InputStream(bArr, true);
    }

    public final Object a() {
        try {
            return this.a.readObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(a.Z2("malformed DER construction: ", e), e);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.b;
        this.b = a();
        return obj;
    }
}
