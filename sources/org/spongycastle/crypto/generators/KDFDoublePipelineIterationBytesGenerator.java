package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.spongycastle.crypto.params.KeyParameter;
public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {
    public static final BigInteger j = BigInteger.valueOf(2147483647L);
    public static final BigInteger k = BigInteger.valueOf(2);
    public final Mac a;
    public final int b;
    public byte[] c;
    public int d;
    public byte[] e;
    public boolean f;
    public int g;
    public byte[] h;
    public byte[] i;

    public KDFDoublePipelineIterationBytesGenerator(Mac mac) {
        this.a = mac;
        int macSize = mac.getMacSize();
        this.b = macSize;
        this.h = new byte[macSize];
        this.i = new byte[macSize];
    }

    public final void a() {
        if (this.g == 0) {
            Mac mac = this.a;
            byte[] bArr = this.c;
            mac.update(bArr, 0, bArr.length);
            this.a.doFinal(this.h, 0);
        } else {
            Mac mac2 = this.a;
            byte[] bArr2 = this.h;
            mac2.update(bArr2, 0, bArr2.length);
            this.a.doFinal(this.h, 0);
        }
        Mac mac3 = this.a;
        byte[] bArr3 = this.h;
        mac3.update(bArr3, 0, bArr3.length);
        if (this.f) {
            int i2 = (this.g / this.b) + 1;
            byte[] bArr4 = this.e;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length == 4) {
                            bArr4[0] = (byte) (i2 >>> 24);
                        } else {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                    }
                    bArr4[bArr4.length - 3] = (byte) (i2 >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i2 >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i2;
            this.a.update(bArr4, 0, bArr4.length);
        }
        Mac mac4 = this.a;
        byte[] bArr5 = this.c;
        mac4.update(bArr5, 0, bArr5.length);
        this.a.doFinal(this.i, 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = this.g;
        int i5 = i4 + i3;
        if (i5 < 0 || i5 >= this.d) {
            throw new DataLengthException(a.j(a.L("Current KDFCTR may only be used for "), this.d, " bytes"));
        }
        if (i4 % this.b == 0) {
            a();
        }
        int i6 = this.g;
        int i7 = this.b;
        int i8 = i6 % i7;
        int min = Math.min(i7 - (i6 % i7), i3);
        System.arraycopy(this.i, i8, bArr, i2, min);
        this.g += min;
        int i9 = i3 - min;
        while (true) {
            i2 += min;
            if (i9 <= 0) {
                return i3;
            }
            a();
            min = Math.min(this.b, i9);
            System.arraycopy(this.i, 0, bArr, i2, min);
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
        if (derivationParameters instanceof KDFDoublePipelineIterationParameters) {
            KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
            this.a.init(new KeyParameter(kDFDoublePipelineIterationParameters.getKI()));
            this.c = kDFDoublePipelineIterationParameters.getFixedInputData();
            int r = kDFDoublePipelineIterationParameters.getR();
            this.e = new byte[(r / 8)];
            int i2 = Integer.MAX_VALUE;
            if (kDFDoublePipelineIterationParameters.useCounter()) {
                BigInteger multiply = k.pow(r).multiply(BigInteger.valueOf((long) this.b));
                if (multiply.compareTo(j) != 1) {
                    i2 = multiply.intValue();
                }
                this.d = i2;
            } else {
                this.d = Integer.MAX_VALUE;
            }
            this.f = kDFDoublePipelineIterationParameters.useCounter();
            this.g = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
