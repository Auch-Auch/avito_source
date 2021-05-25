package com.avito.android.in_app_calls.service;

import com.avito.android.Features;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallManagerServiceDelegate_Factory implements Factory<CallManagerServiceDelegate> {
    public final Provider<CallManager> a;
    public final Provider<TimeSource> b;
    public final Provider<CallReconnectHandler> c;
    public final Provider<CallInfoSender> d;
    public final Provider<CallInfoLoader> e;
    public final Provider<CallAudioManager> f;
    public final Provider<CallEventTracker> g;
    public final Provider<Features> h;
    public final Provider<ErrorTracker> i;
    public final Provider<SchedulersFactory> j;

    public CallManagerServiceDelegate_Factory(Provider<CallManager> provider, Provider<TimeSource> provider2, Provider<CallReconnectHandler> provider3, Provider<CallInfoSender> provider4, Provider<CallInfoLoader> provider5, Provider<CallAudioManager> provider6, Provider<CallEventTracker> provider7, Provider<Features> provider8, Provider<ErrorTracker> provider9, Provider<SchedulersFactory> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static CallManagerServiceDelegate_Factory create(Provider<CallManager> provider, Provider<TimeSource> provider2, Provider<CallReconnectHandler> provider3, Provider<CallInfoSender> provider4, Provider<CallInfoLoader> provider5, Provider<CallAudioManager> provider6, Provider<CallEventTracker> provider7, Provider<Features> provider8, Provider<ErrorTracker> provider9, Provider<SchedulersFactory> provider10) {
        return new CallManagerServiceDelegate_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static CallManagerServiceDelegate newInstance(CallManager callManager, TimeSource timeSource, CallReconnectHandler callReconnectHandler, CallInfoSender callInfoSender, CallInfoLoader callInfoLoader, CallAudioManager callAudioManager, CallEventTracker callEventTracker, Features features, ErrorTracker errorTracker, SchedulersFactory schedulersFactory) {
        return new CallManagerServiceDelegate(callManager, timeSource, callReconnectHandler, callInfoSender, callInfoLoader, callAudioManager, callEventTracker, features, errorTracker, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallManagerServiceDelegate get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
