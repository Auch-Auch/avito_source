package com.avito.android.advert.item.verification;

import com.avito.android.Features;
import com.avito.android.advert.item.verification.AdvertVerificationPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertVerificationPresenterImpl_Factory implements Factory<AdvertVerificationPresenterImpl> {
    public final Provider<AdvertVerificationPresenter.OnHelpCenterClickedListener> a;
    public final Provider<Features> b;

    public AdvertVerificationPresenterImpl_Factory(Provider<AdvertVerificationPresenter.OnHelpCenterClickedListener> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertVerificationPresenterImpl_Factory create(Provider<AdvertVerificationPresenter.OnHelpCenterClickedListener> provider, Provider<Features> provider2) {
        return new AdvertVerificationPresenterImpl_Factory(provider, provider2);
    }

    public static AdvertVerificationPresenterImpl newInstance(AdvertVerificationPresenter.OnHelpCenterClickedListener onHelpCenterClickedListener, Features features) {
        return new AdvertVerificationPresenterImpl(onHelpCenterClickedListener, features);
    }

    @Override // javax.inject.Provider
    public AdvertVerificationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
