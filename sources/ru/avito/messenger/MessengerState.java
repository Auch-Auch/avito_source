package ru.avito.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lru/avito/messenger/MessengerState;", "", "<init>", "()V", "Connected", "Connecting", "Disconnected", "Lru/avito/messenger/MessengerState$Connected;", "Lru/avito/messenger/MessengerState$Connecting;", "Lru/avito/messenger/MessengerState$Disconnected;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class MessengerState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/avito/messenger/MessengerState$Connected;", "Lru/avito/messenger/MessengerState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends MessengerState {
        @NotNull
        public static final Connected INSTANCE = new Connected();

        public Connected() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Connected";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lru/avito/messenger/MessengerState$Connecting;", "Lru/avito/messenger/MessengerState;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Z", "isDisconnected", "()Z", "<init>", "(Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connecting extends MessengerState {
        public final boolean a;

        public Connecting() {
            this(false, 1, null);
        }

        public Connecting(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean isDisconnected() {
            return this.a;
        }

        @NotNull
        public String toString() {
            return "Connecting";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Connecting(boolean z, int i, j jVar) {
            this((i & 1) != 0 ? false : z);
        }
    }

    public MessengerState() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/avito/messenger/MessengerState$Disconnected;", "Lru/avito/messenger/MessengerState;", "", "toString", "()Ljava/lang/String;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "getEvent", "()Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "event", "", AuthSource.BOOKING_ORDER, "J", "getTimestamp", "()J", "timestamp", "<init>", "(Lru/avito/messenger/internal/entity/messenger/TerminationEvent;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Disconnected extends MessengerState {
        @NotNull
        public final TerminationEvent a;
        public final long b;

        public Disconnected() {
            this(null, 0, 3, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Disconnected(TerminationEvent terminationEvent, long j, int i, j jVar) {
            this((i & 1) != 0 ? new TerminationEvent.Unknown(null, null, null, 7, null) : terminationEvent, (i & 2) != 0 ? System.currentTimeMillis() : j);
        }

        @NotNull
        public final TerminationEvent getEvent() {
            return this.a;
        }

        public final long getTimestamp() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Disconnected.class.getSimpleName());
            sb.append("={event=");
            sb.append(this.a.getClass().getSimpleName());
            sb.append(",timestamp=");
            return a.k(sb, this.b, '}');
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Disconnected(@NotNull TerminationEvent terminationEvent, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(terminationEvent, "event");
            this.a = terminationEvent;
            this.b = j;
        }
    }

    public MessengerState(j jVar) {
    }
}
