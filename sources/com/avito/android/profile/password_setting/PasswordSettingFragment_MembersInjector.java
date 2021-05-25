package com.avito.android.profile.password_setting;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PasswordSettingFragment_MembersInjector implements MembersInjector<PasswordSettingFragment> {
    public final Provider<PasswordSettingPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;

    public PasswordSettingFragment_MembersInjector(Provider<PasswordSettingPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<PasswordSettingFragment> create(Provider<PasswordSettingPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new PasswordSettingFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.profile.password_setting.PasswordSettingFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PasswordSettingFragment passwordSettingFragment, ActivityIntentFactory activityIntentFactory) {
        passwordSettingFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_setting.PasswordSettingFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PasswordSettingFragment passwordSettingFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        passwordSettingFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_setting.PasswordSettingFragment.presenter")
    public static void injectPresenter(PasswordSettingFragment passwordSettingFragment, PasswordSettingPresenter passwordSettingPresenter) {
        passwordSettingFragment.presenter = passwordSettingPresenter;
    }

    public void injectMembers(PasswordSettingFragment passwordSettingFragment) {
        injectPresenter(passwordSettingFragment, this.a.get());
        injectActivityIntentFactory(passwordSettingFragment, this.b.get());
        injectDeepLinkIntentFactory(passwordSettingFragment, this.c.get());
    }
}
