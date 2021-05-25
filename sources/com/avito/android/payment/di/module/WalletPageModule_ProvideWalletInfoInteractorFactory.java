package com.avito.android.payment.di.module;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.WalletInfoInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WalletPageModule_ProvideWalletInfoInteractorFactory implements Factory<WalletInfoInteractor> {
    public final WalletPageModule a;
    public final Provider<PaymentApi> b;

    public WalletPageModule_ProvideWalletInfoInteractorFactory(WalletPageModule walletPageModule, Provider<PaymentApi> provider) {
        this.a = walletPageModule;
        this.b = provider;
    }

    public static WalletPageModule_ProvideWalletInfoInteractorFactory create(WalletPageModule walletPageModule, Provider<PaymentApi> provider) {
        return new WalletPageModule_ProvideWalletInfoInteractorFactory(walletPageModule, provider);
    }

    public static WalletInfoInteractor provideWalletInfoInteractor(WalletPageModule walletPageModule, PaymentApi paymentApi) {
        return (WalletInfoInteractor) Preconditions.checkNotNullFromProvides(walletPageModule.provideWalletInfoInteractor(paymentApi));
    }

    @Override // javax.inject.Provider
    public WalletInfoInteractor get() {
        return provideWalletInfoInteractor(this.a, this.b.get());
    }
}
