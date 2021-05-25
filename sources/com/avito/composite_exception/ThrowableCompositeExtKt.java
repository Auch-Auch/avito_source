package com.avito.composite_exception;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "throwable", "composeWith", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "composite-exception"}, k = 2, mv = {1, 4, 2})
public final class ThrowableCompositeExtKt {
    @Nullable
    public static final Throwable composeWith(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null) {
            return th2;
        }
        if (th2 == null) {
            return th;
        }
        return new CompositeException(th.getMessage() + ". \n " + th2.getMessage(), new Throwable[]{th, th2});
    }
}
