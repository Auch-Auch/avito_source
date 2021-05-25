package com.google.zxing.pdf417.decoder.ec;

import a2.j.k.h.a.j.a;
import com.google.zxing.ChecksumException;
import java.util.Objects;
public final class ErrorCorrection {
    public final ModulusGF a = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        a aVar;
        a aVar2 = new a(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int b = aVar2.b(this.a.a[i2]);
            iArr3[i - i2] = b;
            if (b != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        a aVar3 = this.a.d;
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                ModulusGF modulusGF = this.a;
                aVar3 = aVar3.g(new a(modulusGF, new int[]{modulusGF.e(0, modulusGF.a[(iArr.length - 1) - i3]), 1}));
            }
        }
        a aVar4 = new a(this.a, iArr3);
        a b2 = this.a.b(i, 1);
        if (b2.d() >= aVar4.d()) {
            b2 = aVar4;
            aVar4 = b2;
        }
        ModulusGF modulusGF2 = this.a;
        a aVar5 = modulusGF2.c;
        a aVar6 = modulusGF2.d;
        while (true) {
            b2 = aVar4;
            aVar4 = b2;
            aVar5 = aVar6;
            if (aVar4.d() < i / 2) {
                int c = aVar5.c(0);
                if (c != 0) {
                    int c2 = this.a.c(c);
                    a[] aVarArr = {aVar5.f(c2), aVar4.f(c2)};
                    a aVar7 = aVarArr[0];
                    a aVar8 = aVarArr[1];
                    int d = aVar7.d();
                    int[] iArr4 = new int[d];
                    int i4 = 0;
                    for (int i5 = 1; i5 < this.a.e && i4 < d; i5++) {
                        if (aVar7.b(i5) == 0) {
                            iArr4[i4] = this.a.c(i5);
                            i4++;
                        }
                    }
                    if (i4 == d) {
                        int d2 = aVar7.d();
                        int[] iArr5 = new int[d2];
                        for (int i6 = 1; i6 <= d2; i6++) {
                            iArr5[d2 - i6] = this.a.d(i6, aVar7.c(i6));
                        }
                        a aVar9 = new a(this.a, iArr5);
                        int[] iArr6 = new int[d];
                        for (int i7 = 0; i7 < d; i7++) {
                            int c3 = this.a.c(iArr4[i7]);
                            iArr6[i7] = this.a.d(this.a.e(0, aVar8.b(c3)), this.a.c(aVar9.b(c3)));
                        }
                        for (int i8 = 0; i8 < d; i8++) {
                            int length = iArr.length - 1;
                            ModulusGF modulusGF3 = this.a;
                            int i9 = iArr4[i8];
                            Objects.requireNonNull(modulusGF3);
                            if (i9 != 0) {
                                int i10 = length - modulusGF3.b[i9];
                                if (i10 >= 0) {
                                    iArr[i10] = this.a.e(iArr[i10], iArr6[i8]);
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        return d;
                    }
                    throw ChecksumException.getChecksumInstance();
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!aVar4.e()) {
                a aVar10 = this.a.c;
                int c4 = this.a.c(aVar4.c(aVar4.d()));
                while (b2.d() >= aVar4.d() && !b2.e()) {
                    int d3 = b2.d() - aVar4.d();
                    int d4 = this.a.d(b2.c(b2.d()), c4);
                    aVar10 = aVar10.a(this.a.b(d3, d4));
                    if (d3 >= 0) {
                        if (d4 == 0) {
                            aVar = aVar4.a.c;
                        } else {
                            int length2 = aVar4.b.length;
                            int[] iArr7 = new int[(d3 + length2)];
                            for (int i11 = 0; i11 < length2; i11++) {
                                iArr7[i11] = aVar4.a.d(aVar4.b[i11], d4);
                            }
                            aVar = new a(aVar4.a, iArr7);
                        }
                        b2 = b2.i(aVar);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                aVar6 = aVar10.g(aVar5).i(aVar5).h();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }
}
