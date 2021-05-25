package org.spongycastle.jcajce.provider.util;

import javax.crypto.BadPaddingException;
public class BadBlockException extends BadPaddingException {
    public final Throwable a;

    public BadBlockException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
