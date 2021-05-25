package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.api.entity.UserLastActivity;
public final class ChannelContextPresenterImpl_Factory implements Factory<ChannelContextPresenterImpl> {
    public final Provider<ChannelContextView.State> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ChannelContextInteractor> c;
    public final Provider<Formatter<UserLastActivity>> d;
    public final Provider<Analytics> e;
    public final Provider<DeepLinkFactory> f;
    public final Provider<DeeplinkProcessor> g;
    public final Provider<ChannelTracker> h;

    public ChannelContextPresenterImpl_Factory(Provider<ChannelContextView.State> provider, Provider<SchedulersFactory> provider2, Provider<ChannelContextInteractor> provider3, Provider<Formatter<UserLastActivity>> provider4, Provider<Analytics> provider5, Provider<DeepLinkFactory> provider6, Provider<DeeplinkProcessor> provider7, Provider<ChannelTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ChannelContextPresenterImpl_Factory create(Provider<ChannelContextView.State> provider, Provider<SchedulersFactory> provider2, Provider<ChannelContextInteractor> provider3, Provider<Formatter<UserLastActivity>> provider4, Provider<Analytics> provider5, Provider<DeepLinkFactory> provider6, Provider<DeeplinkProcessor> provider7, Provider<ChannelTracker> provider8) {
        return new ChannelContextPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ChannelContextPresenterImpl newInstance(ChannelContextView.State state, SchedulersFactory schedulersFactory, ChannelContextInteractor channelContextInteractor, Formatter<UserLastActivity> formatter, Analytics analytics, DeepLinkFactory deepLinkFactory, DeeplinkProcessor deeplinkProcessor, ChannelTracker channelTracker) {
        return new ChannelContextPresenterImpl(state, schedulersFactory, channelContextInteractor, formatter, analytics, deepLinkFactory, deeplinkProcessor, channelTracker);
    }

    @Override // javax.inject.Provider
    public ChannelContextPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
