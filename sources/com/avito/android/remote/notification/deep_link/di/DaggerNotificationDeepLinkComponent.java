package com.avito.android.remote.notification.deep_link.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.push.NcPushClicksListener;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity_MembersInjector;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkPresenter;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkPresenterImpl;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkPresenterImpl_Factory;
import com.avito.android.remote.notification.deep_link.NotificationDeepLinkRouter;
import com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerNotificationDeepLinkComponent implements NotificationDeepLinkComponent {
    public final NotificationDeepLinkDependencies a;
    public Provider<Analytics> b;
    public Provider<NcPushClicksListener> c;
    public Provider<NotificationCenterCounterMarker> d;
    public Provider<NotificationInteractor> e;
    public Provider<NotificationDeepLinkRouter> f;
    public Provider<NotificationDeepLinkPresenterImpl> g;
    public Provider<NotificationDeepLinkPresenter> h;

    public static final class b implements NotificationDeepLinkComponent.Builder {
        public NotificationDeepLinkDependencies a;
        public NotificationDeepLinkRouter b;

        public b(a aVar) {
        }

        @Override // com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkComponent.Builder
        public NotificationDeepLinkComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationDeepLinkDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, NotificationDeepLinkRouter.class);
            return new DaggerNotificationDeepLinkComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkComponent.Builder
        public NotificationDeepLinkComponent.Builder dependencies(NotificationDeepLinkDependencies notificationDeepLinkDependencies) {
            this.a = (NotificationDeepLinkDependencies) Preconditions.checkNotNull(notificationDeepLinkDependencies);
            return this;
        }

        @Override // com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkComponent.Builder
        public NotificationDeepLinkComponent.Builder withRouter(NotificationDeepLinkRouter notificationDeepLinkRouter) {
            this.b = (NotificationDeepLinkRouter) Preconditions.checkNotNull(notificationDeepLinkRouter);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationDeepLinkDependencies a;

        public c(NotificationDeepLinkDependencies notificationDeepLinkDependencies) {
            this.a = notificationDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<NcPushClicksListener> {
        public final NotificationDeepLinkDependencies a;

        public d(NotificationDeepLinkDependencies notificationDeepLinkDependencies) {
            this.a = notificationDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NcPushClicksListener get() {
            return (NcPushClicksListener) Preconditions.checkNotNullFromComponent(this.a.ncPushClicksListener());
        }
    }

    public static class e implements Provider<NotificationCenterCounterMarker> {
        public final NotificationDeepLinkDependencies a;

        public e(NotificationDeepLinkDependencies notificationDeepLinkDependencies) {
            this.a = notificationDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationCenterCounterMarker get() {
            return (NotificationCenterCounterMarker) Preconditions.checkNotNullFromComponent(this.a.notificationCenterCounterMarker());
        }
    }

    public static class f implements Provider<NotificationInteractor> {
        public final NotificationDeepLinkDependencies a;

        public f(NotificationDeepLinkDependencies notificationDeepLinkDependencies) {
            this.a = notificationDeepLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationInteractor get() {
            return (NotificationInteractor) Preconditions.checkNotNullFromComponent(this.a.notificationInteractor());
        }
    }

    public DaggerNotificationDeepLinkComponent(NotificationDeepLinkDependencies notificationDeepLinkDependencies, NotificationDeepLinkRouter notificationDeepLinkRouter, a aVar) {
        this.a = notificationDeepLinkDependencies;
        this.b = new c(notificationDeepLinkDependencies);
        this.c = new d(notificationDeepLinkDependencies);
        this.d = new e(notificationDeepLinkDependencies);
        this.e = new f(notificationDeepLinkDependencies);
        Factory create = InstanceFactory.create(notificationDeepLinkRouter);
        this.f = create;
        NotificationDeepLinkPresenterImpl_Factory create2 = NotificationDeepLinkPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, create);
        this.g = create2;
        this.h = DoubleCheck.provider(create2);
    }

    public static NotificationDeepLinkComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkComponent
    public void inject(NotificationDeepLinkActivity notificationDeepLinkActivity) {
        NotificationDeepLinkActivity_MembersInjector.injectActivityIntentFactory(notificationDeepLinkActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        NotificationDeepLinkActivity_MembersInjector.injectAnalytics(notificationDeepLinkActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        NotificationDeepLinkActivity_MembersInjector.injectDeepLinkIntentFactory(notificationDeepLinkActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        NotificationDeepLinkActivity_MembersInjector.injectPresenter(notificationDeepLinkActivity, this.h.get());
    }
}
