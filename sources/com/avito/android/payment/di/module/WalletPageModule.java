package com.avito.android.payment.di.module;

import com.avito.android.di.PerActivity;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.WalletInfoInteractor;
import com.avito.android.payment.wallet.WalletPageViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/di/module/WalletPageModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/wallet/WalletInfoInteractor;", "walletInfoInteractor", "Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;", "provideWalletPageViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/WalletInfoInteractor;)Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "provideWalletInfoInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;)Lcom/avito/android/payment/wallet/WalletInfoInteractor;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class WalletPageModule {
    @Provides
    @PerActivity
    @NotNull
    public final WalletInfoInteractor provideWalletInfoInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        return new WalletInfoInteractor(paymentApi);
    }

    @Provides
    @PerActivity
    @NotNull
    public final WalletPageViewModelFactory provideWalletPageViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull WalletInfoInteractor walletInfoInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(walletInfoInteractor, "walletInfoInteractor");
        return new WalletPageViewModelFactory(schedulersFactory, walletInfoInteractor);
    }
}
