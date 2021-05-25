package com.avito.android.player.router;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.ui.fragments.TabBaseFragment;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlayerRouterImpl_Factory implements Factory<PlayerRouterImpl> {
    public final Provider<TabBaseFragment> a;
    public final Provider<ActivityIntentFactory> b;

    public PlayerRouterImpl_Factory(Provider<TabBaseFragment> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PlayerRouterImpl_Factory create(Provider<TabBaseFragment> provider, Provider<ActivityIntentFactory> provider2) {
        return new PlayerRouterImpl_Factory(provider, provider2);
    }

    public static PlayerRouterImpl newInstance(TabBaseFragment tabBaseFragment, ActivityIntentFactory activityIntentFactory) {
        return new PlayerRouterImpl(tabBaseFragment, activityIntentFactory);
    }

    @Override // javax.inject.Provider
    public PlayerRouterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
