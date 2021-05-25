package com.avito.android.authorization.auth.di;

import com.avito.android.Features;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.SignInManager;
import com.avito.android.social.VkontakteSocialManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import javax.inject.Provider;
public final class AuthModule_ProvideSocialManagersFactory implements Factory<ArrayList<SignInManager>> {
    public final Provider<FacebookSocialManager> a;
    public final Provider<OdnoklassnikiSocialManager> b;
    public final Provider<VkontakteSocialManager> c;
    public final Provider<GoogleSocialManager> d;
    public final Provider<AppleSignInManager> e;
    public final Provider<Features> f;

    public AuthModule_ProvideSocialManagersFactory(Provider<FacebookSocialManager> provider, Provider<OdnoklassnikiSocialManager> provider2, Provider<VkontakteSocialManager> provider3, Provider<GoogleSocialManager> provider4, Provider<AppleSignInManager> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AuthModule_ProvideSocialManagersFactory create(Provider<FacebookSocialManager> provider, Provider<OdnoklassnikiSocialManager> provider2, Provider<VkontakteSocialManager> provider3, Provider<GoogleSocialManager> provider4, Provider<AppleSignInManager> provider5, Provider<Features> provider6) {
        return new AuthModule_ProvideSocialManagersFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ArrayList<SignInManager> provideSocialManagers(FacebookSocialManager facebookSocialManager, OdnoklassnikiSocialManager odnoklassnikiSocialManager, VkontakteSocialManager vkontakteSocialManager, GoogleSocialManager googleSocialManager, AppleSignInManager appleSignInManager, Features features) {
        return (ArrayList) Preconditions.checkNotNullFromProvides(AuthModule.provideSocialManagers(facebookSocialManager, odnoklassnikiSocialManager, vkontakteSocialManager, googleSocialManager, appleSignInManager, features));
    }

    @Override // javax.inject.Provider
    public ArrayList<SignInManager> get() {
        return provideSocialManagers(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
