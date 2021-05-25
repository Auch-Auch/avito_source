package com.avito.android.publish.view;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.SelectItemBaseFragment_MembersInjector;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ItemDetailsBaseFragment_MembersInjector implements MembersInjector<ItemDetailsBaseFragment> {
    public final Provider<ItemDetailsSelectResultHandler> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<Features> d;

    public ItemDetailsBaseFragment_MembersInjector(Provider<ItemDetailsSelectResultHandler> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ItemDetailsBaseFragment> create(Provider<ItemDetailsSelectResultHandler> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4) {
        return new ItemDetailsBaseFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.publish.view.ItemDetailsBaseFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ItemDetailsBaseFragment itemDetailsBaseFragment, ActivityIntentFactory activityIntentFactory) {
        itemDetailsBaseFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.view.ItemDetailsBaseFragment.features")
    public static void injectFeatures(ItemDetailsBaseFragment itemDetailsBaseFragment, Features features) {
        itemDetailsBaseFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.publish.view.ItemDetailsBaseFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ItemDetailsBaseFragment itemDetailsBaseFragment, ImplicitIntentFactory implicitIntentFactory) {
        itemDetailsBaseFragment.implicitIntentFactory = implicitIntentFactory;
    }

    public void injectMembers(ItemDetailsBaseFragment itemDetailsBaseFragment) {
        SelectItemBaseFragment_MembersInjector.injectResultHandler(itemDetailsBaseFragment, this.a.get());
        injectActivityIntentFactory(itemDetailsBaseFragment, this.b.get());
        injectImplicitIntentFactory(itemDetailsBaseFragment, this.c.get());
        injectFeatures(itemDetailsBaseFragment, this.d.get());
    }
}
