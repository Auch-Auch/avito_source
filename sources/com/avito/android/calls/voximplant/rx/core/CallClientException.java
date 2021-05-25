package com.avito.android.calls.voximplant.rx.core;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\n\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\n\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "Z", "getNeedRetry", "()Z", "needRetry", "AuthorizationException", "BadParamsException", "CantGetUsernameException", "CantUpdatePushTokenException", "ConnectionException", "InternalException", "InvalidCredentialsException", "InvalidOneTimeKeyException", "LoginFailedException", "RefreshTokenFailedException", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$AuthorizationException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$LoginFailedException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InternalException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$BadParamsException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$RefreshTokenFailedException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InvalidOneTimeKeyException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$CantGetUsernameException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$CantUpdatePushTokenException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InvalidCredentialsException;", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallClientException extends Exception {
    public final boolean a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$AuthorizationException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthorizationException extends CallClientException {
        @Nullable
        public final Throwable b;

        public AuthorizationException(@Nullable Throwable th) {
            super(true, null);
            this.b = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$BadParamsException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class BadParamsException extends CallClientException {
        public BadParamsException() {
            super(true, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$CantGetUsernameException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CantGetUsernameException extends CallClientException {
        public CantGetUsernameException() {
            super(true, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$CantUpdatePushTokenException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CantUpdatePushTokenException extends CallClientException {
        @Nullable
        public final Throwable b;

        public CantUpdatePushTokenException() {
            this(null, 1, null);
        }

        public CantUpdatePushTokenException(@Nullable Throwable th) {
            super(true, null);
            this.b = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CantUpdatePushTokenException(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "CannotConnectException", "CannotDisconnectException", "NoInternetConnectionException", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$NoInternetConnectionException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$CannotConnectException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$CannotDisconnectException;", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ConnectionException extends CallClientException {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$CannotConnectException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "", "needRetry", "<init>", "(ZLjava/lang/Throwable;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class CannotConnectException extends ConnectionException {
            @Nullable
            public final Throwable b;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CannotConnectException(boolean z, Throwable th, int i, j jVar) {
                this(z, (i & 2) != 0 ? null : th);
            }

            @Override // java.lang.Throwable
            @Nullable
            public Throwable getCause() {
                return this.b;
            }

            public CannotConnectException(boolean z, @Nullable Throwable th) {
                super(z, null);
                this.b = th;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$CannotDisconnectException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "", "needRetry", "<init>", "(ZLjava/lang/Throwable;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class CannotDisconnectException extends ConnectionException {
            @Nullable
            public final Throwable b;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CannotDisconnectException(boolean z, Throwable th, int i, j jVar) {
                this(z, (i & 2) != 0 ? null : th);
            }

            @Override // java.lang.Throwable
            @Nullable
            public Throwable getCause() {
                return this.b;
            }

            public CannotDisconnectException(boolean z, @Nullable Throwable th) {
                super(z, null);
                this.b = th;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException$NoInternetConnectionException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException$ConnectionException;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class NoInternetConnectionException extends ConnectionException {
            public NoInternetConnectionException() {
                super(true, null);
            }
        }

        public ConnectionException(boolean z, j jVar) {
            super(z, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InternalException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class InternalException extends CallClientException {
        @Nullable
        public final String b;

        public InternalException(@Nullable String str) {
            super(true, null);
            this.b = str;
        }

        @Override // java.lang.Throwable
        @Nullable
        public String getMessage() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InvalidCredentialsException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class InvalidCredentialsException extends CallClientException {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InvalidCredentialsException(@NotNull String str) {
            super(false, null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.b = str;
        }

        @Override // java.lang.Throwable
        @NotNull
        public String getMessage() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$InvalidOneTimeKeyException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class InvalidOneTimeKeyException extends CallClientException {
        public InvalidOneTimeKeyException() {
            super(true, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$LoginFailedException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", "needRetry", "<init>", "(Z)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoginFailedException extends CallClientException {
        public LoginFailedException(boolean z) {
            super(z, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/core/CallClientException$RefreshTokenFailedException;", "Lcom/avito/android/calls/voximplant/rx/core/CallClientException;", "", "needRetry", "<init>", "(Z)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class RefreshTokenFailedException extends CallClientException {
        public RefreshTokenFailedException(boolean z) {
            super(z, null);
        }
    }

    public CallClientException(boolean z, j jVar) {
        this.a = z;
    }

    public final boolean getNeedRetry() {
        return this.a;
    }
}
