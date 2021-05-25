package com.avito.android.advert_core.specifications;

import com.avito.android.serp.adapter.LayoutTypeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpecificationsConverterImpl_Factory implements Factory<SpecificationsConverterImpl> {
    public final Provider<LayoutTypeProvider> a;

    public SpecificationsConverterImpl_Factory(Provider<LayoutTypeProvider> provider) {
        this.a = provider;
    }

    public static SpecificationsConverterImpl_Factory create(Provider<LayoutTypeProvider> provider) {
        return new SpecificationsConverterImpl_Factory(provider);
    }

    public static SpecificationsConverterImpl newInstance(LayoutTypeProvider layoutTypeProvider) {
        return new SpecificationsConverterImpl(layoutTypeProvider);
    }

    @Override // javax.inject.Provider
    public SpecificationsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
