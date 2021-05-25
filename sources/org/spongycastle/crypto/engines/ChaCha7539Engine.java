package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.util.Pack;
public class ChaCha7539Engine extends Salsa20Engine {
    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void advanceCounter(long j) {
        int i = (int) j;
        if (((int) (j >>> 32)) <= 0) {
            int[] iArr = this.engineState;
            int i2 = iArr[12];
            iArr[12] = iArr[12] + i;
            if (i2 != 0 && iArr[12] < i2) {
                throw new IllegalStateException("attempt to increase counter past 2^32.");
            }
            return;
        }
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine, org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        StringBuilder L = a.L("ChaCha7539-");
        L.append(this.rounds);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public long getCounter() {
        return ((long) this.engineState[12]) & BodyPartID.bodyIdMax;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public int getNonceSize() {
        return 12;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void resetCounter() {
        this.engineState[12] = 0;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void retreatCounter(long j) {
        int i = (int) j;
        if (((int) (j >>> 32)) == 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[12]) & BodyPartID.bodyIdMax) >= (BodyPartID.bodyIdMax & ((long) i))) {
                iArr[12] = iArr[12] - i;
                return;
            }
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[12] != 0) {
            iArr[12] = iArr[12] - 1;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }
}
