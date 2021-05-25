package com.avito.android.in_app_calls.ui.call;

import androidx.fragment.app.Fragment;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallFragmentModule_ProvideInAppCallRouterFactory implements Factory<InAppCallsRouter> {
    public final Provider<Fragment> a;

    public CallFragmentModule_ProvideInAppCallRouterFactory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static CallFragmentModule_ProvideInAppCallRouterFactory create(Provider<Fragment> provider) {
        return new CallFragmentModule_ProvideInAppCallRouterFactory(provider);
    }

    public static InAppCallsRouter provideInAppCallRouter(Fragment fragment) {
        return (InAppCallsRouter) Preconditions.checkNotNullFromProvides(CallFragmentModule.INSTANCE.provideInAppCallRouter(fragment));
    }

    @Override // javax.inject.Provider
    public InAppCallsRouter get() {
        return provideInAppCallRouter(this.a.get());
    }
}
