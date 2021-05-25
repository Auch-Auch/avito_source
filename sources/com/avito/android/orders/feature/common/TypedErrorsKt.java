package com.avito.android.orders.feature.common;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/error/TypedError;", "", "toErrorMessage", "(Lcom/avito/android/remote/error/TypedError;)Ljava/lang/String;", "orders_release"}, k = 2, mv = {1, 4, 2})
public final class TypedErrorsKt {
    @NotNull
    public static final String toErrorMessage(@NotNull TypedError typedError) {
        Intrinsics.checkNotNullParameter(typedError, "$this$toErrorMessage");
        return typedError instanceof ErrorWithMessage ? ((ErrorWithMessage) typedError).getMessage() : typedError.toString();
    }
}
