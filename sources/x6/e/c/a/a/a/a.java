package x6.e.c.a.a.a;

import java.security.cert.CRLException;
public class a extends CRLException {
    public Throwable a;

    public a(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
