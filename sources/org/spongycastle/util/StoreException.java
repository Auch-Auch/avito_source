package org.spongycastle.util;
public class StoreException extends RuntimeException {
    public Throwable a;

    public StoreException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
