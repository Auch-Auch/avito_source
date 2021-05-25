package com.avito.android.rating.check.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker_Impl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.rating.check.RatingPublishCheckActivity;
import com.avito.android.rating.check.RatingPublishCheckActivity_MembersInjector;
import com.avito.android.rating.check.RatingPublishCheckInteractor;
import com.avito.android.rating.check.RatingPublishCheckInteractorImpl;
import com.avito.android.rating.check.RatingPublishCheckInteractorImpl_Factory;
import com.avito.android.rating.check.RatingPublishCheckPresenter;
import com.avito.android.rating.check.RatingPublishCheckPresenterImpl;
import com.avito.android.rating.check.RatingPublishCheckPresenterImpl_Factory;
import com.avito.android.rating.check.di.RatingPublishCheckComponent;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerRatingPublishCheckComponent implements RatingPublishCheckComponent {
    public final RatingPublishCheckDependencies a;
    public Provider<String> b;
    public Provider<AccountStateProvider> c;
    public Provider<RatingApi> d;
    public Provider<SchedulersFactory3> e;
    public Provider<RatingPublishCheckInteractorImpl> f;
    public Provider<RatingPublishCheckInteractor> g;
    public Provider<Activity> h;
    public Provider<DialogRouter> i;
    public Provider<DialogPresenterImpl> j;
    public Provider<DialogPresenter> k;
    public Provider<Resources> l;
    public Provider<ErrorFormatterImpl> m;
    public Provider<ErrorFormatter> n;
    public Provider<ErrorHelperImpl> o;
    public Provider<ErrorHelper> p;
    public Provider<UnknownScreenTracker.Impl> q;
    public Provider<UnknownScreenTracker> r;
    public Provider<Kundle> s;
    public Provider<RatingPublishCheckPresenterImpl> t;
    public Provider<RatingPublishCheckPresenter> u;

    public static final class b implements RatingPublishCheckComponent.Builder {
        public RatingPublishCheckDependencies a;
        public Resources b;
        public Activity c;
        public String d;
        public Kundle e;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent build() {
            Preconditions.checkBuilderRequirement(this.a, RatingPublishCheckDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            return new DaggerRatingPublishCheckComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent.Builder dependentOn(RatingPublishCheckDependencies ratingPublishCheckDependencies) {
            this.a = (RatingPublishCheckDependencies) Preconditions.checkNotNull(ratingPublishCheckDependencies);
            return this;
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent.Builder with(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent.Builder withPresenterState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent.Builder withUserKey(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent.Builder
        public RatingPublishCheckComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final RatingPublishCheckDependencies a;

        public c(RatingPublishCheckDependencies ratingPublishCheckDependencies) {
            this.a = ratingPublishCheckDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<RatingApi> {
        public final RatingPublishCheckDependencies a;

        public d(RatingPublishCheckDependencies ratingPublishCheckDependencies) {
            this.a = ratingPublishCheckDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RatingApi get() {
            return (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final RatingPublishCheckDependencies a;

        public e(RatingPublishCheckDependencies ratingPublishCheckDependencies) {
            this.a = ratingPublishCheckDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerRatingPublishCheckComponent(RatingPublishCheckDependencies ratingPublishCheckDependencies, Resources resources, Activity activity, String str, Kundle kundle, a aVar) {
        this.a = ratingPublishCheckDependencies;
        Factory create = InstanceFactory.create(str);
        this.b = create;
        c cVar = new c(ratingPublishCheckDependencies);
        this.c = cVar;
        d dVar = new d(ratingPublishCheckDependencies);
        this.d = dVar;
        e eVar = new e(ratingPublishCheckDependencies);
        this.e = eVar;
        RatingPublishCheckInteractorImpl_Factory create2 = RatingPublishCheckInteractorImpl_Factory.create(create, cVar, dVar, eVar);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(activity);
        this.h = create3;
        Provider<DialogRouter> provider = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create3));
        this.i = provider;
        DialogPresenterImpl_Factory create4 = DialogPresenterImpl_Factory.create(this.h, provider);
        this.j = create4;
        this.k = SingleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(resources);
        this.l = create5;
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(create5);
        this.m = create6;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create6);
        this.n = provider2;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider2);
        this.o = create7;
        this.p = SingleCheck.provider(create7);
        UnknownScreenTracker_Impl_Factory create8 = UnknownScreenTracker_Impl_Factory.create(TimerFactory_Factory.create());
        this.q = create8;
        this.r = DoubleCheck.provider(create8);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.s = createNullable;
        RatingPublishCheckPresenterImpl_Factory create9 = RatingPublishCheckPresenterImpl_Factory.create(this.g, this.e, this.k, this.p, this.r, createNullable);
        this.t = create9;
        this.u = DoubleCheck.provider(create9);
    }

    public static RatingPublishCheckComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.check.di.RatingPublishCheckComponent
    public void inject(RatingPublishCheckActivity ratingPublishCheckActivity) {
        RatingPublishCheckActivity_MembersInjector.injectIntentFactory(ratingPublishCheckActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        RatingPublishCheckActivity_MembersInjector.injectDeepLinkIntentFactory(ratingPublishCheckActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        RatingPublishCheckActivity_MembersInjector.injectPresenter(ratingPublishCheckActivity, this.u.get());
        RatingPublishCheckActivity_MembersInjector.injectTracker(ratingPublishCheckActivity, this.r.get());
    }
}
