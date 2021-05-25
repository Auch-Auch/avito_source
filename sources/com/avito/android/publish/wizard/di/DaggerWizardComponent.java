package com.avito.android.publish.wizard.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.publish.wizard.WizardFragment;
import com.avito.android.publish.wizard.WizardFragment_MembersInjector;
import com.avito.android.publish.wizard.WizardInteractor;
import com.avito.android.publish.wizard.WizardPresenter;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTracker;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTrackerImpl;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTrackerImpl_Factory;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprint;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.publish.wizard.di.WizardComponent;
import com.avito.android.publish.wizard.remote.WizardApi;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerWizardComponent implements WizardComponent {
    public final WizardDependencies a;
    public Provider<WizardApi> b;
    public Provider<PublishAnalyticsDataProvider> c;
    public Provider<WizardInteractor> d;
    public Provider<WizardItemPresenter> e;
    public Provider<WizardItemBlueprint> f;
    public Provider<ItemBinder> g;
    public Provider<AdapterPresenter> h;
    public Provider<SchedulersFactory> i;
    public Provider<Analytics> j;
    public Provider<ScreenTrackerFactory> k;
    public Provider<ScreenDiInjectTracker> l;
    public Provider<ScreenInitTracker> m;
    public Provider<ScreenFlowTrackerProvider> n;
    public Provider<CategoriesWizardTrackerImpl> o;
    public Provider<CategoriesWizardTracker> p;
    public Provider<Set<ItemPresenter<?, ?>>> q;
    public Provider<WizardPresenter> r;

    public static final class b implements WizardComponent.Builder {
        public WizardDependencies a;
        public WizardModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.wizard.di.WizardComponent.Builder
        public WizardComponent build() {
            Preconditions.checkBuilderRequirement(this.a, WizardDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, WizardModule.class);
            return new DaggerWizardComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.wizard.di.WizardComponent.Builder
        public WizardComponent.Builder dependencies(WizardDependencies wizardDependencies) {
            this.a = (WizardDependencies) Preconditions.checkNotNull(wizardDependencies);
            return this;
        }

        @Override // com.avito.android.publish.wizard.di.WizardComponent.Builder
        public WizardComponent.Builder wizardModule(WizardModule wizardModule) {
            this.b = (WizardModule) Preconditions.checkNotNull(wizardModule);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final WizardDependencies a;

        public c(WizardDependencies wizardDependencies) {
            this.a = wizardDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<PublishAnalyticsDataProvider> {
        public final WizardDependencies a;

        public d(WizardDependencies wizardDependencies) {
            this.a = wizardDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.analyticsDataProvider());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final WizardDependencies a;

        public e(WizardDependencies wizardDependencies) {
            this.a = wizardDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<ScreenTrackerFactory> {
        public final WizardDependencies a;

        public f(WizardDependencies wizardDependencies) {
            this.a = wizardDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class g implements Provider<WizardApi> {
        public final WizardDependencies a;

        public g(WizardDependencies wizardDependencies) {
            this.a = wizardDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public WizardApi get() {
            return (WizardApi) Preconditions.checkNotNullFromComponent(this.a.wizardApi());
        }
    }

    public DaggerWizardComponent(WizardModule wizardModule, WizardDependencies wizardDependencies, a aVar) {
        this.a = wizardDependencies;
        g gVar = new g(wizardDependencies);
        this.b = gVar;
        d dVar = new d(wizardDependencies);
        this.c = dVar;
        this.d = DoubleCheck.provider(WizardModule_ProvideWizardInteractor$publish_releaseFactory.create(wizardModule, gVar, dVar));
        Provider<WizardItemPresenter> provider = DoubleCheck.provider(WizardModule_ProvideWizardItemPresenter$publish_releaseFactory.create(wizardModule));
        this.e = provider;
        Provider<WizardItemBlueprint> provider2 = DoubleCheck.provider(WizardModule_ProvideWizardItemBlueprint$publish_releaseFactory.create(wizardModule, provider));
        this.f = provider2;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(WizardModule_ProvideVHFactory$publish_releaseFactory.create(wizardModule, provider2));
        this.g = provider3;
        this.h = DoubleCheck.provider(WizardModule_ProvideAdapterPresenter$publish_releaseFactory.create(wizardModule, provider3));
        this.i = new e(wizardDependencies);
        this.j = new c(wizardDependencies);
        f fVar = new f(wizardDependencies);
        this.k = fVar;
        this.l = DoubleCheck.provider(WizardModule_ProvidesScreenDiInjectTracker$publish_releaseFactory.create(wizardModule, fVar, TimerFactory_Factory.create()));
        this.m = DoubleCheck.provider(WizardModule_ProvidesScreenInitTrackerFactory.create(wizardModule, this.k, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider4 = DoubleCheck.provider(WizardModule_ProvidesScreenFlowTrackerProviderFactory.create(wizardModule, this.k, TimerFactory_Factory.create()));
        this.n = provider4;
        CategoriesWizardTrackerImpl_Factory create = CategoriesWizardTrackerImpl_Factory.create(this.l, this.m, provider4);
        this.o = create;
        this.p = DoubleCheck.provider(create);
        Provider<Set<ItemPresenter<?, ?>>> provider5 = DoubleCheck.provider(WizardModule_ProvideItemPresentersSetFactory.create(wizardModule, this.e));
        this.q = provider5;
        this.r = DoubleCheck.provider(WizardModule_ProvideWizardPresenter$publish_releaseFactory.create(wizardModule, this.d, this.h, this.i, this.j, this.p, provider5));
    }

    public static WizardComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.wizard.di.WizardComponent
    public void inject(WizardFragment wizardFragment) {
        WizardFragment_MembersInjector.injectAnalytics(wizardFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        WizardFragment_MembersInjector.injectInteractor(wizardFragment, this.d.get());
        WizardFragment_MembersInjector.injectPresenter(wizardFragment, this.r.get());
        WizardFragment_MembersInjector.injectAdapterPresenter(wizardFragment, this.h.get());
        WizardFragment_MembersInjector.injectItemBinder(wizardFragment, this.g.get());
        WizardFragment_MembersInjector.injectIntentFactory(wizardFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        WizardFragment_MembersInjector.injectTracker(wizardFragment, this.p.get());
    }
}
