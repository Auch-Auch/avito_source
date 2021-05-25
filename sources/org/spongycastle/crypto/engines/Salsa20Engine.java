package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.MaxBytesExceededException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;
public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    public static final int[] g = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
    public static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    public static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    public int a;
    public byte[] b;
    public boolean c;
    public int d;
    public int e;
    public int[] engineState;
    public int f;
    public int rounds;
    public int[] x;

    public Salsa20Engine() {
        this(20);
    }

    public static int rotl(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static void salsaCore(int i, int[] iArr, int[] iArr2) {
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int i6 = iArr[4];
            int i7 = iArr[5];
            int i8 = iArr[6];
            int i9 = 7;
            int i10 = iArr[7];
            int i11 = iArr[8];
            int i12 = 9;
            int i13 = iArr[9];
            int i14 = iArr[10];
            int i15 = iArr[11];
            int i16 = iArr[12];
            int i17 = 13;
            int i18 = iArr[13];
            int i19 = iArr[14];
            int i20 = iArr[15];
            int i21 = i19;
            int i22 = i18;
            int i23 = i16;
            int i24 = i15;
            int i25 = i14;
            int i26 = i13;
            int i27 = i11;
            int i28 = i10;
            int i29 = i8;
            int i30 = i7;
            int i31 = i6;
            int i32 = i5;
            int i33 = i4;
            int i34 = i3;
            int i35 = i2;
            for (int i36 = i; i36 > 0; i36 -= 2) {
                int rotl = rotl(i35 + i23, i9) ^ i31;
                int rotl2 = i27 ^ rotl(rotl + i35, i12);
                int rotl3 = i23 ^ rotl(rotl2 + rotl, i17);
                int rotl4 = rotl(rotl3 + rotl2, 18) ^ i35;
                int rotl5 = i26 ^ rotl(i30 + i34, i9);
                int rotl6 = i22 ^ rotl(rotl5 + i30, i12);
                int rotl7 = i34 ^ rotl(rotl6 + rotl5, i17);
                int rotl8 = rotl(rotl7 + rotl6, 18) ^ i30;
                int rotl9 = i21 ^ rotl(i25 + i29, 7);
                int rotl10 = i33 ^ rotl(rotl9 + i25, 9);
                int rotl11 = i29 ^ rotl(rotl10 + rotl9, 13);
                int rotl12 = i25 ^ rotl(rotl11 + rotl10, 18);
                int rotl13 = i32 ^ rotl(i20 + i24, 7);
                int rotl14 = i28 ^ rotl(rotl13 + i20, 9);
                int rotl15 = i24 ^ rotl(rotl14 + rotl13, 13);
                int rotl16 = i20 ^ rotl(rotl15 + rotl14, 18);
                i34 = rotl7 ^ rotl(rotl4 + rotl13, 7);
                i33 = rotl10 ^ rotl(i34 + rotl4, 9);
                int rotl17 = rotl13 ^ rotl(i33 + i34, 13);
                int rotl18 = rotl4 ^ rotl(rotl17 + i33, 18);
                i29 = rotl11 ^ rotl(rotl8 + rotl, 7);
                i28 = rotl14 ^ rotl(i29 + rotl8, 9);
                int rotl19 = rotl(i28 + i29, 13) ^ rotl;
                i30 = rotl8 ^ rotl(rotl19 + i28, 18);
                i24 = rotl15 ^ rotl(rotl12 + rotl5, 7);
                int rotl20 = rotl(i24 + rotl12, 9) ^ rotl2;
                i26 = rotl5 ^ rotl(rotl20 + i24, 13);
                i25 = rotl12 ^ rotl(i26 + rotl20, 18);
                i23 = rotl3 ^ rotl(rotl16 + rotl9, 7);
                i22 = rotl6 ^ rotl(i23 + rotl16, 9);
                i21 = rotl9 ^ rotl(i22 + i23, 13);
                i20 = rotl16 ^ rotl(i21 + i22, 18);
                i32 = rotl17;
                i27 = rotl20;
                i35 = rotl18;
                i31 = rotl19;
                i17 = 13;
                i12 = 9;
                i9 = 7;
            }
            iArr2[0] = i35 + iArr[0];
            iArr2[1] = i34 + iArr[1];
            iArr2[2] = i33 + iArr[2];
            iArr2[3] = i32 + iArr[3];
            iArr2[4] = i31 + iArr[4];
            iArr2[5] = i30 + iArr[5];
            iArr2[6] = i29 + iArr[6];
            iArr2[7] = i28 + iArr[7];
            iArr2[8] = i27 + iArr[8];
            iArr2[9] = i26 + iArr[9];
            iArr2[10] = i25 + iArr[10];
            iArr2[11] = i24 + iArr[11];
            iArr2[12] = i23 + iArr[12];
            iArr2[13] = i22 + iArr[13];
            iArr2[14] = i21 + iArr[14];
            iArr2[15] = i20 + iArr[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i > 0) {
            int[] iArr = this.engineState;
            iArr[9] = iArr[9] + i;
        }
        int[] iArr2 = this.engineState;
        int i3 = iArr2[8];
        iArr2[8] = iArr2[8] + i2;
        if (i3 != 0 && iArr2[8] < i3) {
            iArr2[9] = iArr2[9] + 1;
        }
    }

    public void generateKeyStream(byte[] bArr) {
        salsaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        if (this.rounds == 20) {
            return "Salsa20";
        }
        StringBuilder Q = a.Q("Salsa20", "/");
        Q.append(this.rounds);
        return Q.toString();
    }

    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[9]) << 32) | (((long) iArr[8]) & BodyPartID.bodyIdMax);
    }

    public int getNonceSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long getPosition() {
        return (getCounter() * 64) + ((long) this.a);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != getNonceSize()) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
            }
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters == null) {
                if (this.c) {
                    setKey(null, iv);
                } else {
                    throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
                }
            } else if (parameters instanceof KeyParameter) {
                setKey(((KeyParameter) parameters).getKey(), iv);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            reset();
            this.c = true;
            return;
        }
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
    }

    public void packTauOrSigma(int i, int[] iArr, int i2) {
        int i3 = (i - 16) / 4;
        int[] iArr2 = g;
        iArr[i2] = iArr2[i3];
        iArr[i2 + 1] = iArr2[i3 + 1];
        iArr[i2 + 2] = iArr2[i3 + 2];
        iArr[i2 + 3] = iArr2[i3 + 3];
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[LOOP:0: B:16:0x002e->B:20:0x004f, LOOP_START, PHI: r1 
      PHI: (r1v3 int) = (r1v2 int), (r1v4 int) binds: [B:15:0x002c, B:20:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    @Override // org.spongycastle.crypto.StreamCipher
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int processBytes(byte[] r7, int r8, int r9, byte[] r10, int r11) {
        /*
            r6 = this;
            boolean r0 = r6.c
            if (r0 == 0) goto L_0x006b
            int r0 = r8 + r9
            int r1 = r7.length
            if (r0 > r1) goto L_0x0063
            int r0 = r11 + r9
            int r1 = r10.length
            if (r0 > r1) goto L_0x005b
            int r0 = r6.d
            int r0 = r0 + r9
            r6.d = r0
            r1 = 0
            r2 = 1
            if (r0 >= r9) goto L_0x002b
            if (r0 < 0) goto L_0x002b
            int r0 = r6.e
            int r0 = r0 + r2
            r6.e = r0
            if (r0 != 0) goto L_0x002b
            int r0 = r6.f
            int r0 = r0 + r2
            r6.f = r0
            r0 = r0 & 32
            if (r0 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 != 0) goto L_0x0053
        L_0x002e:
            if (r1 >= r9) goto L_0x0052
            int r0 = r1 + r11
            byte[] r3 = r6.b
            int r4 = r6.a
            byte r3 = r3[r4]
            int r5 = r1 + r8
            byte r5 = r7[r5]
            r3 = r3 ^ r5
            byte r3 = (byte) r3
            r10[r0] = r3
            int r4 = r4 + r2
            r0 = r4 & 63
            r6.a = r0
            if (r0 != 0) goto L_0x004f
            r6.advanceCounter()
            byte[] r0 = r6.b
            r6.generateKeyStream(r0)
        L_0x004f:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0052:
            return r9
        L_0x0053:
            org.spongycastle.crypto.MaxBytesExceededException r7 = new org.spongycastle.crypto.MaxBytesExceededException
            java.lang.String r8 = "2^70 byte limit per IV would be exceeded; Change IV"
            r7.<init>(r8)
            throw r7
        L_0x005b:
            org.spongycastle.crypto.OutputLengthException r7 = new org.spongycastle.crypto.OutputLengthException
            java.lang.String r8 = "output buffer too short"
            r7.<init>(r8)
            throw r7
        L_0x0063:
            org.spongycastle.crypto.DataLengthException r7 = new org.spongycastle.crypto.DataLengthException
            java.lang.String r8 = "input buffer too short"
            r7.<init>(r8)
            throw r7
        L_0x006b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r6.getAlgorithmName()
            r8.append(r9)
            java.lang.String r9 = " not initialised"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.Salsa20Engine.processBytes(byte[], int, int, byte[], int):int");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        this.a = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        resetCounter();
        generateKeyStream(this.b);
    }

    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    public void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i != 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[9]) & BodyPartID.bodyIdMax) >= (((long) i) & BodyPartID.bodyIdMax)) {
                iArr[9] = iArr[9] - i;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((((long) iArr2[8]) & BodyPartID.bodyIdMax) >= (BodyPartID.bodyIdMax & ((long) i2))) {
            iArr2[8] = iArr2[8] - i2;
        } else if (iArr2[9] != 0) {
            iArr2[9] = iArr2[9] - 1;
            iArr2[8] = iArr2[8] - i2;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        int i = this.d + 1;
        this.d = i;
        boolean z = false;
        if (i == 0) {
            int i2 = this.e + 1;
            this.e = i2;
            if (i2 == 0) {
                int i3 = this.f + 1;
                this.f = i3;
                if ((i3 & 32) != 0) {
                    z = true;
                }
            }
        }
        if (!z) {
            byte[] bArr = this.b;
            int i4 = this.a;
            byte b3 = (byte) (b2 ^ bArr[i4]);
            int i5 = (i4 + 1) & 63;
            this.a = i5;
            if (i5 == 0) {
                advanceCounter();
                generateKeyStream(this.b);
            }
            return b3;
        }
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long seekTo(long j) {
        reset();
        return skip(j);
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                int length = (bArr.length - 16) / 4;
                int[] iArr = this.engineState;
                int[] iArr2 = g;
                iArr[0] = iArr2[length];
                iArr[5] = iArr2[length + 1];
                iArr[10] = iArr2[length + 2];
                iArr[15] = iArr2[length + 3];
                Pack.littleEndianToInt(bArr, 0, iArr, 1, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 11, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 6, 2);
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long skip(long j) {
        long j2;
        if (j >= 0) {
            if (j >= 64) {
                long j3 = j / 64;
                advanceCounter(j3);
                j2 = j - (j3 * 64);
            } else {
                j2 = j;
            }
            int i = this.a;
            int i2 = (((int) j2) + i) & 63;
            this.a = i2;
            if (i2 < i) {
                advanceCounter();
            }
        } else {
            long j4 = -j;
            if (j4 >= 64) {
                long j5 = j4 / 64;
                retreatCounter(j5);
                j4 -= j5 * 64;
            }
            for (long j6 = 0; j6 < j4; j6++) {
                if (this.a == 0) {
                    retreatCounter();
                }
                this.a = (this.a - 1) & 63;
            }
        }
        generateKeyStream(this.b);
        return j;
    }

    public Salsa20Engine(int i) {
        this.a = 0;
        this.engineState = new int[16];
        this.x = new int[16];
        this.b = new byte[64];
        this.c = false;
        if (i <= 0 || (i & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.rounds = i;
    }

    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[8] + 1;
        iArr[8] = i;
        if (i == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[8] == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i = iArr[8] - 1;
        iArr[8] = i;
        if (i == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }
}
