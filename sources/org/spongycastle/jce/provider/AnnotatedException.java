package org.spongycastle.jce.provider;

import org.spongycastle.jce.exception.ExtException;
public class AnnotatedException extends Exception implements ExtException {
    public Throwable a;

    public AnnotatedException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable, org.spongycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.a;
    }

    public AnnotatedException(String str) {
        this(str, null);
    }
}
