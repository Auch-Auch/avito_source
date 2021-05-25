package com.avito.android.profile.password_change;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PasswordChangeFragment_MembersInjector implements MembersInjector<PasswordChangeFragment> {
    public final Provider<PasswordChangePresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<SmartLockLoader> d;
    public final Provider<SmartLockSaver> e;
    public final Provider<Analytics> f;

    public PasswordChangeFragment_MembersInjector(Provider<PasswordChangePresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SmartLockLoader> provider4, Provider<SmartLockSaver> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<PasswordChangeFragment> create(Provider<PasswordChangePresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SmartLockLoader> provider4, Provider<SmartLockSaver> provider5, Provider<Analytics> provider6) {
        return new PasswordChangeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PasswordChangeFragment passwordChangeFragment, ActivityIntentFactory activityIntentFactory) {
        passwordChangeFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.analytics")
    public static void injectAnalytics(PasswordChangeFragment passwordChangeFragment, Analytics analytics) {
        passwordChangeFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PasswordChangeFragment passwordChangeFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        passwordChangeFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.presenter")
    public static void injectPresenter(PasswordChangeFragment passwordChangeFragment, PasswordChangePresenter passwordChangePresenter) {
        passwordChangeFragment.presenter = passwordChangePresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.smartLockLoader")
    public static void injectSmartLockLoader(PasswordChangeFragment passwordChangeFragment, SmartLockLoader smartLockLoader) {
        passwordChangeFragment.smartLockLoader = smartLockLoader;
    }

    @InjectedFieldSignature("com.avito.android.profile.password_change.PasswordChangeFragment.smartLockSaver")
    public static void injectSmartLockSaver(PasswordChangeFragment passwordChangeFragment, SmartLockSaver smartLockSaver) {
        passwordChangeFragment.smartLockSaver = smartLockSaver;
    }

    public void injectMembers(PasswordChangeFragment passwordChangeFragment) {
        injectPresenter(passwordChangeFragment, this.a.get());
        injectActivityIntentFactory(passwordChangeFragment, this.b.get());
        injectDeepLinkIntentFactory(passwordChangeFragment, this.c.get());
        injectSmartLockLoader(passwordChangeFragment, this.d.get());
        injectSmartLockSaver(passwordChangeFragment, this.e.get());
        injectAnalytics(passwordChangeFragment, this.f.get());
    }
}
