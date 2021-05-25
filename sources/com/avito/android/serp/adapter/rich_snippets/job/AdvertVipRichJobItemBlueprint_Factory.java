package com.avito.android.serp.adapter.rich_snippets.job;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertVipRichJobItemBlueprint_Factory implements Factory<AdvertVipRichJobItemBlueprint> {
    public final Provider<AdvertRichJobItemPresenter> a;

    public AdvertVipRichJobItemBlueprint_Factory(Provider<AdvertRichJobItemPresenter> provider) {
        this.a = provider;
    }

    public static AdvertVipRichJobItemBlueprint_Factory create(Provider<AdvertRichJobItemPresenter> provider) {
        return new AdvertVipRichJobItemBlueprint_Factory(provider);
    }

    public static AdvertVipRichJobItemBlueprint newInstance(AdvertRichJobItemPresenter advertRichJobItemPresenter) {
        return new AdvertVipRichJobItemBlueprint(advertRichJobItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertVipRichJobItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
