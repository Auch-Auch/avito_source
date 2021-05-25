package x6.e.b.e;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;
public class j extends ByteArrayOutputStream {
    public void a(Digest digest) {
        digest.update(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
