package com.google.zxing.multi.qrcode.detector;

import a2.j.k.f.a.a.a;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class MultiDetector extends Detector {
    public static final DetectorResult[] c = new DetectorResult[0];

    public MultiDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        FinderPattern[][] finderPatternArr;
        FinderPatternInfo[] finderPatternInfoArr;
        a aVar = new a(getImage(), map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK));
        char c2 = 0;
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = aVar.getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i = (height * 3) / 388;
        int i2 = 3;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        for (int i3 = i - 1; i3 < height; i3 += i) {
            aVar.clearCounts(iArr);
            int i4 = 0;
            for (int i5 = 0; i5 < width; i5++) {
                if (image.get(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (!FinderPatternFinder.foundPatternCross(iArr) || !aVar.handlePossibleCenter(iArr, i3, i5)) {
                    aVar.shiftCounts2(iArr);
                    i4 = 3;
                } else {
                    aVar.clearCounts(iArr);
                    i4 = 0;
                }
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                aVar.handlePossibleCenter(iArr, i3, width);
            }
        }
        List<FinderPattern> possibleCenters = aVar.getPossibleCenters();
        int size = possibleCenters.size();
        if (size >= 3) {
            if (size == 3) {
                finderPatternArr = new FinderPattern[][]{new FinderPattern[]{possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2)}};
            } else {
                Collections.sort(possibleCenters, new a.b(null));
                ArrayList arrayList = new ArrayList();
                int i6 = 0;
                while (i6 < size - 2) {
                    FinderPattern finderPattern = possibleCenters.get(i6);
                    if (finderPattern != null) {
                        int i7 = i6 + 1;
                        while (i7 < size - 1) {
                            FinderPattern finderPattern2 = possibleCenters.get(i7);
                            if (finderPattern2 != null) {
                                float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                                float f = 0.05f;
                                float f2 = 0.5f;
                                if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f && estimatedModuleSize >= 0.05f) {
                                    break;
                                }
                                int i8 = i7 + 1;
                                while (i8 < size) {
                                    FinderPattern finderPattern3 = possibleCenters.get(i8);
                                    if (finderPattern3 != null) {
                                        float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                        if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f2 && estimatedModuleSize2 >= f) {
                                            break;
                                        }
                                        FinderPattern[] finderPatternArr2 = new FinderPattern[i2];
                                        finderPatternArr2[c2] = finderPattern;
                                        finderPatternArr2[1] = finderPattern2;
                                        finderPatternArr2[2] = finderPattern3;
                                        ResultPoint.orderBestPatterns(finderPatternArr2);
                                        FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr2);
                                        float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                        float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                        float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                        float estimatedModuleSize3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                        if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= 9.0f && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                            float sqrt = (float) Math.sqrt((double) ((distance3 * distance3) + (distance * distance)));
                                            if (Math.abs((distance2 - sqrt) / Math.min(distance2, sqrt)) < 0.1f) {
                                                arrayList.add(finderPatternArr2);
                                            }
                                        }
                                    }
                                    i8++;
                                    c2 = 0;
                                    i2 = 3;
                                    f = 0.05f;
                                    f2 = 0.5f;
                                }
                            }
                            i7++;
                            c2 = 0;
                            i2 = 3;
                        }
                    }
                    i6++;
                    c2 = 0;
                    i2 = 3;
                }
                if (!arrayList.isEmpty()) {
                    finderPatternArr = (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()][]);
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (FinderPattern[] finderPatternArr3 : finderPatternArr) {
                ResultPoint.orderBestPatterns(finderPatternArr3);
                arrayList2.add(new FinderPatternInfo(finderPatternArr3));
            }
            if (arrayList2.isEmpty()) {
                finderPatternInfoArr = a.f;
            } else {
                finderPatternInfoArr = (FinderPatternInfo[]) arrayList2.toArray(new FinderPatternInfo[arrayList2.size()]);
            }
            if (finderPatternInfoArr.length != 0) {
                ArrayList arrayList3 = new ArrayList();
                for (FinderPatternInfo finderPatternInfo2 : finderPatternInfoArr) {
                    try {
                        arrayList3.add(processFinderPatternInfo(finderPatternInfo2));
                    } catch (ReaderException unused) {
                    }
                }
                if (arrayList3.isEmpty()) {
                    return c;
                }
                return (DetectorResult[]) arrayList3.toArray(new DetectorResult[arrayList3.size()]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
