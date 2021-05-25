package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
@CanIgnoreReturnValue
@Beta
public interface PrimitiveSink {
    /* renamed from: putBoolean */
    PrimitiveSink mo50putBoolean(boolean z);

    /* renamed from: putByte */
    PrimitiveSink mo61putByte(byte b);

    /* renamed from: putBytes */
    PrimitiveSink mo54putBytes(ByteBuffer byteBuffer);

    /* renamed from: putBytes */
    PrimitiveSink mo45putBytes(byte[] bArr);

    /* renamed from: putBytes */
    PrimitiveSink mo55putBytes(byte[] bArr, int i, int i2);

    /* renamed from: putChar */
    PrimitiveSink mo62putChar(char c);

    /* renamed from: putDouble */
    PrimitiveSink mo51putDouble(double d);

    /* renamed from: putFloat */
    PrimitiveSink mo52putFloat(float f);

    /* renamed from: putInt */
    PrimitiveSink mo63putInt(int i);

    /* renamed from: putLong */
    PrimitiveSink mo59putLong(long j);

    /* renamed from: putShort */
    PrimitiveSink mo60putShort(short s);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
