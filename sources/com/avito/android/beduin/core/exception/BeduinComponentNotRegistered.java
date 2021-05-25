package com.avito.android.beduin.core.exception;

import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/beduin/core/exception/BeduinComponentNotRegistered;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(Ljava/lang/String;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinComponentNotRegistered extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeduinComponentNotRegistered(@NotNull String str) {
        super("Component for model " + str + " is not registered in BeduinRegistry");
        Intrinsics.checkNotNullParameter(str, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
    }
}
