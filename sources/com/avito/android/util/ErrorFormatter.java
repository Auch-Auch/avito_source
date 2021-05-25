package com.avito.android.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J/\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "Lkotlin/Function1;", "", "unknownErrorHandler", "format", "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "api_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorFormatter extends Formatter<Throwable> {
    @NotNull
    String format(@Nullable Throwable th, @NotNull Function1<? super Throwable, String> function1);
}
