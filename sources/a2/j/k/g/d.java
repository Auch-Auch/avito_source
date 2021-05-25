package a2.j.k.g;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.UPCEANReader;
import java.util.EnumMap;
public final class d {
    public static final int[] c = {1, 1, 2};
    public final b a = new b();
    public final c b = new c();

    public Result a(int i, BitArray bitArray, int i2) throws NotFoundException {
        EnumMap enumMap;
        int[] iArr = c;
        int[] iArr2 = UPCEANReader.d;
        int[] d = UPCEANReader.d(bitArray, i2, false, iArr, new int[iArr.length]);
        try {
            return this.b.a(i, bitArray, d);
        } catch (ReaderException unused) {
            b bVar = this.a;
            StringBuilder sb = bVar.b;
            sb.setLength(0);
            int[] iArr3 = bVar.a;
            iArr3[0] = 0;
            iArr3[1] = 0;
            iArr3[2] = 0;
            iArr3[3] = 0;
            int size = bitArray.getSize();
            int i3 = d[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && i3 < size; i5++) {
                int c2 = UPCEANReader.c(bitArray, iArr3, i3, UPCEANReader.h);
                sb.append((char) ((c2 % 10) + 48));
                for (int i6 : iArr3) {
                    i3 += i6;
                }
                if (c2 >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    i3 = bitArray.getNextUnset(bitArray.getNextSet(i3));
                }
            }
            if (sb.length() != 2) {
                throw NotFoundException.getNotFoundInstance();
            } else if (Integer.parseInt(sb.toString()) % 4 == i4) {
                String sb2 = sb.toString();
                if (sb2.length() != 2) {
                    enumMap = null;
                } else {
                    enumMap = new EnumMap(ResultMetadataType.class);
                    enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(sb2));
                }
                float f = (float) i;
                Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint(((float) (d[0] + d[1])) / 2.0f, f), new ResultPoint((float) i3, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
                if (enumMap != null) {
                    result.putAllMetadata(enumMap);
                }
                return result;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
