package com.avito.android.di.component;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.di.SendDataSizeDependencies;
import com.avito.android.di.component.SendDataSizeComponent;
import com.avito.android.di.module.SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory;
import com.avito.android.di.module.SendDataSizeModule_ProvideDataDiskUsageDelegateFactory;
import com.avito.android.di.module.SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory;
import com.avito.android.di.module.SendDataSizeModule_ProvideSendDataSizeDelegate$application_releaseFactory;
import com.avito.android.service.short_task.metrics.SendDataSizeTask;
import com.avito.android.service.short_task.metrics.SendDataSizeTaskDelegate;
import com.avito.android.service.short_task.metrics.SendDataSizeTask_MembersInjector;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDiskUsageDelegate;
import com.avito.android.util.DiskSpaceAnalyticsTraverser;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSendDataSizeComponent implements SendDataSizeComponent {
    public Provider<Context> a;
    public Provider<BuildInfo> b;
    public Provider<DataDirectoryProvider> c;
    public Provider<DataDiskUsageDelegate> d;
    public Provider<GraphitePrefix> e;
    public Provider<Analytics> f;
    public Provider<Features> g;
    public Provider<DiskSpaceAnalyticsTraverser> h;
    public Provider<SendDataSizeTaskDelegate> i;

    public static final class b implements SendDataSizeComponent.Builder {
        public SendDataSizeDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.SendDataSizeComponent.Builder
        public SendDataSizeComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SendDataSizeDependencies.class);
            return new DaggerSendDataSizeComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.SendDataSizeComponent.Builder
        public SendDataSizeComponent.Builder dependencies(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = (SendDataSizeDependencies) Preconditions.checkNotNull(sendDataSizeDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final SendDataSizeDependencies a;

        public c(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = sendDataSizeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final SendDataSizeDependencies a;

        public d(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = sendDataSizeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<Context> {
        public final SendDataSizeDependencies a;

        public e(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = sendDataSizeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class f implements Provider<Features> {
        public final SendDataSizeDependencies a;

        public f(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = sendDataSizeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<GraphitePrefix> {
        public final SendDataSizeDependencies a;

        public g(SendDataSizeDependencies sendDataSizeDependencies) {
            this.a = sendDataSizeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GraphitePrefix get() {
            return (GraphitePrefix) Preconditions.checkNotNullFromComponent(this.a.graphitePrefix());
        }
    }

    public DaggerSendDataSizeComponent(SendDataSizeDependencies sendDataSizeDependencies, a aVar) {
        e eVar = new e(sendDataSizeDependencies);
        this.a = eVar;
        d dVar = new d(sendDataSizeDependencies);
        this.b = dVar;
        Provider<DataDirectoryProvider> provider = DoubleCheck.provider(SendDataSizeModule_ProvideDataDirectoryProviderFactoryFactory.create(eVar, dVar));
        this.c = provider;
        Provider<DataDiskUsageDelegate> provider2 = DoubleCheck.provider(SendDataSizeModule_ProvideDataDiskUsageDelegateFactory.create(provider, this.a));
        this.d = provider2;
        g gVar = new g(sendDataSizeDependencies);
        this.e = gVar;
        c cVar = new c(sendDataSizeDependencies);
        this.f = cVar;
        f fVar = new f(sendDataSizeDependencies);
        this.g = fVar;
        Provider<DiskSpaceAnalyticsTraverser> provider3 = DoubleCheck.provider(SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory.create(this.c, provider2, gVar, cVar, fVar));
        this.h = provider3;
        this.i = DoubleCheck.provider(SendDataSizeModule_ProvideSendDataSizeDelegate$application_releaseFactory.create(provider3));
    }

    public static SendDataSizeComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.SendDataSizeComponent
    public void inject(SendDataSizeTask sendDataSizeTask) {
        SendDataSizeTask_MembersInjector.injectDelegate(sendDataSizeTask, this.i.get());
    }
}
