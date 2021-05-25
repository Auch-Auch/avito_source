package a2.j.d.g;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;
@CanIgnoreReturnValue
public abstract class e implements Hasher {
    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBoolean */
    public final Hasher mo50putBoolean(boolean z) {
        return mo61putByte(z ? (byte) 1 : 0);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public abstract Hasher mo55putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putDouble */
    public final Hasher mo51putDouble(double d) {
        return mo59putLong(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putFloat */
    public final Hasher mo52putFloat(float f) {
        return mo63putInt(Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBoolean  reason: collision with other method in class */
    public PrimitiveSink mo50putBoolean(boolean z) {
        return mo61putByte(z ? (byte) 1 : 0);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo45putBytes(byte[] bArr) {
        return mo55putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar */
    public Hasher mo62putChar(char c) {
        mo61putByte((byte) c);
        mo61putByte((byte) (c >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putDouble  reason: collision with other method in class */
    public PrimitiveSink mo51putDouble(double d) {
        return mo59putLong(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putFloat  reason: collision with other method in class */
    public PrimitiveSink mo52putFloat(float f) {
        return mo63putInt(Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt */
    public Hasher mo63putInt(int i) {
        mo61putByte((byte) i);
        mo61putByte((byte) (i >>> 8));
        mo61putByte((byte) (i >>> 16));
        mo61putByte((byte) (i >>> 24));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong */
    public Hasher mo59putLong(long j) {
        for (int i = 0; i < 64; i += 8) {
            mo61putByte((byte) ((int) (j >>> i)));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort */
    public Hasher mo60putShort(short s) {
        mo61putByte((byte) s);
        mo61putByte((byte) (s >>> 8));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return mo45putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            mo62putChar(charSequence.charAt(i));
        }
        return this;
    }
}
