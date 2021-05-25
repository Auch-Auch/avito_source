package org.spongycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
public class ExtCertPathValidatorException extends CertPathValidatorException implements ExtException {
    public Throwable a;

    public ExtCertPathValidatorException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable, org.spongycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.a;
    }

    public ExtCertPathValidatorException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th, certPath, i);
        this.a = th;
    }
}
