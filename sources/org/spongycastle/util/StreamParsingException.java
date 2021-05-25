package org.spongycastle.util;
public class StreamParsingException extends Exception {
    public Throwable a;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
