package com.avito.android.safedeal.delivery_courier.summary.konveyor.link;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LinkItemBlueprint_Factory implements Factory<LinkItemBlueprint> {
    public final Provider<LinkItemPresenter> a;

    public LinkItemBlueprint_Factory(Provider<LinkItemPresenter> provider) {
        this.a = provider;
    }

    public static LinkItemBlueprint_Factory create(Provider<LinkItemPresenter> provider) {
        return new LinkItemBlueprint_Factory(provider);
    }

    public static LinkItemBlueprint newInstance(LinkItemPresenter linkItemPresenter) {
        return new LinkItemBlueprint(linkItemPresenter);
    }

    @Override // javax.inject.Provider
    public LinkItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
