package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/PaymentLibIntentFactory;", "", "", "itemId", "", "serviceIds", "paymentContext", "Landroid/content/Intent;", "legacyServicePaymentIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "orderItems", "servicePaymentIntent", "(Ljava/util/Set;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "horizontalTopUpPaymentIntent", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentLibIntentFactory {
    @NotNull
    Intent horizontalTopUpPaymentIntent(@NotNull ParametersTree parametersTree);

    @Deprecated(message = "Deprecated in BILL-4537. Use servicePaymentIntent() instead.")
    @NotNull
    Intent legacyServicePaymentIntent(@NotNull String str, @NotNull List<String> list, @Nullable String str2);

    @NotNull
    Intent servicePaymentIntent(@NotNull Set<OrderItem> set, @Nullable String str);
}
