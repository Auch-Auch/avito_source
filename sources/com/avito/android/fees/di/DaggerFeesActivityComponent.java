package com.avito.android.fees.di;

import android.app.Activity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.fees.FeesActivity;
import com.avito.android.fees.FeesActivity_MembersInjector;
import com.avito.android.fees.FeesInteractor;
import com.avito.android.fees.FeesPresenter;
import com.avito.android.fees.di.FeesActivityComponent;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerFeesActivityComponent implements FeesActivityComponent {
    public final FeesActivityDependencies a;
    public Provider<FeesApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<ErrorFormatter> d;
    public Provider<PackageApplyInteractor> e;
    public Provider<PublishAnalyticsDataProvider> f;
    public Provider<FeesInteractor> g;
    public Provider<FeesPresenter> h;
    public Provider<Activity> i;
    public Provider<DialogRouter> j;

    public static final class b implements FeesActivityComponent.Builder {
        public FeesActivityModule a;
        public FeesActivityDependencies b;
        public Activity c;

        public b(a aVar) {
        }

        @Override // com.avito.android.fees.di.FeesActivityComponent.Builder
        public FeesActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FeesActivityModule.class);
            Preconditions.checkBuilderRequirement(this.b, FeesActivityDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerFeesActivityComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.fees.di.FeesActivityComponent.Builder
        public FeesActivityComponent.Builder dependencies(FeesActivityDependencies feesActivityDependencies) {
            this.b = (FeesActivityDependencies) Preconditions.checkNotNull(feesActivityDependencies);
            return this;
        }

        @Override // com.avito.android.fees.di.FeesActivityComponent.Builder
        public FeesActivityComponent.Builder feesActivityModule(FeesActivityModule feesActivityModule) {
            this.a = (FeesActivityModule) Preconditions.checkNotNull(feesActivityModule);
            return this;
        }

        @Override // com.avito.android.fees.di.FeesActivityComponent.Builder
        public FeesActivityComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<FeesApi> {
        public final FeesActivityDependencies a;

        public c(FeesActivityDependencies feesActivityDependencies) {
            this.a = feesActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FeesApi get() {
            return (FeesApi) Preconditions.checkNotNullFromComponent(this.a.feesApi());
        }
    }

    public static class d implements Provider<PublishAnalyticsDataProvider> {
        public final FeesActivityDependencies a;

        public d(FeesActivityDependencies feesActivityDependencies) {
            this.a = feesActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final FeesActivityDependencies a;

        public e(FeesActivityDependencies feesActivityDependencies) {
            this.a = feesActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerFeesActivityComponent(FeesActivityModule feesActivityModule, FeesActivityDependencies feesActivityDependencies, Activity activity, a aVar) {
        this.a = feesActivityDependencies;
        this.b = new c(feesActivityDependencies);
        this.c = new e(feesActivityDependencies);
        Provider<ErrorFormatter> provider = DoubleCheck.provider(FeesActivityModule_ProvideErrorFormatterFactory.create(feesActivityModule));
        this.d = provider;
        this.e = DoubleCheck.provider(FeesActivityModule_ProvidePackageApplyInteractorFactory.create(feesActivityModule, this.b, this.c, provider));
        d dVar = new d(feesActivityDependencies);
        this.f = dVar;
        Provider<FeesInteractor> provider2 = DoubleCheck.provider(FeesActivityModule_ProvideInteractorFactory.create(feesActivityModule, this.b, dVar));
        this.g = provider2;
        this.h = DoubleCheck.provider(FeesActivityModule_ProvidePresenterFactory.create(feesActivityModule, provider2, this.c, this.d));
        Factory create = InstanceFactory.create(activity);
        this.i = create;
        this.j = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
    }

    public static FeesActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.fees.di.FeesActivityComponent
    public void inject(FeesActivity feesActivity) {
        FeesActivity_MembersInjector.injectActivityIntentFactory(feesActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        FeesActivity_MembersInjector.injectFeesInteractor(feesActivity, this.g.get());
        FeesActivity_MembersInjector.injectFeesPresenter(feesActivity, this.h.get());
        FeesActivity_MembersInjector.injectDeepLinkIntentFactory(feesActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        FeesActivity_MembersInjector.injectAnalytics(feesActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FeesActivity_MembersInjector.injectAnalyticsData(feesActivity, (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()));
        FeesActivity_MembersInjector.injectFeatures(feesActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FeesActivity_MembersInjector.injectDialogRouter(feesActivity, this.j.get());
        FeesActivity_MembersInjector.injectAbTestConfigProvider(feesActivity, (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestConfigProvider()));
        FeesActivity_MembersInjector.injectAccountStateProvider(feesActivity, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
    }

    @Override // com.avito.android.fees.refactor.di.PackageFeesDependencies
    public PackageApplyInteractor packageApplyInteractor() {
        return this.e.get();
    }
}
