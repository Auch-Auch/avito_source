package com.avito.android.messenger.map.search;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class GeoSearchFragment_MembersInjector implements MembersInjector<GeoSearchFragment> {
    public final Provider<GeoSearchPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public GeoSearchFragment_MembersInjector(Provider<GeoSearchPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<GeoSearchFragment> create(Provider<GeoSearchPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        return new GeoSearchFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.search.GeoSearchFragment.adapterPresenter")
    public static void injectAdapterPresenter(GeoSearchFragment geoSearchFragment, AdapterPresenter adapterPresenter) {
        geoSearchFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.search.GeoSearchFragment.itemBinder")
    public static void injectItemBinder(GeoSearchFragment geoSearchFragment, ItemBinder itemBinder) {
        geoSearchFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.search.GeoSearchFragment.presenter")
    public static void injectPresenter(GeoSearchFragment geoSearchFragment, GeoSearchPresenter geoSearchPresenter) {
        geoSearchFragment.presenter = geoSearchPresenter;
    }

    public void injectMembers(GeoSearchFragment geoSearchFragment) {
        injectPresenter(geoSearchFragment, this.a.get());
        injectAdapterPresenter(geoSearchFragment, this.b.get());
        injectItemBinder(geoSearchFragment, this.c.get());
    }
}
