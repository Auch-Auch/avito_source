package com.avito.android.stories.adapter;

import com.avito.android.analytics.Analytics;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoriesItemPresenterImpl_Factory implements Factory<StoriesItemPresenterImpl> {
    public final Provider<StoriesItemListener> a;
    public final Provider<Analytics> b;

    public StoriesItemPresenterImpl_Factory(Provider<StoriesItemListener> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StoriesItemPresenterImpl_Factory create(Provider<StoriesItemListener> provider, Provider<Analytics> provider2) {
        return new StoriesItemPresenterImpl_Factory(provider, provider2);
    }

    public static StoriesItemPresenterImpl newInstance(Lazy<StoriesItemListener> lazy, Analytics analytics) {
        return new StoriesItemPresenterImpl(lazy, analytics);
    }

    @Override // javax.inject.Provider
    public StoriesItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
