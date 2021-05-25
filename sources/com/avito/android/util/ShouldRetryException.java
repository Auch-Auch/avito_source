package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/ShouldRetryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/avito/android/remote/model/TypedResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/TypedResult;", "getError", "()Lcom/avito/android/remote/model/TypedResult;", "error", "<init>", "(Lcom/avito/android/remote/model/TypedResult;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ShouldRetryException extends Exception {
    @NotNull
    public final TypedResult<?> a;

    public ShouldRetryException(@NotNull TypedResult<?> typedResult) {
        Intrinsics.checkNotNullParameter(typedResult, "error");
        this.a = typedResult;
    }

    @NotNull
    public final TypedResult<?> getError() {
        return this.a;
    }
}
