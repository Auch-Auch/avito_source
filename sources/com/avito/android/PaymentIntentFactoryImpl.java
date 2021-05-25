package com.avito.android;

import android.app.Application;
import android.content.Intent;
import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.payment.WebPaymentResourceProviderImpl;
import com.avito.android.payment.form.PaymentGenericFormActivityKt;
import com.avito.android.payment.form.status.PaymentStatusFormActivityKt;
import com.avito.android.payment.processing.PaymentProcessingActivityKt;
import com.avito.android.payment.top_up.form.TopUpFormActivity;
import com.avito.android.payment.wallet.OperationsHistoryActivityKt;
import com.avito.android.payment.wallet.WalletPageActivity;
import com.avito.android.payment.wallet.history.details.PaymentDetailsType;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsActivityKt;
import com.avito.android.payment.webview.WebPaymentActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00101\u001a\u00020,¢\u0006\u0004\b:\u0010;J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J'\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ!\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u001eJ\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0014J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010+R\u001c\u00101\u001a\u00020,8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/PaymentIntentFactoryImpl;", "Lcom/avito/android/PaymentIntentFactory;", "", "itemId", "", "serviceIds", "ctx", "Landroid/content/Intent;", "servicePaymentIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", "orderItems", "paymentContext", "(Ljava/util/Set;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "topUpPaymentIntent", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "topUpFormIntent", "()Landroid/content/Intent;", "walletPageIntent", "paymentSessionId", "methodSignature", "paymentGenericIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Landroid/content/Intent;", "paymentGenericFormIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", AnalyticFieldsName.orderId, "paymentStatusFormIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "paymentStatusIntent", "startUrl", "Lcom/avito/android/payment/WebPaymentResourceProviderImpl;", "resourceProviderImpl", "webPaymentIntent", "(Ljava/lang/String;Lcom/avito/android/payment/WebPaymentResourceProviderImpl;)Landroid/content/Intent;", "sbolPaymentIntent", "operationsHistoryIntent", "Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;", "paymentDetailsType", "id", "paymentHistoryDetailsIntent", "(Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/PaymentLibIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/PaymentLibIntentFactory;", "paymentLibIntentFactory", "<init>", "(Landroid/app/Application;Lcom/avito/android/PaymentLibIntentFactory;Lcom/avito/android/Features;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public class PaymentIntentFactoryImpl implements PaymentIntentFactory {
    public final Application a;
    public final PaymentLibIntentFactory b;
    @NotNull
    public final Features c;

    @Inject
    public PaymentIntentFactoryImpl(@NotNull Application application, @NotNull PaymentLibIntentFactory paymentLibIntentFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(paymentLibIntentFactory, "paymentLibIntentFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = application;
        this.b = paymentLibIntentFactory;
        this.c = features;
    }

    @NotNull
    public final Features getFeatures() {
        return this.c;
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent operationsHistoryIntent() {
        return OperationsHistoryActivityKt.createOperationsHistoryIntent(this.a);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent paymentGenericFormIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        return PaymentGenericFormActivityKt.createPaymentGenericFormActivity(this.a, str, str2);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent paymentGenericIntent(@NotNull String str, @NotNull String str2, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        return PaymentProcessingActivityKt.createPaymentProcessingActivity(this.a, str, str2, parametersTree);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent paymentHistoryDetailsIntent(@NotNull PaymentDetailsType paymentDetailsType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(paymentDetailsType, "paymentDetailsType");
        Intrinsics.checkNotNullParameter(str, "id");
        return PaymentHistoryDetailsActivityKt.createPaymentHistoryDetailsIntent(this.a, paymentDetailsType, str);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent paymentStatusFormIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return PaymentStatusFormActivityKt.createPaymentStatusFormActivity(this.a, str);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent paymentStatusIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return PaymentProcessingActivityKt.createPaymentProcessingActivity(this.a, str);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent sbolPaymentIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return SberbankOnlineKt.createSberbankOnlinePaymentIntent(this.a, str);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent servicePaymentIntent(@NotNull String str, @NotNull List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        if (!this.c.getBillingServiceSessionV4().invoke().booleanValue()) {
            return this.b.legacyServicePaymentIntent(str, list, str2);
        }
        PaymentLibIntentFactory paymentLibIntentFactory = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OrderItem(it.next(), str));
        }
        return paymentLibIntentFactory.servicePaymentIntent(CollectionsKt___CollectionsKt.toSet(arrayList), str2);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent topUpFormIntent() {
        return new Intent(this.a, TopUpFormActivity.class);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent topUpPaymentIntent(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        return this.b.horizontalTopUpPaymentIntent(parametersTree);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent walletPageIntent() {
        return new Intent(this.a, WalletPageActivity.class);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent webPaymentIntent(@NotNull String str, @Nullable WebPaymentResourceProviderImpl webPaymentResourceProviderImpl) {
        Intrinsics.checkNotNullParameter(str, "startUrl");
        return new WebPaymentActivity.IntentFactory().create(this.a, str, webPaymentResourceProviderImpl);
    }

    @Override // com.avito.android.PaymentIntentFactory
    @NotNull
    public Intent servicePaymentIntent(@NotNull Set<OrderItem> set, @Nullable String str) {
        Intrinsics.checkNotNullParameter(set, "orderItems");
        return this.b.servicePaymentIntent(set, str);
    }
}
