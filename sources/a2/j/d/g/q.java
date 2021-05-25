package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
@Immutable
public final class q extends d {
    public final Mac a;
    public final Key b;
    public final String c;
    public final int d;
    public final boolean e;

    public static final class b extends a {
        public final Mac b;
        public boolean c;

        public b(Mac mac, a aVar) {
            this.b = mac;
        }

        @Override // a2.j.d.g.a
        public void b(byte b2) {
            f();
            this.b.update(b2);
        }

        @Override // a2.j.d.g.a
        public void c(ByteBuffer byteBuffer) {
            f();
            Preconditions.checkNotNull(byteBuffer);
            this.b.update(byteBuffer);
        }

        @Override // a2.j.d.g.a
        public void d(byte[] bArr) {
            f();
            this.b.update(bArr);
        }

        @Override // a2.j.d.g.a
        public void e(byte[] bArr, int i, int i2) {
            f();
            this.b.update(bArr, i, i2);
        }

        public final void f() {
            Preconditions.checkState(!this.c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.c = true;
            byte[] doFinal = this.b.doFinal();
            char[] cArr = HashCode.a;
            return new HashCode.a(doFinal);
        }
    }

    public q(String str, Key key, String str2) {
        boolean z;
        Mac a3 = a(str, key);
        this.a = a3;
        this.b = (Key) Preconditions.checkNotNull(key);
        this.c = (String) Preconditions.checkNotNull(str2);
        this.d = a3.getMacLength() * 8;
        try {
            a3.clone();
            z = true;
        } catch (CloneNotSupportedException unused) {
            z = false;
        }
        this.e = z;
    }

    public static Mac a(String str, Key key) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key);
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        } catch (InvalidKeyException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.d;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.e) {
            try {
                return new b((Mac) this.a.clone(), null);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.a.getAlgorithm(), this.b), null);
    }

    public String toString() {
        return this.c;
    }
}
