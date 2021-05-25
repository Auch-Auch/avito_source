package x6.e.b.e;

import java.security.SecureRandom;
import org.spongycastle.crypto.tls.SecurityParameters;
import org.spongycastle.crypto.tls.TlsClientContext;
public class m extends a implements TlsClientContext {
    public m(SecureRandom secureRandom, SecurityParameters securityParameters) {
        super(secureRandom, securityParameters);
    }

    @Override // org.spongycastle.crypto.tls.TlsContext
    public boolean isServer() {
        return false;
    }
}
