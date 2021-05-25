package com.avito.android.payment.di.module;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.payment.google_pay.AvitoMerchantInfo;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.avito.android.payment.google_pay.GooglePayRequestBuilderImpl;
import com.avito.android.payment.google_pay.ProdAvitoMerchantInfo;
import com.avito.android.payment.google_pay.TestAvitoMerchantInfo;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/payment/di/module/GooglePayModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "avitoMerchantInfo", "Lcom/google/android/gms/wallet/PaymentsClient;", "provideGooglePaymentClient", "(Landroid/content/Context;Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;)Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequestBuilder", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "provideGooglePayInteractor", "(Lcom/google/android/gms/wallet/PaymentsClient;Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;)Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "provideGooglePayRequestBuilder", "(Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;)Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "Lcom/avito/android/Features;", "features", "provideAvitoMerchantInfo", "(Lcom/avito/android/Features;)Lcom/avito/android/payment/google_pay/AvitoMerchantInfo;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public class GooglePayModule {
    @Provides
    @Reusable
    @NotNull
    public final AvitoMerchantInfo provideAvitoMerchantInfo(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return features.getBillingTestGooglePayProfileEnabled().invoke().booleanValue() ? new TestAvitoMerchantInfo() : new ProdAvitoMerchantInfo();
    }

    @Provides
    @Reusable
    @NotNull
    public GooglePayInteractor provideGooglePayInteractor(@NotNull PaymentsClient paymentsClient, @NotNull GooglePayRequestBuilder googlePayRequestBuilder) {
        Intrinsics.checkNotNullParameter(paymentsClient, "paymentsClient");
        Intrinsics.checkNotNullParameter(googlePayRequestBuilder, "googlePayRequestBuilder");
        return new GooglePayInteractor(paymentsClient, googlePayRequestBuilder);
    }

    @Provides
    @Reusable
    @NotNull
    public final GooglePayRequestBuilder provideGooglePayRequestBuilder(@NotNull AvitoMerchantInfo avitoMerchantInfo) {
        Intrinsics.checkNotNullParameter(avitoMerchantInfo, "avitoMerchantInfo");
        return new GooglePayRequestBuilderImpl(avitoMerchantInfo);
    }

    @Provides
    @Reusable
    @NotNull
    public final PaymentsClient provideGooglePaymentClient(@NotNull Context context, @NotNull AvitoMerchantInfo avitoMerchantInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoMerchantInfo, "avitoMerchantInfo");
        PaymentsClient paymentsClient = Wallet.getPaymentsClient(context.getApplicationContext(), new Wallet.WalletOptions.Builder().setEnvironment(avitoMerchantInfo.getEnvironment()).build());
        Intrinsics.checkNotNullExpressionValue(paymentsClient, "Wallet.getPaymentsClient…       .build()\n        )");
        return paymentsClient;
    }
}
