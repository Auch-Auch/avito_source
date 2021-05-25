package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UserDialog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/ErrorWithMessage;", "Lcom/avito/android/remote/error/TypedError;", "", "getMessage", "()Ljava/lang/String;", "message", "ErrorDialog", NativeProtocol.ERROR_NETWORK_ERROR, "SimpleMessageError", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "models_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorWithMessage extends TypedError {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/ErrorWithMessage$ErrorDialog;", "Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/model/UserDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/UserDialog;", "getData", "()Lcom/avito/android/remote/model/UserDialog;", "data", "<init>", "(Lcom/avito/android/remote/model/UserDialog;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorDialog implements TypedError {
        @NotNull
        public final UserDialog a;

        public ErrorDialog(@NotNull UserDialog userDialog) {
            Intrinsics.checkNotNullParameter(userDialog, "data");
            this.a = userDialog;
        }

        @NotNull
        public final UserDialog getData() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/ErrorWithMessage$NetworkError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public NetworkError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/ErrorWithMessage$SimpleMessageError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class SimpleMessageError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public SimpleMessageError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/error/ErrorWithMessage$Unknown;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown implements ErrorWithMessage {
        @NotNull
        public final String a;
        @NotNull
        public final Throwable b;

        public Unknown(@NotNull String str, @NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.a = str;
            this.b = th;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }

        @NotNull
        public final Throwable getThrowable() {
            return this.b;
        }
    }

    @NotNull
    String getMessage();
}
