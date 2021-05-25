package com.avito.android.user_stats.storage;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SmbStatsTooltipSessionStorageImpl_Factory implements Factory<SmbStatsTooltipSessionStorageImpl> {
    public final Provider<Preferences> a;

    public SmbStatsTooltipSessionStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static SmbStatsTooltipSessionStorageImpl_Factory create(Provider<Preferences> provider) {
        return new SmbStatsTooltipSessionStorageImpl_Factory(provider);
    }

    public static SmbStatsTooltipSessionStorageImpl newInstance(Preferences preferences) {
        return new SmbStatsTooltipSessionStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public SmbStatsTooltipSessionStorageImpl get() {
        return newInstance(this.a.get());
    }
}
