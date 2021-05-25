package x6.e.b.e;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.tls.SSL3Mac;
import org.spongycastle.crypto.tls.TlsContext;
import org.spongycastle.crypto.tls.TlsHandshakeHash;
import org.spongycastle.crypto.tls.TlsUtils;
public class b implements TlsHandshakeHash {
    public TlsContext a;
    public Digest b;
    public Digest c;

    public b() {
        this.b = TlsUtils.createHash((short) 1);
        this.c = TlsUtils.createHash((short) 2);
    }

    public void a(Digest digest, byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = this.a.getSecurityParameters().f;
        digest.update(bArr3, 0, bArr3.length);
        digest.update(bArr, 0, i);
        int digestSize = digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        digest.doFinal(bArr4, 0);
        digest.update(bArr3, 0, bArr3.length);
        digest.update(bArr2, 0, i);
        digest.update(bArr4, 0, digestSize);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        TlsContext tlsContext = this.a;
        if (tlsContext != null && TlsUtils.isSSL(tlsContext)) {
            Digest digest = this.b;
            byte[] bArr2 = SSL3Mac.d;
            byte[] bArr3 = SSL3Mac.e;
            a(digest, bArr2, bArr3, 48);
            a(this.c, bArr2, bArr3, 40);
        }
        int doFinal = this.b.doFinal(bArr, i);
        return this.c.doFinal(bArr, i + doFinal) + doFinal;
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public Digest forkPRFHash() {
        return new b(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.b.getAlgorithmName() + " and " + this.c.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.c.getDigestSize() + this.b.getDigestSize();
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public byte[] getFinalHash(short s) {
        throw new IllegalStateException("CombinedHash doesn't support multiple hashes");
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void init(TlsContext tlsContext) {
        this.a = tlsContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public TlsHandshakeHash notifyPRFDetermined() {
        return this;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.b.reset();
        this.c.reset();
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void sealHashAlgorithms() {
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public TlsHandshakeHash stopTracking() {
        return new b(this);
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void trackHashAlgorithm(short s) {
        throw new IllegalStateException("CombinedHash only supports calculating the legacy PRF for handshake hash");
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        this.b.update(b2);
        this.c.update(b2);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.b.update(bArr, i, i2);
        this.c.update(bArr, i, i2);
    }

    public b(b bVar) {
        this.a = bVar.a;
        this.b = TlsUtils.cloneHash(1, bVar.b);
        this.c = TlsUtils.cloneHash(2, bVar.c);
    }
}
