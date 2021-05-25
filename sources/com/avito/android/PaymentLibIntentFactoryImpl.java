package com.avito.android;

import android.app.Application;
import android.content.Intent;
import com.avito.android.payment.lib.PaymentActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/PaymentLibIntentFactoryImpl;", "Lcom/avito/android/PaymentLibIntentFactory;", "", "itemId", "", "serviceIds", "paymentContext", "Landroid/content/Intent;", "legacyServicePaymentIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "orderItems", "servicePaymentIntent", "(Ljava/util/Set;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "horizontalTopUpPaymentIntent", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentLibIntentFactoryImpl implements PaymentLibIntentFactory {
    public final Application a;

    @Inject
    public PaymentLibIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.PaymentLibIntentFactory
    @NotNull
    public Intent horizontalTopUpPaymentIntent(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        return PaymentActivityKt.createPaymentActivityForTopUpWallet(this.a, parametersTree);
    }

    @Override // com.avito.android.PaymentLibIntentFactory
    @NotNull
    public Intent legacyServicePaymentIntent(@NotNull String str, @NotNull List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        return PaymentActivityKt.legacyCreatePaymentActivityForServicePayment(this.a, str, list, str2);
    }

    @Override // com.avito.android.PaymentLibIntentFactory
    @NotNull
    public Intent servicePaymentIntent(@NotNull Set<OrderItem> set, @Nullable String str) {
        Intrinsics.checkNotNullParameter(set, "orderItems");
        return PaymentActivityKt.createPaymentActivityForServicePayment(this.a, set, str);
    }
}
