package com.avito.android.advert.badge_details;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BadgeDetailsActivity_MembersInjector implements MembersInjector<BadgeDetailsActivity> {
    public final Provider<BadgeDetailsPresenter> a;
    public final Provider<DeepLinkIntentFactory> b;

    public BadgeDetailsActivity_MembersInjector(Provider<BadgeDetailsPresenter> provider, Provider<DeepLinkIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<BadgeDetailsActivity> create(Provider<BadgeDetailsPresenter> provider, Provider<DeepLinkIntentFactory> provider2) {
        return new BadgeDetailsActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.advert.badge_details.BadgeDetailsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(BadgeDetailsActivity badgeDetailsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        badgeDetailsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.badge_details.BadgeDetailsActivity.presenter")
    public static void injectPresenter(BadgeDetailsActivity badgeDetailsActivity, BadgeDetailsPresenter badgeDetailsPresenter) {
        badgeDetailsActivity.presenter = badgeDetailsPresenter;
    }

    public void injectMembers(BadgeDetailsActivity badgeDetailsActivity) {
        injectPresenter(badgeDetailsActivity, this.a.get());
        injectDeepLinkIntentFactory(badgeDetailsActivity, this.b.get());
    }
}
