package org.spongycastle.pqc.crypto.newhope;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.security.SecureRandom;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ExchangePair;
import org.spongycastle.pqc.crypto.ExchangePairGenerator;
import x6.e.f.a.b.a;
public class NHExchangePairGenerator implements ExchangePairGenerator {
    public final SecureRandom a;

    public NHExchangePairGenerator(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    @Override // org.spongycastle.pqc.crypto.ExchangePairGenerator
    public ExchangePair GenerateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        return generateExchange(asymmetricKeyParameter);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c3: APUT  
      (r15v0 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x00c1: ARITH  (r22v2 int) = (wrap: int : 0x00b9: ARITH  (r22v1 int) = (r10v11 int) & (wrap: int : 0x00b7: AGET  (r22v0 int) = (r8v2 int[]), (0 ??[int, short, byte, char]))) ^ (wrap: int : 0x00bf: ARITH  (r25v1 int) = (r6v8 int) & (wrap: int : 0x00bd: AGET  (r25v0 int) = (r8v2 int[]), (4 ??[int, float, short, byte, char]))))
     */
    @Override // org.spongycastle.pqc.crypto.ExchangePairGenerator
    public ExchangePair generateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[2048];
        SecureRandom secureRandom = this.a;
        byte[] bArr3 = ((NHPublicKeyParameters) asymmetricKeyParameter).b;
        short[] sArr = new short[1024];
        byte[] bArr4 = new byte[32];
        a.c(sArr, bArr3);
        int i = 0;
        System.arraycopy(bArr3, 1792, bArr4, 0, 32);
        short[] sArr2 = new short[1024];
        AppCompatDelegateImpl.i.o0(sArr2, bArr4);
        byte[] bArr5 = new byte[32];
        secureRandom.nextBytes(bArr5);
        short[] sArr3 = new short[1024];
        a.f(sArr3, bArr5, (byte) 0);
        a.k(sArr3);
        short[] sArr4 = new short[1024];
        int i2 = 1;
        a.f(sArr4, bArr5, (byte) 1);
        a.k(sArr4);
        short[] sArr5 = new short[1024];
        a.h(sArr2, sArr3, sArr5);
        a.a(sArr5, sArr4, sArr5);
        short[] sArr6 = new short[1024];
        a.h(sArr, sArr3, sArr6);
        a.d(sArr6);
        short[] sArr7 = new short[1024];
        a.f(sArr7, bArr5, (byte) 2);
        a.a(sArr6, sArr7, sArr6);
        short[] sArr8 = new short[1024];
        byte[] bArr6 = new byte[8];
        bArr6[0] = 3;
        byte[] bArr7 = new byte[32];
        AppCompatDelegateImpl.i.E1(bArr5, bArr6, bArr7, 0, 32);
        int[] iArr = new int[8];
        int i3 = 4;
        int[] iArr2 = new int[4];
        int i4 = 0;
        while (i4 < 256) {
            int i5 = i4 + 0;
            int i6 = ((bArr7[i4 >>> 3] >>> (i4 & 7)) & i2) * 4;
            int b = a.b(iArr, i, i3, (sArr6[i5] * 8) + i6);
            int i7 = i4 + 256;
            int b2 = a.b(iArr, i2, 5, (sArr6[i7] * 8) + i6) + b;
            int i8 = i4 + 512;
            int i9 = i4 + 768;
            int b3 = (24577 - (a.b(iArr, 3, 7, (sArr6[i9] * 8) + i6) + (a.b(iArr, 2, 6, (sArr6[i8] * 8) + i6) + b2))) >> 31;
            int i10 = ~b3;
            iArr2[0] = (i10 & iArr[0]) ^ (b3 & iArr[4]);
            iArr2[1] = (i10 & iArr[1]) ^ (b3 & iArr[5]);
            iArr2[2] = (i10 & iArr[2]) ^ (b3 & iArr[6]);
            iArr2[3] = (i10 & iArr[3]) ^ (iArr[7] & b3);
            sArr8[i5] = (short) ((iArr2[0] - iArr2[3]) & 3);
            sArr8[i7] = (short) ((iArr2[1] - iArr2[3]) & 3);
            sArr8[i8] = (short) ((iArr2[2] - iArr2[3]) & 3);
            sArr8[i9] = (short) (((iArr2[3] * 2) + (-b3)) & 3);
            i4++;
            i3 = 4;
            i = 0;
            i2 = 1;
        }
        a.j(bArr2, sArr5);
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = i11 * 4;
            bArr2[i11 + 1792] = (byte) ((sArr8[i12 + 3] << 6) | sArr8[i12] | (sArr8[i12 + 1] << 2) | (sArr8[i12 + 2] << 4));
        }
        a.i(bArr, sArr6, sArr8);
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.update(bArr, 0, 32);
        sHA3Digest.doFinal(bArr, 0);
        return new ExchangePair(new NHPublicKeyParameters(bArr2), bArr);
    }
}
