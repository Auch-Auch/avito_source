package com.avito.android.di.component;

import android.app.Application;
import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.di.SendMetricsServiceDependencies;
import com.avito.android.di.component.SendMetricsServiceComponent;
import com.avito.android.di.module.GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory;
import com.avito.android.di.module.SendMetricsModule_ProvideDataDirectoryProviderFactoryFactory;
import com.avito.android.di.module.SendMetricsModule_ProvideDataDiskUsageDelegateFactory;
import com.avito.android.di.module.SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory;
import com.avito.android.di.module.SendMetricsModule_ProvideSendMetricsTaskDelegate$application_releaseFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.service.short_task.metrics.AccessibilityInfoProvider;
import com.avito.android.service.short_task.metrics.AccessibilityInfoProvider_Factory;
import com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper;
import com.avito.android.service.short_task.metrics.AccessibilityManagerWrapperImpl;
import com.avito.android.service.short_task.metrics.AccessibilityManagerWrapperImpl_Factory;
import com.avito.android.service.short_task.metrics.DarkThemeDetectionProvider;
import com.avito.android.service.short_task.metrics.DarkThemeDetectionProvider_Factory;
import com.avito.android.service.short_task.metrics.DataDiskUsageMetricProvider;
import com.avito.android.service.short_task.metrics.DeviceInfoMetricProvider;
import com.avito.android.service.short_task.metrics.DeviceInfoMetricProvider_Factory;
import com.avito.android.service.short_task.metrics.GooglePlayServicesInfoProvider;
import com.avito.android.service.short_task.metrics.GooglePlayServicesInfoProvider_Factory;
import com.avito.android.service.short_task.metrics.NetworkMetricProvider;
import com.avito.android.service.short_task.metrics.NetworkMetricProvider_Factory;
import com.avito.android.service.short_task.metrics.PermissionInfoProvider;
import com.avito.android.service.short_task.metrics.PermissionInfoProvider_Factory;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.service.short_task.metrics.SendMetricTask_MembersInjector;
import com.avito.android.service.short_task.metrics.SendMetricsTaskDelegate;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDiskUsageDelegate;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.GooglePlayServicesInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSendMetricsServiceComponent implements SendMetricsServiceComponent {
    public Provider<PermissionChecker> a;
    public Provider<NotificationManagerProvider> b;
    public Provider<PermissionInfoProvider> c;
    public Provider<DeviceMetrics> d;
    public Provider<DeviceInfoMetricProvider> e;
    public Provider<Context> f;
    public Provider<AccessibilityManagerWrapperImpl> g;
    public Provider<AccessibilityManagerWrapper> h;
    public Provider<AccessibilityInfoProvider> i;
    public Provider<Application> j;
    public Provider<GooglePlayServicesInfo> k;
    public Provider<GooglePlayServicesInfoProvider> l;
    public Provider<BuildInfo> m;
    public Provider<DataDirectoryProvider> n;
    public Provider<DataDiskUsageDelegate> o;
    public Provider<DataDiskUsageMetricProvider> p;
    public Provider<NetworkTypeProvider> q;
    public Provider<NetworkMetricProvider> r;
    public Provider<Analytics> s;
    public Provider<DarkThemeDetectionProvider> t;
    public Provider<SchedulersFactory> u;
    public Provider<SendMetricsTaskDelegate> v;

    public static final class b implements SendMetricsServiceComponent.Builder {
        public SendMetricsServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.SendMetricsServiceComponent.Builder
        public SendMetricsServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SendMetricsServiceDependencies.class);
            return new DaggerSendMetricsServiceComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.SendMetricsServiceComponent.Builder
        public SendMetricsServiceComponent.Builder dependencies(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = (SendMetricsServiceDependencies) Preconditions.checkNotNull(sendMetricsServiceDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final SendMetricsServiceDependencies a;

        public c(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final SendMetricsServiceDependencies a;

        public d(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final SendMetricsServiceDependencies a;

        public e(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<Context> {
        public final SendMetricsServiceDependencies a;

        public f(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class g implements Provider<DeviceMetrics> {
        public final SendMetricsServiceDependencies a;

        public g(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class h implements Provider<NetworkTypeProvider> {
        public final SendMetricsServiceDependencies a;

        public h(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class i implements Provider<NotificationManagerProvider> {
        public final SendMetricsServiceDependencies a;

        public i(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationManagerProvider get() {
            return (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider());
        }
    }

    public static class j implements Provider<PermissionChecker> {
        public final SendMetricsServiceDependencies a;

        public j(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionChecker get() {
            return (PermissionChecker) Preconditions.checkNotNullFromComponent(this.a.permissionChecker());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final SendMetricsServiceDependencies a;

        public k(SendMetricsServiceDependencies sendMetricsServiceDependencies) {
            this.a = sendMetricsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerSendMetricsServiceComponent(SendMetricsServiceDependencies sendMetricsServiceDependencies, a aVar) {
        j jVar = new j(sendMetricsServiceDependencies);
        this.a = jVar;
        i iVar = new i(sendMetricsServiceDependencies);
        this.b = iVar;
        this.c = PermissionInfoProvider_Factory.create(jVar, iVar);
        g gVar = new g(sendMetricsServiceDependencies);
        this.d = gVar;
        this.e = DeviceInfoMetricProvider_Factory.create(gVar);
        f fVar = new f(sendMetricsServiceDependencies);
        this.f = fVar;
        AccessibilityManagerWrapperImpl_Factory create = AccessibilityManagerWrapperImpl_Factory.create(fVar);
        this.g = create;
        Provider<AccessibilityManagerWrapper> provider = DoubleCheck.provider(create);
        this.h = provider;
        this.i = AccessibilityInfoProvider_Factory.create(provider);
        d dVar = new d(sendMetricsServiceDependencies);
        this.j = dVar;
        GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory create2 = GooglePlayServicesInfoModule_ProvideGooglePlayServicesInfoFactory.create(dVar);
        this.k = create2;
        this.l = GooglePlayServicesInfoProvider_Factory.create(create2);
        e eVar = new e(sendMetricsServiceDependencies);
        this.m = eVar;
        Provider<DataDirectoryProvider> provider2 = DoubleCheck.provider(SendMetricsModule_ProvideDataDirectoryProviderFactoryFactory.create(this.f, eVar));
        this.n = provider2;
        Provider<DataDiskUsageDelegate> provider3 = DoubleCheck.provider(SendMetricsModule_ProvideDataDiskUsageDelegateFactory.create(provider2, this.f));
        this.o = provider3;
        this.p = DoubleCheck.provider(SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory.create(this.n, provider3));
        h hVar = new h(sendMetricsServiceDependencies);
        this.q = hVar;
        this.r = NetworkMetricProvider_Factory.create(hVar);
        c cVar = new c(sendMetricsServiceDependencies);
        this.s = cVar;
        DarkThemeDetectionProvider_Factory create3 = DarkThemeDetectionProvider_Factory.create(cVar, this.f);
        this.t = create3;
        k kVar = new k(sendMetricsServiceDependencies);
        this.u = kVar;
        this.v = DoubleCheck.provider(SendMetricsModule_ProvideSendMetricsTaskDelegate$application_releaseFactory.create(this.c, this.e, this.i, this.l, this.p, this.r, create3, this.s, kVar));
    }

    public static SendMetricsServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.SendMetricsServiceComponent
    public void inject(SendMetricTask sendMetricTask) {
        SendMetricTask_MembersInjector.injectDelegate(sendMetricTask, this.v.get());
    }
}
