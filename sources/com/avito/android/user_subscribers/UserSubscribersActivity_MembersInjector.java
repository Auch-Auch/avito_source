package com.avito.android.user_subscribers;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserSubscribersActivity_MembersInjector implements MembersInjector<UserSubscribersActivity> {
    public final Provider<UserSubscribersPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<DeepLinkIntentFactory> d;

    public UserSubscribersActivity_MembersInjector(Provider<UserSubscribersPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<UserSubscribersActivity> create(Provider<UserSubscribersPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4) {
        return new UserSubscribersActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.user_subscribers.UserSubscribersActivity.adapterPresenter")
    public static void injectAdapterPresenter(UserSubscribersActivity userSubscribersActivity, AdapterPresenter adapterPresenter) {
        userSubscribersActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_subscribers.UserSubscribersActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserSubscribersActivity userSubscribersActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        userSubscribersActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_subscribers.UserSubscribersActivity.itemBinder")
    public static void injectItemBinder(UserSubscribersActivity userSubscribersActivity, ItemBinder itemBinder) {
        userSubscribersActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.user_subscribers.UserSubscribersActivity.presenter")
    public static void injectPresenter(UserSubscribersActivity userSubscribersActivity, UserSubscribersPresenter userSubscribersPresenter) {
        userSubscribersActivity.presenter = userSubscribersPresenter;
    }

    public void injectMembers(UserSubscribersActivity userSubscribersActivity) {
        injectPresenter(userSubscribersActivity, this.a.get());
        injectAdapterPresenter(userSubscribersActivity, this.b.get());
        injectItemBinder(userSubscribersActivity, this.c.get());
        injectDeepLinkIntentFactory(userSubscribersActivity, this.d.get());
    }
}
