package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    public static final Result[] c = new Result[0];
    public static final ResultPoint[] d = new ResultPoint[0];

    public static final class b implements Serializable, Comparator<Result> {
        public b(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Result result, Result result2) {
            Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) resultMetadata.get(resultMetadataType)).intValue(), ((Integer) result2.getResultMetadata().get(resultMetadataType)).intValue());
        }
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        DetectorResult[] detectMulti = new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map);
        for (DetectorResult detectorResult : detectMulti) {
            try {
                DecoderResult decode = getDecoder().decode(detectorResult.getBits(), map);
                ResultPoint[] points = detectorResult.getPoints();
                if (decode.getOther() instanceof QRCodeDecoderMetaData) {
                    ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
                }
                Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
                List<byte[]> byteSegments = decode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                String eCLevel = decode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                if (decode.hasStructuredAppend()) {
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
                }
                arrayList.add(result);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return c;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((Result) it.next()).getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Result result2 = (Result) it2.next();
                arrayList2.add(result2);
                if (result2.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    arrayList3.add(result2);
                }
            }
            Collections.sort(arrayList3, new b(null));
            StringBuilder sb = new StringBuilder();
            Iterator it3 = arrayList3.iterator();
            int i = 0;
            int i2 = 0;
            while (it3.hasNext()) {
                Result result3 = (Result) it3.next();
                sb.append(result3.getText());
                i += result3.getRawBytes().length;
                Map<ResultMetadataType, Object> resultMetadata = result3.getResultMetadata();
                ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
                if (resultMetadata.containsKey(resultMetadataType)) {
                    for (byte[] bArr : (Iterable) result3.getResultMetadata().get(resultMetadataType)) {
                        i2 += bArr.length;
                    }
                }
            }
            byte[] bArr2 = new byte[i];
            byte[] bArr3 = new byte[i2];
            Iterator it4 = arrayList3.iterator();
            int i3 = 0;
            int i4 = 0;
            while (it4.hasNext()) {
                Result result4 = (Result) it4.next();
                System.arraycopy(result4.getRawBytes(), 0, bArr2, i3, result4.getRawBytes().length);
                i3 += result4.getRawBytes().length;
                Map<ResultMetadataType, Object> resultMetadata2 = result4.getResultMetadata();
                ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
                if (resultMetadata2.containsKey(resultMetadataType2)) {
                    for (byte[] bArr4 : (Iterable) result4.getResultMetadata().get(resultMetadataType2)) {
                        System.arraycopy(bArr4, 0, bArr3, i4, bArr4.length);
                        i4 += bArr4.length;
                    }
                }
            }
            Result result5 = new Result(sb.toString(), bArr2, d, BarcodeFormat.QR_CODE);
            if (i2 > 0) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(bArr3);
                result5.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList4);
            }
            arrayList2.add(result5);
            arrayList = arrayList2;
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }
}
