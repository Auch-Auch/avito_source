package com.avito.android.remote.error;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "", "", "throwable", "Lcom/avito/android/remote/error/TypedError;", "convert", "(Ljava/lang/Throwable;)Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/error/SpecialCase;", "specialCase", "convertWithSpecialErrorCase", "(Ljava/lang/Throwable;Lcom/avito/android/remote/error/SpecialCase;)Lcom/avito/android/remote/error/TypedError;", "api_release"}, k = 1, mv = {1, 4, 2})
public interface TypedErrorThrowableConverter {
    @NotNull
    TypedError convert(@NotNull Throwable th);

    @NotNull
    TypedError convertWithSpecialErrorCase(@NotNull Throwable th, @NotNull SpecialCase specialCase);
}
