package x6.e.b.e;

import org.spongycastle.crypto.tls.TlsCipher;
public class c {
    public final h a = new h();
    public final int b;
    public final TlsCipher c;
    public long d = 0;

    public c(int i, TlsCipher tlsCipher) {
        if (i < 0) {
            throw new IllegalArgumentException("'epoch' must be >= 0");
        } else if (tlsCipher != null) {
            this.b = i;
            this.c = tlsCipher;
        } else {
            throw new IllegalArgumentException("'cipher' cannot be null");
        }
    }
}
