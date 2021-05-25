package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "", "seconds", "", "applyFormValue", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "toFormValue", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;)Ljava/lang/String;", "DATE_TIME_PARAMETER_PRESENT_TIME", "Ljava/lang/String;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class DateTimeParameterKt {
    @NotNull
    public static final String DATE_TIME_PARAMETER_PRESENT_TIME = "-1";

    public static final void applyFormValue(@NotNull DateTimeParameter dateTimeParameter, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(dateTimeParameter, "$this$applyFormValue");
        Intrinsics.checkNotNullParameter(str, "seconds");
        if (str.hashCode() == 1444 && str.equals(DATE_TIME_PARAMETER_PRESENT_TIME)) {
            obj = DateTimeParameter.Value.PresentTime.INSTANCE;
        } else {
            Long longOrNull = l.toLongOrNull(str);
            if (longOrNull != null) {
                obj = new DateTimeParameter.Value.Timestamp(TimeUnit.SECONDS.toMillis(longOrNull.longValue()));
            } else {
                obj = null;
            }
        }
        if (!Intrinsics.areEqual(dateTimeParameter.getValue(), obj)) {
            dateTimeParameter.setValue(obj);
            dateTimeParameter.setError(null);
        }
    }

    @NotNull
    public static final String toFormValue(@NotNull DateTimeParameter.Value value) {
        Intrinsics.checkNotNullParameter(value, "$this$toFormValue");
        if (value instanceof DateTimeParameter.Value.PresentTime) {
            return DATE_TIME_PARAMETER_PRESENT_TIME;
        }
        if (value instanceof DateTimeParameter.Value.Timestamp) {
            return String.valueOf(((DateTimeParameter.Value.Timestamp) value).toSeconds());
        }
        throw new NoWhenBranchMatchedException();
    }
}
