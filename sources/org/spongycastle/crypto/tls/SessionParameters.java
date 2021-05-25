package org.spongycastle.crypto.tls;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.util.Arrays;
public final class SessionParameters {
    public int a;
    public short b;
    public byte[] c;
    public Certificate d;
    public byte[] e = null;
    public byte[] f = null;
    public byte[] g;

    public static final class Builder {
        public int a = -1;
        public short b = -1;
        public byte[] c = null;
        public Certificate d = null;
        public byte[] e = null;
        public byte[] f = null;
        public byte[] g = null;

        public final void a(boolean z, String str) {
            if (!z) {
                throw new IllegalStateException(a.e3("Required session parameter '", str, "' not configured"));
            }
        }

        public SessionParameters build() {
            boolean z = true;
            a(this.a >= 0, "cipherSuite");
            a(this.b >= 0, "compressionAlgorithm");
            if (this.c == null) {
                z = false;
            }
            a(z, "masterSecret");
            return new SessionParameters(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        public Builder setCipherSuite(int i) {
            this.a = i;
            return this;
        }

        public Builder setCompressionAlgorithm(short s) {
            this.b = s;
            return this;
        }

        public Builder setMasterSecret(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public Builder setPSKIdentity(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public Builder setPeerCertificate(Certificate certificate) {
            this.d = certificate;
            return this;
        }

        public Builder setPskIdentity(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public Builder setSRPIdentity(byte[] bArr) {
            this.f = bArr;
            return this;
        }

        public Builder setServerExtensions(Hashtable hashtable) throws IOException {
            if (hashtable == null) {
                this.g = null;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TlsProtocol.writeExtensions(byteArrayOutputStream, hashtable);
                this.g = byteArrayOutputStream.toByteArray();
            }
            return this;
        }
    }

    public SessionParameters(int i, short s, byte[] bArr, Certificate certificate, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.a = i;
        this.b = s;
        this.c = Arrays.clone(bArr);
        this.d = certificate;
        this.e = Arrays.clone(bArr2);
        this.f = Arrays.clone(bArr3);
        this.g = bArr4;
    }

    public void clear() {
        byte[] bArr = this.c;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    public SessionParameters copy() {
        return new SessionParameters(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public int getCipherSuite() {
        return this.a;
    }

    public short getCompressionAlgorithm() {
        return this.b;
    }

    public byte[] getMasterSecret() {
        return this.c;
    }

    public byte[] getPSKIdentity() {
        return this.e;
    }

    public Certificate getPeerCertificate() {
        return this.d;
    }

    public byte[] getPskIdentity() {
        return this.e;
    }

    public byte[] getSRPIdentity() {
        return this.f;
    }

    public Hashtable readServerExtensions() throws IOException {
        if (this.g == null) {
            return null;
        }
        return TlsProtocol.readExtensions(new ByteArrayInputStream(this.g));
    }
}
