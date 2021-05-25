package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lru/avito/messenger/ReconnectPolicy;", "", "<init>", "()V", "Backoff", "Fixed", "Lru/avito/messenger/ReconnectPolicy$Fixed;", "Lru/avito/messenger/ReconnectPolicy$Backoff;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ReconnectPolicy {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/ReconnectPolicy$Fixed;", "Lru/avito/messenger/ReconnectPolicy;", "", AuthSource.SEND_ABUSE, "J", "getDelayInSeconds", "()J", "delayInSeconds", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Fixed extends ReconnectPolicy {
        public final long a;

        public Fixed(long j) {
            super(null);
            this.a = j;
        }

        public final long getDelayInSeconds() {
            return this.a;
        }
    }

    public ReconnectPolicy() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/ReconnectPolicy$Backoff;", "Lru/avito/messenger/ReconnectPolicy;", "", AuthSource.SEND_ABUSE, "[J", "getIntervalsInSeconds", "()[J", "intervalsInSeconds", "", AuthSource.BOOKING_ORDER, "D", "getJitter", "()D", "jitter", "<init>", "([JD)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Backoff extends ReconnectPolicy {
        @NotNull
        public final long[] a;
        public final double b;

        public Backoff() {
            this(null, 0.0d, 3, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Backoff(long[] jArr, double d, int i, j jVar) {
            this((i & 1) != 0 ? ReconnectPolicyKt.access$getBACKOFF_INTERVALS_S$p() : jArr, (i & 2) != 0 ? 0.2d : d);
        }

        @NotNull
        public final long[] getIntervalsInSeconds() {
            return this.a;
        }

        public final double getJitter() {
            return this.b;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Backoff(@NotNull long[] jArr, double d) {
            super(null);
            Intrinsics.checkNotNullParameter(jArr, "intervalsInSeconds");
            this.a = jArr;
            this.b = d;
        }
    }

    public ReconnectPolicy(j jVar) {
    }
}
