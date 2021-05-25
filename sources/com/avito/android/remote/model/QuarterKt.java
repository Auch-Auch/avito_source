package com.avito.android.remote.model;

import com.avito.android.remote.model.category_parameters.QuartersParameter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/Quarter;", "Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "toQuartersParameterValue", "(Lcom/avito/android/remote/model/Quarter;)Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class QuarterKt {
    @Nullable
    public static final QuartersParameter.Value toQuartersParameterValue(@Nullable Quarter quarter) {
        if (quarter == null) {
            return null;
        }
        return new QuartersParameter.Value(quarter.getToInt(), quarter.getFromInt());
    }
}
