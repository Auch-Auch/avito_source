package com.avito.android.messenger.conversation.mvi.menu;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelMenuPresenterImpl_Factory implements Factory<ChannelMenuPresenterImpl> {
    public final Provider<ChannelMenuInteractor> a;
    public final Provider<BlacklistReasonsProvider> b;
    public final Provider<DeeplinkProcessor> c;
    public final Provider<Resources> d;
    public final Provider<Formatter<String>> e;
    public final Provider<Formatter<Throwable>> f;
    public final Provider<Features> g;
    public final Provider<SchedulersFactory> h;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> i;
    public final Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> j;

    public ChannelMenuPresenterImpl_Factory(Provider<ChannelMenuInteractor> provider, Provider<BlacklistReasonsProvider> provider2, Provider<DeeplinkProcessor> provider3, Provider<Resources> provider4, Provider<Formatter<String>> provider5, Provider<Formatter<Throwable>> provider6, Provider<Features> provider7, Provider<SchedulersFactory> provider8, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider9, Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static ChannelMenuPresenterImpl_Factory create(Provider<ChannelMenuInteractor> provider, Provider<BlacklistReasonsProvider> provider2, Provider<DeeplinkProcessor> provider3, Provider<Resources> provider4, Provider<Formatter<String>> provider5, Provider<Formatter<Throwable>> provider6, Provider<Features> provider7, Provider<SchedulersFactory> provider8, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider9, Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> provider10) {
        return new ChannelMenuPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static ChannelMenuPresenterImpl newInstance(ChannelMenuInteractor channelMenuInteractor, BlacklistReasonsProvider blacklistReasonsProvider, DeeplinkProcessor deeplinkProcessor, Resources resources, Formatter<String> formatter, Formatter<Throwable> formatter2, Features features, SchedulersFactory schedulersFactory, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> singleManuallyExposedAbTestGroup) {
        return new ChannelMenuPresenterImpl(channelMenuInteractor, blacklistReasonsProvider, deeplinkProcessor, resources, formatter, formatter2, features, schedulersFactory, manuallyExposedAbTestGroup, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public ChannelMenuPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
