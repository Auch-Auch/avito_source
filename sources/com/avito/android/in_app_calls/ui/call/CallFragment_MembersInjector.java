package com.avito.android.in_app_calls.ui.call;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.in_app_calls.ui.AudioDeviceChooser;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CallFragment_MembersInjector implements MembersInjector<CallFragment> {
    public final Provider<CallPresenter> a;
    public final Provider<InAppCallsRouter> b;
    public final Provider<TimeSource> c;
    public final Provider<CallAudioManager> d;
    public final Provider<AudioDeviceChooser> e;
    public final Provider<ImplicitIntentFactory> f;
    public final Provider<Features> g;
    public final Provider<Analytics> h;
    public final Provider<ExposedAbTestGroup<CallsNewDesignTestGroup>> i;

    public CallFragment_MembersInjector(Provider<CallPresenter> provider, Provider<InAppCallsRouter> provider2, Provider<TimeSource> provider3, Provider<CallAudioManager> provider4, Provider<AudioDeviceChooser> provider5, Provider<ImplicitIntentFactory> provider6, Provider<Features> provider7, Provider<Analytics> provider8, Provider<ExposedAbTestGroup<CallsNewDesignTestGroup>> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MembersInjector<CallFragment> create(Provider<CallPresenter> provider, Provider<InAppCallsRouter> provider2, Provider<TimeSource> provider3, Provider<CallAudioManager> provider4, Provider<AudioDeviceChooser> provider5, Provider<ImplicitIntentFactory> provider6, Provider<Features> provider7, Provider<Analytics> provider8, Provider<ExposedAbTestGroup<CallsNewDesignTestGroup>> provider9) {
        return new CallFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.analytics")
    public static void injectAnalytics(CallFragment callFragment, Analytics analytics) {
        callFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.audioDeviceChooser")
    public static void injectAudioDeviceChooser(CallFragment callFragment, AudioDeviceChooser audioDeviceChooser) {
        callFragment.audioDeviceChooser = audioDeviceChooser;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.audioManager")
    public static void injectAudioManager(CallFragment callFragment, CallAudioManager callAudioManager) {
        callFragment.audioManager = callAudioManager;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.callPresenter")
    public static void injectCallPresenter(CallFragment callFragment, CallPresenter callPresenter) {
        callFragment.callPresenter = callPresenter;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.features")
    public static void injectFeatures(CallFragment callFragment, Features features) {
        callFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.intentFactory")
    public static void injectIntentFactory(CallFragment callFragment, ImplicitIntentFactory implicitIntentFactory) {
        callFragment.intentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.newDesignTestGroup")
    public static void injectNewDesignTestGroup(CallFragment callFragment, ExposedAbTestGroup<CallsNewDesignTestGroup> exposedAbTestGroup) {
        callFragment.newDesignTestGroup = exposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.router")
    public static void injectRouter(CallFragment callFragment, InAppCallsRouter inAppCallsRouter) {
        callFragment.router = inAppCallsRouter;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.call.CallFragment.timeSource")
    public static void injectTimeSource(CallFragment callFragment, TimeSource timeSource) {
        callFragment.timeSource = timeSource;
    }

    public void injectMembers(CallFragment callFragment) {
        injectCallPresenter(callFragment, this.a.get());
        injectRouter(callFragment, this.b.get());
        injectTimeSource(callFragment, this.c.get());
        injectAudioManager(callFragment, this.d.get());
        injectAudioDeviceChooser(callFragment, this.e.get());
        injectIntentFactory(callFragment, this.f.get());
        injectFeatures(callFragment, this.g.get());
        injectAnalytics(callFragment, this.h.get());
        injectNewDesignTestGroup(callFragment, this.i.get());
    }
}
