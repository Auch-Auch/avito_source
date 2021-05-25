package com.avito.android.item_map.amenity;

import com.avito.android.item_map.remote.ItemMapApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AmenityButtonsInteractorImpl_Factory implements Factory<AmenityButtonsInteractorImpl> {
    public final Provider<ItemMapApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory3> c;

    public AmenityButtonsInteractorImpl_Factory(Provider<ItemMapApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AmenityButtonsInteractorImpl_Factory create(Provider<ItemMapApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        return new AmenityButtonsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static AmenityButtonsInteractorImpl newInstance(ItemMapApi itemMapApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new AmenityButtonsInteractorImpl(itemMapApi, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AmenityButtonsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
