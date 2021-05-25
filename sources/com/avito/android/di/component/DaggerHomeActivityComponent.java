package com.avito.android.di.component;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.di.component.HomeActivityComponent;
import com.avito.android.home.HomeActivity;
import com.avito.android.home.HomeActivity_MembersInjector;
import com.avito.android.ui.UserProfileStatusDataProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Preconditions;
public final class DaggerHomeActivityComponent implements HomeActivityComponent {
    public final HomeActivityDependencies a;

    public static final class b implements HomeActivityComponent.Builder {
        public HomeActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.HomeActivityComponent.Builder
        public HomeActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HomeActivityDependencies.class);
            return new DaggerHomeActivityComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.HomeActivityComponent.Builder
        public HomeActivityComponent.Builder dependencies(HomeActivityDependencies homeActivityDependencies) {
            this.a = (HomeActivityDependencies) Preconditions.checkNotNull(homeActivityDependencies);
            return this;
        }
    }

    public DaggerHomeActivityComponent(HomeActivityDependencies homeActivityDependencies, a aVar) {
        this.a = homeActivityDependencies;
    }

    public static HomeActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.HomeActivityComponent
    public void inject(HomeActivity homeActivity) {
        HomeActivity_MembersInjector.injectActivityIntentFactory(homeActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        HomeActivity_MembersInjector.injectTabFragmentFactory(homeActivity, (TabFragmentFactory) Preconditions.checkNotNullFromComponent(this.a.tabFragmentFactory()));
        HomeActivity_MembersInjector.injectUserProfileStatusDataProvider(homeActivity, (UserProfileStatusDataProvider) Preconditions.checkNotNullFromComponent(this.a.userProfileStatusDataProvider()));
        HomeActivity_MembersInjector.injectAnalytics(homeActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        HomeActivity_MembersInjector.injectAbPreferences(homeActivity, (Preferences) Preconditions.checkNotNullFromComponent(this.a.abTestsPreferences()));
        HomeActivity_MembersInjector.injectFeatures(homeActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        HomeActivity_MembersInjector.injectUserAdvertsTabTestGroup(homeActivity, (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.userAdvertsTabManuallyExposedTestGroup()));
        HomeActivity_MembersInjector.injectBuildInfo(homeActivity, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
        HomeActivity_MembersInjector.injectInAppUpdateTestGroup(homeActivity, (InAppUpdateTestGroup) Preconditions.checkNotNullFromComponent(this.a.inAppUpdateTestGroup()));
        HomeActivity_MembersInjector.injectDraftsOnStartPublishSheet(homeActivity, (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.draftsOnStartPublishSheet()));
        HomeActivity_MembersInjector.injectSchedulers(homeActivity, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
    }
}
