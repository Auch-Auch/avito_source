package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChatListAdBannerInteractorImpl_Factory implements Factory<ChatListAdBannerInteractorImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<BuildInfo> c;
    public final Provider<SavedLocationInteractor> d;
    public final Provider<CommercialBannersInteractor> e;
    public final Provider<CommercialBannersAnalyticsInteractor> f;
    public final Provider<Preferences> g;
    public final Provider<TimeSource> h;
    public final Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> i;
    public final Provider<Features> j;

    public ChatListAdBannerInteractorImpl_Factory(Provider<SchedulersFactory> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<BuildInfo> provider3, Provider<SavedLocationInteractor> provider4, Provider<CommercialBannersInteractor> provider5, Provider<CommercialBannersAnalyticsInteractor> provider6, Provider<Preferences> provider7, Provider<TimeSource> provider8, Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> provider9, Provider<Features> provider10) {
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

    public static ChatListAdBannerInteractorImpl_Factory create(Provider<SchedulersFactory> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<BuildInfo> provider3, Provider<SavedLocationInteractor> provider4, Provider<CommercialBannersInteractor> provider5, Provider<CommercialBannersAnalyticsInteractor> provider6, Provider<Preferences> provider7, Provider<TimeSource> provider8, Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> provider9, Provider<Features> provider10) {
        return new ChatListAdBannerInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static ChatListAdBannerInteractorImpl newInstance(SchedulersFactory schedulersFactory, MessengerClient<AvitoMessengerApi> messengerClient, BuildInfo buildInfo, SavedLocationInteractor savedLocationInteractor, CommercialBannersInteractor commercialBannersInteractor, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, Preferences preferences, TimeSource timeSource, SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> singleManuallyExposedAbTestGroup, Features features) {
        return new ChatListAdBannerInteractorImpl(schedulersFactory, messengerClient, buildInfo, savedLocationInteractor, commercialBannersInteractor, commercialBannersAnalyticsInteractor, preferences, timeSource, singleManuallyExposedAbTestGroup, features);
    }

    @Override // javax.inject.Provider
    public ChatListAdBannerInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
