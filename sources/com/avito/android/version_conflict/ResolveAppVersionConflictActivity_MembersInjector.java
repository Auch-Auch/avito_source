package com.avito.android.version_conflict;

import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ResolveAppVersionConflictActivity_MembersInjector implements MembersInjector<ResolveAppVersionConflictActivity> {
    public final Provider<ImplicitIntentFactory> a;

    public ResolveAppVersionConflictActivity_MembersInjector(Provider<ImplicitIntentFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<ResolveAppVersionConflictActivity> create(Provider<ImplicitIntentFactory> provider) {
        return new ResolveAppVersionConflictActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.version_conflict.ResolveAppVersionConflictActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity, ImplicitIntentFactory implicitIntentFactory) {
        resolveAppVersionConflictActivity.implicitIntentFactory = implicitIntentFactory;
    }

    public void injectMembers(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity) {
        injectImplicitIntentFactory(resolveAppVersionConflictActivity, this.a.get());
    }
}
