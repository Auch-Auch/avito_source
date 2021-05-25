package com.avito.android.str_calendar.seller.edit;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerCalendarParametersConverterImpl_Factory implements Factory<SellerCalendarParametersConverterImpl> {
    public final Provider<CategoryParametersElementConverter> a;

    public SellerCalendarParametersConverterImpl_Factory(Provider<CategoryParametersElementConverter> provider) {
        this.a = provider;
    }

    public static SellerCalendarParametersConverterImpl_Factory create(Provider<CategoryParametersElementConverter> provider) {
        return new SellerCalendarParametersConverterImpl_Factory(provider);
    }

    public static SellerCalendarParametersConverterImpl newInstance(CategoryParametersElementConverter categoryParametersElementConverter) {
        return new SellerCalendarParametersConverterImpl(categoryParametersElementConverter);
    }

    @Override // javax.inject.Provider
    public SellerCalendarParametersConverterImpl get() {
        return newInstance(this.a.get());
    }
}
