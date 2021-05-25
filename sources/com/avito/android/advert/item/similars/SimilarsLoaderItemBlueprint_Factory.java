package com.avito.android.advert.item.similars;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarsLoaderItemBlueprint_Factory implements Factory<SimilarsLoaderItemBlueprint> {
    public final Provider<SimilarsLoaderItemPresenter> a;

    public SimilarsLoaderItemBlueprint_Factory(Provider<SimilarsLoaderItemPresenter> provider) {
        this.a = provider;
    }

    public static SimilarsLoaderItemBlueprint_Factory create(Provider<SimilarsLoaderItemPresenter> provider) {
        return new SimilarsLoaderItemBlueprint_Factory(provider);
    }

    public static SimilarsLoaderItemBlueprint newInstance(SimilarsLoaderItemPresenter similarsLoaderItemPresenter) {
        return new SimilarsLoaderItemBlueprint(similarsLoaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public SimilarsLoaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
