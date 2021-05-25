package com.avito.android.in_app_calls.di;

import android.app.Service;
import android.os.IBinder;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.IncomingCallHandler;
import com.avito.android.in_app_calls.di.CallManagerServiceComponent;
import com.avito.android.in_app_calls.service.CallInfoLoader;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl_Factory;
import com.avito.android.in_app_calls.service.CallInfoSender;
import com.avito.android.in_app_calls.service.CallInfoSenderImpl;
import com.avito.android.in_app_calls.service.CallInfoSenderImpl_Factory;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate_Factory;
import com.avito.android.in_app_calls.service.CallManagerService_MembersInjector;
import com.avito.android.in_app_calls.service.CallNotificationsDelegate;
import com.avito.android.in_app_calls.service.CallNotificationsDelegateImpl;
import com.avito.android.in_app_calls.service.CallNotificationsDelegateImpl_Factory;
import com.avito.android.in_app_calls.service.CallReconnectHandler;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl_Factory;
import com.avito.android.in_app_calls.service.ReconnectClient;
import com.avito.android.in_app_calls.service.RingtoneDelegate;
import com.avito.android.in_app_calls.service.RingtoneDelegateImpl;
import com.avito.android.in_app_calls.service.RingtoneDelegateImpl_Factory;
import com.avito.android.in_app_calls.service.SystemCallStateProvider;
import com.avito.android.in_app_calls.service.binder.LocalCallManagerServiceBinder;
import com.avito.android.in_app_calls.service.binder.LocalCallManagerServiceBinder_Factory;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCallManagerServiceComponent implements CallManagerServiceComponent {
    public Provider<CallNotificationsDelegateImpl> A;
    public Provider<CallNotificationsDelegate> B;
    public Provider<RingtoneDelegateImpl> C;
    public Provider<RingtoneDelegate> D;
    public final CallManagerServiceComponentDependencies a;
    public Provider<CallManager> b;
    public Provider<TimeSource> c;
    public Provider<ReconnectClient> d;
    public Provider<SchedulersFactory> e;
    public Provider<CallAnalyticsTracker> f;
    public Provider<CallReconnectHandlerImpl> g;
    public Provider<CallReconnectHandler> h;
    public Provider<CallsApi> i;
    public Provider<SchedulersFactory3> j;
    public Provider<Analytics> k;
    public Provider<ErrorTracker> l;
    public Provider<CallInfoSenderImpl> m;
    public Provider<CallInfoSender> n;
    public Provider<CallInfoLoaderImpl> o;
    public Provider<CallInfoLoader> p;
    public Provider<CallAudioManager> q;
    public Provider<CallEventTracker> r;
    public Provider<Features> s;
    public Provider<CallManagerServiceDelegate> t;
    public Provider<LocalCallManagerServiceBinder> u;
    public Provider<IBinder> v;
    public Provider<Service> w;
    public Provider<ActivityIntentFactory> x;
    public Provider<SystemCallStateProvider> y;
    public Provider<CallUuidProvider> z;

    public static final class b implements CallManagerServiceComponent.CallManagerServiceComponentFactory {
        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponent.CallManagerServiceComponentFactory
        public CallManagerServiceComponent create(Service service, CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            Preconditions.checkNotNull(service);
            Preconditions.checkNotNull(callManagerServiceComponentDependencies);
            return new DaggerCallManagerServiceComponent(callManagerServiceComponentDependencies, service, null);
        }
    }

    public static class c implements Provider<ActivityIntentFactory> {
        public final CallManagerServiceComponentDependencies a;

        public c(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class d implements Provider<Analytics> {
        public final CallManagerServiceComponentDependencies a;

        public d(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<CallAnalyticsTracker> {
        public final CallManagerServiceComponentDependencies a;

        public e(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallAnalyticsTracker get() {
            return (CallAnalyticsTracker) Preconditions.checkNotNullFromComponent(this.a.callAnalyticsTracker());
        }
    }

    public static class f implements Provider<CallAudioManager> {
        public final CallManagerServiceComponentDependencies a;

        public f(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallAudioManager get() {
            return (CallAudioManager) Preconditions.checkNotNullFromComponent(this.a.callAudioManager());
        }
    }

    public static class g implements Provider<ErrorTracker> {
        public final CallManagerServiceComponentDependencies a;

        public g(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ErrorTracker get() {
            return (ErrorTracker) Preconditions.checkNotNullFromComponent(this.a.callErrorTracker());
        }
    }

    public static class h implements Provider<CallEventTracker> {
        public final CallManagerServiceComponentDependencies a;

        public h(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallEventTracker get() {
            return (CallEventTracker) Preconditions.checkNotNullFromComponent(this.a.callEventTracker());
        }
    }

    public static class i implements Provider<CallManager> {
        public final CallManagerServiceComponentDependencies a;

        public i(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallManager get() {
            return (CallManager) Preconditions.checkNotNullFromComponent(this.a.callManager());
        }
    }

    public static class j implements Provider<CallUuidProvider> {
        public final CallManagerServiceComponentDependencies a;

        public j(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallUuidProvider get() {
            return (CallUuidProvider) Preconditions.checkNotNullFromComponent(this.a.callUuidProvider());
        }
    }

    public static class k implements Provider<CallsApi> {
        public final CallManagerServiceComponentDependencies a;

        public k(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallsApi get() {
            return (CallsApi) Preconditions.checkNotNullFromComponent(this.a.callsApi());
        }
    }

    public static class l implements Provider<Features> {
        public final CallManagerServiceComponentDependencies a;

        public l(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<SchedulersFactory3> {
        public final CallManagerServiceComponentDependencies a;

        public m(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class n implements Provider<SchedulersFactory> {
        public final CallManagerServiceComponentDependencies a;

        public n(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class o implements Provider<SystemCallStateProvider> {
        public final CallManagerServiceComponentDependencies a;

        public o(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SystemCallStateProvider get() {
            return (SystemCallStateProvider) Preconditions.checkNotNullFromComponent(this.a.systemCallStateProvider());
        }
    }

    public static class p implements Provider<TimeSource> {
        public final CallManagerServiceComponentDependencies a;

        public p(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies) {
            this.a = callManagerServiceComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerCallManagerServiceComponent(CallManagerServiceComponentDependencies callManagerServiceComponentDependencies, Service service, a aVar) {
        this.a = callManagerServiceComponentDependencies;
        this.b = new i(callManagerServiceComponentDependencies);
        this.c = new p(callManagerServiceComponentDependencies);
        Provider<ReconnectClient> provider = DoubleCheck.provider(CallManagerServiceModule_ProvideReconnectClientFactory.create());
        this.d = provider;
        n nVar = new n(callManagerServiceComponentDependencies);
        this.e = nVar;
        e eVar = new e(callManagerServiceComponentDependencies);
        this.f = eVar;
        CallReconnectHandlerImpl_Factory create = CallReconnectHandlerImpl_Factory.create(provider, this.c, nVar, eVar);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        k kVar = new k(callManagerServiceComponentDependencies);
        this.i = kVar;
        m mVar = new m(callManagerServiceComponentDependencies);
        this.j = mVar;
        d dVar = new d(callManagerServiceComponentDependencies);
        this.k = dVar;
        g gVar = new g(callManagerServiceComponentDependencies);
        this.l = gVar;
        CallInfoSenderImpl_Factory create2 = CallInfoSenderImpl_Factory.create(kVar, mVar, dVar, gVar);
        this.m = create2;
        this.n = DoubleCheck.provider(create2);
        CallInfoLoaderImpl_Factory create3 = CallInfoLoaderImpl_Factory.create(this.i, this.k, this.j, this.l);
        this.o = create3;
        Provider<CallInfoLoader> provider2 = DoubleCheck.provider(create3);
        this.p = provider2;
        f fVar = new f(callManagerServiceComponentDependencies);
        this.q = fVar;
        h hVar = new h(callManagerServiceComponentDependencies);
        this.r = hVar;
        l lVar = new l(callManagerServiceComponentDependencies);
        this.s = lVar;
        Provider<CallManagerServiceDelegate> provider3 = DoubleCheck.provider(CallManagerServiceDelegate_Factory.create(this.b, this.c, this.h, this.n, provider2, fVar, hVar, lVar, this.l, this.e));
        this.t = provider3;
        LocalCallManagerServiceBinder_Factory create4 = LocalCallManagerServiceBinder_Factory.create(provider3);
        this.u = create4;
        this.v = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(service);
        this.w = create5;
        c cVar = new c(callManagerServiceComponentDependencies);
        this.x = cVar;
        o oVar = new o(callManagerServiceComponentDependencies);
        this.y = oVar;
        j jVar = new j(callManagerServiceComponentDependencies);
        this.z = jVar;
        CallNotificationsDelegateImpl_Factory create6 = CallNotificationsDelegateImpl_Factory.create(create5, cVar, oVar, this.f, jVar, this.s);
        this.A = create6;
        this.B = DoubleCheck.provider(create6);
        RingtoneDelegateImpl_Factory create7 = RingtoneDelegateImpl_Factory.create(this.w, this.s);
        this.C = create7;
        this.D = DoubleCheck.provider(create7);
    }

    public static CallManagerServiceComponent.CallManagerServiceComponentFactory factory() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponent
    public void inject(CallManagerService callManagerService) {
        CallManagerService_MembersInjector.injectDelegate(callManagerService, this.t.get());
        CallManagerService_MembersInjector.injectBinder(callManagerService, this.v.get());
        CallManagerService_MembersInjector.injectCallManager(callManagerService, (CallManager) Preconditions.checkNotNullFromComponent(this.a.callManager()));
        CallManagerService_MembersInjector.injectNotificationsDelegate(callManagerService, this.B.get());
        CallManagerService_MembersInjector.injectRingtoneDelegate(callManagerService, this.D.get());
        CallManagerService_MembersInjector.injectIncomingCallHandler(callManagerService, (IncomingCallHandler) Preconditions.checkNotNullFromComponent(this.a.incomingCallHandler()));
        CallManagerService_MembersInjector.injectCallStartTasks(callManagerService, (CallStartTask) Preconditions.checkNotNullFromComponent(this.a.callStartupTasks()));
    }
}
