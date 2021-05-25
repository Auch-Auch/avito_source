package com.avito.android.call_feedback.di;

import com.avito.android.remote.CallFeedbackApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallFeedbackApiModule_ProvideCallFeedbackApiFactory implements Factory<CallFeedbackApi> {
    public final Provider<RetrofitFactory> a;

    public CallFeedbackApiModule_ProvideCallFeedbackApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static CallFeedbackApiModule_ProvideCallFeedbackApiFactory create(Provider<RetrofitFactory> provider) {
        return new CallFeedbackApiModule_ProvideCallFeedbackApiFactory(provider);
    }

    public static CallFeedbackApi provideCallFeedbackApi(RetrofitFactory retrofitFactory) {
        return (CallFeedbackApi) Preconditions.checkNotNullFromProvides(CallFeedbackApiModule.INSTANCE.provideCallFeedbackApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public CallFeedbackApi get() {
        return provideCallFeedbackApi(this.a.get());
    }
}
