package x6.e.f.a.d;

import java.util.Objects;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Xof;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public final class b {
    public final Digest a;
    public final int b;

    public b(Digest digest, int i) {
        Objects.requireNonNull(digest, "digest == null");
        this.a = digest;
        this.b = i;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == this.b * 3) {
            return c(2, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.b) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return c(3, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }

    public final byte[] c(int i, byte[] bArr, byte[] bArr2) {
        byte[] bytesBigEndian = XMSSUtil.toBytesBigEndian((long) i, this.b);
        this.a.update(bytesBigEndian, 0, bytesBigEndian.length);
        this.a.update(bArr, 0, bArr.length);
        this.a.update(bArr2, 0, bArr2.length);
        int i2 = this.b;
        byte[] bArr3 = new byte[i2];
        Digest digest = this.a;
        if (digest instanceof Xof) {
            ((Xof) digest).doFinal(bArr3, 0, i2);
        } else {
            digest.doFinal(bArr3, 0);
        }
        return bArr3;
    }
}
