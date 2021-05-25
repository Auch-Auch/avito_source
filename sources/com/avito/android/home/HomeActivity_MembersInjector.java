package com.avito.android.home;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTests;
import com.avito.android.ab_tests.DraftsOnStartPublishSheet;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.ui.UserProfileStatusDataProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HomeActivity_MembersInjector implements MembersInjector<HomeActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<TabFragmentFactory> b;
    public final Provider<UserProfileStatusDataProvider> c;
    public final Provider<Analytics> d;
    public final Provider<Preferences> e;
    public final Provider<Features> f;
    public final Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> g;
    public final Provider<BuildInfo> h;
    public final Provider<InAppUpdateTestGroup> i;
    public final Provider<ManuallyExposedAbTestGroup<SimpleTestGroup>> j;
    public final Provider<SchedulersFactory3> k;

    public HomeActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<TabFragmentFactory> provider2, Provider<UserProfileStatusDataProvider> provider3, Provider<Analytics> provider4, Provider<Preferences> provider5, Provider<Features> provider6, Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> provider7, Provider<BuildInfo> provider8, Provider<InAppUpdateTestGroup> provider9, Provider<ManuallyExposedAbTestGroup<SimpleTestGroup>> provider10, Provider<SchedulersFactory3> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static MembersInjector<HomeActivity> create(Provider<ActivityIntentFactory> provider, Provider<TabFragmentFactory> provider2, Provider<UserProfileStatusDataProvider> provider3, Provider<Analytics> provider4, Provider<Preferences> provider5, Provider<Features> provider6, Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> provider7, Provider<BuildInfo> provider8, Provider<InAppUpdateTestGroup> provider9, Provider<ManuallyExposedAbTestGroup<SimpleTestGroup>> provider10, Provider<SchedulersFactory3> provider11) {
        return new HomeActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @AbTests
    @InjectedFieldSignature("com.avito.android.home.HomeActivity.abPreferences")
    public static void injectAbPreferences(HomeActivity homeActivity, Preferences preferences) {
        homeActivity.abPreferences = preferences;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(HomeActivity homeActivity, ActivityIntentFactory activityIntentFactory) {
        homeActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.analytics")
    public static void injectAnalytics(HomeActivity homeActivity, Analytics analytics) {
        homeActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.buildInfo")
    public static void injectBuildInfo(HomeActivity homeActivity, BuildInfo buildInfo) {
        homeActivity.buildInfo = buildInfo;
    }

    @DraftsOnStartPublishSheet
    @InjectedFieldSignature("com.avito.android.home.HomeActivity.draftsOnStartPublishSheet")
    public static void injectDraftsOnStartPublishSheet(HomeActivity homeActivity, ManuallyExposedAbTestGroup<SimpleTestGroup> manuallyExposedAbTestGroup) {
        homeActivity.draftsOnStartPublishSheet = manuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.features")
    public static void injectFeatures(HomeActivity homeActivity, Features features) {
        homeActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.inAppUpdateTestGroup")
    public static void injectInAppUpdateTestGroup(HomeActivity homeActivity, InAppUpdateTestGroup inAppUpdateTestGroup) {
        homeActivity.inAppUpdateTestGroup = inAppUpdateTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.schedulers")
    public static void injectSchedulers(HomeActivity homeActivity, SchedulersFactory3 schedulersFactory3) {
        homeActivity.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.tabFragmentFactory")
    public static void injectTabFragmentFactory(HomeActivity homeActivity, TabFragmentFactory tabFragmentFactory) {
        homeActivity.tabFragmentFactory = tabFragmentFactory;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.userAdvertsTabTestGroup")
    public static void injectUserAdvertsTabTestGroup(HomeActivity homeActivity, SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> singleManuallyExposedAbTestGroup) {
        homeActivity.userAdvertsTabTestGroup = singleManuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeActivity.userProfileStatusDataProvider")
    public static void injectUserProfileStatusDataProvider(HomeActivity homeActivity, UserProfileStatusDataProvider userProfileStatusDataProvider) {
        homeActivity.userProfileStatusDataProvider = userProfileStatusDataProvider;
    }

    public void injectMembers(HomeActivity homeActivity) {
        injectActivityIntentFactory(homeActivity, this.a.get());
        injectTabFragmentFactory(homeActivity, this.b.get());
        injectUserProfileStatusDataProvider(homeActivity, this.c.get());
        injectAnalytics(homeActivity, this.d.get());
        injectAbPreferences(homeActivity, this.e.get());
        injectFeatures(homeActivity, this.f.get());
        injectUserAdvertsTabTestGroup(homeActivity, this.g.get());
        injectBuildInfo(homeActivity, this.h.get());
        injectInAppUpdateTestGroup(homeActivity, this.i.get());
        injectDraftsOnStartPublishSheet(homeActivity, this.j.get());
        injectSchedulers(homeActivity, this.k.get());
    }
}
