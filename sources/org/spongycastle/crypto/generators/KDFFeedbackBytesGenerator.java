package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFFeedbackParameters;
import org.spongycastle.crypto.params.KeyParameter;
public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    public static final BigInteger j = BigInteger.valueOf(2147483647L);
    public static final BigInteger k = BigInteger.valueOf(2);
    public final Mac a;
    public final int b;
    public byte[] c;
    public int d;
    public byte[] e;
    public byte[] f;
    public boolean g;
    public int h;
    public byte[] i;

    public KDFFeedbackBytesGenerator(Mac mac) {
        this.a = mac;
        int macSize = mac.getMacSize();
        this.b = macSize;
        this.i = new byte[macSize];
    }

    public final void a() {
        if (this.h == 0) {
            Mac mac = this.a;
            byte[] bArr = this.f;
            mac.update(bArr, 0, bArr.length);
        } else {
            Mac mac2 = this.a;
            byte[] bArr2 = this.i;
            mac2.update(bArr2, 0, bArr2.length);
        }
        if (this.g) {
            int i2 = (this.h / this.b) + 1;
            byte[] bArr3 = this.e;
            int length = bArr3.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length == 4) {
                            bArr3[0] = (byte) (i2 >>> 24);
                        } else {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                    }
                    bArr3[bArr3.length - 3] = (byte) (i2 >>> 16);
                }
                bArr3[bArr3.length - 2] = (byte) (i2 >>> 8);
            }
            bArr3[bArr3.length - 1] = (byte) i2;
            this.a.update(bArr3, 0, bArr3.length);
        }
        Mac mac3 = this.a;
        byte[] bArr4 = this.c;
        mac3.update(bArr4, 0, bArr4.length);
        this.a.doFinal(this.i, 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = this.h;
        int i5 = i4 + i3;
        if (i5 < 0 || i5 >= this.d) {
            throw new DataLengthException(a.j(a.L("Current KDFCTR may only be used for "), this.d, " bytes"));
        }
        if (i4 % this.b == 0) {
            a();
        }
        int i6 = this.h;
        int i7 = this.b;
        int i8 = i6 % i7;
        int min = Math.min(i7 - (i6 % i7), i3);
        System.arraycopy(this.i, i8, bArr, i2, min);
        this.h += min;
        int i9 = i3 - min;
        while (true) {
            i2 += min;
            if (i9 <= 0) {
                return i3;
            }
            a();
            min = Math.min(this.b, i9);
            System.arraycopy(this.i, 0, bArr, i2, min);
            this.h += min;
            i9 -= min;
        }
    }

    @Override // org.spongycastle.crypto.MacDerivationFunction
    public Mac getMac() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFFeedbackParameters) {
            KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
            this.a.init(new KeyParameter(kDFFeedbackParameters.getKI()));
            this.c = kDFFeedbackParameters.getFixedInputData();
            int r = kDFFeedbackParameters.getR();
            this.e = new byte[(r / 8)];
            int i2 = Integer.MAX_VALUE;
            if (kDFFeedbackParameters.useCounter()) {
                BigInteger multiply = k.pow(r).multiply(BigInteger.valueOf((long) this.b));
                if (multiply.compareTo(j) != 1) {
                    i2 = multiply.intValue();
                }
                this.d = i2;
            } else {
                this.d = Integer.MAX_VALUE;
            }
            this.f = kDFFeedbackParameters.getIV();
            this.g = kDFFeedbackParameters.useCounter();
            this.h = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
