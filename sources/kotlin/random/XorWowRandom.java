package kotlin.random;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0000\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\t¨\u0006\u001a"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "", "nextInt", "()I", "bitCount", "nextBits", "(I)I", g.a, "I", "addend", "e", "w", "c", "y", AuthSource.BOOKING_ORDER, "x", "f", VKApiConst.VERSION, "d", "z", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class XorWowRandom extends Random {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public XorWowRandom(int i, int i2, int i3, int i4, int i5, int i6) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        int i7 = i | i2 | i3 | i4 | i5;
        if (i7 != 0) {
            for (int i8 = 0; i8 < 64; i8++) {
                nextInt();
            }
            return;
        }
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    @Override // kotlin.random.Random
    public int nextBits(int i) {
        return RandomKt.takeUpperBits(nextInt(), i);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i = this.b;
        int i2 = i ^ (i >>> 2);
        this.b = this.c;
        this.c = this.d;
        this.d = this.e;
        int i3 = this.f;
        this.e = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.f = i4;
        int i5 = this.g + 362437;
        this.g = i5;
        return i4 + i5;
    }

    public XorWowRandom(int i, int i2) {
        this(i, i2, 0, 0, ~i, (i << 10) ^ (i2 >>> 4));
    }
}
