package com.avito.android.push;

import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UpdateInstanceIdModule_ProvideUpdateInstanceIdInteractorFactory implements Factory<UpdateInstanceIdInteractor> {
    public final UpdateInstanceIdModule a;
    public final Provider<Adjust> b;
    public final Provider<MutableTokenStorage> c;
    public final Provider<NotificationsApi> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<BuildInfo> f;

    public UpdateInstanceIdModule_ProvideUpdateInstanceIdInteractorFactory(UpdateInstanceIdModule updateInstanceIdModule, Provider<Adjust> provider, Provider<MutableTokenStorage> provider2, Provider<NotificationsApi> provider3, Provider<SchedulersFactory> provider4, Provider<BuildInfo> provider5) {
        this.a = updateInstanceIdModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static UpdateInstanceIdModule_ProvideUpdateInstanceIdInteractorFactory create(UpdateInstanceIdModule updateInstanceIdModule, Provider<Adjust> provider, Provider<MutableTokenStorage> provider2, Provider<NotificationsApi> provider3, Provider<SchedulersFactory> provider4, Provider<BuildInfo> provider5) {
        return new UpdateInstanceIdModule_ProvideUpdateInstanceIdInteractorFactory(updateInstanceIdModule, provider, provider2, provider3, provider4, provider5);
    }

    public static UpdateInstanceIdInteractor provideUpdateInstanceIdInteractor(UpdateInstanceIdModule updateInstanceIdModule, Adjust adjust, MutableTokenStorage mutableTokenStorage, NotificationsApi notificationsApi, SchedulersFactory schedulersFactory, BuildInfo buildInfo) {
        return (UpdateInstanceIdInteractor) Preconditions.checkNotNullFromProvides(updateInstanceIdModule.provideUpdateInstanceIdInteractor(adjust, mutableTokenStorage, notificationsApi, schedulersFactory, buildInfo));
    }

    @Override // javax.inject.Provider
    public UpdateInstanceIdInteractor get() {
        return provideUpdateInstanceIdInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
