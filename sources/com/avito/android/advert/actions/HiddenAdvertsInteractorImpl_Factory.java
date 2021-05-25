package com.avito.android.advert.actions;

import com.avito.android.remote.SearchApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HiddenAdvertsInteractorImpl_Factory implements Factory<HiddenAdvertsInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<HiddenAdvertsStorage> b;
    public final Provider<SchedulersFactory3> c;

    public HiddenAdvertsInteractorImpl_Factory(Provider<SearchApi> provider, Provider<HiddenAdvertsStorage> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static HiddenAdvertsInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<HiddenAdvertsStorage> provider2, Provider<SchedulersFactory3> provider3) {
        return new HiddenAdvertsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static HiddenAdvertsInteractorImpl newInstance(SearchApi searchApi, HiddenAdvertsStorage hiddenAdvertsStorage, SchedulersFactory3 schedulersFactory3) {
        return new HiddenAdvertsInteractorImpl(searchApi, hiddenAdvertsStorage, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public HiddenAdvertsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
