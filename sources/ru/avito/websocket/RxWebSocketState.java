package ru.avito.websocket;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.test.KeepSyntheticConstructorsForTesting;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lru/avito/websocket/RxWebSocketState;", "", "<init>", "()V", "Connected", "Connecting", "Disconnected", "Lru/avito/websocket/RxWebSocketState$Connected;", "Lru/avito/websocket/RxWebSocketState$Connecting;", "Lru/avito/websocket/RxWebSocketState$Disconnected;", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public abstract class RxWebSocketState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/avito/websocket/RxWebSocketState$Connected;", "Lru/avito/websocket/RxWebSocketState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends RxWebSocketState {
        public Connected() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Connected";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/avito/websocket/RxWebSocketState$Connecting;", "Lru/avito/websocket/RxWebSocketState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
    public static final class Connecting extends RxWebSocketState {
        public Connecting() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Connecting";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/avito/websocket/RxWebSocketState$Disconnected;", "Lru/avito/websocket/RxWebSocketState;", "", "toString", "()Ljava/lang/String;", "", "c", "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "", AuthSource.SEND_ABUSE, "I", "getCode", "()I", "code", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getReason", "reason", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
    @KeepSyntheticConstructorsForTesting
    public static final class Disconnected extends RxWebSocketState {
        public final int a;
        @Nullable
        public final String b;
        @Nullable
        public final Throwable c;

        public Disconnected() {
            this(0, null, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Disconnected(int i, String str, Throwable th, int i2, j jVar) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : th);
        }

        public final int getCode() {
            return this.a;
        }

        @Nullable
        public final Throwable getError() {
            return this.c;
        }

        @Nullable
        public final String getReason() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Disconnected{code=");
            L.append(this.a);
            L.append(", reason=\"");
            L.append(this.b);
            L.append("\", error=\"");
            Throwable th = this.c;
            return a.t(L, th != null ? th.getMessage() : null, "}\"");
        }

        public Disconnected(int i, @Nullable String str, @Nullable Throwable th) {
            super(null);
            this.a = i;
            this.b = str;
            this.c = th;
        }
    }

    public RxWebSocketState() {
    }

    public RxWebSocketState(j jVar) {
    }
}
