package com.avito.android.serp.adapter.rich_snippets.job;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertRichJobItemBlueprint_Factory implements Factory<AdvertRichJobItemBlueprint> {
    public final Provider<AdvertRichJobItemPresenter> a;

    public AdvertRichJobItemBlueprint_Factory(Provider<AdvertRichJobItemPresenter> provider) {
        this.a = provider;
    }

    public static AdvertRichJobItemBlueprint_Factory create(Provider<AdvertRichJobItemPresenter> provider) {
        return new AdvertRichJobItemBlueprint_Factory(provider);
    }

    public static AdvertRichJobItemBlueprint newInstance(AdvertRichJobItemPresenter advertRichJobItemPresenter) {
        return new AdvertRichJobItemBlueprint(advertRichJobItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertRichJobItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
