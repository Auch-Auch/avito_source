package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.spec.InvalidKeySpecException;
public class ExtendedInvalidKeySpecException extends InvalidKeySpecException {
    public Throwable a;

    public ExtendedInvalidKeySpecException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
