package org.spongycastle.asn1;

import java.io.IOException;
public class ASN1Exception extends IOException {
    public Throwable a;

    public ASN1Exception(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public ASN1Exception(String str, Throwable th) {
        super(str);
        this.a = th;
    }
}
