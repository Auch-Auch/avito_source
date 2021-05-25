package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class DESedeEngine extends DESEngine {
    public static final int BLOCK_SIZE = 8;
    public int[] o = null;
    public int[] p = null;
    public int[] q = null;
    public boolean r;

    @Override // org.spongycastle.crypto.engines.DESEngine, org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.spongycastle.crypto.engines.DESEngine, org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.engines.DESEngine, org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 24 || key.length == 16) {
                this.r = z;
                byte[] bArr = new byte[8];
                System.arraycopy(key, 0, bArr, 0, 8);
                this.o = generateWorkingKey(z, bArr);
                byte[] bArr2 = new byte[8];
                System.arraycopy(key, 8, bArr2, 0, 8);
                this.p = generateWorkingKey(!z, bArr2);
                if (key.length == 24) {
                    byte[] bArr3 = new byte[8];
                    System.arraycopy(key, 16, bArr3, 0, 8);
                    this.q = generateWorkingKey(z, bArr3);
                    return;
                }
                this.q = this.o;
                return;
            }
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to DESede init - ")));
    }

    @Override // org.spongycastle.crypto.engines.DESEngine, org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.o;
        if (iArr == null) {
            throw new IllegalStateException("DESede engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            byte[] bArr3 = new byte[8];
            if (this.r) {
                desFunc(iArr, bArr, i, bArr3, 0);
                desFunc(this.p, bArr3, 0, bArr3, 0);
                desFunc(this.q, bArr3, 0, bArr2, i2);
            } else {
                desFunc(this.q, bArr, i, bArr3, 0);
                desFunc(this.p, bArr3, 0, bArr3, 0);
                desFunc(this.o, bArr3, 0, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.engines.DESEngine, org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
