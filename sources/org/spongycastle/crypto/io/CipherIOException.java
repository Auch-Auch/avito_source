package org.spongycastle.crypto.io;

import java.io.IOException;
public class CipherIOException extends IOException {
    private static final long serialVersionUID = 1;
    public final Throwable a;

    public CipherIOException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
