package com.avito.android.push;

import com.avito.android.push.provider.PushTokenProvider;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UpdateInstanceIdWorker_MembersInjector implements MembersInjector<UpdateInstanceIdWorker> {
    public final Provider<UpdateInstanceIdInteractor> a;
    public final Provider<PushTokenProvider> b;

    public UpdateInstanceIdWorker_MembersInjector(Provider<UpdateInstanceIdInteractor> provider, Provider<PushTokenProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<UpdateInstanceIdWorker> create(Provider<UpdateInstanceIdInteractor> provider, Provider<PushTokenProvider> provider2) {
        return new UpdateInstanceIdWorker_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.push.UpdateInstanceIdWorker.interactor")
    public static void injectInteractor(UpdateInstanceIdWorker updateInstanceIdWorker, UpdateInstanceIdInteractor updateInstanceIdInteractor) {
        updateInstanceIdWorker.interactor = updateInstanceIdInteractor;
    }

    @InjectedFieldSignature("com.avito.android.push.UpdateInstanceIdWorker.pushTokenProvider")
    public static void injectPushTokenProvider(UpdateInstanceIdWorker updateInstanceIdWorker, PushTokenProvider pushTokenProvider) {
        updateInstanceIdWorker.pushTokenProvider = pushTokenProvider;
    }

    public void injectMembers(UpdateInstanceIdWorker updateInstanceIdWorker) {
        injectInteractor(updateInstanceIdWorker, this.a.get());
        injectPushTokenProvider(updateInstanceIdWorker, this.b.get());
    }
}
