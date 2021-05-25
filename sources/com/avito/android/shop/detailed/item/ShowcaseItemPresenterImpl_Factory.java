package com.avito.android.shop.detailed.item;

import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShowcaseItemPresenterImpl_Factory implements Factory<ShowcaseItemPresenterImpl> {
    public final Provider<Kundle> a;

    public ShowcaseItemPresenterImpl_Factory(Provider<Kundle> provider) {
        this.a = provider;
    }

    public static ShowcaseItemPresenterImpl_Factory create(Provider<Kundle> provider) {
        return new ShowcaseItemPresenterImpl_Factory(provider);
    }

    public static ShowcaseItemPresenterImpl newInstance(Kundle kundle) {
        return new ShowcaseItemPresenterImpl(kundle);
    }

    @Override // javax.inject.Provider
    public ShowcaseItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
