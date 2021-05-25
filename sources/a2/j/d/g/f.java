package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
@Immutable
public abstract class f extends d {

    public final class a extends e {
        public final b a;

        public a(int i) {
            this.a = new b(i);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            return f.this.hashBytes(this.a.a(), 0, this.a.b());
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putByte */
        public Hasher mo61putByte(byte b2) {
            this.a.write(b2);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes */
        public Hasher mo55putBytes(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putByte  reason: collision with other method in class */
        public PrimitiveSink mo61putByte(byte b2) {
            this.a.write(b2);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes  reason: collision with other method in class */
        public PrimitiveSink mo55putBytes(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes */
        public Hasher mo54putBytes(ByteBuffer byteBuffer) {
            this.a.c(byteBuffer);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes  reason: collision with other method in class */
        public PrimitiveSink mo54putBytes(ByteBuffer byteBuffer) {
            this.a.c(byteBuffer);
            return this;
        }
    }

    public static final class b extends ByteArrayOutputStream {
        public b(int i) {
            super(i);
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int b() {
            return ((ByteArrayOutputStream) this).count;
        }

        public void c(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i = ((ByteArrayOutputStream) this).count;
            int i2 = i + remaining;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            if (i2 > bArr.length) {
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, i + remaining);
            }
            byteBuffer.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, remaining);
            ((ByteArrayOutputStream) this).count += remaining;
        }
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        a aVar = (a) newHasher(byteBuffer.remaining());
        aVar.a.c(byteBuffer);
        return aVar.hash();
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < length; i++) {
            order.putChar(charSequence.charAt(i));
        }
        return hashBytes(order.array());
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return newHasher(32);
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        return new a(i);
    }
}
