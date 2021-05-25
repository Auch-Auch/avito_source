package org.spongycastle.asn1;
public class ASN1ParsingException extends IllegalStateException {
    public Throwable a;

    public ASN1ParsingException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.a = th;
    }
}
