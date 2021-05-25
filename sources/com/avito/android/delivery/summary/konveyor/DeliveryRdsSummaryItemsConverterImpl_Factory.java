package com.avito.android.delivery.summary.konveyor;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsSummaryItemsConverterImpl_Factory implements Factory<DeliveryRdsSummaryItemsConverterImpl> {
    public final Provider<CategoryParametersElementConverter> a;
    public final Provider<DeliveryRdsSummaryKonveyorResourceProvider> b;

    public DeliveryRdsSummaryItemsConverterImpl_Factory(Provider<CategoryParametersElementConverter> provider, Provider<DeliveryRdsSummaryKonveyorResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeliveryRdsSummaryItemsConverterImpl_Factory create(Provider<CategoryParametersElementConverter> provider, Provider<DeliveryRdsSummaryKonveyorResourceProvider> provider2) {
        return new DeliveryRdsSummaryItemsConverterImpl_Factory(provider, provider2);
    }

    public static DeliveryRdsSummaryItemsConverterImpl newInstance(CategoryParametersElementConverter categoryParametersElementConverter, DeliveryRdsSummaryKonveyorResourceProvider deliveryRdsSummaryKonveyorResourceProvider) {
        return new DeliveryRdsSummaryItemsConverterImpl(categoryParametersElementConverter, deliveryRdsSummaryKonveyorResourceProvider);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsSummaryItemsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
