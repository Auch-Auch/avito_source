package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.Immutable;
@Immutable
public abstract class c extends d {
    public final HashFunction[] a;

    public c(HashFunction... hashFunctionArr) {
        for (HashFunction hashFunction : hashFunctionArr) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.a = hashFunctionArr;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i = 0; i < length; i++) {
            hasherArr[i] = this.a[i].newHasher();
        }
        return new b(this, hasherArr);
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        int length = this.a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = this.a[i2].newHasher(i);
        }
        return new b(this, hasherArr);
    }
}
