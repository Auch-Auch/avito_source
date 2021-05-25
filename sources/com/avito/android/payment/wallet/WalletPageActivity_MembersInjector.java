package com.avito.android.payment.wallet;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WalletPageActivity_MembersInjector implements MembersInjector<WalletPageActivity> {
    public final Provider<WalletPageViewModelFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;

    public WalletPageActivity_MembersInjector(Provider<WalletPageViewModelFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<WalletPageActivity> create(Provider<WalletPageViewModelFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3) {
        return new WalletPageActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.WalletPageActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(WalletPageActivity walletPageActivity, ActivityIntentFactory activityIntentFactory) {
        walletPageActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.WalletPageActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(WalletPageActivity walletPageActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        walletPageActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.WalletPageActivity.walletPageViewModelFactory")
    public static void injectWalletPageViewModelFactory(WalletPageActivity walletPageActivity, WalletPageViewModelFactory walletPageViewModelFactory) {
        walletPageActivity.walletPageViewModelFactory = walletPageViewModelFactory;
    }

    public void injectMembers(WalletPageActivity walletPageActivity) {
        injectWalletPageViewModelFactory(walletPageActivity, this.a.get());
        injectDeepLinkIntentFactory(walletPageActivity, this.b.get());
        injectActivityIntentFactory(walletPageActivity, this.c.get());
    }
}
