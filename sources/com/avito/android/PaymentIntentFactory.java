package com.avito.android;

import android.content.Intent;
import com.avito.android.payment.WebPaymentResourceProviderImpl;
import com.avito.android.payment.wallet.history.details.PaymentDetailsType;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u001eJ\u000f\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b&\u0010\u0010J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/PaymentIntentFactory;", "", "", "itemId", "", "serviceIds", "context", "Landroid/content/Intent;", "servicePaymentIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "orderItems", "paymentContext", "(Ljava/util/Set;Ljava/lang/String;)Landroid/content/Intent;", "topUpFormIntent", "()Landroid/content/Intent;", "walletPageIntent", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "topUpPaymentIntent", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "paymentSessionId", "methodSignature", "paymentGenericIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "paymentGenericFormIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", AnalyticFieldsName.orderId, "paymentStatusFormIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "paymentStatusIntent", "startUrl", "Lcom/avito/android/payment/WebPaymentResourceProviderImpl;", "resourceProviderImpl", "webPaymentIntent", "(Ljava/lang/String;Lcom/avito/android/payment/WebPaymentResourceProviderImpl;)Landroid/content/Intent;", "sbolPaymentIntent", "operationsHistoryIntent", "Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;", "paymentDetailsType", "id", "paymentHistoryDetailsIntent", "(Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent paymentGenericIntent$default(PaymentIntentFactory paymentIntentFactory, String str, String str2, ParametersTree parametersTree, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    parametersTree = new SimpleParametersTree(CollectionsKt__CollectionsKt.emptyList(), null, 2, null);
                }
                return paymentIntentFactory.paymentGenericIntent(str, str2, parametersTree);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paymentGenericIntent");
        }

        public static /* synthetic */ Intent webPaymentIntent$default(PaymentIntentFactory paymentIntentFactory, String str, WebPaymentResourceProviderImpl webPaymentResourceProviderImpl, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    webPaymentResourceProviderImpl = null;
                }
                return paymentIntentFactory.webPaymentIntent(str, webPaymentResourceProviderImpl);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: webPaymentIntent");
        }
    }

    @NotNull
    Intent operationsHistoryIntent();

    @NotNull
    Intent paymentGenericFormIntent(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent paymentGenericIntent(@NotNull String str, @NotNull String str2, @NotNull ParametersTree parametersTree);

    @NotNull
    Intent paymentHistoryDetailsIntent(@NotNull PaymentDetailsType paymentDetailsType, @NotNull String str);

    @NotNull
    Intent paymentStatusFormIntent(@NotNull String str);

    @NotNull
    Intent paymentStatusIntent(@NotNull String str);

    @NotNull
    Intent sbolPaymentIntent(@NotNull String str);

    @NotNull
    Intent servicePaymentIntent(@NotNull String str, @NotNull List<String> list, @Nullable String str2);

    @NotNull
    Intent servicePaymentIntent(@NotNull Set<OrderItem> set, @Nullable String str);

    @NotNull
    Intent topUpFormIntent();

    @NotNull
    Intent topUpPaymentIntent(@NotNull ParametersTree parametersTree);

    @NotNull
    Intent walletPageIntent();

    @NotNull
    Intent webPaymentIntent(@NotNull String str, @Nullable WebPaymentResourceProviderImpl webPaymentResourceProviderImpl);
}
