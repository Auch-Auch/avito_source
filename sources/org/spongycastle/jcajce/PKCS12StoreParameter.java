package org.spongycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore;
public class PKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    public final OutputStream a;
    public final KeyStore.ProtectionParameter b;
    public final boolean c;

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr) {
        this(outputStream, cArr, false);
    }

    public OutputStream getOutputStream() {
        return this.a;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.b;
    }

    public boolean isForDEREncoding() {
        return this.c;
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(outputStream, protectionParameter, false);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr, boolean z) {
        this(outputStream, new KeyStore.PasswordProtection(cArr), z);
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z) {
        this.a = outputStream;
        this.b = protectionParameter;
        this.c = z;
    }
}
