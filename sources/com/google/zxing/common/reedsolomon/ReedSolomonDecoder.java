package com.google.zxing.common.reedsolomon;

import a2.j.k.c.a.a;
import java.util.Objects;
public final class ReedSolomonDecoder {
    public final GenericGF a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.a = genericGF;
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        a aVar = new a(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            GenericGF genericGF = this.a;
            int b = aVar.b(genericGF.a[genericGF.getGeneratorBase() + i2]);
            iArr3[(i - 1) - i2] = b;
            if (b != 0) {
                z = false;
            }
        }
        if (!z) {
            a aVar2 = new a(this.a, iArr3);
            a a3 = this.a.a(i, 1);
            if (a3.d() < aVar2.d()) {
                a3 = aVar2;
                aVar2 = a3;
            }
            GenericGF genericGF2 = this.a;
            a aVar3 = genericGF2.c;
            a aVar4 = genericGF2.d;
            a aVar5 = aVar3;
            while (aVar2.d() >= i / 2) {
                if (!aVar2.e()) {
                    a aVar6 = this.a.c;
                    int b2 = this.a.b(aVar2.c(aVar2.d()));
                    while (a3.d() >= aVar2.d() && !a3.e()) {
                        int d = a3.d() - aVar2.d();
                        int c = this.a.c(a3.c(a3.d()), b2);
                        aVar6 = aVar6.a(this.a.a(d, c));
                        a3 = a3.a(aVar2.h(d, c));
                    }
                    a a4 = aVar6.g(aVar4).a(aVar5);
                    if (a3.d() < aVar2.d()) {
                        a3 = aVar2;
                        aVar2 = a3;
                        aVar4 = a4;
                        aVar5 = aVar4;
                    } else {
                        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                    }
                } else {
                    throw new ReedSolomonException("r_{i-1} was zero");
                }
            }
            int c2 = aVar4.c(0);
            if (c2 != 0) {
                int b3 = this.a.b(c2);
                a[] aVarArr = {aVar4.f(b3), aVar2.f(b3)};
                a aVar7 = aVarArr[0];
                a aVar8 = aVarArr[1];
                int d2 = aVar7.d();
                if (d2 == 1) {
                    iArr2 = new int[]{aVar7.c(1)};
                } else {
                    int[] iArr4 = new int[d2];
                    int i3 = 0;
                    for (int i4 = 1; i4 < this.a.getSize() && i3 < d2; i4++) {
                        if (aVar7.b(i4) == 0) {
                            iArr4[i3] = this.a.b(i4);
                            i3++;
                        }
                    }
                    if (i3 == d2) {
                        iArr2 = iArr4;
                    } else {
                        throw new ReedSolomonException("Error locator degree does not match number of roots");
                    }
                }
                int length = iArr2.length;
                int[] iArr5 = new int[length];
                for (int i5 = 0; i5 < length; i5++) {
                    int b4 = this.a.b(iArr2[i5]);
                    int i6 = 1;
                    for (int i7 = 0; i7 < length; i7++) {
                        if (i5 != i7) {
                            int c3 = this.a.c(iArr2[i7], b4);
                            i6 = this.a.c(i6, (c3 & 1) == 0 ? c3 | 1 : c3 & -2);
                        }
                    }
                    iArr5[i5] = this.a.c(aVar8.b(b4), this.a.b(i6));
                    if (this.a.getGeneratorBase() != 0) {
                        iArr5[i5] = this.a.c(iArr5[i5], b4);
                    }
                }
                for (int i8 = 0; i8 < iArr2.length; i8++) {
                    int length2 = iArr.length - 1;
                    GenericGF genericGF3 = this.a;
                    int i9 = iArr2[i8];
                    Objects.requireNonNull(genericGF3);
                    if (i9 != 0) {
                        int i10 = length2 - genericGF3.b[i9];
                        if (i10 >= 0) {
                            iArr[i10] = iArr[i10] ^ iArr5[i8];
                        } else {
                            throw new ReedSolomonException("Bad error location");
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return;
            }
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
    }
}
