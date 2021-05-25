package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/PretendError;", "Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/model/PretendResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/PretendResult;", "getPretendResult", "()Lcom/avito/android/remote/model/PretendResult;", "pretendResult", "<init>", "(Lcom/avito/android/remote/model/PretendResult;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PretendError implements TypedError {
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
