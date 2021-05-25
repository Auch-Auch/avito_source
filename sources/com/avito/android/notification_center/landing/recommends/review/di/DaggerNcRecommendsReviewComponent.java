package com.avito.android.notification_center.landing.recommends.review.di;

import android.app.Activity;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragment;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragment_MembersInjector;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractor;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractorImpl;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractorImpl_Factory;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerNcRecommendsReviewComponent implements NcRecommendsReviewComponent {
    public Provider<Activity> a;
    public Provider<DialogRouter> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<NotificationsApi> e;
    public Provider<SchedulersFactory> f;
    public Provider<NcRecommendsReviewInteractorImpl> g;
    public Provider<NcRecommendsReviewInteractor> h;
    public Provider<Kundle> i;
    public Provider<NcRecommendsReviewPresenterImpl> j;
    public Provider<NcRecommendsReviewPresenter> k;

    public static final class b implements NcRecommendsReviewComponent.Builder {
        public NcRecommendsReviewDependencies a;
        public String b;
        public String c;
        public Kundle d;
        public Activity e;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NcRecommendsReviewDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.e, Activity.class);
            return new DaggerNcRecommendsReviewComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent.Builder dependencies(NcRecommendsReviewDependencies ncRecommendsReviewDependencies) {
            this.a = (NcRecommendsReviewDependencies) Preconditions.checkNotNull(ncRecommendsReviewDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent.Builder withActivity(Activity activity) {
            this.e = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent.Builder withHint(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent.Builder
        public NcRecommendsReviewComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }
    }

    public static class c implements Provider<NotificationsApi> {
        public final NcRecommendsReviewDependencies a;

        public c(NcRecommendsReviewDependencies ncRecommendsReviewDependencies) {
            this.a = ncRecommendsReviewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final NcRecommendsReviewDependencies a;

        public d(NcRecommendsReviewDependencies ncRecommendsReviewDependencies) {
            this.a = ncRecommendsReviewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNcRecommendsReviewComponent(NcRecommendsReviewDependencies ncRecommendsReviewDependencies, String str, String str2, Kundle kundle, Activity activity, a aVar) {
        Factory create = InstanceFactory.create(activity);
        this.a = create;
        this.b = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
        this.c = InstanceFactory.create(str2);
        Factory create2 = InstanceFactory.create(str);
        this.d = create2;
        c cVar = new c(ncRecommendsReviewDependencies);
        this.e = cVar;
        d dVar = new d(ncRecommendsReviewDependencies);
        this.f = dVar;
        NcRecommendsReviewInteractorImpl_Factory create3 = NcRecommendsReviewInteractorImpl_Factory.create(create2, cVar, dVar);
        this.g = create3;
        this.h = DoubleCheck.provider(create3);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.i = createNullable;
        NcRecommendsReviewPresenterImpl_Factory create4 = NcRecommendsReviewPresenterImpl_Factory.create(this.c, this.h, this.f, createNullable);
        this.j = create4;
        this.k = DoubleCheck.provider(create4);
    }

    public static NcRecommendsReviewComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.di.NcRecommendsReviewComponent
    public void inject(NcRecommendsReviewFragment ncRecommendsReviewFragment) {
        NcRecommendsReviewFragment_MembersInjector.injectDialogRouter(ncRecommendsReviewFragment, this.b.get());
        NcRecommendsReviewFragment_MembersInjector.injectPresenter(ncRecommendsReviewFragment, this.k.get());
    }
}
