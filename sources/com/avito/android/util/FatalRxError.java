package com.avito.android.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/util/FatalRxError;", "Ljava/lang/LinkageError;", "", "message", "<init>", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "rx"}, k = 1, mv = {1, 4, 2})
public class FatalRxError extends LinkageError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FatalRxError(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FatalRxError(@NotNull String str, @NotNull Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "cause");
    }
}
