package com.avito.android.provider;

import com.avito.android.common.InputFormatter;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/provider/InputItemFormatterProvider;", "", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "displayingOptions", "Lcom/avito/android/common/InputFormatter;", "provide", "(Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)Lcom/avito/android/common/InputFormatter;", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemFormatterProvider {
    @Nullable
    InputFormatter provide(@Nullable DisplayingOptions displayingOptions);
}
