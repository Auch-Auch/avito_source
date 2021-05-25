package com.avito.android.authorization.select_social.adapter;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialItemPresenterImpl_Factory implements Factory<SocialItemPresenterImpl> {
    public final Provider<PublishRelay<SelectSocialField>> a;

    public SocialItemPresenterImpl_Factory(Provider<PublishRelay<SelectSocialField>> provider) {
        this.a = provider;
    }

    public static SocialItemPresenterImpl_Factory create(Provider<PublishRelay<SelectSocialField>> provider) {
        return new SocialItemPresenterImpl_Factory(provider);
    }

    public static SocialItemPresenterImpl newInstance(PublishRelay<SelectSocialField> publishRelay) {
        return new SocialItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public SocialItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
