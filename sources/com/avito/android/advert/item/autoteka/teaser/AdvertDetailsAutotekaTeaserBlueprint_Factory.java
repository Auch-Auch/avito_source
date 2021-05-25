package com.avito.android.advert.item.autoteka.teaser;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutotekaTeaserBlueprint_Factory implements Factory<AdvertDetailsAutotekaTeaserBlueprint> {
    public final Provider<AdvertDetailsAutotekaTeaserPresenter> a;

    public AdvertDetailsAutotekaTeaserBlueprint_Factory(Provider<AdvertDetailsAutotekaTeaserPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAutotekaTeaserBlueprint_Factory create(Provider<AdvertDetailsAutotekaTeaserPresenter> provider) {
        return new AdvertDetailsAutotekaTeaserBlueprint_Factory(provider);
    }

    public static AdvertDetailsAutotekaTeaserBlueprint newInstance(AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter) {
        return new AdvertDetailsAutotekaTeaserBlueprint(advertDetailsAutotekaTeaserPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutotekaTeaserBlueprint get() {
        return newInstance(this.a.get());
    }
}
