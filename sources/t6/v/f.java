package t6.v;

import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
public final class f extends UIntIterator {
    public final int a;
    public boolean b;
    public final int c;
    public int d;

    public f(int i, int i2, int i3, j jVar) {
        this.a = i2;
        boolean z = true;
        int uintCompare = UnsignedKt.uintCompare(i, i2);
        if (i3 <= 0 ? uintCompare < 0 : uintCompare > 0) {
            z = false;
        }
        this.b = z;
        this.c = UInt.m277constructorimpl(i3);
        this.d = !this.b ? i2 : i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // kotlin.collections.UIntIterator
    /* renamed from: nextUInt-pVg5ArA */
    public int mo300nextUIntpVg5ArA() {
        int i = this.d;
        if (i != this.a) {
            this.d = UInt.m277constructorimpl(this.c + i);
        } else if (this.b) {
            this.b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
