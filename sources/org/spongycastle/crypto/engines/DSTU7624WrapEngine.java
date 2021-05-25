package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.util.ArrayList;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
public class DSTU7624WrapEngine implements Wrapper {
    public boolean a;
    public DSTU7624Engine b;
    public byte[] c;
    public byte[] d = new byte[4];
    public byte[] e = new byte[this.b.getBlockSize()];
    public byte[] f = new byte[this.b.getBlockSize()];
    public ArrayList<byte[]> g = new ArrayList<>();

    public DSTU7624WrapEngine(int i) {
        DSTU7624Engine dSTU7624Engine = new DSTU7624Engine(i);
        this.b = dSTU7624Engine;
        this.c = new byte[(dSTU7624Engine.getBlockSize() / 2)];
    }

    public final void a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >> 24);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2] = (byte) i;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "DSTU7624WrapEngine";
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.a = z;
        if (cipherParameters instanceof KeyParameter) {
            this.b.init(z, cipherParameters);
            return;
        }
        throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.a) {
            throw new IllegalStateException("not set for unwrapping");
        } else if (i2 % this.b.getBlockSize() == 0) {
            int blockSize = (i2 * 2) / this.b.getBlockSize();
            int i3 = blockSize - 1;
            int i4 = i3 * 6;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            byte[] bArr3 = new byte[(this.b.getBlockSize() / 2)];
            System.arraycopy(bArr2, 0, bArr3, 0, this.b.getBlockSize() / 2);
            this.g.clear();
            int blockSize2 = i2 - (this.b.getBlockSize() / 2);
            int blockSize3 = this.b.getBlockSize() / 2;
            while (blockSize2 != 0) {
                byte[] bArr4 = new byte[(this.b.getBlockSize() / 2)];
                System.arraycopy(bArr2, blockSize3, bArr4, 0, this.b.getBlockSize() / 2);
                this.g.add(bArr4);
                blockSize2 -= this.b.getBlockSize() / 2;
                blockSize3 += this.b.getBlockSize() / 2;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                System.arraycopy(this.g.get(blockSize - 2), 0, bArr2, 0, this.b.getBlockSize() / 2);
                System.arraycopy(bArr3, 0, bArr2, this.b.getBlockSize() / 2, this.b.getBlockSize() / 2);
                a(i4 - i5, this.d, 0);
                for (int i6 = 0; i6 < 4; i6++) {
                    int blockSize4 = (this.b.getBlockSize() / 2) + i6;
                    bArr2[blockSize4] = (byte) (bArr2[blockSize4] ^ this.d[i6]);
                }
                this.b.processBlock(bArr2, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr3, 0, this.b.getBlockSize() / 2);
                for (int i7 = 2; i7 < blockSize; i7++) {
                    int i8 = blockSize - i7;
                    System.arraycopy(this.g.get(i8 - 1), 0, this.g.get(i8), 0, this.b.getBlockSize() / 2);
                }
                System.arraycopy(bArr2, this.b.getBlockSize() / 2, this.g.get(0), 0, this.b.getBlockSize() / 2);
            }
            System.arraycopy(bArr3, 0, bArr2, 0, this.b.getBlockSize() / 2);
            int blockSize5 = this.b.getBlockSize() / 2;
            for (int i9 = 0; i9 < i3; i9++) {
                System.arraycopy(this.g.get(i9), 0, bArr2, blockSize5, this.b.getBlockSize() / 2);
                blockSize5 += this.b.getBlockSize() / 2;
            }
            System.arraycopy(bArr2, i2 - this.b.getBlockSize(), this.e, 0, this.b.getBlockSize());
            byte[] bArr5 = new byte[(i2 - this.b.getBlockSize())];
            if (Arrays.areEqual(this.e, this.f)) {
                System.arraycopy(bArr2, 0, bArr5, 0, i2 - this.b.getBlockSize());
                return bArr5;
            }
            throw new InvalidCipherTextException("checksum failed");
        } else {
            StringBuilder L = a.L("unwrap data must be a multiple of ");
            L.append(this.b.getBlockSize());
            L.append(" bytes");
            throw new DataLengthException(L.toString());
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i, int i2) {
        if (!this.a) {
            throw new IllegalStateException("not set for wrapping");
        } else if (i2 % this.b.getBlockSize() != 0) {
            StringBuilder L = a.L("wrap data must be a multiple of ");
            L.append(this.b.getBlockSize());
            L.append(" bytes");
            throw new DataLengthException(L.toString());
        } else if (i + i2 <= bArr.length) {
            int blockSize = ((i2 / this.b.getBlockSize()) + 1) * 2;
            int i3 = blockSize - 1;
            int i4 = i3 * 6;
            int blockSize2 = this.b.getBlockSize() + i2;
            byte[] bArr2 = new byte[blockSize2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            System.arraycopy(bArr2, 0, this.c, 0, this.b.getBlockSize() / 2);
            this.g.clear();
            int blockSize3 = blockSize2 - (this.b.getBlockSize() / 2);
            int blockSize4 = this.b.getBlockSize() / 2;
            while (blockSize3 != 0) {
                byte[] bArr3 = new byte[(this.b.getBlockSize() / 2)];
                System.arraycopy(bArr2, blockSize4, bArr3, 0, this.b.getBlockSize() / 2);
                this.g.add(bArr3);
                blockSize3 -= this.b.getBlockSize() / 2;
                blockSize4 += this.b.getBlockSize() / 2;
            }
            int i5 = 0;
            while (i5 < i4) {
                System.arraycopy(this.c, 0, bArr2, 0, this.b.getBlockSize() / 2);
                System.arraycopy(this.g.get(0), 0, bArr2, this.b.getBlockSize() / 2, this.b.getBlockSize() / 2);
                this.b.processBlock(bArr2, 0, bArr2, 0);
                i5++;
                a(i5, this.d, 0);
                for (int i6 = 0; i6 < 4; i6++) {
                    int blockSize5 = (this.b.getBlockSize() / 2) + i6;
                    bArr2[blockSize5] = (byte) (bArr2[blockSize5] ^ this.d[i6]);
                }
                System.arraycopy(bArr2, this.b.getBlockSize() / 2, this.c, 0, this.b.getBlockSize() / 2);
                for (int i7 = 2; i7 < blockSize; i7++) {
                    System.arraycopy(this.g.get(i7 - 1), 0, this.g.get(i7 - 2), 0, this.b.getBlockSize() / 2);
                }
                System.arraycopy(bArr2, 0, this.g.get(blockSize - 2), 0, this.b.getBlockSize() / 2);
            }
            System.arraycopy(this.c, 0, bArr2, 0, this.b.getBlockSize() / 2);
            int blockSize6 = this.b.getBlockSize() / 2;
            for (int i8 = 0; i8 < i3; i8++) {
                System.arraycopy(this.g.get(i8), 0, bArr2, blockSize6, this.b.getBlockSize() / 2);
                blockSize6 += this.b.getBlockSize() / 2;
            }
            return bArr2;
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }
}
