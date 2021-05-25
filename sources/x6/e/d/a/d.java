package x6.e.d.a;

import java.security.cert.CRLException;
public class d extends CRLException {
    public Throwable a;

    public d(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
