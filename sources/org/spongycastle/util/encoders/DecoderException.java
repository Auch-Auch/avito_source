package org.spongycastle.util.encoders;
public class DecoderException extends IllegalStateException {
    public Throwable a;

    public DecoderException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
