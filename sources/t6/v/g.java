package t6.v;

import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
public final class g extends ULongIterator {
    public final long a;
    public boolean b;
    public final long c;
    public long d;

    public g(long j, long j2, long j3, j jVar) {
        this.a = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int ulongCompare = UnsignedKt.ulongCompare(j, j2);
        if (i <= 0 ? ulongCompare < 0 : ulongCompare > 0) {
            z = false;
        }
        this.b = z;
        this.c = ULong.m302constructorimpl(j3);
        this.d = !this.b ? j2 : j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // kotlin.collections.ULongIterator
    /* renamed from: nextULong-s-VKNKU */
    public long mo325nextULongsVKNKU() {
        long j = this.d;
        if (j != this.a) {
            this.d = ULong.m302constructorimpl(this.c + j);
        } else if (this.b) {
            this.b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
