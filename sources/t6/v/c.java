package t6.v;

import com.yandex.mobile.ads.video.tracking.Tracker;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
public class c<T extends Comparable<? super T>> implements ClosedRange<T> {
    @NotNull
    public final T a;
    @NotNull
    public final T b;

    public c(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, Tracker.Events.CREATIVE_START);
        Intrinsics.checkNotNullParameter(t2, "endInclusive");
        this.a = t;
        this.b = t2;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        return ClosedRange.DefaultImpls.contains(this, t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(r0) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof t6.v.c
            if (r0 == 0) goto L_0x002e
            boolean r0 = kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(r2)
            if (r0 == 0) goto L_0x0016
            r0 = r3
            t6.v.c r0 = (t6.v.c) r0
            java.util.Objects.requireNonNull(r0)
            boolean r0 = kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(r0)
            if (r0 != 0) goto L_0x002c
        L_0x0016:
            T extends java.lang.Comparable<? super T> r0 = r2.a
            t6.v.c r3 = (t6.v.c) r3
            T extends java.lang.Comparable<? super T> r1 = r3.a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x002e
            T extends java.lang.Comparable<? super T> r0 = r2.b
            T extends java.lang.Comparable<? super T> r3 = r3.b
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x002e
        L_0x002c:
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.v.c.equals(java.lang.Object):boolean");
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    public T getEndInclusive() {
        return this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    public T getStart() {
        return this.a;
    }

    public int hashCode() {
        if (ClosedRange.DefaultImpls.isEmpty(this)) {
            return -1;
        }
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
