package x6.e.f.a.d;

import a2.b.a.a.a;
import java.util.Map;
import java.util.Objects;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.xmss.XMSSOid;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public final class e {
    public final XMSSOid a;
    public final Digest b;
    public final int c;
    public final int d = 16;
    public final int e;
    public final int f;
    public final int g;

    public e(Digest digest) {
        Objects.requireNonNull(digest, "digest == null");
        this.b = digest;
        int digestSize = XMSSUtil.getDigestSize(digest);
        this.c = digestSize;
        int ceil = (int) Math.ceil(((double) (digestSize * 8)) / ((double) XMSSUtil.log2(16)));
        this.f = ceil;
        int floor = ((int) Math.floor((double) (XMSSUtil.log2((16 - 1) * ceil) / XMSSUtil.log2(16)))) + 1;
        this.g = floor;
        int i = ceil + floor;
        this.e = i;
        String algorithmName = digest.getAlgorithmName();
        Map<String, d> map = d.c;
        Objects.requireNonNull(algorithmName, "algorithmName == null");
        d dVar = d.c.get(d.a(algorithmName, digestSize, 16, i));
        this.a = dVar;
        if (dVar == null) {
            StringBuilder L = a.L("cannot find OID for digest algorithm: ");
            L.append(digest.getAlgorithmName());
            throw new IllegalArgumentException(L.toString());
        }
    }
}
