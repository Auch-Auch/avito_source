package com.avito.android.publish.objects;

import android.os.Bundle;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ObjectsEditInteractorImpl_Factory implements Factory<ObjectsEditInteractorImpl> {
    public final Provider<ValidateAdvertApi> a;
    public final Provider<PublishAnalyticsDataProvider> b;
    public final Provider<Navigation> c;
    public final Provider<ObjectsParameter> d;
    public final Provider<Integer> e;
    public final Provider<Bundle> f;

    public ObjectsEditInteractorImpl_Factory(Provider<ValidateAdvertApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<Navigation> provider3, Provider<ObjectsParameter> provider4, Provider<Integer> provider5, Provider<Bundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ObjectsEditInteractorImpl_Factory create(Provider<ValidateAdvertApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<Navigation> provider3, Provider<ObjectsParameter> provider4, Provider<Integer> provider5, Provider<Bundle> provider6) {
        return new ObjectsEditInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ObjectsEditInteractorImpl newInstance(ValidateAdvertApi validateAdvertApi, PublishAnalyticsDataProvider publishAnalyticsDataProvider, Navigation navigation, ObjectsParameter objectsParameter, Integer num, Bundle bundle) {
        return new ObjectsEditInteractorImpl(validateAdvertApi, publishAnalyticsDataProvider, navigation, objectsParameter, num, bundle);
    }

    @Override // javax.inject.Provider
    public ObjectsEditInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
