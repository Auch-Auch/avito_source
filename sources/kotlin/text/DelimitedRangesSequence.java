package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
public final class DelimitedRangesSequence implements Sequence<IntRange> {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(@NotNull CharSequence charSequence, int i, int i2, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(function2, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<IntRange> iterator() {
        return new Object(this) { // from class: kotlin.text.DelimitedRangesSequence$iterator$1
            public int a = -1;
            public int b;
            public int c;
            @Nullable
            public IntRange d;
            public int e;
            public final /* synthetic */ DelimitedRangesSequence f;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.f = r3;
                int coerceIn = e.coerceIn(r3.b, 0, r3.a.length());
                this.b = coerceIn;
                this.c = coerceIn;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
                if (r6 < r3) goto L_0x001b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a() {
                /*
                    r7 = this;
                    int r0 = r7.c
                    r1 = 0
                    if (r0 >= 0) goto L_0x000c
                    r7.a = r1
                    r0 = 0
                    r7.d = r0
                    goto L_0x0086
                L_0x000c:
                    kotlin.text.DelimitedRangesSequence r2 = r7.f
                    int r3 = r2.c
                    r4 = -1
                    r5 = 1
                    if (r3 <= 0) goto L_0x001b
                    int r6 = r7.e
                    int r6 = r6 + r5
                    r7.e = r6
                    if (r6 >= r3) goto L_0x0023
                L_0x001b:
                    java.lang.CharSequence r2 = r2.a
                    int r2 = r2.length()
                    if (r0 <= r2) goto L_0x0037
                L_0x0023:
                    int r0 = r7.b
                    kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
                    kotlin.text.DelimitedRangesSequence r2 = r7.f
                    java.lang.CharSequence r2 = r2.a
                    int r2 = kotlin.text.StringsKt__StringsKt.getLastIndex(r2)
                    r1.<init>(r0, r2)
                    r7.d = r1
                    r7.c = r4
                    goto L_0x0084
                L_0x0037:
                    kotlin.text.DelimitedRangesSequence r0 = r7.f
                    kotlin.jvm.functions.Function2<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> r2 = r0.d
                    java.lang.CharSequence r0 = r0.a
                    int r3 = r7.c
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    java.lang.Object r0 = r2.invoke(r0, r3)
                    kotlin.Pair r0 = (kotlin.Pair) r0
                    if (r0 != 0) goto L_0x005f
                    int r0 = r7.b
                    kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
                    kotlin.text.DelimitedRangesSequence r2 = r7.f
                    java.lang.CharSequence r2 = r2.a
                    int r2 = kotlin.text.StringsKt__StringsKt.getLastIndex(r2)
                    r1.<init>(r0, r2)
                    r7.d = r1
                    r7.c = r4
                    goto L_0x0084
                L_0x005f:
                    java.lang.Object r2 = r0.component1()
                    java.lang.Number r2 = (java.lang.Number) r2
                    int r2 = r2.intValue()
                    java.lang.Object r0 = r0.component2()
                    java.lang.Number r0 = (java.lang.Number) r0
                    int r0 = r0.intValue()
                    int r3 = r7.b
                    kotlin.ranges.IntRange r3 = t6.v.e.until(r3, r2)
                    r7.d = r3
                    int r2 = r2 + r0
                    r7.b = r2
                    if (r0 != 0) goto L_0x0081
                    r1 = 1
                L_0x0081:
                    int r2 = r2 + r1
                    r7.c = r2
                L_0x0084:
                    r7.a = r5
                L_0x0086:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
            }

            public final int getCounter() {
                return this.e;
            }

            public final int getCurrentStartIndex() {
                return this.b;
            }

            @Nullable
            public final IntRange getNextItem() {
                return this.d;
            }

            public final int getNextSearchIndex() {
                return this.c;
            }

            public final int getNextState() {
                return this.a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.a == -1) {
                    a();
                }
                return this.a == 1;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setCounter(int i) {
                this.e = i;
            }

            public final void setCurrentStartIndex(int i) {
                this.b = i;
            }

            public final void setNextItem(@Nullable IntRange intRange) {
                this.d = intRange;
            }

            public final void setNextSearchIndex(int i) {
                this.c = i;
            }

            public final void setNextState(int i) {
                this.a = i;
            }

            @Override // java.util.Iterator
            @NotNull
            public IntRange next() {
                if (this.a == -1) {
                    a();
                }
                if (this.a != 0) {
                    IntRange intRange = this.d;
                    Objects.requireNonNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                    this.d = null;
                    this.a = -1;
                    return intRange;
                }
                throw new NoSuchElementException();
            }
        };
    }
}
