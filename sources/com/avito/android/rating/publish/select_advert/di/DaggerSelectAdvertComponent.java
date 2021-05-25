package com.avito.android.rating.publish.select_advert.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.SelectAdvertFragment;
import com.avito.android.rating.publish.select_advert.SelectAdvertFragment_MembersInjector;
import com.avito.android.rating.publish.select_advert.SelectAdvertInteractorImpl;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItemBlueprint;
import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItemBlueprint_Factory;
import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItemPresenterImpl;
import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItemPresenterImpl_Factory;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.ErrorSnippetItemBlueprint;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.ErrorSnippetItemBlueprint_Factory;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.ErrorSnippetItemPresenterImpl;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.ErrorSnippetItemPresenterImpl_Factory;
import com.avito.android.rating.publish.select_advert.adapter.loading.LoadingItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.publish.select_advert.adapter.loading.LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory;
import com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTracker;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTrackerImpl;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTrackerImpl_Factory;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSelectAdvertComponent implements SelectAdvertComponent {
    public Provider<ScreenTrackerFactory> A;
    public Provider<Screen> B;
    public Provider<Boolean> C;
    public Provider<TimerFactory> D;
    public Provider<ScreenDiInjectTracker> E;
    public Provider<ScreenInitTracker> F;
    public Provider<ScreenFlowTrackerProvider> G;
    public Provider<SelectAdvertTrackerImpl> H;
    public Provider<SelectAdvertTracker> I;
    public final SelectAdvertDependencies a;
    public final StepListener b;
    public final String c;
    public final PublishRelay<SelectAdvertAction> d;
    public final RatingPublishData e;
    public final RatingPublishViewData f;
    public final Kundle g;
    public Provider<Set<ItemBlueprint<?, ?>>> h = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<LoadingItemNextPageAction>> i;
    public Provider<LoadingItemPresenterImpl> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<PublishRelay<SelectAdvertAction>> l;
    public Provider<AdvertItemPresenterImpl> m;
    public Provider<AdvertItemBlueprint> n;
    public Provider<ErrorSnippetItemPresenterImpl> o;
    public Provider<ErrorSnippetItemBlueprint> p;
    public Provider<Set<ItemBlueprint<?, ?>>> q;
    public Provider<ItemBinder> r;
    public Provider<AdapterPresenter> s;
    public Provider<CallableResponsiveItemPresenterRegistry> t;
    public Provider<ResponsiveAdapterPresenter> u;
    public Provider<Resources> v;
    public Provider<ErrorFormatterImpl> w;
    public Provider<ErrorFormatter> x;
    public Provider<ErrorHelperImpl> y;
    public Provider<ErrorHelper> z;

    public static final class b implements SelectAdvertComponent.Builder {
        public SelectAdvertDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public PublishRelay<SelectAdvertAction> e;
        public String f;
        public Screen g;
        public Boolean h;
        public StepListener i;
        public RatingPublishData j;
        public RatingPublishViewData k;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectAdvertDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, Screen.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.i, StepListener.class);
            Preconditions.checkBuilderRequirement(this.j, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.k, RatingPublishViewData.class);
            return new DaggerSelectAdvertComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, null);
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder dependentOn(SelectAdvertDependencies selectAdvertDependencies) {
            this.a = (SelectAdvertDependencies) Preconditions.checkNotNull(selectAdvertDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder withScreen(Screen screen) {
            this.g = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder withSubComponent(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(PublishRelay publishRelay) {
            this.e = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(StepListener stepListener) {
            this.i = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(RatingPublishData ratingPublishData) {
            this.j = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent.Builder
        public SelectAdvertComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.k = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }
    }

    public static class c implements Provider<ScreenTrackerFactory> {
        public final SelectAdvertDependencies a;

        public c(SelectAdvertDependencies selectAdvertDependencies) {
            this.a = selectAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class d implements Provider<TimerFactory> {
        public final SelectAdvertDependencies a;

        public d(SelectAdvertDependencies selectAdvertDependencies) {
            this.a = selectAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerSelectAdvertComponent(SelectAdvertDependencies selectAdvertDependencies, Kundle kundle, Activity activity, Resources resources, PublishRelay publishRelay, String str, Screen screen, Boolean bool, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, a aVar) {
        this.a = selectAdvertDependencies;
        this.b = stepListener;
        this.c = str;
        this.d = publishRelay;
        this.e = ratingPublishData;
        this.f = ratingPublishViewData;
        this.g = kundle;
        Provider<PublishRelay<LoadingItemNextPageAction>> provider = DoubleCheck.provider(LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory.create());
        this.i = provider;
        LoadingItemPresenterImpl_Factory create = LoadingItemPresenterImpl_Factory.create(provider);
        this.j = create;
        this.k = DoubleCheck.provider(LoadingItemModule_ProvideBlueprint$rating_releaseFactory.create(create));
        Factory create2 = InstanceFactory.create(publishRelay);
        this.l = create2;
        AdvertItemPresenterImpl_Factory create3 = AdvertItemPresenterImpl_Factory.create(create2);
        this.m = create3;
        this.n = AdvertItemBlueprint_Factory.create(create3);
        ErrorSnippetItemPresenterImpl_Factory create4 = ErrorSnippetItemPresenterImpl_Factory.create(this.l);
        this.o = create4;
        this.p = ErrorSnippetItemBlueprint_Factory.create(create4);
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.h).addProvider(this.k).addProvider(this.n).addProvider(this.p).build();
        this.q = build;
        Provider<ItemBinder> provider2 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.r = provider2;
        this.s = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider2));
        Provider<CallableResponsiveItemPresenterRegistry> provider3 = DoubleCheck.provider(SelectAdvertModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory.create());
        this.t = provider3;
        this.u = DoubleCheck.provider(SelectAdvertModule_ProvideAdapterPresenter$rating_releaseFactory.create(this.s, provider3));
        Factory create5 = InstanceFactory.create(resources);
        this.v = create5;
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(create5);
        this.w = create6;
        Provider<ErrorFormatter> provider4 = SingleCheck.provider(create6);
        this.x = provider4;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider4);
        this.y = create7;
        this.z = SingleCheck.provider(create7);
        this.A = new c(selectAdvertDependencies);
        this.B = InstanceFactory.create(screen);
        Factory create8 = InstanceFactory.create(bool);
        this.C = create8;
        d dVar = new d(selectAdvertDependencies);
        this.D = dVar;
        this.E = DoubleCheck.provider(SelectAdvertAnalyticsModule_ProvidesScreenDiInjectTracker$rating_releaseFactory.create(this.A, this.B, create8, dVar));
        this.F = DoubleCheck.provider(SelectAdvertAnalyticsModule_ProvidesScreenInitTrackerFactory.create(this.A, this.B, this.C, this.D));
        Provider<ScreenFlowTrackerProvider> provider5 = DoubleCheck.provider(SelectAdvertAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory.create(this.A, this.B, this.D));
        this.G = provider5;
        SelectAdvertTrackerImpl_Factory create9 = SelectAdvertTrackerImpl_Factory.create(this.E, this.F, provider5);
        this.H = create9;
        this.I = DoubleCheck.provider(create9);
    }

    public static SelectAdvertComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent
    public void inject(SelectAdvertFragment selectAdvertFragment) {
        SelectAdvertFragment_MembersInjector.injectIntentFactory(selectAdvertFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SelectAdvertFragment_MembersInjector.injectDeepLinkIntentFactory(selectAdvertFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        SelectAdvertFragment_MembersInjector.injectAdapterPresenter(selectAdvertFragment, this.u.get());
        SelectAdvertFragment_MembersInjector.injectItemBinder(selectAdvertFragment, this.r.get());
        SelectAdvertFragment_MembersInjector.injectPresenter(selectAdvertFragment, new SelectAdvertPresenterImpl(this.b, new SelectAdvertInteractorImpl(this.c, (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())), this.s.get(), this.d, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.z.get(), this.e, this.f, this.I.get(), this.i.get(), this.g));
        SelectAdvertFragment_MembersInjector.injectStepListener(selectAdvertFragment, this.b);
        SelectAdvertFragment_MembersInjector.injectTracker(selectAdvertFragment, this.I.get());
        SelectAdvertFragment_MembersInjector.injectRatingData(selectAdvertFragment, this.e);
    }
}
