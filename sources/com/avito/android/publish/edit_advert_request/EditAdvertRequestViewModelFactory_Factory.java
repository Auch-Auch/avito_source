package com.avito.android.publish.edit_advert_request;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepository;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditAdvertRequestViewModelFactory_Factory implements Factory<EditAdvertRequestViewModelFactory> {
    public final Provider<EditAdvertRepository> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Analytics> c;
    public final Provider<Features> d;

    public EditAdvertRequestViewModelFactory_Factory(Provider<EditAdvertRepository> provider, Provider<SchedulersFactory> provider2, Provider<Analytics> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static EditAdvertRequestViewModelFactory_Factory create(Provider<EditAdvertRepository> provider, Provider<SchedulersFactory> provider2, Provider<Analytics> provider3, Provider<Features> provider4) {
        return new EditAdvertRequestViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static EditAdvertRequestViewModelFactory newInstance(EditAdvertRepository editAdvertRepository, SchedulersFactory schedulersFactory, Analytics analytics, Features features) {
        return new EditAdvertRequestViewModelFactory(editAdvertRepository, schedulersFactory, analytics, features);
    }

    @Override // javax.inject.Provider
    public EditAdvertRequestViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
