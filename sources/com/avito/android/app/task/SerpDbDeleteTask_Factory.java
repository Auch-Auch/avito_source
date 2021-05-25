package com.avito.android.app.task;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpDbDeleteTask_Factory implements Factory<SerpDbDeleteTask> {
    public final Provider<SchedulersFactory> a;

    public SerpDbDeleteTask_Factory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static SerpDbDeleteTask_Factory create(Provider<SchedulersFactory> provider) {
        return new SerpDbDeleteTask_Factory(provider);
    }

    public static SerpDbDeleteTask newInstance(SchedulersFactory schedulersFactory) {
        return new SerpDbDeleteTask(schedulersFactory);
    }

    @Override // javax.inject.Provider
    public SerpDbDeleteTask get() {
        return newInstance(this.a.get());
    }
}
