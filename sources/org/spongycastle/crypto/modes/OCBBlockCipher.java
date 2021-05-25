package org.spongycastle.crypto.modes;

import a2.b.a.a.a;
import java.util.Vector;
import okio.Utf8;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class OCBBlockCipher implements AEADBlockCipher {
    public BlockCipher a;
    public BlockCipher b;
    public boolean c;
    public int d;
    public byte[] e;
    public Vector f;
    public byte[] g;
    public byte[] h;
    public byte[] i = null;
    public byte[] j = new byte[24];
    public byte[] k = new byte[16];
    public byte[] l;
    public byte[] m;
    public int n;
    public int o;
    public long p;
    public long q;
    public byte[] r;
    public byte[] s;
    public byte[] t = new byte[16];
    public byte[] u;
    public byte[] v;

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        } else if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        } else if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        } else if (blockCipher2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        } else if (blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
            this.a = blockCipher;
            this.b = blockCipher2;
        } else {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
    }

    public static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - shiftLeft(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    public static void OCB_extend(byte[] bArr, int i2) {
        bArr[i2] = Byte.MIN_VALUE;
        while (true) {
            i2++;
            if (i2 < 16) {
                bArr[i2] = 0;
            } else {
                return;
            }
        }
    }

    public static int OCB_ntz(long j2) {
        if (j2 == 0) {
            return 64;
        }
        int i2 = 0;
        while ((1 & j2) == 0) {
            i2++;
            j2 >>>= 1;
        }
        return i2;
    }

    public static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i2 = 16;
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            int i4 = bArr[i2] & 255;
            bArr2[i2] = (byte) (i3 | (i4 << 1));
            i3 = (i4 >>> 7) & 1;
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        for (int i2 = 15; i2 >= 0; i2--) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    public void clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (!this.c) {
            int i3 = this.o;
            int i4 = this.d;
            if (i3 >= i4) {
                int i5 = i3 - i4;
                this.o = i5;
                bArr2 = new byte[i4];
                System.arraycopy(this.m, i5, bArr2, 0, i4);
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else {
            bArr2 = null;
        }
        int i6 = this.n;
        if (i6 > 0) {
            OCB_extend(this.l, i6);
            updateHASH(this.g);
        }
        int i7 = this.o;
        if (i7 > 0) {
            if (this.c) {
                OCB_extend(this.m, i7);
                xor(this.u, this.m);
            }
            xor(this.t, this.g);
            byte[] bArr3 = new byte[16];
            this.a.processBlock(this.t, 0, bArr3, 0);
            xor(this.m, bArr3);
            int length = bArr.length;
            int i8 = this.o;
            if (length >= i2 + i8) {
                System.arraycopy(this.m, 0, bArr, i2, i8);
                if (!this.c) {
                    OCB_extend(this.m, this.o);
                    xor(this.u, this.m);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        xor(this.u, this.t);
        xor(this.u, this.h);
        BlockCipher blockCipher = this.a;
        byte[] bArr4 = this.u;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        xor(this.u, this.s);
        int i9 = this.d;
        byte[] bArr5 = new byte[i9];
        this.v = bArr5;
        System.arraycopy(this.u, 0, bArr5, 0, i9);
        int i10 = this.o;
        if (this.c) {
            int length2 = bArr.length;
            int i11 = i2 + i10;
            int i12 = this.d;
            if (length2 >= i11 + i12) {
                System.arraycopy(this.v, 0, bArr, i11, i12);
                i10 += this.d;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (!Arrays.constantTimeAreEqual(this.v, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        reset(false);
        return i10;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.b.getAlgorithmName() + "/OCB";
    }

    public byte[] getLSub(int i2) {
        while (i2 >= this.f.size()) {
            Vector vector = this.f;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.f.elementAt(i2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        byte[] bArr = this.v;
        if (bArr == null) {
            return new byte[this.d];
        }
        return Arrays.clone(bArr);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int i3 = i2 + this.o;
        if (this.c) {
            return i3 + this.d;
        }
        int i4 = this.d;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.o;
        if (!this.c) {
            int i4 = this.d;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % 16);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        byte[] bArr;
        int i2;
        boolean z2 = this.c;
        this.c = z;
        this.v = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.e = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException(a.M2("Invalid value for MAC size: ", macSize));
            }
            this.d = macSize / 8;
            keyParameter = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.e = null;
            this.d = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.l = new byte[16];
        if (z) {
            i2 = 16;
        } else {
            i2 = this.d + 16;
        }
        this.m = new byte[i2];
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length <= 15) {
            if (keyParameter != null) {
                this.a.init(true, keyParameter);
                this.b.init(z, keyParameter);
                this.i = null;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            byte[] bArr2 = new byte[16];
            this.g = bArr2;
            this.a.processBlock(bArr2, 0, bArr2, 0);
            this.h = OCB_double(this.g);
            Vector vector = new Vector();
            this.f = vector;
            vector.addElement(OCB_double(this.h));
            int processNonce = processNonce(bArr);
            int i3 = processNonce % 8;
            int i4 = processNonce / 8;
            if (i3 == 0) {
                System.arraycopy(this.j, i4, this.k, 0, 16);
            } else {
                for (int i5 = 0; i5 < 16; i5++) {
                    byte[] bArr3 = this.j;
                    i4++;
                    this.k[i5] = (byte) (((bArr3[i4] & 255) >>> (8 - i3)) | ((bArr3[i4] & 255) << i3));
                }
            }
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = new byte[16];
            this.s = new byte[16];
            System.arraycopy(this.k, 0, this.t, 0, 16);
            this.u = new byte[16];
            byte[] bArr4 = this.e;
            if (bArr4 != null) {
                processAADBytes(bArr4, 0, bArr4.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        byte[] bArr = this.l;
        int i2 = this.n;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.n = i3;
        if (i3 == bArr.length) {
            processHashBlock();
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.l;
            int i5 = this.n;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.n = i6;
            if (i6 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
        byte[] bArr2 = this.m;
        int i3 = this.o;
        bArr2[i3] = b2;
        int i4 = i3 + 1;
        this.o = i4;
        if (i4 != bArr2.length) {
            return 0;
        }
        processMainBlock(bArr, i2);
        return 16;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = this.m;
                int i7 = this.o;
                bArr3[i7] = bArr[i2 + i6];
                int i8 = i7 + 1;
                this.o = i8;
                if (i8 == bArr3.length) {
                    processMainBlock(bArr2, i4 + i5);
                    i5 += 16;
                }
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public void processHashBlock() {
        long j2 = this.p + 1;
        this.p = j2;
        updateHASH(getLSub(OCB_ntz(j2)));
        this.n = 0;
    }

    public void processMainBlock(byte[] bArr, int i2) {
        if (bArr.length >= i2 + 16) {
            if (this.c) {
                xor(this.u, this.m);
                this.o = 0;
            }
            byte[] bArr2 = this.t;
            long j2 = this.q + 1;
            this.q = j2;
            xor(bArr2, getLSub(OCB_ntz(j2)));
            xor(this.m, this.t);
            BlockCipher blockCipher = this.b;
            byte[] bArr3 = this.m;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            xor(this.m, this.t);
            System.arraycopy(this.m, 0, bArr, i2, 16);
            if (!this.c) {
                xor(this.u, this.m);
                byte[] bArr4 = this.m;
                System.arraycopy(bArr4, 16, bArr4, 0, this.d);
                this.o = this.d;
                return;
            }
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    public int processNonce(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.d << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        int i3 = bArr2[15] & Utf8.REPLACEMENT_BYTE;
        bArr2[15] = (byte) (bArr2[15] & 192);
        byte[] bArr3 = this.i;
        if (bArr3 == null || !Arrays.areEqual(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.i = bArr2;
            this.a.processBlock(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.j, 0, 16);
            while (i2 < 8) {
                byte[] bArr5 = this.j;
                int i4 = i2 + 16;
                byte b2 = bArr4[i2];
                i2++;
                bArr5[i4] = (byte) (b2 ^ bArr4[i2]);
            }
        }
        return i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }

    public void updateHASH(byte[] bArr) {
        xor(this.r, bArr);
        xor(this.l, this.r);
        BlockCipher blockCipher = this.a;
        byte[] bArr2 = this.l;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        xor(this.s, this.l);
    }

    public void reset(boolean z) {
        this.a.reset();
        this.b.reset();
        clear(this.l);
        clear(this.m);
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        clear(this.r);
        clear(this.s);
        System.arraycopy(this.k, 0, this.t, 0, 16);
        clear(this.u);
        if (z) {
            this.v = null;
        }
        byte[] bArr = this.e;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
