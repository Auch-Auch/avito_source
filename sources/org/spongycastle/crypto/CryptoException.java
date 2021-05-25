package org.spongycastle.crypto;
public class CryptoException extends Exception {
    public Throwable a;

    public CryptoException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.a = th;
    }
}
