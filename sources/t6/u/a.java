package t6.u;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Random {
    public boolean a;
    @NotNull
    public final kotlin.random.Random b;

    public a(@NotNull kotlin.random.Random random) {
        Intrinsics.checkNotNullParameter(random, "impl");
        this.b = random;
    }

    @Override // java.util.Random
    public int next(int i) {
        return this.b.nextBits(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.b.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        this.b.nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.b.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.b.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.b.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.b.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.a) {
            this.a = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.b.nextInt(i);
    }
}
