package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContextActionsPresenterImpl_Factory implements Factory<ContextActionsPresenterImpl> {
    public final Provider<LegacyPlatformActionsPresenter> a;
    public final Provider<ContextActionsInteractor> b;
    public final Provider<DeepLinkFactory> c;
    public final Provider<DeeplinkProcessor> d;
    public final Provider<ConnectivityProvider> e;
    public final Provider<Resources> f;
    public final Provider<Formatter<Throwable>> g;
    public final Provider<Analytics> h;
    public final Provider<SchedulersFactory> i;

    public ContextActionsPresenterImpl_Factory(Provider<LegacyPlatformActionsPresenter> provider, Provider<ContextActionsInteractor> provider2, Provider<DeepLinkFactory> provider3, Provider<DeeplinkProcessor> provider4, Provider<ConnectivityProvider> provider5, Provider<Resources> provider6, Provider<Formatter<Throwable>> provider7, Provider<Analytics> provider8, Provider<SchedulersFactory> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static ContextActionsPresenterImpl_Factory create(Provider<LegacyPlatformActionsPresenter> provider, Provider<ContextActionsInteractor> provider2, Provider<DeepLinkFactory> provider3, Provider<DeeplinkProcessor> provider4, Provider<ConnectivityProvider> provider5, Provider<Resources> provider6, Provider<Formatter<Throwable>> provider7, Provider<Analytics> provider8, Provider<SchedulersFactory> provider9) {
        return new ContextActionsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ContextActionsPresenterImpl newInstance(LegacyPlatformActionsPresenter legacyPlatformActionsPresenter, ContextActionsInteractor contextActionsInteractor, DeepLinkFactory deepLinkFactory, DeeplinkProcessor deeplinkProcessor, ConnectivityProvider connectivityProvider, Resources resources, Formatter<Throwable> formatter, Analytics analytics, SchedulersFactory schedulersFactory) {
        return new ContextActionsPresenterImpl(legacyPlatformActionsPresenter, contextActionsInteractor, deepLinkFactory, deeplinkProcessor, connectivityProvider, resources, formatter, analytics, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ContextActionsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
