package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public class HMacDSAKCalculator implements DSAKCalculator {
    public static final BigInteger e = BigInteger.valueOf(0);
    public final HMac a;
    public final byte[] b;
    public final byte[] c;
    public BigInteger d;

    public HMacDSAKCalculator(Digest digest) {
        HMac hMac = new HMac(digest);
        this.a = hMac;
        this.c = new byte[hMac.getMacSize()];
        this.b = new byte[hMac.getMacSize()];
    }

    public final BigInteger a(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return bArr.length * 8 > this.d.bitLength() ? bigInteger.shiftRight((bArr.length * 8) - this.d.bitLength()) : bigInteger;
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public boolean isDeterministic() {
        return true;
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public BigInteger nextK() {
        int bitLength = (this.d.bitLength() + 7) / 8;
        byte[] bArr = new byte[bitLength];
        while (true) {
            int i = 0;
            while (i < bitLength) {
                HMac hMac = this.a;
                byte[] bArr2 = this.c;
                hMac.update(bArr2, 0, bArr2.length);
                this.a.doFinal(this.c, 0);
                int min = Math.min(bitLength - i, this.c.length);
                System.arraycopy(this.c, 0, bArr, i, min);
                i += min;
            }
            BigInteger a3 = a(bArr);
            if (a3.compareTo(e) > 0 && a3.compareTo(this.d) < 0) {
                return a3;
            }
            HMac hMac2 = this.a;
            byte[] bArr3 = this.c;
            hMac2.update(bArr3, 0, bArr3.length);
            this.a.update((byte) 0);
            this.a.doFinal(this.b, 0);
            this.a.init(new KeyParameter(this.b));
            HMac hMac3 = this.a;
            byte[] bArr4 = this.c;
            hMac3.update(bArr4, 0, bArr4.length);
            this.a.doFinal(this.c, 0);
        }
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.d = bigInteger;
        Arrays.fill(this.c, (byte) 1);
        Arrays.fill(this.b, (byte) 0);
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr2 = new byte[bitLength];
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger2);
        System.arraycopy(asUnsignedByteArray, 0, bArr2, bitLength - asUnsignedByteArray.length, asUnsignedByteArray.length);
        int bitLength2 = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr3 = new byte[bitLength2];
        BigInteger a3 = a(bArr);
        if (a3.compareTo(bigInteger) >= 0) {
            a3 = a3.subtract(bigInteger);
        }
        byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(a3);
        System.arraycopy(asUnsignedByteArray2, 0, bArr3, bitLength2 - asUnsignedByteArray2.length, asUnsignedByteArray2.length);
        this.a.init(new KeyParameter(this.b));
        HMac hMac = this.a;
        byte[] bArr4 = this.c;
        hMac.update(bArr4, 0, bArr4.length);
        this.a.update((byte) 0);
        this.a.update(bArr2, 0, bitLength);
        this.a.update(bArr3, 0, bitLength2);
        this.a.doFinal(this.b, 0);
        this.a.init(new KeyParameter(this.b));
        HMac hMac2 = this.a;
        byte[] bArr5 = this.c;
        hMac2.update(bArr5, 0, bArr5.length);
        this.a.doFinal(this.c, 0);
        HMac hMac3 = this.a;
        byte[] bArr6 = this.c;
        hMac3.update(bArr6, 0, bArr6.length);
        this.a.update((byte) 1);
        this.a.update(bArr2, 0, bitLength);
        this.a.update(bArr3, 0, bitLength2);
        this.a.doFinal(this.b, 0);
        this.a.init(new KeyParameter(this.b));
        HMac hMac4 = this.a;
        byte[] bArr7 = this.c;
        hMac4.update(bArr7, 0, bArr7.length);
        this.a.doFinal(this.c, 0);
    }
}
