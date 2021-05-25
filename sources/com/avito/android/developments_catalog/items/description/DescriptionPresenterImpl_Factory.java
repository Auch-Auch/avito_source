package com.avito.android.developments_catalog.items.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DescriptionPresenterImpl_Factory implements Factory<DescriptionPresenterImpl> {
    public final Provider<DescriptionExpandListener> a;

    public DescriptionPresenterImpl_Factory(Provider<DescriptionExpandListener> provider) {
        this.a = provider;
    }

    public static DescriptionPresenterImpl_Factory create(Provider<DescriptionExpandListener> provider) {
        return new DescriptionPresenterImpl_Factory(provider);
    }

    public static DescriptionPresenterImpl newInstance(DescriptionExpandListener descriptionExpandListener) {
        return new DescriptionPresenterImpl(descriptionExpandListener);
    }

    @Override // javax.inject.Provider
    public DescriptionPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
