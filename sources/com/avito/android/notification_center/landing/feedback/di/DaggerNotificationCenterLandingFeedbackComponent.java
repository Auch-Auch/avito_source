package com.avito.android.notification_center.landing.feedback.di;

import android.app.Activity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity_MembersInjector;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractor;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractorImpl;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractorImpl_Factory;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl_Factory;
import com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerNotificationCenterLandingFeedbackComponent implements NotificationCenterLandingFeedbackComponent {
    public final PublishRelay<Unit> a;
    public final NotificationCenterLandingFeedbackDependencies b;
    public Provider<String> c;
    public Provider<NotificationsApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<NotificationCenterLandingFeedbackInteractorImpl> f;
    public Provider<NotificationCenterLandingFeedbackInteractor> g;
    public Provider<Analytics> h;
    public Provider<PublishRelay<Unit>> i;
    public Provider<Kundle> j;
    public Provider<NotificationCenterLandingFeedbackPresenterImpl> k;
    public Provider<NotificationCenterLandingFeedbackPresenter> l;
    public Provider<Activity> m;
    public Provider<DialogRouter> n;

    public static final class b implements NotificationCenterLandingFeedbackComponent.Builder {
        public NotificationCenterLandingFeedbackDependencies a;
        public String b;
        public Kundle c;
        public Activity d;
        public PublishRelay<Unit> e;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingFeedbackDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.d, Activity.class);
            Preconditions.checkBuilderRequirement(this.e, PublishRelay.class);
            return new DaggerNotificationCenterLandingFeedbackComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent.Builder dependencies(NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies) {
            this.a = (NotificationCenterLandingFeedbackDependencies) Preconditions.checkNotNull(notificationCenterLandingFeedbackDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent.Builder withActivity(Activity activity) {
            this.d = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent.Builder withCancelRelay(PublishRelay publishRelay) {
            this.e = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent.Builder
        public NotificationCenterLandingFeedbackComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterLandingFeedbackDependencies a;

        public c(NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies) {
            this.a = notificationCenterLandingFeedbackDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<NotificationsApi> {
        public final NotificationCenterLandingFeedbackDependencies a;

        public d(NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies) {
            this.a = notificationCenterLandingFeedbackDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final NotificationCenterLandingFeedbackDependencies a;

        public e(NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies) {
            this.a = notificationCenterLandingFeedbackDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNotificationCenterLandingFeedbackComponent(NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies, String str, Kundle kundle, Activity activity, PublishRelay publishRelay, a aVar) {
        this.a = publishRelay;
        this.b = notificationCenterLandingFeedbackDependencies;
        this.c = InstanceFactory.create(str);
        d dVar = new d(notificationCenterLandingFeedbackDependencies);
        this.d = dVar;
        e eVar = new e(notificationCenterLandingFeedbackDependencies);
        this.e = eVar;
        NotificationCenterLandingFeedbackInteractorImpl_Factory create = NotificationCenterLandingFeedbackInteractorImpl_Factory.create(dVar, eVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new c(notificationCenterLandingFeedbackDependencies);
        this.i = InstanceFactory.create(publishRelay);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.j = createNullable;
        NotificationCenterLandingFeedbackPresenterImpl_Factory create2 = NotificationCenterLandingFeedbackPresenterImpl_Factory.create(this.c, this.g, this.e, this.h, this.i, createNullable);
        this.k = create2;
        this.l = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(activity);
        this.m = create3;
        this.n = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create3));
    }

    public static NotificationCenterLandingFeedbackComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent
    public void inject(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity) {
        NotificationCenterLandingFeedbackActivity_MembersInjector.injectPresenter(notificationCenterLandingFeedbackActivity, this.l.get());
        NotificationCenterLandingFeedbackActivity_MembersInjector.injectDialogRouter(notificationCenterLandingFeedbackActivity, this.n.get());
        NotificationCenterLandingFeedbackActivity_MembersInjector.injectOnCancelDialogRelay(notificationCenterLandingFeedbackActivity, this.a);
        NotificationCenterLandingFeedbackActivity_MembersInjector.injectAnalytics(notificationCenterLandingFeedbackActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
    }
}
