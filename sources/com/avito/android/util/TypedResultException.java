package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/TypedResultException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/avito/android/remote/error/TypedError;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedError;", "getErrorResult", "()Lcom/avito/android/remote/error/TypedError;", "errorResult", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Lcom/avito/android/remote/error/TypedError;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class TypedResultException extends Exception {
    @NotNull
    public final String a;
    @NotNull
    public final TypedError b;

    public TypedResultException(@NotNull TypedError typedError) {
        Intrinsics.checkNotNullParameter(typedError, "errorResult");
        this.b = typedError;
        this.a = typedError instanceof ErrorWithMessage ? ((ErrorWithMessage) typedError).getMessage() : "";
    }

    @NotNull
    public final TypedError getErrorResult() {
        return this.b;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.a;
    }
}
