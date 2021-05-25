package org.spongycastle.util.io.pem;

import java.io.IOException;
public class PemGenerationException extends IOException {
    public Throwable a;

    public PemGenerationException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public PemGenerationException(String str) {
        super(str);
    }
}
