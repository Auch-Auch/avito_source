package com.google.zxing.oned.rss.expanded;

import a2.j.k.g.e.b.a;
import a2.j.k.g.e.b.b;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class RSSExpandedReader extends AbstractRSSReader {
    public static final int[] k = {7, 5, 4, 3, 1};
    public static final int[] l = {4, 20, 52, 104, 204};
    public static final int[] m = {0, 348, 1388, 2948, 3988};
    public static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    public static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<a> g = new ArrayList(11);
    public final List<b> h = new ArrayList();
    public final int[] i = new int[2];
    public boolean j;

    public static Result e(List<a> list) throws NotFoundException, FormatException {
        int size = (list.size() << 1) - 1;
        if (((a) a2.b.a.a.a.j2(list, 1)).b == null) {
            size--;
        }
        BitArray bitArray = new BitArray(size * 12);
        int value = list.get(0).b.getValue();
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & value) != 0) {
                bitArray.set(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            a aVar = list.get(i4);
            int value2 = aVar.a.getValue();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i2);
                }
                i2++;
            }
            DataCharacter dataCharacter = aVar.b;
            if (dataCharacter != null) {
                int value3 = dataCharacter.getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i2);
                    }
                    i2++;
                }
            }
        }
        String parseInformation = AbstractExpandedDecoder.createDecoder(bitArray).parseInformation();
        ResultPoint[] resultPoints = list.get(0).c.getResultPoints();
        ResultPoint[] resultPoints2 = ((a) a2.b.a.a.a.j2(list, 1)).c.getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    public static void i(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    public final boolean b() {
        a aVar = this.g.get(0);
        DataCharacter dataCharacter = aVar.a;
        DataCharacter dataCharacter2 = aVar.b;
        if (dataCharacter2 == null) {
            return false;
        }
        int checksumPortion = dataCharacter2.getChecksumPortion();
        int i2 = 2;
        for (int i3 = 1; i3 < this.g.size(); i3++) {
            a aVar2 = this.g.get(i3);
            int checksumPortion2 = aVar2.a.getChecksumPortion() + checksumPortion;
            i2++;
            DataCharacter dataCharacter3 = aVar2.b;
            if (dataCharacter3 != null) {
                checksumPortion = dataCharacter3.getChecksumPortion() + checksumPortion2;
                i2++;
            } else {
                checksumPortion = checksumPortion2;
            }
        }
        if (((i2 - 4) * 211) + (checksumPortion % 211) == dataCharacter.getValue()) {
            return true;
        }
        return false;
    }

    public final List<a> c(List<b> list, int i2) throws NotFoundException {
        boolean z;
        while (i2 < this.h.size()) {
            b bVar = this.h.get(i2);
            this.g.clear();
            for (b bVar2 : list) {
                this.g.addAll(bVar2.a);
            }
            this.g.addAll(bVar.a);
            List<a> list2 = this.g;
            int[][] iArr = p;
            int length = iArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (list2.size() <= iArr2.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            z = true;
                            break;
                        } else if (list2.get(i4).c.getValue() != iArr2[i4]) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z2) {
                i2++;
            } else if (b()) {
                return this.g;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(bVar);
                try {
                    return c(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List<a> d(boolean z) {
        List<a> list = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = c(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.g.clear();
        this.j = false;
        try {
            return e(g(i2, bitArray));
        } catch (NotFoundException unused) {
            this.g.clear();
            this.j = true;
            return e(g(i2, bitArray));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01db A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.oned.rss.DataCharacter f(com.google.zxing.common.BitArray r17, com.google.zxing.oned.rss.FinderPattern r18, boolean r19, boolean r20) throws com.google.zxing.NotFoundException {
        /*
        // Method dump skipped, instructions count: 534
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.f(com.google.zxing.common.BitArray, com.google.zxing.oned.rss.FinderPattern, boolean, boolean):com.google.zxing.oned.rss.DataCharacter");
    }

    public List<a> g(int i2, BitArray bitArray) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        boolean z8 = false;
        while (!z8) {
            try {
                List<a> list = this.g;
                list.add(h(bitArray, list, i2));
            } catch (NotFoundException e) {
                if (!this.g.isEmpty()) {
                    z8 = true;
                } else {
                    throw e;
                }
            }
        }
        if (b()) {
            return this.g;
        }
        boolean z9 = !this.h.isEmpty();
        int i3 = 0;
        boolean z10 = false;
        while (true) {
            if (i3 >= this.h.size()) {
                z = false;
                break;
            }
            b bVar = this.h.get(i3);
            if (bVar.b > i2) {
                z = bVar.a.equals(this.g);
                break;
            }
            z10 = bVar.a.equals(this.g);
            i3++;
        }
        if (!z && !z10) {
            List<a> list2 = this.g;
            Iterator<T> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                T next = it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        continue;
                        break;
                    }
                    T next2 = it2.next();
                    Iterator<a> it3 = next.a.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z7 = true;
                                continue;
                                break;
                            }
                        } else {
                            z7 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z7) {
                        z5 = false;
                        continue;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.h.add(i3, new b(this.g, i2, false));
                List<a> list3 = this.g;
                Iterator<b> it4 = this.h.iterator();
                while (it4.hasNext()) {
                    b next3 = it4.next();
                    if (next3.a.size() != list3.size()) {
                        Iterator<a> it5 = next3.a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            a next4 = it5.next();
                            Iterator<a> it6 = list3.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (next4.equals(it6.next())) {
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it4.remove();
                        }
                    }
                }
            }
        }
        if (z9) {
            List<a> d = d(false);
            if (d != null) {
                return d;
            }
            List<a> d2 = d(true);
            if (d2 != null) {
                return d2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public a h(BitArray bitArray, List<a> list, int i2) throws NotFoundException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        FinderPattern finderPattern;
        int i8 = 2;
        int i9 = 0;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i10 = -1;
        boolean z2 = true;
        while (true) {
            int[] decodeFinderCounters = getDecodeFinderCounters();
            decodeFinderCounters[i9] = i9;
            decodeFinderCounters[1] = i9;
            decodeFinderCounters[i8] = i9;
            decodeFinderCounters[3] = i9;
            int size = bitArray.getSize();
            if (i10 >= 0) {
                i3 = i10;
            } else if (list.isEmpty()) {
                i3 = 0;
            } else {
                i3 = ((a) a2.b.a.a.a.j2(list, 1)).c.getStartEnd()[1];
            }
            boolean z3 = list.size() % i8 != 0;
            if (this.j) {
                z3 = !z3;
            }
            boolean z4 = false;
            while (i3 < size) {
                z4 = !bitArray.get(i3);
                if (!z4) {
                    break;
                }
                i3++;
            }
            boolean z5 = z4;
            int i11 = 0;
            int i12 = i3;
            while (i3 < size) {
                if (bitArray.get(i3) != z5) {
                    decodeFinderCounters[i11] = decodeFinderCounters[i11] + 1;
                } else {
                    if (i11 == 3) {
                        if (z3) {
                            i(decodeFinderCounters);
                        }
                        if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                            int[] iArr = this.i;
                            iArr[0] = i12;
                            iArr[1] = i3;
                            if (z) {
                                int i13 = iArr[0] - 1;
                                while (i13 >= 0 && !bitArray.get(i13)) {
                                    i13--;
                                }
                                int i14 = i13 + 1;
                                int[] iArr2 = this.i;
                                i7 = 0;
                                i6 = iArr2[0] - i14;
                                i5 = i14;
                                i4 = iArr2[1];
                            } else {
                                i7 = 0;
                                int i15 = iArr[0];
                                int nextUnset = bitArray.getNextUnset(iArr[1] + 1);
                                i6 = nextUnset - this.i[1];
                                i4 = nextUnset;
                                i5 = i15;
                            }
                            int[] decodeFinderCounters2 = getDecodeFinderCounters();
                            System.arraycopy(decodeFinderCounters2, i7, decodeFinderCounters2, 1, decodeFinderCounters2.length - 1);
                            decodeFinderCounters2[i7] = i6;
                            DataCharacter dataCharacter = null;
                            try {
                                int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters2, n);
                                int[] iArr3 = new int[2];
                                iArr3[i7] = i5;
                                iArr3[1] = i4;
                                finderPattern = new FinderPattern(parseFinderValue, iArr3, i5, i4, i2);
                            } catch (NotFoundException unused) {
                                finderPattern = null;
                            }
                            if (finderPattern == null) {
                                int i16 = this.i[0];
                                if (bitArray.get(i16)) {
                                    i10 = bitArray.getNextSet(bitArray.getNextUnset(i16));
                                } else {
                                    i10 = bitArray.getNextUnset(bitArray.getNextSet(i16));
                                }
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                DataCharacter f = f(bitArray, finderPattern, z, true);
                                if (!list.isEmpty()) {
                                    if (((a) a2.b.a.a.a.j2(list, 1)).b == null) {
                                        throw NotFoundException.getNotFoundInstance();
                                    }
                                }
                                try {
                                    dataCharacter = f(bitArray, finderPattern, z, false);
                                } catch (NotFoundException unused2) {
                                }
                                return new a(f, dataCharacter, finderPattern, true);
                            }
                            i8 = 2;
                            i9 = 0;
                        } else {
                            if (z3) {
                                i(decodeFinderCounters);
                            }
                            i12 = decodeFinderCounters[0] + decodeFinderCounters[1] + i12;
                            decodeFinderCounters[0] = decodeFinderCounters[2];
                            decodeFinderCounters[1] = decodeFinderCounters[3];
                            decodeFinderCounters[2] = 0;
                            decodeFinderCounters[3] = 0;
                            i11--;
                        }
                    } else {
                        i11++;
                    }
                    decodeFinderCounters[i11] = 1;
                    z5 = !z5;
                }
                i3++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.g.clear();
        this.h.clear();
    }
}
