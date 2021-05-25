package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;
@Immutable
public final class i extends d implements Serializable {
    private static final long serialVersionUID = 0;
    public final l<? extends Checksum> a;
    public final int b;
    public final String c;

    public final class b extends a {
        public final Checksum b;

        public b(Checksum checksum, a aVar) {
            this.b = (Checksum) Preconditions.checkNotNull(checksum);
        }

        @Override // a2.j.d.g.a
        public void b(byte b2) {
            this.b.update(b2);
        }

        @Override // a2.j.d.g.a
        public void e(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.b.getValue();
            if (i.this.b == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }
    }

    public i(l<? extends Checksum> lVar, int i, String str) {
        this.a = (l) Preconditions.checkNotNull(lVar);
        Preconditions.checkArgument(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.b = i;
        this.c = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.b;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new b((Checksum) this.a.get(), null);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c;
    }
}
