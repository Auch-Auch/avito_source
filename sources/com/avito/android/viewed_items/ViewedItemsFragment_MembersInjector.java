package com.avito.android.viewed_items;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.viewed_items.di.ViewedItems;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ViewedItemsFragment_MembersInjector implements MembersInjector<ViewedItemsFragment> {
    public final Provider<ViewedItemsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<ActivityIntentFactory> d;

    public ViewedItemsFragment_MembersInjector(Provider<ViewedItemsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ViewedItemsFragment> create(Provider<ViewedItemsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4) {
        return new ViewedItemsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.viewed_items.ViewedItemsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ViewedItemsFragment viewedItemsFragment, ActivityIntentFactory activityIntentFactory) {
        viewedItemsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.viewed_items.ViewedItemsFragment.adapterPresenter")
    @ViewedItems
    public static void injectAdapterPresenter(ViewedItemsFragment viewedItemsFragment, AdapterPresenter adapterPresenter) {
        viewedItemsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.viewed_items.ViewedItemsFragment.itemBinder")
    @ViewedItems
    public static void injectItemBinder(ViewedItemsFragment viewedItemsFragment, ItemBinder itemBinder) {
        viewedItemsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.viewed_items.ViewedItemsFragment.presenter")
    public static void injectPresenter(ViewedItemsFragment viewedItemsFragment, ViewedItemsPresenter viewedItemsPresenter) {
        viewedItemsFragment.presenter = viewedItemsPresenter;
    }

    public void injectMembers(ViewedItemsFragment viewedItemsFragment) {
        injectPresenter(viewedItemsFragment, this.a.get());
        injectAdapterPresenter(viewedItemsFragment, this.b.get());
        injectItemBinder(viewedItemsFragment, this.c.get());
        injectActivityIntentFactory(viewedItemsFragment, this.d.get());
    }
}
