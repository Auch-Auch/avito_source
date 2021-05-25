package org.spongycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {
    public Throwable a;

    public ExtCertPathBuilderException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable, org.spongycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.a;
    }

    public ExtCertPathBuilderException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th);
        this.a = th;
    }
}
