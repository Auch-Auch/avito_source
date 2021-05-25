package x6.e.c.a.c;

import java.security.PrivilegedAction;
import org.spongycastle.crypto.prng.EntropySourceProvider;
import org.spongycastle.jcajce.provider.drbg.DRBG;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
public final class a implements PrivilegedAction<EntropySourceProvider> {
    public final /* synthetic */ String a;

    public a(String str) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.security.PrivilegedAction
    public EntropySourceProvider run() {
        try {
            return (EntropySourceProvider) ClassUtil.loadClass(DRBG.class, this.a).newInstance();
        } catch (Exception e) {
            StringBuilder L = a2.b.a.a.a.L("entropy source ");
            L.append(this.a);
            L.append(" not created: ");
            L.append(e.getMessage());
            throw new IllegalStateException(L.toString(), e);
        }
    }
}
