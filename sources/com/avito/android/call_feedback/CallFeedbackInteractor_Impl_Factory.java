package com.avito.android.call_feedback;

import com.avito.android.call_feedback.CallFeedbackInteractor;
import com.avito.android.remote.CallFeedbackApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackInteractor_Impl_Factory implements Factory<CallFeedbackInteractor.Impl> {
    public final Provider<CallFeedbackApi> a;
    public final Provider<String> b;
    public final Provider<SchedulersFactory> c;

    public CallFeedbackInteractor_Impl_Factory(Provider<CallFeedbackApi> provider, Provider<String> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CallFeedbackInteractor_Impl_Factory create(Provider<CallFeedbackApi> provider, Provider<String> provider2, Provider<SchedulersFactory> provider3) {
        return new CallFeedbackInteractor_Impl_Factory(provider, provider2, provider3);
    }

    public static CallFeedbackInteractor.Impl newInstance(CallFeedbackApi callFeedbackApi, String str, SchedulersFactory schedulersFactory) {
        return new CallFeedbackInteractor.Impl(callFeedbackApi, str, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallFeedbackInteractor.Impl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
