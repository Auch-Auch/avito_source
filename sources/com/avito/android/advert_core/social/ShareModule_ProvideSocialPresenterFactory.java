package com.avito.android.advert_core.social;

import com.avito.android.analytics.Analytics;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.MailSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.TwitterSocialManager;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.button.SocialInfoProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShareModule_ProvideSocialPresenterFactory implements Factory<SocialPresenter> {
    public final Provider<FacebookSocialManager> a;
    public final Provider<LiveJournalSocialManager> b;
    public final Provider<MailSocialManager> c;
    public final Provider<OdnoklassnikiSocialManager> d;
    public final Provider<TwitterSocialManager> e;
    public final Provider<VkontakteSocialManager> f;
    public final Provider<SocialInfoProvider> g;
    public final Provider<Analytics> h;
    public final Provider<SocialTypeToStringMapper> i;

    public ShareModule_ProvideSocialPresenterFactory(Provider<FacebookSocialManager> provider, Provider<LiveJournalSocialManager> provider2, Provider<MailSocialManager> provider3, Provider<OdnoklassnikiSocialManager> provider4, Provider<TwitterSocialManager> provider5, Provider<VkontakteSocialManager> provider6, Provider<SocialInfoProvider> provider7, Provider<Analytics> provider8, Provider<SocialTypeToStringMapper> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static ShareModule_ProvideSocialPresenterFactory create(Provider<FacebookSocialManager> provider, Provider<LiveJournalSocialManager> provider2, Provider<MailSocialManager> provider3, Provider<OdnoklassnikiSocialManager> provider4, Provider<TwitterSocialManager> provider5, Provider<VkontakteSocialManager> provider6, Provider<SocialInfoProvider> provider7, Provider<Analytics> provider8, Provider<SocialTypeToStringMapper> provider9) {
        return new ShareModule_ProvideSocialPresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SocialPresenter provideSocialPresenter(FacebookSocialManager facebookSocialManager, LiveJournalSocialManager liveJournalSocialManager, MailSocialManager mailSocialManager, OdnoklassnikiSocialManager odnoklassnikiSocialManager, TwitterSocialManager twitterSocialManager, VkontakteSocialManager vkontakteSocialManager, SocialInfoProvider socialInfoProvider, Analytics analytics, SocialTypeToStringMapper socialTypeToStringMapper) {
        return (SocialPresenter) Preconditions.checkNotNullFromProvides(ShareModule.provideSocialPresenter(facebookSocialManager, liveJournalSocialManager, mailSocialManager, odnoklassnikiSocialManager, twitterSocialManager, vkontakteSocialManager, socialInfoProvider, analytics, socialTypeToStringMapper));
    }

    @Override // javax.inject.Provider
    public SocialPresenter get() {
        return provideSocialPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
