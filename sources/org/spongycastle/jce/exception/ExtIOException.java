package org.spongycastle.jce.exception;

import java.io.IOException;
public class ExtIOException extends IOException implements ExtException {
    public Throwable a;

    public ExtIOException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable, org.spongycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.a;
    }
}
