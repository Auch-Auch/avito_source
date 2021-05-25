package com.google.zxing.qrcode.decoder;

import a2.j.k.i.a.a;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import java.util.Map;
public final class Decoder {
    public final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    /* JADX WARNING: Removed duplicated region for block: B:188:0x0371 A[LOOP:19: B:102:0x0215->B:188:0x0371, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0351 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.common.DecoderResult a(a2.j.k.i.a.a r23, java.util.Map<com.google.zxing.DecodeHintType, ?> r24) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        // Method dump skipped, instructions count: 907
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.Decoder.a(a2.j.k.i.a.a, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        return decode(zArr, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return decode(BitMatrix.parse(zArr), map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException checksumException;
        FormatException e;
        a aVar = new a(bitMatrix);
        try {
            return a(aVar, map);
        } catch (FormatException e2) {
            e = e2;
            checksumException = null;
            try {
                aVar.e();
                aVar.b = null;
                aVar.c = null;
                aVar.d = true;
                aVar.d();
                aVar.c();
                aVar.b();
                DecoderResult a3 = a(aVar, map);
                a3.setOther(new QRCodeDecoderMetaData(true));
                return a3;
            } catch (ChecksumException | FormatException unused) {
                if (e != null) {
                    throw e;
                }
                throw checksumException;
            }
        } catch (ChecksumException e3) {
            checksumException = e3;
            e = null;
            aVar.e();
            aVar.b = null;
            aVar.c = null;
            aVar.d = true;
            aVar.d();
            aVar.c();
            aVar.b();
            DecoderResult a3 = a(aVar, map);
            a3.setOther(new QRCodeDecoderMetaData(true));
            return a3;
        }
    }
}
