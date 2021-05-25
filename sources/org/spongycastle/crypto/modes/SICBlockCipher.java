package org.spongycastle.crypto.modes;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    public final BlockCipher b;
    public final int c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g = 0;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.b = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.c = blockSize;
        this.d = new byte[blockSize];
        this.e = new byte[blockSize];
        this.f = new byte[blockSize];
    }

    public final void a() {
        if (this.d.length < this.c) {
            int i = 0;
            while (true) {
                byte[] bArr = this.d;
                if (i == bArr.length) {
                    return;
                }
                if (this.e[i] == bArr[i]) {
                    i++;
                } else {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    public final void b(int i) {
        byte b2;
        int length = this.e.length - i;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.e;
                b2 = (byte) (bArr[length] - 1);
                bArr[length] = b2;
            } else {
                return;
            }
        } while (b2 == -1);
    }

    public final void c(int i) {
        byte b2;
        int length = this.e.length - i;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.e;
                b2 = (byte) (bArr[length] + 1);
                bArr[length] = b2;
            } else {
                return;
            }
        } while (b2 == 0);
    }

    @Override // org.spongycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b2) throws DataLengthException, IllegalStateException {
        int i = this.g;
        if (i == 0) {
            this.b.processBlock(this.e, 0, this.f, 0);
            byte[] bArr = this.f;
            int i2 = this.g;
            this.g = i2 + 1;
            return (byte) (b2 ^ bArr[i2]);
        }
        byte[] bArr2 = this.f;
        int i3 = i + 1;
        this.g = i3;
        byte b3 = (byte) (b2 ^ bArr2[i]);
        if (i3 == this.e.length) {
            this.g = 0;
            c(0);
            a();
        }
        return b3;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.b.getAlgorithmName() + "/SIC";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.b.getBlockSize();
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long getPosition() {
        int i;
        byte[] bArr = this.e;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        for (int i2 = length - 1; i2 >= 1; i2--) {
            byte[] bArr3 = this.d;
            if (i2 < bArr3.length) {
                i = (bArr2[i2] & 255) - (bArr3[i2] & 255);
            } else {
                i = bArr2[i2] & 255;
            }
            if (i < 0) {
                int i3 = i2 - 1;
                bArr2[i3] = (byte) (bArr2[i3] - 1);
                i += 256;
            }
            bArr2[i2] = (byte) i;
        }
        return (Pack.bigEndianToLong(bArr2, length - 8) * ((long) this.c)) + ((long) this.g);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] clone = Arrays.clone(parametersWithIV.getIV());
            this.d = clone;
            int i = this.c;
            if (i >= clone.length) {
                int i2 = 8;
                if (8 > i / 2) {
                    i2 = i / 2;
                }
                if (i - clone.length <= i2) {
                    if (parametersWithIV.getParameters() != null) {
                        this.b.init(true, parametersWithIV.getParameters());
                    }
                    reset();
                    return;
                }
                StringBuilder L = a.L("CTR/SIC mode requires IV of at least: ");
                L.append(this.c - i2);
                L.append(" bytes.");
                throw new IllegalArgumentException(L.toString());
            }
            throw new IllegalArgumentException(a.j(a.L("CTR/SIC mode requires IV no greater than: "), this.c, " bytes."));
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i, this.c, bArr2, i2);
        return this.c;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.e, (byte) 0);
        byte[] bArr = this.d;
        System.arraycopy(bArr, 0, this.e, 0, bArr.length);
        this.b.reset();
        this.g = 0;
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long seekTo(long j) {
        reset();
        return skip(j);
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long skip(long j) {
        int i = 5;
        if (j >= 0) {
            long j2 = (((long) this.g) + j) / ((long) this.c);
            long j3 = j2;
            if (j2 > 255) {
                while (i >= 1) {
                    long j4 = 1 << (i * 8);
                    while (j3 >= j4) {
                        c(i);
                        j3 -= j4;
                    }
                    i--;
                }
            }
            int i2 = (int) j3;
            byte[] bArr = this.e;
            byte b2 = bArr[bArr.length - 1];
            int length = bArr.length - 1;
            bArr[length] = (byte) (bArr[length] + i2);
            if (b2 != 0 && bArr[bArr.length - 1] < b2) {
                c(1);
            }
            this.g = (int) ((((long) this.g) + j) - (((long) this.c) * j2));
        } else {
            long j5 = ((-j) - ((long) this.g)) / ((long) this.c);
            long j6 = j5;
            if (j5 > 255) {
                while (i >= 1) {
                    long j7 = 1 << (i * 8);
                    while (j6 > j7) {
                        b(i);
                        j6 -= j7;
                    }
                    i--;
                }
            }
            for (long j8 = 0; j8 != j6; j8++) {
                b(0);
            }
            int i3 = (int) ((((long) this.c) * j5) + ((long) this.g) + j);
            if (i3 >= 0) {
                this.g = 0;
            } else {
                b(0);
                this.g = this.c + i3;
            }
        }
        a();
        this.b.processBlock(this.e, 0, this.f, 0);
        return j;
    }
}
