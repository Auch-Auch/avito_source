package kotlin.ranges;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B!\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006$"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "Lkotlin/collections/CharIterator;", "iterator", "()Lkotlin/collections/CharIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "c", "I", "getStep", AnalyticFieldsName.step, AuthSource.SEND_ABUSE, "C", "getFirst", "()C", InternalConstsKt.FIRST_IMAGE, AuthSource.BOOKING_ORDER, "getLast", "last", Tracker.Events.CREATIVE_START, "endInclusive", "<init>", "(CCI)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public class CharProgression implements Iterable<Character>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final char a;
    public final char b;
    public final int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "", "rangeStart", "rangeEnd", "", AnalyticFieldsName.step, "Lkotlin/ranges/CharProgression;", "fromClosedRange", "(CCI)Lkotlin/ranges/CharProgression;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CharProgression fromClosedRange(char c, char c2, int i) {
            return new CharProgression(c, c2, i);
        }

        public Companion(j jVar) {
        }
    }

    public CharProgression(char c2, char c3, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i != Integer.MIN_VALUE) {
            this.a = c2;
            this.b = (char) ProgressionUtilKt.getProgressionLastElement((int) c2, (int) c3, i);
            this.c = i;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CharProgression) {
            if (!isEmpty() || !((CharProgression) obj).isEmpty()) {
                CharProgression charProgression = (CharProgression) obj;
                if (!(this.a == charProgression.a && this.b == charProgression.b && this.c == charProgression.c)) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.a;
    }

    public final char getLast() {
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
            if (Intrinsics.compare((int) this.a, (int) this.b) > 0) {
                return true;
            }
        } else if (Intrinsics.compare((int) this.a, (int) this.b) < 0) {
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
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }

    /* Return type fixed from 'kotlin.collections.CharIterator' to match base method */
    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Character> iterator() {
        return new CharProgressionIterator(this.a, this.b, this.c);
    }
}
