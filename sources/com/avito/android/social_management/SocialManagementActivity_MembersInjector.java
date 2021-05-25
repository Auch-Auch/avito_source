package com.avito.android.social_management;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SocialManagementActivity_MembersInjector implements MembersInjector<SocialManagementActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<SocialManagementPresenter> c;
    public final Provider<Analytics> d;
    public final Provider<SocialTypeToStringMapper> e;
    public final Provider<DeepLinkIntentFactory> f;

    public SocialManagementActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SocialManagementPresenter> provider3, Provider<Analytics> provider4, Provider<SocialTypeToStringMapper> provider5, Provider<DeepLinkIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<SocialManagementActivity> create(Provider<ActivityIntentFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<SocialManagementPresenter> provider3, Provider<Analytics> provider4, Provider<SocialTypeToStringMapper> provider5, Provider<DeepLinkIntentFactory> provider6) {
        return new SocialManagementActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.adapter")
    public static void injectAdapter(SocialManagementActivity socialManagementActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        socialManagementActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.analytics")
    public static void injectAnalytics(SocialManagementActivity socialManagementActivity, Analytics analytics) {
        socialManagementActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SocialManagementActivity socialManagementActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        socialManagementActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.intentFactory")
    public static void injectIntentFactory(SocialManagementActivity socialManagementActivity, ActivityIntentFactory activityIntentFactory) {
        socialManagementActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.presenter")
    public static void injectPresenter(SocialManagementActivity socialManagementActivity, SocialManagementPresenter socialManagementPresenter) {
        socialManagementActivity.presenter = socialManagementPresenter;
    }

    @InjectedFieldSignature("com.avito.android.social_management.SocialManagementActivity.socialTypeToStringMapper")
    public static void injectSocialTypeToStringMapper(SocialManagementActivity socialManagementActivity, SocialTypeToStringMapper socialTypeToStringMapper) {
        socialManagementActivity.socialTypeToStringMapper = socialTypeToStringMapper;
    }

    public void injectMembers(SocialManagementActivity socialManagementActivity) {
        injectIntentFactory(socialManagementActivity, this.a.get());
        injectAdapter(socialManagementActivity, this.b.get());
        injectPresenter(socialManagementActivity, this.c.get());
        injectAnalytics(socialManagementActivity, this.d.get());
        injectSocialTypeToStringMapper(socialManagementActivity, this.e.get());
        injectDeepLinkIntentFactory(socialManagementActivity, this.f.get());
    }
}
