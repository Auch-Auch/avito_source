package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class TestFavoriteAdvertItemBlueprint_Factory implements Factory<TestFavoriteAdvertItemBlueprint> {
    public final Provider<TestFavoriteAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;

    public TestFavoriteAdvertItemBlueprint_Factory(Provider<TestFavoriteAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static TestFavoriteAdvertItemBlueprint_Factory create(Provider<TestFavoriteAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        return new TestFavoriteAdvertItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static TestFavoriteAdvertItemBlueprint newInstance(TestFavoriteAdvertItemPresenter testFavoriteAdvertItemPresenter, TimeSource timeSource, Locale locale) {
        return new TestFavoriteAdvertItemBlueprint(testFavoriteAdvertItemPresenter, timeSource, locale);
    }

    @Override // javax.inject.Provider
    public TestFavoriteAdvertItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
