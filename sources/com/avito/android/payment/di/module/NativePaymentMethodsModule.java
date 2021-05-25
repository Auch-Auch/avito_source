package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.google.android.gms.wallet.PaymentsClient;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/di/module/NativePaymentMethodsModule;", "", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "appInfoProvider", "Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequestBuilder", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/payment/NativeMethodsInteractor;", "provideNativeMethodsInteractor", "(Lcom/avito/android/app/external/ApplicationInfoProvider;Lcom/google/android/gms/wallet/PaymentsClient;Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;Lcom/avito/android/Features;)Lcom/avito/android/payment/NativeMethodsInteractor;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NativePaymentMethodsModule {
    @Provides
    @NotNull
    public final NativeMethodsInteractor provideNativeMethodsInteractor(@NotNull ApplicationInfoProvider applicationInfoProvider, @NotNull PaymentsClient paymentsClient, @NotNull GooglePayRequestBuilder googlePayRequestBuilder, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(applicationInfoProvider, "appInfoProvider");
        Intrinsics.checkNotNullParameter(paymentsClient, "paymentsClient");
        Intrinsics.checkNotNullParameter(googlePayRequestBuilder, "googlePayRequestBuilder");
        Intrinsics.checkNotNullParameter(features, "features");
        return new NativeMethodsInteractor(applicationInfoProvider, paymentsClient, googlePayRequestBuilder, features.getBillingGooglePayEnabled().invoke().booleanValue(), features.getBillingShowGooglePayButtonNotDependingOnGooglePaySupport().invoke().booleanValue());
    }
}
