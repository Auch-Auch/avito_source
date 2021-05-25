package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    public final Reader a;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.a = reader;
    }

    public final void a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        boolean z;
        float f;
        float f2;
        int i4;
        int i5;
        List<Result> list2;
        Result result;
        if (i3 <= 4) {
            try {
                Result decode = this.a.decode(binaryBitmap, map);
                Iterator<Result> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getText().equals(decode.getText())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    ResultPoint[] resultPoints = decode.getResultPoints();
                    if (resultPoints == null) {
                        list2 = list;
                        result = decode;
                    } else {
                        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
                        for (int i6 = 0; i6 < resultPoints.length; i6++) {
                            ResultPoint resultPoint = resultPoints[i6];
                            if (resultPoint != null) {
                                resultPointArr[i6] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
                            }
                        }
                        result = new Result(decode.getText(), decode.getRawBytes(), decode.getNumBits(), resultPointArr, decode.getBarcodeFormat(), decode.getTimestamp());
                        result.putAllMetadata(decode.getResultMetadata());
                        list2 = list;
                    }
                    list2.add(result);
                }
                ResultPoint[] resultPoints2 = decode.getResultPoints();
                if (!(resultPoints2 == null || resultPoints2.length == 0)) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f3 = (float) width;
                    float f4 = (float) height;
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    for (ResultPoint resultPoint2 : resultPoints2) {
                        if (resultPoint2 != null) {
                            float x = resultPoint2.getX();
                            float y = resultPoint2.getY();
                            if (x < f3) {
                                f3 = x;
                            }
                            if (y < f4) {
                                f4 = y;
                            }
                            if (x > f5) {
                                f5 = x;
                            }
                            if (y > f6) {
                                f6 = y;
                            }
                        }
                    }
                    if (f3 > 100.0f) {
                        f = f5;
                        f2 = f4;
                        i5 = height;
                        i4 = width;
                        a(binaryBitmap.crop(0, 0, (int) f3, height), map, list, i, i2, i3 + 1);
                    } else {
                        f = f5;
                        f2 = f4;
                        i5 = height;
                        i4 = width;
                    }
                    if (f2 > 100.0f) {
                        a(binaryBitmap.crop(0, 0, i4, (int) f2), map, list, i, i2, i3 + 1);
                    }
                    if (f < ((float) (i4 - 100))) {
                        int i7 = (int) f;
                        a(binaryBitmap.crop(i7, 0, i4 - i7, i5), map, list, i + i7, i2, i3 + 1);
                    }
                    if (f6 < ((float) (i5 - 100))) {
                        int i8 = (int) f6;
                        a(binaryBitmap.crop(0, i8, i4, i5 - i8), map, list, i, i2 + i8, i3 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
