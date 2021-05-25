package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.WalletInfoInteractor;
import com.avito.android.payment.wallet.WalletPageViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WalletPageModule_ProvideWalletPageViewModelFactoryFactory implements Factory<WalletPageViewModelFactory> {
    public final WalletPageModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<WalletInfoInteractor> c;

    public WalletPageModule_ProvideWalletPageViewModelFactoryFactory(WalletPageModule walletPageModule, Provider<SchedulersFactory> provider, Provider<WalletInfoInteractor> provider2) {
        this.a = walletPageModule;
        this.b = provider;
        this.c = provider2;
    }

    public static WalletPageModule_ProvideWalletPageViewModelFactoryFactory create(WalletPageModule walletPageModule, Provider<SchedulersFactory> provider, Provider<WalletInfoInteractor> provider2) {
        return new WalletPageModule_ProvideWalletPageViewModelFactoryFactory(walletPageModule, provider, provider2);
    }

    public static WalletPageViewModelFactory provideWalletPageViewModelFactory(WalletPageModule walletPageModule, SchedulersFactory schedulersFactory, WalletInfoInteractor walletInfoInteractor) {
        return (WalletPageViewModelFactory) Preconditions.checkNotNullFromProvides(walletPageModule.provideWalletPageViewModelFactory(schedulersFactory, walletInfoInteractor));
    }

    @Override // javax.inject.Provider
    public WalletPageViewModelFactory get() {
        return provideWalletPageViewModelFactory(this.a, this.b.get(), this.c.get());
    }
}
