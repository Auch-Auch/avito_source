package com.avito.android.user_adverts.tab_screens.advert_list;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.serp.adapter.SerpSpanProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideSpanLookup$user_adverts_releaseFactory implements Factory<GridLayoutManager.SpanSizeLookup> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<SerpSpanProvider> b;

    public UserAdvertsListAdapterModule_ProvideSpanLookup$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<SerpSpanProvider> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideSpanLookup$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<SerpSpanProvider> provider) {
        return new UserAdvertsListAdapterModule_ProvideSpanLookup$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static GridLayoutManager.SpanSizeLookup provideSpanLookup$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, SerpSpanProvider serpSpanProvider) {
        return (GridLayoutManager.SpanSizeLookup) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideSpanLookup$user_adverts_release(serpSpanProvider));
    }

    @Override // javax.inject.Provider
    public GridLayoutManager.SpanSizeLookup get() {
        return provideSpanLookup$user_adverts_release(this.a, this.b.get());
    }
}
