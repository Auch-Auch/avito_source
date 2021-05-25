package com.google.zxing.oned.rss;

import a2.j.k.g.e.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class RSS14Reader extends AbstractRSSReader {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, 336, 1036, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<a> g = new ArrayList();
    public final List<a> h = new ArrayList();

    public static void b(Collection<a> collection, a aVar) {
        if (aVar != null) {
            boolean z = false;
            Iterator<a> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.getValue() == aVar.getValue()) {
                    next.d++;
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(aVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r3 < 4) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        if (r3 < 4) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c6, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c8, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c9, code lost:
        r12 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0166 A[LOOP:3: B:105:0x0164->B:106:0x0166, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0177 A[LOOP:4: B:108:0x0175->B:109:0x0177, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.oned.rss.DataCharacter c(com.google.zxing.common.BitArray r17, com.google.zxing.oned.rss.FinderPattern r18, boolean r19) throws com.google.zxing.NotFoundException {
        /*
        // Method dump skipped, instructions count: 502
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSS14Reader.c(com.google.zxing.common.BitArray, com.google.zxing.oned.rss.FinderPattern, boolean):com.google.zxing.oned.rss.DataCharacter");
    }

    public final a d(BitArray bitArray, boolean z, int i2, Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        try {
            int[] e = e(bitArray, z);
            FinderPattern f = f(bitArray, i2, z, e);
            if (map == null) {
                resultPointCallback = null;
            } else {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (resultPointCallback != null) {
                float f2 = ((float) (e[0] + e[1])) / 2.0f;
                if (z) {
                    f2 = ((float) (bitArray.getSize() - 1)) - f2;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f2, (float) i2));
            }
            DataCharacter c = c(bitArray, f, true);
            DataCharacter c2 = c(bitArray, f, false);
            return new a((c.getValue() * 1597) + c2.getValue(), (c2.getChecksumPortion() * 4) + c.getChecksumPortion(), f);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        b(this.g, d(bitArray, false, i2, map));
        bitArray.reverse();
        b(this.h, d(bitArray, true, i2, map));
        bitArray.reverse();
        for (a aVar : this.g) {
            if (aVar.d > 1) {
                for (a aVar2 : this.h) {
                    if (aVar2.d > 1) {
                        int checksumPortion = ((aVar2.getChecksumPortion() * 16) + aVar.getChecksumPortion()) % 79;
                        int value = aVar2.c.getValue() + (aVar.c.getValue() * 9);
                        if (value > 72) {
                            value--;
                        }
                        if (value > 8) {
                            value--;
                        }
                        if (checksumPortion == value) {
                            String valueOf = String.valueOf((((long) aVar.getValue()) * 4537077) + ((long) aVar2.getValue()));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i3 = 0;
                            for (int i4 = 0; i4 < 13; i4++) {
                                int charAt = sb.charAt(i4) - '0';
                                if ((i4 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i3 += charAt;
                            }
                            int i5 = 10 - (i3 % 10);
                            if (i5 == 10) {
                                i5 = 0;
                            }
                            sb.append(i5);
                            ResultPoint[] resultPoints = aVar.c.getResultPoints();
                            ResultPoint[] resultPoints2 = aVar2.c.getResultPoints();
                            return new Result(sb.toString(), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] e(BitArray bitArray, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < size) {
            if (bitArray.get(i2) != z2) {
                decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i3, i2};
                } else {
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i4--;
                }
                decodeFinderCounters[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final FinderPattern f(BitArray bitArray, int i2, boolean z, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean z2 = bitArray.get(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && z2 != bitArray.get(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = iArr[0] - i6;
        int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, o);
        int i7 = iArr[1];
        if (z) {
            i3 = (bitArray.getSize() - 1) - i7;
            i4 = (bitArray.getSize() - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new FinderPattern(parseFinderValue, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.g.clear();
        this.h.clear();
    }
}
