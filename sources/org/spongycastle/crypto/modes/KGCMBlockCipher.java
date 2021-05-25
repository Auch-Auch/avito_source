package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public class KGCMBlockCipher implements AEADBlockCipher {
    public static final BigInteger o = BigInteger.valueOf(0);
    public static final BigInteger p = BigInteger.valueOf(1);
    public static final BigInteger q = new BigInteger("340282366920938463463374607431768211456", 10);
    public static final BigInteger r = new BigInteger("340282366920938463463374607431768211455", 10);
    public static final BigInteger s = new BigInteger("135", 10);
    public static final BigInteger t = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936", 10);
    public static final BigInteger u = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639935", 10);
    public static final BigInteger v = new BigInteger("1061", 10);
    public static final BigInteger w = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096", 10);
    public static final BigInteger x = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084095", 10);
    public static final BigInteger y = new BigInteger("293", 10);
    public BlockCipher a;
    public BufferedBlockCipher b;
    public int c;
    public boolean d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public int k;
    public int l;
    public a m = new a(this);
    public a n = new a(this);

    public class a extends ByteArrayOutputStream {
        public a(KGCMBlockCipher kGCMBlockCipher) {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.a = blockCipher;
        this.b = new BufferedBlockCipher(new KCTRBlockCipher(blockCipher));
        this.c = 0;
        this.e = new byte[this.a.getBlockSize()];
        this.g = new byte[this.a.getBlockSize()];
        this.h = new byte[this.a.getBlockSize()];
        this.i = new byte[this.a.getBlockSize()];
        this.j = new byte[this.a.getBlockSize()];
        this.l = 0;
        this.k = 0;
        this.f = null;
    }

    public final void a(byte[] bArr, int i2, int i3) {
        this.f = new byte[this.a.getBlockSize()];
        while (i3 > 0) {
            for (int i4 = 0; i4 < this.a.getBlockSize(); i4++) {
                byte[] bArr2 = this.i;
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr[i4 + i2]);
            }
            c(this.a.getBlockSize() * 8, this.i, this.h, this.j);
            byte[] reverse = Arrays.reverse(this.j);
            this.j = reverse;
            System.arraycopy(reverse, 0, this.i, 0, this.a.getBlockSize());
            i3 -= this.a.getBlockSize();
            i2 += this.a.getBlockSize();
        }
        Arrays.fill(this.j, (byte) 0);
        b(this.k, this.j, 0);
        b(this.l, this.j, this.a.getBlockSize() / 2);
        for (int i5 = 0; i5 < this.a.getBlockSize(); i5++) {
            byte[] bArr3 = this.i;
            bArr3[i5] = (byte) (bArr3[i5] ^ this.j[i5]);
        }
        this.a.processBlock(this.i, 0, this.f, 0);
    }

    public final void b(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >> 24);
        bArr[i3 + 2] = (byte) (i2 >> 16);
        bArr[i3 + 1] = (byte) (i2 >> 8);
        bArr[i3] = (byte) i2;
    }

    public final void c(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        byte[] bArr4 = new byte[this.a.getBlockSize()];
        byte[] bArr5 = new byte[this.a.getBlockSize()];
        System.arraycopy(bArr, 0, bArr4, 0, this.a.getBlockSize());
        System.arraycopy(bArr2, 0, bArr5, 0, this.a.getBlockSize());
        byte[] reverse = Arrays.reverse(bArr4);
        byte[] reverse2 = Arrays.reverse(bArr5);
        if (i2 == 128) {
            bigInteger = q;
            bigInteger3 = r;
            bigInteger2 = s;
        } else if (i2 == 256) {
            bigInteger = t;
            bigInteger3 = u;
            bigInteger2 = v;
        } else if (i2 != 512) {
            bigInteger = q;
            bigInteger3 = r;
            bigInteger2 = s;
        } else {
            bigInteger = w;
            bigInteger3 = x;
            bigInteger2 = y;
        }
        BigInteger bigInteger4 = o;
        BigInteger bigInteger5 = new BigInteger(1, reverse);
        BigInteger bigInteger6 = new BigInteger(1, reverse2);
        while (true) {
            BigInteger bigInteger7 = o;
            if (!bigInteger6.equals(bigInteger7)) {
                BigInteger bigInteger8 = p;
                if (bigInteger6.and(bigInteger8).equals(bigInteger8)) {
                    bigInteger4 = bigInteger4.xor(bigInteger5);
                }
                bigInteger5 = bigInteger5.shiftLeft(1);
                if (!bigInteger5.and(bigInteger).equals(bigInteger7)) {
                    bigInteger5 = bigInteger5.xor(bigInteger2);
                }
                bigInteger6 = bigInteger6.shiftRight(1);
            } else {
                byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger4.and(bigInteger3));
                Arrays.fill(bArr3, (byte) 0);
                System.arraycopy(asUnsignedByteArray, 0, bArr3, 0, asUnsignedByteArray.length);
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        int i3;
        int size = this.n.size();
        if (this.m.size() > 0) {
            byte[] a3 = this.m.a();
            int size2 = this.m.size();
            this.k = size2 * 8;
            BlockCipher blockCipher = this.a;
            byte[] bArr2 = this.h;
            blockCipher.processBlock(bArr2, 0, bArr2, 0);
            int i4 = 0;
            while (size2 > 0) {
                for (int i5 = 0; i5 < this.a.getBlockSize(); i5++) {
                    byte[] bArr3 = this.i;
                    bArr3[i5] = (byte) (bArr3[i5] ^ a3[i4 + i5]);
                }
                c(this.a.getBlockSize() * 8, this.i, this.h, this.j);
                byte[] reverse = Arrays.reverse(this.j);
                this.j = reverse;
                System.arraycopy(reverse, 0, this.i, 0, this.a.getBlockSize());
                size2 -= this.a.getBlockSize();
                i4 += this.a.getBlockSize();
            }
        }
        if (!this.d) {
            this.l = (size - this.c) * 8;
            a(this.n.a(), 0, size - this.c);
            int processBytes = this.b.processBytes(this.n.a(), 0, size - this.c, bArr, i2);
            i3 = this.b.doFinal(bArr, i2 + processBytes) + processBytes;
        } else if (bArr.length - i2 >= this.c + size) {
            this.l = size * 8;
            int processBytes2 = this.b.processBytes(this.n.a(), 0, size, bArr, i2);
            i3 = this.b.doFinal(bArr, i2 + processBytes2) + processBytes2;
            a(bArr, i2, size);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
        int i6 = i2 + i3;
        byte[] bArr4 = this.f;
        if (bArr4 == null) {
            throw new IllegalStateException("mac is not calculated");
        } else if (this.d) {
            System.arraycopy(bArr4, 0, bArr, i6, this.c);
            reset();
            return i3 + this.c;
        } else {
            byte[] bArr5 = new byte[this.c];
            System.arraycopy(this.n.a(), i3, bArr5, 0, this.c);
            int i7 = this.c;
            byte[] bArr6 = new byte[i7];
            System.arraycopy(this.f, 0, bArr6, 0, i7);
            if (Arrays.constantTimeAreEqual(bArr5, bArr6)) {
                reset();
                return i3;
            }
            throw new InvalidCipherTextException("mac verification failed");
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/KGCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i2 = this.c;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        if (this.d) {
            return i2;
        }
        return i2 + this.c;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        return i2;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.d = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.g;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.g, bArr.length - nonce.length, nonce.length);
            this.e = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > this.a.getBlockSize() * 8 || macSize % 8 != 0) {
                throw new IllegalArgumentException(a2.b.a.a.a.M2("Invalid value for MAC size: ", macSize));
            }
            this.c = macSize / 8;
            keyParameter = aEADParameters.getKey();
            byte[] bArr2 = this.e;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr3 = this.g;
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(iv, 0, this.g, bArr3.length - iv.length, iv.length);
            this.e = null;
            this.c = this.a.getBlockSize();
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.f = new byte[this.a.getBlockSize()];
        this.b.init(true, new ParametersWithIV(keyParameter, this.g));
        this.a.init(true, keyParameter);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        this.m.write(b2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        this.m.write(bArr, i2, i3);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        this.n.write(b2);
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i2 + i3) {
            this.n.write(bArr, i2, i3);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        this.h = new byte[this.a.getBlockSize()];
        this.i = new byte[this.a.getBlockSize()];
        this.j = new byte[this.a.getBlockSize()];
        this.l = 0;
        this.k = 0;
        this.a.reset();
        this.n.reset();
        this.m.reset();
        byte[] bArr = this.e;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
