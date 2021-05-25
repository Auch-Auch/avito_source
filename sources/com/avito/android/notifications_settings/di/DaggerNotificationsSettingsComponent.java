package com.avito.android.notifications_settings.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.notifications_settings.NotificationsSettingsActivity;
import com.avito.android.notifications_settings.NotificationsSettingsActivity_MembersInjector;
import com.avito.android.notifications_settings.NotificationsSettingsConverter;
import com.avito.android.notifications_settings.NotificationsSettingsConverterImpl_Factory;
import com.avito.android.notifications_settings.NotificationsSettingsInteractor;
import com.avito.android.notifications_settings.NotificationsSettingsInteractorImpl;
import com.avito.android.notifications_settings.NotificationsSettingsInteractorImpl_Factory;
import com.avito.android.notifications_settings.NotificationsSettingsPresenter;
import com.avito.android.notifications_settings.NotificationsSettingsPresenterImpl;
import com.avito.android.notifications_settings.NotificationsSettingsPresenterImpl_Factory;
import com.avito.android.notifications_settings.di.NotificationsSettingsComponent;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoBlueprint;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoBlueprint_Factory;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoPresenter;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoPresenterImpl_Factory;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomBlueprint;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomBlueprint_Factory;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomPresenter;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomPresenterImpl_Factory;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopBlueprint;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopBlueprint_Factory;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopPresenter;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopPresenterImpl_Factory;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceBlueprint;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceBlueprint_Factory;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpacePresenter;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpacePresenterImpl_Factory;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleBlueprint;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleBlueprint_Factory;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitlePresenter;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitlePresenterImpl_Factory;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleBlueprint;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleBlueprint_Factory;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsTogglePresenter;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsTogglePresenterImpl;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsTogglePresenterImpl_Factory;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerNotificationsSettingsComponent implements NotificationsSettingsComponent {
    public Provider<NotificationsSettingsPresenter> A;
    public final NotificationsSettingsDependencies a;
    public Provider<NotificationsSettingsInfoPresenter> b;
    public Provider<NotificationsSettingsInfoBlueprint> c;
    public Provider<NotificationsSettingsShadowBottomPresenter> d;
    public Provider<NotificationsSettingsShadowBottomBlueprint> e;
    public Provider<NotificationsSettingsShadowTopPresenter> f;
    public Provider<NotificationsSettingsShadowTopBlueprint> g;
    public Provider<NotificationsSettingsSpacePresenter> h;
    public Provider<NotificationsSettingsSpaceBlueprint> i;
    public Provider<NotificationsSettingsTitlePresenter> j;
    public Provider<NotificationsSettingsTitleBlueprint> k;
    public Provider<Relay<NotificationsSettingsToggleItem>> l;
    public Provider<NotificationsSettingsTogglePresenterImpl> m;
    public Provider<NotificationsSettingsTogglePresenter> n;
    public Provider<NotificationsSettingsToggleBlueprint> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;
    public Provider<Relay<Unit>> r = DoubleCheck.provider(NotificationsSettingsModule_ProvideSettingsConsumerFactory.create());
    public Provider<NotificationsApi> s;
    public Provider<SchedulersFactory> t;
    public Provider<NotificationsSettingsInteractorImpl> u;
    public Provider<NotificationsSettingsInteractor> v;
    public Provider<NotificationsSettingsConverter> w;
    public Provider<Consumer<NotificationSettingsChangeEvent>> x;
    public Provider<Kundle> y;
    public Provider<NotificationsSettingsPresenterImpl> z;

    public static final class b implements NotificationsSettingsComponent.Builder {
        public NotificationsSettingsDependencies a;
        public Kundle b;

        public b(a aVar) {
        }

        @Override // com.avito.android.notifications_settings.di.NotificationsSettingsComponent.Builder
        public NotificationsSettingsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationsSettingsDependencies.class);
            return new DaggerNotificationsSettingsComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.notifications_settings.di.NotificationsSettingsComponent.Builder
        public NotificationsSettingsComponent.Builder dependencies(NotificationsSettingsDependencies notificationsSettingsDependencies) {
            this.a = (NotificationsSettingsDependencies) Preconditions.checkNotNull(notificationsSettingsDependencies);
            return this;
        }

        @Override // com.avito.android.notifications_settings.di.NotificationsSettingsComponent.Builder
        public NotificationsSettingsComponent.Builder withPresenterState(Kundle kundle) {
            this.b = kundle;
            return this;
        }
    }

    public static class c implements Provider<Consumer<NotificationSettingsChangeEvent>> {
        public final NotificationsSettingsDependencies a;

        public c(NotificationsSettingsDependencies notificationsSettingsDependencies) {
            this.a = notificationsSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Consumer<NotificationSettingsChangeEvent> get() {
            return (Consumer) Preconditions.checkNotNullFromComponent(this.a.notificationSettingsConsumer());
        }
    }

    public static class d implements Provider<NotificationsApi> {
        public final NotificationsSettingsDependencies a;

        public d(NotificationsSettingsDependencies notificationsSettingsDependencies) {
            this.a = notificationsSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final NotificationsSettingsDependencies a;

        public e(NotificationsSettingsDependencies notificationsSettingsDependencies) {
            this.a = notificationsSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNotificationsSettingsComponent(NotificationsSettingsDependencies notificationsSettingsDependencies, Kundle kundle, a aVar) {
        this.a = notificationsSettingsDependencies;
        Provider<NotificationsSettingsInfoPresenter> provider = DoubleCheck.provider(NotificationsSettingsInfoPresenterImpl_Factory.create());
        this.b = provider;
        this.c = NotificationsSettingsInfoBlueprint_Factory.create(provider);
        Provider<NotificationsSettingsShadowBottomPresenter> provider2 = DoubleCheck.provider(NotificationsSettingsShadowBottomPresenterImpl_Factory.create());
        this.d = provider2;
        this.e = NotificationsSettingsShadowBottomBlueprint_Factory.create(provider2);
        Provider<NotificationsSettingsShadowTopPresenter> provider3 = DoubleCheck.provider(NotificationsSettingsShadowTopPresenterImpl_Factory.create());
        this.f = provider3;
        this.g = NotificationsSettingsShadowTopBlueprint_Factory.create(provider3);
        Provider<NotificationsSettingsSpacePresenter> provider4 = DoubleCheck.provider(NotificationsSettingsSpacePresenterImpl_Factory.create());
        this.h = provider4;
        this.i = NotificationsSettingsSpaceBlueprint_Factory.create(provider4);
        Provider<NotificationsSettingsTitlePresenter> provider5 = DoubleCheck.provider(NotificationsSettingsTitlePresenterImpl_Factory.create());
        this.j = provider5;
        this.k = NotificationsSettingsTitleBlueprint_Factory.create(provider5);
        Provider<Relay<NotificationsSettingsToggleItem>> provider6 = DoubleCheck.provider(NotificationsSettingsModule_ProvideNotificationsSettingsToggleItemConsumerFactory.create());
        this.l = provider6;
        NotificationsSettingsTogglePresenterImpl_Factory create = NotificationsSettingsTogglePresenterImpl_Factory.create(provider6);
        this.m = create;
        Provider<NotificationsSettingsTogglePresenter> provider7 = DoubleCheck.provider(create);
        this.n = provider7;
        NotificationsSettingsToggleBlueprint_Factory create2 = NotificationsSettingsToggleBlueprint_Factory.create(provider7);
        this.o = create2;
        Provider<ItemBinder> provider8 = DoubleCheck.provider(NotificationsSettingsModule_ProvideItemBinderFactory.create(this.c, this.e, this.g, this.i, this.k, create2));
        this.p = provider8;
        this.q = DoubleCheck.provider(NotificationsSettingsModule_ProvideAdapterPresenterFactory.create(provider8));
        d dVar = new d(notificationsSettingsDependencies);
        this.s = dVar;
        e eVar = new e(notificationsSettingsDependencies);
        this.t = eVar;
        NotificationsSettingsInteractorImpl_Factory create3 = NotificationsSettingsInteractorImpl_Factory.create(dVar, eVar);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
        this.w = DoubleCheck.provider(NotificationsSettingsConverterImpl_Factory.create());
        this.x = new c(notificationsSettingsDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.y = createNullable;
        NotificationsSettingsPresenterImpl_Factory create4 = NotificationsSettingsPresenterImpl_Factory.create(this.v, this.w, this.t, this.q, this.r, this.l, this.x, createNullable);
        this.z = create4;
        this.A = DoubleCheck.provider(create4);
    }

    public static NotificationsSettingsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notifications_settings.di.NotificationsSettingsComponent
    public void inject(NotificationsSettingsActivity notificationsSettingsActivity) {
        NotificationsSettingsActivity_MembersInjector.injectAdapterPresenter(notificationsSettingsActivity, this.q.get());
        NotificationsSettingsActivity_MembersInjector.injectAnalytics(notificationsSettingsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        NotificationsSettingsActivity_MembersInjector.injectConsumer(notificationsSettingsActivity, this.r.get());
        NotificationsSettingsActivity_MembersInjector.injectImplicitIntentFactory(notificationsSettingsActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        NotificationsSettingsActivity_MembersInjector.injectItemBinder(notificationsSettingsActivity, this.p.get());
        NotificationsSettingsActivity_MembersInjector.injectNotificationManagerProvider(notificationsSettingsActivity, (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider()));
        NotificationsSettingsActivity_MembersInjector.injectPresenter(notificationsSettingsActivity, this.A.get());
    }
}
