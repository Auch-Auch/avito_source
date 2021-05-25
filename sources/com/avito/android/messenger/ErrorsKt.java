package com.avito.android.messenger;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a0\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0006\u0010\u0007\"+\u0010\u0003\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00058À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"+\u0010\u0001\u001a\u00020\u0000*\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00058À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*$\b\u0000\u0010\f\"\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/ErrorType;", "type", "", "message", "Lkotlin/Pair;", "Lcom/avito/android/messenger/ErrorMetaInfo;", "errorMetaInfo", "(Lcom/avito/android/messenger/ErrorType;Ljava/lang/String;)Lkotlin/Pair;", "getMessage", "(Lkotlin/Pair;)Ljava/lang/String;", "getType", "(Lkotlin/Pair;)Lcom/avito/android/messenger/ErrorType;", "ErrorMetaInfo", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ErrorsKt {
    @NotNull
    public static final Pair<ErrorType, String> errorMetaInfo(@NotNull ErrorType errorType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(errorType, "type");
        Intrinsics.checkNotNullParameter(str, "message");
        return TuplesKt.to(errorType, str);
    }

    @NotNull
    public static final String getMessage(@NotNull Pair<? extends ErrorType, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$message");
        return pair.getSecond();
    }

    @NotNull
    public static final ErrorType getType(@NotNull Pair<? extends ErrorType, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$type");
        return (ErrorType) pair.getFirst();
    }
}
