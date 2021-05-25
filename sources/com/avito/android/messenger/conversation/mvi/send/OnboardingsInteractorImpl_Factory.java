package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OnboardingsInteractorImpl_Factory implements Factory<OnboardingsInteractorImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<Preferences> b;

    public OnboardingsInteractorImpl_Factory(Provider<SchedulersFactory> provider, Provider<Preferences> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static OnboardingsInteractorImpl_Factory create(Provider<SchedulersFactory> provider, Provider<Preferences> provider2) {
        return new OnboardingsInteractorImpl_Factory(provider, provider2);
    }

    public static OnboardingsInteractorImpl newInstance(SchedulersFactory schedulersFactory, Preferences preferences) {
        return new OnboardingsInteractorImpl(schedulersFactory, preferences);
    }

    @Override // javax.inject.Provider
    public OnboardingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
