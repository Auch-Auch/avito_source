package org.spongycastle.jce.provider;

import java.io.OutputStream;
import java.security.KeyStore;
public class JDKPKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    public OutputStream a;
    public KeyStore.ProtectionParameter b;
    public boolean c;

    public OutputStream getOutputStream() {
        return this.a;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.b;
    }

    public boolean isUseDEREncoding() {
        return this.c;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.a = outputStream;
    }

    public void setPassword(char[] cArr) {
        this.b = new KeyStore.PasswordProtection(cArr);
    }

    public void setProtectionParameter(KeyStore.ProtectionParameter protectionParameter) {
        this.b = protectionParameter;
    }

    public void setUseDEREncoding(boolean z) {
        this.c = z;
    }
}
