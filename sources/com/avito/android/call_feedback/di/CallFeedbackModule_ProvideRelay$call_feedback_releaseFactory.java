package com.avito.android.call_feedback.di;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CallFeedbackModule_ProvideRelay$call_feedback_releaseFactory implements Factory<Relay<String>> {

    public static final class a {
        public static final CallFeedbackModule_ProvideRelay$call_feedback_releaseFactory a = new CallFeedbackModule_ProvideRelay$call_feedback_releaseFactory();
    }

    public static CallFeedbackModule_ProvideRelay$call_feedback_releaseFactory create() {
        return a.a;
    }

    public static Relay<String> provideRelay$call_feedback_release() {
        return (Relay) Preconditions.checkNotNullFromProvides(CallFeedbackModule.provideRelay$call_feedback_release());
    }

    @Override // javax.inject.Provider
    public Relay<String> get() {
        return provideRelay$call_feedback_release();
    }
}
