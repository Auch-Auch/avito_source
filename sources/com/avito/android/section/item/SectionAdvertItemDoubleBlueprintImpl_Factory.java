package com.avito.android.section.item;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class SectionAdvertItemDoubleBlueprintImpl_Factory implements Factory<SectionAdvertItemDoubleBlueprintImpl> {
    public final Provider<SectionAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<ConnectivityProvider> d;

    public SectionAdvertItemDoubleBlueprintImpl_Factory(Provider<SectionAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<ConnectivityProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SectionAdvertItemDoubleBlueprintImpl_Factory create(Provider<SectionAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<ConnectivityProvider> provider4) {
        return new SectionAdvertItemDoubleBlueprintImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SectionAdvertItemDoubleBlueprintImpl newInstance(SectionAdvertItemPresenter sectionAdvertItemPresenter, TimeSource timeSource, Locale locale, ConnectivityProvider connectivityProvider) {
        return new SectionAdvertItemDoubleBlueprintImpl(sectionAdvertItemPresenter, timeSource, locale, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public SectionAdvertItemDoubleBlueprintImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
