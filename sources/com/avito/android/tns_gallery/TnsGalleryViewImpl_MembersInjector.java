package com.avito.android.tns_gallery;

import com.avito.android.Features;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class TnsGalleryViewImpl_MembersInjector implements MembersInjector<TnsGalleryViewImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<Features> c;

    public TnsGalleryViewImpl_MembersInjector(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<TnsGalleryViewImpl> create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<Features> provider3) {
        return new TnsGalleryViewImpl_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.tns_gallery.TnsGalleryViewImpl.adapterPresenter")
    public static void injectAdapterPresenter(TnsGalleryViewImpl tnsGalleryViewImpl, AdapterPresenter adapterPresenter) {
        tnsGalleryViewImpl.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tns_gallery.TnsGalleryViewImpl.features")
    public static void injectFeatures(TnsGalleryViewImpl tnsGalleryViewImpl, Features features) {
        tnsGalleryViewImpl.features = features;
    }

    @InjectedFieldSignature("com.avito.android.tns_gallery.TnsGalleryViewImpl.itemBinder")
    public static void injectItemBinder(TnsGalleryViewImpl tnsGalleryViewImpl, ItemBinder itemBinder) {
        tnsGalleryViewImpl.itemBinder = itemBinder;
    }

    public void injectMembers(TnsGalleryViewImpl tnsGalleryViewImpl) {
        injectAdapterPresenter(tnsGalleryViewImpl, this.a.get());
        injectItemBinder(tnsGalleryViewImpl, this.b.get());
        injectFeatures(tnsGalleryViewImpl, this.c.get());
    }
}
