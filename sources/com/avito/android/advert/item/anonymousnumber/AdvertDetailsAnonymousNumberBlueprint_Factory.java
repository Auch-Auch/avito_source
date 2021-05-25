package com.avito.android.advert.item.anonymousnumber;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAnonymousNumberBlueprint_Factory implements Factory<AdvertDetailsAnonymousNumberBlueprint> {
    public final Provider<AdvertDetailsAnonymousNumberPresenter> a;

    public AdvertDetailsAnonymousNumberBlueprint_Factory(Provider<AdvertDetailsAnonymousNumberPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAnonymousNumberBlueprint_Factory create(Provider<AdvertDetailsAnonymousNumberPresenter> provider) {
        return new AdvertDetailsAnonymousNumberBlueprint_Factory(provider);
    }

    public static AdvertDetailsAnonymousNumberBlueprint newInstance(AdvertDetailsAnonymousNumberPresenter advertDetailsAnonymousNumberPresenter) {
        return new AdvertDetailsAnonymousNumberBlueprint(advertDetailsAnonymousNumberPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAnonymousNumberBlueprint get() {
        return newInstance(this.a.get());
    }
}
