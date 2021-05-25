package com.avito.android.in_app_calls.ui.call;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.app.arch_components.ViewModelFactory;
import com.avito.android.app.arch_components.ViewModelFactory_Factory;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.in_app_calls.ui.AudioDeviceChooserImpl;
import com.avito.android.in_app_calls.ui.CallInteractor;
import com.avito.android.in_app_calls.ui.CallInteractor_Factory;
import com.avito.android.in_app_calls.ui.call.CallFragmentComponent;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
public final class DaggerCallFragmentComponent implements CallFragmentComponent {
    public final Fragment a;
    public final CallFragmentComponentDependencies b;
    public final FragmentActivity c;
    public Provider<CallsApi> d;
    public Provider<SchedulersFactory3> e;
    public Provider<NetworkTypeProvider> f;
    public Provider<UsernameProvider> g;
    public Provider<Features> h;
    public Provider<ErrorTracker> i;
    public Provider<CallInteractor> j;
    public Provider<Resources> k;
    public Provider<Analytics> l;
    public Provider<CallAnalyticsTracker> m;
    public Provider<CallPermissionsManager> n;
    public Provider<CallStorage> o;
    public Provider<TimeSource> p;
    public Provider<CallEventTracker> q;
    public Provider<AccountStateProvider> r;
    public Provider<PermissionChecker> s;
    public Provider<SchedulersFactory> t;
    public Provider<CallPresenterImpl> u;
    public Provider<Map<Class<?>, Provider<ViewModel>>> v;
    public Provider<ViewModelFactory> w;

    public static final class b implements CallFragmentComponent.Builder {
        public Fragment a;
        public FragmentActivity b;
        public Resources c;
        public CallFragmentComponentDependencies d;

        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent.Builder
        public CallFragmentComponent.Builder activity(FragmentActivity fragmentActivity) {
            this.b = (FragmentActivity) Preconditions.checkNotNull(fragmentActivity);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent.Builder
        public CallFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, FragmentActivity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, CallFragmentComponentDependencies.class);
            return new DaggerCallFragmentComponent(this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent.Builder
        public CallFragmentComponent.Builder dependencies(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.d = (CallFragmentComponentDependencies) Preconditions.checkNotNull(callFragmentComponentDependencies);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent.Builder
        public CallFragmentComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent.Builder
        public CallFragmentComponent.Builder resources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final CallFragmentComponentDependencies a;

        public c(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final CallFragmentComponentDependencies a;

        public d(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<CallAnalyticsTracker> {
        public final CallFragmentComponentDependencies a;

        public e(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallAnalyticsTracker get() {
            return (CallAnalyticsTracker) Preconditions.checkNotNullFromComponent(this.a.callAnalyticsTracker());
        }
    }

    public static class f implements Provider<ErrorTracker> {
        public final CallFragmentComponentDependencies a;

        public f(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ErrorTracker get() {
            return (ErrorTracker) Preconditions.checkNotNullFromComponent(this.a.callErrorTracker());
        }
    }

    public static class g implements Provider<CallEventTracker> {
        public final CallFragmentComponentDependencies a;

        public g(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallEventTracker get() {
            return (CallEventTracker) Preconditions.checkNotNullFromComponent(this.a.callEventTracker());
        }
    }

    public static class h implements Provider<CallPermissionsManager> {
        public final CallFragmentComponentDependencies a;

        public h(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallPermissionsManager get() {
            return (CallPermissionsManager) Preconditions.checkNotNullFromComponent(this.a.callPermissionsManager());
        }
    }

    public static class i implements Provider<CallStorage> {
        public final CallFragmentComponentDependencies a;

        public i(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallStorage get() {
            return (CallStorage) Preconditions.checkNotNullFromComponent(this.a.callStorage());
        }
    }

    public static class j implements Provider<CallsApi> {
        public final CallFragmentComponentDependencies a;

        public j(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallsApi get() {
            return (CallsApi) Preconditions.checkNotNullFromComponent(this.a.callsApi());
        }
    }

    public static class k implements Provider<Features> {
        public final CallFragmentComponentDependencies a;

        public k(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class l implements Provider<NetworkTypeProvider> {
        public final CallFragmentComponentDependencies a;

        public l(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class m implements Provider<PermissionChecker> {
        public final CallFragmentComponentDependencies a;

        public m(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionChecker get() {
            return (PermissionChecker) Preconditions.checkNotNullFromComponent(this.a.permissionChecker());
        }
    }

    public static class n implements Provider<SchedulersFactory3> {
        public final CallFragmentComponentDependencies a;

        public n(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class o implements Provider<SchedulersFactory> {
        public final CallFragmentComponentDependencies a;

        public o(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class p implements Provider<TimeSource> {
        public final CallFragmentComponentDependencies a;

        public p(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class q implements Provider<UsernameProvider> {
        public final CallFragmentComponentDependencies a;

        public q(CallFragmentComponentDependencies callFragmentComponentDependencies) {
            this.a = callFragmentComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UsernameProvider get() {
            return (UsernameProvider) Preconditions.checkNotNullFromComponent(this.a.usernameProvider());
        }
    }

    public DaggerCallFragmentComponent(CallFragmentComponentDependencies callFragmentComponentDependencies, Fragment fragment, FragmentActivity fragmentActivity, Resources resources, a aVar) {
        this.a = fragment;
        this.b = callFragmentComponentDependencies;
        this.c = fragmentActivity;
        j jVar = new j(callFragmentComponentDependencies);
        this.d = jVar;
        n nVar = new n(callFragmentComponentDependencies);
        this.e = nVar;
        l lVar = new l(callFragmentComponentDependencies);
        this.f = lVar;
        q qVar = new q(callFragmentComponentDependencies);
        this.g = qVar;
        k kVar = new k(callFragmentComponentDependencies);
        this.h = kVar;
        f fVar = new f(callFragmentComponentDependencies);
        this.i = fVar;
        this.j = CallInteractor_Factory.create(jVar, nVar, lVar, qVar, kVar, fVar);
        Factory create = InstanceFactory.create(resources);
        this.k = create;
        d dVar = new d(callFragmentComponentDependencies);
        this.l = dVar;
        e eVar = new e(callFragmentComponentDependencies);
        this.m = eVar;
        h hVar = new h(callFragmentComponentDependencies);
        this.n = hVar;
        i iVar = new i(callFragmentComponentDependencies);
        this.o = iVar;
        p pVar = new p(callFragmentComponentDependencies);
        this.p = pVar;
        g gVar = new g(callFragmentComponentDependencies);
        this.q = gVar;
        c cVar = new c(callFragmentComponentDependencies);
        this.r = cVar;
        m mVar = new m(callFragmentComponentDependencies);
        this.s = mVar;
        o oVar = new o(callFragmentComponentDependencies);
        this.t = oVar;
        this.u = CallPresenterImpl_Factory.create(this.j, create, dVar, eVar, hVar, iVar, this.h, pVar, gVar, this.i, cVar, mVar, oVar);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) CallPresenterImpl.class, (Provider) this.u).build();
        this.v = build;
        this.w = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static CallFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponent
    public void inject(CallFragment callFragment) {
        CallFragment_MembersInjector.injectCallPresenter(callFragment, CallFragmentModule_ProvideCallPresenterFactory.provideCallPresenter(this.a, this.w.get()));
        CallFragment_MembersInjector.injectRouter(callFragment, CallFragmentModule_ProvideInAppCallRouterFactory.provideInAppCallRouter(this.a));
        CallFragment_MembersInjector.injectTimeSource(callFragment, (TimeSource) Preconditions.checkNotNullFromComponent(this.b.timeSource()));
        CallFragment_MembersInjector.injectAudioManager(callFragment, (CallAudioManager) Preconditions.checkNotNullFromComponent(this.b.callAudioManager()));
        CallFragment_MembersInjector.injectAudioDeviceChooser(callFragment, new AudioDeviceChooserImpl((CallAudioManager) Preconditions.checkNotNullFromComponent(this.b.callAudioManager()), this.c));
        CallFragment_MembersInjector.injectIntentFactory(callFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.b.implicitIntentFactory()));
        CallFragment_MembersInjector.injectFeatures(callFragment, (Features) Preconditions.checkNotNullFromComponent(this.b.features()));
        CallFragment_MembersInjector.injectAnalytics(callFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
        CallFragment_MembersInjector.injectNewDesignTestGroup(callFragment, (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.b.newDesignTestGroup()));
    }
}
