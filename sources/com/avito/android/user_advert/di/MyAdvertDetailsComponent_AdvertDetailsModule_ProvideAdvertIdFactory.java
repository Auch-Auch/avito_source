package com.avito.android.user_advert.di;

import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.di.MyAdvertDetailsComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory implements Factory<String> {
    public final Provider<DetailsId> a;

    public MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory(Provider<DetailsId> provider) {
        this.a = provider;
    }

    public static MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory create(Provider<DetailsId> provider) {
        return new MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory(provider);
    }

    public static String provideAdvertId(DetailsId detailsId) {
        return (String) Preconditions.checkNotNullFromProvides(MyAdvertDetailsComponent.AdvertDetailsModule.INSTANCE.provideAdvertId(detailsId));
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAdvertId(this.a.get());
    }
}
