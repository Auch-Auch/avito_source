package ru.avito.messenger.internal.entity.messenger;

import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0006\t\b\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", "", "getCode", "()Ljava/lang/Integer;", "code", "<init>", "()V", "Companion", "ClosedByUser", "ForbiddenError", NativeProtocol.ERROR_NETWORK_ERROR, "UnauthorizedError", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lru/avito/messenger/internal/entity/messenger/TerminationEvent$UnauthorizedError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent$ForbiddenError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent$ClosedByUser;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent$NetworkError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class TerminationEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$ClosedByUser;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()Ljava/lang/Integer;", "code", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClosedByUser extends TerminationEvent {
        public final int a = 1000;

        public ClosedByUser() {
            super(null);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.TerminationEvent
        @NotNull
        public Integer getCode() {
            return Integer.valueOf(this.a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$Companion;", "", "", "throwable", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "fromThrowable", "(Ljava/lang/Throwable;)Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TerminationEvent fromThrowable(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            if (th instanceof JsonRpcCallException) {
                int code = ((JsonRpcCallException) th).getCode();
                String message = th.getMessage();
                if (code != -32043) {
                    if (!(code == -32041 || code == 401)) {
                        if (code != 403) {
                            if (code == 1000) {
                                return new ClosedByUser();
                            }
                            if (code != 3401) {
                                if (code != 3403) {
                                    return new Unknown(Integer.valueOf(code), message, th);
                                }
                            }
                        }
                    }
                    return new UnauthorizedError(code, th);
                }
                return new ForbiddenError(th);
            } else if (th instanceof IOException) {
                return new NetworkError(th);
            } else {
                return new Unknown(null, th.getMessage(), th);
            }
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$UnauthorizedError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()Ljava/lang/Integer;", "code", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(ILjava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnauthorizedError extends TerminationEvent {
        public final int a;
        @Nullable
        public final Throwable b;

        public UnauthorizedError(int i, @Nullable Throwable th) {
            super(null);
            this.a = i;
            this.b = th;
        }

        @Override // ru.avito.messenger.internal.entity.messenger.TerminationEvent
        @NotNull
        public Integer getCode() {
            return Integer.valueOf(this.a);
        }

        @Nullable
        public final Throwable getError() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnauthorizedError(int i, Throwable th, int i2, j jVar) {
            this(i, (i2 & 2) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$Unknown;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "code", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "", "c", "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends TerminationEvent {
        @Nullable
        public final Integer a;
        @Nullable
        public final String b;
        @Nullable
        public final Throwable c;

        public Unknown() {
            this(null, null, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(Integer num, String str, Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.TerminationEvent
        @Nullable
        public Integer getCode() {
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

        public Unknown(@Nullable Integer num, @Nullable String str, @Nullable Throwable th) {
            super(null);
            this.a = num;
            this.b = str;
            this.c = th;
        }
    }

    public TerminationEvent() {
    }

    @Nullable
    public abstract Integer getCode();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$ForbiddenError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()Ljava/lang/Integer;", "code", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForbiddenError extends TerminationEvent {
        public final int a;
        @Nullable
        public final Throwable b;

        public ForbiddenError() {
            this(null, 1, null);
        }

        public ForbiddenError(@Nullable Throwable th) {
            super(null);
            this.b = th;
            this.a = 3403;
        }

        @Override // ru.avito.messenger.internal.entity.messenger.TerminationEvent
        @NotNull
        public Integer getCode() {
            return Integer.valueOf(this.a);
        }

        @Nullable
        public final Throwable getError() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ForbiddenError(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent$NetworkError;", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "", AuthSource.SEND_ABUSE, "I", "getCode", "()Ljava/lang/Integer;", "code", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends TerminationEvent {
        public final int a;
        @Nullable
        public final Throwable b;

        public NetworkError() {
            this(null, 1, null);
        }

        public NetworkError(@Nullable Throwable th) {
            super(null);
            this.b = th;
            this.a = -1;
        }

        @Override // ru.avito.messenger.internal.entity.messenger.TerminationEvent
        @NotNull
        public Integer getCode() {
            return Integer.valueOf(this.a);
        }

        @Nullable
        public final Throwable getError() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkError(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    public TerminationEvent(j jVar) {
    }
}
