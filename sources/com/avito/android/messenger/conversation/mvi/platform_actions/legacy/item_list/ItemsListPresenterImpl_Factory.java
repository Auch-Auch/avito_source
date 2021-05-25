package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemsListPresenterImpl_Factory implements Factory<ItemsListPresenterImpl> {
    public final Provider<LegacyPlatformActionsPresenter> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ItemsListInteractor> c;
    public final Provider<Analytics> d;

    public ItemsListPresenterImpl_Factory(Provider<LegacyPlatformActionsPresenter> provider, Provider<SchedulersFactory> provider2, Provider<ItemsListInteractor> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ItemsListPresenterImpl_Factory create(Provider<LegacyPlatformActionsPresenter> provider, Provider<SchedulersFactory> provider2, Provider<ItemsListInteractor> provider3, Provider<Analytics> provider4) {
        return new ItemsListPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ItemsListPresenterImpl newInstance(LegacyPlatformActionsPresenter legacyPlatformActionsPresenter, SchedulersFactory schedulersFactory, ItemsListInteractor itemsListInteractor, Analytics analytics) {
        return new ItemsListPresenterImpl(legacyPlatformActionsPresenter, schedulersFactory, itemsListInteractor, analytics);
    }

    @Override // javax.inject.Provider
    public ItemsListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
