package com.avito.android.messenger.channels.mvi.di;

import android.content.Context;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideMessengerAdsPreferencesFactory implements Factory<Preferences> {
    public final Provider<Context> a;
    public final Provider<PreferenceFactory> b;

    public ChannelsModule_ProvideMessengerAdsPreferencesFactory(Provider<Context> provider, Provider<PreferenceFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideMessengerAdsPreferencesFactory create(Provider<Context> provider, Provider<PreferenceFactory> provider2) {
        return new ChannelsModule_ProvideMessengerAdsPreferencesFactory(provider, provider2);
    }

    public static Preferences provideMessengerAdsPreferences(Context context, PreferenceFactory preferenceFactory) {
        return (Preferences) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideMessengerAdsPreferences(context, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideMessengerAdsPreferences(this.a.get(), this.b.get());
    }
}
