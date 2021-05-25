package com.avito.android.payment.lib;

import android.content.Context;
import android.content.Intent;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Landroid/content/Intent;", "createPaymentActivityForTopUpWallet", "(Landroid/content/Context;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "", "itemId", "", "serviceIds", "paymentContext", "legacyCreatePaymentActivityForServicePayment", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "orderItems", "createPaymentActivityForServicePayment", "(Landroid/content/Context;Ljava/util/Set;Ljava/lang/String;)Landroid/content/Intent;", "payment-lib_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentActivityKt {
    public static final /* synthetic */ String access$getEXTRA_PAYMENT_SESSION_TYPE$p() {
        return "EXTRA_PAYMENT_SESSION_TYPE";
    }

    @NotNull
    public static final Intent createPaymentActivityForServicePayment(@NotNull Context context, @NotNull Set<OrderItem> set, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(set, "orderItems");
        Intent addFlags = new Intent(context, PaymentActivity.class).putExtra("EXTRA_PAYMENT_SESSION_TYPE", new PaymentSessionType.Services(set, str)).addFlags(65536);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, PaymentA…AG_ACTIVITY_NO_ANIMATION)");
        return addFlags;
    }

    @NotNull
    public static final Intent createPaymentActivityForTopUpWallet(@NotNull Context context, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intent addFlags = new Intent(context, PaymentActivity.class).putExtra("EXTRA_PAYMENT_SESSION_TYPE", new PaymentSessionType.Wallet(parametersTree)).addFlags(65536);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, PaymentA…AG_ACTIVITY_NO_ANIMATION)");
        return addFlags;
    }

    @NotNull
    public static final Intent legacyCreatePaymentActivityForServicePayment(@NotNull Context context, @NotNull String str, @NotNull List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        Intent addFlags = new Intent(context, PaymentActivity.class).putExtra("EXTRA_PAYMENT_SESSION_TYPE", new PaymentSessionType.LegacyServices(str, CollectionsKt___CollectionsKt.toSet(list), str2)).addFlags(65536);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, PaymentA…AG_ACTIVITY_NO_ANIMATION)");
        return addFlags;
    }
}
