package com.avito.android.social;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SocialActivity_MembersInjector implements MembersInjector<SocialActivity> {
    public final Provider<SocialActivityPresenter> a;

    public SocialActivity_MembersInjector(Provider<SocialActivityPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<SocialActivity> create(Provider<SocialActivityPresenter> provider) {
        return new SocialActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.social.SocialActivity.presenter")
    public static void injectPresenter(SocialActivity socialActivity, SocialActivityPresenter socialActivityPresenter) {
        socialActivity.presenter = socialActivityPresenter;
    }

    public void injectMembers(SocialActivity socialActivity) {
        injectPresenter(socialActivity, this.a.get());
    }
}
