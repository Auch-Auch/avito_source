package com.avito.android.push;

import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.push.UpdateInstanceIdComponent;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerUpdateInstanceIdComponent implements UpdateInstanceIdComponent {
    public final UpdateInstanceIdDependencies a;
    public Provider<Adjust> b;
    public Provider<MutableTokenStorage> c;
    public Provider<NotificationsApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<BuildInfo> f;
    public Provider<UpdateInstanceIdInteractor> g;

    public static final class b implements UpdateInstanceIdComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.push.UpdateInstanceIdComponent.Factory
        public UpdateInstanceIdComponent create(UpdateInstanceIdDependencies updateInstanceIdDependencies, UpdateInstanceIdModule updateInstanceIdModule) {
            Preconditions.checkNotNull(updateInstanceIdDependencies);
            Preconditions.checkNotNull(updateInstanceIdModule);
            return new DaggerUpdateInstanceIdComponent(updateInstanceIdModule, updateInstanceIdDependencies, null);
        }
    }

    public static class c implements Provider<Adjust> {
        public final UpdateInstanceIdDependencies a;

        public c(UpdateInstanceIdDependencies updateInstanceIdDependencies) {
            this.a = updateInstanceIdDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Adjust get() {
            return (Adjust) Preconditions.checkNotNullFromComponent(this.a.adjust());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final UpdateInstanceIdDependencies a;

        public d(UpdateInstanceIdDependencies updateInstanceIdDependencies) {
            this.a = updateInstanceIdDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<MutableTokenStorage> {
        public final UpdateInstanceIdDependencies a;

        public e(UpdateInstanceIdDependencies updateInstanceIdDependencies) {
            this.a = updateInstanceIdDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MutableTokenStorage get() {
            return (MutableTokenStorage) Preconditions.checkNotNullFromComponent(this.a.mutableInstanceIdStorage());
        }
    }

    public static class f implements Provider<NotificationsApi> {
        public final UpdateInstanceIdDependencies a;

        public f(UpdateInstanceIdDependencies updateInstanceIdDependencies) {
            this.a = updateInstanceIdDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final UpdateInstanceIdDependencies a;

        public g(UpdateInstanceIdDependencies updateInstanceIdDependencies) {
            this.a = updateInstanceIdDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerUpdateInstanceIdComponent(UpdateInstanceIdModule updateInstanceIdModule, UpdateInstanceIdDependencies updateInstanceIdDependencies, a aVar) {
        this.a = updateInstanceIdDependencies;
        c cVar = new c(updateInstanceIdDependencies);
        this.b = cVar;
        e eVar = new e(updateInstanceIdDependencies);
        this.c = eVar;
        f fVar = new f(updateInstanceIdDependencies);
        this.d = fVar;
        g gVar = new g(updateInstanceIdDependencies);
        this.e = gVar;
        d dVar = new d(updateInstanceIdDependencies);
        this.f = dVar;
        this.g = DoubleCheck.provider(UpdateInstanceIdModule_ProvideUpdateInstanceIdInteractorFactory.create(updateInstanceIdModule, cVar, eVar, fVar, gVar, dVar));
    }

    public static UpdateInstanceIdComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.push.UpdateInstanceIdComponent
    public void inject(UpdateInstanceIdWorker updateInstanceIdWorker) {
        UpdateInstanceIdWorker_MembersInjector.injectInteractor(updateInstanceIdWorker, this.g.get());
        UpdateInstanceIdWorker_MembersInjector.injectPushTokenProvider(updateInstanceIdWorker, (PushTokenProvider) Preconditions.checkNotNullFromComponent(this.a.pushTokenProvider()));
    }
}
