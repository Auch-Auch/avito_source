package x6.e.g;

import java.security.cert.CertificateEncodingException;
public class c extends CertificateEncodingException {
    public Throwable a;

    public c(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
