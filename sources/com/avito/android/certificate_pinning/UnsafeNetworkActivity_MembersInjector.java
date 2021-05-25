package com.avito.android.certificate_pinning;

import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UnsafeNetworkActivity_MembersInjector implements MembersInjector<UnsafeNetworkActivity> {
    public final Provider<ImplicitIntentFactory> a;
    public final Provider<UnsafeNetworkPresenter> b;

    public UnsafeNetworkActivity_MembersInjector(Provider<ImplicitIntentFactory> provider, Provider<UnsafeNetworkPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<UnsafeNetworkActivity> create(Provider<ImplicitIntentFactory> provider, Provider<UnsafeNetworkPresenter> provider2) {
        return new UnsafeNetworkActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.certificate_pinning.UnsafeNetworkActivity.intentFactory")
    public static void injectIntentFactory(UnsafeNetworkActivity unsafeNetworkActivity, ImplicitIntentFactory implicitIntentFactory) {
        unsafeNetworkActivity.intentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.certificate_pinning.UnsafeNetworkActivity.presenter")
    public static void injectPresenter(UnsafeNetworkActivity unsafeNetworkActivity, UnsafeNetworkPresenter unsafeNetworkPresenter) {
        unsafeNetworkActivity.presenter = unsafeNetworkPresenter;
    }

    public void injectMembers(UnsafeNetworkActivity unsafeNetworkActivity) {
        injectIntentFactory(unsafeNetworkActivity, this.a.get());
        injectPresenter(unsafeNetworkActivity, this.b.get());
    }
}
