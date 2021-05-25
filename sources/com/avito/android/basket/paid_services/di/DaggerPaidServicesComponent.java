package com.avito.android.basket.paid_services.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.basket.paid_services.PaidServiceDeeplinkHandlerImpl;
import com.avito.android.basket.paid_services.PaidServiceDeeplinkHandlerImpl_Factory;
import com.avito.android.basket.paid_services.PaidServicesActivity;
import com.avito.android.basket.paid_services.PaidServicesActivity_MembersInjector;
import com.avito.android.basket.paid_services.di.PaidServicesComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.CheckoutApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.StringProviderImpl;
import com.avito.android.tariff.StringProviderImpl_Factory;
import com.avito.android.tariff.routing.PaidServiceDeeplinkHandler;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.vas.remote.VasApi;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerPaidServicesComponent implements PaidServicesComponent {
    public final PaidServicesDependencies a;
    public final Screen b;
    public Provider<Resources> c;
    public Provider<StringProviderImpl> d;
    public Provider<StringProvider> e;
    public Provider<AttributedTextFormatter> f = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<DeepLinkIntentFactory> g;
    public Provider<PaidServiceDeeplinkHandlerImpl> h;
    public Provider<PaidServiceDeeplinkHandler> i;

    public static final class b implements PaidServicesComponent.Builder {
        public PaidServicesDependencies a;
        public Resources b;
        public Screen c;

        public b(a aVar) {
        }

        @Override // com.avito.android.basket.paid_services.di.PaidServicesComponent.Builder
        public PaidServicesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaidServicesDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Screen.class);
            return new DaggerPaidServicesComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.basket.paid_services.di.PaidServicesComponent.Builder
        public PaidServicesComponent.Builder dependencies(PaidServicesDependencies paidServicesDependencies) {
            this.a = (PaidServicesDependencies) Preconditions.checkNotNull(paidServicesDependencies);
            return this;
        }

        @Override // com.avito.android.basket.paid_services.di.PaidServicesComponent.Builder
        public PaidServicesComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.basket.paid_services.di.PaidServicesComponent.Builder
        public PaidServicesComponent.Builder screen(Screen screen) {
            this.c = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }
    }

    public static class c implements Provider<DeepLinkIntentFactory> {
        public final PaidServicesDependencies a;

        public c(PaidServicesDependencies paidServicesDependencies) {
            this.a = paidServicesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public DaggerPaidServicesComponent(PaidServicesDependencies paidServicesDependencies, Resources resources, Screen screen, a aVar) {
        this.a = paidServicesDependencies;
        this.b = screen;
        Factory create = InstanceFactory.create(resources);
        this.c = create;
        StringProviderImpl_Factory create2 = StringProviderImpl_Factory.create(create);
        this.d = create2;
        this.e = DoubleCheck.provider(create2);
        c cVar = new c(paidServicesDependencies);
        this.g = cVar;
        PaidServiceDeeplinkHandlerImpl_Factory create3 = PaidServiceDeeplinkHandlerImpl_Factory.create(cVar);
        this.h = create3;
        this.i = DoubleCheck.provider(create3);
    }

    public static PaidServicesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.VasDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies
    public AttributedTextFormatter attributedTextFormatter() {
        return this.f.get();
    }

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies
    public CheckoutApi checkoutApi() {
        return (CheckoutApi) Preconditions.checkNotNullFromComponent(this.a.checkoutApi());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public DeepLinkIntentFactory deeplinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.basket.paid_services.di.PaidServicesComponent
    public void inject(PaidServicesActivity paidServicesActivity) {
        PaidServicesActivity_MembersInjector.injectDeeplinkHandler(paidServicesActivity, this.i.get());
    }

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies
    public Locale locale() {
        return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies
    public PublishLimitsApi publishLimitsApi() {
        return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.publishLimitsApi());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies
    public SchedulersFactory3 schedulersFactory3() {
        return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
    }

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public Screen screen() {
        return this.b;
    }

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public ScreenTrackerFactory screenTrackerFactory() {
        return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies, com.avito.android.basket.checkout.di.CheckoutDependencies
    public StringProvider stringProvider() {
        return this.e.get();
    }

    @Override // com.avito.android.tariff.di.TariffStepDependencies
    public TariffApi tariffApi() {
        return (TariffApi) Preconditions.checkNotNullFromComponent(this.a.tariffApi());
    }

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    public VasApi vasApi() {
        return (VasApi) Preconditions.checkNotNullFromComponent(this.a.vasApi());
    }
}
