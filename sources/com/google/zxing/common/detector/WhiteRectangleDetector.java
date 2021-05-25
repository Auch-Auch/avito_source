package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
public final class WhiteRectangleDetector {
    public final BitMatrix a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public final boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.get(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.get(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final ResultPoint b(float f2, float f3, float f4, float f5) {
        int round = MathUtils.round(MathUtils.distance(f2, f3, f4, f5));
        float f6 = (float) round;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i = 0; i < round; i++) {
            float f9 = (float) i;
            int round2 = MathUtils.round((f9 * f7) + f2);
            int round3 = MathUtils.round((f9 * f8) + f3);
            if (this.a.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        boolean z;
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            if (!z2) {
                z = false;
                break;
            }
            boolean z9 = true;
            boolean z10 = false;
            while (true) {
                if ((z9 || !z3) && i2 < this.c) {
                    z9 = a(i3, i4, i2, false);
                    if (z9) {
                        i2++;
                        z3 = true;
                        z10 = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.c) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z4) && i4 < this.b) {
                    z11 = a(i, i2, i4, true);
                    if (z11) {
                        i4++;
                        z4 = true;
                        z10 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.b) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z5) && i >= 0) {
                    z12 = a(i3, i4, i, false);
                    if (z12) {
                        i--;
                        z5 = true;
                        z10 = true;
                    } else if (!z5) {
                        i--;
                    }
                }
            }
            if (i < 0) {
                break;
            }
            z2 = z10;
            boolean z13 = true;
            while (true) {
                if ((z13 || !z8) && i3 >= 0) {
                    z13 = a(i, i2, i3, true);
                    if (z13) {
                        i3--;
                        z2 = true;
                        z8 = true;
                    } else if (!z8) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            } else if (z2) {
                z7 = true;
            }
        }
        z = true;
        if (z || !z7) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i6 = 1;
        while (resultPoint2 == null && i6 < i5) {
            resultPoint2 = b((float) i, (float) (i4 - i6), (float) (i + i6), (float) i4);
            i6++;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i7 = 1;
            while (resultPoint3 == null && i7 < i5) {
                resultPoint3 = b((float) i, (float) (i3 + i7), (float) (i + i7), (float) i3);
                i7++;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i8 = 1;
                while (resultPoint4 == null && i8 < i5) {
                    resultPoint4 = b((float) i2, (float) (i3 + i8), (float) (i2 - i8), (float) i3);
                    i8++;
                }
                if (resultPoint4 != null) {
                    int i9 = 1;
                    while (resultPoint == null && i9 < i5) {
                        resultPoint = b((float) i2, (float) (i4 - i9), (float) (i2 - i9), (float) i4);
                        i9++;
                    }
                    if (resultPoint != null) {
                        float x = resultPoint.getX();
                        float y = resultPoint.getY();
                        float x2 = resultPoint2.getX();
                        float y2 = resultPoint2.getY();
                        float x3 = resultPoint4.getX();
                        float y3 = resultPoint4.getY();
                        float x4 = resultPoint3.getX();
                        float y4 = resultPoint3.getY();
                        return x < ((float) this.c) / 2.0f ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.a = bitMatrix;
        int height = bitMatrix.getHeight();
        this.b = height;
        int width = bitMatrix.getWidth();
        this.c = width;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= height || i6 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
