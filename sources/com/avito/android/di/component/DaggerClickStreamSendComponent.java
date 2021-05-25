package com.avito.android.di.component;

import android.app.Application;
import com.avito.android.analytics.clickstream.ClickStreamApi;
import com.avito.android.analytics.clickstream.ClickStreamCommonSendingModule_ProvideClickStreamApiFactory;
import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegate;
import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegateImpl;
import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegateImpl_Factory;
import com.avito.android.analytics.inhouse_transport.InHouseCommonSendingModule_ProvideHttpClientFactory;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.di.ClickStreamSendDependencies;
import com.avito.android.di.component.ClickStreamSendComponent;
import com.avito.android.di.module.ClickStreamSendingModule_ProvideClickStreamSenderFactory;
import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.UserAgentProvider;
import com.avito.android.service.short_task.clickstream.AvitoCommonParametersProvider;
import com.avito.android.service.short_task.clickstream.AvitoCommonParametersProvider_Factory;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask_MembersInjector;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import proto.events.apps.EventOuterClass;
public final class DaggerClickStreamSendComponent implements ClickStreamSendComponent {
    public final ClickStreamSendDependencies a;
    public Provider<BuildInfo> b;
    public Provider<OkHttpClient> c;
    public Provider<ClickStreamApi> d;
    public Provider<InHouseEventStorage<EventOuterClass.Event>> e;
    public Provider<DeviceIdProvider> f;
    public Provider<UserAgentProvider> g;
    public Provider<GeoStorage> h;
    public Provider<AvitoCommonParametersProvider> i;
    public Provider<ClickStreamSender.CommonParametersProvider> j;
    public Provider<SchedulersFactory> k;
    public Provider<Application> l;
    public Provider<ClickStreamSender> m;
    public Provider<SendClickStreamEventsTaskDelegateImpl> n;
    public Provider<SendClickStreamEventsTaskDelegate> o;

    public static final class b implements ClickStreamSendComponent.Builder {
        public ClickStreamSendDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.ClickStreamSendComponent.Builder
        public ClickStreamSendComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ClickStreamSendDependencies.class);
            return new DaggerClickStreamSendComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.ClickStreamSendComponent.Builder
        public ClickStreamSendComponent.Builder dependencies(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = (ClickStreamSendDependencies) Preconditions.checkNotNull(clickStreamSendDependencies);
            return this;
        }
    }

    public static class c implements Provider<Application> {
        public final ClickStreamSendDependencies a;

        public c(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final ClickStreamSendDependencies a;

        public d(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<InHouseEventStorage<EventOuterClass.Event>> {
        public final ClickStreamSendDependencies a;

        public e(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public InHouseEventStorage<EventOuterClass.Event> get() {
            return (InHouseEventStorage) Preconditions.checkNotNullFromComponent(this.a.clickStreamEventStorage());
        }
    }

    public static class f implements Provider<DeviceIdProvider> {
        public final ClickStreamSendDependencies a;

        public f(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceIdProvider get() {
            return (DeviceIdProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdProvider());
        }
    }

    public static class g implements Provider<GeoStorage> {
        public final ClickStreamSendDependencies a;

        public g(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoProvider());
        }
    }

    public static class h implements Provider<SchedulersFactory> {
        public final ClickStreamSendDependencies a;

        public h(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<UserAgentProvider> {
        public final ClickStreamSendDependencies a;

        public i(ClickStreamSendDependencies clickStreamSendDependencies) {
            this.a = clickStreamSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentProvider get() {
            return (UserAgentProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentProvider());
        }
    }

    public DaggerClickStreamSendComponent(ClickStreamSendDependencies clickStreamSendDependencies, a aVar) {
        this.a = clickStreamSendDependencies;
        d dVar = new d(clickStreamSendDependencies);
        this.b = dVar;
        Provider<OkHttpClient> provider = SingleCheck.provider(InHouseCommonSendingModule_ProvideHttpClientFactory.create(dVar));
        this.c = provider;
        this.d = SingleCheck.provider(ClickStreamCommonSendingModule_ProvideClickStreamApiFactory.create(this.b, provider));
        this.e = new e(clickStreamSendDependencies);
        f fVar = new f(clickStreamSendDependencies);
        this.f = fVar;
        i iVar = new i(clickStreamSendDependencies);
        this.g = iVar;
        g gVar = new g(clickStreamSendDependencies);
        this.h = gVar;
        AvitoCommonParametersProvider_Factory create = AvitoCommonParametersProvider_Factory.create(fVar, iVar, gVar);
        this.i = create;
        Provider<ClickStreamSender.CommonParametersProvider> provider2 = DoubleCheck.provider(create);
        this.j = provider2;
        h hVar = new h(clickStreamSendDependencies);
        this.k = hVar;
        c cVar = new c(clickStreamSendDependencies);
        this.l = cVar;
        Provider<ClickStreamSender> provider3 = DoubleCheck.provider(ClickStreamSendingModule_ProvideClickStreamSenderFactory.create(this.d, this.e, this.f, provider2, hVar, this.b, cVar));
        this.m = provider3;
        SendClickStreamEventsTaskDelegateImpl_Factory create2 = SendClickStreamEventsTaskDelegateImpl_Factory.create(provider3);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
    }

    public static ClickStreamSendComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.ClickStreamSendComponent
    public ClickStreamSender clickStreamSender() {
        return this.m.get();
    }

    @Override // com.avito.android.di.component.ClickStreamSendComponent
    public DeviceIdProvider deviceId() {
        return (DeviceIdProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdProvider());
    }

    @Override // com.avito.android.di.component.ClickStreamSendComponent
    public void inject(SendClickStreamEventsTask sendClickStreamEventsTask) {
        SendClickStreamEventsTask_MembersInjector.injectDelegate(sendClickStreamEventsTask, this.o.get());
    }
}
