package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class OtherAdvertsItemBlueprint_Factory implements Factory<OtherAdvertsItemBlueprint> {
    public final Provider<OtherAdvertsItemPresenter> a;

    public OtherAdvertsItemBlueprint_Factory(Provider<OtherAdvertsItemPresenter> provider) {
        this.a = provider;
    }

    public static OtherAdvertsItemBlueprint_Factory create(Provider<OtherAdvertsItemPresenter> provider) {
        return new OtherAdvertsItemBlueprint_Factory(provider);
    }

    public static OtherAdvertsItemBlueprint newInstance(OtherAdvertsItemPresenter otherAdvertsItemPresenter) {
        return new OtherAdvertsItemBlueprint(otherAdvertsItemPresenter);
    }

    @Override // javax.inject.Provider
    public OtherAdvertsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
