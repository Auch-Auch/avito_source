package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierSummaryItemsConverterImpl_Factory implements Factory<DeliveryCourierSummaryItemsConverterImpl> {
    public final Provider<CategoryParametersElementConverter> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<DeliveryCourierSummaryKonveyorResourceProvider> c;

    public DeliveryCourierSummaryItemsConverterImpl_Factory(Provider<CategoryParametersElementConverter> provider, Provider<AttributedTextFormatter> provider2, Provider<DeliveryCourierSummaryKonveyorResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeliveryCourierSummaryItemsConverterImpl_Factory create(Provider<CategoryParametersElementConverter> provider, Provider<AttributedTextFormatter> provider2, Provider<DeliveryCourierSummaryKonveyorResourceProvider> provider3) {
        return new DeliveryCourierSummaryItemsConverterImpl_Factory(provider, provider2, provider3);
    }

    public static DeliveryCourierSummaryItemsConverterImpl newInstance(CategoryParametersElementConverter categoryParametersElementConverter, AttributedTextFormatter attributedTextFormatter, DeliveryCourierSummaryKonveyorResourceProvider deliveryCourierSummaryKonveyorResourceProvider) {
        return new DeliveryCourierSummaryItemsConverterImpl(categoryParametersElementConverter, attributedTextFormatter, deliveryCourierSummaryKonveyorResourceProvider);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierSummaryItemsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
