package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.processing.PaymentGenericFactory;
import com.avito.android.payment.processing.PaymentStatusFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/di/module/PaymentProcessingModule;", "", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/payment/processing/PaymentGenericFactory;", "providePaymentGenericFactory$payment_release", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;Lcom/avito/android/Features;)Lcom/avito/android/payment/processing/PaymentGenericFactory;", "providePaymentGenericFactory", "Lcom/avito/android/payment/processing/PaymentStatusFactory;", "providePaymentStatusFactory$payment_release", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/payment/processing/PaymentStatusFactory;", "providePaymentStatusFactory", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public final class PaymentProcessingModule {
    @NotNull
    public static final PaymentProcessingModule INSTANCE = new PaymentProcessingModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PaymentGenericFactory providePaymentGenericFactory$payment_release(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull DeepLinkFactory deepLinkFactory, @NotNull PaymentSessionTypeMarker paymentSessionTypeMarker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker, "paymentSessionTypeMarker");
        Intrinsics.checkNotNullParameter(features, "features");
        return new PaymentGenericFactory(paymentApi, schedulersFactory, deepLinkFactory, paymentSessionTypeMarker, features, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PaymentStatusFactory providePaymentStatusFactory$payment_release(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new PaymentStatusFactory(paymentApi, schedulersFactory, null);
    }
}
