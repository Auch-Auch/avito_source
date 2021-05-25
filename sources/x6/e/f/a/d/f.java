package x6.e.f.a.d;

import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public final class f {
    public final byte[][] a;

    public f(e eVar, byte[][] bArr) {
        Objects.requireNonNull(eVar, "params == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        } else if (bArr.length == eVar.e) {
            for (byte[] bArr2 : bArr) {
                if (bArr2.length != eVar.c) {
                    throw new IllegalArgumentException("wrong publicKey format");
                }
            }
            this.a = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong publicKey size");
        }
    }
}
