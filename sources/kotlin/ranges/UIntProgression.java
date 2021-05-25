package kotlin.ranges;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
import t6.v.f;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0017\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B$\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0016\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\u0019\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u000fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\""}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "Lkotlin/collections/UIntIterator;", "iterator", "()Lkotlin/collections/UIntIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "I", "getFirst-pVg5ArA", InternalConstsKt.FIRST_IMAGE, AuthSource.BOOKING_ORDER, "getLast-pVg5ArA", "last", "c", "getStep", AnalyticFieldsName.step, Tracker.Events.CREATIVE_START, "endInclusive", "<init>", "(IIILt6/r/a/j;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    public final int b;
    public final int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "Lkotlin/UInt;", "rangeStart", "rangeEnd", "", AnalyticFieldsName.step, "Lkotlin/ranges/UIntProgression;", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "fromClosedRange", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        /* renamed from: fromClosedRange-Nkh28Cs  reason: not valid java name */
        public final UIntProgression m412fromClosedRangeNkh28Cs(int i, int i2, int i3) {
            return new UIntProgression(i, i2, i3, null);
        }

        public Companion(j jVar) {
        }
    }

    public UIntProgression(int i, int i2, int i3, j jVar) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.a = i;
            this.b = UProgressionUtilKt.m400getProgressionLastElementNkh28Cs(i, i2, i3);
            this.c = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntProgression) {
            if (!isEmpty() || !((UIntProgression) obj).isEmpty()) {
                UIntProgression uIntProgression = (UIntProgression) obj;
                if (!(this.a == uIntProgression.a && this.b == uIntProgression.b && this.c == uIntProgression.c)) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-pVg5ArA  reason: not valid java name */
    public final int m410getFirstpVg5ArA() {
        return this.a;
    }

    /* renamed from: getLast-pVg5ArA  reason: not valid java name */
    public final int m411getLastpVg5ArA() {
        return this.b;
    }

    public final int getStep() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (this.c > 0) {
            if (UnsignedKt.uintCompare(this.a, this.b) > 0) {
                return true;
            }
        } else if (UnsignedKt.uintCompare(this.a, this.b) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        int i;
        StringBuilder sb;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(UInt.m281toStringimpl(this.a));
            sb.append("..");
            sb.append(UInt.m281toStringimpl(this.b));
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(UInt.m281toStringimpl(this.a));
            sb.append(" downTo ");
            sb.append(UInt.m281toStringimpl(this.b));
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }

    /* Return type fixed from 'kotlin.collections.UIntIterator' to match base method */
    @Override // java.lang.Iterable
    @NotNull
    public Iterator<UInt> iterator() {
        return new f(this.a, this.b, this.c, null);
    }
}
