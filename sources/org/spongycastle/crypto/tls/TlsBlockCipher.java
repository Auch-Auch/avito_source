package org.spongycastle.crypto.tls;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class TlsBlockCipher implements TlsCipher {
    public TlsContext context;
    public BlockCipher decryptCipher;
    public BlockCipher encryptCipher;
    public boolean encryptThenMAC;
    public byte[] randomData = new byte[256];
    public TlsMac readMac;
    public boolean useExplicitIV;
    public TlsMac writeMac;

    public TlsBlockCipher(TlsContext tlsContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        this.context = tlsContext;
        tlsContext.getNonceRandomGenerator().nextBytes(this.randomData);
        this.useExplicitIV = TlsUtils.isTLSv11(tlsContext);
        this.encryptThenMAC = tlsContext.getSecurityParameters().n;
        int digestSize = digest2.getDigestSize() + digest.getDigestSize() + (i * 2);
        if (!this.useExplicitIV) {
            digestSize += blockCipher2.getBlockSize() + blockCipher.getBlockSize();
        }
        byte[] b = TlsUtils.b(tlsContext, digestSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, b, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, b, digestSize2, digest2.getDigestSize());
        int digestSize3 = digest2.getDigestSize() + digestSize2;
        KeyParameter keyParameter = new KeyParameter(b, digestSize3, i);
        int i2 = digestSize3 + i;
        KeyParameter keyParameter2 = new KeyParameter(b, i2, i);
        int i3 = i2 + i;
        if (this.useExplicitIV) {
            bArr2 = new byte[blockCipher.getBlockSize()];
            bArr = new byte[blockCipher2.getBlockSize()];
        } else {
            bArr2 = Arrays.copyOfRange(b, i3, blockCipher.getBlockSize() + i3);
            int blockSize = blockCipher.getBlockSize() + i3;
            byte[] copyOfRange = Arrays.copyOfRange(b, blockSize, blockCipher2.getBlockSize() + blockSize);
            int blockSize2 = blockSize + blockCipher2.getBlockSize();
            bArr = copyOfRange;
            i3 = blockSize2;
        }
        if (i3 == digestSize) {
            if (tlsContext.isServer()) {
                this.writeMac = tlsMac2;
                this.readMac = tlsMac;
                this.encryptCipher = blockCipher2;
                this.decryptCipher = blockCipher;
                parametersWithIV2 = new ParametersWithIV(keyParameter2, bArr);
                parametersWithIV = new ParametersWithIV(keyParameter, bArr2);
            } else {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                this.encryptCipher = blockCipher;
                this.decryptCipher = blockCipher2;
                parametersWithIV2 = new ParametersWithIV(keyParameter, bArr2);
                parametersWithIV = new ParametersWithIV(keyParameter2, bArr);
            }
            this.encryptCipher.init(true, parametersWithIV2);
            this.decryptCipher.init(false, parametersWithIV);
            return;
        }
        throw new TlsFatalAlert(80);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r8 != 0) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int checkPaddingConstantTime(byte[] r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            int r6 = r6 + r7
            int r0 = r6 + -1
            byte r0 = r5[r0]
            r1 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 + 1
            org.spongycastle.crypto.tls.TlsContext r2 = r4.context
            boolean r2 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0014
            if (r1 > r8) goto L_0x0017
        L_0x0014:
            int r9 = r9 + r1
            if (r9 <= r7) goto L_0x001b
        L_0x0017:
            r5 = 0
            r8 = 0
        L_0x0019:
            r1 = 0
            goto L_0x002b
        L_0x001b:
            int r7 = r6 - r1
            r8 = 0
        L_0x001e:
            int r9 = r7 + 1
            byte r7 = r5[r7]
            r7 = r7 ^ r0
            r7 = r7 | r8
            byte r8 = (byte) r7
            if (r9 < r6) goto L_0x0041
            r5 = r1
            if (r8 == 0) goto L_0x002b
            goto L_0x0019
        L_0x002b:
            byte[] r6 = r4.randomData
        L_0x002d:
            r7 = 256(0x100, float:3.59E-43)
            if (r5 >= r7) goto L_0x003a
            int r7 = r5 + 1
            byte r5 = r6[r5]
            r5 = r5 ^ r0
            r5 = r5 | r8
            byte r8 = (byte) r5
            r5 = r7
            goto L_0x002d
        L_0x003a:
            byte r5 = r6[r3]
            r5 = r5 ^ r8
            byte r5 = (byte) r5
            r6[r3] = r5
            return r1
        L_0x0041:
            r7 = r9
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsBlockCipher.checkPaddingConstantTime(byte[], int, int, int, int):int");
    }

    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2;
        int i5 = i;
        int blockSize = this.decryptCipher.getBlockSize();
        int size = this.readMac.getSize();
        if (this.encryptThenMAC) {
            i3 = blockSize + size;
        } else {
            i3 = Math.max(blockSize, size + 1);
        }
        if (this.useExplicitIV) {
            i3 += blockSize;
        }
        if (i2 >= i3) {
            boolean z = this.encryptThenMAC;
            int i6 = z ? i2 - size : i2;
            if (i6 % blockSize == 0) {
                if (z) {
                    int i7 = i5 + i2;
                    if (!Arrays.constantTimeAreEqual(this.readMac.calculateMac(j, s, bArr, i, i2 - size), Arrays.copyOfRange(bArr, i7 - size, i7))) {
                        throw new TlsFatalAlert(20);
                    }
                }
                if (this.useExplicitIV) {
                    this.decryptCipher.init(false, new ParametersWithIV(null, bArr, i5, blockSize));
                    i5 += blockSize;
                    i6 -= blockSize;
                }
                for (int i8 = 0; i8 < i6; i8 += blockSize) {
                    int i9 = i5 + i8;
                    this.decryptCipher.processBlock(bArr, i9, bArr, i9);
                }
                int checkPaddingConstantTime = checkPaddingConstantTime(bArr, i5, i6, blockSize, this.encryptThenMAC ? 0 : size);
                boolean z2 = checkPaddingConstantTime == 0;
                int i10 = i6 - checkPaddingConstantTime;
                if (!this.encryptThenMAC) {
                    i10 -= size;
                    int i11 = i5 + i10;
                    i4 = i5;
                    bArr2 = bArr;
                    z2 |= !Arrays.constantTimeAreEqual(this.readMac.calculateMacConstantTime(j, s, bArr, i5, i10, i6 - size, this.randomData), Arrays.copyOfRange(bArr, i11, i11 + size));
                } else {
                    i4 = i5;
                    bArr2 = bArr;
                }
                if (!z2) {
                    return Arrays.copyOfRange(bArr2, i4, i4 + i10);
                }
                throw new TlsFatalAlert(20);
            }
            throw new TlsFatalAlert(21);
        }
        throw new TlsFatalAlert(50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        ProtocolVersion serverVersion = this.context.getServerVersion();
        boolean z = this.encryptThenMAC;
        int i5 = (blockSize - 1) - ((!z ? i2 + size : i2) % blockSize);
        if ((z || !this.context.getSecurityParameters().m) && !serverVersion.isDTLS() && !serverVersion.isSSL()) {
            i5 += chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - i5) / blockSize) * blockSize;
        }
        int G1 = a.G1(size, i2, i5, 1);
        boolean z2 = this.useExplicitIV;
        if (z2) {
            G1 += blockSize;
        }
        byte[] bArr3 = new byte[G1];
        if (z2) {
            byte[] bArr4 = new byte[blockSize];
            this.context.getNonceRandomGenerator().nextBytes(bArr4);
            this.encryptCipher.init(true, new ParametersWithIV(null, bArr4));
            System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            bArr2 = bArr;
            i4 = i;
            i3 = blockSize + 0;
        } else {
            bArr2 = bArr;
            i4 = i;
            i3 = 0;
        }
        System.arraycopy(bArr2, i4, bArr3, i3, i2);
        int i6 = i3 + i2;
        if (!this.encryptThenMAC) {
            byte[] calculateMac = this.writeMac.calculateMac(j, s, bArr, i, i2);
            System.arraycopy(calculateMac, 0, bArr3, i6, calculateMac.length);
            i6 += calculateMac.length;
        }
        for (int i7 = 0; i7 <= i5; i7++) {
            i6++;
            bArr3[i6] = (byte) i5;
        }
        while (i3 < i6) {
            this.encryptCipher.processBlock(bArr3, i3, bArr3, i3);
            i3 += blockSize;
        }
        if (!this.encryptThenMAC) {
            return bArr3;
        }
        byte[] calculateMac2 = this.writeMac.calculateMac(j, s, bArr3, 0, i6);
        System.arraycopy(calculateMac2, 0, bArr3, i6, calculateMac2.length);
        return bArr3;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i) {
        int i2;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        if (this.useExplicitIV) {
            i -= blockSize;
        }
        if (this.encryptThenMAC) {
            int i3 = i - size;
            i2 = i3 - (i3 % blockSize);
        } else {
            i2 = (i - (i % blockSize)) - size;
        }
        return i2 - 1;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }
}
