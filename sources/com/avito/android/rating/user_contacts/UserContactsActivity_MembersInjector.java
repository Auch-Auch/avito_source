package com.avito.android.rating.user_contacts;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserContactsActivity_MembersInjector implements MembersInjector<UserContactsActivity> {
    public final Provider<UserContactsPresenter> a;
    public final Provider<ResponsiveAdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<UserContactsSpanProvider> e;
    public final Provider<Analytics> f;

    public UserContactsActivity_MembersInjector(Provider<UserContactsPresenter> provider, Provider<ResponsiveAdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<UserContactsSpanProvider> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<UserContactsActivity> create(Provider<UserContactsPresenter> provider, Provider<ResponsiveAdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<UserContactsSpanProvider> provider5, Provider<Analytics> provider6) {
        return new UserContactsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.adapterPresenter")
    public static void injectAdapterPresenter(UserContactsActivity userContactsActivity, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        userContactsActivity.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.analytics")
    public static void injectAnalytics(UserContactsActivity userContactsActivity, Analytics analytics) {
        userContactsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserContactsActivity userContactsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        userContactsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.itemBinder")
    public static void injectItemBinder(UserContactsActivity userContactsActivity, ItemBinder itemBinder) {
        userContactsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.presenter")
    public static void injectPresenter(UserContactsActivity userContactsActivity, UserContactsPresenter userContactsPresenter) {
        userContactsActivity.presenter = userContactsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_contacts.UserContactsActivity.spanProvider")
    public static void injectSpanProvider(UserContactsActivity userContactsActivity, UserContactsSpanProvider userContactsSpanProvider) {
        userContactsActivity.spanProvider = userContactsSpanProvider;
    }

    public void injectMembers(UserContactsActivity userContactsActivity) {
        injectPresenter(userContactsActivity, this.a.get());
        injectAdapterPresenter(userContactsActivity, this.b.get());
        injectItemBinder(userContactsActivity, this.c.get());
        injectDeepLinkIntentFactory(userContactsActivity, this.d.get());
        injectSpanProvider(userContactsActivity, this.e.get());
        injectAnalytics(userContactsActivity, this.f.get());
    }
}
