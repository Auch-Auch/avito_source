package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
@CanIgnoreReturnValue
public abstract class g extends e {
    public final ByteBuffer a;
    public final int b;
    public final int c;

    public g(int i) {
        Preconditions.checkArgument(i % i == 0);
        this.a = ByteBuffer.allocate(i + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i;
        this.c = i;
    }

    public abstract HashCode a();

    public final void b() {
        this.a.flip();
        while (this.a.remaining() >= this.c) {
            d(this.a);
        }
        this.a.compact();
    }

    public final void c() {
        if (this.a.remaining() < 8) {
            b();
        }
    }

    public abstract void d(ByteBuffer byteBuffer);

    public abstract void e(ByteBuffer byteBuffer);

    public final Hasher f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            c();
            return this;
        }
        int position = this.b - this.a.position();
        for (int i = 0; i < position; i++) {
            this.a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.c) {
            d(byteBuffer);
        }
        this.a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        b();
        this.a.flip();
        if (this.a.remaining() > 0) {
            e(this.a);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return a();
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putByte */
    public final Hasher mo61putByte(byte b2) {
        this.a.put(b2);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar */
    public final Hasher mo62putChar(char c2) {
        this.a.putChar(c2);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt */
    public final Hasher mo63putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong */
    public final Hasher mo59putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort */
    public final Hasher mo60putShort(short s) {
        this.a.putShort(s);
        c();
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putByte  reason: collision with other method in class */
    public PrimitiveSink mo61putByte(byte b2) {
        this.a.put(b2);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public final Hasher mo55putBytes(byte[] bArr, int i, int i2) {
        f(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar  reason: collision with other method in class */
    public PrimitiveSink mo62putChar(char c2) {
        this.a.putChar(c2);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt  reason: collision with other method in class */
    public PrimitiveSink mo63putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong  reason: collision with other method in class */
    public PrimitiveSink mo59putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort  reason: collision with other method in class */
    public PrimitiveSink mo60putShort(short s) {
        this.a.putShort(s);
        c();
        return this;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public final Hasher mo54putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            f(byteBuffer);
            byteBuffer.order(order);
            return this;
        } catch (Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }
}
