package com.avito.android.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0004\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/util/PositionFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "format", "(Ljava/lang/String;)Ljava/lang/String;", "", "cursorPosition", "Lcom/avito/android/util/CursorString;", "(Ljava/lang/String;I)Lcom/avito/android/util/CursorString;", "formatters_release"}, k = 1, mv = {1, 4, 2})
public interface PositionFormatter extends Formatter<String> {
    @NotNull
    CursorString format(@Nullable String str, int i);

    @NotNull
    String format(@Nullable String str);
}
