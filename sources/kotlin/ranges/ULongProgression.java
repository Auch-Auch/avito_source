package kotlin.ranges;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
import t6.v.g;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B$\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0017\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001a\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006$"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "Lkotlin/collections/ULongIterator;", "iterator", "()Lkotlin/collections/ULongIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "J", "getLast-s-VKNKU", "()J", "last", AuthSource.SEND_ABUSE, "getFirst-s-VKNKU", InternalConstsKt.FIRST_IMAGE, "", "c", "getStep", AnalyticFieldsName.step, Tracker.Events.CREATIVE_START, "endInclusive", "<init>", "(JJJLt6/r/a/j;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    public final long b;
    public final long c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "Lkotlin/ULong;", "rangeStart", "rangeEnd", "", AnalyticFieldsName.step, "Lkotlin/ranges/ULongProgression;", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "fromClosedRange", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        /* renamed from: fromClosedRange-7ftBX0g  reason: not valid java name */
        public final ULongProgression m418fromClosedRange7ftBX0g(long j, long j2, long j3) {
            return new ULongProgression(j, j2, j3, null);
        }

        public Companion(j jVar) {
        }
    }

    public ULongProgression(long j, long j2, long j3, j jVar) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.a = j;
            this.b = UProgressionUtilKt.m399getProgressionLastElement7ftBX0g(j, j2, j3);
            this.c = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (!(this.a == uLongProgression.a && this.b == uLongProgression.b && this.c == uLongProgression.c)) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-s-VKNKU  reason: not valid java name */
    public final long m416getFirstsVKNKU() {
        return this.a;
    }

    /* renamed from: getLast-s-VKNKU  reason: not valid java name */
    public final long m417getLastsVKNKU() {
        return this.b;
    }

    public final long getStep() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.a;
        long j2 = this.b;
        long j3 = this.c;
        return ((int) (j3 ^ (j3 >>> 32))) + (((((int) ULong.m302constructorimpl(j ^ ULong.m302constructorimpl(j >>> 32))) * 31) + ((int) ULong.m302constructorimpl(j2 ^ ULong.m302constructorimpl(j2 >>> 32)))) * 31);
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        int i = (this.c > 0 ? 1 : (this.c == 0 ? 0 : -1));
        int ulongCompare = UnsignedKt.ulongCompare(this.a, this.b);
        if (i > 0) {
            if (ulongCompare > 0) {
                return true;
            }
        } else if (ulongCompare < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder sb;
        long j;
        if (this.c > 0) {
            sb.append(ULong.m306toStringimpl(this.a));
            sb.append("..");
            sb.append(ULong.m306toStringimpl(this.b));
            sb.append(" step ");
            j = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(ULong.m306toStringimpl(this.a));
            sb.append(" downTo ");
            sb.append(ULong.m306toStringimpl(this.b));
            sb.append(" step ");
            j = -this.c;
        }
        sb.append(j);
        return sb.toString();
    }

    /* Return type fixed from 'kotlin.collections.ULongIterator' to match base method */
    @Override // java.lang.Iterable
    @NotNull
    public Iterator<ULong> iterator() {
        return new g(this.a, this.b, this.c, null);
    }
}
