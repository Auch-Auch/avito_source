package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelListAdBannerItemFactoryImpl_Factory implements Factory<ChannelListAdBannerItemFactoryImpl> {
    public final Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MyTargetImageBgProvider> c;
    public final Provider<Features> d;

    public ChannelListAdBannerItemFactoryImpl_Factory(Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> provider, Provider<SchedulersFactory3> provider2, Provider<MyTargetImageBgProvider> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChannelListAdBannerItemFactoryImpl_Factory create(Provider<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> provider, Provider<SchedulersFactory3> provider2, Provider<MyTargetImageBgProvider> provider3, Provider<Features> provider4) {
        return new ChannelListAdBannerItemFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChannelListAdBannerItemFactoryImpl newInstance(SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> singleManuallyExposedAbTestGroup, SchedulersFactory3 schedulersFactory3, MyTargetImageBgProvider myTargetImageBgProvider, Features features) {
        return new ChannelListAdBannerItemFactoryImpl(singleManuallyExposedAbTestGroup, schedulersFactory3, myTargetImageBgProvider, features);
    }

    @Override // javax.inject.Provider
    public ChannelListAdBannerItemFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
