package x6.e.b.e;

import a2.b.a.a.a;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.tls.HashAlgorithm;
import org.spongycastle.crypto.tls.TlsContext;
import org.spongycastle.crypto.tls.TlsHandshakeHash;
import org.spongycastle.crypto.tls.TlsUtils;
import org.spongycastle.util.Shorts;
public class i implements TlsHandshakeHash {
    public TlsContext a;
    public j b;
    public Hashtable c;
    public Short d;

    public i() {
        this.b = new j();
        this.c = new Hashtable();
        this.d = null;
    }

    public void a() {
        if (this.b != null && this.c.size() <= 4) {
            Enumeration elements = this.c.elements();
            while (elements.hasMoreElements()) {
                this.b.a((Digest) elements.nextElement());
            }
            this.b = null;
        }
    }

    public void b(Short sh) {
        if (!this.c.containsKey(sh)) {
            this.c.put(sh, TlsUtils.createHash(sh.shortValue()));
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public Digest forkPRFHash() {
        a();
        if (this.b == null) {
            return TlsUtils.cloneHash(this.d.shortValue(), (Digest) this.c.get(this.d));
        }
        Digest createHash = TlsUtils.createHash(this.d.shortValue());
        this.b.a(createHash);
        return createHash;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public byte[] getFinalHash(short s) {
        Digest digest = (Digest) this.c.get(Shorts.valueOf(s));
        if (digest != null) {
            Digest cloneHash = TlsUtils.cloneHash(s, digest);
            j jVar = this.b;
            if (jVar != null) {
                jVar.a(cloneHash);
            }
            byte[] bArr = new byte[cloneHash.getDigestSize()];
            cloneHash.doFinal(bArr, 0);
            return bArr;
        }
        StringBuilder L = a.L("HashAlgorithm.");
        L.append(HashAlgorithm.getText(s));
        L.append(" is not being tracked");
        throw new IllegalStateException(L.toString());
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void init(TlsContext tlsContext) {
        this.a = tlsContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public TlsHandshakeHash notifyPRFDetermined() {
        int prfAlgorithm = this.a.getSecurityParameters().getPrfAlgorithm();
        if (prfAlgorithm == 0) {
            b bVar = new b();
            bVar.a = this.a;
            this.b.a(bVar);
            return bVar;
        }
        Short valueOf = Shorts.valueOf(TlsUtils.getHashAlgorithmForPRFAlgorithm(prfAlgorithm));
        this.d = valueOf;
        b(valueOf);
        return this;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        j jVar = this.b;
        if (jVar != null) {
            jVar.reset();
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).reset();
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void sealHashAlgorithms() {
        a();
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public TlsHandshakeHash stopTracking() {
        Digest cloneHash = TlsUtils.cloneHash(this.d.shortValue(), (Digest) this.c.get(this.d));
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(cloneHash);
        }
        i iVar = new i(this.d, cloneHash);
        iVar.a = this.a;
        return iVar;
    }

    @Override // org.spongycastle.crypto.tls.TlsHandshakeHash
    public void trackHashAlgorithm(short s) {
        if (this.b != null) {
            b(Shorts.valueOf(s));
            return;
        }
        throw new IllegalStateException("Too late to track more hash algorithms");
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.write(b2);
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).update(b2);
        }
    }

    public i(Short sh, Digest digest) {
        this.b = null;
        Hashtable hashtable = new Hashtable();
        this.c = hashtable;
        this.d = sh;
        hashtable.put(sh, digest);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.write(bArr, i, i2);
            return;
        }
        Enumeration elements = this.c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).update(bArr, i, i2);
        }
    }
}
