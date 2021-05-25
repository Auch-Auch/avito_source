package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putBoolean */
    Hasher mo50putBoolean(boolean z);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putByte */
    Hasher mo61putByte(byte b);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    Hasher mo54putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    Hasher mo45putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    Hasher mo55putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putChar */
    Hasher mo62putChar(char c);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putDouble */
    Hasher mo51putDouble(double d);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putFloat */
    Hasher mo52putFloat(float f);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putInt */
    Hasher mo63putInt(int i);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putLong */
    Hasher mo59putLong(long j);

    <T> Hasher putObject(T t, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    /* renamed from: putShort */
    Hasher mo60putShort(short s);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);
}
