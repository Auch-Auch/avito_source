package com.avito.android.in_app_calls.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallActivityModule_ProvideInAppCallsRouterFactory implements Factory<InAppCallsRouter> {
    public final Provider<FragmentActivity> a;

    public CallActivityModule_ProvideInAppCallsRouterFactory(Provider<FragmentActivity> provider) {
        this.a = provider;
    }

    public static CallActivityModule_ProvideInAppCallsRouterFactory create(Provider<FragmentActivity> provider) {
        return new CallActivityModule_ProvideInAppCallsRouterFactory(provider);
    }

    public static InAppCallsRouter provideInAppCallsRouter(FragmentActivity fragmentActivity) {
        return (InAppCallsRouter) Preconditions.checkNotNullFromProvides(CallActivityModule.INSTANCE.provideInAppCallsRouter(fragmentActivity));
    }

    @Override // javax.inject.Provider
    public InAppCallsRouter get() {
        return provideInAppCallsRouter(this.a.get());
    }
}
