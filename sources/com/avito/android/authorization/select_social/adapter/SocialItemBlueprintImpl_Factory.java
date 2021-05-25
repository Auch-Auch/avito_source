package com.avito.android.authorization.select_social.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialItemBlueprintImpl_Factory implements Factory<SocialItemBlueprintImpl> {
    public final Provider<SocialItemPresenter> a;

    public SocialItemBlueprintImpl_Factory(Provider<SocialItemPresenter> provider) {
        this.a = provider;
    }

    public static SocialItemBlueprintImpl_Factory create(Provider<SocialItemPresenter> provider) {
        return new SocialItemBlueprintImpl_Factory(provider);
    }

    public static SocialItemBlueprintImpl newInstance(SocialItemPresenter socialItemPresenter) {
        return new SocialItemBlueprintImpl(socialItemPresenter);
    }

    @Override // javax.inject.Provider
    public SocialItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
