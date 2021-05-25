package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
@CanIgnoreReturnValue
public abstract class a extends e {
    public final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public final Hasher a(int i) {
        try {
            e(this.a.array(), 0, i);
            return this;
        } finally {
            this.a.clear();
        }
    }

    public abstract void b(byte b);

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            e(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            b(byteBuffer.get());
        }
    }

    public void d(byte[] bArr) {
        e(bArr, 0, bArr.length);
    }

    public void e(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            b(bArr[i3]);
        }
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putByte */
    public Hasher mo61putByte(byte b) {
        b(b);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo45putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        d(bArr);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar */
    public Hasher mo62putChar(char c) {
        this.a.putChar(c);
        a(2);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt */
    public Hasher mo63putInt(int i) {
        this.a.putInt(i);
        a(4);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong */
    public Hasher mo59putLong(long j) {
        this.a.putLong(j);
        a(8);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort */
    public Hasher mo60putShort(short s) {
        this.a.putShort(s);
        a(2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putByte  reason: collision with other method in class */
    public PrimitiveSink mo61putByte(byte b) {
        b(b);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes  reason: collision with other method in class */
    public PrimitiveSink mo45putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        d(bArr);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar  reason: collision with other method in class */
    public PrimitiveSink mo62putChar(char c) {
        this.a.putChar(c);
        a(2);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt  reason: collision with other method in class */
    public PrimitiveSink mo63putInt(int i) {
        this.a.putInt(i);
        a(4);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong  reason: collision with other method in class */
    public PrimitiveSink mo59putLong(long j) {
        this.a.putLong(j);
        a(8);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort  reason: collision with other method in class */
    public PrimitiveSink mo60putShort(short s) {
        this.a.putShort(s);
        a(2);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo55putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        e(bArr, i, i2);
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes  reason: collision with other method in class */
    public PrimitiveSink mo55putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        e(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo54putBytes(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes  reason: collision with other method in class */
    public PrimitiveSink mo54putBytes(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return this;
    }
}
