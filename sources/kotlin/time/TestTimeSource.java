package kotlin.time;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "", "read", "()J", "Lkotlin/time/Duration;", "duration", "", "plusAssign-LRDsOJo", "(D)V", "plusAssign", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "J", "reading", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalTime
public final class TestTimeSource extends AbstractLongTimeSource {
    public long b;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    public final void a(double d) {
        StringBuilder L = a.L("TestTimeSource will overflow if its reading ");
        L.append(this.b);
        L.append("ns is advanced by ");
        L.append(Duration.m482toStringimpl(d));
        L.append(FormatterType.defaultDecimalSeparator);
        throw new IllegalStateException(L.toString());
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m490plusAssignLRDsOJo(double d) {
        long j;
        double r0 = Duration.m476toDoubleimpl(d, getUnit());
        long j2 = (long) r0;
        if (j2 == Long.MIN_VALUE || j2 == Long.MAX_VALUE) {
            double d2 = ((double) this.b) + r0;
            if (d2 > ((double) Long.MAX_VALUE) || d2 < ((double) Long.MIN_VALUE)) {
                a(d);
                throw null;
            }
            j = (long) d2;
        } else {
            long j3 = this.b;
            j = j3 + j2;
            if ((j2 ^ j3) >= 0 && (j3 ^ j) < 0) {
                a(d);
                throw null;
            }
        }
        this.b = j;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return this.b;
    }
}
