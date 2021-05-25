package ru.avito.messenger.internal.reconnect;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.ReconnectIntervalGenerator;
import t6.s.c;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lru/avito/messenger/internal/reconnect/BackoffReconnectIntervalGenerator;", "Lru/avito/messenger/ReconnectIntervalGenerator;", "", "attempt", "Ljava/util/concurrent/TimeUnit;", "unit", "", "getIntervalForAttempt", "(ILjava/util/concurrent/TimeUnit;)J", "Lkotlin/random/Random;", AuthSource.SEND_ABUSE, "Lkotlin/random/Random;", "random", "", AuthSource.BOOKING_ORDER, "D", "jitter", "", "c", "[J", "intervalsInSeconds", "<init>", "(Lkotlin/random/Random;D[J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BackoffReconnectIntervalGenerator implements ReconnectIntervalGenerator {
    public final Random a;
    public final double b;
    public final long[] c;

    public BackoffReconnectIntervalGenerator(@NotNull Random random, double d, @NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(jArr, "intervalsInSeconds");
        this.a = random;
        this.b = d;
        this.c = jArr;
    }

    @Override // ru.avito.messenger.ReconnectIntervalGenerator
    public long getIntervalForAttempt(int i, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        long coerceAtLeast = e.coerceAtLeast(this.c[e.coerceAtMost(i, this.c.length - 1)], 0L);
        double coerceAtLeast2 = e.coerceAtLeast(this.b, 0.0d);
        return timeUnit.convert(c.roundToLong((this.a.nextDouble(-coerceAtLeast2, coerceAtLeast2) + ((double) 1)) * ((double) TimeUnit.SECONDS.toNanos(coerceAtLeast))), TimeUnit.NANOSECONDS);
    }
}
