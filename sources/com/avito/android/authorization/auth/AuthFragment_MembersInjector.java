package com.avito.android.authorization.auth;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.social.SocialTypeToStringMapper;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AuthFragment_MembersInjector implements MembersInjector<AuthFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<AuthPresenter> c;
    public final Provider<Analytics> d;
    public final Provider<SmartLockLoader> e;
    public final Provider<SocialTypeToStringMapper> f;
    public final Provider<Features> g;
    public final Provider<ScreenTracker> h;

    public AuthFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AuthPresenter> provider3, Provider<Analytics> provider4, Provider<SmartLockLoader> provider5, Provider<SocialTypeToStringMapper> provider6, Provider<Features> provider7, Provider<ScreenTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<AuthFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AuthPresenter> provider3, Provider<Analytics> provider4, Provider<SmartLockLoader> provider5, Provider<SocialTypeToStringMapper> provider6, Provider<Features> provider7, Provider<ScreenTracker> provider8) {
        return new AuthFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.analytics")
    public static void injectAnalytics(AuthFragment authFragment, Analytics analytics) {
        authFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AuthFragment authFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        authFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.features")
    public static void injectFeatures(AuthFragment authFragment, Features features) {
        authFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.intentFactory")
    public static void injectIntentFactory(AuthFragment authFragment, ActivityIntentFactory activityIntentFactory) {
        authFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.presenter")
    public static void injectPresenter(AuthFragment authFragment, AuthPresenter authPresenter) {
        authFragment.presenter = authPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.screenTracker")
    public static void injectScreenTracker(AuthFragment authFragment, ScreenTracker screenTracker) {
        authFragment.screenTracker = screenTracker;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.smartLock")
    public static void injectSmartLock(AuthFragment authFragment, SmartLockLoader smartLockLoader) {
        authFragment.smartLock = smartLockLoader;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.AuthFragment.socialTypeToStringMapper")
    public static void injectSocialTypeToStringMapper(AuthFragment authFragment, SocialTypeToStringMapper socialTypeToStringMapper) {
        authFragment.socialTypeToStringMapper = socialTypeToStringMapper;
    }

    public void injectMembers(AuthFragment authFragment) {
        injectIntentFactory(authFragment, this.a.get());
        injectDeepLinkIntentFactory(authFragment, this.b.get());
        injectPresenter(authFragment, this.c.get());
        injectAnalytics(authFragment, this.d.get());
        injectSmartLock(authFragment, this.e.get());
        injectSocialTypeToStringMapper(authFragment, this.f.get());
        injectFeatures(authFragment, this.g.get());
        injectScreenTracker(authFragment, this.h.get());
    }
}
