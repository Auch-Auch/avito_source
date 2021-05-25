package com.avito.android.in_app_calls.task;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InitCallsTask_Factory implements Factory<InitCallsTask> {
    public final Provider<Features> a;

    public InitCallsTask_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static InitCallsTask_Factory create(Provider<Features> provider) {
        return new InitCallsTask_Factory(provider);
    }

    public static InitCallsTask newInstance(Features features) {
        return new InitCallsTask(features);
    }

    @Override // javax.inject.Provider
    public InitCallsTask get() {
        return newInstance(this.a.get());
    }
}
