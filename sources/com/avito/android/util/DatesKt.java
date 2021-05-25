package com.avito.android.util;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/util/Date;", "", AnalyticFieldsName.field, "amount", ProductAction.ACTION_ADD, "(Ljava/util/Date;II)Ljava/util/Date;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class DatesKt {
    @NotNull
    public static final Date add(@NotNull Date date, int i, int i2) {
        Intrinsics.checkNotNullParameter(date, "$this$add");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "cal");
        instance.setTime(date);
        instance.add(i, i2);
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "cal.time");
        return time;
    }
}
