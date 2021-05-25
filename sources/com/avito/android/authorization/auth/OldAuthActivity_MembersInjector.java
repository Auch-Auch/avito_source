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
public final class OldAuthActivity_MembersInjector implements MembersInjector<OldAuthActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<AuthPresenter> c;
    public final Provider<Analytics> d;
    public final Provider<SmartLockLoader> e;
    public final Provider<SocialTypeToStringMapper> f;
    public final Provider<Features> g;
    public final Provider<ScreenTracker> h;

    public OldAuthActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AuthPresenter> provider3, Provider<Analytics> provider4, Provider<SmartLockLoader> provider5, Provider<SocialTypeToStringMapper> provider6, Provider<Features> provider7, Provider<ScreenTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<OldAuthActivity> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AuthPresenter> provider3, Provider<Analytics> provider4, Provider<SmartLockLoader> provider5, Provider<SocialTypeToStringMapper> provider6, Provider<Features> provider7, Provider<ScreenTracker> provider8) {
        return new OldAuthActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.analytics")
    public static void injectAnalytics(OldAuthActivity oldAuthActivity, Analytics analytics) {
        oldAuthActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(OldAuthActivity oldAuthActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        oldAuthActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.features")
    public static void injectFeatures(OldAuthActivity oldAuthActivity, Features features) {
        oldAuthActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.intentFactory")
    public static void injectIntentFactory(OldAuthActivity oldAuthActivity, ActivityIntentFactory activityIntentFactory) {
        oldAuthActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.presenter")
    public static void injectPresenter(OldAuthActivity oldAuthActivity, AuthPresenter authPresenter) {
        oldAuthActivity.presenter = authPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.screenTracker")
    public static void injectScreenTracker(OldAuthActivity oldAuthActivity, ScreenTracker screenTracker) {
        oldAuthActivity.screenTracker = screenTracker;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.smartLock")
    public static void injectSmartLock(OldAuthActivity oldAuthActivity, SmartLockLoader smartLockLoader) {
        oldAuthActivity.smartLock = smartLockLoader;
    }

    @InjectedFieldSignature("com.avito.android.authorization.auth.OldAuthActivity.socialTypeToStringMapper")
    public static void injectSocialTypeToStringMapper(OldAuthActivity oldAuthActivity, SocialTypeToStringMapper socialTypeToStringMapper) {
        oldAuthActivity.socialTypeToStringMapper = socialTypeToStringMapper;
    }

    public void injectMembers(OldAuthActivity oldAuthActivity) {
        injectIntentFactory(oldAuthActivity, this.a.get());
        injectDeepLinkIntentFactory(oldAuthActivity, this.b.get());
        injectPresenter(oldAuthActivity, this.c.get());
        injectAnalytics(oldAuthActivity, this.d.get());
        injectSmartLock(oldAuthActivity, this.e.get());
        injectSocialTypeToStringMapper(oldAuthActivity, this.f.get());
        injectFeatures(oldAuthActivity, this.g.get());
        injectScreenTracker(oldAuthActivity, this.h.get());
    }
}
