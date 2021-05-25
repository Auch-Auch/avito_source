package x6.e.b.e;

import java.security.SecureRandom;
import org.spongycastle.crypto.tls.SecurityParameters;
import org.spongycastle.crypto.tls.TlsServerContext;
public class p extends a implements TlsServerContext {
    public p(SecureRandom secureRandom, SecurityParameters securityParameters) {
        super(secureRandom, securityParameters);
    }

    @Override // org.spongycastle.crypto.tls.TlsContext
    public boolean isServer() {
        return true;
    }
}
