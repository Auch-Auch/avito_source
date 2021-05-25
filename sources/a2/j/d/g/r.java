package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
@Immutable
public final class r extends d implements Serializable {
    public final MessageDigest a;
    public final int b;
    public final boolean c;
    public final String d;

    public static final class b extends a {
        public final MessageDigest b;
        public final int c;
        public boolean d;

        public b(MessageDigest messageDigest, int i, a aVar) {
            this.b = messageDigest;
            this.c = i;
        }

        @Override // a2.j.d.g.a
        public void b(byte b2) {
            f();
            this.b.update(b2);
        }

        @Override // a2.j.d.g.a
        public void c(ByteBuffer byteBuffer) {
            f();
            this.b.update(byteBuffer);
        }

        @Override // a2.j.d.g.a
        public void e(byte[] bArr, int i, int i2) {
            f();
            this.b.update(bArr, i, i2);
        }

        public final void f() {
            Preconditions.checkState(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.d = true;
            if (this.c == this.b.getDigestLength()) {
                byte[] digest = this.b.digest();
                char[] cArr = HashCode.a;
                return new HashCode.a(digest);
            }
            byte[] copyOf = Arrays.copyOf(this.b.digest(), this.c);
            char[] cArr2 = HashCode.a;
            return new HashCode.a(copyOf);
        }
    }

    public static final class c implements Serializable {
        private static final long serialVersionUID = 0;
        public final String a;
        public final int b;
        public final String c;

        public c(String str, int i, String str2, a aVar) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        private Object readResolve() {
            return new r(this.a, this.b, this.c);
        }
    }

    public r(String str, String str2) {
        boolean z;
        MessageDigest a3 = a(str);
        this.a = a3;
        this.b = a3.getDigestLength();
        this.d = (String) Preconditions.checkNotNull(str2);
        try {
            a3.clone();
            z = true;
        } catch (CloneNotSupportedException unused) {
            z = false;
        }
        this.c = z;
    }

    public static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.b * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.c) {
            try {
                return new b((MessageDigest) this.a.clone(), this.b, null);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.a.getAlgorithm()), this.b, null);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.d;
    }

    public Object writeReplace() {
        return new c(this.a.getAlgorithm(), this.b, this.d, null);
    }

    public r(String str, int i, String str2) {
        this.d = (String) Preconditions.checkNotNull(str2);
        MessageDigest a3 = a(str);
        this.a = a3;
        int digestLength = a3.getDigestLength();
        boolean z = false;
        Preconditions.checkArgument(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.b = i;
        try {
            a3.clone();
            z = true;
        } catch (CloneNotSupportedException unused) {
        }
        this.c = z;
    }
}
