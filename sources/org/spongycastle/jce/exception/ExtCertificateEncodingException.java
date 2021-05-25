package org.spongycastle.jce.exception;

import java.security.cert.CertificateEncodingException;
public class ExtCertificateEncodingException extends CertificateEncodingException implements ExtException {
    public Throwable a;

    public ExtCertificateEncodingException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable, org.spongycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.a;
    }
}
