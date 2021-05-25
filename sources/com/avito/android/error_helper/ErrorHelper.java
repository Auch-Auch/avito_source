package com.avito.android.error_helper;

import com.avito.android.remote.error.TypedError;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/error_helper/ErrorHelper;", "", "", "error", "Lcom/avito/android/remote/error/TypedError;", "handle", "(Ljava/lang/Throwable;)Lcom/avito/android/remote/error/TypedError;", "errorResult", "", "recycle", "(Lcom/avito/android/remote/error/TypedError;)Ljava/lang/String;", "(Ljava/lang/Throwable;)Ljava/lang/String;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorHelper {
    @NotNull
    TypedError handle(@NotNull Throwable th);

    @NotNull
    String recycle(@NotNull TypedError typedError);

    @NotNull
    String recycle(@NotNull Throwable th);
}
