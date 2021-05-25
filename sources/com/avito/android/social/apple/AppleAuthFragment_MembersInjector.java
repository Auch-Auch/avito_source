package com.avito.android.social.apple;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AppleAuthFragment_MembersInjector implements MembersInjector<AppleAuthFragment> {
    public final Provider<AppleAuthPresenter> a;
    public final Provider<AppleAuthWebViewClient> b;

    public AppleAuthFragment_MembersInjector(Provider<AppleAuthPresenter> provider, Provider<AppleAuthWebViewClient> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<AppleAuthFragment> create(Provider<AppleAuthPresenter> provider, Provider<AppleAuthWebViewClient> provider2) {
        return new AppleAuthFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.social.apple.AppleAuthFragment.presenter")
    public static void injectPresenter(AppleAuthFragment appleAuthFragment, AppleAuthPresenter appleAuthPresenter) {
        appleAuthFragment.presenter = appleAuthPresenter;
    }

    @InjectedFieldSignature("com.avito.android.social.apple.AppleAuthFragment.webViewClient")
    public static void injectWebViewClient(AppleAuthFragment appleAuthFragment, AppleAuthWebViewClient appleAuthWebViewClient) {
        appleAuthFragment.webViewClient = appleAuthWebViewClient;
    }

    public void injectMembers(AppleAuthFragment appleAuthFragment) {
        injectPresenter(appleAuthFragment, this.a.get());
        injectWebViewClient(appleAuthFragment, this.b.get());
    }
}
