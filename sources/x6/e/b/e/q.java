package x6.e.b.e;

import org.spongycastle.crypto.tls.SessionParameters;
import org.spongycastle.crypto.tls.TlsSession;
import org.spongycastle.util.Arrays;
public class q implements TlsSession {
    public final byte[] a;
    public SessionParameters b;

    public q(byte[] bArr, SessionParameters sessionParameters) {
        if (bArr == null) {
            throw new IllegalArgumentException("'sessionID' cannot be null");
        } else if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
        } else {
            this.a = Arrays.clone(bArr);
            this.b = sessionParameters;
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsSession
    public synchronized SessionParameters exportSessionParameters() {
        SessionParameters sessionParameters;
        sessionParameters = this.b;
        return sessionParameters == null ? null : sessionParameters.copy();
    }

    @Override // org.spongycastle.crypto.tls.TlsSession
    public synchronized byte[] getSessionID() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.tls.TlsSession
    public synchronized void invalidate() {
        SessionParameters sessionParameters = this.b;
        if (sessionParameters != null) {
            sessionParameters.clear();
            this.b = null;
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsSession
    public synchronized boolean isResumable() {
        return this.b != null;
    }
}
