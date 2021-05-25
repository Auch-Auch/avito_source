package ru.avito.messenger.internal.reconnect;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.ReconnectIntervalGenerator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/internal/reconnect/FixedReconnectIntervalGenerator;", "Lru/avito/messenger/ReconnectIntervalGenerator;", "", "attempt", "Ljava/util/concurrent/TimeUnit;", "unit", "", "getIntervalForAttempt", "(ILjava/util/concurrent/TimeUnit;)J", AuthSource.SEND_ABUSE, "J", "delayInSeconds", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FixedReconnectIntervalGenerator implements ReconnectIntervalGenerator {
    public final long a;

    public FixedReconnectIntervalGenerator(long j) {
        this.a = j;
    }

    @Override // ru.avito.messenger.ReconnectIntervalGenerator
    public long getIntervalForAttempt(int i, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return timeUnit.convert(this.a, TimeUnit.SECONDS);
    }
}
