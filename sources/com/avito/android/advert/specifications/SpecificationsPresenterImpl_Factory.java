package com.avito.android.advert.specifications;

import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.remote.model.ModelSpecifications;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SpecificationsPresenterImpl_Factory implements Factory<SpecificationsPresenterImpl> {
    public final Provider<ModelSpecifications> a;
    public final Provider<SpecificationsConverter> b;

    public SpecificationsPresenterImpl_Factory(Provider<ModelSpecifications> provider, Provider<SpecificationsConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SpecificationsPresenterImpl_Factory create(Provider<ModelSpecifications> provider, Provider<SpecificationsConverter> provider2) {
        return new SpecificationsPresenterImpl_Factory(provider, provider2);
    }

    public static SpecificationsPresenterImpl newInstance(ModelSpecifications modelSpecifications, SpecificationsConverter specificationsConverter) {
        return new SpecificationsPresenterImpl(modelSpecifications, specificationsConverter);
    }

    @Override // javax.inject.Provider
    public SpecificationsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
