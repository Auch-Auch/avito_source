package org.spongycastle.util.encoders;
public class EncoderException extends IllegalStateException {
    public Throwable a;

    public EncoderException(String str, Throwable th) {
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
