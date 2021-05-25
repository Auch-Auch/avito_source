package com.avito.android.social.di;

import android.os.Bundle;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SocialActivityPresenter;
import com.avito.android.social.VkontakteSocialManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SocialActivityModule_ProvideSocialActivityPresenterFactory implements Factory<SocialActivityPresenter> {
    public final Provider<FacebookSocialManager> a;
    public final Provider<OdnoklassnikiSocialManager> b;
    public final Provider<VkontakteSocialManager> c;
    public final Provider<GoogleSocialManager> d;
    public final Provider<AppleSignInManager> e;
    public final Provider<EsiaSignInManager> f;
    public final Provider<Bundle> g;

    public SocialActivityModule_ProvideSocialActivityPresenterFactory(Provider<FacebookSocialManager> provider, Provider<OdnoklassnikiSocialManager> provider2, Provider<VkontakteSocialManager> provider3, Provider<GoogleSocialManager> provider4, Provider<AppleSignInManager> provider5, Provider<EsiaSignInManager> provider6, Provider<Bundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static SocialActivityModule_ProvideSocialActivityPresenterFactory create(Provider<FacebookSocialManager> provider, Provider<OdnoklassnikiSocialManager> provider2, Provider<VkontakteSocialManager> provider3, Provider<GoogleSocialManager> provider4, Provider<AppleSignInManager> provider5, Provider<EsiaSignInManager> provider6, Provider<Bundle> provider7) {
        return new SocialActivityModule_ProvideSocialActivityPresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SocialActivityPresenter provideSocialActivityPresenter(FacebookSocialManager facebookSocialManager, OdnoklassnikiSocialManager odnoklassnikiSocialManager, VkontakteSocialManager vkontakteSocialManager, GoogleSocialManager googleSocialManager, AppleSignInManager appleSignInManager, EsiaSignInManager esiaSignInManager, Bundle bundle) {
        return (SocialActivityPresenter) Preconditions.checkNotNullFromProvides(SocialActivityModule.provideSocialActivityPresenter(facebookSocialManager, odnoklassnikiSocialManager, vkontakteSocialManager, googleSocialManager, appleSignInManager, esiaSignInManager, bundle));
    }

    @Override // javax.inject.Provider
    public SocialActivityPresenter get() {
        return provideSocialActivityPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
