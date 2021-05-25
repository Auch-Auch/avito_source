package kotlin.time;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001f\u0010\n\u001a\u00020\u00058\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006 "}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "component1", "()Ljava/lang/Object;", "Lkotlin/time/Duration;", "component2-UwyO8pc", "()D", "component2", "value", "duration", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", AuthSource.BOOKING_ORDER, "D", "getDuration-UwyO8pc", "<init>", "(Ljava/lang/Object;DLt6/r/a/j;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public final class TimedValue<T> {
    public final T a;
    public final double b;

    public TimedValue(T t, double d) {
        this.a = t;
        this.b = d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.time.TimedValue */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default  reason: not valid java name */
    public static /* synthetic */ TimedValue m492copyRFiDyg4$default(TimedValue timedValue, Object obj, double d, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.a;
        }
        if ((i & 2) != 0) {
            d = timedValue.b;
        }
        return timedValue.m494copyRFiDyg4(obj, d);
    }

    public final T component1() {
        return this.a;
    }

    /* renamed from: component2-UwyO8pc  reason: not valid java name */
    public final double m493component2UwyO8pc() {
        return this.b;
    }

    @NotNull
    /* renamed from: copy-RFiDyg4  reason: not valid java name */
    public final TimedValue<T> m494copyRFiDyg4(T t, double d) {
        return new TimedValue<>(t, d);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) obj;
        return Intrinsics.areEqual(this.a, timedValue.a) && Double.compare(this.b, timedValue.b) == 0;
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final double m495getDurationUwyO8pc() {
        return this.b;
    }

    public final T getValue() {
        return this.a;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TimedValue(value=");
        L.append((Object) this.a);
        L.append(", duration=");
        L.append(Duration.m482toStringimpl(this.b));
        L.append(")");
        return L.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public TimedValue(Object obj, double d, j jVar) {
        this.a = obj;
        this.b = d;
    }
}
