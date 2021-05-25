package com.avito.android.notification_center.list.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.date_time_formatter.RelativeDateFormatterImpl;
import com.avito.android.date_time_formatter.RelativeDateFormatterImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_center.counter.NotificationCenterCounterCleaner;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.list.NotificationCenterListActivity;
import com.avito.android.notification_center.list.NotificationCenterListActivity_MembersInjector;
import com.avito.android.notification_center.list.NotificationCenterListInteractor;
import com.avito.android.notification_center.list.NotificationCenterListInteractorImpl;
import com.avito.android.notification_center.list.NotificationCenterListInteractorImpl_Factory;
import com.avito.android.notification_center.list.NotificationCenterListPresenter;
import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl_Factory;
import com.avito.android.notification_center.list.di.NotificationCenterListComponent;
import com.avito.android.notification_center.list.item.ErrorSnippetItemBlueprint;
import com.avito.android.notification_center.list.item.ErrorSnippetItemBlueprint_Factory;
import com.avito.android.notification_center.list.item.ErrorSnippetItemPresenter;
import com.avito.android.notification_center.list.item.ErrorSnippetItemPresenterImpl;
import com.avito.android.notification_center.list.item.ErrorSnippetItemPresenterImpl_Factory;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.avito.android.notification_center.list.item.NotificationCenterListItemBlueprint;
import com.avito.android.notification_center.list.item.NotificationCenterListItemBlueprint_Factory;
import com.avito.android.notification_center.list.item.NotificationCenterListItemPresenter;
import com.avito.android.notification_center.list.item.NotificationCenterListItemPresenterImpl;
import com.avito.android.notification_center.list.item.NotificationCenterListItemPresenterImpl_Factory;
import com.avito.android.notification_center.push.NcPushClicksInteractor;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerNotificationCenterListComponent implements NotificationCenterListComponent {
    public Provider<ItemBinder> A;
    public final NotificationCenterListDependencies a;
    public Provider<TimeSource> b;
    public Provider<Resources> c;
    public Provider<Locale> d;
    public Provider<RelativeDateFormatterImpl> e;
    public Provider<RelativeDateFormatter> f;
    public Provider<AdapterPresenter> g = new DelegateFactory();
    public Provider<NotificationsApi> h;
    public Provider<SchedulersFactory> i;
    public Provider<NotificationCenterListInteractorImpl> j;
    public Provider<NotificationCenterListInteractor> k;
    public Provider<NotificationInteractor> l;
    public Provider<NotificationCenterCounterMarker> m;
    public Provider<NotificationCenterCounterCleaner> n;
    public Provider<NcPushClicksInteractor> o;
    public Provider<Analytics> p;
    public Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> q;
    public Provider<Kundle> r;
    public Provider<NotificationCenterListPresenterImpl> s;
    public Provider<NotificationCenterListPresenter> t;
    public Provider<NotificationCenterListItemPresenterImpl> u;
    public Provider<NotificationCenterListItemPresenter> v;
    public Provider<NotificationCenterListItemBlueprint> w;
    public Provider<ErrorSnippetItemPresenterImpl> x;
    public Provider<ErrorSnippetItemPresenter> y;
    public Provider<ErrorSnippetItemBlueprint> z;

    public static final class b implements NotificationCenterListComponent.Builder {
        public NotificationCenterListDependencies a;
        public Resources b;
        public Kundle c;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.list.di.NotificationCenterListComponent.Builder
        public NotificationCenterListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterListDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerNotificationCenterListComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.notification_center.list.di.NotificationCenterListComponent.Builder
        public NotificationCenterListComponent.Builder dependencies(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = (NotificationCenterListDependencies) Preconditions.checkNotNull(notificationCenterListDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.list.di.NotificationCenterListComponent.Builder
        public NotificationCenterListComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.notification_center.list.di.NotificationCenterListComponent.Builder
        public NotificationCenterListComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterListDependencies a;

        public c(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Locale> {
        public final NotificationCenterListDependencies a;

        public d(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class e implements Provider<NcPushClicksInteractor> {
        public final NotificationCenterListDependencies a;

        public e(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NcPushClicksInteractor get() {
            return (NcPushClicksInteractor) Preconditions.checkNotNullFromComponent(this.a.ncPushClicksInteractor());
        }
    }

    public static class f implements Provider<NotificationCenterCounterCleaner> {
        public final NotificationCenterListDependencies a;

        public f(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationCenterCounterCleaner get() {
            return (NotificationCenterCounterCleaner) Preconditions.checkNotNullFromComponent(this.a.notificationCenterCounterCleaner());
        }
    }

    public static class g implements Provider<NotificationCenterCounterMarker> {
        public final NotificationCenterListDependencies a;

        public g(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationCenterCounterMarker get() {
            return (NotificationCenterCounterMarker) Preconditions.checkNotNullFromComponent(this.a.notificationCenterCounterMarker());
        }
    }

    public static class h implements Provider<NotificationInteractor> {
        public final NotificationCenterListDependencies a;

        public h(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationInteractor get() {
            return (NotificationInteractor) Preconditions.checkNotNullFromComponent(this.a.notificationInteractor());
        }
    }

    public static class i implements Provider<NotificationsApi> {
        public final NotificationCenterListDependencies a;

        public i(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final NotificationCenterListDependencies a;

        public j(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class k implements Provider<TimeSource> {
        public final NotificationCenterListDependencies a;

        public k(NotificationCenterListDependencies notificationCenterListDependencies) {
            this.a = notificationCenterListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerNotificationCenterListComponent(NotificationCenterListDependencies notificationCenterListDependencies, Resources resources, Kundle kundle, a aVar) {
        this.a = notificationCenterListDependencies;
        this.b = new k(notificationCenterListDependencies);
        Factory create = InstanceFactory.create(resources);
        this.c = create;
        d dVar = new d(notificationCenterListDependencies);
        this.d = dVar;
        RelativeDateFormatterImpl_Factory create2 = RelativeDateFormatterImpl_Factory.create(this.b, create, dVar);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        i iVar = new i(notificationCenterListDependencies);
        this.h = iVar;
        j jVar = new j(notificationCenterListDependencies);
        this.i = jVar;
        NotificationCenterListInteractorImpl_Factory create3 = NotificationCenterListInteractorImpl_Factory.create(iVar, jVar);
        this.j = create3;
        this.k = DoubleCheck.provider(create3);
        this.l = new h(notificationCenterListDependencies);
        this.m = new g(notificationCenterListDependencies);
        this.n = new f(notificationCenterListDependencies);
        this.o = new e(notificationCenterListDependencies);
        this.p = new c(notificationCenterListDependencies);
        this.q = DoubleCheck.provider(NotificationCenterListModule_ProvideRefreshClicks$notification_center_releaseFactory.create());
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.r = createNullable;
        NotificationCenterListPresenterImpl_Factory create4 = NotificationCenterListPresenterImpl_Factory.create(this.g, this.k, this.i, this.l, this.m, this.n, this.o, this.p, this.q, createNullable);
        this.s = create4;
        Provider<NotificationCenterListPresenter> provider = DoubleCheck.provider(create4);
        this.t = provider;
        NotificationCenterListItemPresenterImpl_Factory create5 = NotificationCenterListItemPresenterImpl_Factory.create(this.f, provider);
        this.u = create5;
        Provider<NotificationCenterListItemPresenter> provider2 = DoubleCheck.provider(create5);
        this.v = provider2;
        this.w = NotificationCenterListItemBlueprint_Factory.create(provider2);
        ErrorSnippetItemPresenterImpl_Factory create6 = ErrorSnippetItemPresenterImpl_Factory.create(this.q);
        this.x = create6;
        Provider<ErrorSnippetItemPresenter> provider3 = DoubleCheck.provider(create6);
        this.y = provider3;
        ErrorSnippetItemBlueprint_Factory create7 = ErrorSnippetItemBlueprint_Factory.create(provider3);
        this.z = create7;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(NotificationCenterListModule_ProvideItemBinder$notification_center_releaseFactory.create(this.w, create7));
        this.A = provider4;
        DelegateFactory.setDelegate(this.g, DoubleCheck.provider(NotificationCenterListModule_ProvideAdapterPresenter$notification_center_releaseFactory.create(provider4)));
    }

    public static NotificationCenterListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.list.di.NotificationCenterListComponent
    public void inject(NotificationCenterListActivity notificationCenterListActivity) {
        NotificationCenterListActivity_MembersInjector.injectActivityIntentFactory(notificationCenterListActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        NotificationCenterListActivity_MembersInjector.injectAdapterPresenter(notificationCenterListActivity, this.g.get());
        NotificationCenterListActivity_MembersInjector.injectAppendingListener(notificationCenterListActivity, this.t.get());
        NotificationCenterListActivity_MembersInjector.injectAnalytics(notificationCenterListActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        NotificationCenterListActivity_MembersInjector.injectCallback(notificationCenterListActivity, this.t.get());
        NotificationCenterListActivity_MembersInjector.injectDeepLinkIntentFactory(notificationCenterListActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        NotificationCenterListActivity_MembersInjector.injectItemBinder(notificationCenterListActivity, this.A.get());
        NotificationCenterListActivity_MembersInjector.injectPresenter(notificationCenterListActivity, this.t.get());
    }
}
