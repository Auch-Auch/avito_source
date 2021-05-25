package com.avito.android.safedeal.delivery_courier.order_update.konveyor;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierItemsConverterImpl_Factory implements Factory<DeliveryCourierItemsConverterImpl> {
    public final Provider<CategoryParametersElementConverter> a;

    public DeliveryCourierItemsConverterImpl_Factory(Provider<CategoryParametersElementConverter> provider) {
        this.a = provider;
    }

    public static DeliveryCourierItemsConverterImpl_Factory create(Provider<CategoryParametersElementConverter> provider) {
        return new DeliveryCourierItemsConverterImpl_Factory(provider);
    }

    public static DeliveryCourierItemsConverterImpl newInstance(CategoryParametersElementConverter categoryParametersElementConverter) {
        return new DeliveryCourierItemsConverterImpl(categoryParametersElementConverter);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierItemsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
