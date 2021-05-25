package com.avito.android.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/util/MasksFormatter;", "Lcom/avito/android/util/PositionFormatter;", "", "value", "filterUnconstrainedLetters", "(Ljava/lang/String;)Ljava/lang/String;", "formatters_release"}, k = 1, mv = {1, 4, 2})
public interface MasksFormatter extends PositionFormatter {
    @NotNull
    String filterUnconstrainedLetters(@Nullable String str);
}
