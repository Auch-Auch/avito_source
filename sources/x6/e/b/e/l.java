package x6.e.b.e;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Signer;
public class l extends ByteArrayOutputStream {
    public void a(Signer signer) {
        signer.update(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
