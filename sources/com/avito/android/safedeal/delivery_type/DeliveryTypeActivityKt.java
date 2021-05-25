package com.avito.android.safedeal.delivery_type;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "data", "Landroid/content/Intent;", "createDeliveryTypeIntent", "(Landroid/content/Context;Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;)Landroid/content/Intent;", "", "KEY_EXTRA_DELIVERY_TYPE_DATA", "Ljava/lang/String;", "safedeal_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryTypeActivityKt {
    @NotNull
    public static final String KEY_EXTRA_DELIVERY_TYPE_DATA = "delivery_type_data";

    @NotNull
    public static final Intent createDeliveryTypeIntent(@NotNull Context context, @NotNull DeliveryTypeData deliveryTypeData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deliveryTypeData, "data");
        Intent putExtra = new Intent(context, DeliveryTypeActivity.class).putExtra(KEY_EXTRA_DELIVERY_TYPE_DATA, deliveryTypeData);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…DELIVERY_TYPE_DATA, data)");
        return putExtra;
    }
}
