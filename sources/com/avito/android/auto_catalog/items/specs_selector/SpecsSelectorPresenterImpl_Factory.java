package com.avito.android.auto_catalog.items.specs_selector;

import com.avito.android.auto_catalog.AutoCatalogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpecsSelectorPresenterImpl_Factory implements Factory<SpecsSelectorPresenterImpl> {
    public final Provider<AutoCatalogPresenter> a;

    public SpecsSelectorPresenterImpl_Factory(Provider<AutoCatalogPresenter> provider) {
        this.a = provider;
    }

    public static SpecsSelectorPresenterImpl_Factory create(Provider<AutoCatalogPresenter> provider) {
        return new SpecsSelectorPresenterImpl_Factory(provider);
    }

    public static SpecsSelectorPresenterImpl newInstance(AutoCatalogPresenter autoCatalogPresenter) {
        return new SpecsSelectorPresenterImpl(autoCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public SpecsSelectorPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
