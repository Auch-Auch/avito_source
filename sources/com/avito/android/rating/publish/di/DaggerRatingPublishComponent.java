package com.avito.android.rating.publish.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.ScreenTransferRecovery_Impl_Factory;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.rating.publish.RatingPublishActivity;
import com.avito.android.rating.publish.RatingPublishActivity_MembersInjector;
import com.avito.android.rating.publish.RatingPublishInteractorImpl;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import com.avito.android.rating.publish.di.RatingPublishComponent;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import com.avito.android.rating.publish.tracker.RatingPublishTrackerImpl;
import com.avito.android.rating.publish.tracker.RatingPublishTrackerImpl_Factory;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerRatingPublishComponent implements RatingPublishComponent {
    public final RatingPublishDependencies a;
    public final RatingPublishPresenter.StepHolder b;
    public final Kundle c;
    public Provider<Activity> d;
    public Provider<BuildInfo> e;
    public Provider<PhotoInteractor> f;
    public Provider<ScreenTrackerFactory> g;
    public Provider<TimerFactory> h;
    public Provider<ScreenDiInjectTracker> i;
    public Provider<ScreenInitTracker> j = DoubleCheck.provider(RatingPublishModule_ProvideScreenInitTrackerFactory.create(this.g, this.h));
    public Provider<ScreenFlowTrackerProvider> k = DoubleCheck.provider(RatingPublishModule_ProvideScreenFlowTrackerProviderFactory.create(this.g, this.h));
    public Provider<ScreenTransferRecovery.Impl> l;
    public Provider<ScreenTransferRecovery> m;
    public Provider<RatingPublishTrackerImpl> n;
    public Provider<RatingPublishTracker> o;
    public Provider<Resources> p;
    public Provider<ErrorFormatterImpl> q;
    public Provider<ErrorFormatter> r;
    public Provider<ErrorHelperImpl> s;
    public Provider<ErrorHelper> t;

    public static final class b implements RatingPublishComponent.Builder {
        public RatingPublishDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public RatingPublishPresenter.StepHolder e;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent build() {
            Preconditions.checkBuilderRequirement(this.a, RatingPublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, RatingPublishPresenter.StepHolder.class);
            return new DaggerRatingPublishComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent.Builder dependentOn(RatingPublishDependencies ratingPublishDependencies) {
            this.a = (RatingPublishDependencies) Preconditions.checkNotNull(ratingPublishDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.di.RatingPublishComponent.Builder
        public RatingPublishComponent.Builder with(RatingPublishPresenter.StepHolder stepHolder) {
            this.e = (RatingPublishPresenter.StepHolder) Preconditions.checkNotNull(stepHolder);
            return this;
        }
    }

    public static class c implements Provider<BuildInfo> {
        public final RatingPublishDependencies a;

        public c(RatingPublishDependencies ratingPublishDependencies) {
            this.a = ratingPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class d implements Provider<ScreenTrackerFactory> {
        public final RatingPublishDependencies a;

        public d(RatingPublishDependencies ratingPublishDependencies) {
            this.a = ratingPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class e implements Provider<TimerFactory> {
        public final RatingPublishDependencies a;

        public e(RatingPublishDependencies ratingPublishDependencies) {
            this.a = ratingPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerRatingPublishComponent(RatingPublishDependencies ratingPublishDependencies, Kundle kundle, Activity activity, Resources resources, RatingPublishPresenter.StepHolder stepHolder, a aVar) {
        this.a = ratingPublishDependencies;
        this.b = stepHolder;
        this.c = kundle;
        Factory create = InstanceFactory.create(activity);
        this.d = create;
        c cVar = new c(ratingPublishDependencies);
        this.e = cVar;
        this.f = DoubleCheck.provider(RatingPublishModule_ProvidePhotoInteractor$rating_releaseFactory.create(create, cVar));
        d dVar = new d(ratingPublishDependencies);
        this.g = dVar;
        e eVar = new e(ratingPublishDependencies);
        this.h = eVar;
        this.i = DoubleCheck.provider(RatingPublishModule_ProvideScreenDiInjectTracker$rating_releaseFactory.create(dVar, eVar));
        ScreenTransferRecovery_Impl_Factory create2 = ScreenTransferRecovery_Impl_Factory.create(this.g, this.h);
        this.l = create2;
        Provider<ScreenTransferRecovery> provider = DoubleCheck.provider(create2);
        this.m = provider;
        RatingPublishTrackerImpl_Factory create3 = RatingPublishTrackerImpl_Factory.create(this.i, this.j, this.k, provider);
        this.n = create3;
        this.o = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.p = create4;
        ErrorFormatterImpl_Factory create5 = ErrorFormatterImpl_Factory.create(create4);
        this.q = create5;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create5);
        this.r = provider2;
        ErrorHelperImpl_Factory create6 = ErrorHelperImpl_Factory.create(provider2);
        this.s = create6;
        this.t = SingleCheck.provider(create6);
    }

    public static RatingPublishComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.di.RatingPublishComponent
    public void inject(RatingPublishActivity ratingPublishActivity) {
        RatingPublishActivity_MembersInjector.injectDeepLinkIntentFactory(ratingPublishActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        RatingPublishActivity_MembersInjector.injectPresenter(ratingPublishActivity, new RatingPublishPresenterImpl(new RatingPublishInteractorImpl((RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi()), this.f.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (Features) Preconditions.checkNotNullFromComponent(this.a.features())), this.o.get(), (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.t.get(), this.b, this.c));
        RatingPublishActivity_MembersInjector.injectTracker(ratingPublishActivity, this.o.get());
        RatingPublishActivity_MembersInjector.injectAnalytics(ratingPublishActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
