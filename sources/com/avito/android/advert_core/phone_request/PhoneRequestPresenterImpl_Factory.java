package com.avito.android.advert_core.phone_request;

import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneRequestPresenterImpl_Factory implements Factory<PhoneRequestPresenterImpl> {
    public final Provider<PhoneRequestLink> a;
    public final Provider<PhoneRequestDeepLinkAnalyticsInteractor> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<AsyncPhonePresenter> d;

    public PhoneRequestPresenterImpl_Factory(Provider<PhoneRequestLink> provider, Provider<PhoneRequestDeepLinkAnalyticsInteractor> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AsyncPhonePresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PhoneRequestPresenterImpl_Factory create(Provider<PhoneRequestLink> provider, Provider<PhoneRequestDeepLinkAnalyticsInteractor> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AsyncPhonePresenter> provider4) {
        return new PhoneRequestPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PhoneRequestPresenterImpl newInstance(PhoneRequestLink phoneRequestLink, PhoneRequestDeepLinkAnalyticsInteractor phoneRequestDeepLinkAnalyticsInteractor, DeepLinkIntentFactory deepLinkIntentFactory, AsyncPhonePresenter asyncPhonePresenter) {
        return new PhoneRequestPresenterImpl(phoneRequestLink, phoneRequestDeepLinkAnalyticsInteractor, deepLinkIntentFactory, asyncPhonePresenter);
    }

    @Override // javax.inject.Provider
    public PhoneRequestPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
