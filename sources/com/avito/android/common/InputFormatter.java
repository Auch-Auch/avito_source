package com.avito.android.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/common/InputFormatter;", "", "Lcom/avito/android/common/InputData;", "data", "format", "(Lcom/avito/android/common/InputData;)Lcom/avito/android/common/InputData;", "", "raw", "(Lcom/avito/android/common/InputData;)Ljava/lang/CharSequence;", "", "getInputType", "()I", "inputType", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public interface InputFormatter {
    @NotNull
    InputData format(@NotNull InputData inputData);

    int getInputType();

    @NotNull
    CharSequence raw(@NotNull InputData inputData);
}
