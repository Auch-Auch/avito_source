package com.avito.android.service.short_task;

import android.content.Context;
import com.avito.android.preferences.FingerprintStorage;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FingerprintCalculationTask_MembersInjector implements MembersInjector<FingerprintCalculationTask> {
    public final Provider<Context> a;
    public final Provider<FingerprintStorage> b;

    public FingerprintCalculationTask_MembersInjector(Provider<Context> provider, Provider<FingerprintStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<FingerprintCalculationTask> create(Provider<Context> provider, Provider<FingerprintStorage> provider2) {
        return new FingerprintCalculationTask_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.FingerprintCalculationTask.context")
    public static void injectContext(FingerprintCalculationTask fingerprintCalculationTask, Context context) {
        fingerprintCalculationTask.context = context;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.FingerprintCalculationTask.fingerprintStorage")
    public static void injectFingerprintStorage(FingerprintCalculationTask fingerprintCalculationTask, FingerprintStorage fingerprintStorage) {
        fingerprintCalculationTask.fingerprintStorage = fingerprintStorage;
    }

    public void injectMembers(FingerprintCalculationTask fingerprintCalculationTask) {
        injectContext(fingerprintCalculationTask, this.a.get());
        injectFingerprintStorage(fingerprintCalculationTask, this.b.get());
    }
}
