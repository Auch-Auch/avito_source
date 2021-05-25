package com.avito.android.stories;

import com.avito.android.remote.StoriesApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoriesInteractorImpl_Factory implements Factory<StoriesInteractorImpl> {
    public final Provider<StoriesApi> a;
    public final Provider<Preferences> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<TimeSource> e;

    public StoriesInteractorImpl_Factory(Provider<StoriesApi> provider, Provider<Preferences> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4, Provider<TimeSource> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static StoriesInteractorImpl_Factory create(Provider<StoriesApi> provider, Provider<Preferences> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4, Provider<TimeSource> provider5) {
        return new StoriesInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StoriesInteractorImpl newInstance(StoriesApi storiesApi, Preferences preferences, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3, TimeSource timeSource) {
        return new StoriesInteractorImpl(storiesApi, preferences, typedErrorThrowableConverter, schedulersFactory3, timeSource);
    }

    @Override // javax.inject.Provider
    public StoriesInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
