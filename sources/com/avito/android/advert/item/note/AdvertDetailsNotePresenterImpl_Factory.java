package com.avito.android.advert.item.note;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsNotePresenterImpl_Factory implements Factory<AdvertDetailsNotePresenterImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<AdvertDetailsAnalyticsInteractor> b;

    public AdvertDetailsNotePresenterImpl_Factory(Provider<SchedulersFactory3> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsNotePresenterImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2) {
        return new AdvertDetailsNotePresenterImpl_Factory(provider, provider2);
    }

    public static AdvertDetailsNotePresenterImpl newInstance(SchedulersFactory3 schedulersFactory3, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new AdvertDetailsNotePresenterImpl(schedulersFactory3, advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsNotePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
