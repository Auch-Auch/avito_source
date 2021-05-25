package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TestFavoriteAdvertItemPresenterImpl_Factory implements Factory<TestFavoriteAdvertItemPresenterImpl> {
    public final Provider<TestFavoriteAdvertItemPresenter.Listener> a;

    public TestFavoriteAdvertItemPresenterImpl_Factory(Provider<TestFavoriteAdvertItemPresenter.Listener> provider) {
        this.a = provider;
    }

    public static TestFavoriteAdvertItemPresenterImpl_Factory create(Provider<TestFavoriteAdvertItemPresenter.Listener> provider) {
        return new TestFavoriteAdvertItemPresenterImpl_Factory(provider);
    }

    public static TestFavoriteAdvertItemPresenterImpl newInstance(Lazy<TestFavoriteAdvertItemPresenter.Listener> lazy) {
        return new TestFavoriteAdvertItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public TestFavoriteAdvertItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
