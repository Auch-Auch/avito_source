package com.avito.android.messenger.map.viewing.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.map.viewing.PlatformMapInteractor;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PlatformMapFragmentModule_ProvidePlatformMapPresenterViewModelFactory implements Factory<ViewModel> {
    public final Provider<SchedulersFactory> a;
    public final Provider<PlatformMapInteractor> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<Formatter<Throwable>> d;
    public final Provider<Resources> e;
    public final Provider<SchedulersFactory3> f;

    public PlatformMapFragmentModule_ProvidePlatformMapPresenterViewModelFactory(Provider<SchedulersFactory> provider, Provider<PlatformMapInteractor> provider2, Provider<AttributedTextFormatter> provider3, Provider<Formatter<Throwable>> provider4, Provider<Resources> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static PlatformMapFragmentModule_ProvidePlatformMapPresenterViewModelFactory create(Provider<SchedulersFactory> provider, Provider<PlatformMapInteractor> provider2, Provider<AttributedTextFormatter> provider3, Provider<Formatter<Throwable>> provider4, Provider<Resources> provider5, Provider<SchedulersFactory3> provider6) {
        return new PlatformMapFragmentModule_ProvidePlatformMapPresenterViewModelFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ViewModel providePlatformMapPresenterViewModel(SchedulersFactory schedulersFactory, PlatformMapInteractor platformMapInteractor, AttributedTextFormatter attributedTextFormatter, Formatter<Throwable> formatter, Resources resources, SchedulersFactory3 schedulersFactory3) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(PlatformMapFragmentModule.providePlatformMapPresenterViewModel(schedulersFactory, platformMapInteractor, attributedTextFormatter, formatter, resources, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return providePlatformMapPresenterViewModel(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
