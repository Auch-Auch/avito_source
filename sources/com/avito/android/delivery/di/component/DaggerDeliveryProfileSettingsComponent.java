package com.avito.android.delivery.di.component;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.delivery.di.component.DeliveryProfileSettingsComponent;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsTrackerModule_ProvideScreenDiInjectTracker$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsTrackerModule_ProvideScreenFlowTrackerProviderFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsTrackerModule_ProvideScreenInitTrackerFactory;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity_MembersInjector;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsRepository;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverter;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerDeliveryProfileSettingsComponent implements DeliveryProfileSettingsComponent {
    public final DeliveryDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<DeliveryProfileSettingsResponseConverter> c;
    public Provider<ProfileApi> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<DeliveryProfileSettingsRepository> f;
    public Provider<ScreenTrackerFactory> g;
    public Provider<String> h = DoubleCheck.provider(DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory.create());
    public Provider<ScreenDiInjectTracker> i = DoubleCheck.provider(DeliveryProfileSettingsTrackerModule_ProvideScreenDiInjectTracker$delivery_releaseFactory.create(this.g, TimerFactory_Factory.create(), this.h));
    public Provider<ScreenInitTracker> j = DoubleCheck.provider(DeliveryProfileSettingsTrackerModule_ProvideScreenInitTrackerFactory.create(this.g, TimerFactory_Factory.create(), this.h));
    public Provider<ScreenFlowTrackerProvider> k;
    public Provider<BaseScreenPerformanceTrackerImpl> l;
    public Provider<BaseScreenPerformanceTracker> m;
    public Provider<DeliveryProfileSettingsViewModelFactory> n;
    public Provider<DeliveryProfileSettingsViewModel> o;
    public Provider<AttributedTextFormatter> p;

    public static final class b implements DeliveryProfileSettingsComponent.Builder {
        public DeliveryDependencies a;
        public DeliveryProfileSettingsModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.DeliveryProfileSettingsComponent.Builder
        public DeliveryProfileSettingsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DeliveryDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, DeliveryProfileSettingsModule.class);
            return new DaggerDeliveryProfileSettingsComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.delivery.di.component.DeliveryProfileSettingsComponent.Builder
        public DeliveryProfileSettingsComponent.Builder deliveryDependencies(DeliveryDependencies deliveryDependencies) {
            this.a = (DeliveryDependencies) Preconditions.checkNotNull(deliveryDependencies);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.DeliveryProfileSettingsComponent.Builder
        public DeliveryProfileSettingsComponent.Builder deliveryProfileSettingsModule(DeliveryProfileSettingsModule deliveryProfileSettingsModule) {
            this.b = (DeliveryProfileSettingsModule) Preconditions.checkNotNull(deliveryProfileSettingsModule);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final DeliveryDependencies a;

        public c(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final DeliveryDependencies a;

        public d(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<ScreenTrackerFactory> {
        public final DeliveryDependencies a;

        public e(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryDependencies a;

        public f(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryProfileSettingsComponent(DeliveryProfileSettingsModule deliveryProfileSettingsModule, DeliveryDependencies deliveryDependencies, a aVar) {
        this.a = deliveryDependencies;
        this.b = new d(deliveryDependencies);
        this.c = DoubleCheck.provider(DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory.create(deliveryProfileSettingsModule));
        c cVar = new c(deliveryDependencies);
        this.d = cVar;
        f fVar = new f(deliveryDependencies);
        this.e = fVar;
        this.f = DoubleCheck.provider(DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory.create(deliveryProfileSettingsModule, cVar, this.b, fVar));
        this.g = new e(deliveryDependencies);
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(DeliveryProfileSettingsTrackerModule_ProvideScreenFlowTrackerProviderFactory.create(this.g, TimerFactory_Factory.create()));
        this.k = provider;
        BaseScreenPerformanceTrackerImpl_Factory create = BaseScreenPerformanceTrackerImpl_Factory.create(this.i, this.j, provider, this.h);
        this.l = create;
        Provider<BaseScreenPerformanceTracker> provider2 = DoubleCheck.provider(create);
        this.m = provider2;
        Provider<DeliveryProfileSettingsViewModelFactory> provider3 = DoubleCheck.provider(DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory.create(deliveryProfileSettingsModule, this.b, this.c, this.f, provider2));
        this.n = provider3;
        this.o = DoubleCheck.provider(DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory.create(deliveryProfileSettingsModule, provider3));
        this.p = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    }

    public static DeliveryProfileSettingsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.DeliveryProfileSettingsComponent
    public void inject(DeliveryProfileSettingsActivity deliveryProfileSettingsActivity) {
        DeliveryProfileSettingsActivity_MembersInjector.injectViewModel(deliveryProfileSettingsActivity, this.o.get());
        DeliveryProfileSettingsActivity_MembersInjector.injectAnalytics(deliveryProfileSettingsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryProfileSettingsActivity_MembersInjector.injectDeepLinkIntentFactory(deliveryProfileSettingsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DeliveryProfileSettingsActivity_MembersInjector.injectAttributedTextFormatter(deliveryProfileSettingsActivity, this.p.get());
        DeliveryProfileSettingsActivity_MembersInjector.injectTracker(deliveryProfileSettingsActivity, this.m.get());
    }
}
