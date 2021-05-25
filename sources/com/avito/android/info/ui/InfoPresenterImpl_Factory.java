package com.avito.android.info.ui;

import android.os.Bundle;
import com.avito.android.info.business.InfoInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoPresenterImpl_Factory implements Factory<InfoPresenterImpl> {
    public final Provider<String> a;
    public final Provider<InfoInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Bundle> d;

    public InfoPresenterImpl_Factory(Provider<String> provider, Provider<InfoInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static InfoPresenterImpl_Factory create(Provider<String> provider, Provider<InfoInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        return new InfoPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static InfoPresenterImpl newInstance(String str, InfoInteractor infoInteractor, SchedulersFactory schedulersFactory, Bundle bundle) {
        return new InfoPresenterImpl(str, infoInteractor, schedulersFactory, bundle);
    }

    @Override // javax.inject.Provider
    public InfoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
