package com.avito.android.db;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionDao_Factory implements Factory<SearchSubscriptionDao> {
    public final Provider<DbHelper> a;

    public SearchSubscriptionDao_Factory(Provider<DbHelper> provider) {
        this.a = provider;
    }

    public static SearchSubscriptionDao_Factory create(Provider<DbHelper> provider) {
        return new SearchSubscriptionDao_Factory(provider);
    }

    public static SearchSubscriptionDao newInstance(DbHelper dbHelper) {
        return new SearchSubscriptionDao(dbHelper);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionDao get() {
        return newInstance(this.a.get());
    }
}
