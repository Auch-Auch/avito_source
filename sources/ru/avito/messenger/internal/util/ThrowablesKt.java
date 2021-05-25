package ru.avito.messenger.internal.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "toErrorMessage", "(Ljava/lang/Throwable;)Ljava/lang/String;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ThrowablesKt {
    @NotNull
    public static final String toErrorMessage(@Nullable Throwable th) {
        String message;
        return (th == null || (message = th.getMessage()) == null) ? "" : message;
    }
}
