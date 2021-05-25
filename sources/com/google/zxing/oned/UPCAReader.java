package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;
public final class UPCAReader extends UPCEANReader {
    public final UPCEANReader i = new EAN13Reader();

    public static Result h(Result result) throws FormatException {
        String text = result.getText();
        if (text.charAt(0) == '0') {
            Result result2 = new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
            if (result.getResultMetadata() != null) {
                result2.putAllMetadata(result.getResultMetadata());
            }
            return result2;
        }
        throw FormatException.getFormatInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return h(this.i.decode(binaryBitmap));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.i.decodeMiddle(bitArray, iArr, sb);
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public Result decodeRow(int i2, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return h(this.i.decodeRow(i2, bitArray, iArr, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat f() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return h(this.i.decode(binaryBitmap, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader, com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return h(this.i.decodeRow(i2, bitArray, map));
    }
}
