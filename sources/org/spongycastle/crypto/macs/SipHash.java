package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;
public class SipHash implements Mac {
    public final int c;
    public final int d;
    public long k0;
    public long k1;
    public long m;
    public long v0;
    public long v1;
    public long v2;
    public long v3;
    public int wordCount;
    public int wordPos;

    public SipHash() {
        this.m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.c = 2;
        this.d = 4;
    }

    public static long rotateLeft(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    public void applySipRounds(int i) {
        long j = this.v0;
        long j2 = this.v1;
        long j3 = this.v2;
        long j4 = this.v3;
        for (int i2 = 0; i2 < i; i2++) {
            long j5 = j + j2;
            long j6 = j3 + j4;
            long rotateLeft = rotateLeft(j2, 13) ^ j5;
            long rotateLeft2 = rotateLeft(j4, 16) ^ j6;
            long j7 = j6 + rotateLeft;
            j = rotateLeft(j5, 32) + rotateLeft2;
            j2 = rotateLeft(rotateLeft, 17) ^ j7;
            j4 = rotateLeft(rotateLeft2, 21) ^ j;
            j3 = rotateLeft(j7, 32);
        }
        this.v0 = j;
        this.v1 = j2;
        this.v2 = j3;
        this.v3 = j4;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        long j = this.m;
        int i = this.wordPos;
        long j2 = j >>> ((7 - i) << 3);
        this.m = j2;
        long j3 = j2 >>> 8;
        this.m = j3;
        this.m = j3 | ((((long) ((this.wordCount << 3) + i)) & 255) << 56);
        processMessageWord();
        this.v2 ^= 255;
        applySipRounds(this.d);
        long j4 = ((this.v0 ^ this.v1) ^ this.v2) ^ this.v3;
        reset();
        return j4;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        StringBuilder L = a.L("SipHash-");
        L.append(this.c);
        L.append("-");
        L.append(this.d);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.k0 = Pack.littleEndianToLong(key, 0);
                this.k1 = Pack.littleEndianToLong(key, 8);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    public void processMessageWord() {
        this.wordCount++;
        this.v3 ^= this.m;
        applySipRounds(this.c);
        this.v0 ^= this.m;
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        long j = this.k0;
        this.v0 = 8317987319222330741L ^ j;
        long j2 = this.k1;
        this.v1 = 7237128888997146477L ^ j2;
        this.v2 = j ^ 7816392313619706465L;
        this.v3 = 8387220255154660723L ^ j2;
        this.m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b) throws IllegalStateException {
        long j = this.m >>> 8;
        this.m = j;
        this.m = j | ((((long) b) & 255) << 56);
        int i = this.wordPos + 1;
        this.wordPos = i;
        if (i == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        int i3 = i2 & -8;
        int i4 = this.wordPos;
        int i5 = 0;
        if (i4 == 0) {
            while (i5 < i3) {
                this.m = Pack.littleEndianToLong(bArr, i + i5);
                processMessageWord();
                i5 += 8;
            }
            while (i5 < i2) {
                long j = this.m >>> 8;
                this.m = j;
                this.m = j | ((((long) bArr[i + i5]) & 255) << 56);
                i5++;
            }
            this.wordPos = i2 - i3;
            return;
        }
        int i6 = i4 << 3;
        int i7 = 0;
        while (i7 < i3) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr, i + i7);
            this.m = (this.m >>> (-i6)) | (littleEndianToLong << i6);
            processMessageWord();
            this.m = littleEndianToLong;
            i7 += 8;
        }
        while (i7 < i2) {
            long j2 = this.m >>> 8;
            this.m = j2;
            this.m = j2 | ((((long) bArr[i + i7]) & 255) << 56);
            int i8 = this.wordPos + 1;
            this.wordPos = i8;
            if (i8 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i7++;
        }
    }

    public SipHash(int i, int i2) {
        this.m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.c = i;
        this.d = i2;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), bArr, i);
        return 8;
    }
}
