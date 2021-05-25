package x6.e.f.a.d;

import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public final class g {
    public byte[][] a;

    public g(e eVar, byte[][] bArr) {
        Objects.requireNonNull(eVar, "params == null");
        Objects.requireNonNull(bArr, "signature == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("signature byte array == null");
        } else if (bArr.length == eVar.e) {
            for (byte[] bArr2 : bArr) {
                if (bArr2.length != eVar.c) {
                    throw new IllegalArgumentException("wrong signature format");
                }
            }
            this.a = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong signature size");
        }
    }

    public byte[][] a() {
        return XMSSUtil.cloneArray(this.a);
    }
}
