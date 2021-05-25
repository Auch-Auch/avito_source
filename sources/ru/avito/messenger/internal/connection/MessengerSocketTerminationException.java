package ru.avito.messenger.internal.connection;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "ClosedByUser", "ForbiddenError", NativeProtocol.ERROR_NETWORK_ERROR, "UnauthorizedError", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$UnauthorizedError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$ForbiddenError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$ClosedByUser;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$NetworkError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class MessengerSocketTerminationException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$ClosedByUser;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClosedByUser extends MessengerSocketTerminationException {
        public ClosedByUser() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$ForbiddenError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForbiddenError extends MessengerSocketTerminationException {
        @Nullable
        public final Throwable a;

        public ForbiddenError() {
            this(null, 1, null);
        }

        public ForbiddenError(@Nullable Throwable th) {
            super(null);
            this.a = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ForbiddenError(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$NetworkError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends MessengerSocketTerminationException {
        @Nullable
        public final Throwable a;

        public NetworkError() {
            this(null, 1, null);
        }

        public NetworkError(@Nullable Throwable th) {
            super(null);
            this.a = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkError(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$UnauthorizedError;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnauthorizedError extends MessengerSocketTerminationException {
        @Nullable
        public final Throwable a;

        public UnauthorizedError() {
            this(null, 1, null);
        }

        public UnauthorizedError(@Nullable Throwable th) {
            super(null);
            this.a = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnauthorizedError(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerSocketTerminationException$Unknown;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends MessengerSocketTerminationException {
        @Nullable
        public final String a;
        @Nullable
        public final Throwable b;

        public Unknown() {
            this(null, null, 3, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(String str, Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.b;
        }

        @Override // java.lang.Throwable
        @Nullable
        public String getMessage() {
            return this.a;
        }

        public Unknown(@Nullable String str, @Nullable Throwable th) {
            super(null);
            this.a = str;
            this.b = th;
        }
    }

    private MessengerSocketTerminationException() {
    }

    public /* synthetic */ MessengerSocketTerminationException(j jVar) {
        this();
    }
}
