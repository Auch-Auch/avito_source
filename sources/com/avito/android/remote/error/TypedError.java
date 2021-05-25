package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/error/TypedError;", "", "ErrorMap", "PretendError", "UnauthorizedError", "models_release"}, k = 1, mv = {1, 4, 2})
public interface TypedError {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/error/TypedError$ErrorMap;", "Lcom/avito/android/remote/error/TypedError;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "messages", "<init>", "(Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorMap implements TypedError {
        @NotNull
        public final Map<String, String> a;

        public ErrorMap(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "messages");
            this.a = map;
        }

        @NotNull
        public final Map<String, String> getMessages() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/TypedError$PretendError;", "Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/model/PretendResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/PretendResult;", "getPretendResult", "()Lcom/avito/android/remote/model/PretendResult;", "pretendResult", "<init>", "(Lcom/avito/android/remote/model/PretendResult;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PretendError implements TypedError {
        @NotNull
        public final PretendResult a;

        public PretendError(@NotNull PretendResult pretendResult) {
            Intrinsics.checkNotNullParameter(pretendResult, "pretendResult");
            this.a = pretendResult;
        }

        @NotNull
        public final PretendResult getPretendResult() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/error/TypedError$UnauthorizedError;", "Lcom/avito/android/remote/error/TypedError;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnauthorizedError implements TypedError {
    }
}
