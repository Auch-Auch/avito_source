package com.avito.android.notification_center.landing.recommends.review_list.di;

import android.app.Activity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment_MembersInjector;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractor;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractorImpl;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListInteractorImpl_Factory;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemBlueprint;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemPresenter;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitleBlueprint;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitleBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitlePresenter;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitlePresenterImpl_Factory;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerNcRecommendsReviewListComponent implements NcRecommendsReviewListComponent {
    public final NcRecommendsReviewListDependencies a;
    public Provider<Relay<Integer>> b;
    public Provider<NcRecommendsReviewListItemPresenterImpl> c;
    public Provider<NcRecommendsReviewListItemPresenter> d;
    public Provider<NcRecommendsReviewListItemBlueprint> e;
    public Provider<NcRecommendsReviewListTitlePresenter> f;
    public Provider<NcRecommendsReviewListTitleBlueprint> g;
    public Provider<ItemBinder> h;
    public Provider<AdapterPresenter> i;
    public Provider<Activity> j;
    public Provider<DialogRouter> k;
    public Provider<String> l;
    public Provider<Integer> m;
    public Provider<NotificationsApi> n;
    public Provider<SchedulersFactory> o;
    public Provider<NcRecommendsReviewListInteractorImpl> p;
    public Provider<NcRecommendsReviewListInteractor> q;
    public Provider<Kundle> r;
    public Provider<NcRecommendsReviewListPresenterImpl> s;
    public Provider<NcRecommendsReviewListPresenter> t;

    public static final class b implements NcRecommendsReviewListComponent.Builder {
        public NcRecommendsReviewListDependencies a;
        public String b;
        public Integer c;
        public Kundle d;
        public Activity e;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NcRecommendsReviewListDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Integer.class);
            Preconditions.checkBuilderRequirement(this.e, Activity.class);
            return new DaggerNcRecommendsReviewListComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent.Builder dependencies(NcRecommendsReviewListDependencies ncRecommendsReviewListDependencies) {
            this.a = (NcRecommendsReviewListDependencies) Preconditions.checkNotNull(ncRecommendsReviewListDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent.Builder withActivity(Activity activity) {
            this.e = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent.Builder
        public NcRecommendsReviewListComponent.Builder withReaction(int i) {
            this.c = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }
    }

    public static class c implements Provider<NotificationsApi> {
        public final NcRecommendsReviewListDependencies a;

        public c(NcRecommendsReviewListDependencies ncRecommendsReviewListDependencies) {
            this.a = ncRecommendsReviewListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final NcRecommendsReviewListDependencies a;

        public d(NcRecommendsReviewListDependencies ncRecommendsReviewListDependencies) {
            this.a = ncRecommendsReviewListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNcRecommendsReviewListComponent(NcRecommendsReviewListDependencies ncRecommendsReviewListDependencies, String str, Integer num, Kundle kundle, Activity activity, a aVar) {
        this.a = ncRecommendsReviewListDependencies;
        Provider<Relay<Integer>> provider = DoubleCheck.provider(NcRecommendsReviewListModule_ProvideItemRelayFactory.create());
        this.b = provider;
        NcRecommendsReviewListItemPresenterImpl_Factory create = NcRecommendsReviewListItemPresenterImpl_Factory.create(provider);
        this.c = create;
        Provider<NcRecommendsReviewListItemPresenter> provider2 = DoubleCheck.provider(create);
        this.d = provider2;
        this.e = NcRecommendsReviewListItemBlueprint_Factory.create(provider2);
        Provider<NcRecommendsReviewListTitlePresenter> provider3 = DoubleCheck.provider(NcRecommendsReviewListTitlePresenterImpl_Factory.create());
        this.f = provider3;
        NcRecommendsReviewListTitleBlueprint_Factory create2 = NcRecommendsReviewListTitleBlueprint_Factory.create(provider3);
        this.g = create2;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(NcRecommendsReviewListModule_ProvideItemBinderFactory.create(this.e, create2));
        this.h = provider4;
        this.i = DoubleCheck.provider(NcRecommendsReviewListModule_ProvideAdapterPresenterFactory.create(provider4));
        Factory create3 = InstanceFactory.create(activity);
        this.j = create3;
        this.k = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create3));
        this.l = InstanceFactory.create(str);
        Factory create4 = InstanceFactory.create(num);
        this.m = create4;
        c cVar = new c(ncRecommendsReviewListDependencies);
        this.n = cVar;
        d dVar = new d(ncRecommendsReviewListDependencies);
        this.o = dVar;
        NcRecommendsReviewListInteractorImpl_Factory create5 = NcRecommendsReviewListInteractorImpl_Factory.create(this.l, create4, cVar, dVar);
        this.p = create5;
        this.q = DoubleCheck.provider(create5);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.r = createNullable;
        NcRecommendsReviewListPresenterImpl_Factory create6 = NcRecommendsReviewListPresenterImpl_Factory.create(this.q, this.o, this.i, this.b, createNullable);
        this.s = create6;
        this.t = DoubleCheck.provider(create6);
    }

    public static NcRecommendsReviewListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.di.NcRecommendsReviewListComponent
    public void inject(NcRecommendsReviewListFragment ncRecommendsReviewListFragment) {
        NcRecommendsReviewListFragment_MembersInjector.injectAdapterPresenter(ncRecommendsReviewListFragment, this.i.get());
        NcRecommendsReviewListFragment_MembersInjector.injectDialogRouter(ncRecommendsReviewListFragment, this.k.get());
        NcRecommendsReviewListFragment_MembersInjector.injectItemBinder(ncRecommendsReviewListFragment, this.h.get());
        NcRecommendsReviewListFragment_MembersInjector.injectPresenter(ncRecommendsReviewListFragment, this.t.get());
        NcRecommendsReviewListFragment_MembersInjector.injectAnalytics(ncRecommendsReviewListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
