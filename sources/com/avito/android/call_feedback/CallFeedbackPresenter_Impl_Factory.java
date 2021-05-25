package com.avito.android.call_feedback;

import com.avito.android.call_feedback.CallFeedbackPresenter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackPresenter_Impl_Factory implements Factory<CallFeedbackPresenter.Impl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<CallFeedbackInteractor> b;
    public final Provider<Relay<String>> c;
    public final Provider<Kundle> d;
    public final Provider<SchedulersFactory> e;

    public CallFeedbackPresenter_Impl_Factory(Provider<AdapterPresenter> provider, Provider<CallFeedbackInteractor> provider2, Provider<Relay<String>> provider3, Provider<Kundle> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static CallFeedbackPresenter_Impl_Factory create(Provider<AdapterPresenter> provider, Provider<CallFeedbackInteractor> provider2, Provider<Relay<String>> provider3, Provider<Kundle> provider4, Provider<SchedulersFactory> provider5) {
        return new CallFeedbackPresenter_Impl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CallFeedbackPresenter.Impl newInstance(AdapterPresenter adapterPresenter, CallFeedbackInteractor callFeedbackInteractor, Relay<String> relay, Kundle kundle, SchedulersFactory schedulersFactory) {
        return new CallFeedbackPresenter.Impl(adapterPresenter, callFeedbackInteractor, relay, kundle, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallFeedbackPresenter.Impl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
