package com.avito.android.favorites.adapter.advert;

import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertItemPresenterImpl_Factory implements Factory<FavoriteAdvertItemPresenterImpl> {
    public final Provider<FavoriteAdvertItemPresenter.Listener> a;
    public final Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> b;

    public FavoriteAdvertItemPresenterImpl_Factory(Provider<FavoriteAdvertItemPresenter.Listener> provider, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteAdvertItemPresenterImpl_Factory create(Provider<FavoriteAdvertItemPresenter.Listener> provider, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider2) {
        return new FavoriteAdvertItemPresenterImpl_Factory(provider, provider2);
    }

    public static FavoriteAdvertItemPresenterImpl newInstance(Lazy<FavoriteAdvertItemPresenter.Listener> lazy, ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup) {
        return new FavoriteAdvertItemPresenterImpl(lazy, exposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
