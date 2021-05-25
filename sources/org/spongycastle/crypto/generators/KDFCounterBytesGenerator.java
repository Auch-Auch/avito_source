package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFCounterParameters;
import org.spongycastle.crypto.params.KeyParameter;
public class KDFCounterBytesGenerator implements MacDerivationFunction {
    public static final BigInteger i = BigInteger.valueOf(2147483647L);
    public static final BigInteger j = BigInteger.valueOf(2);
    public final Mac a;
    public final int b;
    public byte[] c;
    public byte[] d;
    public int e;
    public byte[] f;
    public int g;
    public byte[] h;

    public KDFCounterBytesGenerator(Mac mac) {
        this.a = mac;
        int macSize = mac.getMacSize();
        this.b = macSize;
        this.h = new byte[macSize];
    }

    public final void a() {
        int i2 = (this.g / this.b) + 1;
        byte[] bArr = this.f;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length == 4) {
                        bArr[0] = (byte) (i2 >>> 24);
                    } else {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                }
                bArr[bArr.length - 3] = (byte) (i2 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i2 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i2;
        Mac mac = this.a;
        byte[] bArr2 = this.c;
        mac.update(bArr2, 0, bArr2.length);
        Mac mac2 = this.a;
        byte[] bArr3 = this.f;
        mac2.update(bArr3, 0, bArr3.length);
        Mac mac3 = this.a;
        byte[] bArr4 = this.d;
        mac3.update(bArr4, 0, bArr4.length);
        this.a.doFinal(this.h, 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = this.g;
        int i5 = i4 + i3;
        if (i5 < 0 || i5 >= this.e) {
            throw new DataLengthException(a.j(a.L("Current KDFCTR may only be used for "), this.e, " bytes"));
        }
        if (i4 % this.b == 0) {
            a();
        }
        int i6 = this.g;
        int i7 = this.b;
        int i8 = i6 % i7;
        int min = Math.min(i7 - (i6 % i7), i3);
        System.arraycopy(this.h, i8, bArr, i2, min);
        this.g += min;
        int i9 = i3 - min;
        while (true) {
            i2 += min;
            if (i9 <= 0) {
                return i3;
            }
            a();
            min = Math.min(this.b, i9);
            System.arraycopy(this.h, 0, bArr, i2, min);
            this.g += min;
            i9 -= min;
        }
    }

    @Override // org.spongycastle.crypto.MacDerivationFunction
    public Mac getMac() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        int i2;
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.a.init(new KeyParameter(kDFCounterParameters.getKI()));
            this.c = kDFCounterParameters.getFixedInputDataCounterPrefix();
            this.d = kDFCounterParameters.getFixedInputDataCounterSuffix();
            int r = kDFCounterParameters.getR();
            this.f = new byte[(r / 8)];
            BigInteger multiply = j.pow(r).multiply(BigInteger.valueOf((long) this.b));
            if (multiply.compareTo(i) == 1) {
                i2 = Integer.MAX_VALUE;
            } else {
                i2 = multiply.intValue();
            }
            this.e = i2;
            this.g = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
