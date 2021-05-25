package com.google.zxing.qrcode.detector;

import a2.j.k.i.b.a;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class Detector {
    public final BitMatrix a;
    public ResultPointCallback b;

    public Detector(BitMatrix bitMatrix) {
        this.a = bitMatrix;
    }

    public final float a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float c = c((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float c2 = c((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(c)) {
            return c2 / 7.0f;
        }
        return Float.isNaN(c2) ? c / 7.0f : (c + c2) / 14.0f;
    }

    public final float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        Detector detector;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i8 < i6 ? 1 : -1;
        if (i7 < i5) {
            i12 = 1;
        }
        int i14 = i6 + i13;
        int i15 = i8;
        int i16 = i7;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z3 ? i16 : i15;
            int i19 = z3 ? i15 : i16;
            if (i17 == i10) {
                detector = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                detector = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == detector.a.get(i18, i19)) {
                if (i17 == 2) {
                    return MathUtils.distance(i15, i16, i8, i7);
                }
                i17++;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (i16 == i5) {
                    break;
                }
                i16 += i12;
                i11 -= abs;
            }
            i15 += i13;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
        if (i17 == 2) {
            return MathUtils.distance(i9, i5, i8, i7);
        }
        return Float.NaN;
    }

    public final float c(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float b2 = b(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else if (i5 >= this.a.getWidth()) {
            f = ((float) ((this.a.getWidth() - 1) - i)) / ((float) (i5 - i));
            i5 = this.a.getWidth() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i7 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i7 < 0) {
            f2 = f3 / ((float) (i2 - i7));
        } else if (i7 >= this.a.getHeight()) {
            f2 = ((float) ((this.a.getHeight() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.a.getHeight() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        return (b(i, i2, (int) ((((float) (i5 - i)) * f2) + ((float) i)), i6) + b2) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (a(resultPoint, resultPoint3) + a(resultPoint, resultPoint2)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0066: APUT  (r0v8 int[]), (0 ??[int, short, byte, char]), (0 int) */
    public final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        AlignmentPattern c;
        AlignmentPattern c2;
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.a.getWidth() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.a.getHeight() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                a aVar = new a(this.a, max, max2, min, min2, f, this.b);
                int i4 = aVar.c;
                int i5 = aVar.f;
                int i6 = aVar.e + i4;
                int i7 = (i5 / 2) + aVar.d;
                int[] iArr = new int[3];
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    int i10 = i4;
                    while (i10 < i6 && !aVar.a.get(i10, i9)) {
                        i10++;
                    }
                    int i11 = 0;
                    while (i10 < i6) {
                        if (!aVar.a.get(i10, i9)) {
                            if (i11 == 1) {
                                i11++;
                            }
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i11 == 1) {
                            iArr[1] = iArr[1] + 1;
                        } else if (i11 != 2) {
                            i11++;
                            iArr[i11] = iArr[i11] + 1;
                        } else if (aVar.b(iArr) && (c2 = aVar.c(iArr, i9, i10)) != null) {
                            return c2;
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i11 = 1;
                        }
                        i10++;
                    }
                    if (aVar.b(iArr) && (c = aVar.c(iArr, i9, i6)) != null) {
                        return c;
                    }
                }
                if (!aVar.b.isEmpty()) {
                    return aVar.b.get(0);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.a;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.b;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        float f;
        float f2;
        float f3;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int round = ((MathUtils.round(ResultPoint.distance(topLeft, bottomLeft) / calculateModuleSize) + MathUtils.round(ResultPoint.distance(topLeft, topRight) / calculateModuleSize)) / 2) + 7;
            int i = round & 3;
            if (i == 0) {
                round++;
            } else if (i == 2) {
                round--;
            } else if (i == 3) {
                throw NotFoundException.getNotFoundInstance();
            }
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(round);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x = bottomLeft.getX() + (topRight.getX() - topLeft.getX());
                float y = bottomLeft.getY() + (topRight.getY() - topLeft.getY());
                float f4 = 1.0f - (3.0f / ((float) dimensionForVersion));
                int x2 = (int) (((x - topLeft.getX()) * f4) + topLeft.getX());
                int y2 = (int) (((y - topLeft.getY()) * f4) + topLeft.getY());
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x2, y2, (float) i2);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            float f5 = ((float) round) - 3.5f;
            if (alignmentPattern != null) {
                f2 = alignmentPattern.getX();
                f = alignmentPattern.getY();
                f3 = f5 - 3.0f;
            } else {
                f2 = bottomLeft.getX() + (topRight.getX() - topLeft.getX());
                f = bottomLeft.getY() + (topRight.getY() - topLeft.getY());
                f3 = f5;
            }
            return new DetectorResult(GridSampler.getInstance().sampleGrid(this.a, round, round, PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f5, 3.5f, f3, f3, 3.5f, f5, topLeft.getX(), topLeft.getY(), topRight.getX(), topRight.getY(), f2, f, bottomLeft.getX(), bottomLeft.getY())), alignmentPattern == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern});
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback;
        int i;
        if (map == null) {
            resultPointCallback = null;
        } else {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.b = resultPointCallback;
        FinderPatternFinder finderPatternFinder = new FinderPatternFinder(this.a, resultPointCallback);
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = finderPatternFinder.a.getHeight();
        int width = finderPatternFinder.a.getWidth();
        int i2 = (height * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z2 = false;
        while (i3 < height && !z2) {
            finderPatternFinder.clearCounts(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                if (finderPatternFinder.a.get(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 == 4) {
                    if (!FinderPatternFinder.foundPatternCross(iArr)) {
                        finderPatternFinder.shiftCounts2(iArr);
                    } else if (finderPatternFinder.handlePossibleCenter(iArr, i3, i4)) {
                        if (finderPatternFinder.c) {
                            z2 = finderPatternFinder.c();
                        } else {
                            if (finderPatternFinder.b.size() > 1) {
                                Iterator<FinderPattern> it = finderPatternFinder.b.iterator();
                                FinderPattern finderPattern = null;
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    FinderPattern next = it.next();
                                    if (next.d >= 2) {
                                        if (finderPattern != null) {
                                            finderPatternFinder.c = true;
                                            i = ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                                            break;
                                        }
                                        finderPattern = next;
                                    }
                                }
                            }
                            i = 0;
                            if (i > iArr[2]) {
                                i3 += (i - iArr[2]) - 2;
                                i4 = width - 1;
                            }
                        }
                        finderPatternFinder.clearCounts(iArr);
                        i2 = 2;
                        i5 = 0;
                    } else {
                        finderPatternFinder.shiftCounts2(iArr);
                    }
                    i5 = 3;
                } else {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                }
                i4++;
            }
            if (FinderPatternFinder.foundPatternCross(iArr) && finderPatternFinder.handlePossibleCenter(iArr, i3, width)) {
                int i6 = iArr[0];
                if (finderPatternFinder.c) {
                    z2 = finderPatternFinder.c();
                }
                i2 = i6;
            }
            i3 += i2;
        }
        int size = finderPatternFinder.b.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (FinderPattern finderPattern2 : finderPatternFinder.b) {
                    float estimatedModuleSize = finderPattern2.getEstimatedModuleSize();
                    f2 += estimatedModuleSize;
                    f3 += estimatedModuleSize * estimatedModuleSize;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                Collections.sort(finderPatternFinder.b, new FinderPatternFinder.c(f5, null));
                float max = Math.max(0.2f * f5, (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5))));
                int i7 = 0;
                while (i7 < finderPatternFinder.b.size() && finderPatternFinder.b.size() > 3) {
                    if (Math.abs(finderPatternFinder.b.get(i7).getEstimatedModuleSize() - f5) > max) {
                        finderPatternFinder.b.remove(i7);
                        i7--;
                    }
                    i7++;
                }
            }
            if (finderPatternFinder.b.size() > 3) {
                for (FinderPattern finderPattern3 : finderPatternFinder.b) {
                    f += finderPattern3.getEstimatedModuleSize();
                }
                Collections.sort(finderPatternFinder.b, new FinderPatternFinder.b(f / ((float) finderPatternFinder.b.size()), null));
                List<FinderPattern> list = finderPatternFinder.b;
                list.subList(3, list.size()).clear();
            }
            FinderPattern[] finderPatternArr = {finderPatternFinder.b.get(0), finderPatternFinder.b.get(1), finderPatternFinder.b.get(2)};
            ResultPoint.orderBestPatterns(finderPatternArr);
            return processFinderPatternInfo(new FinderPatternInfo(finderPatternArr));
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
