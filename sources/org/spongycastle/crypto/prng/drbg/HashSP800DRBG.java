package org.spongycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import x6.e.b.d.b.a;
public class HashSP800DRBG implements SP80090DRBG {
    public static final byte[] h = {1};
    public static final Hashtable i;
    public Digest a;
    public byte[] b;
    public byte[] c;
    public long d;
    public EntropySource e;
    public int f;
    public int g;

    static {
        Hashtable hashtable = new Hashtable();
        i = hashtable;
        hashtable.put("SHA-1", Integers.valueOf(440));
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(440));
        hashtable.put("SHA-256", Integers.valueOf(440));
        hashtable.put("SHA-512/256", Integers.valueOf(440));
        hashtable.put("SHA-512/224", Integers.valueOf(440));
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(888));
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA512, Integers.valueOf(888));
    }

    public HashSP800DRBG(Digest digest, int i2, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i2 > ((Integer) a.a.get(digest.getAlgorithmName())).intValue()) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.entropySize() >= i2) {
            this.a = digest;
            this.e = entropySource;
            this.f = i2;
            this.g = ((Integer) i.get(digest.getAlgorithmName())).intValue();
            byte[] a3 = a.a(this.a, Arrays.concatenate(b(), bArr2, bArr), this.g);
            this.b = a3;
            byte[] bArr3 = new byte[(a3.length + 1)];
            System.arraycopy(a3, 0, bArr3, 1, a3.length);
            this.c = a.a(this.a, bArr3, this.g);
            this.d = 1;
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = 1; i3 <= bArr2.length; i3++) {
            int i4 = (bArr[bArr.length - i3] & 255) + (bArr2[bArr2.length - i3] & 255) + i2;
            i2 = i4 > 255 ? 1 : 0;
            bArr[bArr.length - i3] = (byte) i4;
        }
        for (int length = bArr2.length + 1; length <= bArr.length; length++) {
            int i5 = (bArr[bArr.length - length] & 255) + i2;
            i2 = i5 > 255 ? 1 : 0;
            bArr[bArr.length - length] = (byte) i5;
        }
    }

    public final byte[] b() {
        byte[] entropy = this.e.getEntropy();
        if (entropy.length >= (this.f + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[this.a.getDigestSize()];
        this.a.update(bArr, 0, bArr.length);
        this.a.doFinal(bArr2, 0);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.d > 140737488355328L) {
            return -1;
        } else {
            byte[] bArr3 = bArr2;
            if (z) {
                reseed(bArr3);
                bArr3 = null;
            }
            if (bArr3 != null) {
                byte[] bArr4 = this.b;
                byte[] bArr5 = new byte[(bArr4.length + 1 + bArr3.length)];
                bArr5[0] = 2;
                System.arraycopy(bArr4, 0, bArr5, 1, bArr4.length);
                System.arraycopy(bArr3, 0, bArr5, this.b.length + 1, bArr3.length);
                a(this.b, c(bArr5));
            }
            byte[] bArr6 = this.b;
            int i2 = length / 8;
            int digestSize = i2 / this.a.getDigestSize();
            int length2 = bArr6.length;
            byte[] bArr7 = new byte[length2];
            System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
            byte[] bArr8 = new byte[i2];
            int digestSize2 = this.a.getDigestSize();
            byte[] bArr9 = new byte[digestSize2];
            for (int i3 = 0; i3 <= digestSize; i3++) {
                this.a.update(bArr7, 0, length2);
                this.a.doFinal(bArr9, 0);
                int i4 = i3 * digestSize2;
                int i5 = i2 - i4;
                if (i5 > digestSize2) {
                    i5 = digestSize2;
                }
                System.arraycopy(bArr9, 0, bArr8, i4, i5);
                a(bArr7, h);
            }
            byte[] bArr10 = this.b;
            byte[] bArr11 = new byte[(bArr10.length + 1)];
            System.arraycopy(bArr10, 0, bArr11, 1, bArr10.length);
            bArr11[0] = 3;
            a(this.b, c(bArr11));
            a(this.b, this.c);
            long j = this.d;
            a(this.b, new byte[]{(byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)});
            this.d++;
            System.arraycopy(bArr8, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this.a.getDigestSize() * 8;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        byte[] a3 = a.a(this.a, Arrays.concatenate(h, this.b, b(), bArr), this.g);
        this.b = a3;
        byte[] bArr2 = new byte[(a3.length + 1)];
        bArr2[0] = 0;
        System.arraycopy(a3, 0, bArr2, 1, a3.length);
        this.c = a.a(this.a, bArr2, this.g);
        this.d = 1;
    }
}
