package com.avito.android.publish.edit_advert_request.data;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditAdvertRepositoryImpl_Factory implements Factory<EditAdvertRepositoryImpl> {
    public final Provider<EditAdvertDataSource> a;
    public final Provider<CategoryParametersConverter> b;
    public final Provider<PublishAnalyticsDataProvider> c;

    public EditAdvertRepositoryImpl_Factory(Provider<EditAdvertDataSource> provider, Provider<CategoryParametersConverter> provider2, Provider<PublishAnalyticsDataProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditAdvertRepositoryImpl_Factory create(Provider<EditAdvertDataSource> provider, Provider<CategoryParametersConverter> provider2, Provider<PublishAnalyticsDataProvider> provider3) {
        return new EditAdvertRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static EditAdvertRepositoryImpl newInstance(EditAdvertDataSource editAdvertDataSource, CategoryParametersConverter categoryParametersConverter, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return new EditAdvertRepositoryImpl(editAdvertDataSource, categoryParametersConverter, publishAnalyticsDataProvider);
    }

    @Override // javax.inject.Provider
    public EditAdvertRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
