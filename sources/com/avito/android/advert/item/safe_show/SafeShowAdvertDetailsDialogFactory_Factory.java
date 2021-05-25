package com.avito.android.advert.item.safe_show;

import com.avito.android.Features;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SafeShowAdvertDetailsDialogFactory_Factory implements Factory<SafeShowAdvertDetailsDialogFactory> {
    public final Provider<Boolean> a;
    public final Provider<AdvertContactsPresenter> b;
    public final Provider<Features> c;

    public SafeShowAdvertDetailsDialogFactory_Factory(Provider<Boolean> provider, Provider<AdvertContactsPresenter> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SafeShowAdvertDetailsDialogFactory_Factory create(Provider<Boolean> provider, Provider<AdvertContactsPresenter> provider2, Provider<Features> provider3) {
        return new SafeShowAdvertDetailsDialogFactory_Factory(provider, provider2, provider3);
    }

    public static SafeShowAdvertDetailsDialogFactory newInstance(boolean z, AdvertContactsPresenter advertContactsPresenter, Features features) {
        return new SafeShowAdvertDetailsDialogFactory(z, advertContactsPresenter, features);
    }

    @Override // javax.inject.Provider
    public SafeShowAdvertDetailsDialogFactory get() {
        return newInstance(this.a.get().booleanValue(), this.b.get(), this.c.get());
    }
}
