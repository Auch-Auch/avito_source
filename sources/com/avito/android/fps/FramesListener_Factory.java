package com.avito.android.fps;

import android.app.Application;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class FramesListener_Factory implements Factory<FramesListener> {
    public final Provider<Application> a;
    public final Provider<Consumer<Long>> b;

    public FramesListener_Factory(Provider<Application> provider, Provider<Consumer<Long>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FramesListener_Factory create(Provider<Application> provider, Provider<Consumer<Long>> provider2) {
        return new FramesListener_Factory(provider, provider2);
    }

    public static FramesListener newInstance(Application application, Consumer<Long> consumer) {
        return new FramesListener(application, consumer);
    }

    @Override // javax.inject.Provider
    public FramesListener get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
