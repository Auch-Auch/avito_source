package com.avito.android.messenger.map.sharing;

import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SharingMapPresenterImpl_Factory implements Factory<SharingMapPresenterImpl> {
    public final Provider<SharingMapView.State> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<SharingMapView.State> c;
    public final Provider<SharingMapInteractor> d;
    public final Provider<String> e;
    public final Provider<String> f;
    public final Provider<String> g;

    public SharingMapPresenterImpl_Factory(Provider<SharingMapView.State> provider, Provider<SchedulersFactory> provider2, Provider<SharingMapView.State> provider3, Provider<SharingMapInteractor> provider4, Provider<String> provider5, Provider<String> provider6, Provider<String> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static SharingMapPresenterImpl_Factory create(Provider<SharingMapView.State> provider, Provider<SchedulersFactory> provider2, Provider<SharingMapView.State> provider3, Provider<SharingMapInteractor> provider4, Provider<String> provider5, Provider<String> provider6, Provider<String> provider7) {
        return new SharingMapPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SharingMapPresenterImpl newInstance(SharingMapView.State state, SchedulersFactory schedulersFactory, SharingMapView.State state2, SharingMapInteractor sharingMapInteractor, String str, String str2, String str3) {
        return new SharingMapPresenterImpl(state, schedulersFactory, state2, sharingMapInteractor, str, str2, str3);
    }

    @Override // javax.inject.Provider
    public SharingMapPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
