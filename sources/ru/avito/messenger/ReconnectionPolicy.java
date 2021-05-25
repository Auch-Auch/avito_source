package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lru/avito/messenger/ReconnectionPolicy;", "", "<init>", "()V", "Finite", "Infinite", "Lru/avito/messenger/ReconnectionPolicy$Finite;", "Lru/avito/messenger/ReconnectionPolicy$Infinite;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ReconnectionPolicy {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/ReconnectionPolicy$Finite;", "Lru/avito/messenger/ReconnectionPolicy;", "", AuthSource.SEND_ABUSE, "J", "getRetryPeriodMs", "()J", "retryPeriodMs", "", AuthSource.BOOKING_ORDER, "I", "getRetries", "()I", "retries", "<init>", "(JI)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Finite extends ReconnectionPolicy {
        public final long a;
        public final int b;

        public Finite(long j, int i) {
            super(null);
            this.a = j;
            this.b = i;
        }

        public final int getRetries() {
            return this.b;
        }

        public final long getRetryPeriodMs() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/ReconnectionPolicy$Infinite;", "Lru/avito/messenger/ReconnectionPolicy;", "", AuthSource.SEND_ABUSE, "J", "getRetryPeriodMs", "()J", "retryPeriodMs", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Infinite extends ReconnectionPolicy {
        public final long a;

        public Infinite(long j) {
            super(null);
            this.a = j;
        }

        public final long getRetryPeriodMs() {
            return this.a;
        }
    }

    public ReconnectionPolicy() {
    }

    public ReconnectionPolicy(j jVar) {
    }
}
