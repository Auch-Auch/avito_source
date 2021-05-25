package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import kotlin.text.Typography;
public final class Detector {
    public static final int[] g = {3808, 476, 2107, 1799};
    public final BitMatrix a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;

    public static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.a);
            sb.append(' ');
            return a2.b.a.a.a.i(sb, this.b, Typography.greater);
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.a = bitMatrix;
    }

    public static ResultPoint[] a(ResultPoint[] resultPointArr, int i, int i2) {
        float f2 = ((float) i2) / (((float) i) * 2.0f);
        float x = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x2 = (resultPointArr[2].getX() + resultPointArr[0].getX()) / 2.0f;
        float y2 = (resultPointArr[2].getY() + resultPointArr[0].getY()) / 2.0f;
        float f3 = x * f2;
        float f4 = y * f2;
        ResultPoint resultPoint = new ResultPoint(x2 + f3, y2 + f4);
        ResultPoint resultPoint2 = new ResultPoint(x2 - f3, y2 - f4);
        float x3 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y3 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x4 = (resultPointArr[3].getX() + resultPointArr[1].getX()) / 2.0f;
        float y4 = (resultPointArr[3].getY() + resultPointArr[1].getY()) / 2.0f;
        float f5 = x3 * f2;
        float f6 = f2 * y3;
        return new ResultPoint[]{resultPoint, new ResultPoint(x4 + f5, y4 + f6), resultPoint2, new ResultPoint(x4 - f5, y4 - f6)};
    }

    public final int b(a aVar, a aVar2) {
        float distance = MathUtils.distance(aVar.a, aVar.b, aVar2.a, aVar2.b);
        int i = aVar2.a;
        int i2 = aVar.a;
        float f2 = ((float) (i - i2)) / distance;
        int i3 = aVar2.b;
        int i4 = aVar.b;
        float f3 = ((float) (i3 - i4)) / distance;
        float f4 = (float) i2;
        float f5 = (float) i4;
        boolean z = this.a.get(i2, i4);
        int ceil = (int) Math.ceil((double) distance);
        boolean z2 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < ceil; i6++) {
            f4 += f2;
            f5 += f3;
            if (this.a.get(MathUtils.round(f4), MathUtils.round(f5)) != z) {
                i5++;
            }
        }
        float f6 = ((float) i5) / distance;
        if (f6 > 0.1f && f6 < 0.9f) {
            return 0;
        }
        if (f6 <= 0.1f) {
            z2 = true;
        }
        return z2 == z ? 1 : -1;
    }

    public final int c() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    public final a d(a aVar, boolean z, int i, int i2) {
        int i3 = aVar.a + i;
        int i4 = aVar.b;
        while (true) {
            i4 += i2;
            if (!e(i3, i4) || this.a.get(i3, i4) != z) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (e(i5, i6) && this.a.get(i5, i6) == z) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (e(i7, i6) && this.a.get(i7, i6) == z) {
            i6 += i2;
        }
        return new a(i7, i6 - i2);
    }

    public AztecDetectorResult detect() throws NotFoundException {
        return detect(false);
    }

    public final boolean e(int i, int i2) {
        return i >= 0 && i < this.a.getWidth() && i2 > 0 && i2 < this.a.getHeight();
    }

    public final boolean f(ResultPoint resultPoint) {
        return e(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    public final int g(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float distance = MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
        float f2 = distance / ((float) i);
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f2) / distance;
        float y2 = ((resultPoint2.getY() - resultPoint.getY()) * f2) / distance;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f3 = (float) i3;
            if (this.a.get(MathUtils.round((f3 * x2) + x), MathUtils.round((f3 * y2) + y))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    public AztecDetectorResult detect(boolean z) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        int i;
        int i2;
        long j;
        int i3;
        a aVar;
        int i4 = 2;
        int i5 = -1;
        int i6 = 1;
        try {
            ResultPoint[] detect = new WhiteRectangleDetector(this.a).detect();
            resultPoint3 = detect[0];
            resultPoint2 = detect[1];
            resultPoint = detect[2];
            resultPoint4 = detect[3];
        } catch (NotFoundException unused) {
            int width = this.a.getWidth() / 2;
            int height = this.a.getHeight() / 2;
            int i7 = height - 7;
            int i8 = width + 7 + 1;
            int i9 = i8;
            int i10 = i7;
            while (true) {
                i10--;
                if (!e(i9, i10) || this.a.get(i9, i10)) {
                    break;
                }
                i9++;
            }
            int i11 = i9 - 1;
            int i12 = i10 + 1;
            while (e(i11, i12) && !this.a.get(i11, i12)) {
                i11++;
            }
            int i13 = i11 - 1;
            while (e(i13, i12) && !this.a.get(i13, i12)) {
                i12--;
            }
            ResultPoint resultPoint9 = new ResultPoint((float) i13, (float) (i12 + 1));
            int i14 = height + 7;
            int i15 = i14;
            while (true) {
                i15++;
                if (!e(i8, i15) || this.a.get(i8, i15)) {
                    break;
                }
                i8++;
            }
            int i16 = i8 - 1;
            int i17 = i15 - 1;
            while (e(i16, i17) && !this.a.get(i16, i17)) {
                i16++;
            }
            int i18 = i16 - 1;
            while (e(i18, i17) && !this.a.get(i18, i17)) {
                i17++;
            }
            ResultPoint resultPoint10 = new ResultPoint((float) i18, (float) (i17 - 1));
            int i19 = width - 7;
            int i20 = i19 - 1;
            while (true) {
                i14++;
                if (!e(i20, i14) || this.a.get(i20, i14)) {
                    break;
                }
                i20--;
            }
            int i21 = i20 + 1;
            int i22 = i14 - 1;
            while (e(i21, i22) && !this.a.get(i21, i22)) {
                i21--;
            }
            int i23 = i21 + 1;
            while (e(i23, i22) && !this.a.get(i23, i22)) {
                i22++;
            }
            ResultPoint resultPoint11 = new ResultPoint((float) i23, (float) (i22 - 1));
            do {
                i19--;
                i7--;
                if (!e(i19, i7)) {
                    break;
                }
            } while (!this.a.get(i19, i7));
            int i24 = i19 + 1;
            int i25 = i7 + 1;
            while (e(i24, i25) && !this.a.get(i24, i25)) {
                i24--;
            }
            int i26 = i24 + 1;
            while (e(i26, i25) && !this.a.get(i26, i25)) {
                i25--;
            }
            resultPoint4 = new ResultPoint((float) i26, (float) (i25 + 1));
            resultPoint = resultPoint11;
            resultPoint2 = resultPoint10;
            resultPoint3 = resultPoint9;
        }
        int round = MathUtils.round((resultPoint.getX() + (resultPoint2.getX() + (resultPoint4.getX() + resultPoint3.getX()))) / 4.0f);
        int round2 = MathUtils.round((resultPoint.getY() + (resultPoint2.getY() + (resultPoint4.getY() + resultPoint3.getY()))) / 4.0f);
        try {
            ResultPoint[] detect2 = new WhiteRectangleDetector(this.a, 15, round, round2).detect();
            resultPoint7 = detect2[0];
            resultPoint6 = detect2[1];
            resultPoint5 = detect2[2];
            resultPoint8 = detect2[3];
        } catch (NotFoundException unused2) {
            int i27 = round2 - 7;
            int i28 = round + 7 + 1;
            int i29 = i28;
            int i30 = i27;
            while (true) {
                i30--;
                if (!e(i29, i30) || this.a.get(i29, i30)) {
                    break;
                }
                i29++;
            }
            int i31 = i29 - 1;
            int i32 = i30 + 1;
            while (e(i31, i32) && !this.a.get(i31, i32)) {
                i31++;
            }
            int i33 = i31 - 1;
            while (e(i33, i32) && !this.a.get(i33, i32)) {
                i32--;
            }
            ResultPoint resultPoint12 = new ResultPoint((float) i33, (float) (i32 + 1));
            int i34 = round2 + 7;
            int i35 = i34;
            while (true) {
                i35++;
                if (!e(i28, i35) || this.a.get(i28, i35)) {
                    break;
                }
                i28++;
            }
            int i36 = i28 - 1;
            int i37 = i35 - 1;
            while (e(i36, i37) && !this.a.get(i36, i37)) {
                i36++;
            }
            int i38 = i36 - 1;
            while (e(i38, i37) && !this.a.get(i38, i37)) {
                i37++;
            }
            ResultPoint resultPoint13 = new ResultPoint((float) i38, (float) (i37 - 1));
            int i39 = round - 7;
            int i40 = i39 - 1;
            while (true) {
                i34++;
                if (!e(i40, i34) || this.a.get(i40, i34)) {
                    break;
                }
                i40--;
            }
            int i41 = i40 + 1;
            int i42 = i34 - 1;
            while (e(i41, i42) && !this.a.get(i41, i42)) {
                i41--;
            }
            int i43 = i41 + 1;
            while (e(i43, i42) && !this.a.get(i43, i42)) {
                i42++;
            }
            ResultPoint resultPoint14 = new ResultPoint((float) i43, (float) (i42 - 1));
            do {
                i39--;
                i27--;
                if (!e(i39, i27)) {
                    break;
                }
            } while (!this.a.get(i39, i27));
            int i44 = i39 + 1;
            int i45 = i27 + 1;
            while (e(i44, i45) && !this.a.get(i44, i45)) {
                i44--;
            }
            int i46 = i44 + 1;
            while (e(i46, i45) && !this.a.get(i46, i45)) {
                i45--;
            }
            resultPoint8 = new ResultPoint((float) i46, (float) (i45 + 1));
            resultPoint7 = resultPoint12;
            resultPoint5 = resultPoint14;
            resultPoint6 = resultPoint13;
        }
        a aVar2 = new a(MathUtils.round((resultPoint5.getX() + (resultPoint6.getX() + (resultPoint8.getX() + resultPoint7.getX()))) / 4.0f), MathUtils.round((resultPoint5.getY() + (resultPoint6.getY() + (resultPoint8.getY() + resultPoint7.getY()))) / 4.0f));
        this.e = 1;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z2 = true;
        while (this.e < 9) {
            a d2 = d(aVar2, z2, i6, i5);
            a d3 = d(aVar3, z2, i6, i6);
            a d4 = d(aVar4, z2, i5, i6);
            a d5 = d(aVar5, z2, i5, i5);
            if (this.e > i4) {
                double distance = (double) ((MathUtils.distance(d5.a, d5.b, d2.a, d2.b) * ((float) this.e)) / (MathUtils.distance(aVar5.a, aVar5.b, aVar2.a, aVar2.b) * ((float) (this.e + i4))));
                if (distance < 0.75d || distance > 1.25d) {
                    break;
                }
                a aVar6 = new a(d2.a - 3, d2.b + 3);
                a aVar7 = new a(d3.a - 3, d3.b - 3);
                a aVar8 = new a(d4.a + 3, d4.b - 3);
                aVar = d2;
                a aVar9 = new a(d5.a + 3, d5.b + 3);
                int b2 = b(aVar9, aVar6);
                if (!(b2 != 0 && b(aVar6, aVar7) == b2 && b(aVar7, aVar8) == b2 && b(aVar8, aVar9) == b2)) {
                    break;
                }
            } else {
                aVar = d2;
            }
            z2 = !z2;
            this.e++;
            aVar5 = d5;
            aVar3 = d3;
            aVar4 = d4;
            aVar2 = aVar;
            i4 = 2;
            i5 = -1;
            i6 = 1;
        }
        int i47 = this.e;
        if (i47 == 5 || i47 == 7) {
            this.b = i47 == 5;
            ResultPoint[] resultPointArr = {new ResultPoint(((float) aVar2.a) + 0.5f, ((float) aVar2.b) - 0.5f), new ResultPoint(((float) aVar3.a) + 0.5f, ((float) aVar3.b) + 0.5f), new ResultPoint(((float) aVar4.a) - 0.5f, ((float) aVar4.b) + 0.5f), new ResultPoint(((float) aVar5.a) - 0.5f, ((float) aVar5.b) - 0.5f)};
            int i48 = this.e * 2;
            ResultPoint[] a3 = a(resultPointArr, i48 - 3, i48);
            if (z) {
                ResultPoint resultPoint15 = a3[0];
                a3[0] = a3[2];
                a3[2] = resultPoint15;
            }
            if (!f(a3[0]) || !f(a3[1]) || !f(a3[2]) || !f(a3[3])) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i49 = this.e * 2;
            int[] iArr = {g(a3[0], a3[1], i49), g(a3[1], a3[2], i49), g(a3[2], a3[3], i49), g(a3[3], a3[0], i49)};
            int i50 = 0;
            for (int i51 = 0; i51 < 4; i51++) {
                int i52 = iArr[i51];
                i50 = (i50 << 3) + ((i52 >> (i49 - 2)) << 1) + (i52 & 1);
            }
            int i53 = ((i50 & 1) << 11) + (i50 >> 1);
            for (int i54 = 0; i54 < 4; i54++) {
                if (Integer.bitCount(g[i54] ^ i53) <= 2) {
                    this.f = i54;
                    long j2 = 0;
                    for (int i55 = 0; i55 < 4; i55++) {
                        int i56 = iArr[(this.f + i55) % 4];
                        if (this.b) {
                            j = j2 << 7;
                            i3 = (i56 >> 1) & 127;
                        } else {
                            j = j2 << 10;
                            i3 = ((i56 >> 2) & 992) + ((i56 >> 1) & 31);
                        }
                        j2 = j + ((long) i3);
                    }
                    if (this.b) {
                        i2 = 7;
                        i = 2;
                    } else {
                        i2 = 10;
                        i = 4;
                    }
                    int i57 = i2 - i;
                    int[] iArr2 = new int[i2];
                    while (true) {
                        i2--;
                        if (i2 >= 0) {
                            iArr2[i2] = ((int) j2) & 15;
                            j2 >>= 4;
                        } else {
                            try {
                                break;
                            } catch (ReedSolomonException unused3) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                        }
                    }
                    new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr2, i57);
                    int i58 = 0;
                    for (int i59 = 0; i59 < i; i59++) {
                        i58 = (i58 << 4) + iArr2[i59];
                    }
                    if (this.b) {
                        this.c = (i58 >> 6) + 1;
                        this.d = (i58 & 63) + 1;
                    } else {
                        this.c = (i58 >> 11) + 1;
                        this.d = (i58 & 2047) + 1;
                    }
                    BitMatrix bitMatrix = this.a;
                    int i60 = this.f;
                    ResultPoint resultPoint16 = a3[i60 % 4];
                    ResultPoint resultPoint17 = a3[(i60 + 1) % 4];
                    ResultPoint resultPoint18 = a3[(i60 + 2) % 4];
                    ResultPoint resultPoint19 = a3[(i60 + 3) % 4];
                    GridSampler instance = GridSampler.getInstance();
                    int c2 = c();
                    float f2 = ((float) c2) / 2.0f;
                    float f3 = (float) this.e;
                    float f4 = f2 - f3;
                    float f5 = f2 + f3;
                    return new AztecDetectorResult(instance.sampleGrid(bitMatrix, c2, c2, f4, f4, f5, f4, f5, f5, f4, f5, resultPoint16.getX(), resultPoint16.getY(), resultPoint17.getX(), resultPoint17.getY(), resultPoint18.getX(), resultPoint18.getY(), resultPoint19.getX(), resultPoint19.getY()), a(a3, this.e * 2, c()), this.b, this.d, this.c);
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
