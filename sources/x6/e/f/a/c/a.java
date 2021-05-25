package x6.e.f.a.c;

import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Strings;
public class a {
    public static final byte[] d = Strings.toByteArray("expand 32-byte to 64-byte state!");
    public final Digest a;
    public final Digest b;
    public final b c = new b();

    public a(Digest digest) {
        this.a = digest;
        this.b = null;
    }

    public int a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        byte[] bArr4 = new byte[64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr4[i4] = (byte) (bArr2[i2 + i4] ^ bArr3[i3 + i4]);
        }
        byte[] bArr5 = new byte[64];
        for (int i5 = 0; i5 < 32; i5++) {
            bArr5[i5] = bArr4[0 + i5];
            bArr5[i5 + 32] = d[i5];
        }
        this.c.a(bArr5, bArr5);
        for (int i6 = 0; i6 < 32; i6++) {
            bArr5[i6] = (byte) (bArr5[i6] ^ bArr4[(0 + i6) + 32]);
        }
        this.c.a(bArr5, bArr5);
        for (int i7 = 0; i7 < 32; i7++) {
            bArr[i + i7] = bArr5[i7];
        }
        return 0;
    }

    public int b(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = new byte[64];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr3[i3] = bArr2[i2 + i3];
            bArr3[i3 + 32] = d[i3];
        }
        this.c.a(bArr3, bArr3);
        for (int i4 = 0; i4 < 32; i4++) {
            bArr[i + i4] = bArr3[i4];
        }
        return 0;
    }

    public a(Digest digest, Digest digest2) {
        this.a = digest;
        this.b = digest2;
    }
}
