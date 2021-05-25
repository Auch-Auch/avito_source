package com.avito.android.tns_gallery.di;

import com.avito.android.Features;
import com.avito.android.tns_gallery.TnsGalleryItemPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TnsGalleryItemModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<TnsGalleryItemPresenter> a;
    public final Provider<Features> b;

    public TnsGalleryItemModule_ProvideItemBinderFactory(Provider<TnsGalleryItemPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TnsGalleryItemModule_ProvideItemBinderFactory create(Provider<TnsGalleryItemPresenter> provider, Provider<Features> provider2) {
        return new TnsGalleryItemModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(TnsGalleryItemPresenter tnsGalleryItemPresenter, Features features) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(TnsGalleryItemModule.provideItemBinder(tnsGalleryItemPresenter, features));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
