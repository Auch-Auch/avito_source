package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
public final class u extends d implements Serializable {
    public static final HashFunction e = new u(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    public static final class a extends g {
        public final int d;
        public final int e;
        public long f = 8317987319222330741L;
        public long g = 7237128888997146477L;
        public long h = 7816392313619706465L;
        public long i = 8387220255154660723L;
        public long j = 0;
        public long k = 0;

        public a(int i2, int i3, long j2, long j3) {
            super(8);
            this.d = i2;
            this.e = i3;
            this.f = 8317987319222330741L ^ j2;
            this.g = 7237128888997146477L ^ j3;
            this.h = 7816392313619706465L ^ j2;
            this.i = 8387220255154660723L ^ j3;
        }

        @Override // a2.j.d.g.g
        public HashCode a() {
            long j2 = this.k ^ (this.j << 56);
            this.k = j2;
            this.i ^= j2;
            g(this.d);
            this.f = j2 ^ this.f;
            this.h ^= 255;
            g(this.e);
            return HashCode.fromLong(((this.f ^ this.g) ^ this.h) ^ this.i);
        }

        @Override // a2.j.d.g.g
        public void d(ByteBuffer byteBuffer) {
            this.j += 8;
            long j2 = byteBuffer.getLong();
            this.i ^= j2;
            g(this.d);
            this.f = j2 ^ this.f;
        }

        @Override // a2.j.d.g.g
        public void e(ByteBuffer byteBuffer) {
            this.j += (long) byteBuffer.remaining();
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (((long) byteBuffer.get()) & 255) << i2;
                i2 += 8;
            }
        }

        public final void g(int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = this.f;
                long j3 = this.g;
                this.f = j2 + j3;
                this.h += this.i;
                this.g = Long.rotateLeft(j3, 13);
                long rotateLeft = Long.rotateLeft(this.i, 16);
                this.i = rotateLeft;
                long j4 = this.g;
                long j5 = this.f;
                this.g = j4 ^ j5;
                this.i = rotateLeft ^ this.h;
                long rotateLeft2 = Long.rotateLeft(j5, 32);
                this.f = rotateLeft2;
                long j6 = this.h;
                long j7 = this.g;
                this.h = j6 + j7;
                this.f = rotateLeft2 + this.i;
                this.g = Long.rotateLeft(j7, 17);
                long rotateLeft3 = Long.rotateLeft(this.i, 21);
                this.i = rotateLeft3;
                long j8 = this.g;
                long j9 = this.h;
                this.g = j8 ^ j9;
                this.i = rotateLeft3 ^ this.f;
                this.h = Long.rotateLeft(j9, 32);
            }
        }
    }

    public u(int i, int i2, long j, long j2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 <= 0 ? false : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.a == uVar.a && this.b == uVar.b && this.c == uVar.c && this.d == uVar.d) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) ((((long) ((u.class.hashCode() ^ this.a) ^ this.b)) ^ this.c) ^ this.d);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.a, this.b, this.c, this.d);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Hashing.sipHash");
        L.append(this.a);
        L.append("");
        L.append(this.b);
        L.append("(");
        L.append(this.c);
        L.append(", ");
        return a2.b.a.a.a.l(L, this.d, ")");
    }
}
