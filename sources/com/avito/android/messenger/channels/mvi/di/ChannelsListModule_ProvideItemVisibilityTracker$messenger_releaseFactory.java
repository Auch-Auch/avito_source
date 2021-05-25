package com.avito.android.messenger.channels.mvi.di;

import android.os.Bundle;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsListModule_ProvideItemVisibilityTracker$messenger_releaseFactory implements Factory<ItemVisibilityTracker> {
    public final Provider<BannerViewFilter> a;
    public final Provider<Bundle> b;

    public ChannelsListModule_ProvideItemVisibilityTracker$messenger_releaseFactory(Provider<BannerViewFilter> provider, Provider<Bundle> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsListModule_ProvideItemVisibilityTracker$messenger_releaseFactory create(Provider<BannerViewFilter> provider, Provider<Bundle> provider2) {
        return new ChannelsListModule_ProvideItemVisibilityTracker$messenger_releaseFactory(provider, provider2);
    }

    public static ItemVisibilityTracker provideItemVisibilityTracker$messenger_release(BannerViewFilter bannerViewFilter, Bundle bundle) {
        return (ItemVisibilityTracker) Preconditions.checkNotNullFromProvides(ChannelsListModule.INSTANCE.provideItemVisibilityTracker$messenger_release(bannerViewFilter, bundle));
    }

    @Override // javax.inject.Provider
    public ItemVisibilityTracker get() {
        return provideItemVisibilityTracker$messenger_release(this.a.get(), this.b.get());
    }
}
